-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: saipsc
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acesso`
--

DROP TABLE IF EXISTS `acesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acesso` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acesso`
--

LOCK TABLES `acesso` WRITE;
/*!40000 ALTER TABLE `acesso` DISABLE KEYS */;
INSERT INTO `acesso` VALUES (1,'ADM',NULL),(2,'USUARIO',NULL),(3,'OUTRO',NULL);
/*!40000 ALTER TABLE `acesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `id` int NOT NULL,
  `id_pessoa` int DEFAULT NULL,
  `id_cor_faixa` int DEFAULT NULL,
  `data_de_nascimento` date DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `responsavel` int DEFAULT NULL,
  `ultima_grad` date DEFAULT NULL,
  `projec_grad` date DEFAULT NULL,
  `faltas` varchar(100) DEFAULT NULL,
  `id_polo` int DEFAULT NULL,
  `cpf_resp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Aluno_FK` (`id_cor_faixa`),
  KEY `Aluno_FK_1` (`responsavel`),
  KEY `aluno_FK1` (`id_polo`),
  CONSTRAINT `Aluno_FK` FOREIGN KEY (`id_cor_faixa`) REFERENCES `cor` (`id`),
  CONSTRAINT `aluno_FK1` FOREIGN KEY (`id_polo`) REFERENCES `polos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,1,1,'1975-11-29',47,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `campeonato`
--

DROP TABLE IF EXISTS `campeonato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `campeonato` (
  `id` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `local` varchar(100) DEFAULT NULL,
  `responsavel` varchar(100) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `inscricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `campeonato`
--

LOCK TABLES `campeonato` WRITE;
/*!40000 ALTER TABLE `campeonato` DISABLE KEYS */;
INSERT INTO `campeonato` VALUES (1,'Copa Semeando Campeoes','Campo Mourao','Ricardo','44998130695','2023-12-16','50,00');
/*!40000 ALTER TABLE `campeonato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Professor Senior',NULL),(2,'Professor',NULL),(3,'Instrutor Senior',NULL),(4,'Instrutor',NULL);
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoriakf`
--

DROP TABLE IF EXISTS `categoriakf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoriakf` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoriakf`
--

LOCK TABLES `categoriakf` WRITE;
/*!40000 ALTER TABLE `categoriakf` DISABLE KEYS */;
INSERT INTO `categoriakf` VALUES (1,'Kimono'),(2,'Faixa'),(3,'Outro');
/*!40000 ALTER TABLE `categoriakf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `condicao`
--

DROP TABLE IF EXISTS `condicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `condicao` (
  `id` int NOT NULL,
  `estado` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descricao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `condicao`
--

LOCK TABLES `condicao` WRITE;
/*!40000 ALTER TABLE `condicao` DISABLE KEYS */;
INSERT INTO `condicao` VALUES (1,'novo',NULL),(2,'usado',NULL);
/*!40000 ALTER TABLE `condicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cor`
--

DROP TABLE IF EXISTS `cor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cor` (
  `id` int NOT NULL,
  `descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cor`
--

LOCK TABLES `cor` WRITE;
/*!40000 ALTER TABLE `cor` DISABLE KEYS */;
INSERT INTO `cor` VALUES (1,'branca'),(2,'cinza com branco');
/*!40000 ALTER TABLE `cor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipe` (
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_cargo` int DEFAULT NULL,
  `graduacao` date DEFAULT NULL,
  `salario` varchar(100) DEFAULT NULL,
  `id_cor` int DEFAULT NULL,
  `id_acesso` int DEFAULT NULL,
  `id_pessoa` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equipe_FK` (`id_cargo`),
  KEY `equipe_FK_1` (`id_cor`),
  KEY `equipe_FK_2` (`id_acesso`),
  KEY `equipe_FK_3` (`id_pessoa`),
  CONSTRAINT `equipe_FK` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id`),
  CONSTRAINT `equipe_FK_1` FOREIGN KEY (`id_cor`) REFERENCES `cor` (`id`),
  CONSTRAINT `equipe_FK_2` FOREIGN KEY (`id_acesso`) REFERENCES `acesso` (`id`),
  CONSTRAINT `equipe_FK_3` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipe`
--

LOCK TABLES `equipe` WRITE;
/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` VALUES ('1',1,'2023-07-27','00',1,1,1);
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `investidores`
--

DROP TABLE IF EXISTS `investidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investidores` (
  `id` int NOT NULL,
  `observacao` varchar(100) DEFAULT NULL,
  `investimento` varchar(100) DEFAULT NULL,
  `periodicidade` varchar(100) DEFAULT NULL,
  `id_pessoa` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `investidores_FK` (`id_pessoa`),
  CONSTRAINT `investidores_FK` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investidores`
--

LOCK TABLES `investidores` WRITE;
/*!40000 ALTER TABLE `investidores` DISABLE KEYS */;
/*!40000 ALTER TABLE `investidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `id` int NOT NULL,
  `Nome` varchar(100) DEFAULT NULL,
  `descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Cairo',NULL);
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participacao`
--

DROP TABLE IF EXISTS `participacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participacao` (
  `id` int NOT NULL,
  `Resultado` varchar(100) DEFAULT NULL,
  `id_campeonato` int DEFAULT NULL,
  `id_aluno` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `participacao_FK` (`id_campeonato`),
  KEY `participacao_FK_1` (`id_aluno`),
  CONSTRAINT `participacao_FK` FOREIGN KEY (`id_campeonato`) REFERENCES `campeonato` (`id`),
  CONSTRAINT `participacao_FK_1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participacao`
--

LOCK TABLES `participacao` WRITE;
/*!40000 ALTER TABLE `participacao` DISABLE KEYS */;
INSERT INTO `participacao` VALUES (1,'3',1,1);
/*!40000 ALTER TABLE `participacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrimonio`
--

DROP TABLE IF EXISTS `patrimonio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrimonio` (
  `id` int NOT NULL,
  `material` varchar(100) DEFAULT NULL,
  `quantidade` varchar(100) DEFAULT NULL,
  `situacao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `descricao` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrimonio`
--

LOCK TABLES `patrimonio` WRITE;
/*!40000 ALTER TABLE `patrimonio` DISABLE KEYS */;
INSERT INTO `patrimonio` VALUES (1,'Tatame','20','proprio','comprado');
/*!40000 ALTER TABLE `patrimonio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `id` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `rg` varchar(100) DEFAULT NULL,
  `cpf` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  `obs` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'Ricardo','62424796','02046234995','rua akibono','44998130695','B');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polos`
--

DROP TABLE IF EXISTS `polos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polos` (
  `id` int NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `responsavel` varchar(100) DEFAULT NULL,
  `contato` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polos`
--

LOCK TABLES `polos` WRITE;
/*!40000 ALTER TABLE `polos` DISABLE KEYS */;
INSERT INTO `polos` VALUES (1,'CT Centro','R. São Josafat, 1778','Pastor Gustavo','');
/*!40000 ALTER TABLE `polos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quimonos_e_faixas`
--

DROP TABLE IF EXISTS `quimonos_e_faixas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quimonos_e_faixas` (
  `id` int NOT NULL,
  `id_cor` int DEFAULT NULL,
  `id_categoria` int DEFAULT NULL,
  `id_tamanho` int DEFAULT NULL,
  `id_condicao` int DEFAULT NULL,
  `id_marca` int DEFAULT NULL,
  `Obs.` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `quimonos_e_faixas_FK` (`id_cor`),
  KEY `quimonos_e_faixas_FK_1` (`id_categoria`),
  KEY `quimonos_e_faixas_FK_2` (`id_condicao`),
  KEY `quimonos_e_faixas_FK_3` (`id_marca`),
  KEY `quimonos_e_faixas_FK_4` (`id_tamanho`),
  CONSTRAINT `quimonos_e_faixas_FK` FOREIGN KEY (`id_cor`) REFERENCES `cor` (`id`),
  CONSTRAINT `quimonos_e_faixas_FK_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoriakf` (`id`),
  CONSTRAINT `quimonos_e_faixas_FK_2` FOREIGN KEY (`id_condicao`) REFERENCES `condicao` (`id`),
  CONSTRAINT `quimonos_e_faixas_FK_3` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`),
  CONSTRAINT `quimonos_e_faixas_FK_4` FOREIGN KEY (`id_tamanho`) REFERENCES `tamanho` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quimonos_e_faixas`
--

LOCK TABLES `quimonos_e_faixas` WRITE;
/*!40000 ALTER TABLE `quimonos_e_faixas` DISABLE KEYS */;
INSERT INTO `quimonos_e_faixas` VALUES (1,1,1,1,1,1,NULL);
/*!40000 ALTER TABLE `quimonos_e_faixas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tamanho`
--

DROP TABLE IF EXISTS `tamanho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tamanho` (
  `id` int NOT NULL,
  `tamanho` varchar(100) DEFAULT NULL,
  `Obs.` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tamanho`
--

LOCK TABLES `tamanho` WRITE;
/*!40000 ALTER TABLE `tamanho` DISABLE KEYS */;
INSERT INTO `tamanho` VALUES (1,'M0',NULL),(2,'M1',NULL),(3,'M2',NULL);
/*!40000 ALTER TABLE `tamanho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'saipsc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-08 11:56:03
