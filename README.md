# Encurtador de URL
Tecnoligias utilizadas: 
- JSF 2.2
- PrimeFaces 7.0
- Hibernate
- MySQL 8.0.15
- Maven

Este projeto consiste de 3 telas, sendo elas, uma tela de login, outra de listagem das URLs encurtadas geradas pela usuário logado, e uma tela para a criação da URL encurtada.
Além disso, também foi implementado um Web Service para o redirecionamento da URL encurtada para a URL correspondente. 

## Scripts de Banco

Foi adicionado o arquivo "creation_scripts.sql" com os scripts de criação do banco de dados no diretório "WebContent/META-INF/sqls".
Entre os scripts, esta o seguinte comando de criação de 3 usuários iniciais:

- Usuario: daniel
- Senha: senha <br/>
INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('daniel', 'e8d95a51f3af4a3b134bf6bb680a213a', 'Daniel Galvão');

- Usuario: bill
- Senha: password <br/>
INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('bill', '5f4dcc3b5aa765d61d8327deb882cf99', 'Bill Gates');

- Usuario: jobs
- Senha: secret <br/>
INSERT INTO encurtadorURLJSF_db.Usuario
(login, senha, nome)
VALUES('jobs', '5ebe2294ecd0e0f08eab7690d2a6ee69', 'Steve Jobs');
