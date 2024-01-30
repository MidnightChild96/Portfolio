import { useState } from "react";
import { Login } from "./Login";
import { Register } from "./Register";

export const LoginView = (props) => {

    const [currentForm, setCurrentForm] = useState('loginView');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }
    return (
        <>
            <div>
                {
                    (() => {
                        switch (currentForm) {
                            case 'register':
                                return <Register onFormSwitch={toggleForm}></Register>;
                            case 'mainView':
                                return props.onViewSwitch('mainView');
                            default:
                                return <Login onFormSwitch={toggleForm}></Login>;
                        }
                    })()
                }
            </div>
        </>
    )
}