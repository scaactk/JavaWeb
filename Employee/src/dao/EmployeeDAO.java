package dao;

import com.scaactk.DBUtils;
import com.scaactk.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO()
    {
        //建立链接
        connection = DBUtils.connect();
    }

    //将传入的employee保存
    public boolean saveEmployee(Employee employee)
    {
        try {
            PreparedStatement pstmt = connection.prepareStatement("insert into employee (ID, FirstName, LastName, Department) value (?,?,?,?)");
            pstmt.setInt(1,employee.getID());
            pstmt.setString(2,employee.getFirstName());
            pstmt.setString(3,employee.getLastName());
            pstmt.setString(4,employee.getDepartment());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Employee> queryEmployee(int id)
    {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee WHERE ID LIKE ?");
            pstmt.setString(1,"%"+id+"%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                //System.out.println(rs.getInt("ID"));
                Employee employee = new Employee(rs.getInt(1),rs.getString("FirstName"),
                        rs.getString("LastName"),rs.getString("Department"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }

        return employees;
    }

   /* //测试函数
    public static void main(String[] args) {
        //System.out.println("main");
        EmployeeDAO employeeDAO;
        employeeDAO = new EmployeeDAO();
        employeeDAO.queryEmployee(1);
        employeeDAO.queryEmployee(2);
    }*/

}
