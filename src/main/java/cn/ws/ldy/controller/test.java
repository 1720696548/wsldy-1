package cn.ws.ldy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
	
	@RequestMapping("/test")
	public String test(Integer type) {
		if(type == 1) {
			return "小伙子你好";
		}else if(type == 2) {
			return "骚年你好";
		}else if(type == 3) {
			return "大叔你好";
		}else if(type == 4) {
			return "大页你好";
		}else if(type == 5) {
			return "美女你好";
		}else if(type == 6) {
			return "我一点也不好";
		}
		return "陈意忠妳好呀，我们一起捉泥鳅！！！";
	}

}
