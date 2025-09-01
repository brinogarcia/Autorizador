# Autorizador

## 📌 Descrição
Uma solução para uma api de autorização de transações!
No problema envolvia uma fila SQS, porém pensando na solução, resolvi criar uma base de dados MySQL simples com duas tabelas, Account e Transaction!
Criei na necessidade de armazenar informações, dado que as contas criadas estavam vindo através da fila, e pensando que poderiam realizar várias transações devemos ter um local onde consultar a conta e atualiza-lá!
A tabela Transaction foi somente para armazenar as informações de transação, por questões de auditoria ou histórico, nesses casos é sicutivel quais dados podem ser armazenador, levando em considerção a lei de proteção de dados!
Deixei dois diagramas explicando um pouco o fluxo da aplicação!
Não foquei em teste unitário, dado o tempo que consegui priorizar para o desenvolvimento, então foquei no funcionamento!
Outro ponto é que pensei em criar outra aplicação para fazer a função de armazenar as contas na base , assim dividir as responsabilidades e processamento, porém acabei não o criando!

## 🛠️ Tecnologias Utilizadas

- [Java 17]
- [Maven 3.9.11]
- [MySQL]
- [DOCKER]
- ...

## 📦 Instalação
Para a execução será necessário ter o ambiente configurado com SDK do JAVA 17, Maven 3.9.11, Docker e aws cli caso queira testar a fila SQS!
Incluí no mesmo arquivo dockercompose o service do MySQL, e um script para a criação de tabelas na pasta init, então tenho o volume mapeando o arquivo da pasta init.
Aguarde a conclusão da inicialização do docker para fazer o start da aplicação!

```bash
# Clone o repositório
git clone https://github.com/usuario/nome-do-projeto.git

# Acesse a pasta do projeto
cd nome-do-projeto

# Na pasta Docker
Dentro da pasta docker execute o comando "Docker compose up"
Isso fará que os serviços sejam executados

# Rode o projeto
Na pasta raiz do projeto onde tem o arquivo pom.xml
Execute o comando mvn clean install para o build.
Caso queira manter na linha de comando execute "mvn spring-boot:run" para subir a aplicação
Ou caso preferir utilize uma IDE de sua preferencia! 




