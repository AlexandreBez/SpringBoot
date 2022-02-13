package com.hr_worker.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.hr_worker.api.model.entity.Worker;
import com.hr_worker.api.model.repository.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    
    @Autowired
    private WorkerRepository repository;

    @Autowired
    private Environment env;

    @Value("${test.config}")
    private String testConfig;

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @GetMapping("/configs")
    public ResponseEntity<List<Worker>> getConfigs() {
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById( @PathVariable Long id ) {

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}