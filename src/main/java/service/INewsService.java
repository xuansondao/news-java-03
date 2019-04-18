package service;

import model.NewsModel;

import javax.servlet.http.HttpServletRequest;

public interface INewsService {
    void insertNews(HttpServletRequest request,NewsModel newsModel);
}
