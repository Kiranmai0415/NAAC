import React from 'react';
import { useHistory } from 'react-router-dom';
import AuthService from './services/auth.service';
import Outer from '../../Templates/Outer';

const Logout = () => {
  const history = useHistory();
  const logout = () => {
    // AuthService.logout();
    history.push('app/login');
    window.location.reload();
  };
  return (
    <Outer>
      {logout}
    </Outer>
  );
};

export default Logout;
