/* eslint-disable react/prop-types */
function CourseTable({courses, onLeave}) {
    return (
        <table className='table table-striped table-hover '>
            <thead>
                <tr>
                    <th>Course</th>
                    <th>Teacher</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {courses.map((course) => (
                    <tr key={course.id}>
                        <td>{course.name}</td>
                        <td>{course.teacherName}</td>
                        <td>
                            <button>+</button> {/* more info and leave button in a modal */}
                            <button onClick={() => onLeave(course.id)}>-</button> {/* leave course button - works */}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}

export default CourseTable;