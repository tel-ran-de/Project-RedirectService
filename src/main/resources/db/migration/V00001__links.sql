CREATE TABLE IF NOT EXISTS `links`
(
    `url_id`    INT          NOT NULL AUTO_INCREMENT,
    `long_url`  VARCHAR(200) NOT NULL,
    `short_url` VARCHAR(45)  NOT NULL,
    PRIMARY KEY (`url_id`),
    UNIQUE INDEX `link_id_UNIQUE` (`url_id` ASC) VISIBLE
);
