drop database Hotel;

Create database Hotel;
use Hotel;

CREATE TABLE Room (
    RoomNumber INT PRIMARY KEY,
    RoomType VARCHAR(50),
    Amenities VARCHAR(255),
    ADAAccessible VARCHAR(5), -- 'Yes' or 'No'
    StandardOccupancy INT,
    MaximumOccupancy INT,
    BasePrice DECIMAL(10, 2),
    ExtraPersonFee DECIMAL(10, 2)
);

INSERT INTO Room (RoomNumber, RoomType, Amenities, ADAAccessible, StandardOccupancy, MaximumOccupancy, BasePrice, ExtraPersonFee) VALUES 
(201, 'Double', 'Microwave, Jacuzzi', 'No', 2, 4, 199.99, 10),
(202, 'Double', 'Refrigerator', 'Yes', 2, 4, 174.99, 10),
(203, 'Double', 'Microwave, Jacuzzi', 'No', 2, 4, 199.99, 10),
(204, 'Double', 'Refrigerator', 'Yes', 2, 4, 174.99, 10),
(205, 'Single', 'Microwave, Refrigerator, Jacuzzi', 'No', 2, 2, 174.99, NULL),
(206, 'Single', 'Microwave, Refrigerator', 'Yes', 2, 2, 149.99, NULL),
(207, 'Single', 'Microwave, Refrigerator, Jacuzzi', 'No', 2, 2, 174.99, NULL),
(208, 'Single', 'Microwave, Refrigerator', 'Yes', 2, 2, 149.99, NULL),
(301, 'Double', 'Microwave, Jacuzzi', 'No', 2, 4, 199.99, 10),
(302, 'Double', 'Refrigerator', 'Yes', 2, 4, 174.99, 10),
(303, 'Double', 'Microwave, Jacuzzi', 'No', 2, 4, 199.99, 10),
(304, 'Double', 'Refrigerator', 'Yes', 2, 4, 174.99, 10),
(305, 'Single', 'Microwave, Refrigerator, Jacuzzi', 'No', 2, 2, 174.99, NULL),
(306, 'Single', 'Microwave, Refrigerator', 'Yes', 2, 2, 149.99, NULL),
(307, 'Single', 'Microwave, Refrigerator, Jacuzzi', 'No', 2, 2, 174.99, NULL),
(308, 'Single', 'Microwave, Refrigerator', 'Yes', 2, 2, 149.99, NULL),
(401, 'Suite', 'Microwave, Refrigerator, Oven', 'Yes', 3, 8, 399.99, 20),
(402, 'Suite', 'Microwave, Refrigerator, Oven', 'Yes', 3, 8, 399.99, 20);

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(255),
    Address VARCHAR(255),
    City VARCHAR(100),
    State VARCHAR(2),
    Zip VARCHAR(10),
    Phone VARCHAR(20)
);

INSERT INTO Customer (CustomerID, Name, Address, City, State, Zip, Phone)
VALUES 
(1, 'Meixia Sindelar', '21W581 St. Charles Rd.', 'Glen Ellyn', 'IL', '60558', '(555) 555-5555'),
(2, 'Mack Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '(291) 553-0508'),
(3, 'Bettyann Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654', '(478) 277-9632'),
(4, 'Duane Cullison', '9662 Foxrun Lane', 'Harlingen', 'TX', '78552', '(308) 494-0198'),
(5, 'Karie Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '(214) 730-0298'),
(6, 'Aurore Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '(377) 507-0974'),
(7, 'Zachery Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003', '(814) 485-2615'),
(8, 'Jeremiah Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '(279) 491-0960'),
(9, 'Walter Holaway', '7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '(446) 396-6785'),
(10, 'Wilfred Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '(834) 727-1001'),
(11, 'Maritza Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '(446) 351-6860'),
(12, 'Joleen Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '(231) 893-2755');

CREATE TABLE Reservation (
    ReservationID INT PRIMARY KEY,
    RoomNumber INT,
    CustomerID INT,
    Adults INT,
    Children INT,
    StartDate DATE,
    EndDate DATE,
    TotalRoomCost DECIMAL(10, 2),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) -- Assuming a Customer table exists
);

INSERT INTO Reservation (ReservationID, RoomNumber, CustomerID, Adults, Children, StartDate, EndDate, TotalRoomCost) VALUES
(1, 308, 2, 1, 0, '2023-02-02', '2023-02-04', 299.98),
(2, 203, 3, 2, 1, '2023-02-05', '2023-02-10', 999.95),
(3, 305, 4, 2, 0, '2023-02-22', '2023-02-24', 349.98),
(4, 201, 5, 2, 2, '2023-03-06', '2023-03-07', 199.99),
(5, 307, 1, 1, 1, '2023-03-17', '2023-03-20', 524.97),
(6, 302, 6, 3, 0, '2023-03-18', '2023-03-23', 924.95),
(7, 202, 7, 2, 2, '2023-03-29', '2023-03-31', 349.98),
(8, 304, 8, 2, 0, '2023-03-31', '2023-04-05', 874.95),
(9, 301, 9, 1, 0, '2023-04-09', '2023-04-13', 799.96),
(10, 207, 10, 1, 1, '2023-04-23', '2023-04-24', 174.99),
(11, 401, 11, 2, 4, '2023-05-30', '2023-06-02', 1199.97),
(12, 206, 12, 2, 0, '2023-06-10', '2023-06-14', 599.96),
(13, 208, 12, 1, 0, '2023-06-10', '2023-06-14', 599.96),
(14, 304, 6, 3, 0, '2023-06-17', '2023-06-18', 184.99),
(15, 205, 1, 2, 0, '2023-06-28', '2023-07-02', 699.96),
(16, 204, 9, 3, 1, '2023-07-13', '2023-07-14', 184.99),
(17, 401, 10, 4, 2, '2023-07-18', '2023-07-21', 1259.97),
(18, 303, 3, 2, 1, '2023-07-28', '2023-07-29', 199.99),
(19, 305, 3, 1, 0, '2023-08-30', '2023-09-01', 349.98),
(20, 208, 2, 2, 0, '2023-09-16', '2023-09-17', 149.99),
(21, 203, 5, 2, 2, '2023-09-13', '2023-09-15', 399.98),
(22, 401, 4, 2, 2, '2023-11-22', '2023-11-25', 1199.97),
(23, 206, 2, 2, 0, '2023-11-22', '2023-11-25', 449.97),
(24, 301, 2, 2, 2, '2023-11-22', '2023-11-25', 599.97),
(25, 302, 11, 2, 0, '2023-12-24', '2023-12-28', 699.96);

CREATE TABLE CustomerReservations (
    CustomerID INT,
    ReservationID INT,
    PRIMARY KEY (CustomerID, ReservationID),  -- Composite primary key
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),  -- Assuming Customer table exists
    FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)  -- Assuming Reservation table exists
);

INSERT INTO CustomerReservations (CustomerID, ReservationID) VALUES
(2, 1),
(3, 2),
(4, 3),
(5, 4),
(1, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(12, 13),
(6, 14),
(1, 15),
(9, 16),
(10, 17),
(3, 18),
(3, 19),
(2, 20),
(5, 21),
(4, 22),
(2, 23),
(2, 24),
(11, 15);