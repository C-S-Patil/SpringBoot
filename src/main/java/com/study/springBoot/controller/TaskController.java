package com.study.springBoot.controller;

import com.study.springBoot.Pojo.TaskObj;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TaskController {

    Map<Integer, TaskObj> allTasks = new HashMap<Integer, TaskObj>();
    AtomicInteger id = new AtomicInteger();

    @GetMapping("/task")
    ResponseEntity<Map<Integer,TaskObj>> getTasks() {
        return ResponseEntity.ok(allTasks);
    }

    @PostMapping("/task")
    TaskObj createTask(@RequestBody TaskObj taskObj) {
        allTasks.put(id.getAndIncrement(), taskObj);
        return taskObj;
    }

    @PutMapping("/{id}")
    ResponseEntity<TaskObj> updateTask(@PathVariable Integer id, @RequestParam String status) {
        if(allTasks.get(id) != null) {
            allTasks.get(id).setStatus(status);
        } else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allTasks.get(id));
    }

    @DeleteMapping("/{id}")
    String deleteTask(@PathVariable Integer id) {
        if(allTasks.get(id) != null) {
            String name = allTasks.get(id).name;
            allTasks.remove(id);
            return name + " deleted successful";
        } else {
            return "Provided Id not found";
        }
    }
}












