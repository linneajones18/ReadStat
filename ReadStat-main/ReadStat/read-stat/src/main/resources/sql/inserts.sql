INSERT INTO genre (genre_name) VALUES ('Art');
INSERT INTO genre (genre_name) VALUES ('Autobiography');
INSERT INTO genre (genre_name) VALUES ('Biography');
INSERT INTO genre (genre_name) VALUES ('Business');
INSERT INTO genre (genre_name) VALUES ('Childrens');
INSERT INTO genre (genre_name) VALUES ('Classics');
INSERT INTO genre (genre_name) VALUES ('Comics');
INSERT INTO genre (genre_name) VALUES ('Computer Science');
INSERT INTO genre (genre_name) VALUES ('Contemporary');
INSERT INTO genre (genre_name) VALUES ('Cookbook');
INSERT INTO genre (genre_name) VALUES ('Crime');
INSERT INTO genre (genre_name) VALUES ('Design');
INSERT INTO genre (genre_name) VALUES ('Dystopian');
INSERT INTO genre (genre_name) VALUES ('Economics');
INSERT INTO genre (genre_name) VALUES ('Education');
INSERT INTO genre (genre_name) VALUES ('Erotica');
INSERT INTO genre (genre_name) VALUES ('Essays');
INSERT INTO genre (genre_name) VALUES ('Fantasy');
INSERT INTO genre (genre_name) VALUES ('Feminism');
INSERT INTO genre (genre_name) VALUES ('Food and Drink');
INSERT INTO genre (genre_name) VALUES ('Gender');
INSERT INTO genre (genre_name) VALUES ('Graphic Novel');
INSERT INTO genre (genre_name) VALUES ('Health');
INSERT INTO genre (genre_name) VALUES ('Historical');
INSERT INTO genre (genre_name) VALUES ('History');
INSERT INTO genre (genre_name) VALUES ('LGBTQIA+');
INSERT INTO genre (genre_name) VALUES ('Literary');
INSERT INTO genre (genre_name) VALUES ('Magical Realism');
INSERT INTO genre (genre_name) VALUES ('Manga');
INSERT INTO genre (genre_name) VALUES ('Mathematics');
INSERT INTO genre (genre_name) VALUES ('Memoir');
INSERT INTO genre (genre_name) VALUES ('Middle Grade');
INSERT INTO genre (genre_name) VALUES ('Music');
INSERT INTO genre (genre_name) VALUES ('Mystery');
INSERT INTO genre (genre_name) VALUES ('Nature');
INSERT INTO genre (genre_name) VALUES ('Play');
INSERT INTO genre (genre_name) VALUES ('Poetry');
INSERT INTO genre (genre_name) VALUES ('Politics');
INSERT INTO genre (genre_name) VALUES ('Psychology');
INSERT INTO genre (genre_name) VALUES ('Race');
INSERT INTO genre (genre_name) VALUES ('Reference');
INSERT INTO genre (genre_name) VALUES ('Religion');
INSERT INTO genre (genre_name) VALUES ('Romance');
INSERT INTO genre (genre_name) VALUES ('Science');
INSERT INTO genre (genre_name) VALUES ('Science Fiction');
INSERT INTO genre (genre_name) VALUES ('Self Help');
INSERT INTO genre (genre_name) VALUES ('Short Stories');
INSERT INTO genre (genre_name) VALUES ('Sociology');
INSERT INTO genre (genre_name) VALUES ('Speculative Fiction');
INSERT INTO genre (genre_name) VALUES ('Sports');
INSERT INTO genre (genre_name) VALUES ('Technology');
INSERT INTO genre (genre_name) VALUES ('Thriller');
INSERT INTO genre (genre_name) VALUES ('Travel');
INSERT INTO genre (genre_name) VALUES ('True Crime');
INSERT INTO genre (genre_name) VALUES ('Video Games');
INSERT INTO genre (genre_name) VALUES ('Young Adult');


INSERT INTO author (name) VALUES ('Elsie Silver');
INSERT INTO author (name) VALUES ('Chloe Walsh');





INSERT INTO book (title, pages, description) VALUES ('Hopeless', 439, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (1, "Contemporary");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (1, "Romance");
INSERT INTO author_to_book (book_id, author_id) VALUES (1, 1);

INSERT INTO book (title, pages, description) VALUES ('Reckless', 466, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (2, "Contemporary");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (2, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (2, "Sports");
INSERT INTO author_to_book (book_id, author_id) VALUES (2, 1);

INSERT INTO book (title, pages, description) VALUES ('Powerless', 464, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (3, "Contemporary");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (3, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (3, "Sports");
INSERT INTO author_to_book (book_id, author_id) VALUES (3, 1);

INSERT INTO book (title, pages, description) VALUES ('Heartless', 476, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (4, "Contemporary");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (4, "Romance");
INSERT INTO author_to_book (book_id, author_id) VALUES (4, 1);

INSERT INTO book (title, pages, description) VALUES ('Flawless', 424, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (5, "Contemporary");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (5, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (5, "Sports");
INSERT INTO author_to_book (book_id, author_id) VALUES (5, 1);

INSERT INTO book (title, pages, description) VALUES ('Taming 7', 460, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (6, "Romance");
INSERT INTO author_to_book (book_id, author_id) VALUES (6, 2);

INSERT INTO book (title, pages, description) VALUES ('Redeeming 6', 766, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (7, "Romance");
INSERT INTO author_to_book (book_id, author_id) VALUES (7, 2);

INSERT INTO book (title, pages, description) VALUES ('Saving 6', 512, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (8, "Romance");
INSERT INTO author_to_book (book_id, author_id) VALUES (8, 2);

INSERT INTO book (title, pages, description) VALUES ('Keeping 13', 667, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (9, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (9, "Sports");
INSERT INTO author_to_book (book_id, author_id) VALUES (9, 2);

INSERT INTO book (title, pages, description) VALUES ('Binding 13', 609, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (10, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (10, "Sports");
INSERT INTO author_to_book (book_id, author_id) VALUES (10, 2);

INSERT INTO book (title, pages, description) VALUES ('Releasing 10', 768, "description goes here");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (11, "Romance");
INSERT INTO book_to_genre (book_id, genre_name) VALUES (11, "Contemporary");
INSERT INTO author_to_book (book_id, author_id) VALUES (11, 2);
