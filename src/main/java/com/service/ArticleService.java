package com.service;

import java.util.List;

import com.model.Article;

public interface ArticleService {
	public int insertArticle(Article article);
	public Article getArticle(int id);
	public List<Article> getArticleList();
	public int updateArticle(Article article);
}
