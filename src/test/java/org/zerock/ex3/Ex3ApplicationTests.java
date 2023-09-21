package org.zerock.ex3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex3.entity.MyData;
import org.zerock.ex3.web.dto.SampleDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Ex3ApplicationTests {

    @PersistenceContext
    EntityManager em;



    @Test
    void contextLoads() {
        SampleDto dto = SampleDto.builder().first("First1").last("Last1").regTime(LocalDateTime.now()).sno(1L).build();
        System.out.println(dto);
        SampleDto dto2 = dto.toBuilder().sno(2L).regTime(LocalDateTime.now()).build();
        System.out.println(dto2);
    }

    @Transactional
    @Test
    public void entity() {
        MyData myData = em.find(MyData.class, 1L);
        System.out.println(myData);
        myData.setName("김하나");
        myData = em.find(MyData.class, 1L);
        System.out.println(myData);
    }


    @Transactional
    @Test
    public void entity_persist() {
        //insert
        MyData d3 = new MyData();
        d3.setName("홍길동");
        d3.setAge(42);
        d3.setMail("hong@happy");
        d3.setMemo("나는 홍길동....");
        em.persist(d3);

        //insert 값 가져옴
        TypedQuery<MyData> query = em.createQuery("select m from MyData m", MyData.class);
        List<MyData> resultList = query.getResultList();
        for(MyData member : resultList) {
            System.out.println("member = " + member);
        }




    }




}
