package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Article;
import com.service.ArticleService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier(value = "articleServiceImp")
	private ArticleService articleService;
	
	@RequestMapping("/")
	public String getHome(Model model) {
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles", articles);
		return "home";
	}
}
