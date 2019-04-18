package service.impl;

import dao.IGenericDAO;
import dao.INewsDAO;
import dao.impl.NewsDaoImpl;
import model.NewsModel;
import model.UserModel;
import service.INewsService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;

public class NewsServiceImpl implements INewsService {

    private INewsDAO newsDAO;

    public NewsServiceImpl(){
        try {
            newsDAO = IGenericDAO.getInstance(NewsDaoImpl.class);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertNews(HttpServletRequest request,NewsModel newsModel) {
        Date date = new Date();
        newsModel.setCreatedDate(new Timestamp(date.getTime()));
//        UserModel userModel = (UserModel) SessionUtil.getValue(request,"USER");
//        newsModel.setCreatedBy(userModel.getUserName());

        newsDAO.insertNews(newsModel);
    }
}
