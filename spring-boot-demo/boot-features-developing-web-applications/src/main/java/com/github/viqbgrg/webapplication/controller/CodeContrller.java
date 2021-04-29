package com.github.viqbgrg.webapplication.controller;

import com.github.viqbgrg.webapplication.vo.UserVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hhj
 */
@RestController
@RequestMapping("code")
public class CodeContrller {
    @GetMapping("")
    public String zw() {
        return "我是中文";
    }

    @GetMapping("json")
    public UserVo json() {
        return new UserVo("小明", 17);
    }


}
