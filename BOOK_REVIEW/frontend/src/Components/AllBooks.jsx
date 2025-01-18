import React from "react";
import axios from "axios";
import "../css/allBooks.css";
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
const AllBooks = () => {
  const { data } = useLoaderData();

  return (
    <div className="books">
      {data.map((book, i) => {
        const deleteBook = async () => {
          await axiosInstance.delete(`/books/${book.id}`);
          window.location.reload();
        };
        const url = `/dashboard/allreviews/${book.id}`;
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
              <button className="btn delete-btn" onClick={deleteBook}>
                Delete
              </button>
              <Link to={url} className="btn delete-btn">
                Show Reviews
              </Link>
            </footer>
          </div>
        );
      })}
    </div>
  );
};

export default AllBooks;
