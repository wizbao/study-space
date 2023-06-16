CREATE TABLE `user`
(
    `id`       bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username` varchar(50)  NOT NULL DEFAULT '' COMMENT '用户名',
    `password` varchar(255) NOT NULL COMMENT '用户密码',
    `remark`   varchar(50)           DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`id`)
)