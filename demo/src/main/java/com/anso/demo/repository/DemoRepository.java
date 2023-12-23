package com.anso.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anso.demo.entity.Participant;

public interface DemoRepository extends JpaRepository<Participant, Long> {
	List<Participant> findAllByPosition(String software_engineer);
}
