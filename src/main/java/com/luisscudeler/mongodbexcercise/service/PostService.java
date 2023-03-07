package com.luisscudeler.mongodbexcercise.service;

import com.luisscudeler.mongodbexcercise.domain.Post;
import com.luisscudeler.mongodbexcercise.repository.PostRepository;
import com.luisscudeler.mongodbexcercise.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
