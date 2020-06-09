-- 用户表
CREATE TABLE `dianping_db`.`user` (
    `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `telephone` varchar(40) NOT NULL DEFAULT '' COMMENT '手机号',
    `password` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
    `nick_name` varchar(40) DEFAULT '' COMMENT '昵称',
    `gender` int(11) DEFAULT '0' COMMENT '性别',
    `created_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '创建时间',
    `updated_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `telephone_unique_index` (`telephone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 商家表
CREATE TABLE `dianping_db`.`seller` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(80) NOT NULL DEFAULT '' COMMENT '商家名',
  `created_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '创建时间',
  `updated_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '更新时间',
  `remark_score` decimal(2,1) NOT NULL DEFAULT '0.0' COMMENT '评分',
  `disabled_flag` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商家表';


-- 分类表
CREATE TABLE `dianping_db`.`category` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '品类ID',
    `created_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '创建时间',
    `updated_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '更新时间',
    `name` varchar(20) NOT NULL DEFAULT '' COMMENT '品/分类名称',
    `icon_url` varchar(200) NOT NULL DEFAULT '' COMMENT 'icon图标',
    `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_unique_index` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='品类表';


-- 店铺表
CREATE TABLE `dianping_db`.`shop` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `name` varchar(80) NOT NULL DEFAULT '' COMMENT '门店名',
    `remark_score` decimal(2,1) NOT NULL DEFAULT '0.0' COMMENT '评分',
    `price_per_man` int(11) NOT NULL DEFAULT '0' COMMENT '人均消费价',
    `latitude` decimal(10,6) NOT NULL DEFAULT '0.000000' COMMENT '纬度',
    `longitude` decimal(10,6) NOT NULL DEFAULT '0.000000' COMMENT '经度',
    `category_id` int(11) NOT NULL DEFAULT '0' COMMENT '分类ID',
    `tags` varchar(2000) NOT NULL DEFAULT '' COMMENT '标签',
    `start_time` varchar(200) NOT NULL DEFAULT '' COMMENT '营业开始时间',
    `end_time` varchar(200) NOT NULL DEFAULT '' COMMENT '营业结束时间',
    `address` varchar(200) NOT NULL DEFAULT '' COMMENT '地址',
    `seller_id` int(11) NOT NULL DEFAULT '0' COMMENT '商家ID',
    `icon_url` varchar(100) NOT NULL DEFAULT '' COMMENT '门店头像',
    `created_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '创建时间',
    `updated_at` datetime NOT NULL DEFAULT '2020-01-01 00:00:00' COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='店铺表';