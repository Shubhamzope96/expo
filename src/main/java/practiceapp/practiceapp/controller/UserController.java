package practiceapp.practiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import practiceapp.practiceapp.model.User;
import practiceapp.practiceapp.service.SMSService;
import practiceapp.practiceapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder pe;
    @PostMapping("/add")
    public User addNewUser(@RequestBody User user){
        return userService.addNewUser(user);
    }

        @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getUserList(){
        sendOtp();
        return ResponseEntity.ok(userService.getUserList());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name="id") Long userId){
        return ResponseEntity.ok(userService.deleteUser(userId));
    }


    @GetMapping("/check")
    public ResponseEntity<String> userType(){
        System.out.println(pe.encode("user123"));
        return ResponseEntity.ok("yes I am valid user");
    }

    @GetMapping("/get/username/{username}")
    public ResponseEntity <List<User>> searchUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok( userService.searchUserByUsername(username));
    }


    @Autowired
    SMSService smsService;

   @PostMapping("/sms")
    public void sendOtp(){
        smsService.sendOtp();
    }

}
