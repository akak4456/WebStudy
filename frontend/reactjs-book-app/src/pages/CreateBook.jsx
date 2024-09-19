import './CreateBook.css';
import { useNavigate } from 'react-router-dom';
const CreateBook = ({ onAddBook, onInputChange, newBook }) => {
	const navigate = useNavigate();
	return (
		<div className="bookForm">
			<h1>Create Book</h1>
			<input
				type="text"
				name="id"
				placeholder="Input book id"
				value={newBook.id}
				onChange={onInputChange}
			/>
			<br />
			<input
				type="text"
				name="writer"
				placeholder="Input book writer"
				value={newBook.writer}
				onChange={onInputChange}
			/>
			<br />
			<input
				type="text"
				name="title"
				placeholder="Input book title"
				value={newBook.title}
				onChange={onInputChange}
			/>
			<br />
			<input
				type="date"
				name="releaseDate"
				value={newBook.releaseDate}
				onChange={onInputChange}
			/>
			<br />
			<button
				onClick={() => {
					onAddBook();
					navigate('/');
				}}
			>
				Add Book
			</button>
		</div>
	);
};

export default CreateBook;
