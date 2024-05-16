import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';

const fetchStudent = async (id) => {
  const res = await fetch(`/api/students/${id}`);
  return await res.json();
}

const UserData = () => {
  const [student, setStudent] = useState(null);


  useEffect(() => {
    fetchStudent("86Y48E")
      .then((student) => {
        console.log(student)
        setStudent(student)
      })
  }, [])

  return (
    <div className='studentData'>
      <table className='table table-striped table-hover'>
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