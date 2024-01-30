import { useState } from "react";
import { config } from "../config";

export const UploadCSV = () => {
    const [file, setFile] = useState();

    const fileReader = new FileReader();

    const handleOnChange = (e) => {
        setFile(e.target.files[0]);
    };

    const convertObjects = (array) => {
        let userArray = [];
        let itemArray = [];
        let transactionArray = []
        array.forEach(object => {
            let user = {
                firstName: object.FirstName,
                lastName: object.LastName,
                phone: object['Phone#'],
                shippingAddress: object.ShippingAddress,
                shippingCity: object.ShippingCity,
                shippingCountry: object.ShippingCountry,
                cardNumber: object['Card#'],
                cardType: object.CardType,
                billingAddress: object.BillingAddress,
                billingCity: object.BillingCity,
                billingCountry: object.BillingCountry,
                password: '',
                isAdmin: false,
                email: object["Email\r"]
            };
            userArray.push(user);

            let item = {
                Name: object.ItemName,
                Price: object.PricePerItem,
                Origin: object.ManufacturedFrom
            }
            itemArray.push(item);

            let transaction = {
                Tracking: object['Tracking#'],
                DeliveryDate: object.EstimatedDelivery,
                Quantity: object.ItemAmount,
                UserId: object.Id,
            }
            transactionArray.push(transaction); 
        }
        )

        fetch(config.baseurl + `Login`, {
            method: "POST",
            body: JSON.stringify(userArray),
            headers: {
                "Content-Type": "application/json"
            }
         })
            .then((resp) => resp.json())
        
        fetch(config.baseurl + `Store`, {
            method: "POST",
            body: JSON.stringify(itemArray),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then((resp) => resp.json())
        
        fetch(config.baseurl + `PurchaseHistory`, {
            method: "POST",
            body: JSON.stringify(itemArray),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then((resp) => resp.json())
    }

    const csvFileToArray = string => {
        const csvHeader = string.slice(0, string.indexOf("\n")).split(",");
        const csvRows = string.slice(string.indexOf("\n") + 1).split("\n");

        const array = csvRows.map(i => {
            const values = i.split(/,(?=(?:(?:[^"]*"){2})*[^"]*$)/);
            const obj = csvHeader.reduce((object, header, index) => {
                object[header] = values[index];
                return object;
            }, {});
            return obj;
        });
        convertObjects(array);
    };

    const handleOnSubmit = (e) => {
        e.preventDefault();

        if (file) {
            fileReader.onload = function (event) {
                const text = event.target.result;
                csvFileToArray(text);
            };

            fileReader.readAsText(file);
        }
    };

    return (
        <div style={{ textAlign: "center" }}>
            <form>
                <input
                    type={"file"}
                    id={"csvFileInput"}
                    accept={".csv"}
                    onChange={handleOnChange}
                />

                <button
                    onClick={(e) => {
                        handleOnSubmit(e);
                    }}
                >
                    Import CSV
                </button>
            </form>

            <br />
        </div>
    );
}
