import { useEffect, useState } from "react";
import { fetchOffices, deleteOffice } from "../api/api";
import OfficeTable from "../components/OfficeTable";
import Topbar from "../components/Topbar";
import {Link} from "react-router-dom";

const OfficesPage = () => {
  const [offices, setOffices] = useState([]);

  const loadOffices = async () => {
      try{
          const response = await fetchOffices();
          setOffices(response.data.reverse());
      }catch(error){
          console.error("Error fetching ofices:", error);
      }
  };

  useEffect(() => {
      loadOffices();
  }, []);

  const handleDelete = async (id) => {
      const confirmDelete = window.confirm("Are you sure you want to delete this office?");
      if (!confirmDelete) return;
      try{
          await deleteOffice(id);
          loadOffices();
      }catch(error){
          console.error("Error deleting office:", error);
      }
  };

  return (
    <div>
      <Topbar />
      <div className="p-4 space-y-4">
          <div className="flex justify-between items-center">
              <h1 className="text-2xl font-semibold text-blue-800 text-center">Offices</h1>
              <Link to="/offices/new" className="bg-blue-800 text-white px-4 py-2 rounded">
                  Add Office
              </Link>
          </div>
              <OfficeTable offices={offices} onDelete={handleDelete} />
      </div>
    </div>
  );
};

export default OfficesPage;
