import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from "react";

export const Navigation = (props) => {

    const [currentForm, setCurrentForm] = useState('login');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }

    return (
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <button onClick={() => props.onFormSwitch('homepage')}>Homepage</button>
                        <button onClick={() => props.onFormSwitch('store')}>Store</button>
                        <button onClick={() => props.onFormSwitch('purchaseSummary')}>Purchase Summary</button>
                        <button onClick={() => props.onFormSwitch('userInfo')}>User Information</button>
                        <button onClick={() => props.onFormSwitch('uploadCSV')}>Upload CSV</button>
                        <button onClick={() => props.onFormSwitch('loginView')}>Sign Out</button>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
}