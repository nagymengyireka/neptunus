/* eslint-disable react/prop-types */
function CourseTable({courses, onLeave}) {
    return (
        <table>
            <thead>
                <tr>
                    <th>Course</th>
                    <th>Teacher</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                {courses.map((course) => (
                    <tr key={course.courseId}>
                        <td>{course.name}</td>
                        <td>{course.teacherName}</td>
                        <td>
                            <button>+</button> {/* more info and leave button in a modal */}
                            <button onClick={() => onLeave(course.courseId)}>-</button> {/* leave course button - works */}
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    )
}

export default CourseTable;