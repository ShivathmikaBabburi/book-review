import React from "react";
import { Outlet } from "react-router-dom";
import Navbar from "./Navbar";
import "../css/dashboard.css";
import { useEffect } from "react";
import SideBar from "./SideBar";
import { useState } from "react";
import { useLoginContextData } from "./Login";
import { createContext, useContext } from "react";
import axiosInstance from "../axiosConfig";
const DashboardContext = createContext();
const Dashboard = () => {
  const [user, setUser] = useState(null);
  useEffect(() => {
    const fetchUser = async () => {
      try {
        const response = await axiosInstance.get(`/api/auth/user`);
        setUser(response.data);
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    fetchUser();
  }, []);
  console.log(user);

  const [showSidebar, setShowSidebar] = useState(false);
  const toggleSidebar = () => {
    setShowSidebar(!showSidebar);
    console.log(showSidebar);
  };
  const logoutUser = async () => {
    console.log("logout user");
  };
  return (
    <DashboardContext.Provider
      value={{
        user,
        showSidebar,
        toggleSidebar,
        logoutUser,
      }}
    >
      <main className="dashboard">
        <Navbar />
        <SideBar />
        <div className="dashboard-page">
          <Outlet />
        </div>
      </main>
    </DashboardContext.Provider>
  );
};
export const useDashboardContext = () => useContext(DashboardContext);
export default Dashboard;
