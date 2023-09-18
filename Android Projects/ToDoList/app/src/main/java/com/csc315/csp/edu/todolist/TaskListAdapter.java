package com.csc315.csp.edu.todolist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    private final int taskItemLayout;
    private List<Task> taskList;

    public TaskListAdapter(int layoutId){
        taskItemLayout = layoutId;
    }

    public void setTaskList(List<Task> tasks){
        taskList = tasks;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return taskList == null ? 0:taskList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(taskItemLayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition){
        TextView item = holder.item;
        item.setText(taskList.get(listPosition).getTask());
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView item;
        ViewHolder(View itemView){
            super(itemView);
            item = itemView.findViewById(R.id.task_row);
        }
    }
}
