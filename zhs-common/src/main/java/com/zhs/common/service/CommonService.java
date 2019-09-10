package com.zhs.common.service;

import com.zhs.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonService {

    @Autowired
    public PageHelperService pageHelperService;
    @Autowired
    public CommonUtils commonUtils;
}
