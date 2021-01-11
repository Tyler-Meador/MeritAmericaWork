
  
CREATE TABLE Account_Holder (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  middle_name VARCHAR(250),
  last_name VARCHAR(250) NOT NULL,
  ssn VARCHAR(250) NOT NULL
);

CREATE TABLE users(
	id INT,
	username VARCHAR(50) not null primary key,
	password VARCHAR(50) not null,
	enabled boolean not null,
	role VARCHAR(50) not null
);

CREATE TABLE authorities(
	id INT,
	username VARCHAR(50) not null,
	authority VARCHAR(50) not null,
	constraint fk_authorities_id foreign key(id) references users(id)
);

create unique index ix_auth_username on authorities (username, authority);


