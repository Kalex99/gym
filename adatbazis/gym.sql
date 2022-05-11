-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Ápr 30. 16:56
-- Kiszolgáló verziója: 10.4.18-MariaDB
-- PHP verzió: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `gym`
--
CREATE DATABASE IF NOT EXISTS `gym` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gym`;

DELIMITER $$
--
-- Eljárások
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasLetrehoz` (IN `berlet_tipus` VARCHAR(100), IN `berlet_ar` INT)  INSERT INTO berlet_vasarlas (berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar) VALUES (berlet_tipus,berlet_ar)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasModosit` (IN `berlet_vasarlasID` INT, IN `berlet_tipus` VARCHAR(100), IN `berlet_ar` INT)  UPDATE berlet_vasarlas SET berlet_vasarlas.Berlet_tipus=berlet_tipus, berlet_vasarlas.Berlet_ar=berlet_ar WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasOlvas` ()  SELECT * FROM berlet_vasarlas$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasOlvasByID` (IN `berlet_vasarlasID` INT, OUT `berlet_tipus` VARCHAR(100), OUT `berlet_ar` INT)  SELECT berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar FROM berlet_vasarlas WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Berlet_vasarlasTorles` (IN `berlet_vasarlasID` INT)  BEGIN
DELETE FROM berlet_vasarlas WHERE berlet_vasarlas.Berlet_vasarlasID=berlet_vasarlasID;
DELETE FROM rendeles WHERE rendeles.Berlet_vasarlasID=berlet_vasarlasID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloLetrehoz` (IN `felhasznalonev` VARCHAR(20), IN `jelszo` VARCHAR(64), IN `felh_vezeteknev` VARCHAR(50), IN `felh_keresztnev` VARCHAR(50), IN `felh_email` VARCHAR(200), IN `szuletesi_datum` DATE, IN `felh_telefon` VARCHAR(11))  MODIFIES SQL DATA
INSERT INTO felhasznalo (felhasznalo.Felhasznalonev, felhasznalo.Jelszo, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Szuletesi_datum, felhasznalo.Felh_telefon) VALUES (felhasznalonev,jelszo,felh_vezeteknev,felh_keresztnev, felh_email, szuletesi_datum, felh_telefon)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloModosit` (IN `felhasznaloID` INT, IN `felhasznalonev` VARCHAR(20), IN `jelszo` VARCHAR(64), IN `felh_vezeteknev` VARCHAR(50), IN `felh_keresztnev` VARCHAR(50), IN `felh_email` VARCHAR(200), IN `felh_telefon` VARCHAR(11))  UPDATE felhasznalo SET felhasznalo.Felhasznalonev=felhasznalonev, felhasznalo.Jelszo=jelszo, felhasznalo.Felh_vezeteknev=felh_vezeteknev, felhasznalo.Felh_keresztnev= felh_keresztnev, felhasznalo.Felh_email=felh_email, felhasznalo.Felh_telefon=felh_telefon WHERE felhasznalo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloOlvas` ()  SELECT * FROM felhasznalo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloOlvasByID` (IN `felhasznaloID` INT, OUT `felhasznalonev` VARCHAR(20), OUT `jelszo` VARCHAR(64), OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50), OUT `szuletesi_datum` DATE, OUT `felh_email` VARCHAR(200), OUT `felh_telefon` VARCHAR(11))  SELECT felhasznalo.Felhasznalonev, felhasznalo.Jelszo, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Szuletesi_datum, felhasznalo.Felh_telefon FROM felhasznalo WHERE felhasznalo.FelhasznaloID=felhasznaloID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FelhasznaloTorles` (IN `felhasznaloID` INT)  BEGIN
DELETE FROM rendeles WHERE rendeles.FelhasznaloID=felhasznaloID;
DELETE FROM felhasznalo WHERE felhasznalo.FelhasznaloID=felhasznaloID;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `KeszletCsokken` (IN `termekID` INT, IN `keszlet` INT)  UPDATE termek SET termek.Keszlet = termek.Keszlet-keszlet WHERE termek.TermekID = termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesLetrehozBerlet`(IN `berlet_vasarlasID` INT, IN `megjegyzes` TEXT, IN `felhasznaloID` INT)
INSERT INTO rendeles (rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.Berlet_lejar,rendeles.Berlet_vasarlasID, rendeles.TermekID, rendeles.FelhasznaloID) VALUES (now(), megjegyzes, date_add(now(),interval 30 day), berlet_vasarlasID, null, felhasznaloID)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesLetrehozTermek`(IN `termekID` INT, IN `megjegyzes` TEXT, IN `mennyiseg` SMALLINT(10), IN `felhasznaloID` INT)
INSERT INTO rendeles (rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.Berlet_vasarlasID, rendeles.TermekID, rendeles.Mennyiseg, rendeles.FelhasznaloID) VALUES (now(), megjegyzes, null, termekID, mennyiseg, felhasznaloID) ON DUPLICATE KEY UPDATE termek.Keszlet= termek.Keszlet-mennyiség$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvas` ()  SELECT * FROM rendeles$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasBerletByID` (IN `rendelesID` INT, OUT `berlet_vasarlasID` INT, OUT `berlet_tipus` VARCHAR(100), OUT `berlet_ar` INT)  SELECT berlet_vasarlas.Berlet_vasarlasID, berlet_vasarlas.Berlet_tipus, berlet_vasarlas.Berlet_ar FROM berlet_vasarlas INNER JOIN rendeles on berlet_vasarlas.Berlet_vasarlasID=rendeles.Berlet_vasarlasID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasByID` (IN `rendelesID` INT, OUT `rendeles_idopont` DATETIME, OUT `megjegyzes` TEXT, OUT `termekID` INT, OUT `berlet_vasarlasID` INT, OUT `felhasznaloID` INT)  SELECT rendeles.Rendeles_idopont, rendeles.Megjegyzes, rendeles.TermekID, rendeles.Berlet_vasarlasID, rendeles.FelhasznaloID FROM rendeles WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasFelhasznaloByID` (IN `rendelesID` INT, OUT `felhasznaloID` INT, OUT `felh_vezeteknev` VARCHAR(50), OUT `felh_keresztnev` VARCHAR(50), OUT `felh_email` VARCHAR(200), OUT `felh_telefon` VARCHAR(11), OUT `tartozkodasihelyID` INT)  SELECT felhasznalo.FelhasznaloID, felhasznalo.Felh_vezeteknev, felhasznalo.Felh_keresztnev, felhasznalo.Felh_email, felhasznalo.Felh_telefon, felhasznalo.TartozkodasihelyID FROM felhasznalo INNER JOIN rendeles on felhasznalo.FelhasznaloID=rendeles.FelhasznaloID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesOlvasTermekByID` (IN `rendelesID` INT, OUT `termekID` INT, OUT `termek_nev` VARCHAR(100), OUT `kategoria` VARCHAR(50), OUT `ar` INT, OUT `kep` BLOB, OUT `leiras` TEXT, OUT `cegID` INT)  SELECT termek.TermekID, termek.Termek_nev, termek.Kategoria, termek.Ar, termek.Kep, termek.Leiras, termek.CegID FROM termek INNER JOIN rendeles ON termek.TermekID= rendeles.TermekID WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `RendelesTorles` (IN `rendelesID` INT)  DELETE FROM rendeles WHERE rendeles.RendelesID=rendelesID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoLetrehoz` (IN `szemedz_vezeteknev` VARCHAR(50), IN `szemedz_keresztnev` VARCHAR(50), IN `szemedz_email` VARCHAR(200), IN `szemedz_telefon` VARCHAR(11))  INSERT INTO szemelyi_edzo (szemelyi_edzo.Szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev, szemelyi_edzo.Szemedz_email, szemelyi_edzo.Szemedz_telefon) VALUES (szemedz_vezeteknev, szemedz_keresztnev, szemedz_email, szemedz_telefon)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoModosit` (IN `szemelyi_edzoID` INT, IN `szemedz_vezeteknev` VARCHAR(50), IN `szemedz_keresztnev` VARCHAR(50),IN `szemedz_email` VARCHAR(200), IN `szemedz_telefon` VARCHAR(11))  UPDATE szemelyi_edzo SET szemelyi_edzo.Szemedz_vezeteknev=szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev=szemedz_keresztnev, szemelyi_edzo.Szemedz_email=szemedz_email, szemelyi_edzo.Szemedz_telefon=szemedz_telefon WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoOlvas` ()  SELECT * FROM szemelyi_edzo$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoOlvasByID` (IN `szemelyi_edzoID` INT, OUT `szemedz_vezeteknev` VARCHAR(50), OUT `szemedz_keresztnev` VARCHAR(50), OUT `szemedz_email` VARCHAR(200), OUT `szemedz_telefon` VARCHAR(11))  SELECT szemelyi_edzo.Szemedz_vezeteknev, szemelyi_edzo.Szemedz_keresztnev, szemelyi_edzo.Szemedz_email, szemelyi_edzo.Szemedz_telefon FROM szemelyi_edzo WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Szemelyi_edzoTorles` (IN `szemelyi_edzoID` INT)  DELETE FROM szemelyi_edzo WHERE szemelyi_edzo.Szemelyi_edzoID=szemelyi_edzoID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekLetrehoz` (IN `termek_nev` VARCHAR(100), IN `ar` INT, IN `keszlet` INT, IN `leiras` TEXT)  INSERT INTO termek (termek.Termek_nev, termek.Ar, termek.Keszlet, termek.Kaphato, termek.Leiras) VALUES (termek_nev,ar,keszlet,1,leiras)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekModosit` (IN `termekID` INT, IN `termek_nev` VARCHAR(100), IN `ar` INT, IN `keszlet` INT, IN `kaphato` BOOLEAN, IN `leiras` TEXT)  UPDATE termek SET termek.Termek_nev=termek_nev, termek.Ar=ar, termek.Keszlet=keszlet, termek.Kaphato=kaphato, termek.Leiras=leiras WHERE termek.TermekID=termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekOlvas` ()  SELECT * FROM termek$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekOlvasByID` (IN `termekID` INT, OUT `termek_nev` VARCHAR(100), OUT `ar` INT, OUT `keszlet` INT, OUT `kaphato` BOOLEAN, OUT `leiras` TEXT)  SELECT termek.Termek_nev, termek.Ar, termek.Keszlet, termek.Kaphato, termek.Leiras FROM termek WHERE termek.TermekID=termekID$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TermekTorles` (IN `termekID` INT)  BEGIN
DELETE FROM termek WHERE termek.TermekID=termekID;
DELETE FROM rendeles WHERE rendeles.TermekID=termekID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `berlet_vasarlas`
--

CREATE TABLE `berlet_vasarlas` (
  `Berlet_vasarlasID` int(11) NOT NULL,
  `Berlet_tipus` varchar(100) NOT NULL,
  `Berlet_ar` int(11) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `berlet_vasarlas`
--

INSERT INTO `berlet_vasarlas` (`Berlet_vasarlasID`, `Berlet_tipus`, `Berlet_ar`) VALUES
(1, 'Diák', 4000),
(2, 'Felnőtt', 5000),
(3, 'Nyugdíjas', 4500),
(4, 'Csecsemő', 500);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `felhasznalo`
--

CREATE TABLE `felhasznalo` (
  `FelhasznaloID` int(11) NOT NULL,
  `Felhasznalonev` varchar(20) NOT NULL,
  `Jelszo` varchar(64) NOT NULL,
  `Felh_vezeteknev` varchar(50) NOT NULL,
  `Felh_keresztnev` varchar(50) NOT NULL,
  `Felh_email` varchar(200) NOT NULL,
  `Szuletesi_datum` date NOT NULL,
  `Felh_telefon` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `felhasznalo`
--

INSERT INTO `felhasznalo` (`FelhasznaloID`, `Felhasznalonev`, `Jelszo`, `Felh_vezeteknev`, `Felh_keresztnev`, `Felh_email`, `Szuletesi_datum`, `Felh_telefon`) VALUES
(7, 'debitis', 'numquam', 'Shanahan', 'Antonia', 'tkertzmann@example.org', '2004-07-01', '594.622.728'),
(8, 'sit', 'expedita', 'McCullough', 'Kaylin', 'mcclure.irving@example.net', '1987-01-22', '+32(4)42101'),
(11, 'et', 'delectus', 'Hayes', 'Lelia', 'faustino31@example.org', '1987-07-22', '357.039.141'),
(12, 'dolore', 'dignissimos', 'Padberg', 'Bobbie', 'irwin.nienow@example.org', '1976-04-25', '082.402.384'),
(13, 'omnis', 'velit', 'Kilback', 'Everette', 'garett.predovic@example.org', '2010-03-29', '1-800-406-3'),
(14, 'sunt', 'dolore', 'Witting', 'Misael', 'carmela.hills@example.com', '1987-03-08', '1-254-636-1'),
(15, 'doloremque', 'culpa', 'Brakus', 'Samson', 'talon.beatty@example.net', '2010-07-11', '(540)376-46'),
(16, 'quibusdam', 'nam', 'Aufderhar', 'Chloe', 'montana.bins@example.net', '2001-05-01', '061-156-882'),
(17, 'architecto', 'culpa', 'Farrell', 'Alia', 'braden41@example.com', '2021-06-01', '577.475.860'),
(18, 'placeat', 'asperiores', 'Cassin', 'Orpha', 'batz.destany@example.com', '1976-07-25', '+61(9)97986'),
(19, 'totam', 'veritatis', 'Brekke', 'Georgette', 'jjacobi@example.org', '1979-03-02', '738.219.471'),
(20, 'non', 'qui', 'Wunsch', 'Shanelle', 'bboyer@example.com', '1972-11-04', '(609)891-83'),
(21, 'dignissimos', 'enim', 'Casper', 'Donato', 'bernhard.maggio@example.org', '2017-04-24', '1-058-403-8'),
(22, 'laborum', 'doloremque', 'Bashirian', 'Ellie', 'jevon48@example.org', '1982-07-16', '419-660-804'),
(23, 'quo', 'quae', 'Schaefer', 'Arjun', 'nakia.predovic@example.com', '2010-01-13', '(013)559-55'),
(24, 'dolor', 'non', 'Schmitt', 'Hortense', 'vhessel@example.org', '1979-03-25', '805.601.985'),
(25, 'quis', 'sed', 'Goodwin', 'Chanelle', 'antonetta13@example.org', '1987-05-06', '199-630-283'),
(26, 'a', 'in', 'Ward', 'Camden', 'deon94@example.net', '1991-04-29', '257-154-191'),
(27, 'repellendus', 'modi', 'Lebsack', 'Chanel', 'bayer.scarlett@example.org', '2002-06-24', '09446491286'),
(31, 'beatae', 'id', 'Quigley', 'Willy', 'dbartell@example.com', '2006-02-27', '136.161.965'),
(32, 'tempora', 'ut', 'Lebsack', 'Lemuel', 'schroeder.trenton@example.org', '1975-06-02', '(143)815-59'),
(33, 'illum', 'quam', 'Spinka', 'Maymie', 'lhowell@example.org', '2010-12-12', '1-876-891-3'),
(34, 'saepe', 'quia', 'McDermott', 'Kailey', 'kilback.travon@example.com', '1985-09-18', '242-734-259'),
(35, 'vitae', 'molestias', 'West', 'Augustus', 'xkertzmann@example.net', '1972-07-17', '1-934-773-7'),
(36, 'itaque', 'ullam', 'Heidenreich', 'döbrögi', 'torp.felix@example.net', '1971-06-07', '065-393-904'),
(37, 'delectus', 'cupiditate', 'Gerhold', 'Lucious', 'reichel.cassandra@example.org', '2014-01-22', '932-459-244'),
(38, 'minima', 'inventore', 'Hegmann', 'Shaina', 'blanca.vandervort@example.com', '1999-09-12', '(801)023-33'),
(39, 'quidem', 'fugiat', 'Dooley', 'Bertrand', 'fkreiger@example.org', '2012-04-02', '029.773.771'),
(41, 'ullam', 'reiciendis', 'Waelchi', 'Jadon', 'swift.janiya@example.net', '1991-11-04', '851.646.096'),
(42, 'voluptatem', 'aut', 'Muller', 'Vilma', 'zcummerata@example.org', '1979-06-18', '(367)763-02'),
(43, 'inventore', 'rerum', 'Brekke', 'Enrico', 'ethyl33@example.com', '1983-12-25', '1-311-981-5'),
(44, 'repudiandae', 'perspiciatis', 'Labadie', 'Ada', 'kian80@example.net', '1999-10-16', '(810)738-85'),
(45, 'in', 'dolorum', 'Gleichner', 'Tess', 'jennings09@example.net', '1998-09-26', '550.417.481'),
(46, 'animi', 'est', 'Batz', 'Daphne', 'bergnaum.zackery@example.org', '2017-08-02', '556-211-250'),
(47, 'sapiente', 'exercitationem', 'Heidenreich', 'Oscar', 'gabe.gorczany@example.net', '1979-06-19', '136.889.507'),
(48, 'unde', 'et', 'Murphy', 'Kaci', 'zkirlin@example.org', '2009-09-02', '920.441.568'),
(49, 'accusantium', 'provident', 'Jenkins', 'Jeremy', 'johnston.howard@example.com', '1989-12-05', '989-593-316'),
(102, 'alma', 'quia', 'Sanya', 'Macska', 'anr@anoth.com', '1999-07-12', '06205879168');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `rendeles`
--

CREATE TABLE `rendeles` (
  `RendelesID` int(11) NOT NULL,
  `Rendeles_idopont` datetime NOT NULL,
  `Megjegyzes` text DEFAULT NULL,
  `Mennyiseg` SMALLINT(10) DEFAULT NULL,
  `Berlet_lejar` DATE DEFAULT NULL,
  `TermekID` int(11) DEFAULT NULL,
  `Berlet_vasarlasID` int(11) DEFAULT NULL,
  `FelhasznaloID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `rendeles`
--

INSERT INTO `rendeles` (`RendelesID`, `Rendeles_idopont`, `Megjegyzes`, `Mennyiseg`, `Berlet_lejar` , `TermekID`, `Berlet_vasarlasID`, `FelhasznaloID`) VALUES
(7, '1977-01-03 15:18:40', 'Ut natus molestiae.', 7, '1977-01-03', 7, 2, 7),
(8, '1976-07-19 08:46:19', 'Repellat possimus.', 7, '1977-01-03', 8, 3, 8),
(12, '1995-05-27 21:50:17', 'Eos voluptate.', 7, '1977-01-03', 12, 2, 12),
(13, '1986-09-09 18:33:42', 'Ex suscipit quia.', 7, '1977-01-03', 13, 3, 13),
(14, '1991-01-29 19:23:58', 'Commodi architecto.', 7, '1977-01-03', 14, 4, 14),
(16, '1980-04-20 14:01:34', 'Nulla non pariatur.', 7, '1977-01-03',16, 1, 16),
(17, '1986-12-15 22:49:23', 'Amet occaecati ipsa.', 7, '1977-01-03',17, 2, 17),
(18, '2010-05-13 18:15:32', 'Et quod architecto.', 7, '1977-01-03', 18, 3, 18),
(22, '1984-05-24 04:38:03', 'Nobis et porro.', 7, '1977-01-03', 22, 2, 22),
(23, '2007-04-18 05:00:29', 'Aut aliquid non.', 7, '1977-01-03',23, 3, 23),
(24, '1982-05-01 12:27:35', 'Neque perferendis.', 7, '1977-01-03', 24, 4, 24),
(26, '1999-08-11 06:42:09', 'Corporis omnis.', 7, '1977-01-03', 26, 1, 26),
(27, '1994-10-15 10:17:31', 'Consequatur quis.', 7, '1977-01-03', 27, 2, 27),
(32, '2004-07-25 09:45:45', 'Ea soluta ex quo.', 7, '1977-01-03', 32, 2, 32),
(33, '2007-03-29 01:17:37', 'Aut hic asperiores.', 7, '1977-01-03', 33, 3, 33),
(34, '1986-09-16 04:57:21', 'Neque iusto sequi.', 7, '1977-01-03', 34, 4, 34),
(36, '2010-02-11 04:24:32', 'Quasi voluptas.', 7, '1977-01-03', 36, 1, 36),
(37, '1991-01-29 13:44:41', 'Iure eligendi.', 7, '1977-01-03', 37, 2, 37),
(38, '1970-12-19 08:03:26', 'Ea veniam.', 7, '1977-01-03', 38, 3, 38),
(42, '2015-01-22 23:26:09', 'Eligendi cumque sit.', 7, '1977-01-03', 42, 2, 42),
(43, '2016-02-07 00:53:52', 'Exercitationem.', 7, '1977-01-03', 43, 3, 43),
(44, '1992-12-28 14:15:35', 'Nam repellendus.', 7, '1977-01-03', 44, 4, 44),
(46, '1987-06-21 05:59:19', 'Ut sint officia qui.', 7, '1977-01-03', 46, 1, 46),
(47, '1997-09-17 05:47:24', 'Maiores saepe et.', 7, '1977-01-03', 47, 2, 47),
(48, '1984-06-08 21:51:24', 'Tempora sed dolorem.', 7, '1977-01-03', 48, 3, 48);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `szemelyi_edzo`
--

CREATE TABLE `szemelyi_edzo` (
  `Szemelyi_edzoID` int(11) NOT NULL,
  `Szemedz_vezeteknev` varchar(50) NOT NULL,
  `Szemedz_keresztnev` varchar(50) NOT NULL,
  `Szemedz_email` varchar(200) NOT NULL,
  `Szemedz_telefon` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `szemelyi_edzo`
--

INSERT INTO `szemelyi_edzo` (`Szemelyi_edzoID`, `Szemedz_vezeteknev`, `Szemedz_keresztnev`, `Szemedz_email`, `Szemedz_telefon`) VALUES
(2, 'Master', 'Chief', 'matilda62@example.org', '028-844-782'),
(3, 'Doom', 'Slayer', 'solon.blick@example.org', '(976)124-39'),
(4, 'Kratos', 'God', 'ceasar.erdman@example.net', '837.326.349'),
(6, 'Badlands', 'Chugs', 'kellen77@example.com', '1-112-735-1');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `termek`
--

CREATE TABLE `termek` (
  `TermekID` int(11) NOT NULL,
  `Termek_nev` varchar(100) NOT NULL,
  `Ar` int(11) UNSIGNED NOT NULL,
  `Keszlet` int(11) UNSIGNED NOT NULL,
  `Kaphato` tinyint(1) NOT NULL,
  `Leiras` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `termek`
--

INSERT INTO `termek` (`TermekID`, `Termek_nev`, `Ar`, `Keszlet`, `Kaphato`, `Leiras`) VALUES
(2, 'necessitatibus', 6527, 30, 1, 'Corporis sit voluptatem quasi ab non.'),
(3, 'mollitia', 9777, 37, 1, 'Earum quia non consequuntur ullam aspernatur.'),
(4, 'molestias', 6613, 21, 1, 'Neque laudantium fugit porro accusamus.'),
(6, 'est', 7178, 0, 0, 'Delectus voluptatem nobis possimus enim.'),
(7, 'non', 3570, 41, 1, 'Omnis sint sint nobis quia.'),
(8, 'placeat', 3240, 17, 1, 'Dolores libero eum sit aut sed earum nulla.'),
(12, 'animi', 3963, 46, 1, 'Aliquam quae voluptatem quia autem ea.'),
(13, 'nam', 6655, 0, 1, 'Praesentium beatae voluptas ut ducimus explicabo.'),
(14, 'quae', 5132, 18, 1, 'Ipsam ad omnis sunt nam.'),
(16, 'autem', 8914, 3, 0, 'Dolorum qui eum aut non exercitationem iste iste.'),
(17, 'dolor', 9051, 14, 1, 'Ea eum unde et aperiam architecto.'),
(18, 'eos', 9172, 36, 0, 'Sunt architecto neque architecto.'),
(22, 'similique', 3350, 7, 1, 'Sequi sit neque rem pariatur rerum consequatur.'),
(23, 'officiis', 8860, 18, 1, 'At sint tenetur ex itaque earum odit.'),
(24, 'maxime', 5642, 0, 1, 'Numquam aut corporis tenetur possimus voluptates.'),
(26, 'expedita', 3036, 16, 0, 'Nisi et voluptatum aut.'),
(27, 'quasi', 4786, 15, 1, 'Accusamus aut repellendus alias nostrum.'),
(28, 'consequuntur', 3631, 8, 0, 'Facere eum nobis qui dolorem enim quod sed.'),
(32, 'quibusdam', 3381, 38, 0, 'Necessitatibus nihil cumque ipsa quos.'),
(33, 'pariatur', 3991, 48, 1, 'Optio tempore sed in et.'),
(34, 'neque', 4483, 7, 0, 'Et odit et sed consequatur et.'),
(36, 'provident', 7980, 14, 1, 'Aut et deserunt cum vel quod.'),
(37, 'sunt', 4523, 9, 1, 'Occaecati nisi odit doloribus corporis.'),
(38, 'dolor', 3049, 25, 0, 'Et ea repudiandae est et enim voluptatem odit.'),
(42, 'architecto', 2678, 44, 1, 'Labore omnis sequi dolorem.'),
(43, 'voluptatem', 6047, 19, 0, 'Veritatis beatae sapiente aut voluptatum.'),
(44, 'culpa', 8142, 33, 1, 'Itaque ratione laudantium incidunt aliquid.'),
(46, 'qui', 6478, 46, 1, 'Non nulla occaecati optio provident et.'),
(47, 'consequatur', 6937, 32, 0, 'Sit et minima maxime neque ut qui et.'),
(48, 'id', 7816, 18, 0, 'Est tempore nobis aut ea sunt.'),
(52, 'dc', 1, 23, 1, 'fg');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `berlet_vasarlas`
--
ALTER TABLE `berlet_vasarlas`
  ADD PRIMARY KEY (`Berlet_vasarlasID`);

--
-- A tábla indexei `felhasznalo`
--
ALTER TABLE `felhasznalo`
  ADD PRIMARY KEY (`FelhasznaloID`),
  ADD UNIQUE KEY `Felhasznalonev` (`Felhasznalonev`),
  ADD UNIQUE KEY `Felh_email` (`Felh_email`);

--
-- A tábla indexei `rendeles`
--
ALTER TABLE `rendeles`
  ADD PRIMARY KEY (`RendelesID`),
  ADD KEY `TermekID` (`TermekID`),
  ADD KEY `Berlet_vasarlasID` (`Berlet_vasarlasID`),
  ADD KEY `FelhasznaloID` (`FelhasznaloID`);

--
-- A tábla indexei `szemelyi_edzo`
--
ALTER TABLE `szemelyi_edzo`
  ADD PRIMARY KEY (`Szemelyi_edzoID`),
  ADD UNIQUE KEY `Szemedz_email` (`Szemedz_email`);

--
-- A tábla indexei `termek`
--
ALTER TABLE `termek`
  ADD PRIMARY KEY (`TermekID`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `berlet_vasarlas`
--
ALTER TABLE `berlet_vasarlas`
  MODIFY `Berlet_vasarlasID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `felhasznalo`
--
ALTER TABLE `felhasznalo`
  MODIFY `FelhasznaloID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT a táblához `rendeles`
--
ALTER TABLE `rendeles`
  MODIFY `RendelesID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT a táblához `szemelyi_edzo`
--
ALTER TABLE `szemelyi_edzo`
  MODIFY `Szemelyi_edzoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `termek`
--
ALTER TABLE `termek`
  MODIFY `TermekID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `rendeles`
--
ALTER TABLE `rendeles`
  ADD CONSTRAINT `rendeles_ibfk_1` FOREIGN KEY (`Berlet_vasarlasID`) REFERENCES `berlet_vasarlas` (`Berlet_vasarlasID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rendeles_ibfk_2` FOREIGN KEY (`FelhasznaloID`) REFERENCES `felhasznalo` (`FelhasznaloID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rendeles_ibfk_3` FOREIGN KEY (`TermekID`) REFERENCES `termek` (`TermekID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
