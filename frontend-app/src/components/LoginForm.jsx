import React, { useState } from 'react';
import '../FormStyles.css';
import { useNavigate } from 'react-router-dom';

const LogInForm = () => {
  const nav = useNavigate();
  const [formData, setFormData] = useState({
    sponsorId: '',
    password: '',
    termsAccepted: false
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    const val = type === 'checkbox' ? checked : value;
    setFormData({
      ...formData,
      [name]: val
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const result = await response.json();
        console.log('Login successful:', result);
        // Navigate to the next page after successful login
        
        if(result===true)
          nav('/dashboard');
        else
          console.log("unsuccesfull!!") // Update the path to where you want to redirect after login
      } else {
        console.error('Login failed:', response.statusText);
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  return (
    <div className="form-container">
      <div className="form-wrapper">
        <form onSubmit={handleSubmit}>
          <label htmlFor="sponsorId">Referral ID</label>
          <input
            type="text"
            id="sponsorId"
            name="sponsorId"
            value={formData.sponsorId}
            onChange={handleChange}
            required
          />

          <label htmlFor="password">Password</label>
          <input
            type="password"
            id="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            required
          />
          
          <div style={{ display: "flex", alignItems: "center", marginBottom: "20px", columnCount: 2 }}>
            <input
              type="checkbox"
              id="termsAccepted"
              name="termsAccepted"
              checked={formData.termsAccepted}
              onChange={handleChange}
              style={{ width: "30px", margin: "0px" }}
            />
            <label htmlFor="termsAccepted">Remember Me</label>
          </div>

          <button type="submit">Log In</button>
          
          <div className="account-link">
            <label htmlFor="hasAccount">Don't have an account? <a className="link" href="/signup">Create Account</a></label>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LogInForm;
