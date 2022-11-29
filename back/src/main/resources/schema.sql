create table todos
(
    id          bigint       not null
        primary key,
    created_at  date         not null,
    description varchar(255),
    state       boolean      not null,
    title       varchar(255) not null
);

alter table todos
    owner to admin;