import { BrowserRouter, Routes, Route } from "react-router-dom";
import Services from "./pages/Services"
import Header from "./components/Header"
import Footer from "./components/Footer"
import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";


function App() {
  return (

      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/services" element={<Services />} />
      </Routes>

  );

}

export default App;