import React, { Component } from 'react'
import { Link } from 'react-router-dom';

const Layout = () => (
  <div className='layout'>
    <ul>
      <li>
        <Link to='/personal-info'>Personal Info</Link>
      </li>
      <li>
        <Link to="/assigned-courses">Taken Courses</Link>
      </li>
      <li>
        <Link to="/course-application">Course Application</Link>
      </li>
      <li>
        <button type='button'>Log Out</button>
      </li>
    </ul>
  </div>
);

export default Layout;