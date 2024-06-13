import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from './Layout/Layout.jsx';
import UserData from './Pages/UserData.jsx';
import CourseApplication from './Pages/CourseApplication.jsx';
import CourseList from './Pages/CourseList.jsx';
import Calendar from 'react-calendar';
import MainPage from './Pages/MainPage.jsx';
import LoginPage from './Pages/LoginPage.jsx';
import LoginLayout from './Layout/LoginLayout.jsx';
import RegisterStudent from './Pages/RegisterStudent.jsx';
import RegisterTeacher from './Pages/RegisterTeacher.jsx';
import ProtectedRoute from "./Pages/Components/ProtectedRoute.jsx";


function App() {

  return (
    <Routes >
      <Route element={<LoginLayout />}>›
        <Route path="/login" element={<LoginPage />} />
      </Route>

      <Route path='/register' element={<RegisterStudent />} />
      <Route path='/register/teacher' element={<RegisterTeacher />} />

      <Route element={<ProtectedRoute element={Layout} />}>  
        <Route path="/main" element={<MainPage />} />
        <Route path="/personal-info" element={<UserData />} />
        <Route path="/course-application" element={<CourseApplication />} />
        <Route path="/taken-courses" element={<CourseList />} />
        <Route path="/calendar" element={<Calendar />} />
      </Route>
    </Routes>
  )
}

export default App;