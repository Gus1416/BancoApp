CREATE DATABASE  IF NOT EXISTS `bd_bancoapp` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_bancoapp`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_bancoapp
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codigo_cliente` varchar(7) NOT NULL,
  `identificacion` varchar(10) NOT NULL,
  `numero_telefono` varchar(11) NOT NULL,
  `correo_electronico` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo_cliente`),
  KEY `fk_identificacionCliente_idx` (`identificacion`),
  CONSTRAINT `fk_identificacionCliente` FOREIGN KEY (`identificacion`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta` (
  `numero_cuenta` varchar(100) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `saldo` varchar(100) NOT NULL,
  `estatus` varchar(8) NOT NULL,
  `pin` varchar(100) NOT NULL,
  PRIMARY KEY (`numero_cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta`
--

LOCK TABLES `cuenta` WRITE;
/*!40000 ALTER TABLE `cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta_operacion`
--

DROP TABLE IF EXISTS `cuenta_operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta_operacion` (
  `numero_cuenta` varchar(100) NOT NULL,
  `id_operacion` int NOT NULL,
  PRIMARY KEY (`numero_cuenta`,`id_operacion`),
  KEY `fk_numeroOperacionOperacion_idx` (`id_operacion`),
  CONSTRAINT `fk_numeroCuentaOperacion` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta` (`numero_cuenta`) ON DELETE CASCADE,
  CONSTRAINT `fk_numeroOperacionOperacion` FOREIGN KEY (`id_operacion`) REFERENCES `operacion` (`id_operacion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta_operacion`
--

LOCK TABLES `cuenta_operacion` WRITE;
/*!40000 ALTER TABLE `cuenta_operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta_operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operacion`
--

DROP TABLE IF EXISTS `operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operacion` (
  `id_operacion` int NOT NULL AUTO_INCREMENT,
  `fecha_operacion` date NOT NULL,
  `tipo_operacion` varchar(45) NOT NULL,
  `se_cobra_comision` tinyint NOT NULL,
  `monto_operacion` double NOT NULL,
  `monto_comision` double NOT NULL,
  `moneda` varchar(7) NOT NULL,
  PRIMARY KEY (`id_operacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operacion`
--

LOCK TABLES `operacion` WRITE;
/*!40000 ALTER TABLE `operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `identificacion` varchar(10) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_cuenta`
--

DROP TABLE IF EXISTS `persona_cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona_cuenta` (
  `identificacion` varchar(11) NOT NULL,
  `numero_cuenta` varchar(100) NOT NULL,
  PRIMARY KEY (`identificacion`,`numero_cuenta`),
  KEY `fk_numerocuentaPersonaCuenta_idx` (`numero_cuenta`),
  CONSTRAINT `fk_identificacionPersonaCuenta` FOREIGN KEY (`identificacion`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE,
  CONSTRAINT `fk_numerocuentaPersonaCuenta` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta` (`numero_cuenta`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_cuenta`
--

LOCK TABLES `persona_cuenta` WRITE;
/*!40000 ALTER TABLE `persona_cuenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `persona_cuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `codigo_usuario` int NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(11) NOT NULL,
  PRIMARY KEY (`codigo_usuario`),
  KEY `fk_identificacionUsuario_idx` (`identificacion`),
  CONSTRAINT `fk_identificacionUsuario` FOREIGN KEY (`identificacion`) REFERENCES `persona` (`identificacion`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_bancoapp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-30 11:30:28
