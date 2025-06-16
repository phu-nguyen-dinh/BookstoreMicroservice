import React from 'react';
import Datatable from '../../common/DataTable';

const AuthorTable = ({ authors, onEdit, onDelete }) => {
  const columns = [
    { label: 'Author ID', field: 'authorId', sortable: true },
    { label: 'Author Name', field: 'authorName', sortable: true },
    {
      label: 'Actions',
      field: 'actions',
      sortable: false,
      render: (row) => (
        <>
          <button onClick={() => onEdit(row)}>Edit</button>
          <button onClick={() => onDelete(row)}>Delete</button>
        </>
      ),
    },
  ];

  return (
    <Datatable
      columns={columns}
      data={authors}
    />
  );
};

export default AuthorTable;
