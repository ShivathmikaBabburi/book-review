import { VscPreview } from "react-icons/vsc";
import { FaBook } from "react-icons/fa";
import { MdLibraryBooks } from "react-icons/md";
import { MdOutlineRateReview } from "react-icons/md";

const links = [
  { text: "All Reviews", path: "alluserreviews", icon: <VscPreview /> },
  { text: "add book", path: "addbook", icon: <FaBook /> },
  { text: "all books", path: "allbooks", icon: <MdLibraryBooks /> },
  { text: "edit user", path: "edituser", icon: <MdOutlineRateReview /> },
];

export default links;
