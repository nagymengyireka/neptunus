import React, { Component } from 'react'
import Calendar from 'react-calendar';
import { Link, Outlet } from 'react-router-dom';

import "./Layout.css"

const Layout = () => (
  <>
    <div className='layoutHeader' style={{
      "margin": "10px",
    }}>
      <Link to={"/main"}>
        <img src='/icon_v2.png' className='img-fluid' alt='logo' style={{
          "width": "150px"
        }} />
      </Link>
      <span className='h1' style={{
        "fontFamily": "emoji"
      }}>Neptunus</span>
    </div>
    <div>
      <nav className="navbar navbar-expand-lg" style={{
        "backgroundColor": "#E1E1E1",
        "borderRadius": "10px",
        "margin": "10px",
        "padding": "10px",
        "boxShadow": "rgba(0, 0, 0, 0.35) 0px 5px 15px"
      }}>
        <ul className="navbar-nav flex-grow-1">
          <li className="nav-item" style={{
            "borderRight": "solid 1px",
            "borderColor": "#BFBFBF"
          }}>
            <a className="nav-link" href="/personal-info">
              Personal Data
            </a>
          </li>
          <li className="nav-item" style={{
            "borderRight": "solid 1px",
            "borderColor": "#BFBFBF"
          }}>
            <a className="nav-link border-right border-black" href="/taken-courses">
              Taken Courses
            </a>
          </li>
          <li className="nav-item" style={{
            "borderRight": "solid 1px",
            "borderColor": "#BFBFBF"
          }}>
            <a className="nav-link" href="/course-application">
              Course Application
            </a>
          </li>
        </ul>
        <ul className="navbar-nav mx-auto p-2">
          <li className="nav-item">
            <button className="logOutBtn" type="button">
              Log Out
            </button>
          </li>
        </ul>
      </nav>
      <div className="contentContainer">
        <div className="calendar">
          <Calendar />
        </div>
        <div className="outlet">
          <Outlet />
        </div>
      </div>
    </div>
  </>
);

export default Layout;