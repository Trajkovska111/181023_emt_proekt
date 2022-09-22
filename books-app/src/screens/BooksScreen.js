import React, { useEffect, useState } from "react";
import './App.css';
import { BooksService } from '../repository/booksRepository';
import { useNavigate } from "react-router-dom";

function BooksScreen() {
  const navigate = useNavigate();
  const [books, setBooks] = useState([]);

  function getBooks() {
    BooksService.getBooks()
      .then((data) => {
        setBooks(data.data);
        console.log(data.data)
      });
  }

  useEffect(() => {
    getBooks();
  }, [])

  let booksRender = books.map(el => {
    console.log(el)
    return <div>
      <div><img src={el.pictureUrl} alt={el.pictureUrl} width={200} height={150}/></div>
      <div>Title: {el.title}</div>
      <div>Author: {el.author}</div>
      <div>Category: {el.category}</div>
      <div>Price: {el.price}</div>
      <input type={'button'} value="Add to cart"/>
    </div>
  })
  return (
    <div className="App">
      <header className="App-header">
      <button onClick={()=>navigate('/addBook')}>Add Book</button>
        <p style={{display: 'grid', gridTemplateColumns: 'auto auto' , gap:'30px'}}>
          {booksRender}
        </p>
      </header>
    </div>
  );
}

export default BooksScreen;
