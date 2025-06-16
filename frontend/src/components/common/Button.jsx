import React from 'react';

const Button = ({ label, onClick, variant, icon }) => {
  return (
    <button className={`btn ${variant}`} onClick={onClick}>
      {icon && <span>{icon}</span>}
      {label}
    </button>
  );
};

export default Button;
