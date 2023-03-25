import axios from 'axios';

const API_URL = 'http://localhost:8080/api/test/';

const getPublicContent = () => axios.get(API_URL + 'all');

const getUserBoard = () => axios.get(API_URL + 'user');

const getModeratorBoard = () => axios.get(API_URL + 'mod');

const getAdminBoard = () => axios.get(API_URL + 'admin');

const UserService = {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
};

export default UserService;