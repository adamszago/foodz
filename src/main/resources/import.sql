insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Japonesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Aconchego Mineiro', 10.0, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bom Apetite', 12.0, 2);

insert into forma_pagamento (descricao) values ('À Vista Crédito');
insert into forma_pagamento (descricao) values ('PIX');
insert into forma_pagamento (descricao) values ('Parcelado Crédito');
insert into forma_pagamento (descricao) values ('Cartão Débito');

insert into permissao (nome, descricao) values ('Admin', 'Permissão de Administrador');

insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Distrito Federal');

insert into cidade (nome, estado_id) values ('Brasilia', 4);
insert into cidade (nome, estado_id) values ('Niterói', 3);
insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Araguari', 1);
insert into cidade (nome, estado_id) values ('Campinas', 2);
