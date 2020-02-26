CREATE TABLE `dianpingdb`.`user`  (
  `id` int(0) NOT NULL,
  `create_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `update_at` datetime(0) NOT NULL DEFAULT '2020-01-01 00:00:00',
  `telphone` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT null,
  `nick_name` varchar(40) NULL DEFAULT '',
  `gender` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telphone_unique_index`(`telphone`) USING BTREE
);