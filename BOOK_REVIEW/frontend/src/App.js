import "./App.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "./Components/Home";
import Register from "./Components/Register";
import Login from "./Components/Login";
import AllBooks from "./Components/AllBooks";
import AddBook from "./Components/AddBook";
import AddReview from "./Components/AddReview";
import Dashboard from "./Components/Dashboard";
import EditReview from "./Components/EditReview";
import Error from "./Components/Error";
import Landing from "./Components/Landing";
import AllReviews from "./Components/AllReviews";
import EditUser from "./Components/EditUser";
import AllUserReviews from "./Components/AllUserReviews";
import { loader as AllBooksLoader } from "./Components/AllBooks";
import { loader as LandingLoader } from "./Components/Landing";
import { loader as AllReviewsLoader } from "./Components/AllReviews";
import { loader as EditReviewLoader } from "./Components/EditReview";
const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
    errorElement: <Error />,
  },
  {
    path: "/register",
    element: <Register />,
    errorElement: <Error />,
  },
  {
    path: "/login",
    element: <Login />,
    errorElement: <Error />,
  },
  {
    path: "/dashboard",
    element: <Dashboard />,
    errorElement: <Error />,
    children: [
      {
        index: true,
        element: <Landing />,
        loader: LandingLoader,
      },
      {
        path: "addbook",
        element: <AddBook />,
      },
      {
        path: "edituser",
        element: <EditUser />,
      },
      {
        path: "alluserreviews",
        element: <AllUserReviews />,
      },
      {
        path: "allbooks",
        element: <AllBooks />,
        loader: AllBooksLoader,
      },
      {
        path: "addreview/:id",
        element: <AddReview />,
      },
      {
        path: "editreview/:id",
        element: <EditReview />,
        loader: EditReviewLoader,
      },
      {
        path: "allreviews/:id",
        element: <AllReviews />,
        loader: AllReviewsLoader,
      },
    ],
  },
]);

const App = () => {
  return <RouterProvider router={router} />;
};
export default App;
