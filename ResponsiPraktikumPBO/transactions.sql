-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 02 Jun 2022 pada 03.25
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `trans_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `transactions`
--

CREATE TABLE `transactions` (
  `id_trans` char(10) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `nama_kasir` varchar(255) NOT NULL,
  `qty` int(11) NOT NULL,
  `price_per_qty` bigint(20) NOT NULL,
  `discount` tinyint(4) NOT NULL,
  `price_total` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transactions`
--

INSERT INTO `transactions` (`id_trans`, `nama_barang`, `nama_kasir`, `qty`, `price_per_qty`, `discount`, `price_total`) VALUES
('121', 'Beras Coklat', '1', 96, 7000, 3, 651840),
('122', 'Air Botol', '1', 30, 6500, 2, 191100),
('123', 'Masker', '1', 10, 5000, 2, 49000),
('134', 'Beras', '1', 75, 7000, 2, 514500);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id_trans`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
