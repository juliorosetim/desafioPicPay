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

 - ## Salva um cadastro de pessoa
method: `POST`  
`localhost:8080/users`

    {
    	"firstName":  "teste1",
    	"lastName":  "Silva",
    	"cpfCnpj":  "144661116622",
    	"email":  "teste@teste.com",
    	"password":  "1234",
    	"userType":  "MERCHANT"
    }

 - ## Lista todos os cadastros salvos no banco
method: `GET`  

    localhost:8080/users

 - ## Atualiza o saldo de uma carteira por "entrada de cartão de crédito"
method: `PUT`  
`localhost:8080/wallet`     

    {
    	"user":  {
    					"id":  2,
    					"firstName":  "Julio",
    					"lastName":  "Rosetim",
    					"cpfCnpj":  "1446616622",
    					"email":  "julio@teste.com",
    					"password":  "1234",
    					"userType":  "COMMON"
    	},
    	"balance":  5000,
    	"id":  2
    }

 - ## Lista as carteiras de todos os cadastros
method: `GET`  
`localhost:8080/wallet`

 - ## lista a carteira de um cadastro especifico
method: `GET`  

`localhost:8080/wallet/{idCadastro}`

 - ## Faz um pagamento
method: `POST`  

`localhost:8080/transaction`   

    {
    	"userTo":  9,
    	"userFrom":  11,
    	"value":  150
    }
