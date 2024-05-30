import 'bootstrap/dist/css/bootstrap.min.css'
import CourseModal from './Components/CourseModal';
import { useEffect, useState } from 'react';


const getCoursesURL = `/api/courses/`

function CourseApplication() {
    const [courses, setCourses] = useState([]);
    const [showModalCourseId, setShowModalCourseId] = useState(null);

    const handleClose = () => setShowModalCourseId()

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(getCoursesURL);
                const responseData = await response.json()
                setCourses(responseData)
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }

        fetchData()
    }, [])

    return (
        <div>
            <div>
                <table className="table table-striped table-hover">
                    <thead>
                        <tr>
                            <td>Name</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        {courses && courses.map((course, index) => (
                            <tr key={index}>
                                <td>{course.name}</td>

                                <td><button onClick={() => setShowModalCourseId(course.id)}>+</button></td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            <div>
                {showModalCourseId != null && <CourseModal onCourseId={showModalCourseId} onClose={handleClose} />}
            </div>
        </div>
    );
}

export default CourseApplication;