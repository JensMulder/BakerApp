import React from 'react';
import  '../../Styles/Component_styles/Button.css';

// Made some properties for presentational button component

export const Button = ({ size, children, color, ...other }) => {
    size = size ? size : 'medium';

    return (
        <button className={`btn btn--${size} btn--${color}`} {...other}>
            {children}
        </button>
    )
}