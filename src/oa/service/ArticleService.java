package oa.service;

import java.util.List;

import oa.domain.Article;

public interface ArticleService {

	 /*
     * 该接口负责对Article进行增删改查，提供服务
     */
    Article findOne(Long id);
    long count();
    int delete(Long id);
    //save方法包含insert和update
    int save(Article article);
    List<Article> findAll();

}

