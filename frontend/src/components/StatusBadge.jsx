const getColor = (status) => {
  switch (status.toLowerCase()) {
    case "shipped":
      return "bg-blue-600";
    case "pending":
      return "bg-yellow-500";
    case "completed":
      return "bg-green-600";
    default:
      return "bg-gray-500";
  }
};

const StatusBadge = ({ status }) => {
  return (
    <span
      className={`text-white text-xs px-3 py-1 rounded-full ${getColor(
        status
      )}`}
    >
      {status}
    </span>
  );
};

export default StatusBadge;
