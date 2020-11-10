-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2020 at 01:49 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `big_brain_trivia`
--

-- --------------------------------------------------------

--
-- Table structure for table `answers`
--

CREATE TABLE `answers` (
  `answer_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `answer_text` varchar(512) NOT NULL,
  `answer_is_correct` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `answers`
--

INSERT INTO `answers` (`answer_id`, `question_id`, `answer_text`, `answer_is_correct`) VALUES
(1, 1, 'Lira', 1),
(2, 2, 'Pacífico', 1),
(3, 3, 'São Paulo', 1),
(4, 4, 'Campo Grande', 1),
(5, 5, 'Kaka', 1),
(6, 6, 'Volei', 1),
(7, 7, 'Leonardo Da Vinci', 1),
(8, 8, 'França', 1),
(9, 9, 'Nova York', 1),
(10, 10, '12', 1),
(11, 1, 'Euro', 0),
(12, 1, 'Dólar', 0),
(13, 1, 'Peso Italiano', 0),
(14, 2, 'Índico', 0),
(15, 2, 'Atlântico', 0),
(16, 2, 'Ártico', 0),
(17, 3, 'Rio de Janeiro', 0),
(18, 3, 'Minas Gerais', 0),
(19, 3, 'Brasília', 0),
(20, 4, 'Recife', 0),
(21, 4, 'Cuiabá', 0),
(22, 4, 'Rio Branco', 0),
(23, 5, 'Ronaldinho Gaúcho', 0),
(24, 5, 'Zidane', 0),
(25, 5, 'Ronaldo Fenômeno', 0),
(26, 6, 'Futebol', 0),
(27, 6, 'Ciclismo', 0),
(28, 6, 'Natação', 0),
(29, 7, 'Van Gogh', 0),
(30, 7, 'Michelangelo', 0),
(31, 7, 'Romero Brito', 0),
(32, 8, 'Itália', 0),
(33, 8, 'Espanha', 0),
(34, 8, 'Alemanha', 0),
(35, 9, 'São Paulo', 0),
(36, 9, 'Berlim', 0),
(37, 9, 'Paris', 0),
(38, 10, '11', 0),
(39, 10, '1', 0),
(40, 10, '6', 0);

-- --------------------------------------------------------

--
-- Table structure for table `leaderboard`
--

CREATE TABLE `leaderboard` (
  `position` int(11) NOT NULL,
  `user_name` varchar(64) NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `question_id` int(11) NOT NULL,
  `question_text` varchar(512) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`question_id`, `question_text`) VALUES
(1, 'Qual a antiga moeda da Itália?'),
(2, 'Em qual oceano estão as ilhas de Galápagos?'),
(3, 'Onde localiza-se o museu do MASP?'),
(4, 'Qual a capital do Mato Grosso do Sul?'),
(5, 'Quem foi melhor jogador de futebol no ano de 2007?'),
(6, 'Qual o segundo esporte mais popular no Brasil?'),
(7, 'Quem pintou a Monalisa?'),
(8, 'Em que país fica a Torre Eiffel?'),
(9, 'Em que cidade fica a sede das Nações Unidas (ONU)?'),
(10, 'Quantos meses tem 28 dias?');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `NAME` varchar(64) NOT NULL,
  `PASSWORD` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`NAME`, `PASSWORD`) VALUES
('eduardo', 'eduardo'),
('lucas', 'lucas');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answers`
--
ALTER TABLE `answers`
  ADD PRIMARY KEY (`answer_id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`question_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
