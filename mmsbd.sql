INSERT INTO `Cargos` (`ideCar`, `desCar`, `sdoCar`) VALUES
(1, 'Administrador', 1200.00),
(2, 'Ventas', 700.00),
(3, 'Reportes', 700.00),
(4, 'Cajero', 700.00);

INSERT INTO Empleado( dniEmp, nomEmp, apeMatEmp, apePatEmp, sexEmp, estCivEmp, dirEmp, disEmp, emaEmp, telEmp,ideCar)
VALUES ('46663120', 'Pepe', 'Rosasles', 'Agapito', 'M', 'S', 'av. siemrpe viva', 'socabaya', 'pepitor@hotmail.com', '999009',1);

INSERT INTO `Usuario` (`ideUsu`, `pssUsu`, `ideEmp`, `estBlqUsu`, `blqAutUsu`, `nivAccUsu`) 
VALUES ('admin', '123456', 1, 1, 0, '01234');

insert into TipoItem (desTipItm) values('bebida');
insert into TipoItem (desTipItm) values('postre');
insert into TipoItem (desTipItm) values('Sandwich');
insert into TipoItem (desTipItm) values('Matahambre Simple');
insert into TipoItem (desTipItm) values('Matahambre Especial');
insert into TipoItem (desTipItm) values('Matahambre Super Especial');

insert into Item(ideTipItm,desItm,preItm) values(2,'Delicia de fresa',2.00);
insert into Item(ideTipItm,desItm,preItm) values(3,'Sandwich de pollo',8.50);
insert into Item(ideTipItm,desItm,preItm) values(3,'Sandwich de hamburgesa',9.00);
insert into Item(ideTipItm,desItm,preItm) values(3,'Sandwich de chorizo',11.00);
insert into Item(ideTipItm,desItm,preItm) values(3,'Sandwich de mortadela',5.00);
insert into Item(ideTipItm,desItm,preItm) values(3,'Sandwich de especial',10.00);
insert into Item(ideTipItm,desItm,preItm) values(1,'coca cola 200 ml',1.00);
insert into Item(ideTipItm,desItm,preItm) values(1,'coca cola 500ml',2.00);
insert into Item(ideTipItm,desItm,preItm) values(1,'inca cola 500ml',2.00);

INSERT INTO `Item` (`ideTipItm`, `desItm`, `preItm`, `idePro`) VALUES
(4, 'Americano', 8.90, NULL),
(4, 'Hamburgesa', 7.90, NULL),
(4, 'Pollo', 9.00, NULL),
(4, 'Chorizo', 9.90, NULL),
(4, 'Pollo', 9.90, NULL),
(4, 'Chorizo', 9.90, NULL),
(5, 'Hamburgesa Royal', 12.50, NULL),
(5, 'MataHambre de la Casa', 13.00, NULL),
(5, 'MataHambre Tropical', 13.50, NULL),
(5, 'MataHambre Arabe', 14.90, NULL),
(5, 'MataHambre Vegi', 14.00, NULL),
(5, 'Matahambre de Filete de Pollo y queso', 14.90, NULL),
(5, 'Super MataHambre', 15.00, NULL),
(6, 'MataHambre 4 estaciones', 17.00, NULL),
(6, 'MataHambre Gourmet', 17.90, NULL),
(6, 'MataHambre de Bistec', 19.00, NULL),
(6, 'MataHambre de Chicharon', 20.00, NULL);

insert into Terminal(desTer,estBlqTer) values('geank-PC',0);
describe Terminal
