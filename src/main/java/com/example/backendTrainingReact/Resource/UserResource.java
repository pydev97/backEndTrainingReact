package com.example.backendTrainingReact.Resource;

import com.example.backendTrainingReact.Entity.User;
import com.example.backendTrainingReact.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/api") public class UserResource {

    @Autowired private UserService userService;

    @PostMapping(path = "/get-all-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping(path = "/get-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping(path = "/update-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateUserById(User user) {
        return ResponseEntity.ok(userService.updateUserBYId(user));
    }

    @PostMapping(path = "/update-user-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserById(Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(id);
    }
}
