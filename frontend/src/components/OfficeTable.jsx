import { useNavigate } from "react-router-dom";

const OfficeTable = ({ offices, onDelete }) => {
  const navigate = useNavigate();

  return (
    <div className="overflow-x-auto rounded shadow border">
      <table className="min-w-full text-sm text-left">
        <thead className="bg-blue-800 text-white">
          <tr>
            <th className="px-4 py-2">Code</th>
            <th className="px-4 py-2">Phone</th>
            <th className="px-4 py-2">City</th>
            <th className="px-4 py-2">State</th>
            <th className="px-4 py-2">Country</th>
            <th className="px-4 py-2">Postal</th>
            <th className="px-4 py-2">Territory</th>
            <th className="px-4 py-2">Address</th>
          </tr>
        </thead>
        <tbody>
          {offices.map((office) => (
            <tr key={office.id} className="border-b">
              <td className="px-4 py-2">{office.officeCode}</td>
              <td className="px-4 py-2">{office.phone}</td>
              <td className="px-4 py-2">{office.city}</td>
              <td className="px-4 py-2">{office.state || "-"}</td>
              <td className="px-4 py-2">{office.country}</td>
              <td className="px-4 py-2">{office.postalCode}</td>
              <td className="px-4 py-2">{office.territory}</td>
              <td className="px-4 py-2">
                {office.addressLine1}
                {office.addressLine2 ? `, ${office.addressLine2}` : ""}
              </td>
              <td className = "px-4 py-2 space-x-2">
                  <button onClick={() => navigate(`/offices/${office.id}/edit`)}
                          className="text-blue-600 hover:underline"
                          >
                    Edit
                  </button>
                <button onClick={() => onDelete(office.id)}
                        className="text-red-600 hover:underline"
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

export default OfficeTable;
