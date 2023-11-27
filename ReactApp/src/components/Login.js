import React, { useState } from 'react'
import EmployeeService from '../services/LoginService';
import DashBoard from './DashBoard';

const Login = () => {
    const [username,setUsername] = useState('');
    const [password,setPassword] =useState('');
    const[error,setError] =useState('');
    const[role,setRole] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    };

    const handleLogin = async(event)=>{
        event.preventDefault();

        try{
            const fetchRole = await EmployeeService.login(username,password);
            setRole(fetchRole);
            setError('');
        }catch(error){
            setError(error);
            setRole(null);
        }
    }

    const handleLogout = () => {
        setRole(null); // Clear the role state on logout
    };



  return (
<div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <h2>Login</h2>
          {role ? (
            <div>
              <DashBoard role={role} />
              <button className="btn btn-danger" onClick={handleLogout}>
                Logout
              </button>
            </div>
          ) : (
            <div>
              {error && <div className="alert alert-danger">{error.toString()}</div>}
              <form onSubmit={handleLogin}>
                <div className="mb-3">
                  <label className="form-label">Username:</label>
                  <input
                    type="text"
                    className="form-control"
                    name="username"
                    value={username}
                    onChange={handleUsernameChange}
                  />
                </div>
                <div className="mb-3">
                  <label className="form-label">Password:</label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    value={password}
                    onChange={handlePasswordChange}
                  />
                </div>
                <button type="submit" className="btn btn-primary">
                  Login
                </button>
              </form>
            </div>
          )}
        </div>
      </div>
    </div>
  )
}

export default Login