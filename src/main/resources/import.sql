-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO Usuario (
    nome,
    login,
    senha,
    email,
    cpf,
    perfil,
    dataNascimento,
    nomeImage
  )
VALUES (
    'Test User',
    'testuser',
    'password',
    'testuser@example.com',
    '123.456.789-00',
    1,
    '2022-01-01',
    'image.jpg'
  );
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
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua A',
    'Bairro A',
    '123',
    'Complemento A',
    '12345-678'
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
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua E',
    'Bairro E',
    '202',
    'Complemento E',
    '55555-666'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua F',
    'Bairro F',
    '303',
    'Complemento F',
    '77777-888'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua G',
    'Bairro G',
    '404',
    'Complemento G',
    '99999-000'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua H',
    'Bairro H',
    '505',
    'Complemento H',
    '12345-678'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua I',
    'Bairro I',
    '606',
    'Complemento I',
    '98765-432'
  );
INSERT INTO endereco (logradouro, bairro, numero, complemento, cep)
VALUES (
    'Rua J',
    'Bairro J',
    '707',
    'Complemento J',
    '11111-222'
  );
/* ---------------------------Insert de requisitos---------------------------- */
-- Primeiro insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'Intel Core i5',
    'ALTO',
    '8GB',
    'NVIDIA GeForce GTX 1050',
    'Windows 10',
    '512GB SSD'
  );
-- Segundo insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'AMD Ryzen 7',
    'MEDIO',
    '16GB',
    'AMD Radeon RX 5700',
    'Ubuntu 20.04',
    '1TB HDD'
  );
-- Terceiro insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'Intel Core i9',
    'LEVE',
    '32GB',
    'NVIDIA GeForce RTX 3080',
    'MacOS Big Sur',
    '2TB SSD'
  );
-- Quarto insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'AMD Ryzen 5',
    'ALTO',
    '12GB',
    'NVIDIA GeForce GTX 1660',
    'Windows 11',
    '256GB SSD + 1TB HDD'
  );
-- Quinto insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'Intel Core i7',
    'MEDIO',
    '24GB',
    'AMD Radeon RX 6800',
    'Fedora 35',
    '1TB NVMe SSD'
  );
-- Sexto insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'AMD Ryzen 9',
    'LEVE',
    '64GB',
    'NVIDIA GeForce RTX 3090',
    'Arch Linux',
    '4TB HDD'
  );
-- Sétimo insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'Intel Core i3',
    'ALTO',
    '4GB',
    'NVIDIA GeForce GTX 1050 Ti',
    'Windows 10',
    '128GB SSD'
  );
-- Oitavo insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'AMD Ryzen 3',
    'MEDIO',
    '8GB',
    'AMD Radeon RX 5600 XT',
    'Ubuntu 22.04',
    '512GB NVMe SSD'
  );
-- Nono insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'Intel Core i5',
    'LEVE',
    '16GB',
    'NVIDIA GeForce RTX 3060',
    'Windows 11',
    '1TB HDD'
  );
-- Décimo insert
INSERT INTO requisito (
    processador,
    desempenho,
    memoria,
    placaVideo,
    sistemaOperacional,
    armazenamento
  )
VALUES (
    'AMD Ryzen 7',
    'ALTO',
    '32GB',
    'NVIDIA GeForce GTX 1070',
    'Ubuntu 21.10',
    '512GB NVMe SSD'
  );
/* ---------------------------Insert de generos---------------------------- */
-- Primeiro insert
INSERT INTO genero (nome)
VALUES ('Ação');
-- Segundo insert
INSERT INTO genero (nome)
VALUES ('Aventura');
-- Terceiro insert
INSERT INTO genero (nome)
VALUES ('RPG');
-- Quarto insert
INSERT INTO genero (nome)
VALUES ('Estratégia');
-- Quinto insert
INSERT INTO genero (nome)
VALUES ('Esporte');
-- Sexto insert
INSERT INTO genero (nome)
VALUES ('Corrida');
-- Sétimo insert
INSERT INTO genero (nome)
VALUES ('Simulação');
-- Oitavo insert
INSERT INTO genero (nome)
VALUES ('Quebra-Cabeça');
-- Nono insert
INSERT INTO genero (nome)
VALUES ('Ficção Científica');
-- Décimo insert
INSERT INTO genero (nome)
VALUES ('Fantasia');
/* ---------------------------Insert de fabricante---------------------------- */
-- Primeiro insert
INSERT INTO fabricante (nome)
VALUES ('Sony');
-- Segundo insert
INSERT INTO fabricante (nome)
VALUES ('Microsoft');
-- Terceiro insert
INSERT INTO fabricante (nome)
VALUES ('Nintendo');
-- Quarto insert
INSERT INTO fabricante (nome)
VALUES ('Intel');
-- Quinto insert
INSERT INTO fabricante (nome)
VALUES ('AMD');
-- Sexto insert
INSERT INTO fabricante (nome)
VALUES ('NVIDIA');
-- Sétimo insert
INSERT INTO fabricante (nome)
VALUES ('Apple');
-- Oitavo insert
INSERT INTO fabricante (nome)
VALUES ('Samsung');
-- Nono insert
INSERT INTO fabricante (nome)
VALUES ('Google');
-- Décimo insert
INSERT INTO fabricante (nome)
VALUES ('ASUS');
/* ---------------------------Insert de plataforma---------------------------- */
-- Primeiro insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('PlayStation 5', 1);
-- Segundo insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Xbox Series X', 2);
-- Terceiro insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Nintendo Switch', 3);
-- Quarto insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('PC', 4);
-- Quinto insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('PlayStation 4', 1);
-- Sexto insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Xbox One', 2);
-- Sétimo insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Nintendo 3DS', 3);
-- Oitavo insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('PlayStation 3', 1);
-- Nono insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Xbox 360', 2);
-- Décimo insert
INSERT INTO plataforma (nome, id_fabricante)
VALUES ('Nintendo Wii', 3);
/* ---------------------------Insert de pais---------------------------- */
-- Primeiro insert
INSERT INTO pais (nome, sigla)
VALUES ('Brasil', 'BR');
-- Segundo insert
INSERT INTO pais (nome, sigla)
VALUES ('Estados Unidos', 'US');
-- Terceiro insert
INSERT INTO pais (nome, sigla)
VALUES ('Japão', 'JP');
-- Quarto insert
INSERT INTO pais (nome, sigla)
VALUES ('Alemanha', 'DE');
-- Quinto insert
INSERT INTO pais (nome, sigla)
VALUES ('China', 'CN');
-- Sexto insert
INSERT INTO pais (nome, sigla)
VALUES ('Rússia', 'RU');
-- Sétimo insert
INSERT INTO pais (nome, sigla)
VALUES ('França', 'FR');
-- Oitavo insert
INSERT INTO pais (nome, sigla)
VALUES ('Reino Unido', 'UK');
-- Nono insert
INSERT INTO pais (nome, sigla)
VALUES ('Índia', 'IN');
-- Décimo insert
INSERT INTO pais (nome, sigla)
VALUES ('Itália', 'IT');
/* ---------------------------Insert de desenvolvedora---------------------------- */
-- Primeiro insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais, ativo)
VALUES ('Desenvolvedora 1', '11111111111111', 1, true);
-- Segundo insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 2', '22222222222222', 2, false);
-- Terceiro insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 3', '33333333333333', 3 , true);
-- Quarto insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 4', '44444444444444', 4 , false);
-- Quinto insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 5', '55555555555555', 5 , true);
-- Sexto insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 6', '66666666666666', 6 , false);
-- Sétimo insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 7', '77777777777777', 7 , true);
-- Oitavo insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 8', '88888888888888', 8 , false );
-- Nono insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 9', '99999999999999', 9 , true);
-- Décimo insert
INSERT INTO desenvolvedora (nome, cnpj, id_pais , ativo)
VALUES ('Desenvolvedora 10', '10101010101010', 10 , false);
/* ---------------------------Insert de jogo---------------------------- */
-- Primeiro insert (Classificação: Livre)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Minecraft',
    'Jogo de Criar',
    99.99,
    100,
    'LIVRE',
    1,
    1,
    1
  );
-- Segundo insert (Classificação: 10 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'The Sims',
    'Criar Pessoas',
    49.99,
    50,
    'DEZ_ANOS',
    2,
    2,
    2
  );
-- Terceiro insert (Classificação: 12 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Fallout 4',
    'Sobreviva',
    29.99,
    30,
    'DOZE_ANOS',
    3,
    3,
    3
  );
-- Quarto insert (Classificação: 14 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Starfield',
    'Explorar o Espaço',
    79.99,
    80,
    'QUATORZE_ANOS',
    4,
    4,
    4
  );
-- Quinto insert (Classificação: 16 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Call Of Duty: Warzone',
    'Jogo de Tiro',
    39.99,
    40,
    'DEZESSEIS_ANOS',
    5,
    5,
    5
  );
-- Sexto insert (Classificação: 18 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'GTA V',
    'Jogo de Explorar e Caos',
    69.99,
    70,
    'DEZOITO_ANOS',
    6,
    6,
    6
  );
-- Sétimo insert (Classificação: Livre)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Jogo 7',
    'Descrição do Jogo 7',
    59.99,
    60,
    'LIVRE',
    7,
    7,
    7
  );
-- Oitavo insert (Classificação: 10 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Jogo 8',
    'Descrição do Jogo 8',
    89.99,
    90,
    'DEZ_ANOS',
    8,
    8,
    8
  );
-- Nono insert (Classificação: 12 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Jogo 9',
    'Descrição do Jogo 9',
    19.99,
    20,
    'DOZE_ANOS',
    9,
    9,
    9
  );
-- Décimo insert (Classificação: 14 anos)
INSERT INTO jogo (
    nome,
    descricao,
    preco,
    estoque,
    classificacao,
    id_desenvolvedora,
    id_plataforma,
    id_requisito
  )
VALUES (
    'Jogo 10',
    'Descrição do Jogo 10',
    109.99,
    110,
    'QUATORZE_ANOS',
    10,
    10,
    10
  );