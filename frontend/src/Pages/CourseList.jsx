import { useEffect } from "react";
import { useState } from "react";
import CourseTable from "./Components/CourseTable";

async function fetchStudentCourses() {
    try {
        const response = await fetch("/api/students/M6Z1H8/courses");
        const data = await response.json();
        console.log(data);
        return data;
    } catch (error) {
        console.error(error);
    }
}

async function leaveCourse(courseId) {
    try {
        const response = await fetch(`/api/courses/${courseId}/students/M6Z1H8`, {method: "DELETE"});
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
            return courses.filter((course) => course.courseId !== id)
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
            <CourseTable courses={courses} onLeave={handleLeave}/>
        )
    }
}

export default CourseList;