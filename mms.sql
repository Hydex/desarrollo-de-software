-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-12-2013 a las 00:11:51
-- Versión del servidor: 5.6.12
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `mms`
--
CREATE DATABASE IF NOT EXISTS `mms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `mms`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cargos`
--

CREATE TABLE IF NOT EXISTS `Cargos` (
  `ideCar` int(11) NOT NULL AUTO_INCREMENT,
  `desCar` varchar(50) DEFAULT NULL,
  `sdoCar` float(6,2) DEFAULT NULL,
  PRIMARY KEY (`ideCar`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `Cargos`
--

INSERT INTO `Cargos` (`ideCar`, `desCar`, `sdoCar`) VALUES
(1, 'Administrador', 1200.00),
(2, 'Gerente', 700.00),
(3, 'Cajero', 700.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DetalleDelPedido`
--

CREATE TABLE IF NOT EXISTS `DetalleDelPedido` (
  `ideItm` int(11) NOT NULL,
  `idePed` int(11) NOT NULL,
  `cntDetPed` int(11) DEFAULT NULL,
  PRIMARY KEY (`ideItm`,`idePed`),
  KEY `R2` (`idePed`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Empleado`
--

CREATE TABLE IF NOT EXISTS `Empleado` (
  `ideEmp` int(11) NOT NULL AUTO_INCREMENT,
  `dniEmp` varchar(8) NOT NULL,
  `nomEmp` varchar(60) DEFAULT NULL,
  `apeMatEmp` varchar(30) DEFAULT NULL,
  `apePatEmp` varchar(30) DEFAULT NULL,
  `sexEmp` char(1) DEFAULT NULL,
  `estCivEmp` char(1) DEFAULT NULL,
  `dirEmp` varchar(100) DEFAULT NULL,
  `disEmp` varchar(50) DEFAULT NULL,
  `emaEmp` varchar(30) DEFAULT NULL,
  `telEmp` varchar(15) DEFAULT NULL,
  `ideCar` int(11) DEFAULT NULL,
  PRIMARY KEY (`ideEmp`),
  KEY `R13` (`ideCar`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `Empleado`
--

INSERT INTO `Empleado` (`ideEmp`, `dniEmp`, `nomEmp`, `apeMatEmp`, `apePatEmp`, `sexEmp`, `estCivEmp`, `dirEmp`, `disEmp`, `emaEmp`, `telEmp`, `ideCar`) VALUES
(1, '46668113', 'Alison', 'Torres', 'Aguilar', 'F', 'S', 'Elias Aguirre', 'Miraflores', 'alisont@gmail.com', '054985252349', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Factura`
--

CREATE TABLE IF NOT EXISTS `Factura` (
  `nroFac` char(20) NOT NULL,
  `estFac` tinyint(1) DEFAULT NULL,
  `idePed` int(11) DEFAULT NULL,
  PRIMARY KEY (`nroFac`),
  KEY `R9` (`idePed`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HistorialAcceso`
--

CREATE TABLE IF NOT EXISTS `HistorialAcceso` (
  `ideHisAcc` int(11) NOT NULL AUTO_INCREMENT,
  `ideUsu` varchar(50) DEFAULT NULL,
  `ideTer` int(11) DEFAULT NULL,
  `horHisAcc` timestamp NULL DEFAULT NULL,
  `acnHisAcc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ideHisAcc`),
  KEY `R4` (`ideUsu`),
  KEY `R5` (`ideTer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `HistorialAcceso`
--

INSERT INTO `HistorialAcceso` (`ideHisAcc`, `ideUsu`, `ideTer`, `horHisAcc`, `acnHisAcc`) VALUES
(1, 'admin', 1, '2013-12-07 21:03:46', 'Cambio de contraseña: Se reestablecio contraseña exitosamente,'),
(2, 'admin', 1, '2013-12-07 21:15:17', 'Cambio de contraseña: Se reestablecio contraseña exitosamente,'),
(3, 'admin', 1, '2013-12-07 21:51:01', 'Cambio de contraseña: Se reestablecio contraseña exitosamente,'),
(4, 'admin', 1, '2013-12-07 21:51:47', 'Se inicio sesion exitosamente ,arraca sistema.'),
(5, 'admin', 1, '2013-12-07 21:56:39', 'Se inicio sesion exitosamente ,arraca sistema.'),
(6, 'admin', 1, '2013-12-07 21:57:28', 'Se inicio sesion exitosamente ,arraca sistema.'),
(7, 'admin', 1, '2013-12-07 22:00:14', 'Se inicio sesion exitosamente ,arraca sistema.'),
(8, 'admin', 1, '2013-12-07 22:04:21', 'Se inicio sesion exitosamente ,arraca sistema.'),
(9, 'admin', 1, '2013-12-07 22:44:23', 'Se inicio sesion exitosamente ,arraca sistema.'),
(10, 'admin', 1, '2013-12-07 22:47:29', 'Los datos de usuario o contraseña fueron incorrectos.'),
(11, 'admin', 1, '2013-12-07 22:47:33', 'Se inicio sesion exitosamente ,arraca sistema.'),
(12, 'admin', 1, '2013-12-07 22:53:17', 'Se inicio sesion exitosamente ,arraca sistema.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `HistorialLog`
--

CREATE TABLE IF NOT EXISTS `HistorialLog` (
  `ideHisLog` int(11) NOT NULL AUTO_INCREMENT,
  `ideUsu` varchar(50) DEFAULT NULL,
  `ideTer` int(11) DEFAULT NULL,
  `horIniHisLog` time DEFAULT NULL,
  `horFinHisLog` time DEFAULT NULL,
  PRIMARY KEY (`ideHisLog`),
  KEY `R6` (`ideUsu`),
  KEY `R7` (`ideTer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `HistorialLog`
--

INSERT INTO `HistorialLog` (`ideHisLog`, `ideUsu`, `ideTer`, `horIniHisLog`, `horFinHisLog`) VALUES
(1, 'admin', 1, '17:04:21', '17:04:31'),
(2, 'admin', 1, '17:44:23', '17:44:36'),
(3, 'admin', 1, '17:47:34', '17:48:53'),
(4, 'admin', 1, '17:53:17', '17:53:23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Item`
--

CREATE TABLE IF NOT EXISTS `Item` (
  `ideItm` int(11) NOT NULL AUTO_INCREMENT,
  `ideTipItm` int(11) DEFAULT NULL,
  `desItm` varchar(100) DEFAULT NULL,
  `preItm` float(6,2) DEFAULT NULL,
  `idePro` int(11) DEFAULT NULL,
  PRIMARY KEY (`ideItm`),
  KEY `R12` (`ideTipItm`),
  KEY `R10` (`idePro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pedido`
--

CREATE TABLE IF NOT EXISTS `Pedido` (
  `idePed` int(11) NOT NULL AUTO_INCREMENT,
  `nomPed` varchar(60) DEFAULT NULL,
  `nroMesPed` int(11) DEFAULT NULL,
  `ideEmp` int(11) DEFAULT NULL,
  PRIMARY KEY (`idePed`),
  KEY `R11` (`ideEmp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE IF NOT EXISTS `Producto` (
  `idePro` int(11) NOT NULL AUTO_INCREMENT,
  `desPro` varchar(100) DEFAULT NULL,
  `cosPro` double DEFAULT NULL,
  `stkPro` int(11) DEFAULT NULL,
  `idePrv` int(11) DEFAULT NULL,
  PRIMARY KEY (`idePro`),
  KEY `R1` (`idePrv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Proveedor`
--

CREATE TABLE IF NOT EXISTS `Proveedor` (
  `idePrv` int(11) NOT NULL AUTO_INCREMENT,
  `empPrv` varchar(100) DEFAULT NULL,
  `nomPrv` varchar(60) DEFAULT NULL,
  `apePrv` varchar(60) DEFAULT NULL,
  `dirPrv` varchar(100) DEFAULT NULL,
  `disPrv` varchar(60) DEFAULT NULL,
  `ciuPrv` varchar(60) DEFAULT NULL,
  `proPrv` varchar(60) DEFAULT NULL,
  `emaPrv` varchar(30) DEFAULT NULL,
  `telPrv` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idePrv`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Terminal`
--

CREATE TABLE IF NOT EXISTS `Terminal` (
  `ideTer` int(11) NOT NULL AUTO_INCREMENT,
  `desTer` varchar(50) DEFAULT NULL,
  `estBlqTer` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ideTer`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `Terminal`
--

INSERT INTO `Terminal` (`ideTer`, `desTer`, `estBlqTer`) VALUES
(1, 'alison-PC', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TipoItem`
--

CREATE TABLE IF NOT EXISTS `TipoItem` (
  `ideTipItm` int(11) NOT NULL AUTO_INCREMENT,
  `desTipItm` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ideTipItm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuario`
--

CREATE TABLE IF NOT EXISTS `Usuario` (
  `ideUsu` varchar(50) NOT NULL,
  `pssUsu` varchar(50) DEFAULT '123456',
  `ideEmp` int(11) DEFAULT NULL,
  `estBlqUsu` tinyint(1) DEFAULT NULL,
  `blqAutUsu` tinyint(1) DEFAULT NULL,
  `nivAccUsu` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ideUsu`),
  KEY `R3` (`ideEmp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Usuario`
--

INSERT INTO `Usuario` (`ideUsu`, `pssUsu`, `ideEmp`, `estBlqUsu`, `blqAutUsu`, `nivAccUsu`) VALUES
('admin', '1234567', 1, 1, 0, '01');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `DetalleDelPedido`
--
ALTER TABLE `DetalleDelPedido`
  ADD CONSTRAINT `R2` FOREIGN KEY (`idePed`) REFERENCES `Pedido` (`idePed`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `R8` FOREIGN KEY (`ideItm`) REFERENCES `Item` (`ideItm`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Empleado`
--
ALTER TABLE `Empleado`
  ADD CONSTRAINT `R13` FOREIGN KEY (`ideCar`) REFERENCES `Cargos` (`ideCar`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Factura`
--
ALTER TABLE `Factura`
  ADD CONSTRAINT `R9` FOREIGN KEY (`idePed`) REFERENCES `Pedido` (`idePed`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `HistorialAcceso`
--
ALTER TABLE `HistorialAcceso`
  ADD CONSTRAINT `R4` FOREIGN KEY (`ideUsu`) REFERENCES `Usuario` (`ideUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `R5` FOREIGN KEY (`ideTer`) REFERENCES `Terminal` (`ideTer`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `HistorialLog`
--
ALTER TABLE `HistorialLog`
  ADD CONSTRAINT `R6` FOREIGN KEY (`ideUsu`) REFERENCES `Usuario` (`ideUsu`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `R7` FOREIGN KEY (`ideTer`) REFERENCES `Terminal` (`ideTer`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Item`
--
ALTER TABLE `Item`
  ADD CONSTRAINT `R10` FOREIGN KEY (`idePro`) REFERENCES `Producto` (`idePro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `R12` FOREIGN KEY (`ideTipItm`) REFERENCES `TipoItem` (`ideTipItm`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD CONSTRAINT `R11` FOREIGN KEY (`ideEmp`) REFERENCES `Empleado` (`ideEmp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD CONSTRAINT `R1` FOREIGN KEY (`idePrv`) REFERENCES `Proveedor` (`idePrv`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `R3` FOREIGN KEY (`ideEmp`) REFERENCES `Empleado` (`ideEmp`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
