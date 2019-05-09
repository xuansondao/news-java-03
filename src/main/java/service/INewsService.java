package service;

import model.NewsModel;
import paging.PageAble;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface INewsService {
    void insertNews(HttpServletRequest request,NewsModel newsModel);

    List<NewsModel> findAll(PageAble pageAble);

    NewsModel findNewsById(long id);

    void updateNews(Long id, NewsModel updateNews);

    long countAllNews();
}
