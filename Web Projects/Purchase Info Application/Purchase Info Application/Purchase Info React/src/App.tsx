import Button from "./components/Login";

function App() {
    return (
        <div>
            <Button color="secondary" onClick={() => console.log("Clicked")}>
                Hello World
            </Button>
        </div>
    );
}

export default App;
