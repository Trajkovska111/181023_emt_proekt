import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { BooksService } from "../../repository/booksRepository";
import '../App.css';

function AddBook() {
    const navigate = useNavigate();

    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [price, setPrice] = useState(0);
    const [category, setCategory] = useState("");
    const [imageUrl, setImageUrl] = useState("");

    function addBook() {
        BooksService.addBook(title, author, price, category, imageUrl).then((d) => {
            console.log(d)
            navigate("/");
        }).catch(e => console.log(e));
    }

    return (
        <div className="App">
            <header className="App-header" style={{ gap: "10px" }}>
                <input type={"text"} value={title} onChange={(e) => setTitle(e.target.value)} placeholder={"Title"} />
                <input type={"text"} value={author} onChange={(e) => setAuthor(e.target.value)} placeholder={"Author"} />
                <input type={"number"} value={price} onChange={(e) => setPrice(e.target.value)} placeholder={"Price"} />
                <input type={"text"} value={category} onChange={(e) => setCategory(e.target.value)} placeholder={"Category"} />
                <input type={"text"} value={imageUrl} onChange={(e) => setImageUrl(e.target.value)} placeholder={"Image Url"} />
                <input type={"button"} onClick={addBook} value="Add Book" />
            </header>
        </div>
    );
}

export default AddBook;
