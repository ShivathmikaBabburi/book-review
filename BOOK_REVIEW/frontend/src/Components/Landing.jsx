import React from "react";
import axios from "axios";
import "../css/landing.css";
import { useLoaderData } from "react-router-dom";
import { Link } from "react-router-dom";
import axiosInstance from "../axiosConfig";
export const loader = async () => {
  try {
    const response = await axiosInstance.get("/books");
    console.log(response.data);
    return response;
  } catch (error) {
    console.error("Error fetching data:", error);
    throw error;
  }
};

const Landing = () => {
  const { data } = useLoaderData();

  return (
    <div className="books">
      {data.map((book) => {
        const url = `addreview/${book.id}`;
        const url2 = `allreviews/${book.id}`;
        return (
          <div className="box">
            <header>
              <div className="main-icon">{book.name.charAt(0)}</div>
              <div className="info">
                <h3>{book.name}</h3>

                <p>{book.author}</p>
              </div>
            </header>
            <footer className="actions">
              <Link to={url} className="btn add-review">
                Add Review
              </Link>
              <Link to={url2} className="btn show-review">
                Show Reviews
              </Link>
            </footer>
          </div>
        );
      })}
    </div>
  );
};

export default Landing;
