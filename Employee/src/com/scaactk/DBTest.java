package com.scaactk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
    public static void main(String[] args) {
        Connection connection = DBUtils.connect();
        if(connection != null)
        {
            try {
                PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM employee");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next())
                {
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
