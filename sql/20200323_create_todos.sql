create table todos
(
  id SERIAL PRIMARY KEY
  ,name VARCHAR(100) NOT NULL
  ,date_added DATE DEFAULT NOW()
  ,done BOOLEAN DEFAULT FALSE
);
