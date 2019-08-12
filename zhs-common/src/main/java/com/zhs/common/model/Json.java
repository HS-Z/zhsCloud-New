package com.zhs.common.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Json implements Serializable {

    private Boolean success = false;

    private String msg = "";

    private Object obj = null;

    private Map<String, Object> others;


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Map<String, Object> getOthers() {
        return others;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }



    public Json addOthers(String key, Object other) {
        if (this.others == null){
            this.others = new HashMap<>();
        }
        this.others.put(key, other);
        return this;
    }


    public Json addObj(Object obj) {
        this.obj = obj;
        return this;
    }


    public static Json ok() {
        Json json = new Json();
        json.setSuccess(true);
        return json;
    }

    public static Json ok(String msg) {
        Json json = new Json();
        json.setSuccess(true);
        json.setMsg(msg);
        return json;
    }

    public static Json ok(String msg, Object obj) {
        Json json = new Json();
        json.setSuccess(true);
        json.setMsg(msg);
        json.setObj(obj);
        return json;
    }

    public static Json fail() {
        Json json = new Json();
        json.setSuccess(false);
        return json;
    }

    public static Json fail(String msg) {
        Json json = new Json();
        json.setSuccess(false);
        json.setMsg(msg);
        return json;
    }

}
