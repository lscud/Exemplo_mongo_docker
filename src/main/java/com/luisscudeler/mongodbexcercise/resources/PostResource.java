package com.luisscudeler.mongodbexcercise.resources;

import com.luisscudeler.mongodbexcercise.domain.Post;
import com.luisscudeler.mongodbexcercise.domain.User;
import com.luisscudeler.mongodbexcercise.dto.UserDTO;
import com.luisscudeler.mongodbexcercise.resources.util.URL;
import com.luisscudeler.mongodbexcercise.service.PostService;
import com.luisscudeler.mongodbexcercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.awt.SystemColor.text;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value="text", defaultValue = "") String text,
                                                 @RequestParam(value="minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value="maxDate", defaultValue = "") String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }



}
