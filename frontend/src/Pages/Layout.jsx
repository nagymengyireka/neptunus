import React, { Component } from 'react'
import { Link, Outlet } from 'react-router-dom';

import "./Layout.css"


const Layout = () => (
<div>
  <nav className="navbar navbar-expand-lg bg-body-tertiary">
    <ul className="navbar-nav flex-grow-1">
      <li className="nav-item">
        <a className="nav-link" href="/personal-info">
          Personal Data
        </a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="/applied-courses">
          Taken Courses
        </a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="/course-application">
          Course Application
        </a>
      </li>
    </ul>
    <ul className="navbar-nav mx-auto p-2">
      <li className="nav-item">
        <button className="btn btn-outline-success" type="button">
          Log Out
        </button>
      </li>
    </ul>
  </nav>
  <Outlet />
</div>

);

export default Layout;