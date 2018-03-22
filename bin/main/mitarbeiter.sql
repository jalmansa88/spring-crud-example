-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2018 at 12:03 PM
-- Server version: 5.6.37
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dblocal`
--

-- --------------------------------------------------------

--
-- Table structure for table `mitarbeiter`
--

CREATE TABLE IF NOT EXISTS `mitarbeiter` (
  `id` bigint(20) NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(2) NOT NULL,
  `projekte_id` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `mitarbeiter`
--

INSERT INTO `mitarbeiter` (`id`, `username`, `name`, `age`, `projekte_id`) VALUES
(1, 'almansaj', 'javier almansa', 29, 1),
(2, 'adveni', 'javier adveni', 26, 1),
(3, 'martos', 'nico martos', 29, 1),
(4, 'paco', 'francisco', 32, 1),
(12, 'pepe', 'jose', 31, 1),
(13, 'pepe3', 'jose', 31, 1),
(25, 'pepe4', 'jose', 31, 1),
(26, 'pepe5', 'jose', 31, 1),
(27, 'asdasd', 'jose', 31, 1),
(28, 'skywalker', 'luke', 31, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `projekt_id` (`projekte_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  ADD CONSTRAINT `projekte_fk` FOREIGN KEY (`projekte_id`) REFERENCES `projekte` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
