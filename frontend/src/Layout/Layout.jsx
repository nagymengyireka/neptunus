import React, { Component, useState, useEffect } from 'react'
import Calendar from 'react-calendar';
import { Link, Outlet, useLocation } from 'react-router-dom';

import "./Layout.css"
import StudentNavBar from '../Pages/Components/StudentNavBar';
import TeacherNavBar from '../Pages/Components/TeacherNavBar';

const Layout = ({ role }) => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);

  useEffect(() => {
    const handleResize = () => {
      setWindowWidth(window.innerWidth);
    };
    window.addEventListener('resize', handleResize);
    return () => {
      window.removeEventListener('resize', handleResize);
    };
  }, []);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <>
      <div className='layoutHeader' style={{ margin: "10px", backgroundSize: "auto" }}>
        <Link to={"/main"}>
          <img src='/Neptunus.png' className='img-fluid' alt='logo' />
        </Link>
      </div>
      <div>
        {role === "student" ? <StudentNavBar toggleMenu={toggleMenu} isMenuOpen={isMenuOpen}/> : <TeacherNavBar toggleMenu={toggleMenu} isMenuOpen={isMenuOpen}/>}
        <div className="contentContainer">
          {windowWidth > 768 && location.pathname !== "/calendar" && (
            <div className="calendar">
              <Calendar />
            </div>
          )}
          <div className="outlet">
            <Outlet />
          </div>
        </div>
      </div>
    </>
  )
};

export default Layout;