# desafioPicPay
fazendo o desafio que tem no github do picpay em java


#### Projeto desenvolvido para estudos

foi utilizado uma base de dados em postgres(Docker)
segue abaixo os camandos para utilizar o postgres via docker

O Controle do banco esta implementado para ser feito pelo flyway  


**AVISO**
Ao clonar o projeto, não esquecer de alterar as configuraçãoe do banco no arquivo application.properties

Caso não tenha o docker instalado em sua maquina, pode ser utilizado a documentação do docker para instalar
[Docker](https://docs.docker.com/)

##### criar um volume
    docker volume create postgres-data

##### iniciar um container com um volume criado
    docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v postgres-data:/var/lib/postgresql/data postgres

##### depois de criado o container, das proximas vezes só precisa rodar o seguinte comando
    docker start postgres
