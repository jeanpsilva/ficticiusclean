CREATE TABLE public.veiculos (
	id serial NOT NULL,
	nome varchar NOT NULL,
	marca varchar NOT NULL,
	modelo varchar NOT NULL,
	data_fabricacao date NOT NULL,
	consumo_medio_cidade numeric(10,2) NOT NULL,
	consumo_medio_rodovia numeric(10,2) NOT NULL,	
	
	CONSTRAINT veiculo_pk PRIMARY KEY (id)
);