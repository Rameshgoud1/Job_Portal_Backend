package com.myproject.JobPost.Repository;

import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.myproject.JobPost.model.Post;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SearchImplementation implements SearchRepo{
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MappingMongoConverter converter;
    @Override
    public ArrayList searchpost(String text) {
        ArrayList posts=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("MyData");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                                new Document("text",
                                new Document("query",text).append("path", Arrays.asList("profile", "desc", "techs")))),
                                new Document("$sort", new Document("exp", 1L)),
                                new Document("$limit", 5L)));
        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));
        return posts;
    }
}
