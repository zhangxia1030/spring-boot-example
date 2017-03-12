package com.zx.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zx.entity.User;

@Controller
public class FreemarkerController {
	@RequestMapping("/testFtl_el")
	public String testFtl_el(Model map) {
		// 获取@ControllerAdvice的@ModelAttribute值
		System.out.println(map.asMap().get("msg"));

		map.addAttribute("name", "张三");
		map.addAttribute("age", "20");
		return "el";
	}

	@RequestMapping("/testFtl_if")
	public String testFtl_if(Model map) {
		map.addAttribute("name", "张三");
		map.addAttribute("age", "20");
		return "freeIf";
	}

	@RequestMapping("/testFtl_list")
	public String testFtl_list(Model map) {
		List<User> list = new ArrayList<User>();
		User u = new User(10, "zx", "hadoop");
		User u1 = new User(10, "zx", "spark");
		User u2 = new User(10, "zx", "spring cloud");
		User u3 = new User(10, "zx", "mq");

		list.add(u);
		list.add(u1);
		list.add(u2);
		list.add(u3);

		map.addAttribute("data", list);
		return "freeList";
	}

	@RequestMapping("/testError")
	public String testError(Model map) {
		// 获取@ControllerAdvice的@ModelAttribute值
		System.out.println(map.asMap().get("msg"));

		map.addAttribute("name", "张三");
		map.addAttribute("age", "20");
		String name = null;

		// 抛出空指针异常
		name.charAt(10);

		return "el";
	}
}
