package com.zhs.common.model;

import java.util.List;

public class ResponsePageInfo {

    private String code;    //查询返回状态码

    private String msg;    //消息

    private Long count;    //总记录数

    private Object footer;  //页脚信息

    private List<Object> data;  //当前页的记录集合

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
