
-- temporary until google books api is set up




INSERT INTO genre (name) VALUES ('Art');
INSERT INTO genre (name) VALUES ('Autobiography');
INSERT INTO genre (name) VALUES ('Biography');
INSERT INTO genre (name) VALUES ('Business');
INSERT INTO genre (name) VALUES ('Childrens');
INSERT INTO genre (name) VALUES ('Classics');
INSERT INTO genre (name) VALUES ('Comics');
INSERT INTO genre (name) VALUES ('Computer Science');
INSERT INTO genre (name) VALUES ('Contemporary');
INSERT INTO genre (name) VALUES ('Cookbook');
INSERT INTO genre (name) VALUES ('Crime');
INSERT INTO genre (name) VALUES ('Design');
INSERT INTO genre (name) VALUES ('Dystopian');
INSERT INTO genre (name) VALUES ('Economics');
INSERT INTO genre (name) VALUES ('Education');
INSERT INTO genre (name) VALUES ('Erotica');
INSERT INTO genre (name) VALUES ('Essays');
INSERT INTO genre (name) VALUES ('Fantasy');
INSERT INTO genre (name) VALUES ('Feminism');
INSERT INTO genre (name) VALUES ('Food and Drink');
INSERT INTO genre (name) VALUES ('Gender');
INSERT INTO genre (name) VALUES ('Graphic Novel');
INSERT INTO genre (name) VALUES ('Health');
INSERT INTO genre (name) VALUES ('Historical');
INSERT INTO genre (name) VALUES ('History');
INSERT INTO genre (name) VALUES ('LGBTQIA+');
INSERT INTO genre (name) VALUES ('Literary');
INSERT INTO genre (name) VALUES ('Magical Realism');
INSERT INTO genre (name) VALUES ('Manga');
INSERT INTO genre (name) VALUES ('Mathematics');
INSERT INTO genre (name) VALUES ('Memoir');
INSERT INTO genre (name) VALUES ('Middle Grade');
INSERT INTO genre (name) VALUES ('Music');
INSERT INTO genre (name) VALUES ('Mystery');
INSERT INTO genre (name) VALUES ('Nature');
INSERT INTO genre (name) VALUES ('Play');
INSERT INTO genre (name) VALUES ('Poetry');
INSERT INTO genre (name) VALUES ('Politics');
INSERT INTO genre (name) VALUES ('Psychology');
INSERT INTO genre (name) VALUES ('Race');
INSERT INTO genre (name) VALUES ('Reference');
INSERT INTO genre (name) VALUES ('Religion');
INSERT INTO genre (name) VALUES ('Romance');
INSERT INTO genre (name) VALUES ('Science');
INSERT INTO genre (name) VALUES ('Science Fiction');
INSERT INTO genre (name) VALUES ('Self Help');
INSERT INTO genre (name) VALUES ('Short Stories');
INSERT INTO genre (name) VALUES ('Sociology');
INSERT INTO genre (name) VALUES ('Speculative Fiction');
INSERT INTO genre (name) VALUES ('Sports');
INSERT INTO genre (name) VALUES ('Technology');
INSERT INTO genre (name) VALUES ('Thriller');
INSERT INTO genre (name) VALUES ('Travel');
INSERT INTO genre (name) VALUES ('True Crime');
INSERT INTO genre (name) VALUES ('Video Games');
INSERT INTO genre (name) VALUES ('Young Adult');


INSERT INTO author (name) VALUES ('Elsie Silver');
INSERT INTO author (name) VALUES ('Chloe Walsh');





INSERT INTO book (title, pages, description) VALUES ('Hopeless', 439, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (1, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (1, 43);
INSERT INTO author_to_book (book_id, author_id) VALUES (1, 1);

INSERT INTO book (title, pages, description) VALUES ('Reckless', 466, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 50);
INSERT INTO author_to_book (book_id, author_id) VALUES (2, 1);

INSERT INTO book (title, pages, description) VALUES ('Powerless', 464, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 50);
INSERT INTO author_to_book (book_id, author_id) VALUES (3, 1);

INSERT INTO book (title, pages, description) VALUES ('Heartless', 476, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (4, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (4, 43);
INSERT INTO author_to_book (book_id, author_id) VALUES (4, 1);

INSERT INTO book (title, pages, description) VALUES ('Flawless', 424, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 50);
INSERT INTO author_to_book (book_id, author_id) VALUES (5, 1);

INSERT INTO book (title, pages, description) VALUES ('Taming 7', 460, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (6, 43);
INSERT INTO author_to_book (book_id, author_id) VALUES (6, 2);

INSERT INTO book (title, pages, description) VALUES ('Redeeming 6', 766, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (7, 43);
INSERT INTO author_to_book (book_id, author_id) VALUES (7, 2);

INSERT INTO book (title, pages, description) VALUES ('Saving 6', 512, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (8, 43);
INSERT INTO author_to_book (book_id, author_id) VALUES (8, 2);

INSERT INTO book (title, pages, description) VALUES ('Keeping 13', 667, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (9, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (9, 50);
INSERT INTO author_to_book (book_id, author_id) VALUES (9, 2);

INSERT INTO book (title, pages, description) VALUES ('Binding 13', 609, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (10, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (10, 50);
INSERT INTO author_to_book (book_id, author_id) VALUES (10, 2);

INSERT INTO book (title, pages, description) VALUES ('Releasing 10', 768, "description goes here");
INSERT INTO book_to_genre (book_id, genre_id) VALUES (11, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (11, 9);
INSERT INTO author_to_book (book_id, author_id) VALUES (11, 2);
