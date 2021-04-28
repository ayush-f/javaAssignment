-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2021 at 11:18 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bcode` int(11) NOT NULL,
  `b_name` varchar(65) NOT NULL,
  `a_name` varchar(65) NOT NULL,
  `p_date` varchar(65) NOT NULL,
  `price` int(20) NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bcode`, `b_name`, `a_name`, `p_date`, `price`, `quantity`) VALUES
(1, 'picaso', 'prakash', '2006', 5600, 59),
(2, 'pablo', 'shine', '1900', 600, 9),
(5, 'picaso bamb', 'noone', '2021', 3599, 22);

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `name` varchar(65) NOT NULL,
  `user` varchar(65) NOT NULL,
  `email` varchar(65) NOT NULL,
  `psw` varchar(65) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`name`, `user`, `email`, `psw`) VALUES
('anil', 'anil12', 'anil@gmail.com', 'asdf'),
('prakash', 'prakash12', 'prakash@gmail.com', 'asdf'),
('', '', '', ''),
('justin', 'justin12', 'asdf', 'asdf'),
('a', 'a', 'a', 'a'),
('ujjwal khatri', 'khatri12', 'khatri@gmail.com', 'asdf'),
('a', 'aa', 'aaa', 'asdf'),
('bipin khadka', 'bipin12', 'bipin@@gmail.com', 'asdf'),
('kamlesh', 'kamlesh12', 'a@gmail.com', 'aaaa');

-- --------------------------------------------------------

--
-- Table structure for table `soldb`
--

CREATE TABLE `soldb` (
  `bcode` int(65) NOT NULL,
  `a_name` varchar(65) NOT NULL,
  `b_name` varchar(65) NOT NULL,
  `p_date` varchar(65) NOT NULL,
  `price` int(20) NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `soldb`
--

INSERT INTO `soldb` (`bcode`, `a_name`, `b_name`, `p_date`, `price`, `quantity`) VALUES
(1, 'shine', 'pablo', '1900', 600, 1),
(2, 'prakash', 'picaso', '2006', 5600, 1),
(3, 'noone', 'picaso bamb', '2021', 3599, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bcode`);

--
-- Indexes for table `soldb`
--
ALTER TABLE `soldb`
  ADD PRIMARY KEY (`bcode`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bcode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `soldb`
--
ALTER TABLE `soldb`
  MODIFY `bcode` int(65) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
