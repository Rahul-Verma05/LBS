INSERT INTO user_card (id,userId) VALUES
(1), (2), (3), (4), (5), (6), (7), (8), (9), (10);



INSERT INTO user (
    id, first_name, last_name, address, user_card_id, created_at
) VALUES
    (1, 'Alice', 'Johnson', '123 Library St', 1, NOW()),
    (2, 'Bob', 'Smith', '456 Book Rd', 2, NOW()),
    (3, 'Charlie', 'Brown', '789 Read Ave', 3, NOW()),
    (4, 'Diana', 'Prince', '101 Novel Ln', 4, NOW()),
    (5, 'Ethan', 'Hunt', '202 Fiction Blvd', 5, NOW()),
    (6, 'Fiona', 'Gallagher', '303 Mystery Ct', 6, NOW()),
    (7, 'George', 'Miller', '404 Page Pkwy', 7, NOW()),
    (8, 'Hannah', 'Montana', '505 Chapter Dr', 8, NOW()),
    (9, 'Ian', 'Wright', '606 Shelf Way', 9, NOW()),
    (10, 'Julia', 'Roberts', '707 Author Cir',  10, NOW());




INSERT INTO book (
     id, name, author, publishing_house, published_date, user_card_id, created_at, book_status
) VALUES
    (1, 'Clean Code', 'Robert C. Martin', 'Prentice Hall', '2008-08-01', 1, NOW(), 'BORROWED'),
    (2, 'Effective Java', 'Joshua Bloch', 'Addison-Wesley', '2018-01-06', 2, NOW(), 'BORROWED'),
    (3, 'Design Patterns', 'Erich Gamma', 'Addison-Wesley', '1994-10-31', 3, NOW(), 'BORROWED'),
    (4, 'The Pragmatic Programmer', 'Andrew Hunt', 'Addison-Wesley', '1999-10-30', 4, NOW(), 'BORROWED'),
    (5, 'Refactoring', 'Martin Fowler', 'Addison-Wesley', '1999-07-08', 5, NOW(), 'BORROWED'),
    (6, 'Head First Java', 'Kathy Sierra', 'O\'Reilly Media', '2005-02-09', NULL, NOW(), 'AVAILABLE'),
    (7, 'Java Concurrency in Practice', 'Brian Goetz', 'Addison-Wesley', '2006-05-19', NULL, NOW(), 'AVAILABLE'),
    (8, 'Spring in Action', 'Craig Walls', 'Manning', '2018-09-30', 6, NOW(), 'BORROWED'),
    (9, 'Microservices Patterns', 'Chris Richardson', 'Manning', '2018-11-19', 7, NOW(), 'BORROWED'),
    (10, 'Cracking the Coding Interview', 'Gayle Laakmann McDowell', 'CareerCup', '2015-07-01', NULL, NOW(), 'AVAILABLE');




