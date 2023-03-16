insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Japonesa');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Aconchego Mineiro', 10.0, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bom Apetite', 12.0, 2);

insert into forma_pagamento (descricao) values ('À Vista Crédito');
insert into forma_pagamento (descricao) values ('PIX');
insert into forma_pagamento (descricao) values ('Parcelado Crédito');
insert into forma_pagamento (descricao) values ('Cartão Débito');

insert into permissao (nome, descricao) values ('Admin', 'Permissão de Administrador');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Rio de Janeiro');
insert into estado (id, nome) values (4, 'Distrito Federal');

insert into cidade (nome, estado_id) values ('Brasilia', 4);
insert into cidade (nome, estado_id) values ('Niterói', 3);
insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Araguari', 1);
insert into cidade (nome, estado_id) values ('Campinas', 2);
