
create table wallet(
  id serial not null primary key,
  userId integer,
  balance numeric(12,0)
)