import React, { useEffect, useState } from 'react'
import Loading from './Loading';
import "./UserData.css"

const fetchStudent = async (id) => {
  try {
    const res = await fetch(`/api/students/${id}`, {
      headers: {"authorization": `Bearer ${localStorage.getItem('jwt')}`}
    });
    return await res.json();
  } catch (error) {
    console.error("Error fetching student data: ", error)
  }
}

const UserData = () => {
  const [student, setStudent] = useState(null);
  const [loading, setLoading] = useState(true);


  useEffect(() => {
    fetchStudent("1")
      .then((student) => {
        console.log(student)
        setStudent(student)
        setLoading(false)
      })
  }, [])

  return loading ?
    <Loading />
    : (
      <div className='studentData'>
        <h2 className='page-title'>Personal Data</h2>
        <div className='student-page-table-container'>
          <div className='student-page-table-header-container'>
            <div className='student-page-table-header'>{student && student.firstName + " " + student.lastName}</div>
          </div>
          <table className='student-page-table'>
            <tbody className='student-page-table-body'>
              <tr>
                <th className="student-data-th_size">Student ID</th>
                <td>{student && student.studentId}</td>
              </tr>
              <tr>
                <th className="student-data-th_size">First Name</th>
                <td>{student && student.firstName}</td>
              </tr>
              <tr>
                <th className="student-data-th_size">Last Name</th>
                <td>{student && student.lastName}</td>
              </tr>
              <tr>
                <th className="student-data-th_size">Date of Birth</th>
                <td>{student && student.dateOfBirth}</td>
              </tr>
              <tr>
                <th className="student-data-th_size">Gender</th>
                <td>{student && student.gender}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    )
}

export default UserData;