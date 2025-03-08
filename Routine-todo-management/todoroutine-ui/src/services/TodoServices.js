import axios from "axios";
const BASE_REST_API_URL="http://localhost:8080/api/todos";

export const getAlLTodos=()=>axios.getAlLTodos(BASE_REST_API_URL);

