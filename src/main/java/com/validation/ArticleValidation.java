package com.validation;

import org.springframework.ui.Model;

import com.model.Article;

public class ArticleValidation {
	public boolean validation(Article article, Model model) {
		String title = article.getTitle();
		String body = article.getBody();
		int user_id = article.getUser_id();
		boolean error = false;
		
		if(user_id==0) {
			error = true;
			model.addAttribute("user_id_error", "No user selected");
		}
		
		if(title.length()<5) {
			error = true;
			model.addAttribute("title_error", "Title is too small");
		}
		else if(title.length()>55) {
			error = true;
			model.addAttribute("title_error", "Title is too long");
		}
		
		if(body.length()<10) {
			error = true;
			model.addAttribute("body_error", "body is too small");
		}
		else if(body.length()>6000) {
			error = true;
			model.addAttribute("body_error", "body is too long");
		}
		
		return error;
	}
}
