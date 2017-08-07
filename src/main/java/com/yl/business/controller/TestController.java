package com.yl.business.controller;

import com.alibaba.fastjson.JSON;
import com.yl.business.test.bo.UserBo;
import com.yl.business.test.domain.TestDomain;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaoliao on 2017/7/25.
 */
@RestController
@RequestMapping("/test/controller/")
public class TestController {

    @Resource
    private TestDomain testDomain;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(Integer ID) {
        UserBo bo = testDomain.get(ID);
        return JSON.toJSONString(bo);
    }

    public static void main(String[] args) {

        // asList 返回一个内部类ArrayList，这个ArrayList是定长的，也没有add方法
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.add(5);
        System.out.println(list.toString());
    }

}
