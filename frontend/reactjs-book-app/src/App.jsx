import { useState } from 'react';
import reactLogo from './assets/react.svg';
import viteLogo from '/vite.svg';
import './App.css';
import { Route, Routes, Link } from 'react-router-dom';
import Home from './pages/Home';
import CreateBook from './pages/CreateBook';
import NotFound from './pages/NotFound';
function App() {
	// books에는 객체 배열이 있음.
	// setBooks는 books에 값을 변경(상태변경)
	const [books, setBooks] = useState([
		{
			id: 1,
			writer: 'khuser01',
			title: 'Spring Boot&Oracle',
			releaseDate: '2024-08-29',
		},
		{
			id: 2,
			writer: 'khuser02',
			title: 'Spring Boot&JSP',
			releaseDate: '2024-08-28',
		},
		{
			id: 3,
			writer: 'khuser03',
			title: 'Spring Boot&ReactJs',
			releaseDate: '2024-08-27',
		},
	]);
	const [newBook, setNewBook] = useState({
		id: '',
		writer: '',
		title: '',
		releaseDate: '',
	});
	const handlerAddBook = () => {
		setBooks([...books, newBook]);
	};
	const handlerInputChange = (e) => {
		const { name, value } = e.target;
		setNewBook({ ...newBook, [name]: value });
	};
	const handlerDeleteBook = (deletedId) => {
		const updateBooks = books.filter((book) => book.id !== deletedId);
		setBooks(updateBooks);
	};
	return (
		<>
			<nav>
				<ul>
					<li>
						<Link to="/">List</Link>
					</li>
					<li>
						<Link to="/create">Add New Book</Link>
					</li>
				</ul>
			</nav>
			<Routes>
				<Route
					exact
					path="/"
					element={<Home books={books} onDeleteBook={handlerDeleteBook} />}
				></Route>
				<Route
					path="/create"
					element={
						<CreateBook
							onAddBook={handlerAddBook}
							onInputChange={handlerInputChange}
							newBook={newBook}
						/>
					}
				></Route>
				<Route path="*" element={<NotFound />}></Route>
			</Routes>
		</>
	);
}

export default App;
