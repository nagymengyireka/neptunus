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
            <div className='table-container'>
                        <div className='courses-table-header-container'>
                            <div className='courses-table-header'>Courses</div>
                        </div>
                <table className="table table-striped table-hover">
                    <tbody className='courses-table-container'>
                        {courses && courses.map((course, index) => (
                            <tr key={index}>
                                <td className="course-data-size">{course.name}</td>
                                <td className="table-buttons">
                                    <button onClick={() => setShowModalCourseId(course.id)}>+</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {
                showModalCourseId != null &&
                <div className='modal-container'>
                    <div className='modal-content'>
                        <CourseModal onCourseId={showModalCourseId} onClose={handleClose} />
                    </div>
                </div>
            }
        </div >
    );
}

export default CourseApplication;