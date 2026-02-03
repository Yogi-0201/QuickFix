const Sidebar = () => {
  return (
    <div
      style={{
        width: "220px",
        background: "#111827",
        color: "white",
        padding: "20px",
      }}
    >
      <h4>Menu</h4>

      <ul style={{ listStyle: "none", padding: 0 }}>
        <li style={{ margin: "15px 0" }}>Dashboard</li>
        <li style={{ margin: "15px 0" }}>Profile</li>
        <li style={{ margin: "15px 0" }}>Services</li>
        <li style={{ margin: "15px 0" }}>Logout</li>
      </ul>
    </div>
  );
};

export default Sidebar;