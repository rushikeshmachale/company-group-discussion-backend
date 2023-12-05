// MyGroupServiceImpl.java
package com.excelr.service.impl;

import com.excelr.entity.MyGroup;
import com.excelr.repository.MyGroupRepository;
import com.excelr.service.MyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyGroupServiceImpl implements MyGroupService {

    private final MyGroupRepository myGroupRepository;

    @Autowired
    public MyGroupServiceImpl(MyGroupRepository myGroupRepository) {
        this.myGroupRepository = myGroupRepository;
    }

    @Override
    public List<MyGroup> getAllGroups() {
        return myGroupRepository.findAll();
    }

    @Override
    public MyGroup getGroupById(int id) {
        return myGroupRepository.findById(id).orElse(null);
    }

    @Override
    public MyGroup createGroup(MyGroup group) {
        // You may want to add validation or business logic before saving
        return myGroupRepository.save(group);
    }

    @Override
    public void updateGroup(MyGroup group) {
        if (myGroupRepository.existsById(group.getId())) {
            // You may want to add validation or business logic before updating
            myGroupRepository.save(group);
        } else {
            // Handle the case where the group doesn't exist
            throw new IllegalArgumentException("Group with ID " + group.getId() + " not found");
        }
    }

    @Override
    public void deleteGroupById(int id) {
        if (myGroupRepository.existsById(id)) {
            myGroupRepository.deleteById(id);
        } else {
            // Handle the case where the group doesn't exist
            throw new IllegalArgumentException("Group with ID " + id + " not found");
        }
    }

    @Override
    public List<MyGroup> findByType(String type) {
        return myGroupRepository.findByType(type);
        // Assuming that there is a method in MyGroupRepository named findByType
        // that returns a list of MyGroup entities based on the 'type' parameter.
    }
}
