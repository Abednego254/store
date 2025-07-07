import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import ProductForm from "../components/ProductForm";
import { fetchProductById, updateProduct } from "../api/api"; // make sure you have these

const EditProductPage = () => {
  const { id } = useParams(); // /products/:id/edit
  const navigate = useNavigate();
  const [productData, setProductData] = useState(null);
  const [resetSignal, setResetSignal] = useState(0);
  const [loading, setLoading] = useState(true);

  // Fetch product on mount
  useEffect(() => {
    const loadProduct = async () => {
      try {
        const res = await fetchProductById(id);
        // Transform backend productLine object to productLineId string for the form
        const formReady = {
          ...res.data,
          productLineId: res.data.productLine?.id || "",
        };
        setProductData(formReady);
        setLoading(false);
      } catch (err) {
        console.error("Failed to load product:", err);
      }
    };

    loadProduct();
  }, [id]);

  const handleUpdate = async (data) => {
    try {
      const transformed = {
        ...data,
        productLine: { id: Number(data.productLineId) },
      };
      delete transformed.productLineId;

      await updateProduct(id, transformed);
      alert("Product updated successfully");
      setResetSignal((prev) => prev + 1);
      navigate("/products");
    } catch (err) {
      console.error("Failed to update product:", err);
      alert("Failed to update product.");
    }
  };

  if (loading) return <div className="p-6">Loading...</div>;

  return (
    <div className="p-6">
      <h1 className="text-xl font-semibold text-blue-800 mb-4">Edit Product</h1>
      <ProductForm onSubmit={handleUpdate} resetSignal={resetSignal} initialData={productData} />
    </div>
  );
};

export default EditProductPage;
