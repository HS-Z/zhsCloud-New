package com.zhs.common.service;


import com.github.pagehelper.Page;
import com.zhs.common.model.ResponsePageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Mybatis的分页
 */
@Service
public class PageHelperService {


    /**
     * 返回结果的分页处理
     * @param page
     * @return
     */
    public ResponsePageInfo pageHelper(Page page, List dataList){

        ResponsePageInfo responsePageInfo = new ResponsePageInfo();
        responsePageInfo.setCode("0");
        responsePageInfo.setMsg("");

        if (page.size() < 0){
            throw new RuntimeException("数据分页错误");
        }

        int pageNum = page.getPageNum();  //当前属于哪一页
        int pageSize = page.getPageSize();  //当前页面记录数
        long total = page.getTotal();   //总记录数
        int pages = page.getPages();  //总页数

        responsePageInfo.setCount(total);
        responsePageInfo.setData(dataList);

        return responsePageInfo;
    }



}
