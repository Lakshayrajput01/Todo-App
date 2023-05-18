package com.example.Todo.app.service;

import com.example.Todo.app.module.Todo;
import com.example.Todo.app.repository.TodoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoDao todoDao;

    public List<Todo> serviceMethod() {
        return todoDao.FromDaoMethod();
    }

    public String requestservice(Todo td) {
        return todoDao.requestdao(td);
    }

    public Todo getTodoIdFromService(String id) {
//        we can do this work also in Dao but here we can do like this..
        List<Todo> filteredList = todoDao.FromDaoMethod();
//                  store             we can take all thing from  dao
//        logic find id
        for (Todo todoObj : filteredList) {
            if (todoObj.getId().equals(id)) {
                return todoObj;
            }
        }
        return null;
    }

    public String removeTodoById(String id) {
        boolean Response = false;
        String status;

        if (id != null) {
            List<Todo> filteredList = todoDao.FromDaoMethod();

            for (Todo todoObj : filteredList) {
                if (todoObj.getId().equals(id)) {
                    Response = todoDao.remove(todoObj);
                    if (Response) {
                        status = "Delete Succesfully";
                    } else {
                        status = "Not deleted";
                    }
                    return status;
                }
            }
                return "id does not Exist";
        }
        else{
            return "invalid id";
        }
    }

    public String updateTodoById(String id, String status) {
        List<Todo> filteredList = todoDao.FromDaoMethod();

        for (Todo todoObj : filteredList) {
            if (todoObj.getId().equals(id)) {
                todoDao.update(id,Boolean.parseBoolean(status));
            }                             // String to Boolean
        }
        return null;
    }
}
