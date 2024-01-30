import { useState } from "react";
import { Navigation } from './Navigation';
import { Homepage } from './Homepage';
import { Store } from './Store';
import { PurchaseSummary } from './PurchaseSummary';
import { UserInfo } from './UserInfo';
import { UploadCSV } from './UploadCSV';
import '../css/navBar.css';

export const MainView = (props) => {

    const [currentForm, setCurrentForm] = useState('homepage');

    const toggleForm = (formName) => {
        setCurrentForm(formName);
    }
    return (
        <>
            <div className="navBar">
                <Navigation onFormSwitch={toggleForm}></Navigation>
            </div>
            <div>
                {
                    (() => {
                        switch (currentForm) {
                            case 'homepage':
                                return <Homepage></Homepage>;
                            case 'store':
                                return <Store></Store>;
                            case 'purchaseSummary':
                                return <PurchaseSummary></PurchaseSummary>
                            case 'userInfo':
                                return <UserInfo></UserInfo>;
                            case 'uploadCSV':
                                return <UploadCSV></UploadCSV>
                            default:
                                return props.onViewSwitch('loginView') ;
                        }
                    })()
                }
            </div>
        </>  
    )}