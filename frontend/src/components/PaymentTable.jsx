const PaymentTable = ({ payments }) => {
  return (
    <div className="overflow-x-auto bg-white p-4 rounded-lg shadow">
      <table className="min-w-full border">
        <thead>
          <tr className="bg-gray-100 text-left text-sm text-gray-700 uppercase">
            <th className="px-4 py-2 border">Check #</th>
            <th className="px-4 py-2 border">Customer</th>
            <th className="px-4 py-2 border">Amount</th>
            <th className="px-4 py-2 border">Payment Date</th>
          </tr>
        </thead>
        <tbody className="text-sm">
          {payments.map((payment) => (
            <tr key={payment.id} className="border-b hover:bg-gray-50">
              <td className="px-4 py-2 border">{payment.checkNumber}</td>
              <td className="px-4 py-2 border">
                {payment.customer?.customerName || "-"}
              </td>
              <td className="px-4 py-2 border">
                ${payment.amount.toLocaleString()}
              </td>
              <td className="px-4 py-2 border">{payment.paymentDate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PaymentTable;
