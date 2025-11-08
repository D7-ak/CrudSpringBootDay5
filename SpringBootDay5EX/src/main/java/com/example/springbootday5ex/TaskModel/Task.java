package com.example.springbootday5ex.TaskModel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
private String id;
private String title;
private String description;
private boolean Status;

}
