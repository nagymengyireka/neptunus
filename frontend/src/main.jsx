import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from './Pages/Layout.jsx';
import UserData from './Pages/UserData.jsx';
import ErrorPage from './Pages/ErrorPage.jsx';
import CourseApplication from './Pages/CourseApplication.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    errorElement: <ErrorPage/>,
    children: [
      {
        path: "/personal-info",
        element: <UserData />,
      },
      {
        path: "/course-application",
        element: <CourseApplication/>
      }
    ]
  }
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
