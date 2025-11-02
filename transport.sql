CREATE DATABASE transport;
USE transport;

CREATE TABLE buses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bus_name VARCHAR(100),
    source VARCHAR(100),
    destination VARCHAR(100),
    departure_time VARCHAR(50),
    arrival_time VARCHAR(50),
    price DOUBLE
);

INSERT INTO buses (bus_name, source, destination, departure_time, arrival_time, price)
VALUES
('City Express', 'Pune', 'Mumbai', '07:00', '10:30', 300),
('Metro Travels', 'Pune', 'Nagpur', '09:00', '17:00', 600),
('RapidLine', 'Mumbai', 'Pune', '11:00', '14:30', 320);
