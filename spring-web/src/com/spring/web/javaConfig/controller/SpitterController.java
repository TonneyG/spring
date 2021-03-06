package com.spring.web.javaConfig.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.javaConfig.dao.SpittleRepository;
import com.spring.web.javaConfig.pojo.Spitter;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	private SpittleRepository spittleRepository;
	
	@Autowired
	public SpitterController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@RequestParam("file")MultipartFile image,@Valid Spitter spitter, Errors errors,RedirectAttributes model){
		if(errors.hasErrors()){
			return "registerForm";
		}
		spittleRepository.save(spitter);
		//将Spitter对象添加到模型中,RedirectAttributes是Model的一个子接口
		model.addFlashAttribute("spitter",spitter);
		return "redirect:/spitter/"+spitter.getUserName();
	}
	
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable String userName,Model model){
		if(!model.containsAttribute("spitter")){
			Spitter spitter = spittleRepository.findByUserName(userName);
			model.addAttribute(spitter);
		}
		return "profile";
	}
}
