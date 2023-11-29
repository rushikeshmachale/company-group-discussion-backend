
package com.excelr.service;

import com.excelr.entity.MyGroup;
import com.excelr.repository.MyGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class MyGroupService {

    private final MyGroupRepository MygroupRepository;

    @Autowired
    public MyGroupService(MyGroupRepository MygroupRepository) {
        this.MygroupRepository = MygroupRepository;
    }

    public List<MyGroup> getAllGroups() {
        return MygroupRepository.findAll();
    }

    public MyGroup getGroupById(int id) {
        return MygroupRepository.findById(id).orElse(null);
    }

    public void createGroup(MyGroup group) {
        // You may want to add validation or business logic before saving
        MygroupRepository.save(group);
    }

    public void updateGroup(MyGroup group) {
        if (MygroupRepository.existsById(group.getId())) {
            // You may want to add validation or business logic before updating
            MygroupRepository.save(group);
        } else {
            // Handle the case where the group doesn't exist
            throw new IllegalArgumentException("Group with ID " + group.getId() + " not found");
        }
    }

    public void deleteGroupById(int id) {
        if (MygroupRepository.existsById(id)) {
            MygroupRepository.deleteById(id);
        } else {
            // Handle the case where the group doesn't exist
            throw new IllegalArgumentException("Group with ID " + id + " not found");
        }
    }
}
