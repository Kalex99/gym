-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2022 at 02:03 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gym`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `BejelentkezesAccount` (IN `felhasznalonev` VARCHAR(20), IN `jelszo` VARCHAR(64), OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50), OUT `felh_email` VARCHAR(200), OUT `szuletesi_datum` DATE, OUT `felh_telefon` VARCHAR(11), OUT `tartozkodasihelyID` INT)  SELECT felhasznalo.FelhasznaloID, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Szuletesi_datum, felhasznalo.Felh_telefon, felhasznalo.TartozkodasihelyID from felhasznalo WHERE felhasznalo.Felhasznalonev=felhasznalonev AND felhasznalo.Jelszo=jelszo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BejelentkezesRendeles` (IN `felhasznaloID` INT, OUT `rendelesID` INT, OUT `rendeles_idopont` DATETIME, OUT `megjegyzes` TEXT, OUT `termekID` INT, OUT `berlet_vasarlasID` INT)  SELECT rendeles.RendelesID, rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.TermekID, rendeles.Berlet_vasarlasID FROM rendeles WHERE rendeles.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BejelentkezesSzemelyiEdzo` (IN `felhasznaloID` INT, OUT `szemelyi_edzoID` INT, OUT `szemedz_vezeteknev` VARCHAR(50), OUT `szemedz_keresztnev` VARCHAR(50), OUT `portre` BLOB)  SELECT felhasznaloszemelyiedzo.Szemelyi_edzoID, szemelyi_edzo.Szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev, szemelyi_edzo.Portre FROM felhasznaloszemelyiedzo INNER JOIN szemelyi_edzo ON felhasznaloszemelyiedzo.Szemelyi_edzoID=szemelyi_edzo.Szemelyi_edzoID WHERE felhasznaloszemelyiedzo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `BejelentkezesTartozkodasihely` (IN `felhasznaloID` INT, OUT `tartozkodasihelyID` INT, OUT `iranyitoszam` INT, OUT `varos` VARCHAR(100), OUT `kozterulet_neve` VARCHAR(100), OUT `kozterulet_jellege` VARCHAR(20), OUT `haz_szam` INT)  SELECT tartozkodasihely.TartozkodasihelyID, tartozkodasihely.Iranyitoszam, tartozkodasihely.Varos, tartozkodasihely.Kozterulet_neve, tartozkodasihely.Kozterulet_jellege, tartozkodasihely.Haz_szam FROM tartozkodasihely INNER JOIN felhasznalo ON tartozkodasihely.TartozkodasihelyID = felhasznalo.TartozkodasihelyID WHERE felhasznalo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasLetrehoz` (IN `berlet_tipus` VARCHAR(100), IN `berlet_ar` INT)  INSERT INTO berlet_vasarlas (berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar) VALUES (berlet_tipus,berlet_ar)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasModosit` (IN `berlet_vasarlasID` INT, IN `berlet_tipus` VARCHAR(100), IN `berlet_ar` INT)  UPDATE berlet_vasarlas SET berlet_vasarlas.Berlet_tipus=berlet_tipus, berlet_vasarlas.Berlet_ar=berlet_ar WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasOlvasas` (IN `berlet_vasarlasID` INT, OUT `berlet_tipus` VARCHAR(100), OUT `berlet_ar` INT)  SELECT berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar FROM berlet_vasarlas WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasTorles` (IN `berlet_vasarlasID` INT)  BEGIN
DELETE FROM berlet_vasarlas WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID;
DELETE FROM rendeles WHERE rendeles.Berlet_vasarlasID=berlet_vasarlasID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CegLetrehoz` (IN `ceg_nev` VARCHAR(100), IN `ceg_email` VARCHAR(200), IN `ceg_telefon` VARCHAR(20), IN `tartozkodasihelyID` INT)  INSERT INTO ceg (ceg.Ceg_nev, ceg.Ceg_email, ceg.Ceg_telefon, ceg.TartozkodasihelyID) VALUES (ceg_nev, ceg_email, ceg_telefon, tartozkodasihelyID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CegModosit` (IN `cegID` INT, IN `ceg_nev` VARCHAR(100), IN `ceg_email` VARCHAR(200), IN `ceg_telefon` VARCHAR(20), IN `tartozkodasihelyID` INT)  UPDATE ceg SET ceg.Ceg_nev=ceg_nev, ceg.Ceg_email=ceg_email, ceg.Ceg_telefon=ceg_telefon, ceg.TartozkodasihelyID=tartozkodasihelyID WHERE ceg.CegID=cegID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CegOlvasas` (IN `cegID` INT, OUT `ceg_nev` VARCHAR(100), OUT `ceg_email` VARCHAR(200), OUT `ceg_telefon` VARCHAR(20), OUT `tartozkodasihelyID` INT)  SELECT ceg.Ceg_nev, ceg.Ceg_email, ceg.Ceg_telefon, ceg.TartozkodasihelyID FROM ceg WHERE ceg.CegID=cegID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CegOlvasasTartozkodasihely` (IN `cegID` INT, OUT `tartozkodasihelyID` INT, OUT `iranyitoszam` INT, OUT `varos` VARCHAR(100), OUT `kozterulet_neve` VARCHAR(100), OUT `kozterulet_jellege` VARCHAR(20), OUT `haz_szam` INT)  SELECT tartozkodasihely.TartozkodasihelyID, tartozkodasihely.Iranyitoszam, tartozkodasihely.Varos, tartozkodasihely.Kozterulet_neve, tartozkodasihely.Kozterulet_jellege, tartozkodasihely.Haz_szam FROM tartozkodasihely INNER JOIN ceg ON tartozkodasihely.TartozkodasihelyID= ceg.TartozkodasihelyID WHERE ceg.CegID=cegID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `CegTorles` (IN `cegID` INT)  BEGIN
DELETE FROM tartozkodasihely WHERE tartozkodasihely.TartozkodasihelyID=(SELECT ceg.TartozkodasihelyID FROM ceg WHERE ceg.CegID=cegID);
DELETE FROM ceg WHERE ceg.CegID=cegID;
DELETE FROM termek WHERE termek.CegID=cegID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloLetrehoz` (IN `felhasznalonev` VARCHAR(20), IN `jelszo` VARCHAR(64), IN `felh_vezeteknev` VARCHAR(50), IN `felh_keresztnev` VARCHAR(50), IN `felh_email` VARCHAR(200), IN `szuletesi_datum` DATE, IN `felh_telefon` VARCHAR(11), IN `tartozkodasihelyID` INT)  MODIFIES SQL DATA
INSERT INTO felhasznalo (felhasznalo.Felhasznalonev, felhasznalo.Jelszo, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Szuletesi_datum, felhasznalo.Felh_telefon, felhasznalo.TartozkodasihelyID) VALUES (felhasznalonev,jelszo,felh_vezeteknev,felh_keresztnev, felh_email, szuletesi_datum, felh_telefon, tartozkodasihelyID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloModosit` (IN `felhasznaloID` INT, IN `felhasznalonev` VARCHAR(20), IN `jelszo` VARCHAR(64), IN `felh_vezeteknev` VARCHAR(50), IN `felh_keresztnev` VARCHAR(50), IN `felh_email` VARCHAR(200), IN `felh_telefon` VARCHAR(11), IN `tartozkodasihelyID` INT)  UPDATE felhasznalo SET felhasznalo.Felhasznalonev=felhasznalonev, felhasznalo.Jelszo=jelszo, felhasznalo.Felh_vezeteknev=felh_vezeteknev, felhasznalo.Felh_keresztnev= felh_keresztnev, felhasznalo.Felh_email=felh_email, felhasznalo.Felh_telefon=felh_telefon, felhasznalo.TartozkodasihelyID= tartozkodasihelyID WHERE felhasznalo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloOlvasas` ()  SELECT * FROM felhasznalo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloOlvasasByID` (IN `felhasznaloID` INT, OUT `felhasznalonev` VARCHAR(20), OUT `jelszo` VARCHAR(64), OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50), OUT `szuletesi_datum` DATE, OUT `felh_email` VARCHAR(200), OUT `felh_telefon` VARCHAR(11), OUT `tartozkodasihelyID` INT)  SELECT felhasznalo.Felhasznalonev, felhasznalo.Jelszo, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Szuletesi_datum, felhasznalo.Felh_telefon, felhasznalo.TartozkodasihelyID FROM felhasznalo WHERE felhasznalo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloTorles` (IN `felhasznaloID` INT)  BEGIN
DELETE FROM tartozkodasihely WHERE tartozkodasihely.TartozkodasihelyID=(SELECT felhasznalo.TartozkodasihelyID FROM felhasznalo WHERE felhasznalo.FelhasznaloID=felhasznaloID);
DELETE FROM rendeles WHERE rendeles.FelhasznaloID=felhasznaloID;
DELETE FROM felhasznalo WHERE felhasznalo.FelhasznaloID=felhasznaloID;
DELETE FROM felhasznaloszemelyiedzo WHERE felhasznaloszemelyiedzo.FelhasznaloID=felhasznaloID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesLetrehoz` (IN `megjegyzes` TEXT, IN `termekID` INT, IN `berlet_vasarlasID` INT, IN `felhasznaloID` INT)  INSERT INTO rendeles(rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.TermekID, rendeles.Berlet_vasarlasID, rendeles.FelhasznaloID) VALUES (now(), megjegyzes,termekID, berlet_vasarlasID, felhasznaloID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasas` (IN `rendelesID` INT, OUT `rendeles_idopont` DATETIME, OUT `megjegyzes` TEXT, OUT `termekID` INT, OUT `berlet_vasarlasID` INT, OUT `felhasznaloID` INT)  SELECT rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.TermekID, rendeles.Berlet_vasarlasID, rendeles.FelhasznaloID FROM rendeles WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasasBerlet` (IN `rendelesID` INT, OUT `berlet_vasarlasID` INT, OUT `berlet_tipus` VARCHAR(100), OUT `berlet_ar` INT)  SELECT berlet_vasarlas.Berlet_vasarlasID, berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar FROM berlet_vasarlas INNER JOIN rendeles on berlet_vasarlas.Berlet_vasarlasID=rendeles.Berlet_vasarlasID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasasFelhasznalo` (IN `rendelesID` INT, OUT `felhasznaloID` INT, OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50), OUT `felh_email` VARCHAR(200), OUT `felh_telefon` VARCHAR(11), OUT `tartozkodasihelyID` INT)  SELECT felhasznalo.FelhasznaloID, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Felh_telefon, felhasznalo.TartozkodasihelyID FROM felhasznalo INNER JOIN rendeles on felhasznalo.FelhasznaloID=rendeles.FelhasznaloID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasasTermek` (IN `rendelesID` INT, OUT `termekID` INT, OUT `termek_nev` VARCHAR(100), OUT `kategoria` VARCHAR(50), OUT `ar` INT, OUT `kep` BLOB, OUT `leiras` TEXT, OUT `cegID` INT)  SELECT termek.TermekID, termek.Termek_nev, termek.Kategoria, termek.Ar, termek.Kep, termek.Leiras, termek.CegID FROM termek INNER JOIN rendeles ON termek.TermekID= rendeles.TermekID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesTorles` (IN `rendelesID` INT)  DELETE FROM rendeles WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoLetrehoz` (IN `szemedz_vezeteknev` VARCHAR(50), IN `szemedz_keresztnev` VARCHAR(50), IN `portre` BLOB, IN `szemedz_email` VARCHAR(200), IN `szemedz_telefon` VARCHAR(11), IN `tartozkodasihelyID` INT)  INSERT INTO szemelyi_edzo (szemelyi_edzo.Szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev, szemelyi_edzo.Portre, szemelyi_edzo.Szemedz_email, szemelyi_edzo.Szemedz_telefon, szemelyi_edzo.TartozkodasihelyID) VALUES (szemedz_vezeteknev, szemedz_keresztnev, portre, szemedz_email, szemedz_telefon, tartozkodasihelyID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoModosit` (IN `szemelyi_edzoID` INT, IN `szemedz_vezeteknev` VARCHAR(50), IN `szemedz_keresztnev` VARCHAR(50), IN `portre` BLOB, IN `szemedz_email` VARCHAR(200), IN `szemedz_telefon` VARCHAR(11), IN `tartozkodasihelyID` INT)  UPDATE szemelyi_edzo SET szemelyi_edzo.Szemedz_vezeteknev=szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev=szemedz_keresztnev, szemelyi_edzo.Portre=portre, szemelyi_edzo.Szemedz_email=szemedz_email, szemelyi_edzo.Szemedz_telefon=szemedz_telefon, szemelyi_edzo.TartozkodasihelyID=tartozkodasihelyID WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoOlvasas` (IN `szemelyi_edzoID` INT, OUT `szemedz_vezeteknev` VARCHAR(50), OUT `szemedz_keresztnev` VARCHAR(50), OUT `portre` BLOB, OUT `szemedz_email` VARCHAR(200), OUT `szemedz_telefon` VARCHAR(11), OUT `tartozkodasihelyID` INT)  SELECT szemelyi_edzo.Szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev, szemelyi_edzo.Portre, szemelyi_edzo.Szemedz_email, szemelyi_edzo.Szemedz_telefon, szemelyi_edzo.TartozkodasihelyID FROM szemelyi_edzo WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoOlvasasFelhasznalo` (IN `szemelyi_edzoID` INT, OUT `felhasznaloID` INT, OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50))  SELECT felhasznaloszemelyiedzo.FelhasznaloID, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev FROM felhasznaloszemelyiedzo INNER JOIN felhasznalo ON felhasznaloszemelyiedzo.FelhasznaloID=felhasznalo.FelhasznaloID WHERE felhasznaloszemelyiedzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoOlvasasTartozkodasihely` (IN `szemelyi_edzoID` INT, OUT `tartozkodasihelyID` INT, OUT `iranyitoszam` INT, OUT `varos` VARCHAR(100), OUT `kozterulet_neve` VARCHAR(100), OUT `kozterulet_jellege` VARCHAR(20), OUT `haz_szam` INT)  SELECT tartozkodasihely.TartozkodasihelyID, tartozkodasihely.Iranyitoszam, tartozkodasihely.Varos, tartozkodasihely.Kozterulet_neve, tartozkodasihely.Kozterulet_jellege,  tartozkodasihely.Haz_szam FROM tartozkodasihely INNER JOIN szemelyi_edzo ON tartozkodasihely.TartozkodasihelyID = szemelyi_edzo.TartozkodasihelyID WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoTorles` (IN `szemelyi_edzoID` INT)  BEGIN 
DELETE FROM tartozkodasihely WHERE tartozkodasihely.TartozkodasihelyID=(SELECT szemelyi_edzo.TartozkodasihelyID FROM szemelyi_edzo WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID);
DELETE FROM szemelyi_edzo WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TartozkodasihelyLetrehoz` (IN `iranyitoszam` INT, IN `varos` VARCHAR(100), IN `kozterulet_neve` VARCHAR(100), IN `kozterulet_jellege` VARCHAR(20), IN `haz_szam` INT)  INSERT INTO tartozkodasihely( tartozkodasihely.Iranyitoszam, tartozkodasihely.Varos, tartozkodasihely.Kozterulet_neve, tartozkodasihely.Kozterulet_jellege, tartozkodasihely.Haz_szam) VALUES (iranyitoszam, varos, kozterulet_neve, kozterulet_jellege, haz_szam)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TartozkodasihelyModosit` (IN `tartozkodasihelyID` INT, IN `iranyitoszam` INT, IN `varos` VARCHAR(100), IN `kozterulet_neve` VARCHAR(100), IN `kozterulet_jelleg` VARCHAR(20), IN `haz_szam` INT)  UPDATE tartozkodasihely SET tartozkodasihely.Iranyitoszam=iranyitoszam, tartozkodasihely.Varos=varos, tartozkodasihely.Kozterulet_neve=kozterulet_neve, tartozkodasihely.Kozterulet_jellege=kozterulet_jelleg, tartozkodasihely.Haz_szam=haz_szam WHERE tartozkodasihely.TartozkodasihelyID=tartozkodasihelyID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TartozkodasihelyOlvasas` (IN `tartozkodasihelyID` INT, OUT `iranyitoszam` INT, OUT `varos` VARCHAR(100), OUT `kozterulet_neve` VARCHAR(100), OUT `kozterulet_jellege` VARCHAR(20), OUT `haz_szam` INT)  SELECT tartozkodasihely.Iranyitoszam, tartozkodasihely.Varos, tartozkodasihely.Kozterulet_neve, tartozkodasihely.Kozterulet_jellege, tartozkodasihely.Haz_szam FROM tartozkodasihely WHERE tartozkodasihely.TartozkodasihelyID=tartozkodasihelyID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TartozkodasihelyTorles` (IN `tartozkodasihelyID` INT)  DELETE FROM tartozkodasihely WHERE tartozkodasihely.TartozkodasihelyID=tartozkodasihelyID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekLetrehoz` (IN `termek_nev` VARCHAR(100), IN `kategoria` VARCHAR(50), IN `ar` INT, IN `kep` BLOB, IN `keszlet` INT, IN `leiras` TEXT, IN `cegID` INT)  INSERT INTO termek (termek.Termek_nev, termek.Kategoria, termek.Ar, termek.Kep, termek.Keszlet, termek.Kaphato, termek.Leiras, termek.CegID) VALUES (termek_nev,kategoria,ar,kep,keszlet,1,leiras, cegID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekModosit` (IN `termekID` INT, IN `termek_nev` VARCHAR(100), IN `kategoria` VARCHAR(50), IN `ar` INT, IN `kep` BLOB, IN `keszlet` INT, IN `kaphato` BOOLEAN, IN `leiras` TEXT, IN `cegID` INT)  UPDATE termek SET termek.Termek_nev=termek_nev, termek.Kategoria=kategoria, termek.Ar=ar, termek.Kep=kep, termek.Keszlet=keszlet, termek.Kaphato=kaphato, termek.Leiras=leiras, termek.CegID=cegID WHERE termek.TermekID=termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekOlvasas` (IN `termekID` INT, OUT `termek_nev` VARCHAR(100), OUT `kategoria` VARCHAR(50), OUT `ar` INT, OUT `kep` BLOB, OUT `keszlet` INT, OUT `kaphato` BOOLEAN, OUT `leiras` TEXT, OUT `cegID` INT)  SELECT termek.Termek_nev, termek.Kategoria, termek.Ar, termek.Kep, termek.Keszlet, termek.Kaphato, termek.Leiras, termek.CegID FROM termek WHERE termek.TermekID=termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekOlvasasCeg` (IN `termekID` INT, OUT `cegID` INT, OUT `ceg_nev` VARCHAR(100), OUT `ceg_email` VARCHAR(200), OUT `ceg_telefon` VARCHAR(20), OUT `tartozkodasihelyID` INT)  SELECT ceg.CegID, ceg.Ceg_nev, ceg.Ceg_email, ceg.Ceg_telefon, ceg.TartozkodasihelyID FROM ceg INNER JOIN termek ON ceg.CegID = termek.CegID WHERE termek.TermekID=termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekTorles` (IN `termekID` INT)  BEGIN
DELETE FROM termek WHERE termek.TermekID=termekID;
DELETE FROM rendeles WHERE rendeles.TermekID=termekID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `berlet_vasarlas`
--

CREATE TABLE `berlet_vasarlas` (
  `Berlet_vasarlasID` int(11) NOT NULL,
  `Berlet_tipus` varchar(100) NOT NULL,
  `Berlet_ar` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `berlet_vasarlas`
--

INSERT INTO `berlet_vasarlas` (`Berlet_vasarlasID`, `Berlet_tipus`, `Berlet_ar`) VALUES
(1, 'vitae', 2290),
(2, 'aliquam', 2655),
(3, 'ullam', 2051),
(4, 'voluptas', 1042),
(5, 'voluptatem', 1513);

-- --------------------------------------------------------

--
-- Table structure for table `ceg`
--

CREATE TABLE `ceg` (
  `CegID` int(11) NOT NULL,
  `Ceg_nev` varchar(100) NOT NULL,
  `Ceg_email` varchar(200) NOT NULL,
  `Ceg_telefon` varchar(20) NOT NULL,
  `TartozkodasihelyID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ceg`
--

INSERT INTO `ceg` (`CegID`, `Ceg_nev`, `Ceg_email`, `Ceg_telefon`, `TartozkodasihelyID`) VALUES
(2, 'Kshlerin, Connelly and Aufderhar', 'judge03@example.org', '+42(4)1604177595', 2),
(3, 'Ledner-Mayert', 'monahan.sabrina@example.com', '125.798.2598x013', 3),
(4, 'Walter-Rutherford', 'aheidenreich@example.net', '004.541.1722x54559', 4),
(6, 'Carroll PLC', 'dauer@example.org', '(316)086-2545x4819', 6),
(7, 'Bergnaum PLC', 'bell86@example.com', '776-358-2231x66090', 7),
(8, 'Senger, Heller and Gerhold', 'trey20@example.com', '588.487.0394', 8),
(11, 'ITHUB', 'ithub@ithub.ithub', '+3630456542', 4);

-- --------------------------------------------------------

--
-- Table structure for table `felhasznalo`
--

CREATE TABLE `felhasznalo` (
  `FelhasznaloID` int(11) NOT NULL,
  `Felhasznalonev` varchar(20) NOT NULL,
  `Jelszo` varchar(64) NOT NULL,
  `Felh_vezeteknev` varchar(50) NOT NULL,
  `Felh_keresztnev` varchar(50) NOT NULL,
  `Felh_email` varchar(200) NOT NULL,
  `Szuletesi_datum` date NOT NULL,
  `Felh_telefon` varchar(11) NOT NULL,
  `TartozkodasihelyID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `felhasznalo`
--

INSERT INTO `felhasznalo` (`FelhasznaloID`, `Felhasznalonev`, `Jelszo`, `Felh_vezeteknev`, `Felh_keresztnev`, `Felh_email`, `Szuletesi_datum`, `Felh_telefon`, `TartozkodasihelyID`) VALUES
(2, 'perferendis', 'illum', 'Kessler', 'Adrian', 'art.stanton@example.com', '2010-12-28', '(659)634-22', 2),
(3, 'maiores', 'quia', 'Beahan', 'Ignacio', 'ikozey@example.org', '1984-10-29', '01643508922', 3),
(4, 'aspernatur', 'ea', 'Boyle', 'Kaia', 'qwilkinson@example.org', '2008-11-17', '1-771-513-2', 4),
(6, 'aliquam', 'pariatur', 'Kassulke', 'Ryley', 'barton.jaida@example.net', '1994-03-26', '1-649-155-0', 6),
(7, 'debitis', 'numquam', 'Shanahan', 'Antonia', 'tkertzmann@example.org', '2004-07-01', '594.622.728', 7),
(8, 'sit', 'expedita', 'McCullough', 'Kaylin', 'mcclure.irving@example.net', '1987-01-22', '+32(4)42101', 8),
(11, 'et', 'delectus', 'Hayes', 'Lelia', 'faustino31@example.org', '1987-07-22', '357.039.141', 11),
(12, 'dolore', 'dignissimos', 'Padberg', 'Bobbie', 'irwin.nienow@example.org', '1976-04-25', '082.402.384', 12),
(13, 'omnis', 'velit', 'Kilback', 'Everette', 'garett.predovic@example.org', '2010-03-29', '1-800-406-3', 13),
(14, 'sunt', 'dolore', 'Witting', 'Misael', 'carmela.hills@example.com', '1987-03-08', '1-254-636-1', 14),
(15, 'doloremque', 'culpa', 'Brakus', 'Samson', 'talon.beatty@example.net', '2010-07-11', '(540)376-46', 15),
(16, 'quibusdam', 'nam', 'Aufderhar', 'Chloe', 'montana.bins@example.net', '2001-05-01', '061-156-882', 16),
(17, 'architecto', 'culpa', 'Farrell', 'Alia', 'braden41@example.com', '2021-06-01', '577.475.860', 17),
(18, 'placeat', 'asperiores', 'Cassin', 'Orpha', 'batz.destany@example.com', '1976-07-25', '+61(9)97986', 18),
(19, 'totam', 'veritatis', 'Brekke', 'Georgette', 'jjacobi@example.org', '1979-03-02', '738.219.471', 19),
(20, 'non', 'qui', 'Wunsch', 'Shanelle', 'bboyer@example.com', '1972-11-04', '(609)891-83', 20),
(21, 'dignissimos', 'enim', 'Casper', 'Donato', 'bernhard.maggio@example.org', '2017-04-24', '1-058-403-8', 21),
(22, 'laborum', 'doloremque', 'Bashirian', 'Ellie', 'jevon48@example.org', '1982-07-16', '419-660-804', 22),
(23, 'quo', 'quae', 'Schaefer', 'Arjun', 'nakia.predovic@example.com', '2010-01-13', '(013)559-55', 23),
(24, 'dolor', 'non', 'Schmitt', 'Hortense', 'vhessel@example.org', '1979-03-25', '805.601.985', 24),
(25, 'quis', 'sed', 'Goodwin', 'Chanelle', 'antonetta13@example.org', '1987-05-06', '199-630-283', 25),
(26, 'a', 'in', 'Ward', 'Camden', 'deon94@example.net', '1991-04-29', '257-154-191', 26),
(27, 'repellendus', 'modi', 'Lebsack', 'Chanel', 'bayer.scarlett@example.org', '2002-06-24', '09446491286', 27),
(31, 'beatae', 'id', 'Quigley', 'Willy', 'dbartell@example.com', '2006-02-27', '136.161.965', 31),
(32, 'tempora', 'ut', 'Lebsack', 'Lemuel', 'schroeder.trenton@example.org', '1975-06-02', '(143)815-59', 32),
(33, 'illum', 'quam', 'Spinka', 'Maymie', 'lhowell@example.org', '2010-12-12', '1-876-891-3', 33),
(34, 'saepe', 'quia', 'McDermott', 'Kailey', 'kilback.travon@example.com', '1985-09-18', '242-734-259', 34),
(35, 'vitae', 'molestias', 'West', 'Augustus', 'xkertzmann@example.net', '1972-07-17', '1-934-773-7', 35),
(36, 'itaque', 'ullam', 'Heidenreich', 'döbrögi', 'torp.felix@example.net', '1971-06-07', '065-393-904', 36),
(37, 'delectus', 'cupiditate', 'Gerhold', 'Lucious', 'reichel.cassandra@example.org', '2014-01-22', '932-459-244', 37),
(38, 'minima', 'inventore', 'Hegmann', 'Shaina', 'blanca.vandervort@example.com', '1999-09-12', '(801)023-33', 38),
(39, 'quidem', 'fugiat', 'Dooley', 'Bertrand', 'fkreiger@example.org', '2012-04-02', '029.773.771', 39),
(41, 'ullam', 'reiciendis', 'Waelchi', 'Jadon', 'swift.janiya@example.net', '1991-11-04', '851.646.096', 41),
(42, 'voluptatem', 'aut', 'Muller', 'Vilma', 'zcummerata@example.org', '1979-06-18', '(367)763-02', 42),
(43, 'inventore', 'rerum', 'Brekke', 'Enrico', 'ethyl33@example.com', '1983-12-25', '1-311-981-5', 43),
(44, 'repudiandae', 'perspiciatis', 'Labadie', 'Ada', 'kian80@example.net', '1999-10-16', '(810)738-85', 44),
(45, 'in', 'dolorum', 'Gleichner', 'Tess', 'jennings09@example.net', '1998-09-26', '550.417.481', 45),
(46, 'animi', 'est', 'Batz', 'Daphne', 'bergnaum.zackery@example.org', '2017-08-02', '556-211-250', 46),
(47, 'sapiente', 'exercitationem', 'Heidenreich', 'Oscar', 'gabe.gorczany@example.net', '1979-06-19', '136.889.507', 47),
(48, 'unde', 'et', 'Murphy', 'Kaci', 'zkirlin@example.org', '2009-09-02', '920.441.568', 48),
(49, 'accusantium', 'provident', 'Jenkins', 'Jeremy', 'johnston.howard@example.com', '1989-12-05', '989-593-316', 49),
(88, 'Reddit', 'hh', 'bc', 'bcx', 'wqd', '2022-04-05', 'cxy', 2);

-- --------------------------------------------------------

--
-- Table structure for table `felhasznaloszemelyiedzo`
--

CREATE TABLE `felhasznaloszemelyiedzo` (
  `FelhasznaloID` int(11) NOT NULL,
  `Szemelyi_edzoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `felhasznaloszemelyiedzo`
--

INSERT INTO `felhasznaloszemelyiedzo` (`FelhasznaloID`, `Szemelyi_edzoID`) VALUES
(2, 2),
(3, 3),
(4, 4),
(6, 6),
(7, 7),
(8, 8),
(12, 2),
(13, 3),
(14, 4),
(16, 6),
(17, 7),
(18, 8),
(22, 2),
(23, 3),
(24, 4),
(26, 6),
(27, 7);

-- --------------------------------------------------------

--
-- Table structure for table `rendeles`
--

CREATE TABLE `rendeles` (
  `RendelesID` int(11) NOT NULL,
  `Rendeles_idopont` datetime NOT NULL,
  `Megjegyzes` text NOT NULL,
  `TermekID` int(11) NOT NULL,
  `Berlet_vasarlasID` int(11) NOT NULL,
  `FelhasznaloID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rendeles`
--

INSERT INTO `rendeles` (`RendelesID`, `Rendeles_idopont`, `Megjegyzes`, `TermekID`, `Berlet_vasarlasID`, `FelhasznaloID`) VALUES
(2, '1975-07-06 22:46:59', 'Omnis dolorem quo.', 2, 2, 2),
(3, '1997-04-04 06:24:45', 'Et aspernatur.', 3, 3, 3),
(4, '1984-12-21 05:52:05', 'Inventore rerum qui.', 4, 4, 4),
(6, '1982-07-26 05:14:29', 'Occaecati dolores.', 6, 1, 6),
(7, '1977-01-03 15:18:40', 'Ut natus molestiae.', 7, 2, 7),
(8, '1976-07-19 08:46:19', 'Repellat possimus.', 8, 3, 8),
(12, '1995-05-27 21:50:17', 'Eos voluptate.', 12, 2, 12),
(13, '1986-09-09 18:33:42', 'Ex suscipit quia.', 13, 3, 13),
(14, '1991-01-29 19:23:58', 'Commodi architecto.', 14, 4, 14),
(16, '1980-04-20 14:01:34', 'Nulla non pariatur.', 16, 1, 16),
(17, '1986-12-15 22:49:23', 'Amet occaecati ipsa.', 17, 2, 17),
(18, '2010-05-13 18:15:32', 'Et quod architecto.', 18, 3, 18),
(22, '1984-05-24 04:38:03', 'Nobis et porro.', 22, 2, 22),
(23, '2007-04-18 05:00:29', 'Aut aliquid non.', 23, 3, 23),
(24, '1982-05-01 12:27:35', 'Neque perferendis.', 24, 4, 24),
(26, '1999-08-11 06:42:09', 'Corporis omnis.', 26, 1, 26),
(27, '1994-10-15 10:17:31', 'Consequatur quis.', 27, 2, 27),
(32, '2004-07-25 09:45:45', 'Ea soluta ex quo.', 32, 2, 32),
(33, '2007-03-29 01:17:37', 'Aut hic asperiores.', 33, 3, 33),
(34, '1986-09-16 04:57:21', 'Neque iusto sequi.', 34, 4, 34),
(36, '2010-02-11 04:24:32', 'Quasi voluptas.', 36, 1, 36),
(37, '1991-01-29 13:44:41', 'Iure eligendi.', 37, 2, 37),
(38, '1970-12-19 08:03:26', 'Ea veniam.', 38, 3, 38),
(42, '2015-01-22 23:26:09', 'Eligendi cumque sit.', 42, 2, 42),
(43, '2016-02-07 00:53:52', 'Exercitationem.', 43, 3, 43),
(44, '1992-12-28 14:15:35', 'Nam repellendus.', 44, 4, 44),
(46, '1987-06-21 05:59:19', 'Ut sint officia qui.', 46, 1, 46),
(47, '1997-09-17 05:47:24', 'Maiores saepe et.', 47, 2, 47),
(48, '1984-06-08 21:51:24', 'Tempora sed dolorem.', 48, 3, 48);

-- --------------------------------------------------------

--
-- Table structure for table `szemelyi_edzo`
--

CREATE TABLE `szemelyi_edzo` (
  `Szemelyi_edzoID` int(11) NOT NULL,
  `Szemedz_vezeteknev` varchar(50) NOT NULL,
  `Szemedz_keresztnev` varchar(50) NOT NULL,
  `Portre` blob NOT NULL,
  `Szemedz_email` varchar(200) NOT NULL,
  `Szemedz_telefon` varchar(11) NOT NULL,
  `TartozkodasihelyID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `szemelyi_edzo`
--

INSERT INTO `szemelyi_edzo` (`Szemelyi_edzoID`, `Szemedz_vezeteknev`, `Szemedz_keresztnev`, `Portre`, `Szemedz_email`, `Szemedz_telefon`, `TartozkodasihelyID`) VALUES
(2, 'Grady', 'Anahi', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'matilda62@example.org', '028-844-782', 2),
(3, 'Upton', 'Samir', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'solon.blick@example.org', '(976)124-39', 3),
(4, 'Konopelski', 'Orland', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'ceasar.erdman@example.net', '837.326.349', 4),
(6, 'Price', 'Oren', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'kellen77@example.com', '1-112-735-1', 6),
(7, 'Schmeler', 'Denis', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'palma87@example.com', '(576)830-09', 7),
(8, 'Kuvalis', 'Woodrow', 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 'mccullough.rosalinda@example.com', '(938)085-94', 8),
(11, 'Sanyi', 'Sandor', 0x68656c6c6f, 'hello@hello.com', '+30258416', 6);

-- --------------------------------------------------------

--
-- Table structure for table `tartozkodasihely`
--

CREATE TABLE `tartozkodasihely` (
  `TartozkodasihelyID` int(11) NOT NULL,
  `Iranyitoszam` int(11) UNSIGNED NOT NULL,
  `Varos` varchar(100) NOT NULL,
  `Kozterulet_neve` varchar(100) NOT NULL,
  `Kozterulet_jellege` varchar(20) NOT NULL,
  `Haz_szam` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tartozkodasihely`
--

INSERT INTO `tartozkodasihely` (`TartozkodasihelyID`, `Iranyitoszam`, `Varos`, `Kozterulet_neve`, `Kozterulet_jellege`, `Haz_szam`) VALUES
(2, 73488, 'Mosciskiport', 'Dagmar Rue', 'Inlet', 6),
(3, 30388, 'Wymanbury', 'Quigley Fall', 'Wells', 6),
(4, 51963, 'Lake Rosemaryfurt', 'Rau Fields', 'Circle', 6),
(6, 74493, 'East Saigeton', 'Johnston Pines', 'Club', 6),
(7, 39731, 'East Lelia', 'Joanie Well', 'Meadow', 6),
(8, 80688, 'Bashiriantown', 'Schmitt Rest', 'Lock', 6),
(11, 54118, 'East Joan', 'Rau Crest', 'Glen', 6),
(12, 939, 'North Claudview', 'Anastacio Freeway', 'Mountains', 6),
(13, 97671, 'Ottilieberg', 'Gaylord Crest', 'Crossroad', 6),
(14, 37906, 'Lake Alexandreview', 'Fay Centers', 'Radial', 6),
(15, 83731, 'New Giuseppe', 'Hillary Isle', 'Vista', 6),
(16, 22963, 'Joyceview', 'Adams Islands', 'Rest', 6),
(17, 15556, 'East Benjamin', 'Thora Ville', 'Square', 6),
(18, 93839, 'Streichmouth', 'Edythe Path', 'Trafficway', 6),
(19, 37309, 'West Elijahport', 'Alysha Lodge', 'Ramp', 6),
(20, 33511, 'McClurebury', 'Jerod Prairie', 'Throughway', 6),
(21, 36109, 'East Hermanmouth', 'Elsa Burgs', 'Roads', 6),
(22, 96385, 'New Dinafurt', 'Prosacco Crossing', 'Island', 6),
(23, 39871, 'Nehamouth', 'Funk Neck', 'Throughway', 6),
(24, 33102, 'South Georgettechester', 'Claude Shore', 'Mount', 6),
(25, 58760, 'New Jeremie', 'Pagac Plaza', 'Glens', 6),
(26, 60482, 'New Cleta', 'Lubowitz Branch', 'Junction', 6),
(27, 66121, 'Moisestown', 'Ullrich Turnpike', 'Ranch', 6),
(30, 75273, 'Port Isaac', 'Smith Locks', 'Squares', 6),
(31, 18820, 'South Maynardchester', 'Johnson Squares', 'Plains', 6),
(32, 54116, 'Gleasonmouth', 'Desmond Dam', 'Station', 6),
(33, 25656, 'Edwinville', 'Caesar Wall', 'Walks', 6),
(34, 79152, 'Port Deontown', 'Conn Divide', 'Keys', 6),
(35, 2085, 'New Enidville', 'Langworth Ramp', 'Radial', 6),
(36, 1776, 'New Maximusburgh', 'Bartell Bypass', 'Freeway', 6),
(37, 1196, 'West Prudence', 'Schroeder Path', 'Summit', 6),
(38, 19676, 'West Ashlynn', 'Marks Coves', 'Roads', 6),
(39, 54064, 'North Alda', 'Leannon Mission', 'Forge', 6),
(40, 49821, 'New Marietta', 'Lebsack Mountains', 'River', 6),
(41, 44203, 'Harberton', 'Madeline Prairie', 'Trace', 6),
(42, 91762, 'Roobland', 'Green Throughway', 'Valleys', 6),
(43, 40296, 'Port Ian', 'Roxane Mall', 'Plains', 6),
(44, 80107, 'Providenciport', 'Gerlach Shore', 'Harbor', 6),
(45, 98356, 'Brendaberg', 'Deckow Haven', 'Stream', 6),
(46, 84659, 'Predovicchester', 'Lavinia Roads', 'Alley', 6),
(47, 75099, 'Lake Lonie', 'Satterfield Knolls', 'Trafficway', 6),
(48, 13045, 'Zboncakfort', 'Bennett Pike', 'Harbors', 6),
(49, 53204, 'South Nikitaview', 'Roob Place', 'Junctions', 6),
(50, 7800, 'Beremend', 'helixlab', 'ithub', 6),
(51, 7800, 'Beremend', 'helixlab', '', 6);

-- --------------------------------------------------------

--
-- Table structure for table `termek`
--

CREATE TABLE `termek` (
  `TermekID` int(11) NOT NULL,
  `Termek_nev` varchar(100) NOT NULL,
  `Kategoria` varchar(50) NOT NULL,
  `Ar` int(11) UNSIGNED NOT NULL,
  `Kep` blob NOT NULL,
  `Keszlet` int(11) UNSIGNED NOT NULL,
  `Kaphato` tinyint(1) NOT NULL,
  `Leiras` text NOT NULL,
  `CegID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `termek`
--

INSERT INTO `termek` (`TermekID`, `Termek_nev`, `Kategoria`, `Ar`, `Kep`, `Keszlet`, `Kaphato`, `Leiras`, `CegID`) VALUES
(2, 'necessitatibus', 'sint', 6527, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 40, 1, 'Corporis sit voluptatem quasi ab non.', 2),
(3, 'mollitia', 'aliquid', 9777, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 37, 1, 'Earum quia non consequuntur ullam aspernatur.', 3),
(4, 'molestias', 'ex', 6613, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 21, 1, 'Neque laudantium fugit porro accusamus.', 4),
(6, 'est', 'doloremque', 7178, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 0, 0, 'Delectus voluptatem nobis possimus enim.', 6),
(7, 'non', 'distinctio', 3570, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 41, 1, 'Omnis sint sint nobis quia.', 7),
(8, 'placeat', 'quia', 3240, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 17, 1, 'Dolores libero eum sit aut sed earum nulla.', 8),
(12, 'animi', 'omnis', 3963, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 46, 1, 'Aliquam quae voluptatem quia autem ea.', 2),
(13, 'nam', 'sit', 6655, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 0, 1, 'Praesentium beatae voluptas ut ducimus explicabo.', 3),
(14, 'quae', 'non', 5132, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 18, 1, 'Ipsam ad omnis sunt nam.', 4),
(16, 'autem', 'maxime', 8914, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 3, 0, 'Dolorum qui eum aut non exercitationem iste iste.', 6),
(17, 'dolor', 'quasi', 9051, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 14, 1, 'Ea eum unde et aperiam architecto.', 7),
(18, 'eos', 'adipisci', 9172, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 36, 0, 'Sunt architecto neque architecto.', 8),
(22, 'similique', 'recusandae', 3350, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 7, 1, 'Sequi sit neque rem pariatur rerum consequatur.', 2),
(23, 'officiis', 'quisquam', 8860, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 18, 1, 'At sint tenetur ex itaque earum odit.', 3),
(24, 'maxime', 'perferendis', 5642, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 0, 1, 'Numquam aut corporis tenetur possimus voluptates.', 4),
(26, 'expedita', 'unde', 3036, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 16, 0, 'Nisi et voluptatum aut.', 6),
(27, 'quasi', 'impedit', 4786, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 15, 1, 'Accusamus aut repellendus alias nostrum.', 7),
(28, 'consequuntur', 'aut', 3631, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 8, 0, 'Facere eum nobis qui dolorem enim quod sed.', 8),
(32, 'quibusdam', 'deserunt', 3381, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 38, 0, 'Necessitatibus nihil cumque ipsa quos.', 2),
(33, 'pariatur', 'aut', 3991, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 48, 1, 'Optio tempore sed in et.', 3),
(34, 'neque', 'nostrum', 4483, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 7, 0, 'Et odit et sed consequatur et.', 4),
(36, 'provident', 'autem', 7980, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 14, 1, 'Aut et deserunt cum vel quod.', 6),
(37, 'sunt', 'expedita', 4523, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 9, 1, 'Occaecati nisi odit doloribus corporis.', 7),
(38, 'dolor', 'consequatur', 3049, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 25, 0, 'Et ea repudiandae est et enim voluptatem odit.', 8),
(42, 'architecto', 'recusandae', 2678, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 44, 1, 'Labore omnis sequi dolorem.', 2),
(43, 'voluptatem', 'exercitationem', 6047, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 19, 0, 'Veritatis beatae sapiente aut voluptatum.', 3),
(44, 'culpa', 'harum', 8142, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 33, 1, 'Itaque ratione laudantium incidunt aliquid.', 4),
(46, 'qui', 'eaque', 6478, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 46, 1, 'Non nulla occaecati optio provident et.', 6),
(47, 'consequatur', 'ratione', 6937, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 32, 0, 'Sit et minima maxime neque ut qui et.', 7),
(48, 'id', 'totam', 7816, 0x2f34383665306634656165663237346636663831313738643931656636616338642e6a7067, 18, 0, 'Est tempore nobis aut ea sunt.', 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `berlet_vasarlas`
--
ALTER TABLE `berlet_vasarlas`
  ADD PRIMARY KEY (`Berlet_vasarlasID`);

--
-- Indexes for table `ceg`
--
ALTER TABLE `ceg`
  ADD PRIMARY KEY (`CegID`),
  ADD KEY `TartozkodasihelyID` (`TartozkodasihelyID`);

--
-- Indexes for table `felhasznalo`
--
ALTER TABLE `felhasznalo`
  ADD PRIMARY KEY (`FelhasznaloID`),
  ADD UNIQUE KEY `Felhasznalonev` (`Felhasznalonev`),
  ADD UNIQUE KEY `Felh_email` (`Felh_email`),
  ADD KEY `TartozkodasihelyID` (`TartozkodasihelyID`);

--
-- Indexes for table `felhasznaloszemelyiedzo`
--
ALTER TABLE `felhasznaloszemelyiedzo`
  ADD KEY `FelhasznaloID` (`FelhasznaloID`),
  ADD KEY `Szemelyi_edzoID` (`Szemelyi_edzoID`);

--
-- Indexes for table `rendeles`
--
ALTER TABLE `rendeles`
  ADD PRIMARY KEY (`RendelesID`),
  ADD KEY `TermekID` (`TermekID`),
  ADD KEY `Berlet_vasarlasID` (`Berlet_vasarlasID`),
  ADD KEY `FelhasznaloID` (`FelhasznaloID`);

--
-- Indexes for table `szemelyi_edzo`
--
ALTER TABLE `szemelyi_edzo`
  ADD PRIMARY KEY (`Szemelyi_edzoID`),
  ADD UNIQUE KEY `Szemedz_email` (`Szemedz_email`),
  ADD KEY `TartozkodasihelyID` (`TartozkodasihelyID`);

--
-- Indexes for table `tartozkodasihely`
--
ALTER TABLE `tartozkodasihely`
  ADD PRIMARY KEY (`TartozkodasihelyID`);

--
-- Indexes for table `termek`
--
ALTER TABLE `termek`
  ADD PRIMARY KEY (`TermekID`),
  ADD KEY `CegID` (`CegID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `berlet_vasarlas`
--
ALTER TABLE `berlet_vasarlas`
  MODIFY `Berlet_vasarlasID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `ceg`
--
ALTER TABLE `ceg`
  MODIFY `CegID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `felhasznalo`
--
ALTER TABLE `felhasznalo`
  MODIFY `FelhasznaloID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=89;

--
-- AUTO_INCREMENT for table `rendeles`
--
ALTER TABLE `rendeles`
  MODIFY `RendelesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `szemelyi_edzo`
--
ALTER TABLE `szemelyi_edzo`
  MODIFY `Szemelyi_edzoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `tartozkodasihely`
--
ALTER TABLE `tartozkodasihely`
  MODIFY `TartozkodasihelyID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `termek`
--
ALTER TABLE `termek`
  MODIFY `TermekID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ceg`
--
ALTER TABLE `ceg`
  ADD CONSTRAINT `ceg_ibfk_1` FOREIGN KEY (`TartozkodasihelyID`) REFERENCES `tartozkodasihely` (`TartozkodasihelyID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `felhasznalo`
--
ALTER TABLE `felhasznalo`
  ADD CONSTRAINT `felhasznalo_ibfk_1` FOREIGN KEY (`TartozkodasihelyID`) REFERENCES `tartozkodasihely` (`TartozkodasihelyID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `felhasznaloszemelyiedzo`
--
ALTER TABLE `felhasznaloszemelyiedzo`
  ADD CONSTRAINT `felhasznaloszemelyiedzo_ibfk_1` FOREIGN KEY (`Szemelyi_edzoID`) REFERENCES `szemelyi_edzo` (`Szemelyi_edzoID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `felhasznaloszemelyiedzo_ibfk_2` FOREIGN KEY (`FelhasznaloID`) REFERENCES `felhasznalo` (`FelhasznaloID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rendeles`
--
ALTER TABLE `rendeles`
  ADD CONSTRAINT `rendeles_ibfk_1` FOREIGN KEY (`Berlet_vasarlasID`) REFERENCES `berlet_vasarlas` (`Berlet_vasarlasID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rendeles_ibfk_2` FOREIGN KEY (`FelhasznaloID`) REFERENCES `felhasznalo` (`FelhasznaloID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rendeles_ibfk_3` FOREIGN KEY (`TermekID`) REFERENCES `termek` (`TermekID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `szemelyi_edzo`
--
ALTER TABLE `szemelyi_edzo`
  ADD CONSTRAINT `szemelyi_edzo_ibfk_1` FOREIGN KEY (`TartozkodasihelyID`) REFERENCES `tartozkodasihely` (`TartozkodasihelyID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `termek`
--
ALTER TABLE `termek`
  ADD CONSTRAINT `termek_ibfk_1` FOREIGN KEY (`CegID`) REFERENCES `ceg` (`CegID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
