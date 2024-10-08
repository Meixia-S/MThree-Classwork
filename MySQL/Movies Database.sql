create database Movies;
use Movies;

-- Create the Genre table
CREATE TABLE Genre (
    GenreID INT PRIMARY KEY,
    GenreName VARCHAR(30) NOT NULL
);

-- Create the Director table
CREATE TABLE Director (
    DirectorID INT PRIMARY KEY,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE NULL
);

-- Create the Rating table
CREATE TABLE Rating (
    RatingID INT PRIMARY KEY,
    RatingName CHAR(5) NOT NULL
);

-- Create the Movie table
CREATE TABLE Movie (
    MovieID INT PRIMARY KEY,
    GenreID INT NOT NULL,
    DirectorID INT NULL,
    RatingID INT NULL,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE NULL,
    FOREIGN KEY (GenreID) REFERENCES Genre(GenreID),
    FOREIGN KEY (DirectorID) REFERENCES Director(DirectorID),
    FOREIGN KEY (RatingID) REFERENCES Rating(RatingID)
);

-- Create the Actor table
CREATE TABLE Actor (
    ActorID INT PRIMARY KEY,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE NULL
);

-- Create the CastMembers table
CREATE TABLE CastMembers (
    CastMemberID INT PRIMARY KEY,
    ActorID INT NOT NULL,
    MovieID INT NOT NULL,
    Role VARCHAR(50) NOT NULL,
    FOREIGN KEY (ActorID) REFERENCES Actor(ActorID),
    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID)
);
