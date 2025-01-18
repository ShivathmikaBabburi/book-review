import React from "react";
import { RiDashboardLine } from "react-icons/ri";
import Logo from "./logo";
import "../css/nav.css";
import { useDashboardContext } from "./Dashboard";
import LogoutContainer from "./LogoutContainer";
const Navbar = () => {
  const { toggleSidebar } = useDashboardContext();
  return (
    <main>
      <div className="nav-center">
        <button type="button" className="toggle-btn" onClick={toggleSidebar}>
          <RiDashboardLine />
        </button>
        <div>
          <Logo />
        </div>
        <LogoutContainer />
      </div>
    </main>
  );
};

export default Navbar;
