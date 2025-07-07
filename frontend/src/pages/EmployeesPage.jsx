import { useEffect, useState } from "react";
import { fetchEmployees } from "../api/api";
import EmployeeTable from "../components/EmployeeTable";
import Topbar from "../components/Topbar";

const EmployeesPage = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    fetchEmployees()
      .then((res) => setEmployees(res.data))
      .catch((err) => console.error("Error fetching employees:", err));
  }, []);

  return (
    <div>
      <Topbar />
      <div className="p-4 space-y-4">
        <h1 className="text-2xl font-semibold text-blue-800">Employees</h1>
        <EmployeeTable employees={employees} />
      </div>
    </div>
  );
};

export default EmployeesPage;
