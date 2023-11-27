package com.excelr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.entity.Messages;


@Repository
public interface MessageRepository extends JpaRepository<Messages, Integer>{

}
