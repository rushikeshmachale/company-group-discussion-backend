package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.excelr.entity.MyGroup;

import java.util.List;

@Repository
public interface MyGroupRepository extends JpaRepository<MyGroup, Integer> {
	List<MyGroup> findByType(String type);

}
