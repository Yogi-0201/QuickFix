import "./../styles/Services.css";

const services = [
  {
    name: "Electrician",
    desc: "Wiring, switches, power issues, appliance fitting",
    icon: "⚡"
  },
  {
    name: "Plumber",
    desc: "Leakage, pipe fitting, bathroom & kitchen work",
    icon: "🚰"
  },
  {
    name: "Carpenter",
    desc: "Furniture repair, doors, wooden fittings",
    icon: "🪚"
  },
  {
    name: "AC Repair",
    desc: "AC installation, servicing & gas refill",
    icon: "❄️"
  },
  {
    name: "Cleaning",
    desc: "Home & office cleaning services",
    icon: "🧹"
  },
  {
    name: "Appliance Repair",
    desc: "Washing machine, fridge, microwave repair",
    icon: "🔧"
  }
];

const Services = () => {
  return (
    <div className="services-page">
      <h1 className="services-title">Our Services</h1>
      <p className="services-subtitle">
        Choose a service and create a request instantly
      </p>

      <div className="services-grid">
        {services.map((service, index) => (
          <div key={index} className="service-card">
            <div className="service-icon">{service.icon}</div>
            <h3>{service.name}</h3>
            <p>{service.desc}</p>
            <button>Request Service</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Services;