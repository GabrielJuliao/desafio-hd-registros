# desafio-hd-registros

### Criar um usuario
POST localhost:8080/signup <br>
Accept: application/json <br>
Content-Type: application/json

{<br>
"email": "johndoe@domain.domain",<br>
"password": "password",<br>
"firstName": "john",<br>
"lastName": "doe"<br>
}

### Consultar saldo (Autorização basica em base64 usuario:senha)
GET localhost:8080/conta/saldo <br>
Accept: application/json <br>
Authorization: Basic am9obmRvZUBkb21haW4uZG9tYWluOnBhc3N3b3Jk

### Transferir (Autorização basica em base64 usuario:senha)
{valor em double}/{id da conta de destino} <br>
POST localhost:8080/conta/transferir/10.0/1 <br>
Accept: application/json <br>
Authorization: Basic am9obmRvZUBkb21haW4uZG9tYWluOnBhc3N3b3Jk

### Consultar extrato (Autorização basica em base64 usuario:senha)
GET localhost:8080/conta/extrato <br>
Accept: application/json <br>
Authorization: Basic am9obmRvZUBkb21haW4uZG9tYWluOnBhc3N3b3Jk


### Autorização Http basica
'username:password' em Base64 <br>
Authorization: Basic <Base64credentials> 






