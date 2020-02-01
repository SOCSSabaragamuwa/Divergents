create table user(
id int auto_increment NOT NULL PRIMARY KEY,
nic varchar(255),
mobile varchar(255),
password varchar(255)
);

create table vehicle(
vehicle_id int auto_increment not null PRIMARY KEY,
vehicleNumber varchar(255)
);