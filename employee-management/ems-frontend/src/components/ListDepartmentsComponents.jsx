import { useEffect, useState } from "react";
import {
  deleteDepartment,
  getAllDepartments,
} from "../services/DepartmentService";
import { Link, useNavigate } from "react-router-dom";

const ListDepartmentsComponents = () => {
  const [departments, setDepartments] = useState([]);

  const navigator = useNavigate();
  useEffect(() => {
    listOfDepartments();
  }, []);

  function listOfDepartments() {
    getAllDepartments()
      .then((response) => {
        console.log(response.data);
        setDepartments(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function updateDepartment(id) {
    navigator(`/edit-department/${id}`);
  }

  function removeDepartment(id) {
    deleteDepartment(id)
      .then((response) => {
        console.log(response.data);
        listOfDepartments();
      })
      .catch((error) => {
        console.error(error);
      });
  }
  return (
    <div className="container">
      <h2 className="text-center">List of Departments</h2>
      <Link to="/add-department" className="btn btn-primary mb-2">
        Add Department
      </Link>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Department Id</th>
            <th>DepartmentName</th>
            <th>DepartmentDescription</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {departments.map((department) => (
            <tr key={department.id}>
              <td>{department.id}</td>
              <td>{department.departmentName}</td>
              <td>{department.departmentDescription}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => updateDepartment(department.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => removeDepartment(department.id)}
                  style={{ marginLeft: 10 }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListDepartmentsComponents;
