INSERT INTO USERS (FIRST_NAME, MIDDLE_NAME, LAST_NAME, PHONE, email, password)
VALUES ('User','us','la','123123', 'user@yandex.ru', '{noop}password'),
       ('Admin','ad','la','123123', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLES (USER_ID, ROLE)
VALUES  (1, 'USER'),
        (2, 'ADMIN'),
        (2, 'USER')