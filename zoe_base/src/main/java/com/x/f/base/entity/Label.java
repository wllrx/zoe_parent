package com.x.f.base.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zoe
 * @date 2019-01-04
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label {

    @Id
    private String id;
    private String lablename;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐

}
