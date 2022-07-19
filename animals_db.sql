USE `animals_db`;

DROP TABLE IF EXISTS `animals`;
DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext NOT NULL,
  `plural_name` tinytext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `categories` WRITE;
INSERT INTO `categories` VALUES (1,'Dog','Dogs'),(2,'Cat','Cats'),(3,'Jellyfish','Jellyfish'),(4,'Insect','Insects');
UNLOCK TABLES;

CREATE TABLE `animals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `name` tinytext NOT NULL,
  `image_url` tinytext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `animals_FK` (`category_id`),
  CONSTRAINT `animals_FK` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

LOCK TABLES `animals` WRITE;
INSERT INTO `animals` VALUES (1,1,'Mira Dog','dog1.jpg'),(2,1,'Rottweiler','dog2.jpg'),(3,2,'Grey Cat','cat1.jpg'),(4,2,'Cute Kitten','cat2.jpg'),(5,3,'Pink Jellyfish','jellyfish1.jpg'),(6,3,'Blue Jellyfish','jellyfish2.jpg'),(7,4,'Green Caterpillar','insect1.jpg'),(8,4,'Panda Ant','insect2.jpg');
UNLOCK TABLES;
