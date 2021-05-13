/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.4.18-MariaDB : Database - floreria
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`floreria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */;

USE `floreria`;

/*Table structure for table `catalogoarreglos` */

DROP TABLE IF EXISTS `catalogoarreglos`;

CREATE TABLE `catalogoarreglos` (
  `idArreglo` int(11) NOT NULL AUTO_INCREMENT,
  `nombreArreglo` varchar(150) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `costoArreglo` double NOT NULL,
  `tiempoElaboracion` time DEFAULT NULL,
  `comision` double DEFAULT NULL,
  PRIMARY KEY (`idArreglo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

/*Data for the table `catalogoarreglos` */

insert  into `catalogoarreglos`(`idArreglo`,`nombreArreglo`,`costoArreglo`,`tiempoElaboracion`,`comision`) values 
(3,'Gardenias y geranios',350,'00:50:00',17.5),
(9,'rosas y violetas',250,'00:10:00',12.5);

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `numEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpleado` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `user` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(20) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `puntoDeVenta` varchar(150) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `puesto` enum('diseñador','supervisor','administrador') COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `comision` double(10,0) DEFAULT NULL,
  `tiempoTrabajo` time DEFAULT NULL,
  PRIMARY KEY (`numEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

/*Data for the table `empleados` */

insert  into `empleados`(`numEmpleado`,`nombreEmpleado`,`user`,`password`,`puntoDeVenta`,`puesto`,`comision`,`tiempoTrabajo`) values 
(1,'jesus dario rodriguez','chuy2012','12345','matriz','administrador',0,NULL),
(4,'Benito Bodoque','donGato','12345','matriz','diseñador',0,NULL);

/*Table structure for table `pedidosempleado` */

DROP TABLE IF EXISTS `pedidosempleado`;

CREATE TABLE `pedidosempleado` (
  `idPedidoEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `estatus` enum('asignado','en elaboracion','terminado','autorizado') COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `tiempoEstimado` time DEFAULT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaTermino` time DEFAULT NULL,
  `numeroEmpleado` int(11) DEFAULT NULL,
  `idArreglo` int(11) DEFAULT NULL,
  `user` varchar(45) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `comision` double DEFAULT NULL,
  PRIMARY KEY (`idPedidoEmpleado`),
  KEY `numeroEmpleado` (`numeroEmpleado`),
  KEY `idArreglo` (`idArreglo`),
  CONSTRAINT `pedidosempleado_ibfk_1` FOREIGN KEY (`numeroEmpleado`) REFERENCES `empleados` (`numEmpleado`),
  CONSTRAINT `pedidosempleado_ibfk_2` FOREIGN KEY (`idArreglo`) REFERENCES `catalogoarreglos` (`idArreglo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

/*Data for the table `pedidosempleado` */

insert  into `pedidosempleado`(`idPedidoEmpleado`,`estatus`,`tiempoEstimado`,`horaInicio`,`horaTermino`,`numeroEmpleado`,`idArreglo`,`user`,`comision`) values 
(25,'terminado','00:10:00','23:37:19','23:37:27',4,9,'donGato',NULL),
(26,'asignado','00:10:00',NULL,NULL,4,9,'donGato',NULL),
(27,'asignado','00:10:00',NULL,NULL,4,9,'donGato',NULL),
(28,'asignado','00:50:00',NULL,NULL,4,3,'donGato',NULL),
(29,'asignado','00:10:00',NULL,NULL,4,9,'donGato',NULL),
(30,'asignado','00:10:00',NULL,NULL,4,9,'donGato',NULL),
(31,'asignado','00:50:00',NULL,NULL,4,3,'donGato',NULL),
(32,'asignado','00:10:00',NULL,NULL,4,9,'donGato',12.5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
