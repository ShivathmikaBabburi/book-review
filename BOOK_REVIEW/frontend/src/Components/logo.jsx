import React from "react";
import favicon from "../favicon.png";
import "../css/logo.css";
const Logo = () => {
  return (
    <div className="logo-div">
      <img className="logo" src={favicon} alt="book"></img>{" "}
      <div className="logo-text">BOOK REVIEW</div>
    </div>
  );
};

export default Logo;
