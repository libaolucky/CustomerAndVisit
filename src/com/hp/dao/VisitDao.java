package com.hp.dao;

import com.hp.bean.Visit;
import com.hp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDao {
    //增加
    public int insertVisit(Visit visit){
        //1.加载连接
        Connection connection = DBHelper.getConnection();
        //2.书写sql语句
        String  sql = "insert into t_visit values (null,?,?,?,?,?)";
        //预编译
        PreparedStatement ps=null;
        int i=0;
        try {
            ps=connection.prepareStatement(sql);
            ps.setInt(1,visit.getUser_id());
            ps.setInt(2,visit.getCust_id());
            ps.setString(3,visit.getVisit_desc());
            ps.setString(4,visit.getVisit_time());
            ps.setString(5,visit.getCreate_time());
            //4.执行预编译对象
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static void main(String[] args) {
        VisitDao visitDao=new VisitDao();
        Visit visit=new Visit();
        visit.setUser_id(25);
        visit.setCust_id(8);
        visit.setVisit_desc("fnslknfkj");
        visit.setVisit_time("2020-01-12");
        visit.setCreate_time("2020-11-02 13:04:53");
        int i=visitDao.insertVisit(visit);
        System.out.println("i = " + i);
    }

}
