package com.scaactk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //获取PrintWriter,这个要放在设置编码之后
        PrintWriter out = response.getWriter();

        //从request对象获取用户的输入
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //对用户名密码进行校验,暂时用固定的进行测试
        if("scaactk".equals(username) && "123456".equals(password))
        {
            out.write("<script>alert('登录成功')</script>");

            //获取session对象
            HttpSession session = request.getSession();
            //向session中添加属性
            session.setAttribute("username",username);

            out.write("<script>window.location.href='/thankyouServlet'</script>");
        }
        else{
            out.write("<script>alert('登录失败');window.location.href='/index.jsp'</script>");
        }


        /*out.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "      <meta charset=\"utf-8\">\n" +
                "    <title>Title</title>\n" +
                "  </head>\n" +
                "  <body>\n");
        out.write("<p>Hello "+username+" Welcome</p>");
        out.write("<p>Please enter these details:</p>");

        out.write("<form action=\"/thankyouServlet\" method=\"post\">\n");
        //用隐藏提交的方式把username再转交一次,换成session的方式
        //out.write("<input name=\"username\" type=\"hidden\" value=\" "+username+" \"><br>");
        out.write("Address:<input name=\"address\" type=\"text\"><br>");
        out.write("PhoneNo:<input name=\"phoneNo\" type=\"text\"><br>");
        out.write("<input type=\"submit\">");

        out.write("    </form>\n");
        out.write("  </body>\n");
        out.write("</html>");*/


        out.flush();//情况输出流,确保内容已经完全输出
        out.close();//关闭输出流
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
