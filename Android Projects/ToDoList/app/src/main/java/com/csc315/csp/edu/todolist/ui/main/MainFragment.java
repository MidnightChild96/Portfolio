package com.csc315.csp.edu.todolist.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.csc315.csp.edu.todolist.TaskListAdapter;
import com.csc315.csp.edu.todolist.databinding.MainFragmentBinding;
import com.csc315.csp.edu.todolist.Task;
import androidx.lifecycle.Observer;
import java.util.List;
import java.util.Locale;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.csc315.csp.edu.todolist.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;
    private TaskListAdapter adapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        listenerSetup();
        observerSetup();
        recyclerSetup();
    }


    private void listenerSetup() {
        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.taskInput.getText().toString();
                if (!name.equals("")) {
                    Task task = new Task(name);
                    mViewModel.addTask(task);
                }
            }
        });
    }
    private void observerSetup(){
        mViewModel.getAllTasks().observe(getViewLifecycleOwner(),new Observer<List<Task>>(){
            @Override
            public void onChanged(@Nullable final List<Task> tasks){
                adapter.setTaskList(tasks);
            }
        });
    }

    private void recyclerSetup(){
        adapter = new TaskListAdapter(R.layout.task_list);
        binding.taskRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.taskRecycler.setAdapter(adapter);
    }
}