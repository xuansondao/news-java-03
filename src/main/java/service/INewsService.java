package service;

import model.NewsModel;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface INewsService {
    void insertNews(HttpServletRequest request,NewsModel newsModel);

    List<NewsModel> findAll();
}
