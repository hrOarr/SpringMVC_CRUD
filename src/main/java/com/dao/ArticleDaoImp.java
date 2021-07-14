package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.model.Article;

@Repository
public class ArticleDaoImp implements ArticleDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertArticle(Article article) {
		String sql = "INSERT INTO articles (title, body, user_id) VALUES (?, ?, ?)";
		Object[] args = {article.getTitle(), article.getBody(), article.getUser_id()};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public List<Article> getArticleList() {
		String sql = "SELECT articles.id, articles.title, articles.body, users.name AS username FROM articles INNER JOIN users ON articles.user_id=users.id";
		return jdbcTemplate.query(sql, new ArticleMapper());
	}

	@Override
	public Article getArticle(int id) {
		String sql = "SELECT articles.id, articles.title, articles.body, users.name AS username FROM articles INNER JOIN users ON articles.user_id=users.id WHERE articles.id=?";
		Object[] args = {id};
		return jdbcTemplate.queryForObject(sql, new ArticleMapper(), args);
	}

	@Override
	public int updateArticle(Article article) {
		String sql = "UPDATE articles SET title=?, body=?, user_id=? WHERE id=?";
		Object[] args = {article.getTitle(), article.getBody(), article.getUser_id(), article.getId()};
		return jdbcTemplate.update(sql, args);
	}

}
