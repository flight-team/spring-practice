package springstudy.springstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springstudy.springstudy.service.UserService;
import springstudy.springstudy.user.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUserLists(){
        return userService.getUsers();


    }

    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable("id") Integer id){
        return userService.getUserByUserId(id);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user){
        System.out.println(user);
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Integer id,
                           @RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
