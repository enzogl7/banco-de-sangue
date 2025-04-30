CREATE TABLE tipos_sanguineos (id SERIAL PRIMARY KEY,tipo VARCHAR(3) NOT NULL);

CREATE TABLE doacoes_possiveis ( doador_id BIGINT NOT NULL, receptor_id BIGINT NOT NULL, PRIMARY KEY (doador_id, receptor_id),
                                 FOREIGN KEY (doador_id) REFERENCES tipos_sanguineos(id),
                                 FOREIGN KEY (receptor_id) REFERENCES tipos_sanguineos(id));

CREATE TABLE recebimentos_possiveis (receptor_id BIGINT NOT NULL,doador_id BIGINT NOT NULL,
                                        PRIMARY KEY (receptor_id, doador_id),
                                        FOREIGN KEY (receptor_id) REFERENCES tipos_sanguineos(id),
                                        FOREIGN KEY (doador_id) REFERENCES tipos_sanguineos(id)
);
