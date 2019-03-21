create table bdoo.uf (
	id integer not null primary key,
	nome varchar(20),
	sigla char(2) not null
);

create table bdoo.municipio (
	id integer not null primary key,
	nome varchar(20) not null,
	id_uf integer not null,
	foreign key(id_uf) references bdoo.uf(id)	
);

create table bdoo.pessoa (
	id integer not null primary key,
	nome varchar(40) not null,
	id_municipio integer not null,
	foreign key(id_municipio) references bdoo.municipio(id)
);