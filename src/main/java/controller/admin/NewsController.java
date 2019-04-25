package controller.admin;

import service.INewsService;
import service.impl.NewsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/news")
public class NewsController extends HttpServlet{

    private INewsService newsService;

    public NewsController(){
        this.newsService = new NewsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String view = "";
        if (type != null){
            if (type.equals("edit")){

            }else if (type.equals("create")){

            }
            view = "/views/admin/news/edit.jsp";
        }else{
            view = "/views/admin/news/list.jsp";
        }
        RequestDispatcher rs = req.getRequestDispatcher(view);
        rs.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
