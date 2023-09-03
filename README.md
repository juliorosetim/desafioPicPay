# desafioPicPay
fazendo o desafio que tem no github do picpay em java


#### Projeto desenvolvido para estudos

foi utilizado uma base de dados em postgres(Docker)
segue abaixo os camandos para utilizar o postgres via docker

##### criar um volume
    docker volume create postgres-data

##### iniciar um container com um volume criado
    docker run --name postgres -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v postgres-data:/var/lib/postgresql/data postgres

##### depois de criado o container, das proximas vezes só precisa rodar o seguinte comando
    docker start postgres
