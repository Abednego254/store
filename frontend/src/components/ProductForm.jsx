import { useState, useEffect } from "react";

const ProductForm = ({ onSubmit, resetSignal, initialData }) => {
  const [formData, setFormData] = useState({
    productCode: "",
    productName: "",
    productLineId: "",
    productVendor: "",
    productDescription: "",
    productScale: "",
    quantityInStock: "",
    buyPrice: "",
    msrp: "",
  });

  // Load initial data for edit mode
  useEffect(() => {
    if (initialData) {
      setFormData({
        productCode: initialData.productCode || "",
        productName: initialData.productName || "",
        productLineId: initialData.productLineId || "",
        productVendor: initialData.productVendor || "",
        productDescription: initialData.productDescription || "",
        productScale: initialData.productScale || "",
        quantityInStock: initialData.quantityInStock || "",
        buyPrice: initialData.buyPrice || "",
        msrp: initialData.msrp || "",
      });
    }
  }, [initialData]);

  // Reset form after successful submit
  useEffect(() => {
    setFormData({
      productCode: "",
      productName: "",
      productLineId: "",
      productVendor: "",
      productDescription: "",
      productScale: "",
      quantityInStock: "",
      buyPrice: "",
      msrp: "",
    });
  }, [resetSignal]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="max-w-2xl mx-auto bg-white p-6 rounded-lg shadow-md space-y-4"
    >
      <h2 className="text-xl font-bold text-blue-800">
        {initialData ? "Edit Product" : "Add Product"}
      </h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        <FormInput
          label="Product Code"
          name="productCode"
          value={formData.productCode}
          onChange={handleChange}
          required
        />
        <FormInput
          label="Product Name"
          name="productName"
          value={formData.productName}
          onChange={handleChange}
          required
        />
        <FormInput
          label="Vendor"
          name="productVendor"
          value={formData.productVendor}
          onChange={handleChange}
        />
        <FormInput
          label="Scale"
          name="productScale"
          value={formData.productScale}
          onChange={handleChange}
        />
        <FormInput
          label="Quantity in Stock"
          name="quantityInStock"
          type="number"
          value={formData.quantityInStock}
          onChange={handleChange}
        />
        <FormInput
          label="Buy Price"
          name="buyPrice"
          type="number"
          step="0.01"
          value={formData.buyPrice}
          onChange={handleChange}
        />
        <FormInput
          label="MSRP"
          name="msrp"
          type="number"
          step="0.01"
          value={formData.msrp}
          onChange={handleChange}
        />
        <FormInput
          label="Product Line ID"
          name="productLineId"
          value={formData.productLineId}
          onChange={handleChange}
        />
      </div>

      <div>
        <label className="block text-gray-700 mb-1">Description</label>
        <textarea
          name="productDescription"
          value={formData.productDescription}
          onChange={handleChange}
          rows={3}
          className="w-full border rounded px-3 py-2"
        />
      </div>

      <button
        type="submit"
        className="bg-blue-800 text-white px-6 py-2 rounded hover:bg-blue-700"
      >
        {initialData ? "Update" : "Submit"}
      </button>
    </form>
  );
};

export default ProductForm;

// Reusable form input
const FormInput = ({
  label,
  name,
  type = "text",
  step,
  value,
  onChange,
  required = false,
}) => (
  <div>
    <label className="block text-gray-700 mb-1">{label}</label>
    <input
      name={name}
      type={type}
      step={step}
      value={value}
      onChange={onChange}
      className="w-full border rounded px-3 py-2"
      required={required}
    />
  </div>
);
