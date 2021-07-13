package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Article;
import com.model.User;
import com.service.ArticleService;
import com.service.UserService;

@Controller
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	@Qualifier(value = "articleServiceImp")
	private ArticleService articleService;
	
	@Autowired
	@Qualifier(value = "userServiceImp")
	private UserService userService;
	
	@RequestMapping("/")
	public String allArticles(Model model) {
		List<Article> articles = articleService.getArticleList();
		model.addAttribute("articles", articles);
		return "articles/article_list";
	}
	
	@RequestMapping("/{id}")
	public String showArticle(@PathVariable("id") int id, Model model) {
		Article article = articleService.getArticle(id);
		model.addAttribute("article", article);
		return "articles/show_article";
	}
	
	@RequestMapping("/new")
	public String newArticle(Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "articles/show_form";
	}
	
	@PostMapping("/add")
	public String addArticle(@RequestParam("title") String title, @RequestParam("body") String body, @RequestParam("user_id") String user_id, Model model) {
		int user = Integer.parseInt(user_id);
		articleService.insertArticle(new Article(title, body, user));
		return "redirect:/";
	}
}
