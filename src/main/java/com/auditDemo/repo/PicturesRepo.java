package com.auditDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditDemo.entities.tables.Picture;

@Repository
public interface PicturesRepo extends JpaRepository<Picture, Long>{

}
