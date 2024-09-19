import './AddBook.css';
const AddBook = ({ newBook, onAddBook, onInputChange }) => {
	return (
		<>
			<h1>Add Book</h1>
			<div className="addForm">
				<input
					type="number"
					name="id"
					value={newBook.id}
					onChange={onInputChange}
					placeholder="Input Book Id"
				></input>
				<br />
				<input
					type="text"
					name="writer"
					value={newBook.writer}
					onChange={onInputChange}
					placeholder="Input Book Writer"
				></input>
				<br />
				<input
					type="text"
					name="title"
					value={newBook.title}
					onChange={onInputChange}
					placeholder="Input Book Title"
				></input>
				<br />
				<input
					type="date"
					name="releaseDate"
					value={newBook.releaseDate}
					onChange={onInputChange}
				></input>
				<br />
				<button onClick={onAddBook}>Add Book</button>
			</div>
		</>
	);
};

export default AddBook;
