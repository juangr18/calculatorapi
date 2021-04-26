CREATE TABLE Tech(
    `id` VARCHAR(36) NOT NULL,
    `idTech` VARCHAR(10) NOT NULL,
    `idService` VARCHAR(36) NOT NULL,
    `horaInicio` TIMESTAMP NOT NULL,
    `horaFinal` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
);