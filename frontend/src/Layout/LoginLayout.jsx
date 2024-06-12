import { Outlet } from 'react-router-dom';

const LoginLayout = () => {
    return (
        <div className="h-full bg-white">
          <div className="h-full flex items-center justify-center">
            <Outlet />
          </div>
        </div>
      );
  };
  
  export default LoginLayout;