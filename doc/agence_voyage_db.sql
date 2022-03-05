-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 05 mars 2022 à 19:04
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `agence_voyage_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE IF NOT EXISTS `chambre` (
  `id` int(11) NOT NULL,
  `id_hotel` int(11) NOT NULL,
  `numero` varchar(254) DEFAULT NULL,
  `description` varchar(254) DEFAULT NULL,
  `prix` varchar(254) DEFAULT NULL,
  `date_create` date NOT NULL,
  `date_update` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_chambre_associati_hotel` (`id_hotel`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `date_create` datetime NOT NULL,
  `date_update` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id`, `nom`, `telephone`, `adresse`, `date_create`, `date_update`) VALUES
(1, 'Michelle', '673667139', 'Douala', '2022-03-05 12:55:47', NULL),
(2, 'Marrion', '680587196', 'Douala', '2022-03-05 12:56:47', NULL),
(3, 'Patrice Franck', '655575799', 'Yaoundé', '2022-03-05 12:57:01', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `compagnieaerienne`
--

DROP TABLE IF EXISTS `compagnieaerienne`;
CREATE TABLE IF NOT EXISTS `compagnieaerienne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `siteweb` varchar(50) NOT NULL,
  `date_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date-update` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
CREATE TABLE IF NOT EXISTS `hotel` (
  `id` int(11) NOT NULL,
  `id_ville` int(11) NOT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `adresse` varchar(254) DEFAULT NULL,
  `telephone` varchar(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `site_web` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hotel_pk` (`id`),
  KEY `fk_hotel_associati_ville` (`id_ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` int(11) NOT NULL,
  `id_vol` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_chambre` int(11) DEFAULT NULL,
  `description` varchar(254) DEFAULT NULL,
  `date_reservation` date NOT NULL,
  `date_update` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `reservation_pk` (`id`),
  KEY `fk_reservation_associati_vol` (`id_vol`),
  KEY `fk_reservation_associati_client` (`id_client`),
  KEY `fk_reservation_associati_chambre` (`id_chambre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

DROP TABLE IF EXISTS `ville`;
CREATE TABLE IF NOT EXISTS `ville` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ville`
--

INSERT INTO `ville` (`id`, `nom`, `description`) VALUES
(1, 'Douala', 'Ville économique du Cameroun'),
(2, 'Yaoundé', 'Capitale Politique du Cameroun');

-- --------------------------------------------------------

--
-- Structure de la table `villearrivee`
--

DROP TABLE IF EXISTS `villearrivee`;
CREATE TABLE IF NOT EXISTS `villearrivee` (
  `id_ville` int(11) NOT NULL,
  `localite` varchar(50) NOT NULL,
  KEY `id` (`id_ville`),
  KEY `association1_fk` (`id_ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `villearrivee`
--

INSERT INTO `villearrivee` (`id_ville`, `localite`) VALUES
(1, 'aeroport');

-- --------------------------------------------------------

--
-- Structure de la table `villedepart`
--

DROP TABLE IF EXISTS `villedepart`;
CREATE TABLE IF NOT EXISTS `villedepart` (
  `id_ville` bigint(20) NOT NULL,
  PRIMARY KEY (`id_ville`),
  UNIQUE KEY `villedepart_pk` (`id_ville`),
  KEY `association1_fk` (`id_ville`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `villedepart`
--

INSERT INTO `villedepart` (`id_ville`) VALUES
(2);

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

DROP TABLE IF EXISTS `vol`;
CREATE TABLE IF NOT EXISTS `vol` (
  `id` int(11) NOT NULL,
  `id_ville_depart` int(11) NOT NULL,
  `id_ville_arrive` int(11) NOT NULL,
  `id_compagnie` int(11) NOT NULL,
  `nom` varchar(254) DEFAULT NULL,
  `adresse` varchar(254) DEFAULT NULL,
  `telephone` varchar(254) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `site_web` varchar(254) DEFAULT NULL,
  `date_create` date NOT NULL,
  `date_depart` date NOT NULL,
  `date_arrivee` date NOT NULL,
  `prix` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `hotel_pk` (`id`),
  KEY `fk_hotel_associati_villearrive` (`id_ville_arrive`),
  KEY `fk_hotel_associati_villedepart` (`id_ville_depart`),
  KEY `fk_hotel_associati_compagnie` (`id_compagnie`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
