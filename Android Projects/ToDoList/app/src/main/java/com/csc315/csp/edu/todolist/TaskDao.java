package com.csc315.csp.edu.todolist;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao

public  interface TaskDao {
    @Insert void addTask(Task task);

    @Query("SELECT* FROM tasks")LiveData<List<Task>>getAllTasks();
}
