
set sql_safe_updates = 0;

create database quiz;

drop database if exists quiz;

use quiz;

select * from pergunta;
select * from categoria;
select * from sub_categoria;
select * from alternativa;
select * from usuario;
select * from quiz;

insert into usuario(cpf, email, login, nome, senha, statusAtivo, telefone) values('99999999999', 'teste@gmail.com', 'asd', 'teste', '123', true, '33333333');

insert into categoria(nome, statusAtivo) values('geografia', true), ('história', true), ('matemática', true);

insert into sub_categoria(nome, statusAtivo, id_categoria) values('relevo', true, 1), ('hidrografia', true, 1), ('vegetação', true, 1);
insert into sub_categoria(nome, statusAtivo, id_categoria) values('álgebra', true, 3), ('geometria', true, 3), ('aritmética', true, 3);

--   QUESTÃO  1

INSERT INTO pergunta (data_criacao, statusAtivo, texto, visibilidade_privada, id_sub_categoria, id_usuario_proprietario) VALUES 
("2020-05-05", true, "Assinale a alternativa abaixo que NÃO representa uma das características gerais da hidrografia brasileira.", FALSE, 1, 1);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("A maior parte dos rios brasileiros é abastecida por um regime pluvial, praticamente não havendo indícios de regimes de abastecimento nivais ou glaciais."
, true, true, 1);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("A maior parte dos rios brasileiros é pluvial, havendo indícios de regimes de abastecimento glaciais."
, true, FALSE, 1);

--   QUESTÃO  2

INSERT INTO pergunta (data_criacao, statusAtivo, texto, visibilidade_privada, id_sub_categoria, id_usuario_proprietario) VALUES 
("2020-05-05", true, "Pergunta2", TRUE, 1, 1);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("Alternativa 1 da pergunta 2", true, true, 2);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("Alternativa 2 da pergunta 2", true, FALSE, 2);

--   QUESTÃO  3

INSERT INTO pergunta (data_criacao, statusAtivo, texto, visibilidade_privada, id_sub_categoria, id_usuario_proprietario) VALUES 
("2020-05-05", true, "Pergunta3", TRUE, 1, 1);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("Alternativa 1 da pergunta 3", true, true, 3);

INSERT INTO alternativa (texto, statusAtivo, status_correta, id_pergunta) VALUES 
("Alternativa 2 da pergunta 3", true, FALSE, 3);





