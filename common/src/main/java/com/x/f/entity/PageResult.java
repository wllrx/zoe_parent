package com.x.f.entity;

import java.util.List;
/**
 * 分页结果类
 *
 * @author zoe
 * @date 2019-01-03
 */
public class PageResult<T> {

    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
