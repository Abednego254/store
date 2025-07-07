import { useEffect, useState } from "react";
import { fetchCustomers } from "../api/api";
import CustomerList from "../components/CustomerList";
import Topbar from "../components/Topbar"

const CustomersPage = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    fetchCustomers()
      .then((res) => setCustomers(res.data))
      .catch((err) => console.error("Error fetching customers:", err));
  }, []);

  return (
    <div className="space-y-4">
      <Topbar />
      <h1 className="text-2xl font-semibold text-blue-800">Customers</h1>
      <CustomerList customers={customers} />
    </div>
  );
};

export default CustomersPage;
