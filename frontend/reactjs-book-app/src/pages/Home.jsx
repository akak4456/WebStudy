import './Home.css';

const Home = ({ books, onDeleteBook }) => {
	return (
		<div>
			<h1>Books</h1>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Writer</th>
						<th>Title</th>
						<th>Release Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					{books.map((book) => (
						<tr key={book.id + 'book'}>
							<td>{book.id}</td>
							<td>{book.writer}</td>
							<td>{book.title}</td>
							<td>{book.releaseDate}</td>
							<td>
								<button onClick={() => onDeleteBook(book.id)}>DEL</button>
							</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
};

export default Home;
