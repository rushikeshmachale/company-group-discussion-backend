import React from 'react';

const Info = ({ employees}) => {

    
    
  return (
    <div className="container">
      <div className="group-members">
        <h3>Group Members</h3>
        <ul>
          {employees.map((employee) => (
            <li key={employee.id}>
              ID: {employee.id}, Username: {employee.username}, Role: {employee.role}
            </li>
          ))}
        </ul>
      </div>
      <button className='btn btn-danger'>Delete Group</button>
    </div>
  );
};

export default Info;
