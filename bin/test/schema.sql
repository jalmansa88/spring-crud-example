CREATE SCHEMA IF NOT EXISTS testdb AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS testdb.mitarbeiter (
  `id` bigint(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `age` int(2) NOT NULL,
  `projekte_id` bigint(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS testdb.projekte (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);