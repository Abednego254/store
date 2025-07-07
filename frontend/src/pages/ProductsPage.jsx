import { useEffect, useState } from "react";
import Topbar from "../components/Topbar";
import ProductTable from "../components/ProductTable";
import { fetchProducts, deleteProduct } from "../api/api";
import { Link } from "react-router-dom";

const ProductsPage = () => {
  const [products, setProducts] = useState([]);

  const loadProducts = async () => {
    try {
      const res = await fetchProducts();
      setProducts(res.data.reverse()); // Show latest product on top
    } catch (err) {
      console.error("Error fetching products:", err);
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  const handleDelete = async (id) => {
    const confirmDelete = window.confirm("Are you sure you want to delete this product?");
    if (!confirmDelete) return;
    try {
      await deleteProduct(id);
      loadProducts();
    } catch (err) {
      console.error("Error deleting product:", err);
    }
  };

  return (
    <div>
      <Topbar />
      <div className="p-4 space-y-4">
        <div className="flex justify-between items-center">
          <h1 className="text-2xl font-semibold text-blue-800">Products</h1>
          <Link to="/products/new" className="bg-blue-800 text-white px-4 py-2 rounded">
            Add Product
          </Link>
        </div>
        <ProductTable products={products} onDelete={handleDelete} />
      </div>
    </div>
  );
};

export default ProductsPage;
