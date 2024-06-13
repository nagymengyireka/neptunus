import React, { Component, useState, useEffect } from 'react'
import Calendar from 'react-calendar';
import { Link, Outlet, useLocation } from 'react-router-dom';

import "./Layout.css"
import StudentNavBar from './StudentNavBar';
import TeacherNavBar from './TeacherNavBar';

const Layout = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const [windowWidth, setWindowWidth] = useState(window.innerWidth);
  const role = localStorage.getItem('roles')

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
        {role === "ROLE_STUDENT" ? <StudentNavBar windowWidth={windowWidth} toggleMenu={toggleMenu} isMenuOpen={isMenuOpen}/> : <TeacherNavBar windowWidth={windowWidth} toggleMenu={toggleMenu} isMenuOpen={isMenuOpen}/>}
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