package com.study.springBoot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @GetMapping("/task")
    ResponseEntity<String> getTasks() {
        return ResponseEntity.ok("Get API added...");
    }
}
