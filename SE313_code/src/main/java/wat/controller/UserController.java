package wat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wat.entity.User;
import wat.service.UserService;

/**
 * Created by P-OniSawa on 14/5/2558.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public @ResponseBody
    User add(@RequestBody User user, BindingResult bindingResult){
        return userService.addUser(user);
    }
}
