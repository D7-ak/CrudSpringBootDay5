package com.example.springbootday5ex.TaskController;

import com.example.springbootday5ex.ApiResponse.ApiResponse;
import com.example.springbootday5ex.TaskModel.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("task successfully added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task){
        tasks.set(index,task);
        return new ApiResponse("updated successfully");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("deleted successfully ");
    }

    @PutMapping("/update-status/{index}")
    public ApiResponse updateStatusTask(@PathVariable int index){
        if(tasks.get(index).isStatus()){
            tasks.get(index).setStatus(false);
        }else {
            tasks.get(index).setStatus(true);
        }
        return new ApiResponse("updated successfully");
    }

    @GetMapping("/get-by-title/{title}")
    public Task getByTitleTask(@PathVariable String title){
        for (Task t: tasks){
            if(t.getTitle().equalsIgnoreCase(title)){
                return t;
            }
        }
        return null;
    }
}