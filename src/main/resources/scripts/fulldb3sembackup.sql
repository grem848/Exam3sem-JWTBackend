-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: seed
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CITYINFO`
--

DROP TABLE IF EXISTS `CITYINFO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CITYINFO` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(255) DEFAULT NULL,
  `ZIPCODE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITYINFO`
--

LOCK TABLES `CITYINFO` WRITE;
/*!40000 ALTER TABLE `CITYINFO` DISABLE KEYS */;
INSERT INTO `CITYINFO` VALUES (1,'Helsingør',3000),(2,'Kgs. Lyngby',2800),(3,'Charlottenlund',2920),(4,'Gentofte',2820),(5,'Herlev',2730),(6,'København N',2200);
/*!40000 ALTER TABLE `CITYINFO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RESTAURANT`
--

DROP TABLE IF EXISTS `RESTAURANT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RESTAURANT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `FOODTYPE` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  `CITYINFO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_RESTAURANT_CITYINFO_ID` (`CITYINFO_ID`),
  CONSTRAINT `FK_RESTAURANT_CITYINFO_ID` FOREIGN KEY (`CITYINFO_ID`) REFERENCES `CITYINFO` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESTAURANT`
--

LOCK TABLES `RESTAURANT` WRITE;
/*!40000 ALTER TABLE `RESTAURANT` DISABLE KEYS */;
INSERT INTO `RESTAURANT` VALUES (1,'Baunehøjvej 24','Italian, American','Miss Pizza','45873585','https://www.misspizza.dk/',2),(2,'Egegårdsvej 1','Italian','Il mondo Pizzaria','45886693','https://www.il-mondo-pizza.dk/',2),(3,'Lyngbygårdsvej 100','Italian','Edas Pizzaria & BurgerHouse','45875754','https://www.edaspizza.dk/',2),(4,'Gammelmosevej 121','Italian, Sandwich & Bagels','Madhuset Pizza & Sandwich','65790763','https://www.madhuset2800.dk/',2),(14,'Lyngby Hovedgade 43','Sushi, Premium & Gourmet','Sticks\'n\'Sushi Lyngby','45470034','https://sticksnsushi.com/da/restauranter/koebenhavn/lyngby',2),(15,'Lundtofteparken 65','Smørrebrød, Danish','Parkens Smørrebrød & Catering','32675889','http://www.parkenssmoerrebroed.dk/',2),(16,'Lyngby Storcenter 1','Vietnamese, Premium & Gourmet','LêLê Street Kitchen Lyngby','70277030','https://takeout.dk/restaurant/lele-street-kitchen-lyngby',2),(17,'Klampenborgvej 215','Sandwich & Bagels, Burger','Sunset Boulevard Lyngby','75453266','https://www.sunset-boulevard.dk/restauranter/lyngby',3),(18,'Jernbanepladsen 61','Pizza, American','Domino\'s Lyngby','33123456','https://www.dominos.dk/',3),(19,'Ordrupvej 102','Pizza, Burger','Pizzeria Costa Italiana - Ægte Stenovn','39400030','https://www.costaitaliana.dk/ ',3),(20,'Gefionsvej 45','Italian, American','Mamma Rosa','4093586','https://www.mammarosapizza.dk/',1),(21,'Ny Kronborgvej 2','Indian','Varnada','49200201','http://vaerftetsmadmarked.dk/services/',1),(22,'Stengade 39','Grill','Rib House - Helsingør','49200300','http://ribhouse.dk',1),(23,'Gefionsvej 46','American, Danish','Madonna Burgerbar','1155945',NULL,1),(24,'Rosenkildevej 14A','Italian, Mexican','Napoli Pizza & Grill','4922646','https://www.napolipizzeria.dk/',1),(25,'Ny Kronborgvej 2','Japanese, Vegetarian','Suki Ramen','2864839','https://www.facebook.com/vaerftetsstreetfood/',1),(26,'Hovedvagtsstræde 2B','Libanese, Turkish','Mamma Mira','9560934','http://www.mamma-mia-3000.dk/',1),(27,'Kampergade 1A','Thai, Vegetarian','Restaurant Ø','7323324','https://restauranto.dk/ ',1),(28,'Bramstræde 1','Chinese','Kinesisk Restaurant Hai Yi','9999651','https://www.haiyi.dk/',1),(29,'Bjergegade 18 A','Indian','Taj Mahal','60034689','http://www.taj-mahal-3000.dk/',1),(30,'Fenrisvej 27','Japanese, Vegetarian','Wa Se Fu Ku Sushi','51675746','http://www.wasefuku-sushi.dk/',1),(31,'Vangede Bygade 88','Italian, Danish','Mezzaluna','34609815','http://mezzaluna-gentofte.dk/?gclid=Cj0KCQiA_s7fBRDrARIsAGEvF8Spb2YaqexDW9T3WB6V5hsEP3qpJtkOhOQC9sONXRhIC1D8R06sg1AaAiJFEALw_wcB',4),(32,'Vangede Bygade 2','Italian, Pizza','Pizzamed','39650212','https://pizzamed.dk/',4),(33,'Herlev bygade 2','Italian','Torino Pizza & Grill','4917474','https://torinoherlev.dk/',5),(34,'Borgerdiget 145','Italian','Hjortens Pizzaria & café','44920073','http://hjortenspizzaria.dk',5),(35,'Herlev Torv 2','American','The Burger - Herlev','44843934','http://theburger.dk/',5),(36,'Herlev Hovedgade 105','American','Sandwich & Bagels','88134147','https://sandwichandbagel.dk/',5),(37,'Herlev hovedgade 55','American','Max Premium Burgers','79304343','https://www.max.dk/store-locator/Find-max/Herlev/',5),(38,'Herlev Hovedgade 129','Italian, Danish','Farfar\'s Mad & Burger House','44920466','https://www.farfarspizza.dk/',5),(39,'Mørkhøjvej 131','Indian','Italiensk, Dansk','29169475','http://www.tasteofcurry2730.dk/',5),(40,'Herlev bygade 34','Indian','Pippali indian grill','44929999','http://pippali.dk/',5),(41,'Herlev bygade 27','Japanese','Suki sushi','44887676','http://www.sukisushi.dk/',5),(42,'Jagtvej 101','Thai','WokAmok','33291793','https://www.wokamok2200.dk/',6),(43,'Blågårdsgade 35','Japanese','Poporoya','17506789',NULL,6),(44,'Jagtvej 102','Japanese','Kuma','31375101','https://www.kumacopenhagen.com/',6),(45,'Fredensgade 19','Danish','Kokken i kælderen','81599094','www.kokkenikælderen.dk',6),(46,'Jagtvej 109','Libanese','Manakish Al-Wadi','35818160',NULL,6),(47,'stefansgade 1','Italian','Pronto pizzaria','35828481','https://pronto-italiana.dk/',6),(48,'Blågårdsgade 1','Mexican','Blue taco','32218000','http://www.bluetaco.dk/',6),(49,'Fælledvej 6','Italian, Indian','Ashiq\'s Place','36906150','http://ashiqs.dk/',6),(50,'Nørrebrogade 59','American, Premium & Gourmet','Hooked','30705922','https://www.gethooked.dk/',6);
/*!40000 ALTER TABLE `RESTAURANT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `role_name` varchar(20) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  PRIMARY KEY (`role_name`,`user_name`),
  KEY `FK_user_roles_user_name` (`user_name`),
  CONSTRAINT `FK_user_roles_role_name` FOREIGN KEY (`role_name`) REFERENCES `roles` (`role_name`),
  CONSTRAINT `FK_user_roles_user_name` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('admin','admin');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_name` varchar(25) NOT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','$2a$10$M7ezJnKz.Kn2bzBV9PfpWe4yZhcHVFpuxtZEvhqak75gm61cXN8W.');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'seed'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-23 12:21:30
