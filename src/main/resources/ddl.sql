-- 用户表
CREATE TABLE `dianpingdb`.`user`  (
  `id` int(0) NOT NULL,
  `created_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `telephone` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT null,
  `nick_name` varchar(40) NULL DEFAULT '',
  `gender` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telephone_unique_index`(`telephone`) USING BTREE
);



-- 商家表
CREATE TABLE `dianpingdb`.`seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '',
  `created_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `disabled_flag` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
);

-- 分类表
CREATE TABLE `category` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品类ID',
    `created_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '创建时间',
    `updated_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '更新时间',
    `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品/分类名称',
    `icon_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'icon图标',
    `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_unique_index` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='品类表';

--
CREATE TABLE `dianpingdb`.`shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `name` varchar(80) NOT NULL DEFAULT '',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `price_per_man` int(0) NOT NULL DEFAULT 0,
  `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `category_id` int(0) NOT NULL DEFAULT 0,
  `tags` varchar(2000) NOT NULL DEFAULT '',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '',
  `seller_id` int(0) NOT NULL DEFAULT 0,
  `icon_url` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);
