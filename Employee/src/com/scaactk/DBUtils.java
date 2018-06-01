package com.scaactk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String  driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";

    private static String user = "root";
    private static String pwd = "scaactk";

/*    public static void main(String[] args)
    {
        connect();
    }*/

    public static Connection connect() {
        Connection conn = null;
        //加载驱动
        try{
            Class.forName(driverClassName);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("load driver failed!");
            e.printStackTrace();
        }

        //建立连接
        try{
            conn = DriverManager.getConnection(url,user,pwd);
        }
        catch(SQLException e){
            System.out.println("connect failed!");
            e.printStackTrace();
        }

        System.out.println(conn);
        return conn;
    }


    /*static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void getConnection()
    {
        if(conn == null){
            try{
                conn = DriverManager.getConnection(url,user,pwd);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    //执行读取操作
    public java.sql.ResultSet executeQuery(String query, List<Object> params){
        getConnection();
        try{
            pstmt = conn.prepareStatement(query);
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++)
                {
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            rs = pstmt.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return rs;
    }

    //执行写操作方法
    public int executeUpdate(String query,
                             List<Object> params){
        int result = 0;
        getConnection();
        try {
            //3、创建命令执行对象
            pstmt = conn.prepareStatement(query);
            //4、执行
            if(params!=null && params.size()>0){
                for(int i=0;i<params.size();i++){
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            //5、处理结果
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //6、释放资源
            this.close();
        }
        return result;
    }

    //关闭资源
    public void close(){
        try {
            if(rs!=null){
                rs.close();
                rs = null;
            }
            if(pstmt!=null){
                pstmt.close();
                pstmt = null;
            }
            if(conn!=null){
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/
}
