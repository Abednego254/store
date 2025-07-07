const OrderTable = ({ orders }) => {
  // Function to assign badge styles based on status
  const getStatusBadgeClass = (status) => {
    switch (status) {
      case "SHIPPED":
        return "bg-green-100 text-green-700";
      case "PENDING":
        return "bg-yellow-100 text-yellow-800";
      case "CANCELLED":
        return "bg-red-100 text-red-700";
      default:
        return "bg-gray-100 text-gray-700";
    }
  };

  return (
    <div className="overflow-x-auto bg-white p-4 rounded-lg shadow">
      <table className="min-w-full border">
        <thead>
          <tr className="bg-gray-100 text-left text-sm text-gray-700 uppercase">
            <th className="px-4 py-2 border">Order #</th>
            <th className="px-4 py-2 border">Customer</th>
            <th className="px-4 py-2 border">Order Date</th>
            <th className="px-4 py-2 border">Required Date</th>
            <th className="px-4 py-2 border">Shipped Date</th>
            <th className="px-4 py-2 border">Status</th>
            <th className="px-4 py-2 border">Total</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {orders.map((order) => (
            <tr key={order.id} className="border-b hover:bg-gray-50">
              <td className="px-4 py-2 border">{order.orderNumber}</td>
              <td className="px-4 py-2 border">
                {order.customer?.customerName || "-"}
              </td>
              <td className="px-4 py-2 border">{order.orderDate}</td>
              <td className="px-4 py-2 border">{order.requiredDate}</td>
              <td className="px-4 py-2 border">
                {order.shippedDate || <span className="text-gray-400">Not Shipped</span>}
              </td>
              <td className="px-4 py-2 border">
                <span
                  className={`px-2 py-1 rounded-full text-xs font-semibold ${getStatusBadgeClass(order.status)}`}
                >
                  {order.status}
                </span>
              </td>
              <td className="px-4 py-2 border">
                {order.totalAmount ? `$${order.totalAmount.toFixed(2)}` : "-"}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default OrderTable;
