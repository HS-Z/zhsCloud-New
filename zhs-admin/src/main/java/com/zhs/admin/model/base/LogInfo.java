package com.zhs.admin.model.base;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class LogInfo implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)    //使用JDBC 的方式获取数据库自增的主键值
    private Long id;

    private String creator;    //操作人

    private Date createDate;    //操作时间

    private String description;    //描述

    private String logType;  //日志类型，对应枚举类 LogTypeEnum

    private String logOperateType;   //操作类型，对应枚举类 LogOperateTypeEnum

    private String state;   //操作状态（成功或失败）

    private String oldInfo;   //操作前信息

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogOperateType() {
        return logOperateType;
    }

    public void setLogOperateType(String logOperateType) {
        this.logOperateType = logOperateType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOldInfo() {
        return oldInfo;
    }

    public void setOldInfo(String oldInfo) {
        this.oldInfo = oldInfo;
    }
}
