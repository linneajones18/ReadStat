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















-- in order for relationships to genres to be loaded properly, the table must be empty upon entering these insert statements

INSERT INTO book (title, author, pages) VALUES ('Hopeless', 'Elsie Silver', 439);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (1, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (1, 43);


INSERT INTO book (title, author, pages) VALUES ('Reckless', 'Elsie Silver', 466);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (2, 50);


INSERT INTO book (title, author, pages) VALUES ('Powerless', 'Elsie Silver', 464);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (3, 50);


INSERT INTO book (title, author, pages) VALUES ('Heartless', 'Elsie Silver', 476);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (4, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (4, 43);

INSERT INTO book (title, author, pages) VALUES ('Flawless', 'Elsie Silver', 424);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (5, 50);

INSERT INTO book (title, author, pages) VALUES ('Goldfinch', 'Raven Kennedy', 688);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (6, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (6, 43);

INSERT INTO book (title, author, pages) VALUES ('Gold', 'Raven Kennedy', 646);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (7, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (7, 43);

INSERT INTO book (title, author, pages) VALUES ('Glow', 'Raven Kennedy', 714);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (8, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (8, 43);

INSERT INTO book (title, author, pages) VALUES ('Gleam', 'Raven Kennedy', 679);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (9, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (9, 43);

INSERT INTO book (title, author, pages) VALUES ('Glint', 'Raven Kennedy', 433);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (10, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (10, 43);

INSERT INTO book (title, author, pages) VALUES ('Gild', 'Raven Kennedy', 393);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (11, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (11, 43);

INSERT INTO book (title, author, pages) VALUES ('Satan''s Affair', 'H.D. Carlton', 180);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (12, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (12, 9);


INSERT INTO book (title, author, pages) VALUES ('Hunting Adeline', 'H.D. Carlton', 649);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (13, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (13, 52);


INSERT INTO book (title, author, pages) VALUES ('Haunting Adeline', 'H.D. Carlton', 608);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (14, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (14, 52);


INSERT INTO book (title, author, pages) VALUES ('King of Envy', 'Ana Huang', 512);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (15, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (15, 9);


INSERT INTO book (title, author, pages) VALUES ('King of Sloth', 'Ana Huang', 439);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (16, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (16, 9);

INSERT INTO book (title, author, pages) VALUES ('King of Greed', 'Ana Huang', 315);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (17, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (17, 9);

INSERT INTO book (title, author, pages) VALUES ('King of Pride', 'Ana Huang', 358);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (18, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (18, 9);

INSERT INTO book (title, author, pages) VALUES ('King of Wrath', 'Ana Huang', 416);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (19, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (19, 9);

INSERT INTO book (title, author, pages) VALUES ('Taming 7', 'Chloe Walsh', 460);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (20, 43);

INSERT INTO book (title, author, pages) VALUES ('Redeeming 6', 'Chloe Walsh', 766);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (21, 43);

INSERT INTO book (title, author, pages) VALUES ('Saving 6', 'Chloe Walsh', 512);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (22, 43);

INSERT INTO book (title, author, pages) VALUES ('Keeping 13', 'Chloe Walsh', 667);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (23, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (23, 50);

INSERT INTO book (title, author, pages) VALUES ('Binding 13', 'Chloe Walsh', 609);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (24, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (24, 50);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (24, 9);

INSERT INTO book (title, author, pages) VALUES ('Releasing 10', 'Chloe Walsh', 768);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (25, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (25, 9);

INSERT INTO book (title, author, pages) VALUES ('A Cure for True Love', 'Stephanie Garber', 358);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (26, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (26, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (26, 56);

INSERT INTO book (title, author, pages) VALUES ('The Ballad of Never After', 'Stephanie Garber', 432);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (27, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (27, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (27, 56);

INSERT INTO book (title, author, pages) VALUES ('Once Upon a Broken Heart', 'Stephanie Garber', 416);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (28, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (28, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (28, 56);

INSERT INTO book (title, author, pages) VALUES ('Spectacular', 'Stephanie Garber', 240);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (29, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (29, 56);

INSERT INTO book (title, author, pages) VALUES ('Finale', 'Stephanie Garber', 491);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (30, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (30, 56);

INSERT INTO book (title, author, pages) VALUES ('Legendary', 'Stephanie Garber', 496);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (31, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (31, 56);

INSERT INTO book (title, author, pages) VALUES ('Caraval', 'Stephanie Garber', 436);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (32, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (32, 56);

INSERT INTO book (title, author, pages) VALUES ('A Reign of Rose', 'Kate Golden', 491);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (33, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (33, 43);

INSERT INTO book (title, author, pages) VALUES ('A Promise of Peridot', 'Kate Golden', 480);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (34, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (34, 43);

INSERT INTO book (title, author, pages) VALUES ('A Dawn of Onyx', 'Kate Golden', 417);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (35, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (35, 43);

INSERT INTO book (title, author, pages) VALUES ('Ruthless Vows', 'Rebecca Ross', 420);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (36, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (36, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (36, 56);

INSERT INTO book (title, author, pages) VALUES ('Divine Rivals', 'Rebecca Ross', 357);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (37, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (37, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (37, 56);

INSERT INTO book (title, author, pages) VALUES ('Double Apex', 'Josie Juniper', 340);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (38, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (38, 9);

INSERT INTO book (title, author, pages) VALUES ('Deep End', 'Ali Hazelwood', 457);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (39, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (39, 9);

INSERT INTO book (title, author, pages) VALUES ('Pole Position', 'Rebecca J. Caffery', 366);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (40, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (40, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (40, 50);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (40, 26);

INSERT INTO book (title, author, pages) VALUES ('The Game Changer', 'Lana Ferguson', 400);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (41, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (41, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (41, 50);

INSERT INTO book (title, author, pages) VALUES ('Daydream', 'Hannah Grace', 432);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (42, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (42, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (42, 50);

INSERT INTO book (title, author, pages) VALUES ('Not in Love', 'Ali Hazelwood', 384);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (43, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (43, 9);

INSERT INTO book (title, author, pages) VALUES ('Exploring Culture and Gender through Film', 'Christian Hammons', 336);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (44, 1);

INSERT INTO book (title, author, pages) VALUES ('House of Flame and Shadow', 'Sarah J. Maas', 839);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (45, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (45, 43);

INSERT INTO book (title, author, pages) VALUES ('House of Sky and Breath', 'Sarah J. Maas', 816);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (46, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (46, 43);

INSERT INTO book (title, author, pages) VALUES ('House of Earth and Blood', 'Sarah J. Maas', 819);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (47, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (47, 43);

INSERT INTO book (title, author, pages) VALUES ('The Nanny', 'Lana Ferguson', 432);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (48, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (48, 43);

INSERT INTO book (title, author, pages) VALUES ('A Court of Silver Flames', 'Sarah J. Maas', 751);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (49, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (49, 43);

INSERT INTO book (title, author, pages) VALUES ('Heartstopper Volume 5', 'Alice Oseman', 336);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (50, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (50, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (50, 56);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (50, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (50, 22);

INSERT INTO book (title, author, pages) VALUES ('Heartstopper Volume 4', 'Alice Oseman', 384);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (51, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (51, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (51, 56);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (51, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (51, 22);

INSERT INTO book (title, author, pages) VALUES ('Girls Like Girls', 'Hayley Kiyoko', 309);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (52, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (52, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (52, 56);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (52, 43);

INSERT INTO book (title, author, pages) VALUES ('Unbroken Bonds', 'J. Bree', 496);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (53, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (53, 43);

INSERT INTO book (title, author, pages) VALUES ('Tragic Bonds', 'J. Bree', 466);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (54, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (54, 43);

INSERT INTO book (title, author, pages) VALUES ('Forced Bonds', 'J. Bree', 488);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (55, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (55, 43);

INSERT INTO book (title, author, pages) VALUES ('Blood Bonds', 'J. Bree', 469);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (56, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (56, 43);

INSERT INTO book (title, author, pages) VALUES ('Savage Bonds', 'J. Bree', 500);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (57, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (57, 43);









INSERT INTO book (title, author, pages) VALUES ('Emma Hearts LA', 'Keris Stainton', 256);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (58, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (58, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (58, 56);

INSERT INTO book (title, author, pages) VALUES ('Any Way the Wind Blows', 'Seanan McGuire', 17);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (59, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (59, 45);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (53, 47);

INSERT INTO book (title, author, pages) VALUES ('These Were the Greeks', 'H.D. Amos', 224);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (60, 25);

INSERT INTO book (title, author, pages) VALUES ('Head Cases', 'John McMahon', 341);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (61, 11);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (61, 52);

INSERT INTO book (title, author, pages) VALUES ('The Legend of the Wandering King', 'Laura Gallego', 224);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (62, 5);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (62, 24);

INSERT INTO book (title, author, pages) VALUES ('The Bewitching', 'Silvia Moreno-Garcia', 460);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (63, 18);

INSERT INTO book (title, author, pages) VALUES ('Girl, Transcending: Becoming the woman I was born to be', 'AJ Clementine', 240);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (64, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (64, 31);

INSERT INTO book (title, author, pages) VALUES ('Little Bosses Everywhere', 'Bridget Read', 366);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (65, 14);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (65, 38);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (65, 48);


INSERT INTO book (title, author, pages) VALUES ('Witchcaft: A History in Thirteen Trials', 'Marion Gibson', 320);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (66, 25);

INSERT INTO book (title, author, pages) VALUES ('The Facttracker', 'Jason Carter Eaton', 279);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (67, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (67, 32);


INSERT INTO book (title, author, pages) VALUES ('Stowed Away', 'Barbara Ross', 280);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (68, 34);

INSERT INTO book (title, author, pages) VALUES ('The Coincidence Makers', 'Yoav Blum', 291);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (69, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (69, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (69, 28);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (69, 45);

INSERT INTO book (title, author, pages) VALUES ('Feral is the Beast', 'Nisha J. Tuli', 163);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (70, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (70, 43);

INSERT INTO book (title, author, pages) VALUES ('Batman: Gotham by Gaslight', 'Brian Augustyn', 112);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (71, 7);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (71, 11);

INSERT INTO book (title, author, pages) VALUES ('Across the Acheron', 'Monique Wittig', 192);

INSERT INTO book (title, author, pages) VALUES ('Pooh Goes Visiting and Pooh and Piglet Nearly Catch a Woozle', 'A.A. Milne', 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (73, 5);

INSERT INTO book (title, author, pages) VALUES ('InvestiGators', 'John Patrick Green', 208);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (74, 5);

INSERT INTO book (title, author, pages) VALUES ('The Sultan''s Admiral: Barbarossa: Pirate and Empire Builder', 'Ernle Bradford', 248);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (75, 25);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (75, 3);

INSERT INTO book (title, author, pages) VALUES ('The Puck Player', 'G.N. Wright', 416);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (76, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (76, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (76, 50);

INSERT INTO book (title, author, pages) VALUES ('Learning to Grow', 'M.A. Innes', 296);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (77, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (77, 43);

INSERT INTO book (title, author, pages) VALUES ('A Terribly Strange Bed', 'Wilkie Collins', 48);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (78, 6);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (78, 47);

INSERT INTO book (title, author, pages) VALUES ('Smolder', 'Laurell K. Hamilton', 384);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (79, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (79, 43);

INSERT INTO book (title, author, pages) VALUES ('A False Proposal', 'Pamela Mingle', 284);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (80, 24);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (80, 43);

INSERT INTO book (title, author, pages) VALUES ('Money', 'Martin Amis', 454);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (81, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (81, 6);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (81, 52);

INSERT INTO book (title, author, pages) VALUES ('Blue Moon', 'Lori Handeland', 352);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (82, 43);

INSERT INTO book (title, author, pages) VALUES ('The Changeup', 'Nicole Falls', 144);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (83, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (83, 50);

INSERT INTO book (title, author, pages) VALUES ('Combust', 'K. Bromberg', 308);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (84, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (84, 43);

INSERT INTO book (title, author, pages) VALUES ('The Whitechaoel Conspiracy', 'Anne Perry', 352);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (85, 24);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (85, 34);

INSERT INTO book (title, author, pages) VALUES ('Beary Christmas, Baby', 'Sasha Devlin', 64);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (86, 43);

INSERT INTO book (title, author, pages) VALUES ('The Damned Vol. 1: Three Days Dead', 'Cullen Bunn', 160);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (87, 11);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (87, 22);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (87, 34);

INSERT INTO book (title, author, pages) VALUES ('The Sunshine Court', 'Nora Sakavic', 347);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (88, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (88, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (88, 50);

INSERT INTO book (title, author, pages) VALUES ('Goal Lines & First Times', 'Saxon James', 308);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (89, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (89, 26);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (89, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (89, 50);

INSERT INTO book (title, author, pages) VALUES ('Daughters of Shadow and Blood - Book I: Yasamin', 'J. Matthew Saunders', 398);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (90, 18);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (90, 24);

INSERT INTO book (title, author, pages) VALUES ('Like the Taste of Summer', 'Kaje Harper', 46);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (91, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (91, 43);

INSERT INTO book (title, author, pages) VALUES ('Inferno', 'Patrícia Melo', 310);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (92, 11);

INSERT INTO book (title, author, pages) VALUES ('The Senator''s Wife', 'Karen Robards', 448);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (93, 43);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (93, 34);

INSERT INTO book (title, author, pages) VALUES ('Love Song', 'Kylie Scott', 87);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (94, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (94, 43);

INSERT INTO book (title, author, pages) VALUES ('"What Do You Care What Other People Think?": Further Adventures of a Curious Character', 'Ralph Leighton', 288);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (95, 3);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (95, 44);

INSERT INTO book (title, author, pages) VALUES ('How to Build a Car: The Autobiography of the World''s Greatest Formula 1 Designer', 'Adrian Newey', 390);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (96, 2);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (96, 50);

INSERT INTO book (title, author, pages) VALUES ('Superman: For Tomorrow, Vol. 2', 'Jim Lee', 160);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (97, 7);

INSERT INTO book (title, author, pages) VALUES ('Life in the Pitlane', 'Calum Nicholas', 288);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (98, 50);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (98, 31);

INSERT INTO book (title, author, pages) VALUES ('Pendulum of Fate - Part 2', 'Patrick Laplante', 316);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (99, 18);

INSERT INTO book (title, author, pages) VALUES ('Where Rainbows End', 'Cecelia Ahern', 568);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (100, 9);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (100, 27);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (100, 43);

INSERT INTO book (title, author, pages) VALUES ('Rapport: Friendship, Solidarity, Communion, Empathy', 'Martha Wells', 32);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (101, 45);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (101, 47);

INSERT INTO book (title, author, pages) VALUES ('Edge of Oblivion', 'Patrick Laplante', 298);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (102, 18);

INSERT INTO book (title, author, pages) VALUES ('Words of Creation', 'Patrick Laplante', 361);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (103, 18);

INSERT INTO book (title, author, pages) VALUES ('Shattered Lands', 'Patrick Laplante', 314);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (104, 18);

INSERT INTO book (title, author, pages) VALUES ('Shifting Tides', 'Patrick Laplante', 283);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (105, 18);

INSERT INTO book (title, author, pages) VALUES ('Kindling', 'Patrick Laplante', 301);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (106, 18);

INSERT INTO book (title, author, pages) VALUES ('Corrupted Crimson', 'Patrick Laplante', 285);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (107, 18);

INSERT INTO book (title, author, pages) VALUES ('Light in the Darkness', 'Patrick Laplante', 225);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (108, 18);

INSERT INTO book (title, author, pages) VALUES ('Flea Circus Summer', 'Cheryl Ware', 144);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (109, 5);

INSERT INTO book (title, author, pages) VALUES ('Blood Moon', 'Patrick Laplante', 244);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (110, 18);

INSERT INTO book (title, author, pages) VALUES ('Chasing Life', 'Brandt Legg', 296);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (111, 52);

INSERT INTO book (title, author, pages) VALUES ('Only One Lie', 'Audrey J. Cole', 296);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (112, 24);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (112, 34);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (112, 52);

INSERT INTO book (title, author, pages) VALUES ('CapWar ELECTION', 'Brandt Legg', 382);
INSERT INTO book_to_genre (book_id, genre_id) VALUES (113, 52);