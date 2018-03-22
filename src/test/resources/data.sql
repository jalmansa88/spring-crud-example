INSERT INTO testdb.projekte (`id`, `name`, `date`) VALUES
(1, 'neue projekte', '2018-03-09 16:01:48'),
(2, 'advani projekte', '2018-03-09 16:01:48');

INSERT INTO testdb.mitarbeiter (`id`, `username`, `name`, `age`, `projekte_id`) VALUES
(1, 'almansaj', 'javier almansa', 29, 1),
(2, 'adveni', 'javier adveni', 26, 1),
(3, 'martos', 'nico martos', 29, 1),
(4, 'paco', 'francisco', 32, 1),
(12, 'pepe', 'jose', 31, 1),
(13, 'pepe3', 'jose', 31, 1),
(25, 'pepe4', 'jose', 31, 1),
(26, 'pepe5', 'jose', 31, 1),
(27, 'asdasd', 'jose', 31, 1),
(28, 'skywalker', 'luke', 31, 1);

COMMIT;