import React, {  useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Info from "./Info";
import GroupEmployeeService from "../services/GroupEmployeeService";

const DashBoard = () => {

  const navigate = useNavigate()
  const [showInfo, setShowInfo] = useState(false);
  const[employees,setEmployees] = useState([]);

  useEffect(()=>{
    getEmployeesByGroupId(1);
  },[])

  const handleInfo = async () => {
    try {
      const employeesData2 = await getEmployeesByGroupId(1);
      setEmployees(employeesData2);
      setShowInfo(true);
    } catch (error) {
      console.log("Error in getting employees:", error);
      setShowInfo(false); // Ensure to set showInfo to false in case of error
    }
  };



  

  const closeInfo = () => {
    setShowInfo(false);
  };


  const handleCreate = ( )=>{

    navigate('create');
    

  }
  const handleUpdate = ( )=>{

    navigate('update');
    

  }

  

  
  
  const handleLogout=()=>{

    navigate('/')
  }


  const getEmployeesByGroupId= async(group_id)=>{
    try {

      const employeesData = await GroupEmployeeService.getAllEmployeesByGroupId(group_id);
      console.log("Employees in group",employeesData);
      return employeesData;

      
    } catch (error) {
      console.log("Error in getting employees:" , error);
      return [];
    }

  }

  


  return (
  <div>
     <div className="container-fluid h-100">
       <div className="row h-100">

         <div className="col-12 top-div d-flex align-items-center justify-content-between px-3">
            <div className="w-25">
                <span>Hello user!</span>
            </div>
            <div className="w-75 text-left d-flex align-items-center justify-content-between">
                <span>Group Name!!</span>
            <div>
                <button className="btn btn-info" onClick={handleInfo}>Info</button>
               <button className="btn btn-success m-2" onClick={handleUpdate} >Update</button>
               <button className="btn btn-danger " onClick={handleLogout} >Logout</button>
                         
            </div>
            </div>
        </div>

        {showInfo && (
          <div className="modal fade show" style={{ display: 'block' }}>
            <div className="modal-dialog modal-dialog-centered" style={{ maxWidth: '33.33%', width: '100%' }}>
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Info</h5>
                  <button type="button" className="btn-close" aria-label="Close" onClick={closeInfo}></button>
                </div>
                <div className="modal-body">
                  <Info employees={employees}  /> {/* Render Info component */}
                </div>
              </div>
            </div>
          </div>
        )}

         <div className="col-md-3 sidebar">
                <div className="px-3 py-4 d-flex flex-column justify-content-between sidebartable" >
                    <div>
                        <input type="text" className="form-control mb-3" placeholder="Search..."/>
                        <table className="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Groups</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Group 1</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                   <button className="btn btn-primary btn-block mt-3" onClick={handleCreate} >Create Group</button>
                </div>
            </div>

            <div className="col-md-9 chat-window">
                <div className="chat-messages border-bottom mb-3">
                    {/* <!-- Sample Messages (replace with actual chat content) --> */}
                    <div className="message">Sample Message 1</div>
                    <div className="message">Sample Message 2</div>
                    <div className="message">Sample Message 3</div>
                    {/* <!-- Add more messages here --> */}
                </div>
                <div className="d-flex">
                    <input type="text" className="form-control m-1" placeholder="Type a message..."/>
                    <button className="btn btn-primary m-1 ">Send</button>
                </div>
            </div>

        </div>

     
  </div>
  </div>
  )
}

export default DashBoard