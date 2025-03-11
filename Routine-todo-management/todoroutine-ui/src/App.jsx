import { BrowserRouter, Routes ,Route } from "react-router-dom";
import "./App.css";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListTodoComponent from "./components/ListTodoComponent";

function App() {
  return (
    <BrowserRouter>
      <>
        <HeaderComponent />
        <Routes>
          <Route path="/" element={<ListTodoComponent />}></Route>
        </Routes>

        <FooterComponent />
      </>
    </BrowserRouter>
  );
}

export default App;
