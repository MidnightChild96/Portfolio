package com.csc315.csp.edu.todolist;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")

public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "taskName")
    private String task;

    public Task(String task){
        this.task = task;
    }
    public String getTask(){
        return task;
    }
    public int getId(){return id;}
    public void setTask(String task){
        this.task = task;
    }
    public void setId(int id){this.id = id;}
}
