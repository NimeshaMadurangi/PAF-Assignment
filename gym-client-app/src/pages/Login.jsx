import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import '../styles/LoginForm.css';

const LoginForm = ({ history }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    
    // Validation: Check if username and password are not empty
    if (!username || !password) {
      setError('Please enter both username and password.');
      return;
    }

    // Your login logic
    if (username === 'Nimesha' && password === '1999') {
      // Redirect to the '/WorkoutPlanList' route upon successful login
      history.push('/WorkoutPlanList');
    } else {
      setError('Invalid username or password');
    }
  };

  return (
    <div className="login-form">
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="username">Username</label>
          <input
            type="text"
            id="username"
            name="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        {error && <div className="error">{error}</div>}
        <Link to="/Home">
          <button type="submit" className="btn btn-primary">Login</button>
        </Link>
      </form>
    </div>
  );
};

export default LoginForm;
