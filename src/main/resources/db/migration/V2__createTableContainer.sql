create table if not exists containers
(
    id                 bigint primary key        not null auto_increment,
    number             varchar(11)               not null,
    container_type     enum ('TWENTY', 'FORTY')  not null,
    container_status   enum ('FULL', 'EMPTY')    not null,
    container_category enum ('IMPORT', 'EXPORT') not null,
    client_id          bigint                    not null,
    foreign key (client_id) references clients (id)

) ENGINE = INNODB;