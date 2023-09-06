create database gangulaWedaMedura;

use gangulaWedaMedura;

create table reception(
                          repId varchar(10) primary key,
                          name varchar(15) not null,
                          email text not null
);

create table attendance(
                           atId varchar(10) primary key,
                           date date,
                           time varchar(10)
);

create table staff(
                      staffId varchar(10) primary key,
                      name text,
                      address text,
                      contactNum varchar(20),
                      jobRole varchar(20)
);

create table salary(
                       salaryId varchar(10) primary key,
                       amount double(10,2),
	atId varchar(10),
	staffId varchar(10),
	foreign key(staffId) references staff(staffId) on update cascade on delete cascade,
	foreign key(atId) references attendance(atId) on update cascade on delete cascade
);


create table doctor(
                       docId varchar(10) primary key,
                       name text not null,
                       email text not null,
                       mrId varchar(10)
);


create table patient(
                        patId varchar(10)primary key,
                        name text,
                        address text,
                        age int,
                        nic varchar(20),
                        contactNum varchar(20),
                        docId varchar(10),
                        foreign key(docId) references doctor(docId) on update cascade on delete cascade
);


create table medicalReport(
                              mrId varchar(10) primary key,
                              docId varchar(10),
                              foreign key(docId) references doctor(docId) on update cascade on delete cascade
);

create table supplier(
                         supId varchar(10) primary key,
                         name text,
                         address text,
                         age int,
                         nic varchar(20),
                         contactNum varchar(20)
);

create table rawMaterial(
                            rawId varchar(10) primary key,
                            name text,
                            type text,
                            qty int,
                            supId varchar(10),
                            foreign key(supId) references supplier(supId) on update cascade on delete cascade
);




create table medicine(
                         medId varchar(10) primary key,
                         name text,
                         description text,
                         qty int
);

create table bill(
                     billId varchar(10 )primary key,
                     price double(10,2),
	patId varchar(10),
	medId varchar(10),
	foreign key(patId) references patient(patId) on update cascade on delete cascade,
	foreign key(medId) references medicine(medId) on update cascade on delete cascade
);

create table appointments(
                             appId varchar(10) primary key,
                             date date,
                             time varchar(10),
                             purpose text,
                             docId varchar(10),
                             repId varchar(10),
                             foreign key(docId) references doctor(docId) on update cascade on delete cascade,
                             foreign key(repId) references reception(repId) on update cascade on delete cascade
);




insert into reception values("001","Kasun Madushan","kasunmadushan@gmail.com");
insert into reception values("002","Pasindu Lakshan","pasindulakshan@gmail.com");
insert into reception values("003","Kasun Madushan","kasunmadushan@gmail.com");
insert into reception values("004","Minidu Lakshan","manidulakshan@gmail.com");
insert into reception values("005","Ashen Saluka","ashensaluka@gmail.com");
insert into reception values("006","Pasindu Yapa","pasinduyapa@gmail.com");
insert into reception values("007","Udeera Kushan","udeerakushan@gmail.com");
insert into reception values("008","Sanuka Perera","sanukaperera@gmail.com");
insert into reception values("009","Malki Peiris","malkipeiris@gmail.com");
insert into reception values("010","Ishara Lakshan","isharalakshan@gmail.com");


insert into attendance values("001","2023-01-20","11.30");
insert into attendance values("002","2023-11-22","11.30");
insert into attendance values("003","2023-01-25","15.30");
insert into attendance values("004","2023-05-14","08.30");
insert into attendance values("005","2023-11-25","09.45");
insert into attendance values("006","2023-12-15","14.45");
insert into attendance values("007","2023-12-15","15.15");
insert into attendance values("008","2023-12-15","10.00");
insert into attendance values("009","2023-12-15","11.00");
insert into attendance values("010","2023-12-15","09.30");


insert into staff values("001","Wasantha Perera"," 213, Grandpass Road, colombo","0761501544","Ayurvedic Healers");
insert into staff values("002","Sunil Appuhami","277/1, Galle Road, Idama","0118456233","Payment Handler");
insert into staff values("003","Gihan Madushan","1st Chapel Lane,Colombo","0715623846","Clarks");
insert into staff values("004","Chamila Perera","17 Street, Johns Road,Panadura","0764815236","Payment Handler");
insert into staff values("005","Kamal Bandara","192A 2nd Cross Street,Colombo 11","0721595481","Clarks");
insert into staff values("006","Nalaka Deshan","5/11, Meda Mawatha,Horana","0764585152","Clarks");
insert into staff values("007","Nuwan Thennakoon","Sri Lankaramaya Serpentine Road,Maharagama","0754865711","Ayurvedic Healers");
insert into staff values("008","Susil Perera","219, Stanley Thilakarathna Mawatha,Nugegoda","0712536451","Clarks");
insert into staff values("009","Lara peiris","80 3rd Cross Street,Colombo 11","0765142311","Payment Handler");
insert into staff values("010","Udara Dhammika","2/404, Thalawathugoda rd,Polonnaruwa","0112364572","Payment Handler");



insert into salary values("001","30000","001","001");
insert into salary values("002","41000","002","002");
insert into salary values("003","39000","003","003");
insert into salary values("004","45000","004","004");
insert into salary values("005","36000","005","005");
insert into salary values("006","25000","006","006");
insert into salary values("007","34000","007","007");
insert into salary values("008","10000","008","008");
insert into salary values("009","30000","009","009");
insert into salary values("010","40100","010","010");


insert into doctor values("001","Kusal Gunasekara","kusalgunasekara@gmailo.com","001");
insert into doctor values("002","Senumi Minodya","senumiminodya@gmailo.com","002");
insert into doctor values("003","Tharushi Kawodya","tharushikawodya@gmailo.com","003");
insert into doctor values("004","Minura Wijewikrama","minurawijewikrama@gmail.com","004");
insert into doctor values("005","Nishan Tharaka","nishantharka@gmailo.com","005");
insert into doctor values("006","Pasindu Akalanka","pasidnuakalanka@gmail.com","006");
insert into doctor values("007","Piumini Rashmika","piuminirashmika@gmailo.com","007");
insert into doctor values("008","Nadil Sanjula","nadilsanjula@gmailo.com","008");
insert into doctor values("009","Sandul Rusara","sandulrusara@gmailo.com","009");
insert into doctor values("010","Sithmi Sanjula","sithmisanjula@gmailo.com","010");



insert into patient values("001","Mahinda Rajapaksha","83, Colombo Road,Colombo",22,"4789645756210","0786578965","001");
insert into patient values("002","Namal Rajapaksha","81, Colombo Road,Colombo",32,"156945756210","0786515485","002");
insert into patient values("003","Ghotabaya Rajapaksha","22, Colombo Road,Colombo",40,"145645756210","0786570123","003");
insert into patient values("004","Ranil Wikramasinghe","01, Colombo Road,Colombo",85,"255645756210","0745578965","004");
insert into patient values("005","Sajith Premadasa","05, Colombo Road,Colombo",15,"451205756210","0725678965","005");
insert into patient values("006","Ranjan Ramanayaka","145, Colombo Road,Colombo",56,"999645756210","0710578965","006");
insert into patient values("007","Basil Rajapaksa","023, Colombo Road,Colombo",48,"652445756210","0745688965","007");
insert into patient values("008","Nipuna Ranawaka","112, Colombo Road,Colombo",75,"728845756210","0712678965","008");
insert into patient values("009","Shiranthi Rajapaksha","014, Colombo Road,Colombo",14,"125214756210","0751428965","009");
insert into patient values("010","Mahinda Rajapaksha","456, Colombo Road,Colombo",96,"115620756210","0746908965","010");


insert into medicalReport values("001","001");
insert into medicalReport values("002","002");
insert into medicalReport values("003","003");
insert into medicalReport values("004","004");
insert into medicalReport values("005","005");
insert into medicalReport values("006","006");
insert into medicalReport values("007","007");
insert into medicalReport values("008","008");
insert into medicalReport values("009","009");
insert into medicalReport values("010","010");


insert into supplier values("001","Indika thotawatta","158 2/ Galle Road, Colombo",22,"200132620152","0710336541");
insert into supplier values("002","Darshana Sandaruwan","280 Dam Street, Colombo",35,"123578695203","0761501452");
insert into supplier values("003","Damith Harsha","171, AVALON ESTATE,horayayakurunegala",45,"200214562035","076150420");
insert into supplier values("004","Sampath Sandaruwan","158 1/3 Prince Street,Colombo",45,"199485123651","0761523648");
insert into supplier values("005","Viran Chathuranga","203 Union Place, Colombo",56,"198745610326","0741596548");
insert into supplier values("006","Tharindu Thennakoon","117 Hunupitiya Lake Road, Colombo",75,"487965123061","0112654856");
insert into supplier values("007","Sujith Aththanayaka","135 5A Keyzer Street, Colombo",46,"1654264951236","07152695410");
insert into supplier values("008","Chathuka Nimsara","309 High Level Road, Colombo",34,"423652016232","01125698410");
insert into supplier values("009","Shalitha Silva","26, Castle Lane,Colombo",32,"199878260231","0741502644");
insert into supplier values("010","Pathum Gimhana","92 2nd Cross Street, Colombo",34,"96541236548","0761236548");


insert into rawMaterial values("001","ginger","root",32,"001");
insert into rawMaterial values("002","Kohomba","Leaves",32,"002");
insert into rawMaterial values("003","Mango","Roots",32,"003");
insert into rawMaterial values("004","kohomda","leaves",32,"004");
insert into rawMaterial values("005","Nika","Leaves",32,"005");
insert into rawMaterial values("006","Akkapaana","Leaves",32,"006");
insert into rawMaterial values("007","Kuppameniya","Leaves",32,"007");
insert into rawMaterial values("008","Nelum","flowers",32,"008");
insert into rawMaterial values("009","Inguru","Roots",32,"009");
insert into rawMaterial values("010","Lemon","Flowers",32,"010");


insert into medicine values("001","Mukha Lepam","Pain ,Mental stress",30);
insert into medicine values("002","Balarishta","Daurbalya, Vataroga, Agnimandya, Karshya",300);
insert into medicine values("003","Kumaryasava","Rajodushti, Krichhrartav, Paktishula",310);
insert into medicine values("004","Balarishtaya"," Arishta, Herbal Health Care",20);
insert into medicine values("005","Bakuchi Thailaya","Herbal Health Care",10);


insert into bill values("001",20000,"001","001");
insert into bill values("002",10000,"002","002");
insert into bill values("003",35000,"003","003");
insert into bill values("004",14000,"004","004");
insert into bill values("005",4000,"005","005");


insert into appointments values("001","2011-12-11","11.30","Revisit","001","001");
insert into appointments values("002","2011-02-11","11.30","Meet Doctor","002","002");
insert into appointments values("003","2014-10-11","11.30","Revisit","003","003");
insert into appointments values("004","2020-02-11","11.30","Revisit","004","004");
insert into appointments values("005","2012-12-10","11.30","Meet Doctor","005","005");
insert into appointments values("006","2023-12-15","11.30","Revisit","006","006");