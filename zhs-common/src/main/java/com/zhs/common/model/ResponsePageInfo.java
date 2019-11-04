package com.zhs.common.model;

import java.util.List;

public class ResponsePageInfo {

    /**
     * 查询返回状态码
     */
    private String code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 总记录数
     */
    private Long count;

    /**
     * 页脚信息
     */
    private Object footer;

    /**
     * 当前页的记录集合
     */
    private List<Object> data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getFooter() {
        return footer;
    }

    public void setFooter(Object footer) {
        this.footer = footer;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }


}
