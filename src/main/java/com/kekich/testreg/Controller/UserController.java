package com.kekich.testreg.Controller;

import com.kekich.testreg.model.User;
import com.kekich.testreg.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/main")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }




    @PostMapping("/addUser")
    public User add(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/loginUser")
    public User loginUser(@RequestBody User user, HttpSession session) {
        User loggedIn = userService.login(user.getLogin(), user.getPassword());
        session.setAttribute("user", loggedIn);
        return loggedIn;
    }


}
