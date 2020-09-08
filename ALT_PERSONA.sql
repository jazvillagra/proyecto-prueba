alter table persona
	add nro_documento varchar(50) not null;

alter table persona
	add tipo_documento varchar(5) not null;

alter table persona
	add nacionalidad varchar(50);

alter table persona
	add email varchar(50);

alter table persona
	add telefono varchar(50);

alter table persona
	add fecha_nacimiento date not null;

create unique index persona_nro_documento_uindex
	on persona (nro_documento);

