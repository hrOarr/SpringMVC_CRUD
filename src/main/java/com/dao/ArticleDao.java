package com.dao;

import java.util.List;

import com.model.Article;

public interface ArticleDao {
	public int insertArticle(Article article);
	public Article getArticle(int id);
	public List<Article> getArticleList();
}