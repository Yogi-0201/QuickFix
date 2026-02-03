import React from "react";

const Dashboard = () => {
  return (
    <div className="min-h-screen bg-gray-100">
      {/* Header */}
      <header className="bg-gray-900 text-white px-6 py-4 flex justify-between items-center">
        <h1 className="text-xl font-semibold">QuickFix</h1>
        <button className="text-sm hover:underline">Logout</button>
      </header>

      {/* Body */}
      <div className="flex">
        {/* Sidebar */}
        <aside className="w-64 bg-white shadow-md min-h-screen p-6">
          <nav className="space-y-4">
            <p className="font-semibold text-gray-700">Dashboard</p>
            <p className="text-gray-600 hover:text-black cursor-pointer">
              My Requests
            </p>
            <p className="text-gray-600 hover:text-black cursor-pointer">
              Create Request
            </p>
            <p className="text-gray-600 hover:text-black cursor-pointer">
              Profile
            </p>
          </nav>
        </aside>

        {/* Main Content */}
        <main className="flex-1 p-8">
          <h2 className="text-2xl font-bold mb-6">
            Welcome to Dashboard 👋
          </h2>

          {/* Stats */}
          <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
            <div className="bg-white p-6 rounded-lg shadow">
              <p className="text-gray-500">Total Requests</p>
              <p className="text-3xl font-bold">12</p>
            </div>

            <div className="bg-white p-6 rounded-lg shadow">
              <p className="text-gray-500">Active Requests</p>
              <p className="text-3xl font-bold text-blue-600">5</p>
            </div>

            <div className="bg-white p-6 rounded-lg shadow">
              <p className="text-gray-500">Completed</p>
              <p className="text-3xl font-bold text-green-600">7</p>
            </div>
          </div>
        </main>
      </div>
    </div>
  );
};

export default Dashboard;