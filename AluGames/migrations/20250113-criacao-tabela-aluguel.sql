CREATE TABLE aluguel (
                         id INT NOT NULL AUTO_INCREMENT,
                         dataFinal DATE DEFAULT NULL,
                         dataInicial DATE DEFAULT NULL,
                         emDias INT NOT NULL,
                         valorDoAluguel DOUBLE NOT NULL,
                         gamer_id INT DEFAULT NULL,
                         jogo_id INT DEFAULT NULL,
                         PRIMARY KEY (id),
                         KEY fk_gamer_id (gamer_id),
                         KEY fk_jogo_id (jogo_id),
                         CONSTRAINT fk_gamer FOREIGN KEY (jogo_id) REFERENCES jogos (id),
                         CONSTRAINT fk_jogo FOREIGN KEY (gamer_id) REFERENCES gamers (id)
);