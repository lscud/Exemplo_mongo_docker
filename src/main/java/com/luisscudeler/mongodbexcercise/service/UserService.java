package com.luisscudeler.mongodbexcercise.service;

import com.luisscudeler.mongodbexcercise.domain.User;
import com.luisscudeler.mongodbexcercise.repository.UserRepository;
import com.luisscudeler.mongodbexcercise.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

    }
}
