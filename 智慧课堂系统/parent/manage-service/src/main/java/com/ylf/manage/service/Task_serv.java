package com.ylf.manage.service;

import com.ylf.manage.entity.Task;
import com.ylf.manage.idao.Task_idao;
import com.ylf.manage.iservice.Task_iserv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Task_serv implements Task_iserv {
    @Autowired
    private Task_idao dao;
    public int add(Task task) {
        return dao.add(task);
    }

    public int del(String id) {
        return dao.del(id);
    }

    public List<Task> findAll(String cId) {
        return dao.findAll(cId);
    }

    public Task getOne(String tId) {
        return dao.getOne(tId);
    }
}
