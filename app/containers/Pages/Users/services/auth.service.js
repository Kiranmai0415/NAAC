import axios from 'axios';
import {resources} from '../../../appConstants'

//const API_URL = 'http://localhost:8080/api/auth/';
const API_URL = resources.AUTHORIZE_URL;

const register = (username, email, password, role, instituteType, eamcetCode, collegeName) => axios.post(API_URL + 'signup', {
  username,
  email,
  password,
  role,
  instituteType,
  eamcetCode,
  collegeName,
});

const login = (username, password) => axios.post(API_URL + 'signin', {
  username,
  password,
})
  .then((response) => {
    if (response.data.username) {
      localStorage.setItem('user', JSON.stringify(response.data));
    }
    return response.data;
  });

const logout = () => {
  localStorage.removeItem('user');
  // return axios.post(API_URL + 'signout').then((response) => response.data);
};

const getCurrentUser = () => JSON.parse(localStorage.getItem('user'));

const AuthService = {
  register,
  login,
  logout,
  getCurrentUser,
};

export default AuthService;
