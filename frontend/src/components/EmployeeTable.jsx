const EmployeeTable = ({ employees }) => {
  return (
    <div className="overflow-x-auto rounded shadow border">
      <table className="min-w-full text-sm text-left">
        <thead className="bg-blue-800 text-white">
          <tr>
            <th className="px-4 py-2">Name</th>
            <th className="px-4 py-2">Email</th>
            <th className="px-4 py-2">Extension</th>
            <th className="px-4 py-2">Job Title</th>
            <th className="px-4 py-2">Office</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id} className="border-b">
              <td className="px-4 py-2">{emp.firstName} {emp.lastName}</td>
              <td className="px-4 py-2">{emp.email}</td>
              <td className="px-4 py-2">{emp.extension}</td>
              <td className="px-4 py-2">{emp.jobTitle}</td>
              <td className="px-4 py-2">
                {emp.office?.city}, {emp.office?.country}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeTable;
