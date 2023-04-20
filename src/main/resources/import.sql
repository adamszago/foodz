insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Japonesa');
insert into cozinha (nome) values ('Indiana');

insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Distrito Federal');

insert into cidade (nome, estado_id) values ('Brasilia', 4);
insert into cidade (nome, estado_id) values ('Niterói', 3);
insert into cidade (nome, estado_id) values ('Uberlândia', 1);
insert into cidade (nome, estado_id) values ('Araguari', 1);
insert into cidade (nome, estado_id) values ('Campinas', 2);

insert into restaurante (nome, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_cidade_id, data_cadastro, data_atualizacao) values ('Aconchego Mineiro', 10.0, 1, '38.408-294', 'Rua Patrulheiro OSmar Tavares', '1682', 'apto 202', 3, '2023-04-12 14.07.00', '2023-04-12 14.07.00');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Bom Apetite', 12.0, 2, '2023-04-12 14.07.00', '2023-04-12 14.07.00');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tuk Tuk', 0, 3, '2023-04-12 14.07.00', '2023-04-12 14.07.00');

insert into produto (nome, preco, ativo, restaurante_id) values ('Macchiato', 7.9, true, 1);
insert into produto (nome, preco, ativo, restaurante_id) values ('Cappucino', 6.9, true, 1);
insert into produto (nome, preco, ativo, restaurante_id) values ('Frango com curry', 26, true, 3);
insert into produto (nome, preco, ativo, restaurante_id) values ('Arroz grego', 12.9, true, 2);
insert into produto (nome, preco, ativo, restaurante_id) values ('Churrasco', 35.8, true, 2);
insert into produto (nome, preco, ativo, restaurante_id) values ('Lasanha', 23, true, 2);
insert into produto (nome, preco, ativo, restaurante_id) values ('Mexidão', 16.7, true, 2);
insert into produto (nome, preco, ativo, restaurante_id) values ('Expresso duplo', 4.5, true, 1);

insert into forma_pagamento (descricao) values ('À Vista Crédito');
insert into forma_pagamento (descricao) values ('PIX');
insert into forma_pagamento (descricao) values ('Parcelado Crédito');
insert into forma_pagamento (descricao) values ('Cartão Débito');

insert into permissao (nome, descricao) values ('Admin', 'Permissão de Administrador');
insert into permissao (nome, descricao) values ('Colaborador', 'Permissão de Colaborador');

insert into Grupo (nome) values ('Gerente');
insert into Grupo (nome) values ('Cozinheiro');
insert into Grupo (nome) values ('Financeiro');

insert into usuario (nome, email, senha, data_cadastro) values ('Adams Zago', 'awzago@gmail.com', '123', '2023-04-17 14.07.00');
insert into usuario (nome, email, senha, data_cadastro) values ('Jesebel Caixeta', 'jesebelfisio@gmail.com', '456', '2023-04-17 14.07.00');
insert into usuario (nome, email, senha, data_Cadastro) values ('Davi Ribeiro Zago', 'davirz@hotmail.com', '789', '2023-04-17 14.07.00');

insert into grupo_permissao(grupo_id, permissao_id) values (1,1), (2,2), (3,2);

insert into usuario_grupo(usuario_id, grupo_id) values (1,1), (2,3), (3,2);

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (1, 1), (1, 2), (1, 3), (2, 3), (3, 1), (3, 3)
