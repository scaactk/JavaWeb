package com.scaactk;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class thankyouServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取PrintWriter,这个要放在设置编码之后
        PrintWriter out = response.getWriter();

        //获取用户输入的值
        String address = request.getParameter("address");
        String phoneNo = request.getParameter("phoneNo");
        //String name = request.getParameter("username");
        //从session获取name
        String name = (String) request.getSession().getAttribute("username");
        if(name!=null)
        {
            out.write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "  <head>\n" +
                    "      <meta charset=\"utf-8\">\n" +
                    "    <title>Title</title>\n" +
                    "  </head>\n" +
                    "  <body>\n");
            out.write("<p>Thank you " + name +"</p><br>");
            out.write("<p>Your detail has been submitted</p>");
            out.write("name: " + name + "<br>");
            out.write("address: " + address + "<br>");
            out.write("Phone No: " + phoneNo + "<br>");


            out.write("  </body>\n");
            out.write("</html>");
        }
        else{
            //跳转到登录页面，重新登录
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
        }




        out.flush();//情况输出流,确保内容已经完全输出
        out.close();//关闭输出流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
