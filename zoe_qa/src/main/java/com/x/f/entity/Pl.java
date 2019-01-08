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
@Table(name = "tb_pl")
@Data
public class Pl implements Serializable {
    @Id
    private String problemid;
    @Id
    private String lableid;
}
