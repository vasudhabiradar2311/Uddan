// UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8900/users';  // Replace with your API endpoint

// Fetch all users
const getUsers = () => {
  return axios.get(API_URL);
};

// Fetch a user by their ID
const getUserById = (userId) => {
  return axios.get(`${API_URL}/${userId}`);
};

// ➕ ADD THIS NEW FUNCTION FOR SIGN UP
const addUser = (userData) => {
  return axios.post(API_URL, userData);
};

// ➕ ADD 'addUser' TO THE EXPORT OBJECT AT THE BOTTOM
export default {
  getUsers,
  getUserById,
  addUser, 
};
