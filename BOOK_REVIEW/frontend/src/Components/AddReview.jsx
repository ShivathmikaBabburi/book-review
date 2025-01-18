import React from "react";
import { useDashboardContext } from "./Dashboard";
import { useParams } from "react-router-dom";
import { useState } from "react";
import { Form } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "../css/addreview.css";
import axiosInstance from "../axiosConfig";
const AddReview = () => {
  const handleChange = (e) => {
    setReview({ ...review, review: e.target.value });
  };
  const handleSubmit = (e) => {
    axiosInstance.post("/review", review);
    navigate("/dashboard/alluserreviews");
  };
  const { user } = useDashboardContext();
  const params = useParams();
  const id = params.id;
  const [review, setReview] = useState({ userId: user.id, bookId: id });
  const navigate = useNavigate();

  return (
    <Form method="post">
      <label className="form-label" htmlFor="review">
        <h3>Add Review</h3>
      </label>
      <input
        type="text"
        className="form-control"
        id="review"
        onChange={handleChange}
      />
      <button className="btn btn-submit" onClick={handleSubmit}>
        Submit
      </button>
    </Form>
  );
};

export default AddReview;
