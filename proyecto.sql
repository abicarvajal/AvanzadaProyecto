-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 07-07-2019 a las 22:59:32
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
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `identificacion` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`identificacion`, `nombre`, `direccion`, `telefono`, `correo`, `ciudad`) VALUES
('0650026230', 'Emily Chavez', 'Quito', '2097317', 'e@espe.edu.cec', '0'),
('1720826138', 'Diego', 'ESPE', '0998573712', 'd@gmail.com', 'Quito');

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
(1, '2/7/2019', '0604188086', '0604188086', '3', '0.54', 'Item 3', '', ''),
(1, '2/7/2019', '0604188086', '0604188086', '3', '0.54', 'Item 3', '', ''),
(1, '2/7/2019', '0604188086', '0604188086', 'TOTAL', '1.08', 'Item 3', '', ''),
(2, '5/7/2019', '0604188086', '0604188086', '3', '0.54', 'Item 2', 'sdfg', 'ANULADO'),
(2, '5/7/2019', '0604188086', '0604188086', '2', '0.45', 'Item 2', 'sdfg', 'ANULADO'),
(2, '5/7/2019', '0604188086', '0604188086', '5', '0.3', 'Item 2', 'sdfg', 'ANULADO'),
(2, '5/7/2019', '0604188086', '0604188086', 'TOTAL', '1.29', 'Item 2', 'sdfg', 'ANULADO'),
(3, '6/7/2019', '', '', 'TOTAL', '', 'Quito', '', 'ACTIVO'),
(4, '6/7/2019', '0650026230', '0604188086', '1', '0.2', '0', 'Quito', 'ACTIVO');

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
('2', 'Peras', 0.45, 'Frágil'),
('3', 'Durazno', 0.54, 'Frági1l'),
('4', 'Sandia', 1.5, 'Frágil'),
('5', 'Tomate', 0.3, 'Frágil'),
('11', 'Banano', 1.1, 'Frágil');

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
  `placa` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `transportista`
--

INSERT INTO `transportista` (`identificacion`, `nombre`, `direccion`, `telefono`, `correo`, `placa`) VALUES
('0602175143', 'Mario', 'Quito', '2097317', 'mariochavezm@hotmial.com', 'PKO0140'),
('0604188086', 'nnn', 'uuu', '111', '1@hotmail.com', 'PKO0140'),
('0650026230', 'E', 'E', '0998573712', 'e@gmail.com', 'jod8962');

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
('admin', 'admin', 1),
('user', 'user', 2),
('user', 'user', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`codigo`, `nombre`) VALUES
('1', 'anaa');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
