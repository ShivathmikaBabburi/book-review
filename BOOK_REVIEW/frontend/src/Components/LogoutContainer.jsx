import { FaUserCircle } from "react-icons/fa";
import "../css/logout.css";
import { useDashboardContext } from "./Dashboard";

const LogoutContainer = () => {
  const { user, logoutUser } = useDashboardContext();
  console.log(user);
  return (
    <main>
      <button type="button" className="btn logout-btn" onClick={logoutUser}>
        <FaUserCircle />
        {user?.username}
      </button>
    </main>
  );
};
export default LogoutContainer;
