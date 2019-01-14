package com.x.f.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @author zoe
 * @date 2019-01-10
 */
@Document(indexName = "",type = "article")
@Data
public class Article implements Serializable {

    @Id
    private String id;//id

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;//标题

    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content; //正文

    private String state;//审核状态
}
