package com.example.backendTrainingReact.Service.Impl;

import com.example.backendTrainingReact.Entity.User;
import com.example.backendTrainingReact.Repository.UserRepository;
import com.example.backendTrainingReact.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public Integer updateUserBYId(User user) {
        // get old data
        User oldUser = getUserById(user.getUserId());
        User newUser = new User();
        newUser.setAddress(user.getAddress());
        newUser.setEmail(user.getEmail());
        newUser.setFullName(user.getFullName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUserName(user.getUserName());
        return userRepository.save(newUser).getUserId();
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Integer createUser(User user) {
        return userRepository.save(user).getUserId();
    }
}
