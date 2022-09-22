import React, { useEffect, useState } from "react";
import BooksScreen from "./screens/BooksScreen";
import { BrowserRouter as Router, Routes, Route }
  from 'react-router-dom';
import AddBook from "./screens/AddBook/AddBook";

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path='/' element={<BooksScreen />} />
        <Route path='/books' element={<BooksScreen />} />
        <Route path='/addBook' element={<AddBook />} />
        
      </Routes>
    </Router>
  );
}

export default App;
