import './Home.css';
const Home = ({ books }) => {
	return (
		<>
			<h1>Book List</h1>
			<div>
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Writer</th>
							<th>Title</th>
							<th>ReleaseDate</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						{books.map((book) => (
							<tr key={book.id}>
								<td>{book.id}</td>
								<td>{book.writer}</td>
								<td>{book.title}</td>
								<td>{book.releaseDate}</td>
								<td>
									<button>DEL</button>
								</td>
							</tr>
						))}
					</tbody>
				</table>
			</div>
		</>
	);
};

export default Home;
