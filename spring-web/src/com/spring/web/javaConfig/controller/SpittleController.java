package com.spring.web.javaConfig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.javaConfig.dao.SpittleRepository;
import com.spring.web.javaConfig.pojo.Spittle;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	private SpittleRepository spitterRepository;

	@Autowired
	public SpittleController(SpittleRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
	//方法一
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(@RequestParam("max") long max,@RequestParam(value="count",defaultValue="20") int count,Model model){
		model.addAttribute(spitterRepository.findSpittles(Long.MAX_VALUE, 20));
		//等同
		//model.addAttribute("spittleList",spitterRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
	
	//方法二，根据请求url:/spittles自动解析出返回的逻辑视图名为“spittles”
	/*@RequestMapping(method=RequestMethod.GET)
	public List<Spittle> spittles(Model model){
		return spitterRepository.findSpittles(Long.MAX_VALUE, 20);
	}*/
	
}
	