import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';


const getCourseURL = (courseId) => `/api/courses/${courseId}`;
const addStudentToCourseURL = (courseId, studentId) => `/api/courses/${courseId}/students/${studentId}`;
const getCourseStudentsURL = (courseId) => `/api/courses/${courseId}/students`;
const STUDENT_ID = "2"; 


function CourseModal({ onCourseId, onClose }) {
    const [course, setCourse] = useState(null);
    const [courseStudents, setCourseStudents] = useState(null);

    const saveApplication = (courseId, studentId)=>{
        addStudentToCourse(courseId, studentId);
        onClose(null)
    }

    const addStudentToCourse = async (courseId, studentId) => {
        try {
            const addStudent = await fetch(addStudentToCourseURL(courseId, studentId), {
                method: "POST",
                headers: {
                  "Content-Type": "application/json",
                },
              })
              const response = await addStudent.json();
              return response;
        } catch (error) {
            return error
        }

      };

    useEffect(() => {
       
        const fetchData = async (url) => {
            try {
                const response = await fetch(url);
                const responseData = await response.json()
                console.log(responseData)
               return responseData;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }
        
        const fetchCourseData = async () => {
            const data = await fetchData(getCourseURL(onCourseId))
            setCourse(data)
        }

        const fetchCourseStudentsData = async () => {
            const data = await fetchData(getCourseStudentsURL(onCourseId))
            setCourseStudents(data)
        }
        


        fetchCourseData()
        fetchCourseStudentsData()
    }, [onCourseId])

    return (
        <div>
            {course && <div
                className="modal show"
                style={{ display: 'block', position: 'initial' }}
            >
                <Modal show={course}  >
                    <Modal.Header closeButton onClick={() => onClose(null)}>
                        <Modal.Title>{course.name}</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <p>Teacher: {course.teacherName}</p>
                        <table>
                            <thead>
                                <tr>
                                    <td>Students</td>
                                    <td/>
                                </tr>
                            </thead>
                            <tbody>
                                {courseStudents && courseStudents.map((student, index) => (
                                    <tr key={index}>
                                        <td>{student.lastName}</td>
                                        <td>{student.firstName}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={() => onClose(null)}>
                            Close
                        </Button>
                        <Button variant="primary" onClick={()=> saveApplication(onCourseId, STUDENT_ID)}>
                            Application
                        </Button>
                    </Modal.Footer>
                </Modal>
            </div>}
        </div>

    );
}

export default CourseModal;