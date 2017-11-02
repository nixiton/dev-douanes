
-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 26, 2017 at 08:54 AM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Test`
--

-- --------------------------------------------------------

--
-- Table structure for table `Agent`

--
INSERT INTO `Useri` (`idUser`, `designation`, `role`) VALUES(1, 'Un utilisateur qui peut tout faire', 'toor');
INSERT INTO `Agent` (`im`, `nomAgent`, `PASSWORD`, `prenomAgent`, `idposteny`, `idrole`) VALUES (1, 'ADMINISTRATEUR', '$2a$10$I2sElP6dzguyXFLs0a1nSOOB6oFkSk3aiUoHzB.3d9svCbpVgDbUS', 'toor', NULL, 1);