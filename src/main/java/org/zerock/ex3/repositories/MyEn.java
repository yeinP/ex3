package org.zerock.ex3.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ex3.entity.MyData;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
//dao
public class MyEn {
    @PersistenceContext
    EntityManager em;

    public List<MyData> findAll() {
        String sql = "select m from MyData m";
        TypedQuery<MyData> query = em.createQuery(sql, MyData.class);
        List<MyData> list = query.getResultList();
        return list;
    }

    @Transactional
    public void insert(MyData myData) {
        em.persist(myData);
    }


    public MyData findById(Long id) {
        MyData myData  = em.find(MyData.class, id);
        return myData;
    }

    @Transactional
    public void update(MyData myData) {
        em.merge(myData);
    }

    @Transactional
    public void deletById(Long id) {
        MyData myData = em.find(MyData.class, id);
        em.remove(myData);
    }
}