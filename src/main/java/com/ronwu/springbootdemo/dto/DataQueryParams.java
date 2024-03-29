package com.ronwu.springbootdemo.dto;

import com.ronwu.springbootdemo.constant.DataCategory;

public class DataQueryParams {
    private DataCategory category;
    private String search;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;

    public DataCategory getCategory() {
        return category;
    }

    public void setCategory(DataCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
