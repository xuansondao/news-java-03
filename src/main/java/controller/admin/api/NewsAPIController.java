package controller.admin.api;

import model.NewsModel;
import model.UserModel;
import service.INewsService;
import service.impl.NewsServiceImpl;
import utils.ModelToJsonUtil;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/api/admin/news")
public class NewsAPIController extends HttpServlet implements Serializable {

    private INewsService newsService;

    public NewsAPIController(){
        this.newsService = new NewsServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");

        NewsModel newsModel = ModelToJsonUtil.of(req.getReader()).toModel(NewsModel.class);

        newsService.insertNews(req, newsModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        NewsModel news = ModelToJsonUtil
                .of(req.getReader())
                .toModel(NewsModel.class);
        UserModel user = (UserModel) SessionUtil
                .getValue(req,"USER");
        news.setModifiedBy(user.getUserName());

        newsService.updateNews(news.getId(),news);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
