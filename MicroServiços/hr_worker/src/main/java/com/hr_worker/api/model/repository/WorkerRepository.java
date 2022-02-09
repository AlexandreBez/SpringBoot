package com.hr_worker.api.model.repository;

import com.hr_worker.api.model.entity.Worker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    
}