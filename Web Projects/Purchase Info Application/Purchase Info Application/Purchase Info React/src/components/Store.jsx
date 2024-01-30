import { useState, useEffect } from 'react';
import { ItemSummary } from './ItemSummary'
import { config } from "../config";
import '../css/table.css';

export const Store = () => {
    const [data, setData] = useState([]);
    const [open, setOpen] = useState(false);

     useEffect(() => {
         fetch(config.baseurl + `Store`)
             .then((resp) => resp.json())
             .then((data) => setData(data))
     }, []);

    return (
        <div>
            <>
            </>
            <table className="tableView">
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                </tr>
                {
                    data.map((item) => {
                        return <tr key={item.id}>
                            <td>
                                <button className='btn-link' onClick={() => setOpen(true)}>{item.name}</button>
                                {open ? <ItemSummary closePopup={() => setOpen(false)}></ItemSummary> : null}
                            </td>
                            <td>
                                {item.price}
                            </td>
                        </tr>    
                    })
                }
            </table>
        </div>
    );
}
