package com.myproject.JobPost.Repository;

import com.myproject.JobPost.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepo {
    List<Post> searchpost(String text);
}
