import { useEffect, useState } from "react";
import Modal from 'react-bootstrap/Modal';

async function fetchStudents(id) {
    const response = await fetch(`/api/courses/${id}/students`);
    const data = await response.json();
    return data;
}

function CourseInfo({ course, onClose }) {
    const [students, setStudents] = useState(null);

    useEffect(() => {
        fetchStudents(course.id)
            .then((data) => {
                setStudents(data);
            })
    }, [course])

    if (students && course) {
        return (
            <Modal show={course}>
                <Modal.Header closeButton onClick={() => onClose(null)}>
                    <Modal.Title>{course.name} Information</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                <h5>Teacher: {course.teacherName}</h5>
                        <table>
                            <thead>
                                <tr>
                                    <td>Students</td>
                                    <td/>
                                </tr>
                            </thead>
                            <tbody>
                                {students.map((student) => (
                                    <tr key={student.studentId}>
                                        <td>{student.firstName}</td>
                                        <td>{student.lastName}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                </Modal.Body>
            </Modal>
        );
    }
}

export default CourseInfo;