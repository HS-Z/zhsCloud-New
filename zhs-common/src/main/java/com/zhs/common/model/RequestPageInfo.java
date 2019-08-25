package com.zhs.common.model;

public class RequestPageInfo {

    private int page;    //当前页

    private int limit;    //每页查询数据量

    private String sort = "desc";    //排序的方式

    private String sortField;    //排序的属性

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

}
