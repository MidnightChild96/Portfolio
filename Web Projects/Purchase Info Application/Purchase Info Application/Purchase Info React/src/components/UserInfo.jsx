import { useState, useEffect } from 'react';
import '../css/table.css';
import { config } from "../config";

export const UserInfo = () => {
    const [data, setData] = useState([]);

    useEffect(() => {
        fetch(config.baseurl + `UserInfo`)
            .then((resp) => resp.json())
            .then((data) => setData(data))
    }, []);

    return (
        <div>
            <>
            </>
            <table className="tableView">
                <tr>
                    <th>Password</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone</th>
                    <th>Shipping Address</th>
                    <th>Shipping City</th>
                    <th>Shipping Country</th>
                    <th>Card Number</th>
                    <th>Card Type</th>
                    <th>Billing Address</th>
                    <th>Billing City</th>
                    <th>Billing Country</th>
                </tr>
                {
                    console.log(data)
                    //data.map((user) => {
                    //    return <tr key={user.id}>
                    //        <td>
                    //            {user.password}
                    //        </td>
                    //        <td>
                    //            {user.firstName}
                    //        </td>
                    //        <td>
                    //            {user.lastName}
                    //        </td>
                    //        <td>
                    //            {user.phone}
                    //        </td> 
                    //        <td>
                    //            {user.shippingAddress}
                    //        </td>
                    //        <td>
                    //            {user.shippingCity}
                    //        </td>
                    //        <td>
                    //            {user.cardNumber}
                    //        </td>
                    //        <td>
                    //            {user.cardType}
                    //        </td>
                    //        <td>
                    //            {user.billingAddress}
                    //        </td>
                    //        <td>
                    //            {user.billingCity}
                    //        </td>
                    //        <td>
                    //            {user.billingCountry}
                    //        </td>
                    //    </tr>
                    //})
                }
            </table>
        </div>
    );
}