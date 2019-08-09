package com.zhs.common.model;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhang on 2019/8/9.
 */
public class CommonModel implements Serializable{


    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String creator;    //创建人

    private String lastEditor;    //最后编辑人

    private Date createDate;    //创建时间

    private Date lastEditDate;    //最后编辑时间

    private Boolean deleted = Boolean.FALSE;    //删除标记，默认为否



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

}
