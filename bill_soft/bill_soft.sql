/*
Navicat MySQL Data Transfer

Source Server         : Embel
Source Server Version : 50559
Source Host           : localhost:3306
Source Database       : bill_soft

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2023-07-10 02:18:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank_details
-- ----------------------------
DROP TABLE IF EXISTS `bank_details`;
CREATE TABLE `bank_details` (
  `pk_bank_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_holder_name` varchar(255) DEFAULT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bank_email` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `branch_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `ifsc_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_bank_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bank_details
-- ----------------------------
INSERT INTO `bank_details` VALUES ('1', 'pratikasha sd', '788999999999', 'karvenagar', 'nikhilgmail.com', 'sbi', 'karvenagar', '89887766768', 'admin(admin)', '14-04-2023', '3', '2', '12345679005555');
INSERT INTO `bank_details` VALUES ('2', 'pratikasha sd', '788999999999', 'karvenagar', 'nikhilgmail.com', 'sbi', 'karvenagar', '89887766768', 'admin(admin)', '14-04-2023', '3', '2', '12345679005555');
INSERT INTO `bank_details` VALUES ('3', 'pratikasha sd', '788999999999', 'karvenagar', 'nikhilgmail.com', 'sbi', 'karvenagar', '89887766768', 'admin(admin)', '2023-05-08', '3', '2', '12345679005555');

-- ----------------------------
-- Table structure for bank_payment
-- ----------------------------
DROP TABLE IF EXISTS `bank_payment`;
CREATE TABLE `bank_payment` (
  `pk_bank_payment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountant_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_bank_id` bigint(20) DEFAULT NULL,
  `fk_organization_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `organization_name` varchar(255) DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_bank_payment_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bank_payment
-- ----------------------------

-- ----------------------------
-- Table structure for barcode_no_wise_stock
-- ----------------------------
DROP TABLE IF EXISTS `barcode_no_wise_stock`;
CREATE TABLE `barcode_no_wise_stock` (
  `pk_barcode_stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manufacture_date` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `available_quantity` double DEFAULT NULL,
  `barcode_no` varchar(255) DEFAULT NULL,
  `barcode_no_wise_stock` double DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `packing_type` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`pk_barcode_stock_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of barcode_no_wise_stock
-- ----------------------------
INSERT INTO `barcode_no_wise_stock` VALUES ('1', '2023-04-01', 'Smartphones', 'John', '5', '1000', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('2', '2023-04-01', 'Smartphones', 'John', '5', '1001', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('3', '2023-04-01', 'Smartphones', 'John', '5', '1003', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('4', '2023-04-01', 'Smartphones', 'John', '5', '1004', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('5', '2023-04-01', 'Smartphones', 'John', '5', '1006', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('6', '2023-04-01', 'Smartphones', 'John', '5', '1007', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('7', '2023-04-01', 'Smartphones', 'John', '5', '1009', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('8', '2023-04-01', 'Smartphones', 'John', '5', '1010', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('9', '2023-04-01', 'Smartphones', 'John', '5', '1012', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('10', '2023-04-01', 'Smartphones', 'John', '5', '1013', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('11', '2023-04-01', 'Smartphones', 'John', '5', '1015', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('12', '2023-04-01', 'Smartphones', 'John', '5', '1016', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('13', '2023-04-01', 'Smartphones', 'John', '5', '1018', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('14', '2023-04-01', 'Smartphones', 'John', '5', '1019', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('15', '2023-04-01', 'Smartphones', 'John', '5', '1020', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('16', '2023-04-01', 'Smartphones', 'John', '5', '1021', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('17', '2023-04-01', 'Smartphones', 'John', '5', '1022', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('18', '2023-04-01', 'Smartphones', 'John', '5', '1023', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('19', '2023-04-01', 'Smartphones', 'John', '5', '1024', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('20', '2023-04-01', 'Smartphones', 'John', '5', '1025', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('21', '2023-04-01', 'Smartphones', 'John', '5', '1026', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('22', '2023-04-01', 'Smartphones', 'John', '5', '1027', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('23', '2023-04-01', 'Smartphones', 'John', '5', '1028', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('24', '2023-04-01', 'Smartphones', 'John', '5', '1029', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('25', '2023-04-01', 'Smartphones', 'John', '5', '1030', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S11', 'TechHub', '0', 'pcs', '2023-05-10', '400');
INSERT INTO `barcode_no_wise_stock` VALUES ('26', '2023-04-01', 'Smartphones', 'John', '5', '1031', null, '1234', 'Electronics', 'Phantom Black', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', null, 'Samsung Galaxy S21', 'TechHub', '0', 'pcs', '2023-05-10', '400');

-- ----------------------------
-- Table structure for bill_details
-- ----------------------------
DROP TABLE IF EXISTS `bill_details`;
CREATE TABLE `bill_details` (
  `pk_bill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `amount_recieved` double DEFAULT NULL,
  `barcode_no` varchar(255) DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `bill_date` varchar(255) DEFAULT NULL,
  `bill_no` bigint(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `comapny_name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_type` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_cat_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcat_id` bigint(20) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `gst_expense` double DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `labour_expense` double DEFAULT NULL,
  `manufaturing_date` varchar(255) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `sale_price_excluding_tax` double DEFAULT NULL,
  `sale_price_including_tax` double DEFAULT NULL,
  `sale_quotation_no` bigint(20) DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `transport_expense` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `card_amount` double DEFAULT NULL,
  `cash_amount` double DEFAULT NULL,
  `upi_amount` double DEFAULT NULL,
  `credit_amount` double DEFAULT NULL,
  PRIMARY KEY (`pk_bill_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bill_details
-- ----------------------------

-- ----------------------------
-- Table structure for category_details
-- ----------------------------
DROP TABLE IF EXISTS `category_details`;
CREATE TABLE `category_details` (
  `pk_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_category_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category_details
-- ----------------------------
INSERT INTO `category_details` VALUES ('1', 'admin', 'cloth', 'Mens', 'admin(admin)', '05-05-2023', '3', '1', '1', 'EmbelShop', 'Embel Technology');
INSERT INTO `category_details` VALUES ('2', 'admin', 'cloth', 'Womens', 'admin(admin)', '05-05-2023', '3', '1', '1', 'EmbelShop', 'Embel Technology');

-- ----------------------------
-- Table structure for customer_details
-- ----------------------------
DROP TABLE IF EXISTS `customer_details`;
CREATE TABLE `customer_details` (
  `pk_customer_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `alternate_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `firm_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `gst_or_tin_no` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_customer_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer_details
-- ----------------------------
INSERT INTO `customer_details` VALUES ('1', 'warje', 'admin', '8888888888', 'pune', '9999999999', 'admin(admin)', '14-04-2023', 'ashwiniembel@gmail.com', 'embel', 'ashwini', '3', '1', '2', '1234', 'pujari', 'aaaaaa', 'oragnization', 'Embel Technologies', '12345');

-- ----------------------------
-- Table structure for customer_payment
-- ----------------------------
DROP TABLE IF EXISTS `customer_payment`;
CREATE TABLE `customer_payment` (
  `pk_customer_payment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountant_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `balance_amount` double DEFAULT NULL,
  `bill_no` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_customer_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `receipt_no` bigint(20) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `card` double DEFAULT NULL,
  `cash` double DEFAULT NULL,
  `upi` double DEFAULT NULL,
  PRIMARY KEY (`pk_customer_payment_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of customer_payment
-- ----------------------------
INSERT INTO `customer_payment` VALUES ('1', 'vvvvv', 'admin', '120', '1', '8888888888', 'admin(admin)', '24-04-2023', 'ashwini pujari', 'payment', '3', '1', '1', '2', 'oragnization', '100', null, 'cash', 'cash', '1', 'Embel Technologies', '200', '1', null, null, null);

-- ----------------------------
-- Table structure for employee_details
-- ----------------------------
DROP TABLE IF EXISTS `employee_details`;
CREATE TABLE `employee_details` (
  `pk_employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login_time` varchar(255) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_employee_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee_details
-- ----------------------------
INSERT INTO `employee_details` VALUES ('1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMiIsImF1dGgiOltdLCJpYXQiOjE2NzU3NzY5MzIsImV4cCI6MTY3NTc4MDUzMn0.RZUscj8sWc_wjvObSNs45i2ETzHZH6M8ww2338stfnI', 'admin2', '9090909090', null, '04-02-2023', 'viduyaembel@gmail.com', 'user2', '14', null, 'user2', '07-02-2023 19:05:32', null, '$2a$12$R9eqiw6Y6Wds8ezsKLGnzudYIVNxvjCJmInRh5ggDIJZix7ePymH6', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMiIsImF1ZCI6IlJlZnJlc2giLCJpYXQiOjE2NzU3NzY5MzIsImV4cCI6MTY3NTg2MzMzMn0.4auKsUh8mNCxBHhnM6gnARdr_2KGMObEQQVdtgu4kXs', null, 'user', 'user2');
INSERT INTO `employee_details` VALUES ('2', null, null, '7678767876', null, '06-03-2023', 'supriya@gmail.com', 'supriya1', '3', '2', 'kadam', null, null, '$2a$12$6yYnM1kLUJIP5.DcWPaw4OGH0RE7XRr2.EKvzMaOSD3ldntlPg7E6', null, null, 'user', 'supriya');
INSERT INTO `employee_details` VALUES ('3', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyNCIsImF1dGgiOltdLCJpYXQiOjE2NzU4MzIyNjAsImV4cCI6MTY3NTgzNTg2MH0.wo5ufi7udRjQbHjIqxqpYlJ4a4nMVIV2C6W_LJdbA04', 'admin1', '9090909090', null, '04-02-2023', 'viduyaembel12@gmail.com', 'user4', '12', '2', 'user4', '08-02-2023 10:27:38', 'oragnization', '$2a$12$LX3O9Ci9B4L6MYRepC9yi.MPU9v8JDTk1awQ6CYR.NUTbGIB10hfu', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyNCIsImF1ZCI6IlJlZnJlc2giLCJpYXQiOjE2NzU4MzIyNjAsImV4cCI6MTY3NTkxODY2MH0.2HROm3X9o0nFYdsP6kJp1ap6Z8Z554dFGdLb1n-DGAA', null, 'user', 'user4');
INSERT INTO `employee_details` VALUES ('4', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOltdLCJpYXQiOjE2ODQ0NzgxNTAsImV4cCI6MTY4NDQ4MTc1MH0.vyOg1Th0UIHz2qRJM_w12agHSzP--22H80RYuckRWbY', 'None', '9090909090', null, '06-03-2023', 'admin@gmail.com', 'admin', '0', '4', 'admin', '2023-05-19 12:05:49', 'Embel Technologies', '$2a$12$7zkVCP4h83GYk2naBPAfnunh8CkgwSBV.CrSwjB4nSmDUCNQmKL9W', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZCI6IlJlZnJlc2giLCJpYXQiOjE2ODQ0NzgxNTAsImV4cCI6MTY4NDU2NDU1MH0.gP9n3OpYpszk6xUn3wohUNjg1fqrmKit6FV-6QiPsZg', null, 'admin', 'admin');
INSERT INTO `employee_details` VALUES ('5', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTdXBlcmFkbWluIiwiYXV0aCI6W10sImlhdCI6MTY4MzYxMzAzMiwiZXhwIjoxNjgzNjE2NjMyfQ.dDRJ2RmzPaSi65eZI8eDJ7DM5Z60yVIPyRBV4yGFv0Y', 'Suraj', '9284688780', null, '25-04-2023', 'superadmin@gmail.com', 'Superadmin', '1', '1', 'Manager', '2023-05-09 11:47:10', 'Embel Technologies', '$2a$12$bSJI9yrs9YR4UdX0/Tzmr.1vQddzAZlbSljoByB0fypDGVIyd5sfK', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJTdXBlcmFkbWluIiwiYXVkIjoiUmVmcmVzaCIsImlhdCI6MTY4MzYxMzAzMiwiZXhwIjoxNjgzNjk5NDMyfQ.Fn63jltdH7Vnnev7J6DmyWVgYEwjt16grVcCwksAxpM', null, 'super-admin', 'Superadmin');

-- ----------------------------
-- Table structure for employee_payment
-- ----------------------------
DROP TABLE IF EXISTS `employee_payment`;
CREATE TABLE `employee_payment` (
  `pk_employee_payment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountant_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_employee_id` bigint(20) DEFAULT NULL,
  `fk_organization_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `organization_name` varchar(255) DEFAULT NULL,
  `paid_amount` double DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_employee_payment_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of employee_payment
-- ----------------------------

-- ----------------------------
-- Table structure for expenditure_details
-- ----------------------------
DROP TABLE IF EXISTS `expenditure_details`;
CREATE TABLE `expenditure_details` (
  `pk_expenditure_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expenditure_amount` double DEFAULT NULL,
  `expenditure_name` varchar(255) DEFAULT NULL,
  `expenditure_type` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_expenditure_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of expenditure_details
-- ----------------------------
INSERT INTO `expenditure_details` VALUES ('1', 'admin', 'admin(admin)', '14-04-2023', ' tasty cold coffee', '567', 'coffee', 'Direct', '3', '1', '1', 'oragnization', 'Embel Technologies');
INSERT INTO `expenditure_details` VALUES ('2', 'admin', 'admin(admin)', '14-04-2023', ' tasty cold coffee', '567', 'coffee', 'Direct', '3', '1', '1', 'oragnization', 'Embel Technologies');

-- ----------------------------
-- Table structure for expenditure_payment
-- ----------------------------
DROP TABLE IF EXISTS `expenditure_payment`;
CREATE TABLE `expenditure_payment` (
  `pk_expenditurepayment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountant_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `expenditure_name` varchar(255) DEFAULT NULL,
  `expense_type` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_expense_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `service_provider` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `card` double DEFAULT NULL,
  `cash` double DEFAULT NULL,
  `upi` double DEFAULT NULL,
  PRIMARY KEY (`pk_expenditurepayment_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of expenditure_payment
-- ----------------------------
INSERT INTO `expenditure_payment` VALUES ('1', 'vvvvv', 'admin', '8888888888', 'admin(admin)', '22-04-2023', 'payment', 'water', 'direct', '3', '1', '1', '2', 'oragnization', '22-04-2023', 'cash', 'cash', 'vinay', 'Embel Technologies', '100', '1', null, null, null);
INSERT INTO `expenditure_payment` VALUES ('2', 'vvvvv', 'admin', '8888888888', 'admin(admin)', '22-04-2023', 'payment', 'water', 'direct', '3', '1', '1', '2', 'oragnization', '22-04-2023', 'cash', 'cash', 'vinay', 'Embel Technologies', '100', '1', null, null, null);
INSERT INTO `expenditure_payment` VALUES ('3', 'vvvvv', 'admin', '8888888888', 'admin(admin)', '24-04-2023', 'payment', 'water', 'direct', '3', '1', '1', '2', 'oragnization', '24-04-2023', 'cash', 'cash', 'vinay', 'Embel Technologies', '100', '1', null, null, null);
INSERT INTO `expenditure_payment` VALUES ('4', 'vvvvv', 'admin', '8888888888', 'admin(admin)', '24-04-2023', 'payment', 'water', 'direct', '3', '1', '1', '2', 'oragnization', '24-04-2023', 'cash', 'cash', 'vinay', 'Embel Technologies', '100', '1', '48', '125', '45');

-- ----------------------------
-- Table structure for godown_entry
-- ----------------------------
DROP TABLE IF EXISTS `godown_entry`;
CREATE TABLE `godown_entry` (
  `pk_godown_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_organization_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `godown_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_godown_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of godown_entry
-- ----------------------------
INSERT INTO `godown_entry` VALUES ('1', 'oragnization(oragnization)', '14-04-2023', '3', '2', '2', 'EMBEL Technologies-default', 'EMBEL Technologies');

-- ----------------------------
-- Table structure for good_receive
-- ----------------------------
DROP TABLE IF EXISTS `good_receive`;
CREATE TABLE `good_receive` (
  `pk_good_receive_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `barcode_number` varchar(255) DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `bill_no` varchar(255) DEFAULT NULL,
  `buy_price_excluding_tax` double NOT NULL,
  `buy_price_including_tax` double DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_cat_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_purchase_order_id` bigint(20) DEFAULT NULL,
  `fk_purchase_quotation_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcat_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `gst_for_expense` double DEFAULT NULL,
  `hsn_or_sac` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `labour_expense` double DEFAULT NULL,
  `manufacture_date` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `packing_type` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `po_no` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `quotation_no` bigint(20) DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `transport_expense` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `good_receive_date` varchar(255) DEFAULT NULL,
  `pay_due_date` varchar(255) DEFAULT NULL,
  `roll_size` double DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `total_quantity` double DEFAULT NULL,
  `total_tax_amount` double DEFAULT NULL,
  `good_receive_number` bigint(20) DEFAULT NULL,
  `supplier_payment` double DEFAULT NULL,
  PRIMARY KEY (`pk_good_receive_id`,`buy_price_excluding_tax`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of good_receive
-- ----------------------------
INSERT INTO `good_receive` VALUES ('1', 'John', '1000', '1234', '001', '700', '800', 'Electronics', '6', null, 'Samsung', 'admin(admin)', '2023-05-10', '50', '250', '2024-04-01', '4', '3', '4', '4', '4', '4', '4', '4', '3', '3800', '5', '1234', '0', '20', '2023-04-01', '1200', 'Tech Solutions', null, 'Samsung Galaxy S11', '4', '5', '4', '1000', '6', 'TechHub', null, 'Smartphones', 'John Doe', '300', '12', '3800', '3500', '15', 'pcs', '400', '555-555-5555', null, null, '0', 'Smartphone', '5', '300', '0', '3800');
INSERT INTO `good_receive` VALUES ('2', 'John', '1001', '1234', '001', '700', '800', 'Electronics', '6', null, 'Samsung', 'admin(admin)', '2023-05-10', '50', '250', '2024-04-01', '4', '3', '4', '4', '4', '4', '4', '4', '3', '3800', '5', '1234', '0', '20', '2023-04-01', '1200', 'Tech Solutions', null, 'Samsung Galaxy S21', '4', '5', '4', '1000', '6', 'TechHub', null, 'Smartphones', 'John Doe', '300', '12', '3800', '3500', '15', 'pcs', '400', '555-555-5555', null, null, '0', 'Smartphone', '5', '300', '0', '3800');
INSERT INTO `good_receive` VALUES ('3', 'John', '1003', '1234', '001', '700', '800', 'Electronics', '6', null, 'Samsung', 'admin(admin)', '2023-05-10', '50', '250', '2024-04-01', '4', '3', '3', '4', '4', '4', '4', '4', '3', '3800', '5', '1234', '0', '20', '2023-04-01', '1200', 'Tech Solutions', null, 'Samsung Galaxy S11', '4', '5', '4', '1000', '6', 'TechHub', null, 'Smartphones', 'John Doe', '300', '12', '3800', '3500', '15', 'pcs', '400', '555-555-5555', null, null, '0', 'Smartphone', '5', '300', '0', '3800');
INSERT INTO `good_receive` VALUES ('4', 'John', '1031', '1234', '001', '700', '800', 'Electronics', '6', null, 'Samsung', 'admin(admin)', '2023-05-10', '50', '250', '2024-04-01', '4', '3', '4', '4', '4', '4', '4', '4', '3', '3800', '5', '1234', '0', '20', '2023-04-01', '1200', 'Tech Solutions', null, 'Samsung Galaxy S21', '4', '5', '4', '1000', '6', 'TechHub', null, 'Smartphones', 'John Doe', '300', '12', '3800', '3500', '15', 'pcs', '400', '555-555-5555', null, null, '0', 'Smartphone', '5', '300', '0', '3800');

-- ----------------------------
-- Table structure for login_history
-- ----------------------------
DROP TABLE IF EXISTS `login_history`;
CREATE TABLE `login_history` (
  `pkid` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pkid`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=FIXED;

-- ----------------------------
-- Records of login_history
-- ----------------------------

-- ----------------------------
-- Table structure for product_details
-- ----------------------------
DROP TABLE IF EXISTS `product_details`;
CREATE TABLE `product_details` (
  `pk_product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `buy_price_including_tax` double DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `discription` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_tax_id` bigint(20) DEFAULT NULL,
  `fk_unit_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `hsn_code` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `is_barcode_product` varchar(255) DEFAULT NULL,
  `manufacture_company` varchar(255) DEFAULT NULL,
  `model_name` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `purchase_discount` double DEFAULT NULL,
  `roll_size` double DEFAULT NULL,
  `sale_discount` double DEFAULT NULL,
  `sale_price_including_tax` double DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `tax` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `unit_quantity` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`pk_product_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of product_details
-- ----------------------------
INSERT INTO `product_details` VALUES ('1', 'John Smith', '1200', 'Mens', '6', 'Black', 'admin(admin)', '05-05-2023', 'A sleek black dress shirt with a regular fit design.', '3', '1', '1', '1', '0', '1', '2', '1234', '0', 'https://example.com/black-dress-shirt.jpg', 'Y', 'XYZ Company', 'N/A', '3000', 'XYZ Company', 'Black Dress Shirt', '80', '0', '200', '2500', '6', 'XYZ Store', 'L', 'Regular Fit', 'Shirts', '0', 'Piece', '1', '0');
INSERT INTO `product_details` VALUES ('2', 'John Smith', '1000', 'Mens', '6', 'Blue', 'admin(admin)', '05-05-2023', 'A classic blue striped shirt with a slim fit design.', '3', '1', '1', '1', '0', '1', '2', '1234', '0', 'https://example.com/blue-striped-shirt.jpg', 'Y', 'ABC Company', 'N/A', '2500', 'ABC Company', 'Blue Striped Shirt', '50', '0', '100', '2000', '6', 'XYZ Store', 'M', 'Slim Fit', 'Shirts', '0', 'Piece', '1', '0');
INSERT INTO `product_details` VALUES ('3', 'John Smith', '900', 'Mens', '6', 'Green', 'admin(admin)', '05-05-2023', 'A stylish green plaid shirt with a regular fit design.', '3', '1', '1', '1', '0', '1', '2', '1234', '0', 'https://example.com/green-plaid-shirt.jpg', 'Y', 'ABC Company', 'N/A', '2200', 'ABC Company', 'Green Plaid Shirt', '70', '0', '150', '1800', '6', 'XYZ Store', 'L', 'Regular Fit', 'Shirts', '0', 'Piece', '1', '0');
INSERT INTO `product_details` VALUES ('4', 'John Smith', '1100', 'Mens', '6', 'White', 'admin(admin)', '05-05-2023', 'A classic white oxford shirt with a slim fit design.', '3', '1', '1', '1', '0', '1', '2', '1234', '0', 'https://example.com/white-oxford-shirt.jpg', 'Y', 'XYZ Company', 'N/A', '2800', 'XYZ Company', 'White Oxford Shirt', '60', '0', '180', '2400', '6', 'XYZ Store', 'M', 'Slim Fit', 'Shirts', '0', 'Piece', '1', '0');
INSERT INTO `product_details` VALUES ('5', 'admin', '500', 'Mens', '5', 'White', 'admin(admin)', '05-05-2023', 'Comfortable plain white T-shirt', '3', '1', '1', '2', '0', '1', '2', '1234', '0', 'https://example.com/plain_white_tshirt.jpg', 'Y', 'Nike', 'N/A', '1000', 'Fashion Hub', 'Plain White T-Shirt', '100', '0', '200', '800', '5', 'Fashion Hub', 'L', 'Round neck', 'T-Shirts', '0', 'pcs', '1', '0');
INSERT INTO `product_details` VALUES ('6', 'admin', '750', 'Mens', '5', 'Black', 'admin(admin)', '05-05-2023', 'Stylish black T-shirt with a printed design', '3', '1', '1', '2', '0', '1', '2', '1234', '0', 'https://example.com/printed_black_tshirt.jpg', 'Y', 'Adidas', 'N/A', '1500', 'Fashion Hub', 'Printed Black T-Shirt', '150', '0', '250', '1200', '5', 'Fashion Hub', 'M', 'V-neck', 'T-Shirts', '0', 'pcs', '1', '0');

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
  `pk_purchase_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `barcode_number` varchar(255) DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `buy_price_excluding_tax` double DEFAULT NULL,
  `buy_price_including_tax` double DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_purchase_quotation_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `hsn_or_sacc` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `labour_expense` double DEFAULT NULL,
  `manufacturing_date` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `pay_due_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `purchase_order_date` varchar(255) DEFAULT NULL,
  `purchase_order_number` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `quotation_number` bigint(20) DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `transport_expense` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `roll_size` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `total_quantity` double DEFAULT NULL,
  `total_tax_amount` double DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_purchase_order_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for purchase_quotation
-- ----------------------------
DROP TABLE IF EXISTS `purchase_quotation`;
CREATE TABLE `purchase_quotation` (
  `pk_purchase_quotation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `barcode_no` varchar(255) DEFAULT NULL,
  `buy_price_including_tax` double DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `discount_percentage` double DEFAULT NULL,
  `supplier_email_id` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `hsn_or_sacc` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `labour_expence` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `quotation_date` varchar(255) DEFAULT NULL,
  `quotation_number` bigint(20) DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `sub_category_name` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `transport_expence` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `total_quantity` double DEFAULT NULL,
  `total_tax_amount` double DEFAULT NULL,
  `roll_size` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `buy_price_excluding_tax` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_purchase_quotation_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of purchase_quotation
-- ----------------------------

-- ----------------------------
-- Table structure for purchase_return
-- ----------------------------
DROP TABLE IF EXISTS `purchase_return`;
CREATE TABLE `purchase_return` (
  `purchase_return_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `barcode_number` varchar(255) DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `bill_no` varchar(255) DEFAULT NULL,
  `buy_price` double DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_cat_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcat_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `manufacture_date` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `purchase_return_no` bigint(20) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `return_quantity` double DEFAULT NULL,
  `sale_price` double DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `sub_category_name` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `return_amount` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `buy_price_excluding_tax` double DEFAULT NULL,
  `buy_price_including_tax` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `fk_goodreceive_id` bigint(20) DEFAULT NULL,
  `good_receive_date` varchar(255) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `gst_for_expense` double DEFAULT NULL,
  `hsn_or_sac` varchar(255) DEFAULT NULL,
  `labour_expense` double DEFAULT NULL,
  `roll_size` double DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `style` varchar(255) DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `total_quantity` double DEFAULT NULL,
  `total_tax_amount` double DEFAULT NULL,
  `transport_expense` double DEFAULT NULL,
  PRIMARY KEY (`purchase_return_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of purchase_return
-- ----------------------------

-- ----------------------------
-- Table structure for sale_quotation
-- ----------------------------
DROP TABLE IF EXISTS `sale_quotation`;
CREATE TABLE `sale_quotation` (
  `pk_sale_quatation_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `barcode_no` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_cat_id` bigint(20) DEFAULT NULL,
  `fk_customer_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `fk_subcat_id` bigint(20) DEFAULT NULL,
  `gross_total` varchar(255) DEFAULT NULL,
  `gst_expense` varchar(255) DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `hsn_or_sacc` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `labour_expense` varchar(255) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quotation_date` varchar(255) DEFAULT NULL,
  `return_quantity` double DEFAULT NULL,
  `sale_price_excluding_tax` double DEFAULT NULL,
  `sale_price_including_tax` double DEFAULT NULL,
  `sale_quotation_no` bigint(20) DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `transport_expense` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `contact_no` bigint(20) DEFAULT NULL,
  `labour_tax_amount` double DEFAULT NULL,
  PRIMARY KEY (`pk_sale_quatation_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sale_quotation
-- ----------------------------

-- ----------------------------
-- Table structure for sale_return
-- ----------------------------
DROP TABLE IF EXISTS `sale_return`;
CREATE TABLE `sale_return` (
  `pk_sale_return_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `available_quantity` double DEFAULT NULL,
  `barcode_no` varchar(255) DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `bill_no` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `gross_total` double DEFAULT NULL,
  `hsn_or_sac_code` varchar(255) DEFAULT NULL,
  `igst` double DEFAULT NULL,
  `manufacture_date` varchar(255) DEFAULT NULL,
  `mrp` double DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `packing_type` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `return_date` varchar(255) DEFAULT NULL,
  `return_quantity` double DEFAULT NULL,
  `return_total` double DEFAULT NULL,
  `sale_price_excluding_tax` double DEFAULT NULL,
  `sale_price_including_tax` double DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `tax_percentage` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `total_excluding_tax` double DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`pk_sale_return_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sale_return
-- ----------------------------

-- ----------------------------
-- Table structure for shop_details
-- ----------------------------
DROP TABLE IF EXISTS `shop_details`;
CREATE TABLE `shop_details` (
  `pk_shop_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_logo` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_organization_id` bigint(20) DEFAULT NULL,
  `gst_no` varchar(255) DEFAULT NULL,
  `organization_name` varchar(255) DEFAULT NULL,
  `shop_address` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `shop_registration_date` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_shop_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of shop_details
-- ----------------------------
INSERT INTO `shop_details` VALUES ('1', 'hgdjkjgs', null, 'PUNE', '8888888888', null, '2', '43435', 'oragnization', 'warje1', 'EMBEL Technologies', '14-04-2023', 'cloth');
INSERT INTO `shop_details` VALUES ('2', 'hgdjkjgs', null, 'PUNE', '8888888888', null, '2', '43435', 'oragnization', 'warje1', 'EMBEL Technologies', '14-04-2023', 'cloth');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `pk_stock_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manufacture_date` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `available_quantity` double DEFAULT NULL,
  `batch_number` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `expiry_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_product_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_subcategory_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `packing_type` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `fk_godown_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_stock_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '2023-04-01', 'Smartphones', 'John', '70', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('2', '2023-04-01', 'Smartphones', 'John', '65', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('3', '2023-04-01', 'Smartphones', 'John', '60', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('4', '2023-04-01', 'Smartphones', 'John', '60', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('5', '2023-04-01', 'Smartphones', 'John', '55', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('6', '2023-04-01', 'Smartphones', 'John', '55', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('7', '2023-04-01', 'Smartphones', 'John', '50', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('8', '2023-04-01', 'Smartphones', 'John', '50', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('9', '2023-04-01', 'Smartphones', 'John', '45', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('10', '2023-04-01', 'Smartphones', 'John', '45', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('11', '2023-04-01', 'Smartphones', 'John', '40', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('12', '2023-04-01', 'Smartphones', 'John', '40', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('13', '2023-04-01', 'Smartphones', 'John', '35', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('14', '2023-04-01', 'Smartphones', 'John', '35', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('15', '2023-04-01', 'Smartphones', 'John', '30', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('16', '2023-04-01', 'Smartphones', 'John', '30', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('17', '2023-04-01', 'Smartphones', 'John', '25', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('18', '2023-04-01', 'Smartphones', 'John', '10', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('19', '2023-04-01', 'Smartphones', 'John', '10', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('20', '2023-04-01', 'Smartphones', 'John', '5', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '3', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S11', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);
INSERT INTO `stock` VALUES ('21', '2023-04-01', 'Smartphones', 'John', '5', '1234', 'Electronics', 'Samsung', 'admin(admin)', '2023-05-10', '2024-04-01', '4', '4', '4', '4', '3', '3', 'Tech Solutions', 'unpacked', 'Samsung Galaxy S21', '5', 'TechHub', 'pcs', '2023-05-10', '400', null);

-- ----------------------------
-- Table structure for stock_excel_report_download_count
-- ----------------------------
DROP TABLE IF EXISTS `stock_excel_report_download_count`;
CREATE TABLE `stock_excel_report_download_count` (
  `pk_download_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `download_count` bigint(20) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `fk_user_id` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_download_id`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of stock_excel_report_download_count
-- ----------------------------

-- ----------------------------
-- Table structure for subcategory_details
-- ----------------------------
DROP TABLE IF EXISTS `subcategory_details`;
CREATE TABLE `subcategory_details` (
  `pk_subcategory_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_category_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `subcategory_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_subcategory_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of subcategory_details
-- ----------------------------
INSERT INTO `subcategory_details` VALUES ('1', 'admin1', 'grocerry', 'Mens', 'oragnization(oragnization)', '05-05-2023', '3', '1', '2', '1', 'oragnization', 'Embel', 'T-Shirts');
INSERT INTO `subcategory_details` VALUES ('2', 'admin1', 'grocerry', 'Mens', 'oragnization(oragnization)', '05-05-2023', '3', '1', '2', '1', 'oragnization', 'Embel', 'Shirts');
INSERT INTO `subcategory_details` VALUES ('3', 'admin1', 'grocerry', 'Mens', 'oragnization(oragnization)', '05-05-2023', '3', '1', '2', '1', 'oragnization', 'Embel', 'Jeans');
INSERT INTO `subcategory_details` VALUES ('4', 'admin1', 'grocerry', 'Womens', 'oragnization(oragnization)', '05-05-2023', '3', '2', '2', '1', 'oragnization', 'Embel', 'Top');
INSERT INTO `subcategory_details` VALUES ('5', 'admin1', 'grocerry', 'Womens', 'oragnization(oragnization)', '05-05-2023', '3', '2', '2', '1', 'oragnization', 'Embel', 'Kurti');

-- ----------------------------
-- Table structure for supplier_details
-- ----------------------------
DROP TABLE IF EXISTS `supplier_details`;
CREATE TABLE `supplier_details` (
  `pk_suppplier_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_holder_name` varchar(255) DEFAULT NULL,
  `account_no` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `alternate_number` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `gst_or_tin_no` varchar(255) DEFAULT NULL,
  `ifsc_no` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `opening_balance` varchar(255) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `upi_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_suppplier_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplier_details
-- ----------------------------
INSERT INTO `supplier_details` VALUES ('1', 'vvvvv', '95863248632156', 'karvenagar', 'admin', '95863248632156', 'pune', '9999999999', null, '14-04-2023', 'vidyaembel@gmail.com', 'vidya', '3', '1', '2', '1234', '1111111111111', 'gawade', '1000', 'oragnization', 'nikhil nalawade', 'Embel Technologies', '8989089890');

-- ----------------------------
-- Table structure for supplier_payment
-- ----------------------------
DROP TABLE IF EXISTS `supplier_payment`;
CREATE TABLE `supplier_payment` (
  `pk_supplier_payment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) DEFAULT NULL,
  `accountant_name` varchar(255) DEFAULT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `balance_amount` double DEFAULT NULL,
  `bill_no` bigint(20) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_supplier_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `payment_amount` double DEFAULT NULL,
  `payment_date` varchar(255) DEFAULT NULL,
  `payment_mode` varchar(255) DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `receipt_no` bigint(20) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `transcation_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk_supplier_payment_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of supplier_payment
-- ----------------------------
INSERT INTO `supplier_payment` VALUES ('1', 'Embel Technologies', 'vvvvv', 'admin', '120', '1', 'admin(admin)', '19-04-2023', 'payment', '3', '1', '1', '2', 'oragnization', '100', '19-04-2023', 'cash', 'cash', '1', 'Embel Technologies', '200', '1');

-- ----------------------------
-- Table structure for tax_details
-- ----------------------------
DROP TABLE IF EXISTS `tax_details`;
CREATE TABLE `tax_details` (
  `pk_tax_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `cgst` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `percentage` varchar(255) DEFAULT NULL,
  `sgst` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `tax_name` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_tax_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tax_details
-- ----------------------------
INSERT INTO `tax_details` VALUES ('1', 'admin', '2.5', 'admin(admin)', '14-04-2023', '3', '1', '2', 'oragnization', '5', '2.5', 'Embel Technologies', 'GST5', null);

-- ----------------------------
-- Table structure for unit_details
-- ----------------------------
DROP TABLE IF EXISTS `unit_details`;
CREATE TABLE `unit_details` (
  `pk_unit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `fk_oragnization_id` bigint(20) DEFAULT NULL,
  `oragnization_name` varchar(255) DEFAULT NULL,
  `shop_name` varchar(255) DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `unit_value` varchar(255) DEFAULT NULL,
  `business_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk_unit_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of unit_details
-- ----------------------------
INSERT INTO `unit_details` VALUES ('1', 'admin', 'admin(admin)', '14-04-2023', 'kilogram', '3', '1', '1', 'oragnization', 'Embel Technologies', 'kg', '1.00', null);

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `pkid` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_date` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `fk_admin_id` bigint(20) DEFAULT NULL,
  `fk_organization_id` bigint(20) DEFAULT NULL,
  `fk_shop_id` bigint(20) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `login_time` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `refresh_token` varchar(255) DEFAULT NULL,
  `reset_password_token` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `validity_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pkid`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES ('1', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluIiwiYXV0aCI6W10sImlhdCI6MTY4MjQwNDYyMSwiZXhwIjoxNjgyNDA4MjIxfQ.T43JZaQgiCLYjz7pHQzd5U2pQz-ba1djMjKHF77nwPs', '1234567895', null, '04-02-2023', 'superadmin@gmail.com', 'superadmin', null, null, null, 'superadmin', '25-04-2023 12:06:59', '$2a$12$ASX65/0ETHFFCCNIafLaveKbkrc6Vog/dYMrnEFgLDO.gbMYXXiN6', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdXBlcmFkbWluIiwiYXVkIjoiUmVmcmVzaCIsImlhdCI6MTY4MjQwNDYyMiwiZXhwIjoxNjgyNDkxMDIyfQ.OyV5RyU5nKZOs6sEVMFntjFFJK5Ztc8lrDnEoeu9-MQ', null, 'super-admin', 'active', 'superadmin', null);
INSERT INTO `user_details` VALUES ('2', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvcmFnbml6YXRpb24iLCJhdXRoIjpbXSwiaWF0IjoxNjc2ODg0NDAzLCJleHAiOjE2NzY4ODgwMDN9.ZoLXudSwk7kGwNpMTyp7yaOaBNMoBpD7noyMqVFtWp0', '1234567895', null, '04-02-2023', 'oragnization@gmail.com', 'oragnization', null, null, null, 'oragnization', '20-02-2023 14:43:22', '$2a$12$5ZVfRed6cNzgn33Xy2cNpuzO/2fIWToYN1DUFgWG7QXz7bUESgIJi', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvcmFnbml6YXRpb24iLCJhdWQiOiJSZWZyZXNoIiwiaWF0IjoxNjc2ODg0NDAzLCJleHAiOjE2NzY5NzA4MDN9.WgMyWSMXgtCeia3Oiv6DNl0GAtQUwsswEmKKpiKzh1g', null, 'oragnization', 'active', 'oragnization', null);
INSERT INTO `user_details` VALUES ('3', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOltdLCJpYXQiOjE2Nzc1NjA1ODcsImV4cCI6MTY3NzU2NDE4N30.xotzP_cDWn0KOY-dupyuQoQwSKYC8S2cLk6Y52CP2M0', '1234567895', null, '04-02-2023', 'admin@gmail.com', 'admin', null, null, null, 'admin', '28-02-2023 10:30:04', '$2a$12$GhfhW067GN8qhAPSO8ksbOqoK6xJ7Pp4ysPcLXo8qUJRrromNWupm', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZCI6IlJlZnJlc2giLCJpYXQiOjE2Nzc1NjA1OTMsImV4cCI6MTY3NzY0Njk5M30.QgbiRhQDwf5IXKVdXkDGe8An3kohrQ-XkNZ1tGMlgo4', null, 'admin', 'active', 'admin', null);
INSERT INTO `user_details` VALUES ('14', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjIiLCJhdXRoIjpbXSwiaWF0IjoxNjc2ODg0MDk0LCJleHAiOjE2NzY4ODc2OTR9.imM8saZV4wA8k8xVt3qeKIvlspbLFw1Gwvkm0YTWo0c', '1234567895', null, '04-02-2023', 'admin2@gmail.com', 'admin2', null, null, null, 'admin2', '20-02-2023 14:38:14', '$2a$12$fc70ZuhMmr/aA.kj641KV.iBvNjuWNH9WYRItGLDNgQVxa6MHzJE6', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjIiLCJhdWQiOiJSZWZyZXNoIiwiaWF0IjoxNjc2ODg0MDk0LCJleHAiOjE2NzY5NzA0OTR9.QRYid3bQmiuEykx8-IXd8_guzt9GgHEt0z-9HF0TzlA', null, 'admin', 'active', 'admin2', null);
INSERT INTO `user_details` VALUES ('12', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEiLCJhdXRoIjpbXSwiaWF0IjoxNjc2ODg0MzEwLCJleHAiOjE2NzY4ODc5MTB9.2lOxo86dmBlKmuP_bFaV9G-z7ZjzhirEfY-bBX9Gbh0', '1234567895', null, '04-02-2023', 'admin1@gmail.com', 'admin1', null, '2', '1', 'admin1', '20-02-2023 14:41:50', '$2a$12$HfYUEv0WWpGIC6K67zj3kepteqzML0qzraIdB2jkjxYaDdBgW8q4y', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEiLCJhdWQiOiJSZWZyZXNoIiwiaWF0IjoxNjc2ODg0MzEwLCJleHAiOjE2NzY5NzA3MTB9.4A-0_pxEFQBMULzF8V0CNk12AJh-1WqvZ91hETy-68w', null, 'admin', 'active', 'admin1', null);
INSERT INTO `user_details` VALUES ('15', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBdGhhckAxMjMiLCJhdXRoIjpbXSwiaWF0IjoxNjc2MDI4MDU4LCJleHAiOjE2NzYwMzE2NTh9.GyzHTIWcBYIx6NY6upCyCg200amQ34UTKtEazbPH0ik', '9284688780', null, '10-02-2023', 'atharvaembel@gmail.com', 'atharva', null, null, null, 'atharva', '10-02-2023 16:50:57', '$2a$12$fwjjlPbsdELFUAs2zfxU4OcuEjP.lMGIByWVxwKWcDnlnYobzf9By', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBdGhhckAxMjMiLCJhdWQiOiJSZWZyZXNoIiwiaWF0IjoxNjc2MDI4MDU4LCJleHAiOjE2NzYxMTQ0NTh9.K7kxkLlOvV0Ht9kyvfc5EAxkKU_egpUW1P4rt1-ve8k', '6CFraRzD1rRM3YEZzyk0BmsqolOVuH', 'admin', 'active', 'Athar@123', '10-03-2023');
