import { FaUserCircle } from "react-icons/fa";
import { IoApps } from "react-icons/io5";

const Topbar = () => {
  return (
    <header className="bg-white shadow-md px-6 py-3 flex items-center justify-between sticky top-0 z-50">
      {/* Left: Logo + Title */}
      <div className="flex items-center space-x-2 text-blue-900 font-bold text-lg">
        <IoApps className="text-2xl" />
        <span>ClassicModels CMS</span>
      </div>

      {/* Center: (Optional search bar) */}
      {/* <div className="w-full max-w-md mx-4">
        <input
          type="text"
          placeholder="🔍 Search..."
          className="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-600"
        />
      </div> */}

      {/* Right: User Icon */}
      <div className="flex items-center space-x-2">
        <div className="w-9 h-9 rounded-full bg-blue-900 text-white flex items-center justify-center font-semibold shadow">
          A
        </div>
        <span className="text-sm text-gray-700 hidden sm:inline">Admin</span>
        {/* Optional: Dropdown icon or menu */}
      </div>
    </header>
  );
};

export default Topbar;
