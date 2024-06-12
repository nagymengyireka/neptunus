import React from 'react'
import ReactDOM from 'react-dom/client'
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Layout from './Layout/Layout.jsx';
import UserData from './Pages/UserData.jsx';
import ErrorPage from './Pages/ErrorPage.jsx';
import CourseApplication from './Pages/CourseApplication.jsx';
import CourseList from './Pages/CourseList.jsx';
import Calendar from 'react-calendar';
import MainPage from './Pages/MainPage.jsx';
import LoginPage from './Pages/LoginPage.jsx';
import LoginLayout from './Layout/LoginLayout.jsx';

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
      },
      {
        path: "/calendar",
        element: <Calendar/>
      }
    ]
  },
  {
    path: "/login",
    element: <LoginLayout />,
    children: [
      {
        path: "",
        element: <LoginPage />,
      },
    ],
  },
])


ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
