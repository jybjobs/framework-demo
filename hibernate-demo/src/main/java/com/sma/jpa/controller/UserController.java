package com.sma.jpa.controller;

import com.sma.jpa.dao.UserEntity;
import com.sma.jpa.dao.UserRepository;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/test")
public class UserController {

    @Autowired
    //用来调用hibernate自带的数据库方法
    private UserRepository userRepository;
    @PersistenceContext
    //用来得到hibernate中的session，然后通过session去执行我们直接写的sql操作
    private EntityManager entityManager;

    @Autowired
    private SessionFactory sessionFactory;

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody UserEntity userEntity){
        System.out.println(userEntity.toString());
        userRepository.save(userEntity);
        return "success";
    }
    @GetMapping("/delete")
    public @ResponseBody String delete(Integer[] ids){
        //System.out.println(ids.length);
        userRepository.deleteAllById(Arrays.asList(ids));
        return "success";
    }


    @GetMapping("/batch/save")
    public @ResponseBody String batchSave(@RequestBody List<UserEntity> userEntities){
       // System.out.println(ids.length);
//        List<UserEntity> userEntities = new ArrayList<>();
//        String text= "xiaoming";
//        userEntities.add(new UserEntity(120,text,"aa",102));
//        userEntities.add(new UserEntity(121,text,"aa",102));
//        userEntities.add(new UserEntity(122,text,"aa",102));
//        userEntities.add(new UserEntity(123,text,"aa",102));
//        userEntities.add(new UserEntity(124,text,"aa",102));
//        userRepository.saveAll(userEntities);
        Session session = sessionFactory.openSession();
       // EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        Transaction tx = session.beginTransaction();
        for ( int i=0; i<userEntities.size(); i++ ) {
            session.save(userEntities.get(i));
           if ( i % 20 == 0 ) { //20, same as the JDBC batch size
              //flush a batch of inserts and release memory:
              session.flush();
              session.clear();
           }
        }
//        session.flush();
//        session.clear();
        tx.commit();
        session.close();

        return "success";
    }
    //自定义sql语句的实现，需要hibernate中的session实现
    @GetMapping("/query")
    public @ResponseBody String query(){
        String sql = "select * from sys_user";
        Session session = (Session) entityManager.getDelegate();
        SQLQuery query = session.createSQLQuery(sql);
        List<UserEntity> list = query.list();
        System.out.println(list.toString());
        return "success";
    }
}
