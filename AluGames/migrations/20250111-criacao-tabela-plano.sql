CREATE TABLE planos
(
    TipoPlano      VARCHAR(31) NOT NULL,
    id             INT auto_increment
        PRIMARY KEY,
    tipo           VARCHAR(255) NULL,
    jogosIncluidos INT NULL,
    mensalidade DOUBLE NULL,
    percentualDescontoReputacao DOUBLE NULL
);

