package com.ylf.manage.idao;

import com.ylf.manage.entity.Task;

import java.util.List;

public interface Task_idao {
    int add(Task task);  //添加任务
    int del(String id);  //删除任务
    List<Task> findAll(String cId); //查找班课内全部任务
    Task getOne(String tTd);   //获取单个任务
}
