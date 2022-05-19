USE quiz;

/*
set sql_safe_updates = 0;

delete from sub_categoria;
delete from categoria;
delete from alternativa;
delete from aplicacao_quiz;
delete from aplicacao_quiz_resultado;
delete from login;
delete from pergunta;
delete from quiz;
delete from quiz_pergunta;
delete from usuario;
*/

-- categoriaS E SUB categoriaS
-- GEOGRAFIA
INSERT INTO categoria (nome) VALUES ("GEOGRAFIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("HIDROGRAFIA", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("URBANIZAÇÃO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("POPULAÇÃO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("IMIGRAÇÕES", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INDUSTRIALIZAÇÃO E COMÉRCIO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GEOPOLÍTICA", 1);

-- HISTÓRIA
INSERT INTO categoria (nome) VALUES ("HISTÓRIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FEUDALISMO", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ABSOLUTISMO", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("CIVILIZAÇÕES PRÉ-COMLOMBIANAS", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ANTIGUIDADE CLÁSSICA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("REVOLUÇÃO FRANCESA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("COLONIZAÇÃO MERCANTILISTA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ERA VARGAS", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PROCESSO DE IDEPENDENCIA DO BRASIL", 2);

-- MATEMÁTICA
INSERT INTO categoria (nome) VALUES ("MATEMÁTICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TRIGONOMETRIA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GEOMETRIA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PORCENTAGEM", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRISMAS", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("RAZÕES E PROPORÇÕES", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ESTATÍSTICA E PROBABILIDADE", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ALGEBRA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INTRODUÇÃO AO CÁLCULO", 3);

-- PORTUGUÊS
INSERT INTO categoria (nome) VALUES ("PORTUGUÊS");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("LITERATURA", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("LINGUÍSTICA", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GRAMÁTICA", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GÊNEROS TEXTUAIS", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INTERPRETAÇÃO DE texto", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("VARIAÇÃO LINGUÍSTICA", 4);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FIGURAS DE LINGUAGEM", 4);

-- BIOLOGIA
INSERT INTO categoria (nome) VALUES ("BIOLOGIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ANATOMIA ANIMAL", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("BIOESTATICA", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GENÉTICA", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TECIDOS BIOLÓGICOS", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("BIOLOGIA CELULAR", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("BIOLOGIA MOLECULAR", 5);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("DETERMINISMO BIOLÓGICO", 5);

-- QUÍMICA
INSERT INTO categoria (nome) VALUES ("QUÍMICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FUNÇÕES INORGÂNICAS", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("REAÇÕES INORGÂNICAS", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SOLUÇÕES", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ELETROQUÍMICA", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("EQUILÍBRIO QUÍMICO", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TERMOQUÍMICA", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("RADIOATIVIDADE", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FUNÇÕES ORGÂNICAS", 6);

-- FÍSICA
INSERT INTO categoria (nome) VALUES ("FÍSICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("MECÂNICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TERMODINÂMICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ÓPTICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ELETROMAGNETISMO", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FÍSICA NUCLEAR", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ASTRONOMIA", 7);

-- EDUCAÇÃO FÍSICA
INSERT INTO categoria (nome) VALUES ("EDUCAÇÃO FÍSICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FUTEBOL", 8);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("LINGUAGENS DO CORPO", 8);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GINÁSTICA", 8);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("JUDÔ", 8);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("HANDEBOL", 8);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("BASQUETE", 8);

-- ARTES
INSERT INTO categoria (nome) VALUES ("ARTES");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("BARROCO", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("CANTIGAS DE RODA", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("VANGUARDAS EUROPÉIAS", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ARTE CONTEMPORÂNEA", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("RENASCIMENTO CULTURAL", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("DANÇAS FOLCLÓRICAS", 9);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SEMANA DA ARTE MODERNA", 9);

-- SOCIOLOGIA
INSERT INTO categoria (nome) VALUES ("SOCIOLOGIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PROCESSOS SOCIAIS", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INTRODUÇÃO A SOCIOLOGIA", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GRUPOS SOCIAIS", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("CIDADANIA BRASILEIRA", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("A CULTURA NO BRASIL", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PROCESSOS SOCIAIS", 10);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ORGANIZAÇÃO DO ESTADO BRASILEIRO", 10);

-- FILOSOFIA
INSERT INTO categoria (nome) VALUES ("FILOSOFIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INTRODUÇÃO A FILOSOFIA", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("OS SOFISTAS", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SÓCRATES", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PLATÃO", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ARISTÓTOLES", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("A ÉTICA DE SANTO AGOSTINHO", 11);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("CONFÚCIO E SEUS ENSINAMENTOS", 11);

-- INGLÊS
INSERT INTO categoria (nome) VALUES ("INGLÊS");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("VERB TO BE", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE PAST", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRESENT CONTINUOUS", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE PRESENT", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE FUTURE", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PAST CONTINUOUS", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRESENT PERFECT SIMPLE", 12);



-- USUÁRIO
INSERT INTO usuario (nome, cpf, email, telefone) VALUES 
("Ian Benedito Almeida", "506.726.137-43", "ian_benedito_almeida@coldblock.com.br", "(43) 99120-3042");
INSERT INTO usuario (nome, cpf, email, telefone) VALUES 
("Valentina Lavínia Isabelle Castro", "254.100.896-18", "valentina_castro@teravida.com.br", "(41) 2749-0455");
INSERT INTO usuario (nome, cpf, email, telefone) VALUES 
("José Danilo dos Santos", "046.349.843-77", "jose-dossantos70@aspadvocacia.com", "(79) 99773-0287");
INSERT INTO usuario (nome, cpf, email, telefone) VALUES 
("André Leonardo Jesus", "738.161.742-05", "andre_leonardo_jesus@stilomovelaria.com.br", "(48) 98446-0449");

-- PERGUNTAS E ALTERNATIVAS
-- IAN, GEOGRAFIA, HIDROGRAFIA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("Assinale a alternativa abaixo que NÃO representa uma das características gerais da hidrografia brasileira.", TRUE, "2020-05-05", 1, 
(SELECT id FROM sub_categoria WHERE nome = "HIDROGRAFIA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A maior parte dos rios brasileiros é abastecida por um regime pluvial, praticamente não havendo indícios de regimes de abastecimento nivais ou glaciais.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Assinale a alternativa abaixo que NÃO representa%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A maioria dos rios do Brasil é perene e a minoria é intermitente.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Assinale a alternativa abaixo que NÃO representa%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A hidrografia brasileira é rica em rios e pobre em lagos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Assinale a alternativa abaixo que NÃO representa%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Os rios do Brasil são exorreicos e deságuam quase sempre no Oceano Atlântico.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Assinale a alternativa abaixo que NÃO representa%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Alguns rios brasileiros são muito usados para a navegação, a exemplo do Rio Amazonas.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Assinale a alternativa abaixo que NÃO representa%"));

-- IAN, HISTÓRIA, FEUDALISMO
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(Fatec-SP) – Uma das características a ser reconhecida no feudalismo europeu é:", TRUE, "2021-06-04", 1, 
(SELECT id FROM sub_categoria WHERE nome = "FEUDALISMO")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A sociedade feudal era semelhante ao sistema de castas.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Uma das características a ser reconhecida no feudalismo europeu é%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Os ideais de honra e fidelidade vieram das instituições dos hunos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Uma das características a ser reconhecida no feudalismo europeu é%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Vilões e servos estavam presos a várias obrigações, entre elas, o pagamento anual de capitação, talha e banalidades.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Uma das características a ser reconhecida no feudalismo europeu é%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A economia do feudo era dinâmica, estando voltada para o comércio dos feudos vizinhos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Uma das características a ser reconhecida no feudalismo europeu é%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("As relações de produção eram escravocratas.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%Uma das características a ser reconhecida no feudalismo europeu é%"));

-- IAN, MATEMÁTICA, TRIGONOMETRIA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(Cefet/MG - 2017) Em um triângulo retângulo, a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5, o valor do seno desse mesmo ângulo é", TRUE, "2022-01-05", 1, 
(SELECT id FROM sub_categoria WHERE nome = "TRIGONOMETRIA"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("4/5", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("√5/4", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("√5/5", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("2√5/5", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 1 AND texto LIKE "%a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5%"));


-- VALENTINA, PORTUGUÊS, LITERATURA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(UFRN) A obra de Gregório de Matos – autor que se destaca na literatura barroca brasileira – compreende:", TRUE, "2019-11-20", 2, 
(SELECT id FROM sub_categoria WHERE nome = "LITERATURA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Poesia épico-amorosa e obras dramáticas.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFRN) A obra de Gregório de Matos – autor que se destaca%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Poesia satírica e contos burlescos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFRN) A obra de Gregório de Matos – autor que se destaca%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Poesia lírica, de caráter religioso e amoroso, e poesia satírica.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFRN) A obra de Gregório de Matos – autor que se destaca%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Poesia confessional e autos religiosos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFRN) A obra de Gregório de Matos – autor que se destaca%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Poesia lírica e teatro de costumes.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFRN) A obra de Gregório de Matos – autor que se destaca%"));

-- VALENTINA, BIOLOGIA, GENÉTICA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("Sobre a recombinação gênica é correto afirmar que:", TRUE, "2012-06-05", 2, 
(SELECT id FROM sub_categoria WHERE nome = "GENÉTICA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A recombinação gênica pode ser homóloga ou heteróloga.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%Sobre a recombinação gênica é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A principal diferença entre os tipos de recombinação é que ocorrem em etapas diferentes da mitose.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%Sobre a recombinação gênica é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A recombinação gênica é classificada em homóloga e não-homóloga.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%Sobre a recombinação gênica é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Enquanto um tipo de recombinação permite a variabilidade, o outro tipo apresenta limitações.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%Sobre a recombinação gênica é correto afirmar que:%"));

-- VALENTINA, QUIMICA, TERMOQUÍMICA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações químicas, pode-se afirmar:", TRUE, "2015-07-06", 2, 
(SELECT id FROM sub_categoria WHERE nome = "TERMOQUÍMICA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A queima da parafina de uma vela exemplifica um processo endotérmico.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A vaporização da água de uma piscina pela ação da luz solar exemplifica um processo endotérmico.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A combustão do álcool hidratado em motores de automóveis exemplifica um processo endotérmico.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("A formação de um iceberg a partir da água do mar exemplifica um processo endotérmico.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O valor de ΔH de uma transformação depende exclusivamente do estado físico dos reagentes.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 2 AND texto LIKE "%(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações%"));


-- jOSÉ, FISICA, TERMODINÂMICA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico. Sobre a energia cinética média e sobre a velocidade média das moléculas de cada gás, pode-se concluir que:", TRUE, "2018-03-27", 3, 
(SELECT id FROM sub_categoria WHERE nome = "TERMODINÂMICA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("as moléculas de H2  e N2  tem a mesma energia cinética média e a mesma velocidade média.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ambas tem a mesma velocidade média, mas as moléculas de N2 tem maior energia cinética média.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ambas tem a mesma velocidade média, mas as moléculas de H2 tem maior energia cinética média.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ambas tem a mesma energia cinética média, mas as moléculas de N2 tem maior velocidade média.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ambas tem a mesma energia cinética média, mas as moléculas de H2 tem maior velocidade média.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico%"));

-- jOSÉ, EDUCAÇÃO FISICA, GINÁSTICA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("Quais são as ginásticas competitivas?", TRUE, "2015-09-10", 3, 
(SELECT id FROM sub_categoria WHERE nome = "GINÁSTICA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Contorcionismo, ginástica cerebral, ginástica laboral e hidroginástica.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%Quais são as ginásticas competitivas?%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ginástica de trampolim, ginástica rítmica, ginástica artística e ginástica acrobática", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%Quais são as ginásticas competitivas?%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ginástica cerebral, ginástica artística, ginástica laboral e ginástica de trampolim.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%Quais são as ginásticas competitivas?%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Contorcionismo,ginástica rítmica, ginástica cerebral.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%Quais são as ginásticas competitivas?%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Ginástica rítmica, ginástica artística e ginástica acrobática.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%Quais são as ginásticas competitivas?%"));

-- jOSÉ, ARTES, BARROCO
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII. Na arte e na economia suas expressões foram respectivamente:", TRUE, "2019-05-06", 3, 
(SELECT id FROM sub_categoria WHERE nome = "BARROCO")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("rococó e liberalismo.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII.%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("renascentismo e capitalismo.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII.%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("barroco e mercantilismo.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII.%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("maneirismo e colonialismo.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII.%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("classicismo e economicismo.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 3 AND texto LIKE "%(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII.%"));


-- ANDRÉ, SOCIOLOGIA, INTRODUÇÃO A SOCIOLOGIA
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental na constituição da sociologia como ramo científico. Sobre essa corrente de pensamento, que reunia autores como Augusto Comte e Herbert Spencer, assinale o que for correto.", TRUE, "2011-02-17", 4, 
(SELECT id FROM sub_categoria WHERE nome = "INTRODUÇÃO A SOCIOLOGIA")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O evolucionismo define que as estruturas, naturais ou sociais, passam por processo de diferenciação e integração que levam ao seu aprimoramento.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O evolucionismo propõe que a evolução das sociedades ocorre em estágios sucessivos de racionalização. ", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O evolucionismo considera o Estado Militar como a forma mais evoluída de organização social, fundamentada na cooperação interna e obrigatória. ", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O evolucionismo rejeita o modelo político e econômico liberal, baseado na livre iniciativa e no laissez-faire, considerando-o uma orientação contrária à evolução social.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O evolucionismo defende a unidade biológica e cognitiva da espécie humana, independente de variações particulares.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental%"));

-- ANDRÉ, FILOSOFIA, SÓCRATES
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental, contribuindo para compreender o mundo e a sua complexidade.Sócrates, um dos seus filósofos mais conhecidos:", TRUE, "2016-05-19", 4, 
(SELECT id FROM sub_categoria WHERE nome = "SÓCRATES")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Defendeu a existência da democracia e a organização de uma Assembleia Popular para definir o governo ateniense.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental,%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Polemizou com os filósofos sofistas que defendiam princípios religiosos diferentes dos princípios gregos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental,%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Teve muitas das suas teorias incorporadas ao pensamento idealista de Platão, outro grande pensador grego.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental,%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Foi contra as reformas políticas defendidas por Aristóteles, pois era favorável à existência de um governo democrático.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental,%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Propagou a necessidade do fortalecimento militar de Atenas, para evitar os ataques dos inimigos asiáticos.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental,%"));

-- ANDRÉ, INGLÊS, VERB TO BE
INSERT INTO pergunta (texto, visibilidade_privada, datacriacao, id_usuario_proprietario, id_sub_categoria) VALUES 
("Em relação à frase Is it that difficult? é correto afirmar que:", TRUE, "2013-09-13", 4, 
(SELECT id FROM sub_categoria WHERE nome = "VERB TO BE")); 
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O verbo to be está no passado.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%Em relação à frase Is it that difficult? é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("O verbo to be está na primeira pessoa.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%Em relação à frase Is it that difficult? é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Pode ser respondida com yes, it is.", TRUE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%Em relação à frase Is it that difficult? é correto afirmar que:%"));
INSERT INTO alternativa (texto, status_correta, id_pergunta) VALUES 
("Pode ser respondida com no, it is.", FALSE, 
(SELECT id_pergunta FROM pergunta WHERE id_usuario_proprietario = 4 AND texto LIKE "%Em relação à frase Is it that difficult? é correto afirmar que:%"));


