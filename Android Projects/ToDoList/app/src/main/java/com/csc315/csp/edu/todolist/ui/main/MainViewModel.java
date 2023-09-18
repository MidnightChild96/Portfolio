package com.csc315.csp.edu.todolist.ui.main;
import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import com.csc315.csp.edu.todolist.Task;
import com.csc315.csp.edu.todolist.TaskRepository;

public class MainViewModel extends AndroidViewModel {
    private TaskRepository repository;
    private LiveData<List<Task>> allTasks;

    public MainViewModel(Application application){
        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllProducts();

    }

    LiveData<List<Task>> getAllTasks(){
        return allTasks;
    }

    public void addTask(Task task){
        repository.addTask(task);
    }
}