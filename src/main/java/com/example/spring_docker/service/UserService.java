package com.example.spring_docker.service;

import com.example.spring_docker.model.User;
import com.example.spring_docker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User create (User user) {
        return repository.save(user);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User user){
        User existing = findById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return repository.save(existing);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}