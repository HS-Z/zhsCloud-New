package com.zhs.common.model;

public class RequestPageInfo {

    /**
     * 当前页
     */
    private int page;

    /**
     * 每页显示的数量
     */
    private int limit;

    /**
     * 排序的方式
     */
    private String sort = "desc";

    /**
     * 排序的属性
     */
    private String sortField;

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
