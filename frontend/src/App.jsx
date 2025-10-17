import React, { useEffect, useState } from "react";

export default function App() {
  const [message, setMessage] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchHello = async () => {
    setLoading(true);
    setError(null);
    try {
      const res = await fetch("/api/hello");
      if (!res.ok) throw new Error(`Status ${res.status}`);
      const json = await res.json();
      setMessage(json.message);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchHello();
  }, []);

  return (
    <div className="app">
      <h1>JavaOutput3 Frontend</h1>
      <p>
        This is a minimal React frontend that calls the backend endpoint <code>/api/hello</code>.
      </p>

      <div className="card">
        {loading ? (
          <p>Loading…</p>
        ) : error ? (
          <p className="error">Error: {error}</p>
        ) : (
          <p className="message">{message ?? "No message yet"}</p>
        )}
        <button onClick={fetchHello}>Refresh</button>
      </div>

      <footer>
        <small>Frontend dev server runs on http://localhost:3000 — backend on http://localhost:8080</small>
      </footer>
    </div>
  );
}

