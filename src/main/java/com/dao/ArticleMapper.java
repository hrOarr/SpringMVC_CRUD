package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Article;

public class ArticleMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setTitle(rs.getString("title"));
		article.setBody(rs.getString("body"));
		article.setUsername(rs.getString("username"));
		return article;
	}
	
}
