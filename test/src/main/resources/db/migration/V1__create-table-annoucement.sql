CREATE TABLE Announcement (
    id bigint not null unique,
    link VARCHAR(150) not null,
	title VARCHAR(150) not null,
	content text not null,
    date DATETIME not null,
    primary key(id)
);