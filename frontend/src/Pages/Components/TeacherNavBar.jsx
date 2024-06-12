import React from 'react'

function TeacherNavBar({toggleMenu, isMenuOpen}) {
  return (
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
            <a className="nav-link" href="???">My Courses</a>
          </li>
          <li className="nav-item" style={{ borderRight: "solid 1px", borderColor: "#BFBFBF" }}>
            <a className="nav-link" href="???">Course Creation</a>
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
  )
}

export default TeacherNavBar