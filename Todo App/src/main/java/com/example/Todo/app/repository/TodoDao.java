package com.example.Todo.app.repository;

import com.example.Todo.app.module.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoDao {

    List<Todo> todosList =new ArrayList<>();
    public List<Todo> FromDaoMethod(){
        Todo todo =new Todo("0","Dummy",false);
        todosList.add(todo);
        return todosList;
    }
    public String requestdao(Todo td){
        todosList.add(td);
        return "Saved";
    }
    public boolean remove(Todo todo){
        todosList.remove(todo);
        return true;
    }

    public boolean update(String id, boolean status) {
        for(Todo todoObj : todosList){
            if(todoObj.getId().equals(id)){
                //remove from original
                if(remove(todoObj)) {
                    //set
                    todoObj.setStatus(status);
                    //add
                    todosList.add(todoObj);
                    return true;

                }else{
                    return false;
                }

            }
        }
        return false;
    }
}
