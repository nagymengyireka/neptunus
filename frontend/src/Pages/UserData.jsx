import React, { useEffect, useState } from 'react'
import Loading from './Loading';

const fetchStudent = async (id) => {
  try {
    const res = await fetch(`/api/students/${id}`);
    return await res.json();
  } catch (error) {
    console.error("Error fetching student data: ", error)
  }
}

const UserData = () => {
  const [student, setStudent] = useState(null);
  const [loading, setLoading] = useState(true);


  useEffect(() => {
    fetchStudent("86Y48E")
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
        <table className='table table-striped table-hover '>
          <tbody>
            <tr>
              <th>Student ID</th>
              <td>{student && student.studentId}</td>
            </tr>
            <tr>
              <th>First Name</th>
              <td>{student && student.firstName}</td>
            </tr>
            <tr>
              <th>Last Name</th>
              <td>{student && student.lastName}</td>
            </tr>
            <tr>
              <th>Date of Birth</th>
              <td>{student && student.dateOfBirth}</td>
            </tr>
            <tr>
              <th>Gender</th>
              <td>{student && student.gender}</td>
            </tr>
          </tbody>
        </table>
      </div>
    )
}

export default UserData;