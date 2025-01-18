import React from "react";
import "../css/register.css";
import Logo from "./logo";
import { Link } from "react-router-dom";
const Register = () => {
  return (
    <div className="form">
      <Logo />
      <h4>REGISTER</h4>
      <div className="form-element">
        <label for="name" className="form-label">
          NAME:
        </label>
        <input type="name" className="form-control" id="name" />
      </div>

      <div className="form-element">
        <label for="email" className="form-label">
          EMAIL:
        </label>
        <input type="email" className="form-control" id="email" />
      </div>
      <div className="form-element">
        <label for="password" className="form-label">
          PASSWORD:
        </label>
        <input type="password" className="form-control" id="password" />
      </div>
      <div className="form-element">
        <label for="address" className="form-label">
          ADDRESS:
        </label>
        <input type="text" className="form-control" id="address" />
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
      <p>
        Already a Member?<Link to="/login">Login</Link>
      </p>
    </div>
  );
};

export default Register;
