import { useState } from "react";
import { NavLink } from "react-router-dom";
import {
  HomeIcon,
  CubeIcon,
  UsersIcon,
  ShoppingCartIcon,
  BanknotesIcon,
  BuildingOfficeIcon,
  UserGroupIcon,
  Bars3Icon
} from "@heroicons/react/24/solid";

const Sidebar = () => {
  const [isCollapsed, setIsCollapsed] = useState(false);

  const links = [
    { name: "Home", path: "/home", icon: HomeIcon },
    { name: "Products", path: "/products", icon: CubeIcon },
    { name: "Customers", path: "/customers", icon: UsersIcon },
    { name: "Orders", path: "/orders", icon: ShoppingCartIcon },
    { name: "Payments", path: "/payments", icon: BanknotesIcon },
    { name: "Employees", path: "/employees", icon: UserGroupIcon },
    { name: "Offices", path: "/offices", icon: BuildingOfficeIcon },
  ];

  return (
    <aside
      className={`${
        isCollapsed ? "w-16" : "w-48"
      } bg-blue-900 text-white min-h-screen p-4 transition-all duration-300 space-y-4`}
    >
      {/* Top Bar */}
      <div className="flex justify-between items-center">
        {!isCollapsed && <h2 className="text-xl font-bold">Dashboard</h2>}
        <button onClick={() => setIsCollapsed(!isCollapsed)}>
          <Bars3Icon className="h-6 w-6" />
        </button>
      </div>

      {/* Nav Links */}
      <nav className="space-y-2 mt-4">
        {links.map(({ name, path, icon: Icon }) => (
          <NavLink
            key={name}
            to={path}
            className={({ isActive }) =>
              `flex items-center px-3 py-2 rounded-md transition-all ${
                isActive ? "bg-blue-700 font-semibold" : "hover:bg-blue-800"
              }`
            }
          >
            <Icon className="h-5 w-5 shrink-0" />
            <span
              className={`ml-3 overflow-hidden transition-all duration-300 ${
                isCollapsed ? "w-0 opacity-0" : "w-auto opacity-100"
              }`}
            >
              {name}
            </span>
          </NavLink>
        ))}
      </nav>
    </aside>
  );
};

export default Sidebar;
