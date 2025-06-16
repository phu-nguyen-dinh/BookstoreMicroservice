export function mapAuthorsToTableData(authors) {
  return authors.map((author) => ({
    authorId: author.authorId || '',
    authorName: author.authorName || ''
  }));
}
