package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ArticleDao;
import com.model.Article;

@Service
public class ArticleServiceImp implements ArticleService {
	
	private ArticleDao articleDao;
	
	@Autowired
	public ArticleServiceImp(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDao.insertArticle(article);
	}

	@Override
	public List<Article> getArticleList() {
		return articleDao.getArticleList();
	}

	@Override
	public Article getArticle(int id) {
		return articleDao.getArticle(id);
	}

	@Override
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

}
