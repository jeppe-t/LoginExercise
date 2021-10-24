package dk.jt.loginexercise.model;

public class User {

    private String userName;
    private String password;

    private String first_name;
    private String last_name;
    private String adress;
    private String phone;

    public User(String first_name, String last_name, String adress, String phone, String userName, String password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.adress = adress;
        this.phone = phone;
        this.userName = userName;
        this.password = password;

    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;

    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User" +
                "\nFirst_name:" + first_name +
                "\nLast name: " + last_name +
                "\nAdress: " + adress +
                "\nPhone: " + phone +
                "\nUsername: " + userName +
                "\nPassword: " + password;
    }
}
