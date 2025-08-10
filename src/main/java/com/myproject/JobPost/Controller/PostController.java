package com.myproject.JobPost.Controller;

import com.myproject.JobPost.model.Post;
import com.myproject.JobPost.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {
    @Autowired
    PostService service;
    @GetMapping("/allPosts")
    public List<Post> getallpost(){
        return service.getallposts();
    }
    @PostMapping("/addPost")
    public Post addposts(@RequestBody Post post){
        return service.addpost(post);
    }
    @GetMapping("/SearchPost/{text}")
    public List<Post> searchpost(@PathVariable String text){
        return service.searchpost(text);
    }

}
