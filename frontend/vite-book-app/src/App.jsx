import { useState } from 'react';
import './App.css';
import { Route, Routes, Link, useNavigate } from 'react-router-dom';
import Home from './pages/Home';
import AddBook from './pages/AddBook';

function App() {
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
			releaseDate: '2024-08-29',
		},
		{
			id: 3,
			writer: 'khuser03',
			title: 'Spring Boot&Thymeleaf',
			releaseDate: '2024-08-29',
		},
	]);
	const [newBook, setNewBook] = useState({
		id: '',
		writer: '',
		title: '',
		releaseDate: '',
	});
	const nav = useNavigate();
	const handlerInputChange = (e) => {
		const { name, value } = e.target;
		setNewBook({ ...newBook, [name]: value });
	};
	const handlerAddBook = () => {
		setBooks([...books, newBook]);
		nav('/');
	};
	return (
		<>
			<nav>
				<ul>
					<li>
						<Link to="/">List</Link>
					</li>
					<li>
						<Link to="/add">Add New Book</Link>
					</li>
				</ul>
			</nav>
			<Routes>
				<Route path="/" element={<Home books={books} />}></Route>
				<Route
					path="/add"
					element={
						<AddBook
							newBook={newBook}
							onAddBook={handlerAddBook}
							onInputChange={handlerInputChange}
						/>
					}
				></Route>
			</Routes>
		</>
	);
}

export default App;
