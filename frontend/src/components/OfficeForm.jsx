import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const OfficeForm = ({onSubmit, resetSignal, initialData}) => {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        officeCode: "",
        phone: "",
        city: "",
        state: "",
        country: "",
        postalCode: "",
        territory: "",
        addressLine1: "",
    });

    useEffect(() => {
        if (initialData) {
            setFormData({
                officeCode: initialData.officeCode || "",
                phone: initialData.phone || "",
                city: initialData.city || "",
                state: initialData.state || "",
                country: initialData.country || "",
                postalCode: initialData.postalCode || "",
                territory: initialData.territory || "",
                addressLine1: initialData.addressLine1 || "",
            });
        }
    }, [initialData]);

    useEffect(() => {
        setFormData({
            officeCode: "",
            phone: "",
            city: "",
            state: "",
            country: "",
            postalCode: "",
            territory: "",
            addressLine1: "",
        });
    }, [resetSignal]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    };

    const handleSubmit = (e) =>{
        e.preventDefault();
        onSubmit(formData);
    }

    return (
        <div>
            <form onSubmit={handleSubmit}
                  className="max-w-2xl mx-auto bg-white p-6 rounded-lg shadow-md space-y-4">
            <h2 className="text-xl font-bold text-blue-800">
                {initialData ? "Edit Office" : "Add Office"}
            </h2>
            <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <FormInput
                    label = "Office Code"
                    name="officeCode"
                    value={formData.officeCode}
                    onChange={handleChange}
                    required
                    />
                <FormInput
                    label = "Phone"
                    name="phone"
                    value={formData.phone}
                    onChange={handleChange}
                    required
                    />
                <FormInput
                    label = "City"
                    name="city"
                    value={formData.city}
                    onChange={handleChange}
                    />
                <FormInput
                    label = "State"
                    name="state"
                    value={formData.state}
                    onChange={handleChange}
                    />
                <FormInput
                    label = "Country"
                    name="country"
                    value={formData.country}
                    onChange={handleChange}
                    />
                <FormInput
                    label = "Postal Code"
                    name="postalCode"
                    value={formData.postalCode}
                    onChange={handleChange}
                    />
                <FormInput
                label = "territory"
                name="territory"
                value={formData.territory}
                onChange={handleChange}
                />
                <FormInput
                label = "addressLine1"
                name="addressLine1"
                value={formData.addressLine1}
                onChange={handleChange}
                />
            </div>

                <button
                    type="submit"
                    className ="bg-blue-800 text-white px-6 py-2 rounded hover:bg-blue-700"
                    >
                    {initialData ? "Update" : "Submit"}
                </button>
            </form>
        </div>
    );
};

export default OfficeForm;

const FormInput = ({
    label,
    name,
    type = "text",
    step,
    value,
    onChange,
    required=false,
}) => (
    <div className="flex flex-col gap-1">
        <label className="text-sm font-medium text-gray-700">{label}</label>
        <input
            type={type}
            name={name}
            value={value}
            onChange={onChange}
            required={required}
            step={step}
        className="
        w-full rounded-md border border-gray-300
        px-3 py-2 shadow-sm
        placeholder:text-gray-400
        focus:border-blue-500 focus:outline-none focus:ring-2 focus:ring-blue-500
        disabled:cursor-not-allowed disabled:bg-gray-100
        dark:border-gray-600 dark:bg-gray-800 dark:text-white
        dark:focus:border-blue-400 dark:focus:ring-blue-400
        "
            />
    </div>
);