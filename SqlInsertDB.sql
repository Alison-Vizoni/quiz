USE quiz;
set sql_safe_updates = 0;


-- CATEGORIAS E SUB CATEGORIAS
-- GEOGRAFIA
INSERT INTO categoria (nome) VALUES ("GEOGRAFIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("HIDROGRAFIA", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("URBANIZAÇÃO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("POPULAÇÃO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("IMIGRAÇÕES", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INDUSTRIALIZAÇÃO E COMÉRCIO", 1);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GEOPOLÍTICA", 1);

-- HISTÓRIA
INSERT INTO categoria (nome) VALUES ("HISTORIA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FEUDALISMO", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ABSOLUTISMO", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("CIVILIZAÇÕES PRÉ-COLOMBIANAS", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ANTIGUIDADE CLÁSSICA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("REVOLUÇÃO FRANCESA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("COLONIZAÇÃO MERCANTILISTA", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ERA VARGAS", 2);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PROCESSO DE IDEPENDENCIA DO BRASIL", 2);

-- MATEMÁTICA
INSERT INTO categoria (nome) VALUES ("MATEMATICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TRIGONOMETRIA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("GEOMETRIA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PORCENTAGEM", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRISMAS", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("RAZÕES E PROPORÇÕES", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ESTATÍSTICA E PROBABILIDADE", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ALGEBRA", 3);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("INTRODUÇÃO AO CÁLCULO", 3);

-- PORTUGUÊS
INSERT INTO categoria (nome) VALUES ("PORTUGUES");
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
INSERT INTO categoria (nome) VALUES ("QUIMICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FUNÇÕES INORGÂNICAS", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("REAÇÕES INORGÂNICAS", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SOLUÇÕES", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ELETROQUÍMICA", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("EQUILÍBRIO QUÍMICO", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TERMOQUÍMICA", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("RADIOATIVIDADE", 6);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FUNÇÕES ORGÂNICAS", 6);

-- FÍSICA
INSERT INTO categoria (nome) VALUES ("FISICA");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("MECÂNICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("TERMODINÂMICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ÓPTICA", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ELETROMAGNETISMO", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("FÍSICA NUCLEAR", 7);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("ASTRONOMIA", 7);

-- EDUCAÇÃO FÍSICA
INSERT INTO categoria (nome) VALUES ("EDUCACAO FISICA");
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
INSERT INTO categoria (nome) VALUES ("INGLES");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("VERB TO BE", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE PAST", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRESENT CONTINUOUS", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE PRESENT", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("SIMPLE FUTURE", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PAST CONTINUOUS", 12);
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("PRESENT PERFECT SIMPLE", 12);

-- OUTROS
INSERT INTO categoria (nome) VALUES ("OUTROS");
INSERT INTO sub_categoria (nome, id_categoria) VALUES ("OUTROS", 13);


-- USUÁRIO
INSERT INTO usuario (nome, cpf, email, telefone, login, senha, status_ativo) VALUES 
("Ian Benedito Almeida", "506.726.137-43", "ian_benedito_almeida@coldblock.com.br", "(43) 99120-3042", "ian", "b54a95127a4b573f41e335fdbd339dcc2208fbfb1ae0b6fab7599d6e2d6ec754", TRUE);
INSERT INTO usuario (nome, cpf, email, telefone, login, senha, status_ativo) VALUES 
("Valentina Lavínia Isabelle Castro", "254.100.896-18", "valentina_castro@teravida.com.br", "(41) 2749-0455", "valentina", "ba2d0830e65eadb371708af3592703d68353b5566093002111df7c34f89c9ff0", TRUE);
INSERT INTO usuario (nome, cpf, email, telefone, login, senha, status_ativo) VALUES 
("José Danilo dos Santos", "046.349.843-77", "jose-dossantos70@aspadvocacia.com", "(79) 99773-0287", "jose", "1ec4ed037766aa181d8840ad04b9fc6e195fd37dedc04c98a5767a67d3758ece", TRUE);
INSERT INTO usuario (nome, cpf, email, telefone, login, senha, status_ativo) VALUES 
("André Leonardo Jesus", "738.161.742-05", "andre_leonardo_jesus@stilomovelaria.com.br", "(48) 98446-0449", "andre", "bd01b0b648c2c64eb1bddd9361d9972ea684b344fedc4d166654a85e8919e7ad", TRUE);


-- PERGUNTAS
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (1,'2020-05-05',1,'Assinale a alternativa abaixo que NÃO representa uma das características gerais da hidrografia brasileira.',0,1,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (2,'2021-06-04',1,'(Fatec-SP) – Uma das características a ser reconhecida no feudalismo europeu é:',0,7,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (3,'2022-01-05',1,'(Cefet/MG - 2017) Em um triângulo retângulo, a tangente de um de seus ângulos agudos é 2. Sabendo-se que a hipotenusa desse triângulo é 5, o valor do seno desse mesmo ângulo é',0,15,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (4,'2019-11-20',1,'(UFRN) A obra de Gregório de Matos – autor que se destaca na literatura barroca brasileira – compreende:',0,23,2);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (5,'2012-06-05',1,'Sobre a recombinação gênica é correto afirmar que:',0,32,2);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (6,'2015-07-06',1,'(UFBA) Em relação aos aspectos energéticos envolvidos nas transformações químicas, pode-se afirmar:',0,42,2);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (7,'2018-03-27',1,'(ITA-SP) Considere uma mistura de gases H2 e N2 , em equilíbrio térmico. Sobre a energia cinética média e sobre a velocidade média das moléculas de cada gás, pode-se concluir que:',0,46,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (8,'2015-09-10',1,'Quais são as ginásticas competitivas?',0,53,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (9,'2019-05-06',1,'(Fuvest-SP) O Estado moderno absolutista atingiu seu maior poder de atuação no século XVII. Na arte e na economia suas expressões foram respectivamente:',0,57,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (10,'2011-02-17',1,'(UEM-2011) O evolucionismo social do século XIX teve um papel fundamental na constituição da sociologia como ramo científico. Sobre essa corrente de pensamento, que reunia autores como Augusto Comte e Herbert Spencer, assinale o que for correto.',0,65,4);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (11,'2016-05-19',1,'(UFPE) Os gregos construíram reflexões importantes para a formação do pensamento ocidental, contribuindo para compreender o mundo e a sua complexidade.Sócrates, um dos seus filósofos mais conhecidos:',0,73,4);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (12,'2013-09-13',1,'Em relação à frase Is it that difficult? é correto afirmar que:',0,78,4);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (13,'2022-07-04',1,'Quantas patas tem um cachorro?',0,30,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (14,'2022-07-04',1,'Qual é a soma da operação matemática \"2+2+(1+1)\"?',1,22,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (15,'2022-07-04',1,'Qual é a ordem de precedencia em uma equação matemática?',0,22,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (16,'2022-07-04',1,'Resolva o seguinte cálculo e assinale a alternativa correta: \"2a + 2b - 3c\", sendo a = 1, b = 3 e c = 2.',1,22,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (17,'2022-07-04',1,'25 representa quantos por cento de 200?',0,17,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (18,'2022-07-04',1,'30 representa 15% de qual número?',0,17,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (19,'2022-07-04',1,'Em uma sala de aula há 30 alunos, dos quais 40% são meninas. Quantas meninas têm na sala?',0,17,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (20,'2022-07-04',1,'Júlia acertou 75% das questões de Matemática do teste e Mariana acertou 4/5. Quem acertou mais questões?',1,17,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (21,'2022-07-04',1,'Na promoção de uma loja de eletrodomésticos, um aparelho de som que custava R$ 400,00 teve um desconto de 12%. Quanto o cliente que decidir comprar o equipamento pagará?',0,22,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (22,'2022-07-04',1,'Em um concurso, 520 candidatos se inscreveram. No dia da prova apenas 364 candidatos compareceram. Neste caso, qual foi a porcentagem dos candidatos que faltaram a prova?',0,17,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (23,'2022-07-04',1,'Em uma indústria, o setor de qualidade constatou que um lote com 4500 peças, 180 apresentavam algum defeito. Para um lote ser aprovado é necessário que o número de peças com defeito seja inferior a 3%. Neste caso, o lote foi aprovado ou reprovado?',0,17,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (24,'2022-07-04',1,'Na última liquidação de verão, uma loja vendia todos os seus produtos com um desconto de 15%. Se uma camisa antes da liquidação custava R$ 145,00, quanto passou a custar na liquidação?',0,17,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (25,'2022-07-04',1,'Os vendedores de uma loja recebem mensalmente um salário fixo no valor de R$ 1200,00 e uma comissão de 6% referente ao valor total do que venderam no mês. Sendo assim, qual será o valor recebido por um vendedor que vendeu no mês R$ 14000,00?',0,17,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (26,'2022-07-04',1,'Em uma loja, uma máquina de lavar roupas custava R$ 1500,00 e seu preço sofreu um aumento de 3%. Logo após o aumento a loja resolveu fazer uma promoção oferecendo um desconto de 3% no mesmo produto. Qual o valor do produto após o aumento e após o desconto?\n\n',0,17,3);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (27,'2022-07-05',1,'Existem quantas pessoas no mundo aproximadamente?',0,3,1);
INSERT INTO pergunta (id,data_criacao,status_ativo,texto,visibilidade_privada,id_sub_categoria,id_usuario_proprietario) VALUES (28,'2022-07-05',1,'Assinale abaixo a alternativa que representa o gene recessivo.',0,32,1);


-- ALTERNATIVAS
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (1,1,0,'A maior parte dos rios brasileiros é abastecida por um regime pluvial, praticamente não havendo indícios de regimes de abastecimento nivais ou glaciais.',1);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (2,1,0,'A maioria dos rios do Brasil é perene e a minoria é intermitente.',1);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (3,1,0,'A hidrografia brasileira é rica em rios e pobre em lagos.',1);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (4,1,0,'Os rios do Brasil são exorreicos e deságuam quase sempre no Oceano Atlântico.',1);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (5,1,1,'Alguns rios brasileiros são muito usados para a navegação, a exemplo do Rio Amazonas.',1);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (6,1,0,'A sociedade feudal era semelhante ao sistema de castas.',2);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (7,1,0,'Os ideais de honra e fidelidade vieram das instituições dos hunos.',2);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (8,1,1,'Vilões e servos estavam presos a várias obrigações, entre elas, o pagamento anual de capitação, talha e banalidades.',2);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (9,1,0,'A economia do feudo era dinâmica, estando voltada para o comércio dos feudos vizinhos.',2);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (10,1,0,'As relações de produção eram escravocratas.',2);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (11,1,0,'4/5',3);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (12,1,0,'√5/4',3);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (13,1,0,'√5/5',3);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (14,1,1,'2√5/5',3);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (15,1,0,'Poesia épico-amorosa e obras dramáticas.',4);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (16,1,0,'Poesia satírica e contos burlescos.',4);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (17,1,1,'Poesia lírica, de caráter religioso e amoroso, e poesia satírica.',4);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (18,1,0,'Poesia confessional e autos religiosos.',4);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (19,1,0,'Poesia lírica e teatro de costumes.',4);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (20,1,0,'A recombinação gênica pode ser homóloga ou heteróloga.',5);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (21,1,0,'A principal diferença entre os tipos de recombinação é que ocorrem em etapas diferentes da mitose.',5);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (22,1,1,'A recombinação gênica é classificada em homóloga e não-homóloga.',5);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (23,1,0,'Enquanto um tipo de recombinação permite a variabilidade, o outro tipo apresenta limitações.',5);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (24,1,0,'A queima da parafina de uma vela exemplifica um processo endotérmico.',6);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (25,1,1,'A vaporização da água de uma piscina pela ação da luz solar exemplifica um processo endotérmico.',6);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (26,1,0,'A combustão do álcool hidratado em motores de automóveis exemplifica um processo endotérmico.',6);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (27,1,0,'A formação de um iceberg a partir da água do mar exemplifica um processo endotérmico.',6);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (28,1,0,'O valor de ΔH de uma transformação depende exclusivamente do estado físico dos reagentes.',6);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (29,1,0,'as moléculas de H2  e N2  tem a mesma energia cinética média e a mesma velocidade média.',7);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (30,1,0,'Ambas tem a mesma velocidade média, mas as moléculas de N2 tem maior energia cinética média.',7);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (31,1,0,'Ambas tem a mesma velocidade média, mas as moléculas de H2 tem maior energia cinética média.',7);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (32,1,1,'Ambas tem a mesma energia cinética média, mas as moléculas de N2 tem maior velocidade média.',7);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (33,1,0,'Ambas tem a mesma energia cinética média, mas as moléculas de H2 tem maior velocidade média.',7);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (34,1,0,'Contorcionismo, ginástica cerebral, ginástica laboral e hidroginástica.',8);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (35,1,1,'Ginástica de trampolim, ginástica rítmica, ginástica artística e ginástica acrobática',8);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (36,1,0,'Ginástica cerebral, ginástica artística, ginástica laboral e ginástica de trampolim.',8);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (37,1,0,'Contorcionismo,ginástica rítmica, ginástica cerebral.',8);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (38,1,0,'Ginástica rítmica, ginástica artística e ginástica acrobática.',8);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (39,1,0,'rococó e liberalismo.',9);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (40,1,0,'renascentismo e capitalismo.',9);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (41,1,1,'barroco e mercantilismo.',9);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (42,1,0,'maneirismo e colonialismo.',9);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (43,1,0,'classicismo e economicismo.',9);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (44,1,0,'O evolucionismo define que as estruturas, naturais ou sociais, passam por processo de diferenciação e integração que levam ao seu aprimoramento.',10);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (45,1,1,'O evolucionismo propõe que a evolução das sociedades ocorre em estágios sucessivos de racionalização. ',10);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (46,1,0,'O evolucionismo considera o Estado Militar como a forma mais evoluída de organização social, fundamentada na cooperação interna e obrigatória. ',10);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (47,1,0,'O evolucionismo rejeita o modelo político e econômico liberal, baseado na livre iniciativa e no laissez-faire, considerando-o uma orientação contrária à evolução social.',10);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (48,1,0,'O evolucionismo defende a unidade biológica e cognitiva da espécie humana, independente de variações particulares.',10);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (49,1,0,'Defendeu a existência da democracia e a organização de uma Assembleia Popular para definir o governo ateniense.',11);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (50,1,0,'Polemizou com os filósofos sofistas que defendiam princípios religiosos diferentes dos princípios gregos.',11);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (51,1,1,'Teve muitas das suas teorias incorporadas ao pensamento idealista de Platão, outro grande pensador grego.',11);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (52,1,0,'Foi contra as reformas políticas defendidas por Aristóteles, pois era favorável à existência de um governo democrático.',11);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (53,1,0,'Propagou a necessidade do fortalecimento militar de Atenas, para evitar os ataques dos inimigos asiáticos.',11);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (54,1,0,'O verbo to be está no passado.',12);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (55,1,0,'O verbo to be está na primeira pessoa.',12);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (56,1,1,'Pode ser respondida com yes, it is.',12);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (57,1,0,'Pode ser respondida com no, it is.',12);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (58,1,0,'7',13);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (59,1,0,'2',13);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (60,1,0,'5',13);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (61,1,1,'4',13);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (62,1,0,'3',13);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (63,1,1,'6',14);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (64,1,0,'4',14);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (65,1,0,'10',14);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (66,1,0,'8',14);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (67,1,0,'12',14);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (68,1,1,'Parênteses; Expoentes; Multiplicação e Divisão; Somas e Subtração;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (69,1,0,'Expoentes; Parênteses; Multiplicação e Divisão; Somas e Subtração;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (70,1,0,'Multiplicação e Divisão; Parênteses; Expoentes; Somas e Subtração;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (71,1,0,'Multiplicação e Divisão; Somas e Subtração; Parênteses; Expoentes;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (72,1,0,'Somas e Subtração; Parênteses; Expoentes; Multiplicação e Divisão;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (73,1,0,'Parênteses; Multiplicação e Divisão; Expoentes; Somas e Subtração;',15);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (74,1,0,'5',16);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (75,1,0,'7',16);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (76,1,0,'10',16);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (77,1,1,'2',16);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (78,1,1,'12,5%',17);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (79,1,0,'15,5%',17);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (80,1,0,'16%',17);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (81,1,0,'20%',17);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (82,1,0,'150',18);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (83,1,1,'200',18);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (84,1,0,'350',18);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (85,1,0,'400',18);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (86,1,0,'10 meninas',19);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (87,1,1,'12 meninas',19);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (88,1,0,'15 meninas',19);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (89,1,0,'18 meninas',19);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (90,1,0,'Júlia',20);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (91,1,1,'Mariana',20);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (92,1,0,'As duas acertaram o mesmo número de questões.',20);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (93,1,0,'R$ 372,00',21);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (94,1,0,'R$ 342,00',21);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (95,1,0,'R$ 362,00',21);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (96,1,1,'R$ 352,00',21);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (97,1,0,'10%',22);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (98,1,0,'20%',22);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (99,1,1,'30%',22);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (100,1,0,'40%',22);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (101,1,0,'Aprovado com 1% de peças com defeito.',23);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (102,1,0,'Aprovado com 2% de peças com defeito.',23);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (103,1,0,'Reprovado com 3% de peças com defeito.',23);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (104,1,1,'Reprovado com 4% de peças com defeito.',23);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (105,1,0,'R$ 112,20',24);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (106,1,1,'R$ 123,25',24);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (107,1,0,'R$ 135,50',24);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (108,1,0,'R$ 140,15',24);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (109,1,1,'R$ 2040,00',25);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (110,1,0,'R$ 2080,00',25);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (111,1,0,'R$ 3020,00',25);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (112,1,0,'R$ 3040,00',25);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (113,1,0,'R$ 1555,00 com aumento e R$ 1498,65 com desconto.',26);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (114,1,0,'R$ 1545,00 com aumento e R$ 1500,00 com desconto.',26);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (115,1,1,'R$ 1545,00 com aumento e R$ 1498,65 com desconto.',26);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (116,1,0,'R$ 1555,00 com aumento e R$ 1500,00 com desconto.',26);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (117,1,0,'7 bilhões de pessoas',27);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (118,1,1,'8 bilhões de pessoas',27);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (119,1,0,'9 bilhões de pessoas',27);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (120,1,0,'7 milhões de pessoas',27);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (121,1,0,'8 milhões de pessoas',27);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (122,1,1,'aa',28);
INSERT INTO alternativa (id,status_ativo,status_correta,texto,id_pergunta) VALUES (123,1,0,'AA',28);


-- QUIZZES
-- IAN, GEOGRAFIA E HISTÓRIA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2020-05-30", "Aprender mais sobre as coisas", FALSE, 1);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Aprender mais sobre as coisas%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 1 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "HIDROGRAFIA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Aprender mais sobre as coisas%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 1 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "FEUDALISMO") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Aprender mais sobre as coisas%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "GEOGRAFIA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Aprender mais sobre as coisas%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "HISTÓRIA"));

-- IAN, GEOGRAFIA E MATEMÀTICA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2020-06-15", "Matemática quiz", FALSE, 1);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Matemática quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 1 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "HIDROGRAFIA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Matemática quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 1 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "TRIGONOMETRIA") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Matemática quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "MATEMÀTICA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 1 AND titulo LIKE "%Matemática quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "GEOGRAFIA"));


-- VALENTINA, PORTUGUÊS E BIOLOGIA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2018-10-17", "Português quiz", FALSE, 2);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Português quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 2 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "LITERATURA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Português quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 2 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "GENÉTICA") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Português quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "BIOLOGIA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Português quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "PORTUGUÊS"));

-- VALENTINA, BIOLOGIA E QUIMICA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2019-09-11", "Biologia quiz", FALSE, 2);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Biologia quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 2 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "TERMOQUÍMICA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Biologia quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 2 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "GENÉTICA") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Biologia quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "BIOLOGIA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 2 AND titulo LIKE "%Biologia quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "QUIMICA"));


-- jOSÉ, FISICA E EDUCAÇÃO FÍSICA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2021-04-18", "Física quiz", FALSE, 3);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Física quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 3 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "TERMODINÂMICA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Física quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 3 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "GINÁSTICA") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Física quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "FISICA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Física quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "EDUCAÇÃO FÍSICA"));

-- jOSÉ, FISICA E EDUCAÇÃO FÍSICA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2015-09-07", "Artística quiz", FALSE, 3);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Artística quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 3 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "BARROCO") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Artística quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 3 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "GINÁSTICA") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Artística quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "ARTES"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 3 AND titulo LIKE "%Artística quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "EDUCAÇÃO FÍSICA"));


-- ANDRÉ, SOCIOLOGIA E FILOSOFIA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2017-08-08", "Social filósofo quiz", FALSE, 4);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Social filósofo quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 4 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "INTRODUÇÃO A SOCIOLOGIA") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Social filósofo quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 4 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "SÓCRATES") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Social filósofo quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "SOCIOLOGIA"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Social filósofo quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "FILOSOFIA"));

-- ANDRÉ, INGLÊS E FILOSOFIA
INSERT INTO quiz (data_criacao, titulo, visibilidade_privada, id_usuario_proprietario) VALUES ("2017-08-08", "Filósofo inglês quiz", FALSE, 4);

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 4 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "VERB TO BE") LIMIT 1));

INSERT INTO quiz_pergunta (id_quiz, id_pergunta) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1),
(SELECT id FROM pergunta WHERE id_usuario_proprietario = 4 AND id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "SÓCRATES") LIMIT 1));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "INGLÊS"));

INSERT INTO categoria_quiz (id_quiz, id_categoria) VALUES (
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1),
(SELECT id FROM categoria WHERE nome = "FILOSOFIA"));


-- IAN APLICANDO QUIZ DO ANDRÉ
INSERT INTO aplicacao_quiz (data_aplicacao, id_quiz, id_usuario_aplicador) VALUES ("2022-02-05", 
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1), 1);

INSERT INTO emails_aplicacao_quiz (emails, id_aplicacao_quiz) values ((SELECT email FROM usuario WHERE nome = "Ian Benedito Almeida"), 1);
INSERT INTO emails_aplicacao_quiz (emails, id_aplicacao_quiz) values ((SELECT email FROM usuario WHERE nome = "André Leonardo Jesus"), 1);


-- ANDRÉ APLICANDO SEU PRÓRPIO QUIZ
INSERT INTO aplicacao_quiz (data_aplicacao, id_quiz, id_usuario_aplicador) VALUES ("2022-02-05", 
(SELECT id FROM quiz WHERE id_usuario_proprietario = 4 AND titulo LIKE "%Filósofo inglês quiz%" LIMIT 1), 4);

INSERT INTO emails_aplicacao_quiz (emails, id_aplicacao_quiz) values ((SELECT email FROM usuario WHERE nome = "Ian Benedito Almeida"), 2);


-- RESPOSTAS DO ANDRÉ DA APLICACAO DO IAN
INSERT INTO aplicacao_quiz_resultado (id_alternativa, id_aplicacao_quiz, id_usuario, data_resolucao) VALUES (
(SELECT alternativa.id FROM alternativa 
join pergunta on pergunta.id = alternativa.id_pergunta and pergunta.id_usuario_proprietario = 4
join sub_categoria on sub_categoria.id = pergunta.id_sub_categoria and pergunta.id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "SÓCRATES")
WHERE alternativa.status_correta = FALSE LIMIT 1)
, 1, 4, "2022-03-05");

INSERT INTO aplicacao_quiz_resultado (id_alternativa, id_aplicacao_quiz, id_usuario, data_resolucao) VALUES (
(SELECT alternativa.id FROM alternativa 
join pergunta on pergunta.id = alternativa.id_pergunta and pergunta.id_usuario_proprietario = 4
join sub_categoria on sub_categoria.id = pergunta.id_sub_categoria and pergunta.id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "VERB TO BE")
WHERE alternativa.status_correta = TRUE LIMIT 1)
, 1, 4, "2022-03-05");

-- RESPOSTAS DO IAN DA APLICACAO DO ANDRÉ
INSERT INTO aplicacao_quiz_resultado (id_alternativa, id_aplicacao_quiz, id_usuario, data_resolucao) VALUES (
(SELECT alternativa.id FROM alternativa 
join pergunta on pergunta.id = alternativa.id_pergunta and pergunta.id_usuario_proprietario = 4
join sub_categoria on sub_categoria.id = pergunta.id_sub_categoria and pergunta.id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "SÓCRATES")
WHERE alternativa.status_correta = TRUE LIMIT 1)
, 2, 1, "2022-03-06");

INSERT INTO aplicacao_quiz_resultado (id_alternativa, id_aplicacao_quiz, id_usuario, data_resolucao) VALUES (
(SELECT alternativa.id FROM alternativa 
join pergunta on pergunta.id = alternativa.id_pergunta and pergunta.id_usuario_proprietario = 4
join sub_categoria on sub_categoria.id = pergunta.id_sub_categoria and pergunta.id_sub_categoria = (SELECT id FROM sub_categoria WHERE nome = "VERB TO BE")
WHERE alternativa.status_correta = TRUE LIMIT 1)
, 2, 1, "2022-03-06");
