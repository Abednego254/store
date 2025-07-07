import { useEffect, useState } from "react";
import Topbar from "../components/Topbar";
import ProductLineCard from "../components/ProductLineCard";
import { fetchProductLines } from "../api/api"; // central API

const HomePage = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [productLines, setProductLines] = useState([]);

  useEffect(() => {
    const getProductLines = async () => {
      try {
        const res = await fetchProductLines();
        setProductLines(res.data);
      } catch (err) {
        console.error("Error fetching product lines:", err);
      }
    };

    getProductLines();
  }, []);

  const filtered = productLines.filter((line) =>
    line.productLine.toLowerCase().includes(searchTerm.toLowerCase())
  );
    console.log(productLines); // check if data iko
  return (
    <div>
      <Topbar />
      <div className="space-y-4 px-4">
        <input
          type="text"
          placeholder="🔍 Search product line"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="w-full max-w-md px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
        />

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-6">
          {filtered.map((line) => (
            <ProductLineCard
               key={line.productLine}
               name={line.productLine}
               description={line.textDescription}
               image={line.imageBase64}
            />
          ))}
        </div>
      </div>
    </div>
  );
};

export default HomePage;
