import axiosInstance from "../axios/axiosSetup";

export const BooksService = {
    getBooks: () => {
        return axiosInstance.get("/books/getAll");
    },
    addBook: (title, author, price, category, imageUrl) => {
        return axiosInstance.post("/books/add", {
            "title": title,
            "author":author,
            "price": price,
            "category": category,
            "pictureUrl": imageUrl
        });
    },
}