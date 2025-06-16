import React, { useState, useRef, useCallback } from "react";
import Button from "./Button.jsx";
import { FaEye, FaEdit, FaTrash, FaSort, FaSortUp, FaSortDown, FaPlus } from "react-icons/fa";
import "../../styles/pages/Table.css";

const DataTable = ({
  columns,
  data,
  onEdit,
  onView,
  onDelete,
  onAdd,
  initialSortField,
  onUnregisterStudent
}) => {
  const [sortField, setSortField] = useState(initialSortField || null);
  const [sortOrder, setSortOrder] = useState("asc");
  const [visibleCount, setVisibleCount] = useState(10);
  const [loading, setLoading] = useState(false);
  const observer = useRef(null);

  const loadMore = () => setVisibleCount((prev) => prev + 10);

  const lastRowRef = useCallback(
    (node) => {
      if (observer.current) observer.current.disconnect();
      observer.current = new IntersectionObserver((entries) => {
        if (entries[0].isIntersecting && !loading) {
          loadMore();
        }
      });
      if (node) observer.current.observe(node);
    },
    [loading]
  );

  const handleSort = (field) => {
    const newOrder = sortField === field && sortOrder === "asc" ? "desc" : "asc";
    setSortField(field);
    setSortOrder(newOrder);
  };

  const getNestedValue = (obj, path) => path.split(".").reduce((value, key) => value?.[key] || "", obj);

  const sortedData = [...data].sort((a, b) => {
    if (!sortField) return 0;

    const valueA = getNestedValue(a, sortField);
    const valueB = getNestedValue(b, sortField);

    if (typeof valueA === "number" && typeof valueB === "number") {
      return sortOrder === "asc" ? valueA - valueB : valueB - valueA;
    }

    const strA = String(valueA);
    const strB = String(valueB);

    return sortOrder === "asc" ? strA.localeCompare(strB) : strB.localeCompare(strA);
  });

  const getSortIcon = (field) => {
    if (sortField !== field) return <FaSort />;
    return sortOrder === "asc" ? <FaSortUp /> : <FaSortDown />;
  };

  return (
    <table className="data-table">
      <thead>
        <tr>
          {columns.map(({ label, field, sortable }) => (
            <th
              key={field}
              onClick={() => sortable && handleSort(field)}
              style={{ cursor: sortable ? "pointer" : "default" }}
            >
              {label} {sortable && getSortIcon(field)}
            </th>
          ))}
          <th>Operation</th> {/* Tên cột "operation" đã được thay bằng 'Operation' trực tiếp */}
        </tr>
      </thead>
      <tbody>
        {sortedData.length === 0 ? (
          <tr>
            <td colSpan={columns.length + 1} style={{ textAlign: "center" }}>No data available</td> {/* Thông báo không có dữ liệu */}
          </tr>
        ) : (
          sortedData.slice(0, visibleCount).map((row, index) => (
            <tr key={row._id || row.studentId} ref={index === visibleCount - 1 ? lastRowRef : null}>
              {columns.map(({ field }) => (
                <td key={field}>{getNestedValue(row, field)}</td>
              ))}
              <td>
                <div className="buttonBox">
                  {onView && <Button icon={<FaEye />} label="View" variant="gray" onClick={() => onView(row)} />}
                  {onEdit && <Button icon={<FaEdit />} label="Edit" variant="gray" onClick={() => onEdit(row)} />}
                  {onDelete && <Button icon={<FaTrash />} label="Delete" variant="danger" onClick={() => onDelete(row._id || row.studentId)} />}
                  {onAdd && <Button icon={<FaPlus />} label="Add" variant="success" onClick={() => onAdd(row)} />}
                  {onUnregisterStudent && (
                    <Button
                      icon={<FaTrash />}
                      label="Unregister"
                      variant="warning"
                      onClick={() => onUnregisterStudent(row)}
                    />
                  )}
                </div>
              </td>
            </tr>
          ))
        )}
        {loading && (
          <tr>
            <td colSpan={columns.length + 1} style={{ textAlign: "center" }}>
              Loading...
            </td>
          </tr>
        )}
      </tbody>
    </table>
  );
};

export default DataTable;
