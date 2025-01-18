import React from "react";
import { FaTimes } from "react-icons/fa";
import Logo from "./logo";
import "../css/sidebar.css";
import { NavLink } from "react-router-dom";
import links from "./links";
import { useDashboardContext } from "./Dashboard";
const SideBar = () => {
  const { showSidebar, toggleSidebar } = useDashboardContext();
  return (
    <main>
      <div
        className={
          showSidebar ? "sidebar-container show-sidebar" : "sidebar-container"
        }
      >
        <div className="content">
          <header>
            <Logo />
          </header>

          <div className="nav-links">
            {links.map((link) => {
              const { text, path, icon } = link;

              return (
                <NavLink
                  to={path}
                  key={text}
                  className="nav-link"
                  onClick={toggleSidebar}
                  // will discuss in a second
                  end
                >
                  <span className="icon">{icon}</span>
                  {text}
                </NavLink>
              );
            })}
            <button type="button" className="close-btn" onClick={toggleSidebar}>
              <FaTimes />
            </button>
          </div>
        </div>
      </div>
    </main>
  );
};

export default SideBar;
