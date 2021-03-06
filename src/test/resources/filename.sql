-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: antivirus2
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_orders`
--

DROP TABLE IF EXISTS `delivery_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_orders` (
  `delivery_id` int(11) NOT NULL,
  `orders_id` int(11) NOT NULL,
  KEY `FKdg1fj61i6qw9hx3luu4jgyoql` (`orders_id`),
  KEY `FKfh25518flcxlcmp78y35a01wh` (`delivery_id`),
  CONSTRAINT `FKdg1fj61i6qw9hx3luu4jgyoql` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKfh25518flcxlcmp78y35a01wh` FOREIGN KEY (`delivery_id`) REFERENCES `deliverytype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_orders`
--

LOCK TABLES `delivery_orders` WRITE;
/*!40000 ALTER TABLE `delivery_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_product`
--

DROP TABLE IF EXISTS `delivery_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_product` (
  `product_id` int(11) NOT NULL,
  `delivery_id` int(11) NOT NULL,
  KEY `FKja16x3oxruw4xywaxruwhxsf9` (`delivery_id`),
  KEY `FKfmngyafvui4brrcojbahhnrdn` (`product_id`),
  CONSTRAINT `FKfmngyafvui4brrcojbahhnrdn` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKja16x3oxruw4xywaxruwhxsf9` FOREIGN KEY (`delivery_id`) REFERENCES `deliverytype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_product`
--

LOCK TABLES `delivery_product` WRITE;
/*!40000 ALTER TABLE `delivery_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deliverytype`
--

DROP TABLE IF EXISTS `deliverytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deliverytype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` int(11) NOT NULL,
  `daysToArrive` int(11) NOT NULL,
  `deliveryServiceName` varchar(255) DEFAULT NULL,
  `region_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9th2nvqt7bi0p1enmr6sx8eig` (`region_id`),
  CONSTRAINT `FK9th2nvqt7bi0p1enmr6sx8eig` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deliverytype`
--

LOCK TABLES `deliverytype` WRITE;
/*!40000 ALTER TABLE `deliverytype` DISABLE KEYS */;
INSERT INTO `deliverytype` VALUES (1,250,25,'DHL',8),(2,180,10,'UPS',9),(3,80,8,'FedEx',3),(4,210,7,'TNT',5),(5,120,35,'Ali Express',9),(6,40,5,'AutoLux',4),(7,60,3,'Nova Poshta',4),(8,180,15,'Parcel Delivery',1),(9,140,18,'South Fly',7);
/*!40000 ALTER TABLE `deliverytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules_product`
--

DROP TABLE IF EXISTS `modules_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modules_product` (
  `product_id` int(11) NOT NULL,
  `modules_id` int(11) NOT NULL,
  KEY `FK5o2xne19jeaeqm357qll3jamm` (`modules_id`),
  KEY `FK2m4ms27oors1ekeocur4nw4rr` (`product_id`),
  CONSTRAINT `FK2m4ms27oors1ekeocur4nw4rr` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK5o2xne19jeaeqm357qll3jamm` FOREIGN KEY (`modules_id`) REFERENCES `modulesincluded` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules_product`
--

LOCK TABLES `modules_product` WRITE;
/*!40000 ALTER TABLE `modules_product` DISABLE KEYS */;
INSERT INTO `modules_product` VALUES (2,3),(4,3),(4,3),(6,3),(6,3),(7,3),(7,3),(2,1),(3,1),(3,1),(4,1),(4,1),(6,1),(6,1),(6,7),(6,7),(2,9),(7,9),(7,9),(5,1),(5,3),(5,9),(3,2),(3,2),(7,2),(7,2),(5,2),(4,4),(4,4),(6,4),(6,4),(7,4),(7,4),(4,8),(4,8),(6,8),(6,8),(7,8),(7,8),(7,10),(7,10),(8,1),(8,2),(8,3),(8,7),(11,3),(11,4),(11,6),(11,8),(10,1),(10,4),(10,6),(10,9),(9,1),(9,3),(9,4),(9,5),(9,6);
/*!40000 ALTER TABLE `modules_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulesincluded`
--

DROP TABLE IF EXISTS `modulesincluded`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulesincluded` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulesincluded`
--

LOCK TABLES `modulesincluded` WRITE;
/*!40000 ALTER TABLE `modulesincluded` DISABLE KEYS */;
INSERT INTO `modulesincluded` VALUES (1,'Deactivation of all existing types of threats, such as viruses, spyware, trojans, rootkits, advertising;','Antivirus'),(2,'Allows you to block connections of external storage media, such as USB, CD, DVD, etc., prevents unauthorized copying of confidential information to external media;','Antispyware'),(3,'This module, thanks to the online portal allows you to find a stolen or lost device and thereby ensure the preservation of all important data;','Anti-theft'),(4,'This is a module that prevents unauthorized copying of information to external devices, so you are always safe from sites that can commit bank data, logins and passwords;','Anti-fishing'),(5,'Provides safe operation in Internet banking and other various online operations, even when working in public Wi-fi networks, remaining invisible to other users;','Personal firewall'),(6,'You can safely make bank payments and purchases online, while remaining safe;','Protect online payments'),(7,'Protect your family from unwanted and dangerous information, blocking malicious websites;','Parental control'),(8,'All vulnerabilities of the operating system and applications will be fully protected','Exploits detection '),(9,'There is a tracking of all suspicious processes and their scanning from the moment of occurrence, so you are protected from carefully encrypted and hidden threats;','Memory Scanner'),(10,'Detects the vulnerabilities (CVE) of protocols that are widely used, namely SMB, RPC and RDP;','Vulnerability Protection');
/*!40000 ALTER TABLE `modulesincluded` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` datetime DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `totalPrice` int(11) NOT NULL,
  `region_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2t76h862334r9ebb1elfwxiy6` (`region_id`),
  KEY `FKsgwj42spshwc3eestq5vk520j` (`user_id`),
  CONSTRAINT `FK2t76h862334r9ebb1elfwxiy6` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`),
  CONSTRAINT `FKsgwj42spshwc3eestq5vk520j` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2017-08-03 11:37:59',0,1520,NULL,4),(2,'2017-08-03 11:38:59',0,1990,NULL,4),(3,'2017-08-03 11:46:17',0,3180,NULL,5),(4,'2017-08-03 11:47:22',0,550,NULL,5),(5,'2017-08-03 11:48:48',0,1650,NULL,5),(6,'2017-08-03 11:52:32',0,2060,NULL,6),(7,'2017-08-03 11:57:21',0,0,NULL,6),(8,'2017-08-03 12:11:04',0,630,NULL,6);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_product`
--

DROP TABLE IF EXISTS `orders_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_product` (
  `product_id` int(11) NOT NULL,
  `orders_id` int(11) NOT NULL,
  KEY `FK7l9h7uj4iko47so8f7adheeb8` (`orders_id`),
  KEY `FKawy62h5ss5urqjiqrq5xg0b8l` (`product_id`),
  CONSTRAINT `FK7l9h7uj4iko47so8f7adheeb8` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKawy62h5ss5urqjiqrq5xg0b8l` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_product`
--

LOCK TABLES `orders_product` WRITE;
/*!40000 ALTER TABLE `orders_product` DISABLE KEYS */;
INSERT INTO `orders_product` VALUES (3,1),(4,1),(6,1),(10,3),(8,3),(3,4),(4,4),(4,5),(3,5),(4,6),(7,6),(9,6),(5,7),(8,7),(11,7),(2,8),(4,8);
/*!40000 ALTER TABLE `orders_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `licenceDurationYears` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pathImage` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `productQuantity` int(11) NOT NULL,
  `quantityPC` int(11) NOT NULL,
  `systemRequirements_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl49ld5tbells5ccd8nmbrtdde` (`systemRequirements_id`),
  CONSTRAINT `FKl49ld5tbells5ccd8nmbrtdde` FOREIGN KEY (`systemRequirements_id`) REFERENCES `systemrequirements` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,'Avast Antivirus',1,'Avast','resources/Avast/126-150x150.jpg',210,1,1,7),(3,'Antivirus for all',1,'Avira','resources/Avira/avira.jpg',130,3,1,2),(4,'Universal for Desktop PC',1,'Bit Defender','resources/Bit Defender/bitdefender-logo-150x150.jpg',420,1,2,4),(5,'Simple antivirus for Linux',3,'Kaspersky (KAV)','resources/Kaspersky/Kaspersky-Antivirus.jpg',640,2,4,7),(6,'Interner Secirity',1,'Kaspersky (KIS)','resources/Kaspersky (KIS)/kaspersky_1pc_1year.jpg',970,1,6,2),(7,'Total RealTime Protectin',5,'Kaspersky (CRYSTAL)','resources/Kaspersky (CRYSTAL)/Kaspersky_Total_Security.jpg',1460,1,2,4),(8,'NOD 32 antivirus',1,'ESET','resources/ESET/ESET-NOD32-Antivirus-.png',580,2,4,1),(9,'protectyour IPhone 24/7 ',3,'ESET for IOS','resources/ESET for IOS/eset-internet-security-2pk-12m.jpg',180,1,1,5),(10,'Online Internet Security',1,'Avast (IS)','resources/Avast (IS)/Avast-Internet-Security.png',480,3,3,1),(11,'Defend your device',1,'Kaspersky for Android','resources/Kaspersky for Android/kasp.png',195,2,1,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pathImage` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Brazil','resources/Brazil/brazil_flag.jpeg'),(2,'Great Britain','resources/Great Britain/britain-Flag.jpg'),(3,'Canada','resources/Canada/flag_of_canada.png'),(4,'Ukraine','resources/Ukraine/Flag_of_Ukraine.png'),(5,'USA','resources/USA/USA1.jpg'),(6,'Japan','resources/Japan/Japanese Flag.jpg'),(7,'Australia','resources/Australia/australia-flag.jpg'),(8,'World','resources/World/International_Flag_of_Planet_Earth.png'),(9,'Euro Union','resources/Euro Union/EU-Flag-300-ppi.jpg');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `systemrequirements`
--

DROP TABLE IF EXISTS `systemrequirements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `systemrequirements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `OSlanguage` varchar(255) DEFAULT NULL,
  `OSname` varchar(255) DEFAULT NULL,
  `RAM` int(11) NOT NULL,
  `bitSystem` varchar(255) DEFAULT NULL,
  `spaceAmount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemrequirements`
--

LOCK TABLES `systemrequirements` WRITE;
/*!40000 ALTER TABLE `systemrequirements` DISABLE KEYS */;
INSERT INTO `systemrequirements` VALUES (1,'english','WIndows Mobile',64,'x32',150),(2,'ukrainian','Windows 7',256,'x64',200),(3,'russian','Linux',128,'x32',130),(4,'spain','Windows 10',512,'x64',380),(5,'english','IOS',256,'x64',220),(6,'ukrainian','Android',128,'x32',180),(7,'old egypt','Windows XP',64,'x32',100);
/*!40000 ALTER TABLE `systemrequirements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `enable` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'meteoritKIDS@gmail.com','','yura','$2a$10$lmuA3B0A7N3Saufh8P4aqOpsIz0qm/1UgPldhoBWt/MHmjZVOBL9O',1,'62244078-7e58-43d6-b791-3e3b4be14a8c'),(5,'cola709@rambler.ru','','vova','$2a$10$Ws3jzAQXOSlZ3mJv8vfG.OvFSGVvNDhne0YdwLa1AGZKWutrS3inS',1,'123bae1d-601e-4dfc-b533-34bad4bb98b6'),(6,'zelisko_ks-11@inbox.ru','','vicen','$2a$10$Kthl8SpBIzWGkZf717SrPOGFU/YGi2ec1MlKzUe9IC2spi9w.6dAa',1,'7266daf6-4eab-412f-914a-7f00b136c198');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_product`
--

DROP TABLE IF EXISTS `user_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_product` (
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  KEY `FKf4ynufhjqptdpbq4g7qxm6qhg` (`product_id`),
  KEY `FKrddxxxw1c4mv1u7d1kg2os7u5` (`user_id`),
  CONSTRAINT `FKf4ynufhjqptdpbq4g7qxm6qhg` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKrddxxxw1c4mv1u7d1kg2os7u5` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_product`
--

LOCK TABLES `user_product` WRITE;
/*!40000 ALTER TABLE `user_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-03 13:41:55
