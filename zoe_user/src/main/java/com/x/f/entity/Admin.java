package com.x.f.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zoe
 * @date 2019-01-14
 */
@Data
@Entity
@Table(name = "tb_admin")
public class Admin implements Serializable {

    @Id
    private String id;//ID
    private String loginname;//登陆名
    private String password;//密码
    private String state;//状态
}
