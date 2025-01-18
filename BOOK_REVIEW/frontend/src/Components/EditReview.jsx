import React from "react";
import axios from "axios";
import { Form } from "react-router-dom";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useLoaderData } from "react-router-dom";
import "../css/addreview.css";
import axiosInstance from "../axiosConfig";
export const loader = async ({ params }) => {
  try {
    const response = await axiosInstance.get(`/reviews/${params.id}`);
    console.log(response.data);
    return response;
  } catch (error) {
    console.error("Error fetching data:", error);
    throw error;
  }
};
const EditReview = () => {
  const { data } = useLoaderData();
  const handleChange = (e) => {
    setReview({ ...review, review: e.target.value });
  };
  const handleSubmit = (e) => {
    axios.post("http://localhost:8080/review", review);
    navigate("/dashboard/alluserreviews");
  };
  const [review, setReview] = useState(data);
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
        defaultValue={data.review}
        onChange={handleChange}
      />
      <button className="btn btn-submit" onClick={handleSubmit}>
        Submit
      </button>
    </Form>
  );
};
export default EditReview;
