package com.groupc.flippedclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupc.flippedclass.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{
}
