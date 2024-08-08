// src/pages/SignupPage.js
import React from 'react';
import SignupForm from '../components/SignupForm';
import '../FormStyles.css';

const SignupPage = () => {
  const handleSignup = (values) => {
    console.log('Signup:', values);
    // Add registration logic here
  };

  return (
    <div className="form-container">
      <div className="form-wrapper">
        <SignupForm onSubmit={handleSignup} />
      </div>
    </div>
  );
};

export default SignupPage;
