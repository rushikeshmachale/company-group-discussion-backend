package com.excelr.service;



import java.util.List;

import com.excelr.entity.MyGroup;

public interface GroupService {
	
	MyGroup addGroup(MyGroup myGroup);
    MyGroup updateGroup(int id,MyGroup myGroup);
    void deleteGroup(int id);
    List<MyGroup> findByType(String type);
    MyGroup getGroupById(int id);
    
    

}