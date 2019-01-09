package com.x.f.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 文章评论
 * @author zoe
 * @date 2019-01-09
 */
@Data
public class Comment implements Serializable {

    @Id
    private String _id;

    private String articleid;

    private String content;

    private String userid;

    private String parentid;

    private Date publishdate;

}
