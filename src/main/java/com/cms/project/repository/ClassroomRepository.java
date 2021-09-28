package com.cms.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.project.model.ClassRoom;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom, String>{

}
