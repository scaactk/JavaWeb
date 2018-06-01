package com.scaactk;

import dao.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        //获取PrintWriter
        PrintWriter out = response.getWriter();
        String kind = request.getParameter("kind");
        if(kind!=null)
        {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            if(kind.equals("saveEmployee"))
            {
                int ID = Integer.parseInt(request.getParameter("id"));//将String转为int
                String  firstName = request.getParameter("firstname");
                String  lastName = request.getParameter("lastname");
                String  department = request.getParameter("department");
                Employee employee = new Employee((int)ID,firstName,lastName,department);
                boolean flag = employeeDAO.saveEmployee(employee);
                if(flag==false)
                {
                    out.write("<script>alert('插入失败');window.location.href='/Save.jsp'</script>");
                    out.flush();
                }
                else
                {
                    out.write("<script>alert('插入成功');window.location.href='/Save.jsp'</script>");
                    out.flush();
                }
            }
            else if(kind.equals("queryEmployee"))
            {
                int ID = Integer.parseInt(request.getParameter("QueryID"));
                ArrayList<Employee> rs = employeeDAO.queryEmployee(ID);
                out.write("<center><table width='400px' align:center border='1'>");
                out.write("<th>ID</th> <th>FirstName</th> <th>LastName</th> <th>Department</th>");
                for(int i=0;i<rs.size();i++)
                {
                    out.write("<tr width='400px'>");
                    out.write("<td width='100px'>");
                    out.write(rs.get(i).getID()+"");//输出int类型
                    out.write("</td>");

                    out.write("<td width='400px'>");
                    out.write(rs.get(i).getFirstName());
                    out.write("</td>");

                    out.write("<td width='400px'>");
                    out.write(rs.get(i).getLastName());
                    out.write("</td>");

                    out.write("<td width='400px'>");
                    out.write(rs.get(i).getDepartment());
                    out.write("</td>");
                    out.write("</tr>");
                }
                out.write("</table></center>");
            }
        }
        //Connection coon = DBUtils.connect();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
