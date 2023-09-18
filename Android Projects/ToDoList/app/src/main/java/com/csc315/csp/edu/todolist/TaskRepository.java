package com.csc315.csp.edu.todolist;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import android.app.Application;
import androidx.lifecycle.LiveData;

public class TaskRepository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public TaskRepository(Application application){
        TaskDataBase db;
        db = TaskDataBase.getDatabase(application);
        taskDao = db.taskDao();
        allTasks = taskDao.getAllTasks();
    }

    public void addTask(Task newtask){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(()->{
            taskDao.addTask(newtask);
        });
        executor.shutdown();
    }

    public LiveData<List<Task>> getAllProducts(){
        return allTasks;
    }
}
