Create database if not exists PetShop;
Use PetShop;

-- Create the Customers table
CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    Address VARCHAR(255)
);

-- Create the Pets table
CREATE TABLE Pets (
    PetID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    PetName VARCHAR(50) NOT NULL,
    PetType VARCHAR(50) NOT NULL, -- e.g., Dog, Cat, etc.
    Breed VARCHAR(50),
    Age INT,
    Weight DECIMAL(5, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

-- Create the Services table
CREATE TABLE Services (
    ServiceID INT PRIMARY KEY AUTO_INCREMENT,
    ServiceName VARCHAR(100) NOT NULL,
    Description TEXT,
    Price DECIMAL(10, 2) NOT NULL
);

-- Create the Appointments table
CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY AUTO_INCREMENT,
    PetID INT,
    ServiceID INT,
    AppointmentDate DATETIME NOT NULL,
    AppointmentTime TIME NOT NULL,
    Notes TEXT,
    FOREIGN KEY (PetID) REFERENCES Pets(PetID),
    FOREIGN KEY (ServiceID) REFERENCES Services(ServiceID)
);

-- Create the Employees table
CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    Position VARCHAR(50)
);

-- Create the Appointment_Employee table to handle many-to-many relationship
CREATE TABLE Appointment_Employee (
    AppointmentID INT,
    EmployeeID INT,
    PRIMARY KEY (AppointmentID, EmployeeID),
    FOREIGN KEY (AppointmentID) REFERENCES Appointments(AppointmentID),
    FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
);
