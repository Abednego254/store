const CustomerList = ({ customers }) => {
  return (
    <div className="space-y-4">
      {customers.map((cust) => (
        <div key={cust.id} className="border rounded-md p-4 shadow-sm bg-white">
          <div className="flex justify-between items-center mb-2">
            <h2 className="font-semibold text-blue-900 text-lg">
              {cust.customerName}
            </h2>
            <span className="text-sm text-gray-600">{cust.country}</span>
          </div>

          <div className="text-sm text-gray-700">
            <p>
              <span className="font-medium">Contact:</span>{" "}
              {cust.contactFirstName} {cust.contactLastName}
            </p>
            <p>
              <span className="font-medium">Phone:</span> {cust.phone}
            </p>
            <p>
              <span className="font-medium">Address:</span>{" "}
              {cust.addressLine1}
              {cust.addressLine2 && `, ${cust.addressLine2}`}, {cust.city},{" "}
              {cust.state || "-"}, {cust.postalCode}
            </p>
            <p>
              <span className="font-medium">Credit Limit:</span>{" "}
              ${cust.creditLimit.toLocaleString()}
            </p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default CustomerList;
