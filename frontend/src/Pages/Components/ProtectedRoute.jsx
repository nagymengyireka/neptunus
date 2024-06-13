import React from 'react'
import { Navigate } from 'react-router-dom'

const ProtectedRoute = ({element: Element, ...rest}) => {
  const token = localStorage.getItem('jwt');
  const isAuthenticated = token && token !== 'undefined' && token !== 'null';
  
  return isAuthenticated ? <Element {...rest} /> : <Navigate to="/login" />;
}

export default ProtectedRoute