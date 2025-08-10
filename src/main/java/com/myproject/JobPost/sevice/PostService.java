package com.myproject.JobPost.sevice;

import com.myproject.JobPost.Repository.PostRepo;
import com.myproject.JobPost.Repository.SearchRepo;
import com.myproject.JobPost.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class PostService {
    @Autowired
    PostRepo repo;
    @Autowired
    SearchRepo searchrepo;
    public List<Post> getallposts() {
        System.out.println(repo.findAll());
        return repo.findAll();
    }

    public Post addpost(Post post) {
        return repo.save(post);
    }

    public List<Post> searchpost(String text) {
         return searchrepo.searchpost(text);
    }
}
