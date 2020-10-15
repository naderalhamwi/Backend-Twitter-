-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2020 at 11:30 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usersinfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `name` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phonenumber` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `password`, `email`, `phonenumber`) VALUES
('Bjön', '$2a$12$.h4KJkAkcIcEoVACEj1vVO9luA99X2xvf0V2ra2gHK2Rz1tGeTygS', 'bjön@gmail.com', '0734764230'),
('David', '$2a$12$kD5yBeUOhUkZXYsNBGqCN.1zcOkzwJ1Y/vQjwd2YlLGnWRondhcvO', 'David@gmail.com', '0734764230'),
('oliver', '$2a$12$hlel9/6vYWJlkvnMpeyFre2SqK2y4KhRt9FKL4Hkpsq8hcwP08FUm', 'oliver@gmail.com', '0734764230'),
('Tim', '$2a$12$W7Z1WDWwiT8ex/GHCsiEieF6YEcH9QpqF72xm8dvKNZvCTcEbm5mW', 'Tim@gmail.com', '0734764230');

-- --------------------------------------------------------

--
-- Table structure for table `usersposts`
--

CREATE TABLE `usersposts` (
  `Title` varchar(100) NOT NULL,
  `Date` date NOT NULL,
  `Likes` int(11) NOT NULL,
  `Content` text NOT NULL,
  `E-mail/Username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
