CREATE TABLE "myuser" (
  "id" SERIAL PRIMARY KEY,
  "name" varchar NOT NULL,
  "username" varchar UNIQUE NOT NULL,
  "password" varchar NOT NULL,
  "phone_number" int,
  "address" varchar,
  "age" smallint
);
