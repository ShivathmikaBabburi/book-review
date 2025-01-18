import React from "react";
import "../css/error.css";
import error from "../404error.svg";
import { Link } from "react-router-dom";
const Error = () => {
  return (
    <div>
      <img className="error-img" src={error} alt="error"></img>
      <div className="div-class">
        <h3>Ohh! page not found</h3>
        <p>We can't seem to find the page you're looking for</p>
        <Link to="/">back home</Link>
      </div>
    </div>
  );
};

export default Error;
