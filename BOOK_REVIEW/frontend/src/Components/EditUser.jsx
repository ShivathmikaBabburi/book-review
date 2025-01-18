import React from "react";
import { useDashboardContext } from "./Dashboard";
import { Form } from "react-router-dom";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import axiosInstance from "../axiosConfig";
const EditUser = () => {
  const navigate = useNavigate();
  const handleChange = (e) => {
    const { id, value } = e.target;
    setData((prevUser) => ({
      ...prevUser,
      [id]: value,
    }));
  };

  const { user } = useDashboardContext();
  const [data, setData] = useState(user);

  const handleSubmit = (e) => {
    e.preventDefault();
    axiosInstance.patch(`/users/${user.id}`, data);
    console.log(data);
    navigate("/dashboard");
  };
  return (
    <Form method="post">
      <label className="form-label" htmlFor="name">
        Name:
      </label>
      <input
        type="text"
        className="form-control"
        id="name"
        defaultValue={user.name}
        onChange={handleChange}
      />
      <label className="form-label" htmlFor="email">
        Email:
      </label>
      <input
        type="text"
        className="form-control"
        id="email"
        defaultValue={user.email}
        onChange={handleChange}
      />
      <label className="form-label" htmlFor="name">
        Address:
      </label>
      <input
        type="text"
        className="form-control"
        id="address"
        defaultValue={user.address}
        onChange={handleChange}
      />
      <button className="btn btn-submit" onClick={handleSubmit}>
        Submit
      </button>
    </Form>
  );
};

export default EditUser;
