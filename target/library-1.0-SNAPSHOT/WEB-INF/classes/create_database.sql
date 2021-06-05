CREATE DATABASE test
    WITH OWNER "postgres"
    ENCODING 'UTF8'
    LC_COLLATE = 'en-EN.UTF-8'
    LC_CTYPE = 'en-EN.UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE films
(
    id SERIAL UNIQUE ,
    title character varying(100) NOT NULL,
    year integer,
    genre character varying(20),
    watched boolean DEFAULT false  NOT NULL,
    PRIMARY KEY (id)
);
CREATE UNIQUE INDEX films_title_uindex ON films (title);

INSERT INTO "films" ("title","year","genre", watched)
VALUES
('Inception', 2010, 'sci-fi', true),
('The Lord of the Rings: The Fellowship of the Ring', 2001, 'fantasy', true),
('Tag', 2018, 'comedy', false),
('Gunfight at the O.K. Corral', 1957, 'western', false),
('Die Hard', 1988, 'action', true);