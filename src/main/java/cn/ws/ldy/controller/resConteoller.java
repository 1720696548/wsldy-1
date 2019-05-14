package cn.ws.ldy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 * @create: 2019-05-14 23:28
 */
@Controller
public class resConteoller {

    @RequestMapping("/index")
    public String index(){
        return  "views/index";
    }
}
