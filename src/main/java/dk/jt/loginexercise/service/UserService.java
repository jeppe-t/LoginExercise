package dk.jt.loginexercise.service;

import dk.jt.loginexercise.model.User;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;



public class UserService {

    SQLController sqlController = new SQLController();

    //Create user objects in java-------------------------------------------------------------------------------------//

    public String createUser(WebRequest request){

        User user = new User(request.getParameter("first_name"),request.getParameter("last_name"),
                request.getParameter( "adress"), request.getParameter("phone"),
                request.getParameter("username"), request.getParameter("password"));

        return sqlController.createUserRequest(user);

    }

    //Scope method for user login-------------------------------------------------------------------------------------//


    public String validateLogin(User user, WebRequest request, HttpSession session){
        for (int i = 0; i < sqlController.getUserList().size(); i++) {
            if(sqlController.getUserList().get(i).getUserName().equals(user.getUserName()) &&
                    sqlController.getUserList().get(i).getPassword().equals(user.getPassword()) ){

                if(session.getAttribute("uname") ==null){
                    request.setAttribute("uname", user, WebRequest.SCOPE_SESSION);

                }

                return "login_success";
            }
        }

        return "login_failed";
    }



}
