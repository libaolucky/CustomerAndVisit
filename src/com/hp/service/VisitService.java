package com.hp.service;

import com.hp.bean.Visit;
import com.hp.dao.VisitDao;

import java.util.HashMap;
import java.util.Map;

public class VisitService {
    //增加
    public Map insertVisit(Visit visit){
        System.out.println("进入到 service 层了---");
        Map map = new HashMap();

        VisitDao dao=new VisitDao();
        System.out.println("dao = " + dao);
        int i = dao.insertVisit(visit);
        System.out.println("i = " + i);
        if(i==1){
            map.put("code",0);
            map.put("msg","添加成功");
        }else{
            map.put("code",400);
            map.put("msg","添加不成功");
        }
        return map;
    }

}
