CREATE TABLE Empleado
(
  ideEmp Int NOT NULL AUTO_INCREMENT,
  dniEmp Varchar(8) NOT NULL,
  nomEmp Varchar(60),
  apeMatEmp Varchar(30),
  apePatEmp Varchar(30),
  sexEmp Char(1),
  estCivEmp Char(1),
  dirEmp Varchar(100),
  disEmp Varchar(50),
  emaEmp Varchar(30),
  telEmp Varchar(15),
  ideCar Int,
 PRIMARY KEY (ideEmp)
)
;

-- Table Usuario

CREATE TABLE Usuario
(
  ideUsu Varchar(50) NOT NULL,
  pssUsu Varchar(50) DEFAULT 123456,
  ideEmp Int,
  estBlqUsu Bool,
  blqAutUsu Bool,
  nivAccUsu Varchar(10)
)
;

ALTER TABLE Usuario ADD PRIMARY KEY (ideUsu)
;

-- Table Producto

CREATE TABLE Producto
(
  idePro Int NOT NULL AUTO_INCREMENT,
  desPro Varchar(100),
  cosPro Double,
  stkPro Int,
  idePrv Int,
 PRIMARY KEY (idePro)
)
;

-- Table Proveedor

CREATE TABLE Proveedor
(
  idePrv Int NOT NULL AUTO_INCREMENT,
  empPrv Varchar(100),
  nomPrv Varchar(60),
  apePrv Varchar(60),
  dirPrv Varchar(100),
  disPrv Varchar(60),
  ciuPrv Varchar(60),
  proPrv Varchar(60),
  emaPrv Varchar(30),
  telPrv Varchar(15),
 PRIMARY KEY (idePrv)
)
;

-- Table Pedido

CREATE TABLE Pedido
(
  idePed Int NOT NULL AUTO_INCREMENT,
  nomPed Varchar(60),
  nroMesPed Int,
  ideEmp Int,
  estado Bool, 
  fecHorPed Datetime,
 PRIMARY KEY (idePed)
)
;

-- Table DetalleDelPedido

CREATE TABLE DetalleDelPedido
(
  ideItm Int NOT NULL,
  idePed Int NOT NULL,
  cntDetPed Int,
  nomItm varchar(50),
  total  float(6,2)
)
;

ALTER TABLE DetalleDelPedido ADD PRIMARY KEY (ideItm,idePed)
;

-- Table Terminal

CREATE TABLE Terminal
(
  ideTer Int NOT NULL AUTO_INCREMENT,
  desTer Varchar(50),
  estBlqTer Bool,
 PRIMARY KEY (ideTer)
)
;

-- Table HistorialAcceso

CREATE TABLE HistorialAcceso
(
  ideHisAcc Int NOT NULL AUTO_INCREMENT,
  ideUsu Varchar(50),
  ideTer Int,
  horHisAcc Timestamp NULL,
  acnHisAcc Varchar(100),
 PRIMARY KEY (ideHisAcc)
)
;

-- Table HistorialLog

CREATE TABLE HistorialLog
(
  ideHisLog Int NOT NULL AUTO_INCREMENT,
  ideUsu Varchar(50),
  ideTer Int,
  horIniHisLog Time NULL,
  horFinHisLog Time NULL,
 PRIMARY KEY (ideHisLog)
)
;

-- Table Item

CREATE TABLE Item
(
  ideItm Int NOT NULL AUTO_INCREMENT,
  ideTipItm Int,
  desItm Varchar(100),
  preItm Float(6,2),
  idePro Int,
  dscItm Float(6,2) DEFAULT 0,
 PRIMARY KEY (ideItm)
)
;

-- Table TipoItem

CREATE TABLE TipoItem
(
  ideTipItm Int NOT NULL AUTO_INCREMENT,
  desTipItm Varchar(100),
 PRIMARY KEY (ideTipItm)
)
;

-- Table Factura

CREATE TABLE Factura
(
  nroFac Char(20) NOT NULL,
  idePed Int,
  estAnuFac Bool,
  tipPagFac Bool,
  fechaEmision date,
  total float(6,2)
)
;

ALTER TABLE Factura ADD PRIMARY KEY (nroFac)
;

-- Table Cargos

CREATE TABLE Cargos
(
  ideCar Int NOT NULL AUTO_INCREMENT,
  desCar Varchar(50),
  sdoCar Float(6,2),
 PRIMARY KEY (ideCar)
)
;

-- Table Articulo

CREATE TABLE Articulo
(
  ideArt Int NOT NULL AUTO_INCREMENT,
  desArt Varchar(100),
  cntArt Int,
 PRIMARY KEY (ideArt)
)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE Producto ADD CONSTRAINT R1 FOREIGN KEY (idePrv) REFERENCES Proveedor (idePrv) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Usuario ADD CONSTRAINT R3 FOREIGN KEY (ideEmp) REFERENCES Empleado (ideEmp) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE HistorialAcceso ADD CONSTRAINT R4 FOREIGN KEY (ideUsu) REFERENCES Usuario (ideUsu) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE HistorialAcceso ADD CONSTRAINT R5 FOREIGN KEY (ideTer) REFERENCES Terminal (ideTer) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE HistorialLog ADD CONSTRAINT R6 FOREIGN KEY (ideUsu) REFERENCES Usuario (ideUsu) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE HistorialLog ADD CONSTRAINT R7 FOREIGN KEY (ideTer) REFERENCES Terminal (ideTer) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Item ADD CONSTRAINT R12 FOREIGN KEY (ideTipItm) REFERENCES TipoItem (ideTipItm) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE DetalleDelPedido ADD CONSTRAINT R8 FOREIGN KEY (ideItm) REFERENCES Item (ideItm) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE DetalleDelPedido ADD CONSTRAINT R2 FOREIGN KEY (idePed) REFERENCES Pedido (idePed) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Factura ADD CONSTRAINT R9 FOREIGN KEY (idePed) REFERENCES Pedido (idePed) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Item ADD CONSTRAINT R10 FOREIGN KEY (idePro) REFERENCES Producto (idePro) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Pedido ADD CONSTRAINT R11 FOREIGN KEY (ideEmp) REFERENCES Empleado (ideEmp) ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE Empleado ADD CONSTRAINT R13 FOREIGN KEY (ideCar) REFERENCES Cargos (ideCar) ON DELETE NO ACTION ON UPDATE NO ACTION
;

