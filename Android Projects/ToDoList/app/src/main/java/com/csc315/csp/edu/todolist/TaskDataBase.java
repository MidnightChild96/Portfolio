package com.csc315.csp.edu.todolist;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities={Task.class},version=1)
public abstract class TaskDataBase extends RoomDatabase{
    public abstract TaskDao taskDao();
    private static TaskDataBase INSTANCE;

    static TaskDataBase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized(TaskDataBase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),TaskDataBase.class,"task_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
