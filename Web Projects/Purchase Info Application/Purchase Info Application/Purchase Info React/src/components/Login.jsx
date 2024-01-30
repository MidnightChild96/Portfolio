import { useState } from "react";
import PropTypes from "prop-types";

export const Login = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
    }
    return (
        <div className="auth-form-container">
            <form className="login-form" onSubmit={ handleSubmit }>
                <label htmlFor="email">Email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)} type="mail" placeholder="youremail@gmail.com" id="email" name="email"></input>
                <label htmlFor="password">Password</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)} type="password" placeholder="*****" id="password" name="password"></input>
                <button onClick={() => props.onFormSwitch('mainView')}>Log In</button>
            </form>
            <button className="link-btn" onClick={() => props.onFormSwitch('register')}>Don't have an account? Register</button>
        </div>
    )
}

Login.propType = {
    props: PropTypes.string
}