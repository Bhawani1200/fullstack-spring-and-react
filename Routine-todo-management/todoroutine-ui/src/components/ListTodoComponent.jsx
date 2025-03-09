import React, { useState } from "react";

const ListTodoComponent = () => {
  const [todos, setTodos] = useState([]);
  return (
    <div className="container">
      <h2 className="text-center">List of Todos</h2>
      <div>
        <table className="table table-bordered table-striped">
          <thead>
            <tr>
              <th>Todo Title</th>
              <th>Todo Description</th>
              <th>Todo Completed</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {todos.map((todo) => {
              <tr key={todo.id}>
                <td>{todo.Title}</td>
                <td>{todo.Description}</td>
                <td>{todo.completed ? "YES" : "No"}</td>
              </tr>;
            })}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListTodoComponent;
