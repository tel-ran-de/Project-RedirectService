
CREATE TABLE urls (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  long_url varchar(2048),
  short_url varchar(2048)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into urls (id, long_url, short_url) values ('1', 'https://en.wikipedia.org/wiki/Road_Rash_(1994_video_game)',
                                                   'server/urls/99999');
