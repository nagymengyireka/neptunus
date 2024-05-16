import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';


const getCourseURL = (courseId) => `/api/courses/${courseId}`;
const addStudentToCourseURL = (courseId, studentId) => `/api/courses/${courseId}/students/${studentId}`;
const STUDENT_ID = "OH3847"; 


function CourseModal({ onCourseId, onClose }) {
    const [course, setCourse] = useState();

    const saveApplication = (courseId, studentId)=>{
        addStudentToCourse(courseId, studentId);
        onClose(null)
    }

    const addStudentToCourse = async (courseId, studentId) => {
        const addStudent = await fetch(addStudentToCourseURL(courseId, studentId), {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
        })
        const response = await addStudent.json();
        return response;
      };

    useEffect(() => {
       
        const fetchData = async () => {
            try {
                const response = await fetch(getCourseURL(onCourseId));
                const responseData = await response.json()
                setCourse(responseData)
                console.log(responseData)
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }

        fetchData()
    }, [])

    return (
        <div className='szia'>
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
                                </tr>
                            </thead>
                            <tbody>
                                {course.students && course.students.map((student, index) => (
                                    <tr key={index}>
                                        <td>{student.name}</td>
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