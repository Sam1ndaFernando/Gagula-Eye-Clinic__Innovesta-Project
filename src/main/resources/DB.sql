create database gangulaWedaMedura;

use gangulaWedaMedura;

create table reception(
                          repId varchar(25) primary key,
                          name text,
                          email text not null
);

create table attendance(
                           atId varchar(25) primary key,
                           date date,
                           time varchar(25)
);

create table employee(
                         empId varchar(25) primary key,
                         name text,
                         address text,
                         contactNum varchar(20),
                         jobRole varchar(50),
                         joinedDate date
);

create table salary(
                       salaryId varchar(25) primary key,
                       amount double(10,2),
                       atId varchar(25),
                       empId varchar(25),
                       foreign key(empId) references employee(empId) on update cascade on delete cascade,
                       foreign key(atId) references attendance(atId) on update cascade on delete cascade
);


create table doctor(
                       docId varchar(25) primary key,
                       name text,
                       email text,
                       mrId varchar(25)
);

create table patient(
                        patId varchar(25)primary key,
                        name text,
                        address text,
                        age int,
                        nic varchar(20),
                        contactNum varchar(20),
                        gender varchar(10),
                        docId varchar(25),
                        foreign key(docId) references doctor(docId) on update cascade on delete cascade
);


create table medicalReport(
                              mrId varchar(25) primary key,
                              pic1 longblob,
                              pic2 longblob,
                              patId varchar(25),
                              foreign key(patId) references patient(patId) on update cascade on delete cascade
);

create table supplier(
                         supId varchar(25) primary key,
                         name text,
                         address text,
                         email text,
                         nic varchar(20),
                         contactNum varchar(20)
);

create table rawMaterial(
                            rawId varchar(25) primary key,
                            name text,
                            qty int,
                            category text,
                            supId varchar(25),
                            foreign key(supId) references supplier(supId) on update cascade on delete cascade
);




create table medicine(
                         medId varchar(25) primary key,
                         name text,
                         description text
);

create table bill(
                     billId varchar(25 )primary key,
                     price double(10,2),
                     patId varchar(25),
                     medId varchar(25),
                     foreign key(patId) references patient(patId) on update cascade on delete cascade,
                     foreign key(medId) references medicine(medId) on update cascade on delete cascade
);

create table appointments(
                             appId varchar(25) primary key,
                             date date,
                             time varchar(10),
                             purpose text,
                             docId varchar(25),
                             patId varchar(25),
                             foreign key(docId) references doctor(docId) on update cascade on delete cascade,
                             foreign key(patId) references patient(patId) on update cascade on delete cascade
);
