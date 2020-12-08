insert into genre (genre_id, name)
    values (10, 'Фентези');

insert into genre (genre_id, name)
    values (20, 'Роман');

insert into genre (genre_id, name)
    values (30, 'Компьютерная');

insert into genre (genre_id, name)
    values (40, 'Повесть');

insert into author (author_id, full_name)
    values (1, 'Дж. К. Роулинг');

insert into author (author_id, full_name)
    values (2, 'Толстой Л.Н.');

insert into author (author_id, full_name)
    values (3, 'Кейденхед Роджер');

insert into author (author_id, full_name)
    values (4, 'Куприн А.И.');

insert into book (id, name, price, total_views, rating, url_image, genre_id, author_id)
    values (1, 'Гарри Поттер и Кубок огня', 1200, 128, 9.0, 'https://img-gorod.ru/24/412/2441276_detail.jpg', 10, 1);

insert into book (id, name, price, total_views, rating, url_image, genre_id, author_id)
    values (2, 'Война и мир', 900, 89, 9.2, 'https://m.media-amazon.com/images/I/51q8voM3-jL.jpg', 20, 2);

insert into book (id, name, price, total_views, rating, url_image, genre_id, author_id)
    values (3, 'Анна Каренина', 900, 80, 8.9, 'https://cdn1.ozone.ru/s3/multimedia-5/6009081221.jpg', 20, 2);

insert into book (id, name, price, total_views, rating, url_image, genre_id, author_id)
    values (4, 'Java за 24 часа', 1300, 150, 9.5, 'https://cdn1.ozone.ru/multimedia/wc1200/1026506512.jpg', 30, 3);

insert into book (id, name, price, total_views, rating, url_image, genre_id, author_id)
    values (5, 'Гранатовый браслет', 1100, 70, 7.3, 'https://www.ukazka.ru/img/b/uk736845.jpg', 40, 4);





