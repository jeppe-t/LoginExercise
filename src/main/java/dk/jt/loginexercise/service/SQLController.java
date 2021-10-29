package dk.jt.loginexercise.service;

import dk.jt.loginexercise.DBManager.DBManager;
import dk.jt.loginexercise.model.User;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLController {

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean bol;
    private ArrayList<User> resultList = new ArrayList<>();
    private ArrayList<User> userList = getResults(scriptRecieve("select * from users"));



    //Receiving SQL query---------------------------------------------------------------------------------------------//

    public void scriptCommand(String sqlCommand) {
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(sqlCommand);
            bol = ps.execute();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    //Getting result from database------------------------------------------------------------------------------------//

    public ArrayList<User>getResults(ResultSet rs) {
        try {
            resultList.clear();
            while (rs.next()) {
                resultList.add(new User(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultList;
    }

    //Getting result from database------------------------------------------------------------------------------------//

    public ResultSet scriptRecieve(String sqlCommand) {
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(sqlCommand);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;

    }

    //Database insert and receive-------------------------------------------------------------------------------------//

    public String createUserRequest(User user){
        scriptCommand("insert into users(first_name, last_name, adress, phone, username, password ) " +
                "values(" + "\"" + user.getFirst_name() + "\", \"" + user.getLast_name()+ "\", \"" + user.getAdress()+
                "\", \"" + user.getPhone() + "\", \"" + user.getUserName() +  "\", \"" + user.getPassword() + "\")");

        userList = getResults(scriptRecieve("select * from users"));

        return "register_success";

    }

    public ArrayList<User> getUserList() {
        return userList;
    }



}
