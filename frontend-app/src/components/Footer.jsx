import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faTwitter } from '@fortawesome/free-brands-svg-icons';

function Footer() {
  return (
    <footer style={{ marginTop: "50px", textAlign: "center", padding: "20px", backgroundColor: "#333", color: "#fff" }}>
      <p>&copy; Copyright 2024 GTB. All rights reserved.</p>
      <div style={{ marginTop: "10px" }}>
        <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer" style={{ margin: "0 10px", color: "#fff" }}>
          <FontAwesomeIcon icon={faFacebook} size="2x" />
        </a>
        <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer" style={{ margin: "0 10px", color: "#fff" }}>
          <FontAwesomeIcon icon={faTwitter} size="2x" />
        </a>
      </div>
    </footer>
  );
}

export default Footer;
