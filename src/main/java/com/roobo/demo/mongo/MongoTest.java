package com.roobo.demo.mongo;

import org.bson.Document;

/**
 * Created by NOTE-026 on 2017/1/12/0012.
 */
public class MongoTest {
    public static void main(String[] args) {
        Document document = new Document("title", "MongoDB").
        append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        MongoDBJDBC.addDoc(document,"test");
    }
}
