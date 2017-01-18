package com.roobo.demo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NOTE-026 on 2017/1/12/0012.
 */
public class MongoDBJDBC {
    private static final MongoClient mongoClient = new MongoClient( "172.16.101.12" , 27017 );
    private static final MongoDatabase mongoDatabase = mongoClient.getDatabase("hj_ecp");
    public static MongoDatabase init(){
        if(mongoDatabase == null){
            return  mongoClient.getDatabase("hj_ecp");
        }
        return mongoDatabase;
    }

    public static void CreateCollection(String collectionName){
        mongoDatabase.createCollection(collectionName);
    }

    public static MongoCollection<Document> getCollection(String collectionName){
        return mongoDatabase.getCollection(collectionName);
    }

    /**
     * 1. 创建文档 org.bson.Document 参数为key-value的格式
     * 2. 创建文档集合List<Document>
     * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
     * */
    public static void addDoc(Document document,String collectionName){
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        getCollection(collectionName).insertMany(documents);
        System.out.println("文档插入成功");
    }
}
