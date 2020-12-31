create table genre
(
    genre_id bigserial primary key,
    name     varchar(255)
);

create table author
(
    author_id bigserial primary key,
    full_name varchar(255)
);
create table book
(
    id          bigserial primary key,
    url_image   varchar(255),
    author_id   bigint references author (author_id),
    genre_id    bigint references genre (genre_id),
    name        varchar(255),
    price       bigint,
    rating      double precision,
    total_views bigint
);
