import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
const SignUpForm = () => {
  const Navigate=useNavigate();
  const [formData, setFormData] = useState({
    name: '',
    password: '',
    email: '',
    sponsorId: '',
    mobileNumber: '',
    packages: '',
    termsAccepted: false,
    hasAccount: false
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
      const response = await fetch('http://localhost:8080/api/signup', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        const result = await response.json();
        console.log('Success:', result);
        Navigate('/login')
        // Optionally reset the form fields after successful submission
        setFormData({
          name: '',
          password: '',
          email: '',
          sponsorId: '',
          mobileNumber: '',
          packages: '',
          termsAccepted: false,
          hasAccount: false
        });
      } else {
        console.error('Error:', response.statusText);
      }
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="form-container">
      <div className="form-wrapper">
        <h1 className="form-title">Create An Account</h1>
        <p>Enter your personal details to create an account</p>
        <form onSubmit={handleSubmit}>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />

          <label htmlFor="email">Email Address</label>
          <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
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

          <label htmlFor="sponsorId">Sponsor ID</label>
          <input
            type="text"
            id="sponsorId"
            name="sponsorId"
            value={formData.sponsorId}
            onChange={handleChange}
            required
          />

          <label htmlFor="sponsorMobile">Mobile Number</label>
          <input
            type="tel"
            id="mobileNumber"
            name="mobileNumber"
            value={formData.sponsorMobile}
            onChange={handleChange}
            required
          />

          <label htmlFor="packageOption" style={{ display: "block", textAlign: "left", margin: "10px 0 5px" }}>Packages</label>
          <select
            id="packages"
            name="packages"
            value={formData.packageOption}
            onChange={handleChange}
            required
            style={{
              width: "100%",
              padding: "10px",
              marginBottom: "20px",
              border: "1px solid #ccc",
              borderRadius: "4px",
              backgroundColor: "#fff",
              textAlign: "left",
              fontSize: "16px",
              cursor: "pointer"
            }}
          >
            <option value="" disabled>Select a package option</option>
            <option value="10">10</option>
            <option value="25">25</option>
            <option value="50">50</option>
            <option value="100">100</option>
            <option value="250">250</option>
            <option value="500">500</option>
            <option value="1000">1000</option>
            <option value="5000">5000</option>
          </select>

          <div style={{ display: "flex", alignItems: "center", marginBottom: "20px", columnCount: 2 }}>
            <input
              type="checkbox"
              id="termsAccepted"
              name="termsAccepted"
              checked={formData.termsAccepted}
              onChange={handleChange}
              required
              style={{ width: "30px", margin: "0px" }}
            />
            <label htmlFor="termsAccepted">I accept the terms and conditions</label>
          </div>

          <button type="submit">Create Account</button>

          <div className="checkbox-container">
            <label htmlFor="hasAccount">
              Already have an account? <a href="/login">Log in</a>
            </label>
          </div>
        </form>
      </div>
    </div>
  );
};

export default SignUpForm;
