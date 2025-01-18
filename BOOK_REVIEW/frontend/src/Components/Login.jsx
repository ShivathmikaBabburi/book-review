import React from "react";
import { Link } from "react-router-dom";
import Logo from "./logo";
import { useState } from "react";
import axios from "axios";
import "../css/login.css";
import axiosInstance from "../axiosConfig";

import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const handleChange = (e) => {
    const { id, value } = e.target;
    setData((prevUser) => ({
      ...prevUser,
      [id]: value,
    }));
  };

  const [data, setData] = useState({});

  const handleSubmit = async () => {
    console.log(data);
    const user = await axiosInstance.post(`/api/auth/signin`, data);
    console.log(user);
    if (user) {
      navigate("/dashboard");
    }
  };
  return (
    <div className="form">
      <Logo />
      <h4>LOGIN</h4>

      <div className="form-element">
        <label for="email" className="form-label">
          EMAIL:
        </label>
        <input
          type="email"
          className="form-control"
          id="username"
          onChange={handleChange}
        />
      </div>
      <div className="form-element">
        <label for="password" className="form-label">
          PASSWORD:
        </label>
        <input
          type="password"
          className="form-control"
          id="password"
          onChange={handleChange}
        />
      </div>

      <button type="submit" className="btn btn-primary" onClick={handleSubmit}>
        Submit
      </button>
      <p>
        Not a Member?<Link to="/register">Register</Link>
      </p>
    </div>
  );
};

export default Login;
