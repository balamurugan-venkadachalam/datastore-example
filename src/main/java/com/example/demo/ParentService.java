package com.example.demo;

import com.example.demo.data.ParentRepository;
import com.example.demo.data.model.Child;
import com.example.demo.data.model.Parent;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Optional;

@ShellComponent(value = "Embedded Entities")
public class ParentService {
    @Autowired
    private ParentRepository repository;

    @ShellMethod("get parent: get-parent <id>")
    public String getParent(String id) {
        Optional<Parent> parent = this.repository.findById(id);
        return parent.get().toString();
    }

    @ShellMethod("find all parent: find-all-parent")
    public String findAllParent() {
        Iterable<Parent> parents = this.repository.findAll();
        return Lists.newArrayList(parents).toString();
    }

    @ShellMethod("Save parent and child details: save-order <parentName> <childName> <item>")
    public String saveParent(String parentName, String childName, int age, String sex) {
        Parent parent = new Parent();
        parent.setName(parentName);

        Child child = new Child();
        child.setName(childName);
        child.setAge(age);
        child.setSex(sex);
        parent.setChild(child);

        Parent parentObj = repository.save(parent);
        return parentObj.toString();
    }
}

