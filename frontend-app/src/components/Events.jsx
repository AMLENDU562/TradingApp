import React from 'react';
import '../styles/Event.css'; // Import the CSS file for styling

export default function Events(props) {
  return (
    <div className="image-container" style={{margin:"20px"}}>
      <img src={props.img} alt={props.name} className="event-image" />
      <div className="image-text">{props.name}</div>
    </div>
  );
}
