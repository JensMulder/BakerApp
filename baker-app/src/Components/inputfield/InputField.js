import React from "react";
import "./../../Styles/Component_styles/InputFeild.css"

function InputField({
  children,
  type,
  id,
  value,
  onChange,
  placeholder,
  className,
  accept,
}) {
  return (
    <>
      <div className="input-item__container">
        <label htmlFor={id}>{children}</label>
        <input
          style={{
            border: "1px solid rgb(141, 139, 139)",
          }}
          className={className}
          type={type}
          id={id}
          value={value}
          placeholder={placeholder}
          accept={accept}
          onChange={onChange}
        />
      </div>
    </>
  );
}
export default InputField;
