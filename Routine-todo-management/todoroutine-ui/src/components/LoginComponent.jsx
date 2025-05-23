import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import {
  loginAPICall,
  savedLoggedInUser,
  storeToken,
} from "../services/AuthService";

const LoginComponent = () => {
  const [username, setUsername] = useState([]);
  const [password, setPassword] = useState([]);
  const navigator = useNavigate();

  async function handleLoginForm(e) {
    e.preventDefault();

    await loginAPICall(username, password)
      .then((response) => {
        console.log(response.data);
        // const token = "Basic" + window.btoa(username + ":" + password);
        const token = "Bearer" + response.data.accessToken;
        const role=response.data.role;
        storeToken(token);
        navigator("/todos");

        savedLoggedInUser(username,role);
        navigator("/todos");
        window.location.reload(false);
      })
      .catch((error) => {
        console.log(error.response);
      });
  }
  return (
    <div className="container">
      <br></br>
      <div className="row">
        <div className="col-md-6 offset-md-3">
          <div className="card">
            <div className="card-header">
              <h2 className="text-center">Login Form</h2>
            </div>
            <div className="card-body">
              <form>
                <div className="row mb-3">
                  <label className="col-md-3 control-label">
                    Username or Email
                  </label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      name="username"
                      className="form-control"
                      placeholder="Enter username or email"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                    />
                  </div>
                </div>
                <div className="row mb-3">
                  <label className="col-md-3 control-label">Password</label>
                  <div className="col-md-9">
                    <input
                      type="text"
                      name="password"
                      className="form-control"
                      placeholder="Enter password"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                    />
                  </div>
                </div>
                <div className="form-group md-3">
                  <button
                    className="btn btn-primary"
                    onClick={(e) => handleLoginForm(e)}
                  >
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginComponent;
