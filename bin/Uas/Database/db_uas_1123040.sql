-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jan 2025 pada 13.47
-- Versi server: 11.3.0-MariaDB
-- Versi PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uas_1123040`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `cost`
--

CREATE TABLE `cost` (
  `id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `fee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `cost`
--

INSERT INTO `cost` (`id`, `type`, `fee`) VALUES
(1, 'Building Materials', 10000),
(2, 'House Moving', 15000),
(3, 'Instant Delivery', 20000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`id`, `password`, `name`, `address`, `phone`) VALUES
(1, '1', 'calvin', 'jalan pasir luhur', '1'),
(2, '2', 'adyo', 'hehe', '2'),
(5, '', 'assa', '', ''),
(6, '', 'sdsda', '', ''),
(7, '', 'daas', '', ''),
(8, '1', 'dasda', 'adsdas', 'a1'),
(9, '1', '1', '1', '1'),
(10, '1234', 'calvin', 'rancamanyar', '4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `delivery_details`
--

CREATE TABLE `delivery_details` (
  `id` int(11) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `status` enum('PENDING','IN_PROGRESS','ON_DELIVERY','ARRIVED') NOT NULL,
  `current_position` varchar(30) DEFAULT NULL,
  `evidence` varchar(30) DEFAULT NULL,
  `date` date NOT NULL,
  `updated_by` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `delivery_details`
--

INSERT INTO `delivery_details` (`id`, `transaction_id`, `status`, `current_position`, `evidence`, `date`, `updated_by`) VALUES
(1, 1, 'PENDING', 'hehe', 'HEHE', '2025-01-10', 'HEHE'),
(2, 3, 'ON_DELIVERY', 'hehe', 'hehe', '2025-01-10', 'dani');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `delivery_type` varchar(30) DEFAULT NULL,
  `expected_weight` int(11) DEFAULT NULL,
  `total_cost` int(11) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `receipt_name` varchar(30) DEFAULT NULL,
  `receipt_address` varchar(30) DEFAULT NULL,
  `receipt_phone` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id`, `customer_id`, `delivery_type`, `expected_weight`, `total_cost`, `created_at`, `receipt_name`, `receipt_address`, `receipt_phone`) VALUES
(1, 1, 'Building Materials', 1, 10000, '2025-01-10', 'jeje', 'hehe', '1'),
(2, 1, 'House Moving', 2, 30000, '2025-01-10', 'jeje', 'hehe', '1'),
(3, 1, 'House Moving', 1, 15000, '2025-01-10', '1', '1', '1'),
(4, 10, 'Instant Delivery', 1, 20000, '2025-01-10', 'dani', 'du', '90');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `cost`
--
ALTER TABLE `cost`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `delivery_details`
--
ALTER TABLE `delivery_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_id` (`transaction_id`);

--
-- Indeks untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `cost`
--
ALTER TABLE `cost`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT untuk tabel `delivery_details`
--
ALTER TABLE `delivery_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `delivery_details`
--
ALTER TABLE `delivery_details`
  ADD CONSTRAINT `delivery_details_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`);

--
-- Ketidakleluasaan untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
