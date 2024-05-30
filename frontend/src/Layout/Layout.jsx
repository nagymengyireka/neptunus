import React, { Component, useState, useEffect } from 'react'
import Calendar from 'react-calendar';
import { Link, Outlet, useLocation } from 'react-router-dom';

import "./Layout.css"

const Layout = () => {
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
        <img src='/Neptunus.png' className='img-fluid' alt='logo' />
      </div>
      <div>
        <nav className="navbar navbar-expand-lg navbar-light" style={{
          backgroundColor: "#E1E1E1",
          borderRadius: "10px",
          margin: "10px",
          padding: "10px",
          boxShadow: "rgba(0, 0, 0, 0.35) 0px 5px 15px"
        }}>
          <button className="navbar-toggler" type="button" onClick={toggleMenu}>
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className={`collapse navbar-collapse ${isMenuOpen ? 'show' : ''}`} id="navbarNav">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item" style={{ borderRight: "solid 1px", borderColor: "#BFBFBF" }}>
                <a className="nav-link" href="/personal-info">Personal Data</a>
              </li>
              <li className="nav-item" style={{ borderRight: "solid 1px", borderColor: "#BFBFBF" }}>
                <a className="nav-link" href="/taken-courses">My Courses</a>
              </li>
              <li className="nav-item" style={{ borderRight: "solid 1px", borderColor: "#BFBFBF" }}>
                <a className="nav-link" href="/course-application">Course Application</a>
              </li>
              {windowWidth < 768 && (
                <li className="nav-item" style={{ borderRight: "solid 1px", borderColor: "#BFBFBF" }}>
                  <a className="nav-link" href="/calendar">Calendar</a>
                </li>
              )}
            </ul>
            <ul className="navbar-nav ms-auto p-2">
              <li className="nav-item">
                <button className="logOutBtn" type="button">Log Out</button>
              </li>
            </ul>
          </div>
        </nav>
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