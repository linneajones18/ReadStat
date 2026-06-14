USE read_stat;

CREATE TABLE IF NOT EXISTS book (
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(70),
    pages INT
);

CREATE TABLE IF NOT EXISTS user_ (
	username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS user_to_books_read (
    user_id VARCHAR(50),
    book_id INT,
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES user_(username),
    FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE IF NOT EXISTS genre (
    name VARCHAR(30) UNIQUE,
    id INT AUTO_INCREMENT PRIMARY KEY 
);

CREATE TABLE IF NOT EXISTS book_to_genre (
    genre_id INT,
    book_id INT,
    PRIMARY KEY (genre_id, book_id),
    FOREIGN KEY (genre_id) REFERENCES genre(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
)
