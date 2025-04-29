-- Inserção dos tipos sanguíneos
INSERT INTO tipos_sanguineos (tipo) VALUES('A+'), ('A-'), ('B+'), ('B-'), ('AB+'), ('AB-'), ('O+'), ('O-');

-- Inserção das relações de doações possíveis
INSERT INTO doacoes_possiveis (doador_id, receptor_id) VALUES
    (1, 1), (1, 5),
    (2, 1), (2, 2), (2, 5), (2, 6),
    (3, 3), (3, 5),
    (4, 3), (4, 4), (4, 5), (4, 6),
    (5, 5),
    (6, 5), (6, 6),
    (7, 1), (7, 3), (7, 5), (7, 7),
    (8, 1), (8, 2), (8, 3), (8, 4), (8, 5), (8, 6), (8, 7), (8, 8);

-- Inserção das relações de recebimentos possíveis
INSERT INTO recebimentos_possiveis (receptor_id, doador_id) VALUES
    (1, 1), (1, 2), (1, 7), (1, 8),
    (2, 2), (2, 8),
    (3, 3), (3, 4), (3, 7), (3, 8),
    (4, 4), (4, 8),
    (5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8),
    (6, 2), (6, 4), (6, 6), (6, 8),
    (7, 7), (7, 8),
    (8, 8);
