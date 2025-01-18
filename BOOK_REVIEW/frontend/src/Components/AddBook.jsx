import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Form } from "react-router-dom";
import axios from "axios";
import axiosInstance from "../axiosConfig";
const AddBook = () => {
  const handleChange = (e) => {
    const { id, value } = e.target;
    setBook((prevBook) => ({
      ...prevBook,
      [id]: value,
    }));
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    axiosInstance.post("/book", book);

    console.log(book);
    navigate("/dashboard");
  };

  const [book, setBook] = useState({});
  const navigate = useNavigate();

  return (
    <div>
      <Form method="post">
        <label className="form-label" htmlFor="name">
          Book name
        </label>
        <input
          type="text"
          className="form-control"
          id="name"
          onChange={handleChange}
        />
        <label className="form-label" htmlFor="author">
          Author
        </label>
        <input
          type="text"
          className="form-control"
          id="author"
          onChange={handleChange}
        />
        <button className="btn btn-submit" onClick={handleSubmit}>
          Submit
        </button>
      </Form>
    </div>
  );
};

export default AddBook;
