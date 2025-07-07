import { useState } from "react";
import { useNavigate } from "react-router-dom";
import OfficeForm from "../components/OfficeForm";
import { createOffice} from "../api/api";
import Topbar from "../components/Topbar";

const AddOfficePage = () => {
    const navigate = useNavigate();
    const [resetSignal, setResetSignal] = useState(0);

    const handleAdd = async (data) => {
        const transformed = {
            ...data,
        };
        await createOffice(transformed);
        alert("Successfully added new office");
        setResetSignal((prev) => prev + 1)
        setTimeout(() => {
            navigate("/offices");
        }, 300);
    };

    return (
        <div className="p-6">
            <Topbar />
            <h1 className="text-xl font-semibold text-blue-800 mb-4">Add Office</h1>
            <OfficeForm onSubmit={handleAdd} resetSignal={resetSignal} />
        </div>
    );
};

export default AddOfficePage;