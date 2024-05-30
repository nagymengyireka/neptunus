import { useEffect } from "react";
import { useState } from "react";
import CourseTable from "./Components/CourseTable";

async function fetchStudentCourses() {
    try {
        const response = await fetch("/api/students/2/courses");
        const data = await response.json();
        console.log(data);
        return data;
    } catch (error) {
        console.error(error);
    }
}

async function leaveCourse(courseId) {
    try {
        const response = await fetch(`/api/courses/${courseId}/students/2`, {method: "DELETE"});
        const data = await response.json();

        return data;
    } catch (error) {
        console.error(error);
    }
}

function CourseList() {
    const [courses, setCourses] = useState(null);

    const handleLeave = (id) => {
        leaveCourse(id);

        setCourses((courses) => {
            return courses.filter((course) => course.id !== id)
        });
    }

    useEffect(() => {
        fetchStudentCourses()
            .then((courses) => {
                setCourses(courses);
            })
    }, [])

    if (courses) {
        return (
            <div>
                <h2 className='page-title'>My Courses</h2>
                <CourseTable courses={courses} onLeave={handleLeave}/>
            </div>
        )
    }
}

export default CourseList;