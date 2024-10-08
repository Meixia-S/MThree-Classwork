CREATE DATABASE Books;
USE Books;

-- Create the Author table
CREATE TABLE Author (
    AuthorId INT PRIMARY KEY,
    FirstName VARCHAR(25),
    MiddleName VARCHAR(25),
    LastName VARCHAR(50),
    Gender CHAR(1),
    DateOfBirth DATETIME,
    DateOfDeath DATETIME
);

-- Create the Book table
CREATE TABLE Book (
    BookId INT PRIMARY KEY,
    Title VARCHAR(100),
    PublicationDate DATETIME
);

-- Create the Format table
CREATE TABLE Format (
    FormatId INT PRIMARY KEY,
    FormatName VARCHAR(12)
);

-- Create the Genre table
CREATE TABLE Genre (
    GenreId INT PRIMARY KEY,
    GenreName VARCHAR(25)
);

-- Create the AuthorBook table (junction table for many-to-many relationship between Author and Book)
CREATE TABLE AuthorBook (
    AuthorId INT,
    BookId INT,
    PRIMARY KEY (AuthorId, BookId),
    FOREIGN KEY (AuthorId) REFERENCES Author(AuthorId),
    FOREIGN KEY (BookId) REFERENCES Book(BookId)
);

-- Create the BookFormat table (junction table for many-to-many relationship between Book and Format)
CREATE TABLE BookFormat (
    BookId INT,
    FormatId INT,
    Price DOUBLE,
    QuantityOnHand INT,
    PRIMARY KEY (BookId, FormatId),
    FOREIGN KEY (BookId) REFERENCES Book(BookId),
    FOREIGN KEY (FormatId) REFERENCES Format(FormatId)
);

-- Create the BookGenre table (junction table for many-to-many relationship between Book and Genre)
CREATE TABLE BookGenre (
    BookId INT,
    GenreId INT,
    PRIMARY KEY (BookId, GenreId),
    FOREIGN KEY (BookId) REFERENCES Book(BookId),
    FOREIGN KEY (GenreId) REFERENCES Genre(GenreId)
);
