package com.iorta.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iorta.sboot.dto.PixabaySearchDto;
import com.iorta.sboot.service.RestTemplateService;

@Controller
@RequestMapping("/api")
public class RestTemplateWebController {
	
	@Autowired
	RestTemplateService restTemplateService;
	
	
	@GetMapping("/nasa/picOfDay")
	public String nasaPicOfDayNavigation(Model model) {
		model.addAttribute("imageUrl", restTemplateService.getAstronomyPictureOfTheDay());
		return "picOfDay";
	}
	
	
	@GetMapping("/pixabay/images")
	public String getPixabayImages(Model model) {
		model.addAttribute("pixabaySearch", new PixabaySearchDto()); 
		model.addAttribute("imageUrl", "http://localhost:1900/images/dummy-image.png");
		return "pixabayPic";
	}
	
	@PostMapping("/pixabayImageSearch")
	public String getPixabayImages(@ModelAttribute PixabaySearchDto pixabaySearch, Model model) {
		String image = restTemplateService.getPixabayImages(pixabaySearch);
		
		if (image == null || image.isEmpty()) {
			image = "http://localhost:1900/images/dummy-image.png";
		}
		
		model.addAttribute("imageUrl", restTemplateService.getPixabayImages(pixabaySearch));
		model.addAttribute("pixabaySearch", pixabaySearch);
		return "pixabayPic";
	}

}
