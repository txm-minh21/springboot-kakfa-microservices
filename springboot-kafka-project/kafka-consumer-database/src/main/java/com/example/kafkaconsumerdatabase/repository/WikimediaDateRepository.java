package com.example.kafkaconsumerdatabase.repository;

import com.example.kafkaconsumerdatabase.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDateRepository extends JpaRepository<WikimediaData, Long> {

}
