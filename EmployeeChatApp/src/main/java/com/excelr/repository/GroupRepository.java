package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.excelr.entity.MyGroup;

@Repository
public interface GroupRepository extends JpaRepository<MyGroup, Integer> {

}
