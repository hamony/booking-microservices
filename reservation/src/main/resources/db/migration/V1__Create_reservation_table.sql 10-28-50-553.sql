create table reservation (
    id bigint not null,
    full_name varchar(255) not null,
    email varchar(255) not null,
    phone_number varchar(255),
    room_number varchar(255) not null,
    price numeric(38,2) not null,
    check_in_date date, 
    check_out_date date,
    primary key (id)
);

create sequence reservation_seq start with 1 increment by 50;