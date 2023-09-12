create table if not exists movements (
    id              bigint primary key not null auto_increment,
    initial_date    DATETIME not null,
    finish_date     DATETIME,
    type_movement   enum ('SHIPPING', 'UNLOAD', 'GATE_IN', 'GATE_OUT', 'REPOSITIONING', 'IN_WEIGHING', 'OUT_WEIGHING', 'SCANNER', 'LOADING') not null,
    status_movement enum ('IN_PROGRESS', 'FINISHED') not null,
    container_id    bigint not null,
    foreign key (container_id) references containers (id)

) ENGINE = INNODB;