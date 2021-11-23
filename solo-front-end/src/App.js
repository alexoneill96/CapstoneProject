import "./App.css";
import Create from "./components/Create/Create";
import Admin from "./components/Admin/Admin";
import "semantic-ui-css/semantic.min.css";
import { BrowserRouter, Route } from "react-router-dom";
import "react-toastify/dist/ReactToastify.css";
import { ToastContainer } from "react-toastify";

function App() {
  return (
    <>
      <ToastContainer
        position="top-center"
        autoClose={10000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
      />

      <BrowserRouter>
        <div className="App">
          <div></div>
          <div>
            <Route exact path="/" component={Create} />
          </div>
          <div>
            <Route exact path="/admin" component={Admin} />
          </div>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;
