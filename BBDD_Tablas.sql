create table Ninja(
	id_ninja int primary key auto_increment not null,
    nombre varchar(255) not null,
    rango varchar(255) not null,
    aldea varchar(255) not null
);

create table Mision(
	id_mision int primary key auto_increment not null,
    descripcion varchar(255) not null,
    rango varchar(255) not null,
    recompensa int not null
);

create table MisionNinja(
	id_mision_ninja int primary key auto_increment not null,
    fechaInicio date not null,
    fechaFin date not null,
    id_ninja int not null,
    id_mision int not null,
    foreign key(id_ninja) references Ninja(id_ninja),
    foreign key(id_mision) references Mision(id_mision)
);

create table Habilidad(
	id_hab_ninja int primary key auto_increment not null,
    nombre varchar(255) not null,
    descripcion varchar(255) not null,
    id_ninja int not null,
    foreign key(id_ninja) references Ninja(id_ninja)
);