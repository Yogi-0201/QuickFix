import Header from "../components/Header";
import Footer from "../components/Footer";

export default function Register() {
  return (
    <>
      <Header />

      <div className="flex items-center justify-center min-h-screen bg-gray-100">
        <div className="bg-white p-8 rounded-lg shadow-md w-full max-w-md">

          <h2 className="text-2xl font-semibold text-center mb-6">
            Create Account
          </h2>

          <form className="space-y-4">

            <div>
              <label className="block text-sm font-medium">Name</label>
              <input
                type="text"
                placeholder="Enter your name"
                className="w-full mt-1 px-3 py-2 border rounded-md"
              />
            </div>

            <div>
              <label className="block text-sm font-medium">Email</label>
              <input
                type="email"
                placeholder="Enter your email"
                className="w-full mt-1 px-3 py-2 border rounded-md"
              />
            </div>

            <div>
              <label className="block text-sm font-medium">Phone</label>
              <input
                type="text"
                placeholder="Enter your phone number"
                className="w-full mt-1 px-3 py-2 border rounded-md"
              />
            </div>

            <div>
              <label className="block text-sm font-medium">Password</label>
              <input
                type="password"
                placeholder="Create a password"
                className="w-full mt-1 px-3 py-2 border rounded-md"
              />
            </div>

            <button
              type="submit"
              className="w-full bg-blue-600 text-white py-2 rounded-md hover:bg-blue-700"
            >
              Sign Up
            </button>
          </form>

          <p className="text-sm text-center mt-4">
            Already have an account?{" "}
            <a href="/" className="text-blue-600">Login</a>
          </p>

        </div>
      </div>

      <Footer />
    </>
  );
}