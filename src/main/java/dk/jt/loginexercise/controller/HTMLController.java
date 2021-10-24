package dk.jt.loginexercise.controller;

import dk.jt.loginexercise.model.User;
import dk.jt.loginexercise.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HTMLController {

    private UserService userService = new UserService();


    //Login formulars-------------------------------------------------------------------------------------------------//

    @GetMapping("/")
    public String showlogForm(){

        return "login";
    }


    @PostMapping("/login")
    public String submitForm(WebRequest request, HttpSession session){

        User user = new User(request.getParameter("username"), request.getParameter("password"));

        return userService.validateLogin(user, request, session);
    }


    //Register formulars----------------------------------------------------------------------------------------------//


    @GetMapping("/register")
    public String register(){

        return "register";

    }

    @PostMapping("/registervalidate")
    public String validateRegistration(WebRequest request) {
        //Creates user object in java

        return userService.createUser(request);


    }

    //Secret page-----------------------------------------------------------------------------------------------------//


    @GetMapping("/secret")
    public String showSecret(){

        return "secret";
    }

}