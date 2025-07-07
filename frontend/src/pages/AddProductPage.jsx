import { useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductForm from "../components/ProductForm";
import { createProduct } from "../api/api";
import Topbar from "../components/Topbar";

const AddProductPage = () => {
  const navigate = useNavigate();
  const [resetSignal, setResetSignal] = useState(0);

const handleAdd = async (data) => {
  try {
    // Convert productLineId to nested object
    const transformed = {
      ...data,
      productLine: {
        id: Number(data.productLineId),
      },
    };

    // Remove the flat productLineId
    delete transformed.productLineId;

    await createProduct(transformed);
    alert("Product added successfully");
    setResetSignal((prev) => prev + 1);
    setTimeout(() => {
      navigate("/products");
    }, 300);
  } catch (err) {
    console.error("Failed to add product:", err);
    alert("Failed to add product.");
  }
};

  return (
    <div className="p-6">
      <Topbar />
      <h1 className="text-xl font-semibold text-blue-800 mb-4">Add Product</h1>
      <ProductForm onSubmit={handleAdd} resetSignal={resetSignal} />
    </div>
  );
};

export default AddProductPage;
