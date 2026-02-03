import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api";

export const loginUser = async (email, password) => {
  const response = await axios.post(`${API_BASE_URL}/auth/login`, {
    email: email,
    password: password,
  });
  return response.data; // JWT token
};