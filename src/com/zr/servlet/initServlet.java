package com.zr.servlet;

import com.zr.entity.News;
import com.zr.entity.NewsType;
import com.zr.service.NewsService;
import com.zr.service.NewsTypeService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019/3/17
 */
public class initServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        NewsTypeService typeService=new NewsTypeService();
        NewsService newsService=new NewsService();
        // 新闻类别加载
        List<NewsType> typeList = typeService.findAll();
        application.setAttribute("typeList",typeList);
        // 最新新闻
        List<News> newNewsList = newsService.findNewNews();
        application.setAttribute("newNewsList",newNewsList);
        // 热门新闻
        List<News> clickNewsList = newsService.findClickNews();
        application.setAttribute("clickNewsList",clickNewsList);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
