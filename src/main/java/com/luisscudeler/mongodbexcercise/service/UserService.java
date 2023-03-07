package com.luisscudeler.mongodbexcercise.service;

import com.luisscudeler.mongodbexcercise.domain.User;
import com.luisscudeler.mongodbexcercise.dto.UserDTO;
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

    public User insert(User obj){
        return userRepository.insert(obj);
    }

    public void deleteById(String id){
        findById(id); //usar essa função apenas pra buscar pois caso nao exista ela ja irá lançar uma exception para nós.
        userRepository.deleteById(id);
    }
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
