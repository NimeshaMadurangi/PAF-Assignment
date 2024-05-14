import React, { useState } from 'react';
import '../styles/RegistrationForm.css';
import { Link } from 'react-router-dom';
import { FaGoogle, FaFacebook, FaInstagram } from 'react-icons/fa';
import axios from 'axios'; // Import axios for making HTTP requests

const RegistrationForm = () => {
  // State variables to hold form data
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: ''
  });

  // Function to handle form field changes
  const handleInputChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Function to handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault(); // Prevent default form submission behavior
    try {
      // Make a POST request to your backend API endpoint
      const response = await axios.post('http://localhost:8080/api/users', formData);
      console.log('Registration successful:', response.data);
      // Redirect the user to the home page after successful registration
      window.location.href = '/Home';
    } catch (error) {
      console.error('Registration failed:', error);
    }
  };

  return (
    <div className='image-container'>
      <div className="registration-form">
        <h2>Register</h2>
        <form onSubmit={handleSubmit}> {/* Call handleSubmit when form is submitted */}
          <div className="form-group">
            <label htmlFor="username">Username</label>
            <input type="text" id="username" name="username" className="form-control" value={formData.username} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email</label>
            <input type="email" id="email" name="email" className="form-control" value={formData.email} onChange={handleInputChange} />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password</label>
            <input type="password" id="password" name="password" className="form-control" value={formData.password} onChange={handleInputChange} />
          </div>
          <button type="submit" className="btn btn-primary submit-btn">Register</button>
          <div className="social-login">
            <p>Or</p>
            <div className="social-icons">
              <FaGoogle className="social-icon" />
              <FaFacebook className="social-icon" />
              <FaInstagram className="social-icon" />
            </div>
          </div>
          <p className="login-text">Already have an account? <Link to='/LoginForm'> Login </Link></p>
        </form>
      </div>
    </div>
  );
};

export default RegistrationForm;
