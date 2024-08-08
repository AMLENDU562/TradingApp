import React from 'react';
import '../styles/Ai.css';

export default function Ai(props) {
  return (
    <div className="ai-container">
        <img src={props.img} alt={props.name} className="ai-image"/>
        <h3 className="ai-name">{props.name}</h3>
        <p className="ai-desc" style={{textAlign:"justify"}}>{props.desc}</p>
    </div>
  )
}
