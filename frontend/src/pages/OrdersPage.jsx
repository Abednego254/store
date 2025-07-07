import { useEffect, useState } from "react";
import { fetchOrders } from "../api/api";
import OrderTable from "../components/OrderTable";
import Topbar from "../components/Topbar"

const OrdersPage = () => {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    fetchOrders()
      .then((res) => setOrders(res.data))
      .catch((err) => console.error("Error fetching orders:", err));
  }, []);

  return (
    <div>
      <Topbar />
      <h1 className="text-2xl font-semibold text-blue-800 mb-4">Orders</h1>
      <OrderTable orders={orders} />
    </div>
  );
};

export default OrdersPage;
