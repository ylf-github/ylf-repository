package com.ylf.manage.dao;

import com.ylf.manage.entity.Task;
import com.ylf.manage.idao.Task_idao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Task_dao extends BaseDao<Task> implements Task_idao {
    public int add(Task task) {
        return super.add("insertTask",task);
    }

    public int del(String id) {
        return super.del("deleteTaskByPrimaryKey",id);
    }

    public List<Task> findAll(String cId) {
        return super.findLimitAll("selectTaskByCid",cId);
    }

    public Task getOne(String tTd) {
        return super.getOne("selectTaskByPrimaryKey",tTd);
    }
}
