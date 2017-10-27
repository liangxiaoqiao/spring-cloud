CREATE TABLE `author` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `year_of_birth` int(7) DEFAULT NULL,
  `inserttime` timestamp NULL DEFAULT NULL,
  `updatetimestr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  `id` int(7) NOT NULL AUTO_INCREMENT,
  `author_id` int(7) NOT NULL,
  `title` varchar(400) NOT NULL,
  `published_in` int(7) NOT NULL,
  `language_id` int(7) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

