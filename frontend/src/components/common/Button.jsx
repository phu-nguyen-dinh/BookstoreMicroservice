import React from "react";
import "../../styles/components/Button.scss"

const Button = ({ text, onClick, className = "", disabled = false }) => {
  return (
    <button
      className={`custom-button ${className}`}
      onClick={onClick}
      disabled={disabled}
    >
      {text}
    </button>
  );
}