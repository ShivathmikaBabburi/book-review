import React from "react";
import { useDashboardContext } from "./Dashboard";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axiosInstance from "../axiosConfig";
import "../css/alluserreviews.css";
const AllUserReviews = () => {
  const { user } = useDashboardContext();
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axiosInstance.get(`/reviews/users/${user.id}`);
        setData(response.data);
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    fetchUser();
  }, []);
  return (
    <div>
      {data.map((item) => {
        const url = `/dashboard/editreview/${item.review.id}`;
        return (
          <div className="reviews">
            <header>
              <div className="main-icon">{item.book.name.charAt(0)}</div>
              <div className="info">
                <h3>{item.book.name}</h3>

                <p>{item.review.review}</p>
                <Link to={url} className="btn delete-btn">
                  Edit Review
                </Link>
              </div>
            </header>
          </div>
        );
      })}
    </div>
  );
};

export default AllUserReviews;
