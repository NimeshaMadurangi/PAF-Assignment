import React, { useState } from 'react';
import { Link } from 'react-router-dom'; // Import Link from react-router-dom
import '../styles/Splash.css';

const Splash = () => {

  const [error, setError] = useState('');
  const handleGoogleLogin = async () => {
    try {
      window.location.href = "http://localhost:8083/oauth2/authorization/google";
    } catch (error) {
      console.error('Google authentication error:', error);
      setError('Failed to initiate Google authentication. Please try again.');
    }
  };
  return (
    <div className="splash-container">
      <div className="content">
        <h1>Welcome to Vector Gym</h1>
        {/* Use Link component instead of a regular button */}
        <Link to="/LoginForm">
          <button>Login</button>
        </Link>
        <Link to="/Register">
          <button>Register</button>
        </Link>
        <p>Feel free to explore!</p>
       
      <button onClick={handleGoogleLogin} className="btn btn-primary">
        Sign in with Google
      </button>
      {error && <div className="error">{error}</div>}
      </div>
    </div>
    
  );
};

export default Splash;