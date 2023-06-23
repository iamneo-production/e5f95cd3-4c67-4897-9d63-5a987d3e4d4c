import axios from 'axios';

const API_BASE_URL = "http://localhost:8080/api"; // Replace with your API base URL

export const createPayment = async (paymentData) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/payments`, paymentData);
    return response.data;
  } catch (error) {
    throw new Error(error.response.data.message);
  }
};

// Add more functions as needed for updating, deleting, or retrieving payment data
