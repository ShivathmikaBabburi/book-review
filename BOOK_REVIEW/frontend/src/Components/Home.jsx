import React from "react";
import "../css/home.css";
import book from "../book.svg";
import { Outlet } from "react-router-dom";
import { Link } from "react-router-dom";
import Logo from "./logo";
const Home = () => {
  return (
    <div className="bg">
      <Outlet />
      <Logo />
      <div className="container">
        <div className="row">
          <div className="col">
            <img src={book} alt="book"></img>
          </div>
          <div className="col">
            <h1>BOOK REVIEW SYSTEM</h1>
            <p>
              If nobody talks about books, if they are not discussed or somehow
              contended with, literature ceases to be a conversation, ceases to
              be dynamic. Most of all, it ceases to be intimate. It degenerates
              into a monologue or a mutter. An unreviewed book is a struck bell
              that gives no resonance. Without reviews, literature would be
              oddly mute in spite of all those words on all those pages of all
              those books. Reviewing makes of reading a participant sport, not a
              spectator sport.
            </p>

            <Link to="/login" className="btn btn-primary">
              Login
            </Link>

            <Link to="/register" className="btn btn-primary">
              Register
            </Link>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
