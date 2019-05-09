package service.impl;

import dao.IGenericDAO;
import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.NewsModel;
import model.UserModel;
import paging.PageAble;
import service.INewsService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class NewsServiceImpl implements INewsService {

    private INewsDAO newsDAO;

    public NewsServiceImpl(){
       this.newsDAO = new NewsDaoImpl();
    }

    @Override
    public void insertNews(HttpServletRequest request,NewsModel newsModel) {
        Date date = new Date();
        newsModel.setCreatedDate(new Timestamp(date.getTime()));
        UserModel userModel = (UserModel) SessionUtil.getValue(request,"USER");
        newsModel.setCreatedBy(userModel.getUserName());

        newsDAO.insertNews(newsModel);
    }

    @Override
    public List<NewsModel> findAll(PageAble pageAble) {
        return newsDAO.getAll(pageAble);
    }

    @Override
    public NewsModel findNewsById(long id) {
        return newsDAO.findNewsById(id);
    }

    @Override
    public void updateNews(Long id, NewsModel updateNews) {
        NewsModel oldNews = newsDAO.findNewsById(id);
        updateNews.setCreatedDate(oldNews.getCreatedDate());
        updateNews.setCreatedBy(oldNews.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));

        newsDAO.updateNews(id, updateNews);
    }

    @Override
    public long countAllNews() {
        return newsDAO.countAllNews();
    }
}
