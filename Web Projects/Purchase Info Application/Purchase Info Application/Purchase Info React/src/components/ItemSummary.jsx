import '../css/popUp.css';
import '../css/table.css';

export const ItemSummary = (props) => {
    return (
        <div className="popup-container">
            <div className="popup-body">
            <table>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td><input type="number" min="1"></input></td>
                </tr>
                </table>
                <button>Purchase</button>
                <button onClick={props.closePopup}>Close X</button>
            </div>
        </div>
    )
}