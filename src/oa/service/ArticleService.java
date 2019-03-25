package oa.service;

import java.util.List;

import oa.domain.Article;

public interface ArticleService {

	 /*
     * �ýӿڸ����Article������ɾ�Ĳ飬�ṩ����
     */
    Article findOne(Long id);
    long count();
    int delete(Long id);
    //save��������insert��update
    int save(Article article);
    List<Article> findAll();

}

