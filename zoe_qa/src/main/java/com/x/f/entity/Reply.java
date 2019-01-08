package com.x.f.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zoe
 * @date 2019-01-08
 */
@Entity
@Table(name="tb_reply")
@Data
public class Reply implements Serializable {

    @Id
    private String id;//编号
    private String problemid;//问题ID
    private String content;//回答内容
    private java.util.Date createtime;//创建日期
    private java.util.Date updatetime;//更新日期
    private String userid;//回答人ID
    private String nickname;//回答人昵称
}
