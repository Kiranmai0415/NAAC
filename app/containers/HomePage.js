import React, { useState, useEffect } from 'react';

const Home = () => {
  const [content, setContent] = useState('');

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>Welcome Back</h3>
      </header>
    </div>
  );
};

export default Home;
