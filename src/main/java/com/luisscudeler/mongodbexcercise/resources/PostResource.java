package com.luisscudeler.mongodbexcercise.resources;

import com.luisscudeler.mongodbexcercise.domain.Post;
import com.luisscudeler.mongodbexcercise.domain.User;
import com.luisscudeler.mongodbexcercise.dto.UserDTO;
import com.luisscudeler.mongodbexcercise.service.PostService;
import com.luisscudeler.mongodbexcercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable("id") String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
