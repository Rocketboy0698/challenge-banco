-- Tabla Cliente
CREATE TABLE Cliente (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    genero VARCHAR(50),
    edad INT,
    direccion VARCHAR(255),
    telefono VARCHAR(50),
    contrasena VARCHAR(255),
    estado BOOLEAN
);

-- Tabla Cuenta
CREATE TABLE Cuenta (
    id BIGINT PRIMARY KEY,
    numeroCuenta VARCHAR(20) NOT NULL,
    tipoCuenta VARCHAR(50),
    saldoInicial DECIMAL(10,2),
    estado BOOLEAN,
    cliente_id BIGINT,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

-- Tabla Movimiento
CREATE TABLE Movimiento (
    id BIGINT PRIMARY KEY,
    fecha TIMESTAMP,
    tipoMovimiento VARCHAR(50),
    valor DECIMAL(10,2),
    saldo DECIMAL(10,2),
    cuenta_id BIGINT,
    FOREIGN KEY (cuenta_id) REFERENCES Cuenta(id)
);
