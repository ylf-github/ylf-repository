package com.ylf.JDBC;

import java.sql.*;

public class FetchAndBatch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String name="root";
        String pass="haha123.";
        String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        Connection conn= DriverManager.getConnection(url,name,pass);
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        //提升读取速率
//        String sql="select * from fun";
//        PreparedStatement ps=conn.prepareStatement(sql);
//        ResultSet rs=ps.executeQuery();
//        //rs.setFetchSize(0);
//        while(rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getInt(2));
//        }
        //批处理
        String Sql="insert into fun value(8,8)";
        PreparedStatement ps=conn.prepareStatement(Sql);
        ps.addBatch(Sql);
       // for(int i=5;i<11;i++){
          //  ps.setInt(0,i);
           // ps.setInt(1,i);
            ps.addBatch("update fun set sex=66 where id=4");
       // }
        ps.executeBatch();
        conn.commit();
    }
}
