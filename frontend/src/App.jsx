import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Sidebar from "./components/Sidebar";
import OrdersPage from "./pages/OrdersPage";
import HomePage from "./pages/HomePage";
import ProductsPage from "./pages/ProductsPage";
import OfficesPage from "./pages/OfficesPage";
import EmployeesPage from "./pages/EmployeesPage";
import CustomersPage from "./pages/CustomersPage";
import PaymentsPage from "./pages/PaymentsPage";
import AddProductPage from "./pages/AddProductPage";
import EditProductPage from "./pages/EditProductPage";
import AddOfficePage from "./pages/AddOfficePage";

function App() {
  return (
    <Router>
      <div className="flex">
        <Sidebar />
        <div className="flex-1 p-6">
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/orders" element={<OrdersPage />} />
            <Route path="/home" element={<HomePage />} />
            <Route path="/products" element={<ProductsPage />} />
            <Route path="/payments" element={<PaymentsPage />} />
            <Route path="/products/:id/edit" element={<EditProductPage />} />
            <Route path="/employees" element={<EmployeesPage />} />
            <Route path="/customers" element={<CustomersPage />} />
            <Route path="/offices" element={<OfficesPage />} />
            <Route path="/products/new" element={<AddProductPage />} />
            <Route path="/offices/new" element ={<AddOfficePage />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
}

export default App;
