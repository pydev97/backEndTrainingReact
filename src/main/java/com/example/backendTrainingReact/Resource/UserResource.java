package com.example.backendTrainingReact.Resource;

import com.example.backendTrainingReact.Entity.User;
import com.example.backendTrainingReact.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/get-all-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/get-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@RequestBody Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/update-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateUserById(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateUserBYId(user));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/delete-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserById(@RequestBody Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/create-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer createUser(@RequestBody User user) {
        System.out.println(user.getEmail());
        return  userService.createUser(user);
    }
}
