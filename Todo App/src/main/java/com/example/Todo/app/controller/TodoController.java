package com.example.Todo.app.controller;

import com.example.Todo.app.module.Todo;
import com.example.Todo.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping( value = "/getAllTodo")
    public List<Todo> getAllTodoFromService(){
        return todoService.serviceMethod();
    }

    @PostMapping(value ="/postAllTodo")
//                                      Todo- obj type ka h  td- jha p store krre h
    public String postTodos(@RequestBody Todo td) {
        return todoService.requestservice(td);
    }

    @RequestMapping(value = "/getTodoById/{id}",method = RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
            return todoService.getTodoIdFromService(id);
    }

    @DeleteMapping(value = "/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }

    @PutMapping(value = "/updateTodoById/{id}/{status}")
    public String updateTodoById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoById(id,status);
    }

}
