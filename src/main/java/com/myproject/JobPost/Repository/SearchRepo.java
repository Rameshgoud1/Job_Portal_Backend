package com.myproject.JobPost.Repository;

import com.myproject.JobPost.model.Post;

import java.util.List;

public interface SearchRepo {
    List<Post> searchpost(String text);
}
