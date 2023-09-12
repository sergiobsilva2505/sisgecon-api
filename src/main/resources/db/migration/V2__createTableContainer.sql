create table if not exists containers(
    id                 bigint primary key        not null auto_increment,
    number             varchar(11)               not null,
    type_container     enum ('TWENTY', 'FORTY')  not null,
    status_container   enum ('FULL', 'EMPTY')    not null,
    category_container enum ('IMPORT', 'EXPORT') not null,
    client_id          bigint                    not null,
    foreign key (client_id) references clients (id)

) ENGINE = INNODB;