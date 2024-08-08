import React, { useState } from 'react';
import '../FormStyles.css';

const LogInForm = () => {
  const [formData, setFormData] = useState({
    id: '',
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

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic here, e.g., send data to backend or perform validation
    console.log(formData);
    // Reset form fields after submission if needed
    setFormData({
      id: '',
      password: '',
      termsAccepted: false
    });
  };

  return (
    <div className="form-container">
      <div className="form-wrapper">
        <form onSubmit={handleSubmit}>
          <label htmlFor="id">Referral ID</label>
          <input
            type="text"
            id="id"
            name="id"
            value={formData.id}
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
         <div style={{ display: "flex", alignItems: "center", marginBottom: "20px",columnCount:2 }}>
                <input
                    type="checkbox"
                    id="termsAccepted"
                    name="termsAccepted"
                    checked={formData.termsAccepted}
                    onChange={handleChange}
                    required
                    style={{ width:"30px",margin:"0px" }}
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
