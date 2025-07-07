import { useEffect, useState } from "react";
import { fetchPayments } from "../api/api";
import PaymentTable from "../components/PaymentTable";
import Topbar from "../components/Topbar"

const PaymentsPage = () => {
  const [payments, setPayments] = useState([]);

  useEffect(() => {
    fetchPayments()
      .then((res) => setPayments(res.data))
      .catch((err) => console.error("Error fetching payments:", err));
  }, []);

  return (
    <div>
      <Topbar />
      <h1 className="text-2xl font-semibold text-blue-800 mb-4">Payments</h1>
      <PaymentTable payments={payments} />
    </div>
  );
};

export default PaymentsPage;
