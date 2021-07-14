package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Article;
import com.model.User;
import com.service.ArticleService;
import com.service.UserService;
import com.validation.ArticleValidation;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	private ArticleService articleService;
	private UserService userService;
	
	@Autowired
	public ArticleController(ArticleService articleService, UserService userService) {
		this.articleService = articleService;
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String allArticles(Model model) {
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles", articles);
		return "articles/article_list";
	}
	
	@GetMapping("/{id}")
	public String showArticle(@PathVariable("id") int id, Model model) {
		System.out.println("Begin......");
		try {
			Article article = articleService.getArticle(id);
			model.addAttribute("article", article);
			return "articles/show_article";
		} catch (Exception e) {
			model.addAttribute("msg", "Resource Not Found");
			return "error";
		}
	}
	
	@GetMapping("/add")
	public String addArticle(Model model) {
		model.addAttribute("type", "add");
//		model.addAttribute("article", new Article());
		return "articles/show_form";
	}
	
	@ModelAttribute("article")
	public Article getArticle() {
		return new Article();
	}
	
	@ModelAttribute("users")
	public List<User> getUsers(){
		return userService.allUsers();
	}
	
	@PostMapping("/add")
	public String addArticle(@ModelAttribute("article") Article article, BindingResult result, Model model) {
		ArticleValidation articleValidation = new ArticleValidation();
		boolean error = articleValidation.validation(article, model);
		if(error) {
			model.addAttribute("type", "add");
			return "articles/show_form";
		}
		articleService.insertArticle(article);
		return "redirect:/articles/";
	}
	
	@GetMapping("/edit/{id}")
	public String editArticle(@PathVariable("id") int id, Model model) {
		try {
			Article article = articleService.getArticle(id);
			model.addAttribute("article", article);
			model.addAttribute("type", "edit");
			return "articles/show_form";
		} catch (Exception e) {
			model.addAttribute("msg", "Unauthorized...");
			return "error";
		}
	}
	
	@PostMapping("/edit")
	public String editArticle(@ModelAttribute("article") Article article, BindingResult result, Model model) {
		ArticleValidation articleValidation = new ArticleValidation();
		boolean error = articleValidation.validation(article, model);
		if(error) {
			model.addAttribute("type", "edit");
			return "articles/show_form";
		}
		articleService.updateArticle(article);
		return "redirect:/articles/";
	}
}
