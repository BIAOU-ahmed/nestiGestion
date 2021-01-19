-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 19 jan. 2021 à 13:05
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `nestigestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `idAdministrator` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(150) NOT NULL,
  `adminState` enum('a','w','b') DEFAULT NULL,
  `createAt` datetime DEFAULT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`idAdministrator`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `administrator`
--

INSERT INTO `administrator` (`idAdministrator`, `userName`, `adminState`, `createAt`, `password`) VALUES
(1, 'SuperAdmin', 'a', '2021-01-17 00:00:00', '$s0$41010$CuTXrR1KkxCDuks4r3VbCA==$OLjKChfb0mwx8ndOS+krYFLZ8/fyGXOqNX0qYcnIDjc=');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `idArticle` int(11) NOT NULL AUTO_INCREMENT,
  `weight` decimal(15,2) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `articleState` enum('a','w','b') DEFAULT NULL,
  `createdAt` datetime DEFAULT NULL,
  `idAdministrator` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  `idConditioning` int(11) NOT NULL,
  PRIMARY KEY (`idArticle`),
  KEY `idAdministrator` (`idAdministrator`),
  KEY `idProduct` (`idProduct`),
  KEY `idConditioning` (`idConditioning`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`idArticle`, `weight`, `amount`, `articleState`, `createdAt`, `idAdministrator`, `idProduct`, `idConditioning`) VALUES
(1, '0.20', 5, 'a', '2021-01-17 00:00:00', 1, 1, 1),
(2, '1.00', 5, 'a', '2021-01-17 00:00:00', 1, 2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `conditioning`
--

DROP TABLE IF EXISTS `conditioning`;
CREATE TABLE IF NOT EXISTS `conditioning` (
  `idConditioning` int(11) NOT NULL AUTO_INCREMENT,
  `conditioningName` varchar(50) NOT NULL,
  PRIMARY KEY (`idConditioning`),
  UNIQUE KEY `conditioningName` (`conditioningName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `conditioning`
--

INSERT INTO `conditioning` (`idConditioning`, `conditioningName`) VALUES
(1, 'lot'),
(2, 'paquet');

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `idProduct` int(11) NOT NULL,
  `idMeasurement` int(11) NOT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `idMeasurement` (`idMeasurement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`idProduct`, `idMeasurement`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `measurement`
--

DROP TABLE IF EXISTS `measurement`;
CREATE TABLE IF NOT EXISTS `measurement` (
  `idMeasurement` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(50) NOT NULL,
  PRIMARY KEY (`idMeasurement`),
  UNIQUE KEY `unit` (`unit`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `measurement`
--

INSERT INTO `measurement` (`idMeasurement`, `unit`) VALUES
(1, 'kg'),
(2, 'L'),
(3, 'piece');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `idOrders` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` datetime NOT NULL,
  `state` enum('act','w','bl') DEFAULT NULL,
  `idProvider` int(11) NOT NULL,
  `idAdministrator` int(11) NOT NULL,
  PRIMARY KEY (`idOrders`),
  KEY `idProvider` (`idProvider`),
  KEY `idAdministrator` (`idAdministrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `order_line`
--

DROP TABLE IF EXISTS `order_line`;
CREATE TABLE IF NOT EXISTS `order_line` (
  `idArticle` int(11) NOT NULL,
  `idOrders` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `amountReceive` int(11) DEFAULT NULL,
  `deliveryDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idArticle`,`idOrders`),
  KEY `idOrders` (`idOrders`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(150) NOT NULL,
  PRIMARY KEY (`idProduct`),
  UNIQUE KEY `productName` (`productName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`idProduct`, `productName`) VALUES
(1, 'banane'),
(2, 'fouet');

-- --------------------------------------------------------

--
-- Structure de la table `provider`
--

DROP TABLE IF EXISTS `provider`;
CREATE TABLE IF NOT EXISTS `provider` (
  `idProvider` int(11) NOT NULL AUTO_INCREMENT,
  `compagnyName` varchar(150) NOT NULL,
  `contactLastName` varchar(100) NOT NULL,
  `contactFirstName` varchar(100) NOT NULL,
  `providerState` enum('a','w','b') DEFAULT NULL,
  `contactPhoneNumber` varchar(100) NOT NULL,
  `idAdministrator` int(11) NOT NULL,
  PRIMARY KEY (`idProvider`),
  UNIQUE KEY `compagnyName` (`compagnyName`),
  KEY `idAdministrator` (`idAdministrator`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `provider`
--

INSERT INTO `provider` (`idProvider`, `compagnyName`, `contactLastName`, `contactFirstName`, `providerState`, `contactPhoneNumber`, `idAdministrator`) VALUES
(1, 'Légumes.fr', 'test', 'test1', 'a', '01.02.54.12.36', 1);

-- --------------------------------------------------------

--
-- Structure de la table `sell`
--

DROP TABLE IF EXISTS `sell`;
CREATE TABLE IF NOT EXISTS `sell` (
  `idProvider` int(11) NOT NULL,
  `idArticle` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`idProvider`,`idArticle`),
  KEY `idArticle` (`idArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `superadmin`
--

DROP TABLE IF EXISTS `superadmin`;
CREATE TABLE IF NOT EXISTS `superadmin` (
  `idAdministrator` int(11) NOT NULL,
  PRIMARY KEY (`idAdministrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utensil`
--

DROP TABLE IF EXISTS `utensil`;
CREATE TABLE IF NOT EXISTS `utensil` (
  `idProduct` int(11) NOT NULL,
  PRIMARY KEY (`idProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utensil`
--

INSERT INTO `utensil` (`idProduct`) VALUES
(2);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`),
  ADD CONSTRAINT `article_ibfk_2` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  ADD CONSTRAINT `article_ibfk_3` FOREIGN KEY (`idConditioning`) REFERENCES `conditioning` (`idConditioning`);

--
-- Contraintes pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD CONSTRAINT `ingredient_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  ADD CONSTRAINT `ingredient_ibfk_2` FOREIGN KEY (`idMeasurement`) REFERENCES `measurement` (`idMeasurement`);

--
-- Contraintes pour la table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`idProvider`) REFERENCES `provider` (`idProvider`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`);

--
-- Contraintes pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD CONSTRAINT `order_line_ibfk_1` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`),
  ADD CONSTRAINT `order_line_ibfk_2` FOREIGN KEY (`idOrders`) REFERENCES `orders` (`idOrders`);

--
-- Contraintes pour la table `provider`
--
ALTER TABLE `provider`
  ADD CONSTRAINT `provider_ibfk_1` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`);

--
-- Contraintes pour la table `sell`
--
ALTER TABLE `sell`
  ADD CONSTRAINT `sell_ibfk_1` FOREIGN KEY (`idProvider`) REFERENCES `provider` (`idProvider`),
  ADD CONSTRAINT `sell_ibfk_2` FOREIGN KEY (`idArticle`) REFERENCES `article` (`idArticle`);

--
-- Contraintes pour la table `superadmin`
--
ALTER TABLE `superadmin`
  ADD CONSTRAINT `superadmin_ibfk_1` FOREIGN KEY (`idAdministrator`) REFERENCES `administrator` (`idAdministrator`);

--
-- Contraintes pour la table `utensil`
--
ALTER TABLE `utensil`
  ADD CONSTRAINT `utensil_ibfk_1` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
