import React, { useState } from "react";
import AuthorTable from "./components/domain/Authors/AuthorTable"; // Điều chỉnh theo cấu trúc dự án của bạn
import DataTable from "./components/common/DataTable"; // Điều chỉnh theo cấu trúc dự án của bạn

const App = () => {
  // Dữ liệu mẫu cho tác giả
  const [authors, setAuthors] = useState([
    { authorId: 1, authorName: "J.K. Rowling" },
    { authorId: 2, authorName: "George R.R. Martin" },
    { authorId: 3, authorName: "J.R.R. Tolkien" }
  ]);

  // Hàm chỉnh sửa tác giả
  const handleEdit = (author) => {
    console.log("Editing", author);
  };

  // Hàm xóa tác giả
  const handleDelete = (authorId) => {
    setAuthors(authors.filter((author) => author.authorId !== authorId));
    console.log("Deleted author with ID", authorId);
  };

  // Hàm thêm tác giả mới
  const handleAdd = () => {
    const newAuthor = { authorId: 4, authorName: "New Author" };
    setAuthors([...authors, newAuthor]);
    console.log("Added new author");
  };

  return (
    <div className="app-container">
      <h1>Bookstore Author Management</h1>
      {/* Hiển thị bảng tác giả */}
      <AuthorTable
        authors={authors}
        onEdit={handleEdit}
        onDelete={handleDelete}
        onAdd={handleAdd}
      />
    </div>
  );
};

export default App;
