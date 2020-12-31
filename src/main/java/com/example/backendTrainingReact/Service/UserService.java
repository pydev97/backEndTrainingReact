package com.example.backendTrainingReact.Service;

import com.example.backendTrainingReact.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public User getUserById(Integer id);

    public Integer updateUserBYId(User user);

    public void deleteUserById(Integer id);
}
