package com.zhs.common.model;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhang on 2019/8/9.
 */
public class CommonModel implements Serializable {


    /**
     * 使用JDBC 的方式获取数据库自增的主键值
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 最后编辑人
     */
    private String lastEditor;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最近更新时间
     */
    private Date lastEditDate;

    /**
     * 删除标记，默认为否
     */
    private Boolean deleted = Boolean.FALSE;

    /**
     * 描述
     */
    private String description;


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

    public String getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(String lastEditor) {
        this.lastEditor = lastEditor;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
