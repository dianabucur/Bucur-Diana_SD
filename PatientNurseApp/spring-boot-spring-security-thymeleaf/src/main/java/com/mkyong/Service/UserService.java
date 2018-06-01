package com.mkyong.Service;

import com.mkyong.Models.Patient;
import com.mkyong.Models.User;
import com.mkyong.Repository.PatientRepository;
import com.mkyong.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void insert(User user){
        User user2 = new User(user.getUsername(), user.getPassword(), "patient");
        userRepository.save(user2);
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
