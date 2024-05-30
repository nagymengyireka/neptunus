/* eslint-disable react/prop-types */
function CourseTable({ courses, onLeave }) {
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
                        <tr key={course.courseId}>
                            <td>{course.name}</td>
                            <td>{course.teacherName}</td>
                            <td className="table-buttons">
                                <button>+</button>
                                <button onClick={() => onLeave(course.id)}>-</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default CourseTable;