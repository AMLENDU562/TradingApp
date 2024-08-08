import React from 'react';
import { Link } from 'react-router-dom';
import '../styles/Header.css';
import Logo from '../images/logo.jpg'

function Header() {
  return (
    <header className="header">
      <div className="logo" style={{display:"flex"}}>
        <img src={Logo} alt="GT Broker" />
        <h2 style={{color:"black"}}>GTB</h2>
      </div>
      <div className="nav-container">
        <nav>
          <ul className="nav-list">
            <li><Link to="/" className="nav-link">Home</Link></li>
            <li><Link to="/about" className="nav-link">About</Link></li>
            <li><Link to="/contact" className="nav-link">Contact</Link></li>
          </ul>
        </nav>
      </div>
    </header>
  );
}

export default Header;
