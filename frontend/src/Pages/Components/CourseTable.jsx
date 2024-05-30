import { useState } from "react";

/* eslint-disable react/prop-types */
function CourseTable({ courses, onLeave }) {
    const [visibleDropdown, setVisibleDropdown] = useState(null);

    const handleToggle = (courseId) => {
        setVisibleDropdown(visibleDropdown === courseId ? null : courseId);
    }

    return (
        <div className='table-container'>
            <div className='courses-table-header-container'>
                <div className='courses-table-header'>Courses</div>
            </div>
            <table className='table table-striped table-hover'>
                <thead>
                    <tr>
                        <th>Course</th>
                        <th>Teacher</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {courses.map((course) => (
                        <tr key={course.id}>
                            <td>{course.name}</td>
                            <td>{course.teacherName}</td>
                            <td className="table-buttons">
                                <button onClick={() => handleToggle(course.id)}>
                                    {visibleDropdown === course.id ? '-' : '+'}
                                </button>
                                {visibleDropdown === course.id && (
                                    <div className="dropdown-menu show">
                                        <button className="dropdown-item">Course Info</button>
                                        <button className="dropdown-item" onClick={() => onLeave(course.id)}>Leave Course</button>
                                    </div>
                                )}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default CourseTable;