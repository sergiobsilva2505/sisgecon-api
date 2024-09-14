create table if not exists clients
(
    id
    bigint
    primary
    key
    not
    null
    auto_increment,
    name
    varchar
(
    100
) not null,
    cnpj varchar
(
    14
) not null
    ) ENGINE=INNODB;