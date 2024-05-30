import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from './Pages/Layout/Layout.jsx';
import UserData from './Pages/UserData.jsx';
import ErrorPage from './Pages/ErrorPage.jsx';
import CourseApplication from './Pages/CourseApplication.jsx';
import CourseList from './Pages/CourseList.jsx';
import MainPage from './Pages/MainPage.jsx';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout/>,
    errorElement: <ErrorPage/>,
    children: [
      {
        path: "/main",
        element: <MainPage/>
      },
      {
        path: "/personal-info",
        element: <UserData />,
      },
      {
        path: "/course-application",
        element: <CourseApplication/>
      },
      {
        path: "/taken-courses",
        element: <CourseList/>
      }
    ]
  }
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
