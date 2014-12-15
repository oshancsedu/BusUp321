-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2014 at 02:06 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bus_route`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`UserName`, `Password`) VALUES
('oshan', '123');

-- --------------------------------------------------------

--
-- Table structure for table `atcl`
--

CREATE TABLE IF NOT EXISTS `atcl` (
  `lat` float(10,6) DEFAULT NULL,
  `Lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atcl`
--

INSERT INTO `atcl` (`lat`, `Lng`) VALUES
(23.726727, 90.421303),
(23.730263, 90.415100),
(23.725832, 90.415115),
(23.724899, 90.413879),
(23.724899, 90.411987),
(23.727531, 90.412025),
(23.727678, 90.410538),
(23.730085, 90.410110),
(23.729879, 90.405151),
(23.732618, 90.404350),
(23.733669, 90.403610),
(23.733946, 90.402245),
(23.734711, 90.400780),
(23.737558, 90.399086),
(23.738110, 90.395943),
(23.739061, 90.388794),
(23.738815, 90.383461),
(23.744610, 90.382057),
(23.754244, 90.376595),
(23.763542, 90.371056),
(23.769464, 90.368637);

-- --------------------------------------------------------

--
-- Table structure for table `atcl_stand`
--

CREATE TABLE IF NOT EXISTS `atcl_stand` (
  `Standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `atcl_stand`
--

INSERT INTO `atcl_stand` (`Standname`) VALUES
('Motijheel'),
('Gulistan'),
('Paltan'),
('Press Club'),
('Matsha Bhaban'),
('Shahbag'),
('Kataban'),
('Science Lab'),
('City College'),
('Kalabagan'),
('Shukrabad'),
('Ashad Gate'),
('College Gate');

-- --------------------------------------------------------

--
-- Table structure for table `bihango`
--

CREATE TABLE IF NOT EXISTS `bihango` (
  `Lat` float(10,6) DEFAULT NULL,
  `Lng` float(10,6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bihango`
--

INSERT INTO `bihango` (`Lat`, `Lng`) VALUES
(23.726727, 90.421303),
(23.730263, 90.415100);

-- --------------------------------------------------------

--
-- Table structure for table `bihango_stand`
--

CREATE TABLE IF NOT EXISTS `bihango_stand` (
  `standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bihango_stand`
--

INSERT INTO `bihango_stand` (`standname`) VALUES
('Shahbag'),
('Framgate');

-- --------------------------------------------------------

--
-- Table structure for table `bikolpo`
--

CREATE TABLE IF NOT EXISTS `bikolpo` (
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bikolpo`
--

INSERT INTO `bikolpo` (`lat`, `lng`) VALUES
(23.722813, 90.387596),
(23.728226, 90.385925),
(23.730375, 90.385742),
(23.744680, 90.382004),
(23.754068, 90.376686);

-- --------------------------------------------------------

--
-- Table structure for table `bikolpo_stand`
--

CREATE TABLE IF NOT EXISTS `bikolpo_stand` (
  `standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bikolpo_stand`
--

INSERT INTO `bikolpo_stand` (`standname`) VALUES
('Dhakeshwari'),
('Azimpur'),
('New Market'),
('City College'),
('Kalabagan'),
('Shukrabad');

-- --------------------------------------------------------

--
-- Table structure for table `busname`
--

CREATE TABLE IF NOT EXISTS `busname` (
  `Bus` varchar(20) NOT NULL,
  `Color` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `busname`
--

INSERT INTO `busname` (`Bus`, `Color`) VALUES
('ATCL', 'white'),
('Bikolpo', 'white'),
('Shakalpo', 'green'),
('Winner', 'indigo'),
('Bihango', 'lightgreen'),
('Dlink', 'lightgreen'),
('Grameen Seba', 'white');

-- --------------------------------------------------------

--
-- Table structure for table `busstand`
--

CREATE TABLE IF NOT EXISTS `busstand` (
  `Stand` varchar(30) NOT NULL,
  `latUp` float(10,8) NOT NULL,
  `longUp` float(10,8) NOT NULL,
  `latdown` float(10,8) DEFAULT NULL,
  `longdown` float(10,8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `busstand`
--

INSERT INTO `busstand` (`Stand`, `latUp`, `longUp`, `latdown`, `longdown`) VALUES
('Shukrabad', 23.75247574, 90.37770844, 76.77999878, 12.56000042),
('Science Lab', 23.73901749, 90.38463593, 100.65000153, 13.86999989),
('Kalabagan', 23.74758148, 90.38050842, 23.74758148, 90.38050842),
('College Gate', 23.76795387, 90.36914062, 23.76795387, 90.36914062),
('Ashad Gate', 23.75978661, 90.37339020, 23.75978661, 90.37339020),
('Science Lab', 23.73901749, 90.38463593, 23.73903084, 90.38465118),
('Kataban', 23.73883820, 90.39152527, 23.73883820, 90.39152527),
('Shahbag', 23.73809624, 90.39701080, 23.73809433, 90.39584351),
('Press Club', 23.72986412, 90.40734863, 23.72986412, 90.40734863),
('Kamalapur', 23.73250008, 90.42514038, 23.73229599, 90.42514038),
('Panthapath', 23.74990082, 90.39221954, 23.74990082, 90.39221954),
('New Market', 23.73216248, 90.38510132, 23.73216248, 90.38510132),
('Azimpur', 23.72704887, 90.38611603, 23.72704887, 90.38611603),
('Mirpur-10', 23.80681229, 90.36843872, 23.80681229, 90.36843872),
('City College', 23.73930359, 90.38302612, 23.73930359, 90.38302612),
('Gulistan', 23.72512436, 90.41189575, 23.72512436, 90.41189575),
('Paltan', 23.72963524, 90.41009521, 23.72997856, 90.41026306),
('Framgate', 23.75743484, 90.39020538, 23.75743484, 90.39020538),
('Matsha Bhaban', 23.73358536, 90.40370941, 23.73358536, 90.40370941),
('Dhakeshwari', 23.72270775, 90.38760376, 23.72270775, 90.38760376),
('Motijheel', 23.72663689, 90.42111969, 23.72663689, 90.42111969),
('Gulistan Flyover', 23.72315979, 90.40576172, 23.72315979, 90.40576172),
('Chankhar Pul', 23.72386360, 90.40027618, 23.72400093, 90.40048981),
('Bakshi Bazar', 23.72248077, 90.39541626, 23.72249603, 90.39555359),
('Board Office', 23.72223282, 90.39147949, 23.72223282, 90.39147949),
('Dhanmondi 27', 23.75655937, 90.37548828, 23.75655937, 90.37548828),
('Shyamoli', 23.77486229, 90.36527252, 23.77486229, 90.36527252),
('Kallyanpur', 23.77845573, 90.35986328, 23.77819061, 90.36093903),
('Technical', 23.78158760, 90.35224152, 23.78112602, 90.35234070),
('Mazar Road', 23.78310966, 90.34707642, 23.78276443, 90.34748077),
('Gabtoli', 23.78317642, 90.34314728, 23.78336334, 90.34326172);

-- --------------------------------------------------------

--
-- Table structure for table `dlink`
--

CREATE TABLE IF NOT EXISTS `dlink` (
  `Lat` float(10,6) DEFAULT NULL,
  `Lng` float(10,6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dlink`
--

INSERT INTO `dlink` (`Lat`, `Lng`) VALUES
(23.723209, 90.405815),
(23.723356, 90.403435),
(23.724674, 90.395523),
(23.723005, 90.395844),
(23.722403, 90.395676),
(23.722786, 90.394691),
(23.723228, 90.392960),
(23.722874, 90.392845),
(23.722506, 90.392960),
(23.722496, 90.391823),
(23.722200, 90.391769),
(23.722246, 90.390602),
(23.722137, 90.390228),
(23.722383, 90.389709),
(23.722191, 90.388824),
(23.722761, 90.388672),
(23.722767, 90.387611),
(23.728201, 90.385963),
(23.729891, 90.385834),
(23.744671, 90.382011),
(23.763721, 90.370941),
(23.773342, 90.367126),
(23.775740, 90.364632),
(23.778606, 90.359871),
(23.779156, 90.356438),
(23.782219, 90.350433),
(23.783358, 90.344124),
(23.783121, 90.338928),
(23.786421, 90.329269),
(23.790056, 90.323608),
(23.789822, 90.316231);

-- --------------------------------------------------------

--
-- Table structure for table `dlink_stand`
--

CREATE TABLE IF NOT EXISTS `dlink_stand` (
  `StandName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dlink_stand`
--

INSERT INTO `dlink_stand` (`StandName`) VALUES
('Gulistan Flyover'),
('Chankhar Pul'),
('Bakshi Bazar'),
('Board Office'),
('Dhakeshwari'),
('Azimpur'),
('New Market'),
('City College'),
('Kalabagan'),
('Shukrabad'),
('Ashad Gate'),
('College Gate'),
('Dhanmondi 27'),
('Shyamoli'),
('Kallyanpur'),
('Technical'),
('Mazar Road'),
('Gabtoli');

-- --------------------------------------------------------

--
-- Table structure for table `grameen seba`
--

CREATE TABLE IF NOT EXISTS `grameen seba` (
  `Lat` float(10,6) NOT NULL,
  `Lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grameen seba`
--

INSERT INTO `grameen seba` (`Lat`, `Lng`) VALUES
(23.723209, 90.405815),
(23.723356, 90.403435),
(23.724674, 90.395523),
(23.723005, 90.395844),
(23.722403, 90.395676),
(23.722786, 90.394691),
(23.723228, 90.392960),
(23.722874, 90.392845),
(23.722506, 90.392960),
(23.722496, 90.391823),
(23.722200, 90.391769),
(23.722246, 90.390602),
(23.722137, 90.390228),
(23.722383, 90.389709),
(23.722191, 90.388824),
(23.722761, 90.388672),
(23.722767, 90.387611),
(23.728201, 90.385963),
(23.729891, 90.385834),
(23.744671, 90.382011),
(23.763721, 90.370941),
(23.773342, 90.367126),
(23.775740, 90.364632),
(23.778606, 90.359871),
(23.779156, 90.356438),
(23.782219, 90.350433),
(23.783358, 90.344124),
(23.783121, 90.338928),
(23.786421, 90.329269),
(23.790056, 90.323608),
(23.789822, 90.316231);

-- --------------------------------------------------------

--
-- Table structure for table `grameen seba_stand`
--

CREATE TABLE IF NOT EXISTS `grameen seba_stand` (
  `Standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grameen seba_stand`
--

INSERT INTO `grameen seba_stand` (`Standname`) VALUES
('Gulistan Flyover'),
('Chankhar Pul'),
('Bakshi Bazar'),
('Board Office'),
('Dhakeshwari'),
('Azimpur'),
('New Market'),
('City College'),
('Kalabagan'),
('Shukrabad'),
('Ashad Gate'),
('College Gate'),
('Dhanmondi 27'),
('Shyamoli'),
('Kallyanpur'),
('Technical'),
('Mazar Road'),
('Gabtoli');

-- --------------------------------------------------------

--
-- Table structure for table `shakalpo`
--

CREATE TABLE IF NOT EXISTS `shakalpo` (
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shakalpo`
--

INSERT INTO `shakalpo` (`lat`, `lng`) VALUES
(0.000000, 0.000000),
(0.000000, 0.000000);

-- --------------------------------------------------------

--
-- Table structure for table `shakalpo_stand`
--

CREATE TABLE IF NOT EXISTS `shakalpo_stand` (
  `standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shakalpo_stand`
--

INSERT INTO `shakalpo_stand` (`standname`) VALUES
('Mirpur-10'),
('Kamalapur');

-- --------------------------------------------------------

--
-- Table structure for table `winner`
--

CREATE TABLE IF NOT EXISTS `winner` (
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `winner`
--

INSERT INTO `winner` (`lat`, `lng`) VALUES
(23.722813, 90.387596),
(23.728226, 90.385925),
(23.730375, 90.385742),
(23.744680, 90.382004),
(23.751301, 90.378204),
(23.752674, 90.381767),
(23.752674, 90.384476),
(23.751436, 90.386101),
(23.749786, 90.393143);

-- --------------------------------------------------------

--
-- Table structure for table `winner_stand`
--

CREATE TABLE IF NOT EXISTS `winner_stand` (
  `standname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `winner_stand`
--

INSERT INTO `winner_stand` (`standname`) VALUES
('Azimpur'),
('New Market'),
('City College'),
('Kalabagan'),
('Panthapath');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
