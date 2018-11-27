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
  `ZIPCODE` int(11) NOT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ZIPCODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CITYINFO`
--

LOCK TABLES `CITYINFO` WRITE;
/*!40000 ALTER TABLE `CITYINFO` DISABLE KEYS */;
INSERT INTO `CITYINFO` VALUES (2200,'København N'),(2730,'Herlev'),(2800,'Kgs. Lyngby'),(2820,'Gentofte'),(2920,'Charlottenlund'),(3000,'Helsingør');
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
  `FOODTYPE` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `PICTUREURL` varchar(255) DEFAULT NULL,
  `RESTNAME` varchar(255) DEFAULT NULL,
  `STREET` varchar(255) DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  `CITYINFO_ZIPCODE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_RESTAURANT_CITYINFO_ZIPCODE` (`CITYINFO_ZIPCODE`),
  CONSTRAINT `FK_RESTAURANT_CITYINFO_ZIPCODE` FOREIGN KEY (`CITYINFO_ZIPCODE`) REFERENCES `CITYINFO` (`ZIPCODE`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESTAURANT`
--

LOCK TABLES `RESTAURANT` WRITE;
/*!40000 ALTER TABLE `RESTAURANT` DISABLE KEYS */;
INSERT INTO `RESTAURANT` VALUES (1,'Italian, American','45873585',NULL,'Miss Pizza','Baunehøjvej 24','https://www.misspizza.dk/',2800),(2,'Italian','45886693',NULL,'il mondo Pizzeria','Egegårdsvej 1','https://www.il-mondo-pizza.dk/',2800),(3,'Italian','45875754',NULL,'Eda Pizzaria og BurgerHouse','Lyngbygårdsvej 100','https://www.edaspizza.dk/',2800),(23,'Italian, Sandwich & Bagels','65790763',NULL,'Madhuset Pizza & Sandwich','Gammelmosevej 121','https://www.madhuset2800.dk/',2800),(24,'Sushi, Premium & Gourmet','45470034',NULL,'Sticks\'n\'Sushi Lyngby','Lyngby Hovedgade 43','https://sticksnsushi.com/da/restauranter/koebenhavn/lyngby',2800),(25,'Smørrebrød, Danish','32675889',NULL,'Parkens Smørrebrød & Catering','Lundtofteparken 65','http://www.parkenssmoerrebroed.dk/',2800),(26,'Vietnamese, Premium & Gourmet','70277030',NULL,'LêLê Street Kitchen Lyngby','Lyngby Storcenter 1','https://takeout.dk/restaurant/lele-street-kitchen-lyngby',2800),(27,'Sandwich & Bagels, Burger','75453266',NULL,'Sunset Boulevard Lyngby','Klampenborgvej 215','https://www.sunset-boulevard.dk/restauranter/lyngby',2800),(28,'Pizza, American','33123456',NULL,'Domino\'s Lyngby','Jernbanepladsen 61','https://www.dominos.dk/',2800),(29,'Pizza, Burger','39400030',NULL,'Pizzeria Costa Italiana - Ægte Stenovn','Ordrupvej 102','https://www.costaitaliana.dk/ ',2920),(30,'Italian, American','4093586',NULL,'Mamma Rosa','Gefionsvej 45','https://www.mammarosapizza.dk/',3000),(31,'Indian','49200201',NULL,'Varnada','Ny Kronborgvej 2','http://vaerftetsmadmarked.dk/services/',3000),(32,'Grill','49200300',NULL,'Rib House - Helsingør','Stengade 39','http://ribhouse.dk',3000),(33,'American, Danish','1155945',NULL,'Madonna Burgerbar','Gefionsvej 46',NULL,3000),(34,'Italian, Mexican','4922646',NULL,'Napoli Pizza & Grill','Rosenkildevej 14A','https://www.napolipizzeria.dk/',3000),(35,'Japanese, Vegetarian','2864839',NULL,'Suki Ramen','Ny Kronborgvej 2','https://www.facebook.com/vaerftetsstreetfood/',3000),(36,'Lebanese, Turkish','9560934',NULL,'Mamma Mira','Hovedvagtsstræde 2B','http://www.mamma-mia-3000.dk/',3000),(37,'Thai, Vegetarian','7323324',NULL,'Restaurant Ø','Kampergade 1A','https://restauranto.dk/ ',3000),(38,'Chinese','9999651',NULL,'Kinesisk Restaurant Hai Yi','Bramstræde 1','https://www.haiyi.dk/',3000),(39,'Indian','60034689',NULL,'Taj Mahal','Bjergegade 18 A','http://www.taj-mahal-3000.dk/',3000),(40,'Japanese, Vegetarian','51675746',NULL,'Wa Se Fu Ku Sushi','Fenrisvej 27','http://www.wasefuku-sushi.dk/',3000),(41,'Italian, Danish','34609815',NULL,'Mezzaluna','Vangede Bygade 88','http://mezzaluna-gentofte.dk/?gclid=Cj0KCQiA_s7fBRDrARIsAGEvF8Spb2YaqexDW9T3WB6V5hsEP3qpJtkOhOQC9sONXRhIC1D8R06sg1AaAiJFEALw_wcB',2820),(42,'Italian, Pizza','39650212',NULL,'Pizzamed','Vangede Bygade 2','https://pizzamed.dk/',2820),(43,'Italian','4917474',NULL,'Torino Pizza & Grill','Herlev bygade 2','https://torinoherlev.dk/',2730),(44,'Italian','44920073',NULL,'Hjortens Pizzaria & café','Borgerdiget 145','http://hjortenspizzaria.dk',2730),(45,'American','44843934',NULL,'The Burger - Herlev','Herlev Torv 2','http://theburger.dk/',2730),(46,'American','88134147',NULL,'Sandwich & Bagels','Herlev Hovedgade 105','https://sandwichandbagel.dk/',2730),(47,'American','79304343',NULL,'Max Premium Burgers','Herlev hovedgade 55','https://www.max.dk/store-locator/Find-max/Herlev/',2730),(48,'Italian, Danish','44920466',NULL,'Farfar\'s Mad & Burger House','Herlev Hovedgade 129','https://www.farfarspizza.dk/',2730),(49,'Indian','29169475',NULL,'Taste of curry','Mørkhøjvej 131','http://www.tasteofcurry2730.dk/',2730),(50,'Indian','44929999',NULL,'Pippali indian grill','Herlev bygade 34','http://pippali.dk/',2730),(51,'Japanese, Vegetarian','44887676',NULL,'Suki sushi','Herlev bygade 27','http://www.sukisushi.dk/',2730),(62,'Thai','33291793',NULL,'WokAmok','Jagtvej 101','https://www.wokamok2200.dk/',2200),(63,'Thai','50120888',NULL,'Momo wok box','Frederiksberggade 15','https://momowokbox.dk/',2200),(64,'Japanese','17506789',NULL,'Poporoya','Blågårdsgade 35',NULL,2200),(65,'Japanese','31375101',NULL,'Kuma','Jagtvej 102','https://www.kumacopenhagen.com/',2200),(66,'Danish','81599094',NULL,'Kokken i kælderen','Fredensgade 19','www.kokkenikælderen.dk',2200),(67,'Lebanese','35818160',NULL,'Manakish Al-Wadi','Jagtvej 109',NULL,2200),(68,'Italian','35828481',NULL,'Pronto pizzaria','stefansgade 1','https://pronto-italiana.dk/',2200),(69,'Mexican','32218000',NULL,'Blue taco','Blågårdsgade 1','http://www.bluetaco.dk/',2200),(70,'Italian, Indian','36906150',NULL,'Ashiq\'s Place','Fælledvej 6','http://ashiqs.dk/',2200),(71,'American, Premium & Gourmet','30705922',NULL,'Hooked','Nørrebrogade 59','https://www.gethooked.dk/',2200);
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

-- Dump completed on 2018-11-27 11:39:39
