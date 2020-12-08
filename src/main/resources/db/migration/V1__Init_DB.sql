drop table if exists book cascade;
create table book (id int8 generated by default as identity,
    url_image varchar(255),
    author_id int8,
    genre_id int8,
    name varchar(255),
    price int8,
    rating float8,
    total_views int8,
    primary key (id)
    );

create table genre (genre_id int8 not null,
    name varchar(255),
    primary key (genre_id)
    );

create table author (author_id int8 not null,
    full_name varchar(255),
    primary key (author_id)
    );

alter table if exists book
    add constraint author_id_fk
    foreign key (author_id) references author;

alter table if exists book
    add constraint genre_id_fk
    foreign key (genre_id) references genre;
