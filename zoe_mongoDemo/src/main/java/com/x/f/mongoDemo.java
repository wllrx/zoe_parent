package com.x.f;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zoe
 * @date 2019-01-09
 */
public class mongoDemo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1");//创建连接
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");//打开数据库
        MongoCollection<Document> spit = spitdb.getCollection("spit");//获取集合
        // FindIterable<Document> documents = spit.find();//查询记录获取文档集合
        /**
         * BasicDBObject 对象: 表示一个具体的记录,BasicDBObject实现了DBObject,是key-value的数据结构
         * 用起来跟HashMap基本一致
         */
        //BasicDBObject basicDBObject = new BasicDBObject("userid","1013");//构建查询条件 查询userid是1013的记录
        //FindIterable<Document> documents = spit.find(basicDBObject);//查询记录获取文档集合

       /* BasicDBObject basicDBObject = new BasicDBObject("visits",new BasicDBObject("$gt",1000));//构建查询条件 查询浏览量visits大于1000的记录
        FindIterable<Document> documents = spit.find(basicDBObject);//查询记录获取文档集合
        for (Document document:documents){
            System.out.println("内容:"+document.getString("content"));
            System.out.println("用户id:"+document.getString("userid"));
            System.out.println("浏览量:"+document.getInteger("visits"));
        }*/
        /**
         * 插入数据
         */
        Map<String,Object> map = new HashMap<>();
        map.put("content","我要吐槽");
        map.put("userid","9999");
        map.put("visits","123");
        map.put("publishtime",new Date());
        Document document = new Document(map);
        spit.insertOne(document);
        mongoClient.close();//关闭连接
    }
}

