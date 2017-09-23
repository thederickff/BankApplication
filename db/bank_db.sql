-- phpMyAdmin SQL Dump
-- version 4.6.6deb3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Sep 23, 2017 at 05:47 PM
-- Server version: 5.7.17-1
-- PHP Version: 7.0.16-3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `account_no` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `age` int(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `DOB` varchar(100) NOT NULL,
  `occupation` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `picure` blob NOT NULL,
  `previous_balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `account_no` int(11) NOT NULL,
  `previous_balance` double NOT NULL,
  `amount_deposited` double NOT NULL,
  `authorized_id` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `depositor_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `age` int(100) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `DOB` varchar(100) NOT NULL,
  `rank` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `date` varchar(100) NOT NULL,
  `picture` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `withdrawal`
--

CREATE TABLE `withdrawal` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `account_no` int(100) NOT NULL,
  `previous_balance` double NOT NULL,
  `amount_withdrawn` double NOT NULL,
  `authorized_id` int(11) NOT NULL,
  `date` varchar(100) NOT NULL,
  `new_balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`account_no`);

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `withdrawal`
--
ALTER TABLE `withdrawal`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `account_no` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `staffs`
--
ALTER TABLE `staffs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `withdrawal`
--
ALTER TABLE `withdrawal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
