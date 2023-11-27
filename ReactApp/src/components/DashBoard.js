import React, { useState } from 'react'

const DashBoard = ({role}) => {

    const [message, setMessage] = useState('');

  const handleSend = () => {
    // Add functionality to handle sending messages
    // For example, you can send messages to a chat server or update state
    console.log('Message sent:', message);
  };

  const handleDelete = () => {
    // Add functionality to handle delete
    alert('Deleted');
  };

  const handleUpdate = () => {
    // Add functionality to handle update
    alert('Updated');
  };
  return (
    <div className="container mt-5">
    <div className="row">
      {role === 'admin' && (
        <div className="col-md-6">
          <div className="p-3 mb-3" style={{ border: '1px solid black' }}>
            <h2>Admin Functional Groups</h2>
            <div className="list-group" id="functionalGroups">
              <div className="list-group-item d-flex justify-content-between align-items-center">
                Sample Admin Functional Group 1
                <div>
                  <button className="btn btn-sm btn-primary mr-2" onClick={handleUpdate}>
                    Update
                  </button>
                  <button className="btn btn-sm btn-danger" onClick={handleDelete}>
                    Delete
                  </button>
                </div>
              </div>
              {/* Add more admin functional groups here */}
            </div>
            <button className="btn btn-primary mt-3">Add Admin Functional Group</button>
          </div>
        </div>
      )}

      {role === 'admin' && (
        <div className="col-md-6">
          <div className="p-3 mb-3" style={{ border: '1px solid black' }}>
            <h2>Admin Technical Groups</h2>
            <div className="list-group" id="technicalGroups">
              <div className="list-group-item d-flex justify-content-between align-items-center">
                Sample Admin Technical Group 1
                <div>
                  <button className="btn btn-sm btn-primary mr-2" onClick={handleUpdate}>
                    Update
                  </button>
                  <button className="btn btn-sm btn-danger" onClick={handleDelete}>
                    Delete
                  </button>
                </div>
              </div>
              {/* Add more admin technical groups here */}
            </div>
            <button className="btn btn-primary mt-3">Add Admin Technical Group</button>
          </div>
        </div>
      )}

      <div className="col-md-3 border-end">
        <h4>Members</h4>
        {/* ... (Your existing code for members) */}
      </div>

      <div className="col-md-9">
        <h4>Chat</h4>
        <div className="chat-area border">
          {/* ... (Your existing code for chat messages) */}
        </div>
        <div className="input-group mt-3">
          <input
            type="text"
            className="form-control"
            placeholder="Type your message..."
            onChange={(e) => setMessage(e.target.value)}
            value={message}
          />
          <button className="btn btn-primary" onClick={handleSend}>
            Send
          </button>
        </div>
      </div>

     
    </div>
  </div>
  )
}

export default DashBoard