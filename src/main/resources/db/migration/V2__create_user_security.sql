CREATE TABLE "user"(
    id IDENTITY PRIMARY KEY,
    name VARCHAR (255),
    password VARCHAR (255),
    authorities VARCHAR (255)
);

INSERT INTO "user"(name, password, authorities)
VALUES
    ('user', '{noop}default', 'USER');