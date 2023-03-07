package com.luisscudeler.mongodbexcercise.repository;

import com.luisscudeler.mongodbexcercise.domain.Post;
import com.luisscudeler.mongodbexcercise.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
