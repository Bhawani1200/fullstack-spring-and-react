import EmployeeComponent from "./components/EmployeeComponent";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import ListDepartmentsComponents from "./components/ListDepartmentsComponents";
import ListEmployeeComponents from "./components/ListEmployeeComponents";
import { BrowserRouter, Route, Routes } from "react-router-dom";
function App() {
  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          {/* http:localhost:3000 */}
          <Route path="/" element={<ListEmployeeComponents />}></Route>
          {/* http:localhost:3000/employees */}
          <Route path="/employees" element={<ListEmployeeComponents />}></Route>
          {/* http:localhost:/add-employee */}
          <Route path="/add-employee" element={<EmployeeComponent />}></Route>
          {/* http:localhost:3000/edit-employee */}
          <Route
            path="/edit-employee/:id"
            element={<EmployeeComponent />}
          ></Route>
          {/* http:localhost:3000/departments */}
          <Route
            path="/departments"
            element={<ListDepartmentsComponents />}
          ></Route>
        </Routes>

        <FooterComponent />
      </BrowserRouter>
    </>
  );
}

export default App;
