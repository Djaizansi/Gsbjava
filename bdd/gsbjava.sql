-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 20 oct. 2019 à 13:14
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsbjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

DROP TABLE IF EXISTS `famille`;
CREATE TABLE IF NOT EXISTS `famille` (
  `code_f` int(5) NOT NULL,
  `nom_f` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`code_f`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`code_f`, `nom_f`) VALUES
(6, 'Pneumologie  '),
(8, 'Endocrinologie  '),
(12, 'Anti-inflammatoires'),
(14, 'Antalgiques  '),
(15, 'Immunologie  '),
(16, 'Rhumatologie  '),
(45, 'Antidouleur');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `med_depot_legal` varchar(20) NOT NULL,
  `quantite` int(6) DEFAULT NULL,
  `etat_med` tinyint(1) DEFAULT NULL,
  `date_peremption` date DEFAULT NULL,
  `code_f` int(5) DEFAULT NULL,
  `prix_med` float DEFAULT NULL,
  PRIMARY KEY (`med_depot_legal`),
  KEY `code_f` (`code_f`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`med_depot_legal`, `quantite`, `etat_med`, `date_peremption`, `code_f`, `prix_med`) VALUES
('med01', 54, 0, '2020-06-26', 45, 10.71),
('med02', 150, 0, '2022-04-18', 15, 12.699),
('med03', 26, 1, '2019-10-02', 6, 15.2796);

-- --------------------------------------------------------

--
-- Structure de la table `praticien`
--

DROP TABLE IF EXISTS `praticien`;
CREATE TABLE IF NOT EXISTS `praticien` (
  `pra_code` int(5) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `fonction` varchar(30) NOT NULL,
  PRIMARY KEY (`pra_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `praticien`
--

INSERT INTO `praticien` (`pra_code`, `nom`, `prenom`, `adresse`, `fonction`) VALUES
(1, 'Jean', 'Bernard', '112 rue de Paris', 'Allergologue'),
(2, 'Abhissera ', 'Yoav', '10 avenue du vieux port', 'Medecin Géneraliste'),
(3, 'Akerman', 'Ruben', '56 avenue de la tour eiffel', 'Dentiste'),
(4, 'Jallali', 'Youcef', '6 rue de Patrick', 'Rhumatologue');

-- --------------------------------------------------------

--
-- Structure de la table `rapport_visite`
--

DROP TABLE IF EXISTS `rapport_visite`;
CREATE TABLE IF NOT EXISTS `rapport_visite` (
  `num` int(10) NOT NULL,
  `date_rapport` date DEFAULT NULL,
  `bilan` varchar(200) DEFAULT NULL,
  `motif` varchar(50) DEFAULT NULL,
  `etat_med` tinyint(1) DEFAULT NULL,
  `off_qte` int(5) DEFAULT NULL,
  `vis_matricule` varchar(10) DEFAULT NULL,
  `pra_code` int(5) DEFAULT NULL,
  `med_depot_legal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num`),
  KEY `pra_code` (`pra_code`),
  KEY `vis_matricule` (`vis_matricule`),
  KEY `med_depot_legal` (`med_depot_legal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rapport_visite`
--

INSERT INTO `rapport_visite` (`num`, `date_rapport`, `bilan`, `motif`, `etat_med`, `off_qte`, `vis_matricule`, `pra_code`, `med_depot_legal`) VALUES
(41, '2019-05-30', 'Effectuer', 'Bonne état', 0, 45, 'V002', 4, 'med03'),
(478, '2019-10-12', 'Nefaste', 'Medicament nefaste', 1, 487, 'V001', 2, 'med01'),
(484, '2018-11-10', 'bonjour', 'rehfrueihfer', 0, 454, 'V001', 1, 'med01'),
(514, '2018-10-14', 'Probleme', 'Rappel', 1, 4589, 'V002', 1, 'med01'),
(1001, '2019-01-11', 'RAS bonne etat', 'Rapport med01', 0, 10, 'V001', 1, 'med01');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `vis_matricule` varchar(10) NOT NULL,
  `statut` varchar(2) DEFAULT NULL,
  `mdp` varchar(50) DEFAULT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `date_embauche` date DEFAULT NULL,
  `annee_embauche` varchar(4) NOT NULL,
  PRIMARY KEY (`vis_matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`vis_matricule`, `statut`, `mdp`, `nom`, `prenom`, `adresse`, `date_embauche`, `annee_embauche`) VALUES
('V001', 'M', 'medicale', 'Alberto', 'Luigi', '14 rue de Paris', '2018-11-15', '2018'),
('V002', 'D', 'admin', 'Moha', 'lasquale', '70 Rue Douy Délcupe', '2012-01-08', '2012'),
('V003', 'M', 'azerty', 'Moha', 'Moha', 'PARIS', '2018-12-29', '2018'),
('V004', 'M', 'tyuiop', 'Moha', 'Zola', 'TUNIS', '2018-12-31', '2018');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `medicament_ibfk_1` FOREIGN KEY (`code_f`) REFERENCES `famille` (`code_f`);

--
-- Contraintes pour la table `rapport_visite`
--
ALTER TABLE `rapport_visite`
  ADD CONSTRAINT `rapport_visite_ibfk_1` FOREIGN KEY (`pra_code`) REFERENCES `praticien` (`pra_code`),
  ADD CONSTRAINT `rapport_visite_ibfk_2` FOREIGN KEY (`vis_matricule`) REFERENCES `visiteur` (`vis_matricule`),
  ADD CONSTRAINT `rapport_visite_ibfk_3` FOREIGN KEY (`med_depot_legal`) REFERENCES `medicament` (`med_depot_legal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
