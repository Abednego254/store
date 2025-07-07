import { useNavigate } from "react-router-dom";

const ProductTable = ({ products, onDelete }) => {
  const navigate = useNavigate();

  return (
    <div className="overflow-x-auto rounded shadow border">
      <table className="min-w-full text-sm text-left">
        <thead className="bg-blue-800 text-white">
          <tr>
            <th className="px-4 py-2">Code</th>
            <th className="px-4 py-2">Name</th>
            <th className="px-4 py-2">Line</th>
            <th className="px-4 py-2">Vendor</th>
            <th className="px-4 py-2">Scale</th>
            <th className="px-4 py-2">Stock</th>
            <th className="px-4 py-2">Buy Price</th>
            <th className="px-4 py-2">MSRP</th>
            <th className="px-4 py-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((prod) => (
            <tr key={prod.id} className="border-b">
              <td className="px-4 py-2">{prod.productCode}</td>
              <td className="px-4 py-2">{prod.productName}</td>
              <td className="px-4 py-2">{prod.productLine?.productLine || "N/A"}</td>
              <td className="px-4 py-2">{prod.productVendor}</td>
              <td className="px-4 py-2">{prod.productScale}</td>
              <td className="px-4 py-2">{prod.quantityInStock}</td>
              <td className="px-4 py-2">${prod.buyPrice.toFixed(2)}</td>
              <td className="px-4 py-2">${prod.msrp.toFixed(2)}</td>
              <td className="px-4 py-2 space-x-2">
                <button
                  onClick={() => navigate(`/products/${prod.id}/edit`)}
                  className="text-blue-600 hover:underline"
                >
                  Edit
                </button>
                <button
                  onClick={() => onDelete(prod.id)}
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

export default ProductTable;
