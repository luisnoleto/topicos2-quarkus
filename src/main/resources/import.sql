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
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo1', 'Descrição do Jogo1', 49.99, 100);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo2', 'Descrição do Jogo2', 29.99, 75);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES('Jogo3', 'Descrição do Jogo3', 39.99, 50);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo4', 'Descrição do Jogo4', 59.99, 120);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo5', 'Descrição do Jogo5', 19.99, 80);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo6', 'Descrição do Jogo6', 49.99, 90);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES('Jogo7', 'Descrição do Jogo7', 69.99, 60);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo8', 'Descrição do Jogo8', 24.99, 110);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo9', 'Descrição do Jogo9', 34.99, 70);
INSERT INTO jogo (nome, descricao, preco, estoque)
VALUES ('Jogo10', 'Descrição do Jogo10', 44.99, 85);
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
INSERT INTO pais (nome, sigla)
VALUES ('Brasil', 'BR');
INSERT INTO pais (nome, sigla)
VALUES ('Estados Unidos', 'EUA');
INSERT INTO pais (nome, sigla)
VALUES ('Argentina', 'ARG');
INSERT INTO desenvolvedora (nome, cnpj, id_pais)
VALUES ('Desenvolvedora1', '12345678901234', 1);
INSERT INTO desenvolvedora (nome, cnpj, id_pais)
VALUES ('Desenvolvedora2', '12345678901234', 2);
INSERT INTO desenvolvedora (nome, cnpj, id_pais)
VALUES ('Desenvolvedora3', '12345678901234', 3);