-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Joao Silva',
    'joao123',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'joao@email.com',
    2,
    '123.456.789-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Maria Oliveira',
    'maria456',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'maria@email.com',
    2,
    '987.654.321-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Carlos Santos',
    'carlos789',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'carlos@email.com',
    2,
    '456.789.123-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Ana Pereira',
    'ana321',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'ana@email.com',
    1,
    '789.123.456-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Lucas Souza',
    'lucas654',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'lucas@email.com',
    2,
    '321.654.987-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Isabela Lima',
    'isabela987',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'isabela@email.com',
    1,
    '654.321.789-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Pedro Almeida',
    'pedro555',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'pedro@email.com',
    1,
    '987.789.654-00'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Mariana Costa',
    'mariana111',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'mariana@email.com',
    1,
    '111.222.333-44'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Felipe Rocha',
    'felipe222',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'felipe@email.com',
    1,
    '555.666.777-88'
  );
INSERT INTO usuario (nome, login, senha, email, perfil, cpf)
VALUES (
    'Laura Martins',
    'laura333',
    'UTD+AWUM7xWFkmQV+0A76Z1At65WUe0yNG+HC/zdRauqPtv5XBnBJywgdfg+vb2oRK5ddlpXjLPFJu8M2zf3Bw==',
    'laura@email.com',
    2,
    '999.888.777-66'
  );
insert into estado(nomeEstado, sigla)
values('Tocantins', 'TO');
insert into estado(nomeEstado, sigla)
values('Bahia', 'BA');
insert into cidade(nomeCidade, id_estado)
values('Palmas', 1);
insert into cidade(nomeCidade, id_estado)
values('Paraíso', 1);
insert into cidade(nomeCidade, id_estado)
values('Salvador', 2);
insert into endereco(
    cep,
    bairro,
    logradouro,
    numero,
    complemento,
    id_cidade
  )
values(
    '77006-020',
    '110 Norte',
    'alameda 15',
    25,
    'casa',
    1
  );
insert into endereco(
    cep,
    bairro,
    logradouro,
    numero,
    complemento,
    id_cidade
  )
values(
    '77010-000',
    '106 Norte',
    'Av.JK',
    10,
    'loja 1, Sapataria',
    1
  );
insert into endereco(
    cep,
    bairro,
    logradouro,
    numero,
    complemento,
    id_cidade
  )
values(
    '77006-500',
    '204 Sul',
    'alameda 02',
    13,
    'casa',
    2
  );
insert into usuario_endereco (id_usuario, id_endereco)
values(1, 1);
insert into usuario_endereco (id_usuario, id_endereco)
values(1, 2);
insert into usuario_endereco (id_usuario, id_endereco)
values(2, 3);
insert into telefone (codigoArea, numero)
values('63', '999999999');
insert into telefone (codigoArea, numero)
values('62', '888888888');
insert into telefone (codigoArea, numero)
values('61', '777777777');
insert into telefone (codigoArea, numero)
values('55', '666666666');
insert into usuario_telefone (id_usuario, id_telefone)
values(1, 1);
insert into usuario_telefone (id_usuario, id_telefone)
values(1, 2);
insert into usuario_telefone (id_usuario, id_telefone)
values(2, 3);
insert into usuario_telefone (id_usuario, id_telefone)
values(2, 4);
INSERT INTO endereco (
    logradouro,
    bairro,
    numero,
    complemento,
    cep,
    id_cidade
  )
VALUES (
    'Rua A',
    'Bairro A',
    '123',
    'Complemento A',
    '12345-678',
    2
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua B',
    'Bairro B',
    '456',
    'Complemento B',
    '98765-432'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua C',
    'Bairro C',
    '789',
    'Complemento C',
    '11111-222'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua D',
    'Bairro D',
    '101',
    'Complemento D',
    '33333-444'
  );
insert into usuario_endereco (id_usuario, id_endereco)
values(2, 4);
insert into usuario_endereco (id_usuario, id_endereco)
values(3, 5);
insert into usuario_endereco (id_usuario, id_endereco)
values(3, 6);
insert into usuario_endereco (id_usuario, id_endereco)
values(4, 7);
/* ---------------------------Insert de generos---------------------------- */
-- Primeiro insert
INSERT INTO genero (nome, ativo)
VALUES ('Ação', true);
-- Segundo insert
INSERT INTO genero (nome, ativo)
VALUES ('Aventura', true);
-- Terceiro insert
INSERT INTO genero (nome, ativo)
VALUES ('RPG', true);
-- Quarto insert
INSERT INTO genero (nome, ativo)
VALUES ('Estratégia', true);
-- Quinto insert
INSERT INTO genero (nome, ativo)
VALUES ('Esporte', true);
-- Sexto insert
INSERT INTO genero (nome, ativo)
VALUES ('Corrida', true);
-- Sétimo insert
INSERT INTO genero (nome, ativo)
VALUES ('Simulação', true);
-- Oitavo insert
INSERT INTO genero (nome, ativo)
VALUES ('Quebra-Cabeça', true);
-- Nono insert
INSERT INTO genero (nome, ativo)
VALUES ('Ficção Científica', true);
-- Décimo insert
INSERT INTO genero (nome, ativo)
VALUES ('Fantasia', true);
/* ---------------------------Insert de fabricante---------------------------- */
-- Primeiro insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Sony', true);
-- Segundo insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Microsoft', true);
-- Terceiro insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Nintendo', true);
-- Quarto insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Intel', true);
-- Quinto insert
INSERT INTO fabricante (nome, ativo)
VALUES ('AMD', true);
-- Sexto insert
INSERT INTO fabricante (nome, ativo)
VALUES ('NVIDIA', true);
-- Sétimo insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Apple', true);
-- Oitavo insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Samsung', true);
-- Nono insert
INSERT INTO fabricante (nome, ativo)
VALUES ('Google', true);
-- Décimo insert
INSERT INTO fabricante (nome, ativo)
VALUES ('ASUS', true);
/* ---------------------------Insert de plataforma---------------------------- */
-- Primeiro insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('PlayStation 5', 1, true);
-- Segundo insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Xbox Series X', 2, true);
-- Terceiro insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Nintendo Switch', 3, true);
-- Quarto insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('PC', 4, true);
-- Quinto insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('PlayStation 4', 1, true);
-- Sexto insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Xbox One', 2, true);
-- Sétimo insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Nintendo 3DS', 3, true);
-- Oitavo insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('PlayStation 3', 1, true);
-- Nono insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Xbox 360', 2, true);
-- Décimo insert
INSERT INTO plataforma (nome, id_fabricante, ativo)
VALUES ('Nintendo Wii', 3, true);
/* ---------------------------Insert de pais---------------------------- */
-- Primeiro insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Brasil', 'BR', true);
-- Segundo insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Estados Unidos', 'US', true);
-- Terceiro insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Japão', 'JP', true);
-- Quarto insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Alemanha', 'DE', true);
-- Quinto insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('China', 'CN', true);
-- Sexto insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Rússia', 'RU', true);
-- Sétimo insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('França', 'FR', true);
-- Oitavo insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Reino Unido', 'UK', true);
-- Nono insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Índia', 'IN', true);
-- Décimo insert
INSERT INTO pais (nome, sigla, ativo)
VALUES ('Itália', 'IT', true);
/* ---------------------------Insert de desenvolvedora---------------------------- */
-- Primeiro insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Xbox Game Studios', '12345678000195', 1, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Bethesda Softworks', '23456789000188', 2, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Rockstar Games', '34567890000160', 3, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Electronic Arts', '45678901000142', 4, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Ubisoft', '56789012000123', 5, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('CD Projekt Red', '67890123000104', 6, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Valve Corporation', '78901234000185', 7, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Capcom', '89012345000166', 8, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Square Enix', '90123456000147', 9, true);
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Naughty Dog', '01234567000128', 10, true);
/* ---------------------------Insert de jogo---------------------------- */
-- Primeiro insert (Classificação: Livre)
-- Primeiro insert (Classificação: Livre)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Minecraft',
    'Jogo de Criar',
    99.99,
    100,
    'Intel Core i3',
    '4GB',
    'NVIDIA GTX 400',
    '10GB',
    'Windows 7',
    'LIVRE',
    1,
    1,
    true
  );
-- Segundo insert (Classificação: 10 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'The Sims',
    'Criar Pessoas',
    49.99,
    50,
    'Intel Core i3',
    '4GB',
    'NVIDIA GTX 400',
    '10GB',
    'Windows 7',
    'DEZ_ANOS',
    2,
    2,
    true
  );
-- Terceiro insert (Classificação: 12 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Fallout 4',
    'Sobreviva',
    29.99,
    30,
    'Intel Core i5',
    '8GB',
    'NVIDIA GTX 770',
    '30GB',
    'Windows 7',
    'DOZE_ANOS',
    3,
    3,
    true
  );
-- Quarto insert (Classificação: 14 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Starfield',
    'Explorar o Espaço',
    79.99,
    80,
    'Intel Core i5',
    '16GB',
    'NVIDIA GTX 1060',
    '70GB',
    'Windows 10',
    'QUATORZE_ANOS',
    4,
    4,
    true
  );
-- Quinto insert (Classificação: 16 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Call Of Duty: Warzone',
    'Jogo de Tiro',
    39.99,
    40,
    'Intel Core i3',
    '8GB',
    'NVIDIA GTX 670',
    '175GB',
    'Windows 10',
    'DEZESSEIS_ANOS',
    5,
    5,
    true
  );
-- Sexto insert (Classificação: 18 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'GTA V',
    'Jogo de Exploração e História',
    69.99,
    70,
    'Intel Core i5',
    '8GB',
    'NVIDIA GTX 660',
    '65GB',
    'Windows 7',
    'DEZOITO_ANOS',
    6,
    6,
    true
  );
-- Sétimo insert (Classificação: Livre)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Portal 2',
    'Resolva puzzles com portais.',
    19.99,
    20,
    'Intel Core i3',
    '2GB',
    'NVIDIA GTX 200',
    '8GB',
    'Windows 7',
    'LIVRE',
    7,
    7,
    true
  );
-- Oitavo insert (Classificação: 10 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Monster Hunter: World',
    'Mate Montros em um dinamico mundo.',
    59.99,
    60,
    'Intel Core i5',
    '8GB',
    'NVIDIA GTX 760',
    '20GB',
    'Windows 7',
    'DEZ_ANOS',
    8,
    8,
    true
  );
-- Nono insert (Classificação: 12 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Final Fantasy XV',
    'RPG Ação e Aventura.',
    89.99,
    90,
    'Intel Core i7',
    '16GB',
    'NVIDIA GTX 1060',
    '100GB',
    'Windows 10',
    'DOZE_ANOS',
    9,
    9,
    true
  );
-- Décimo insert (Classificação: 14 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    processador,
    memoria,
    placaVideo,
    armazenamento,
    sistemaOperacional,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    ativo
  )
VALUES (
    'Uncharted 4',
    'Jogo de Ação e Aventura.',
    109.99,
    110,
    'Intel Core i5',
    '8GB',
    'NVIDIA GTX 1080',
    '50GB',
    'Windows 10',
    'QUATORZE_ANOS',
    10,
    10,
    true
  );