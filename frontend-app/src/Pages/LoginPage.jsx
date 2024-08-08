// src/pages/LoginPage.js
import React from 'react';
import LoginForm from '../components/LoginForm';
import '../FormStyles.css';

const LoginPage = () => {
  const handleLogin = (values) => {
    console.log('Login:', values);
    // Add authentication logic here
  };

  return (
    <div className="form-container">
      <div className="form-wrapper">
        <h1 className="form-title">Login</h1>
        <LoginForm onSubmit={handleLogin} />
      </div>
    </div>
  );
};

export default LoginPage;
