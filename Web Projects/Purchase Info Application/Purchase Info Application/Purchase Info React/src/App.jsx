import { useState } from "react";
import './App.css';
import { LoginView } from "./components/LoginView";
import { MainView } from "./components/MainView";

function App() {
    const [currentView, setCurrentView] = useState('loginView');

    const toggleView = (viewName) => {
        setCurrentView(viewName);
    }

    return (
        <div className="App">
            {
                (() => {
                    switch (currentView) {
                        case "mainView":
                            return <MainView onViewSwitch={toggleView}></MainView>
                        default:
                            return <LoginView onViewSwitch={toggleView}></LoginView>
                    }
                })()
               }
        </div>
    );
}

export default App
