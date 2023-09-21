package org.zerock.ex3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.ex3.entity.MyData;

import java.util.Optional;

@Repository
public interface MyDataRepository  extends JpaRepository<MyData, Long> {
    public Optional<MyData> findById(Long name);

}
