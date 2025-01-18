import React from "react";
import { useLoaderData } from "react-router-dom";
import axiosInstance from "../axiosConfig";
import "../css/allreviews.css";
export const loader = async ({ params }) => {
  try {
    const response = await axiosInstance.get(`/reviews/books/${params.id}`);
    console.log(response.data);
    return response;
  } catch (error) {
    console.error("Error fetching data:", error);
    throw error;
  }
};
const AllReviews = () => {
  const { data } = useLoaderData();
  return (
    <div>
      {data.map((object) => {
        return (
          <div className="reviews">
            <header>
              <div className="main-icon">{object.user.name.charAt(0)}</div>
              <div className="info">
                <h3>{object.user.name}</h3>

                <p>{object.review.review}</p>
              </div>
            </header>
          </div>
        );
      })}
    </div>
  );
};

export default AllReviews;
