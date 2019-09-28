-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-07-2019 a las 18:28:18
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id`, `nombre`) VALUES
(1, 'Quito'),
(2, 'Machala'),
(3, 'Guayaquil'),
(4, 'Loja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `identificacion` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `zona` varchar(200) NOT NULL,
  `calleP` varchar(200) NOT NULL,
  `calleS` varchar(200) NOT NULL,
  `lote` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`identificacion`, `nombre`, `telefono`, `correo`, `ciudad`, `zona`, `calleP`, `calleS`, `lote`) VALUES
('0604188086', 'Sabrina', '0998573712', 's@gmai.com', 'Guayaquil', 'guayas', '1', '2', '3'),
('1718911488', 'Jonatan Suntaxi', '0995773741', 'jjsuntaxi@espe.edu.ec', 'Quito', 'valle', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `iddepartamento` int(11) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`iddepartamento`, `departamento`) VALUES
(1, 'Quito'),
(2, 'Machala'),
(3, 'Guayaquil'),
(4, 'Loja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `guia`
--

CREATE TABLE `guia` (
  `numero` int(11) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `cedulaCliente` varchar(20) NOT NULL,
  `cedulaTransportista` varchar(20) NOT NULL,
  `codigoProducto` varchar(20) NOT NULL,
  `valorEnvio` varchar(20) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `estadoReserva` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `guia`
--

INSERT INTO `guia` (`numero`, `fecha`, `cedulaCliente`, `cedulaTransportista`, `codigoProducto`, `valorEnvio`, `destino`, `direccion`, `estadoReserva`) VALUES
(1, '10/7/2019', '0604188086', '0602175143', 'PR761', '1.0', 'Quito', 'Item 1', 'ANULADO'),
(1, '10/7/2019', '0604188086', '0602175143', 'TOTAL', '1.0', 'Quito', 'Item 1', 'ANULADO'),
(2, '12/7/2019', '0604188086', '0650026230', 'PR761', '1.0', 'Quito', 'Item 1', 'ANULADO'),
(2, '12/7/2019', '0604188086', '0650026230', 'PR761', '1.0', 'Quito', 'Item 1', 'ANULADO'),
(2, '12/7/2019', '0604188086', '0650026230', 'PR761', '1.0', 'Quito', 'Item 1', 'ANULADO'),
(2, '12/7/2019', '0604188086', '0650026230', 'TOTAL', '3.0', 'Quito', 'Item 1', 'ANULADO'),
(3, '14/7/2019', '1718911488', '1714786629', 'PR761', '1.0', 'Quito', 'valle', 'ACTIVO'),
(3, '14/7/2019', '1718911488', '1714786629', 'TOTAL', '1.0', 'Quito', 'valle', 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigo` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `valorEnvio` float NOT NULL,
  `claseProducto` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `descripcion`, `valorEnvio`, `claseProducto`) VALUES
('PR761', 'Sandia', 1, 'Frágil'),
('PR050', 'Dulces', 0.5, 'Frágil'),
('PR566', 'Manzana', 0.45, 'Frágil'),
('PR237', 'Papas', 1.1, 'Frágil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincia`
--

CREATE TABLE `provincia` (
  `idprovincia` int(11) NOT NULL,
  `provincia` varchar(45) DEFAULT NULL,
  `idDepartamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincia`
--

INSERT INTO `provincia` (`idprovincia`, `provincia`, `idDepartamento`) VALUES
(0, 'valle', 1),
(1, 'norte', 1),
(0, 'centro', 0),
(0, 'alborada', 0),
(4, 'sur', 1),
(5, 'alboradaUno', 3),
(0, 'valle de tumbaco', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transportista`
--

CREATE TABLE `transportista` (
  `identificacion` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `placa` varchar(20) NOT NULL,
  `zona` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `transportista`
--

INSERT INTO `transportista` (`identificacion`, `nombre`, `direccion`, `telefono`, `correo`, `placa`, `zona`) VALUES
('0602175143', 'Nicole Chavez', 'Quito', '0998384984', 'mariochavezm@hotmail.com', 'qwe1234', 'valle'),
('0650026230', 'Diego', 'Quito', '0998573721', 'd@hotmail.com', 'PQW1234', 'Valle de los Chillos'),
('1714786629', 'Nicolee', 'Quito', '0998573713', 'b@hotmail.com', 'Valle de los Chillos', 'Quito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuarios` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuarios`, `password`, `tipo`) VALUES
('admin', 'admin', 1),
('user', 'user', 2),
('admin', 'admin', 1),
('user', 'user', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`codigo`, `nombre`, `ciudad`) VALUES
('Z282', 'valle', 'Quito'),
('Z317', 'norte', 'Quito'),
('Z452', 'sur', 'Quito'),
('Z782', 'alboradaUno', 'Guayaquil');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
