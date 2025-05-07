-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 伺服器版本:                        5.7.44-log - MySQL Community Server (GPL)
-- 伺服器操作系統:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 傾印  表格 bentest.my_order 結構
CREATE TABLE IF NOT EXISTS `my_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `duedate` datetime NOT NULL,
  `price` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_my_order_my_customer` (`customer_id`),
  CONSTRAINT `FK_my_order_my_customer` FOREIGN KEY (`customer_id`) REFERENCES `my_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- 正在傾印表格  bentest.my_order 的資料：~4 rows (大約)
/*!40000 ALTER TABLE `my_order` DISABLE KEYS */;
INSERT INTO `my_order` (`id`, `name`, `customer_id`, `address`, `duedate`, `price`) VALUES
	(1, 'toy', 1, '123 Maple Street', '2024-01-15 14:25:36', 123),
	(2, 'pen', 1, 'addrv', '2024-04-18 20:13:14', 34),
	(3, 'book', 3, 'test', '2024-07-01 20:00:00', 45),
	(4, 'car', 2, 'test2', '2024-07-01 20:00:00', 5678);
/*!40000 ALTER TABLE `my_order` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
