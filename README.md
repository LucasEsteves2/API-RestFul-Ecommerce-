<div align="center">
<i><h6> API-RESTFUL. [SERRATEC] <br>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="https://apiserratec.herokuapp.com/">https://apiserratec.herokuapp.com</a>

</div>
<a name="back-to-top">

<p align="center">
  <a href="">
    <img width="300px" src="" alt="">
   </a>
</p>

 <p>
    <h2 align="center">
 Atividade avaliativa de java2
  </h2>
  </p> 
  </br>
<br>
<div align="center">
  <img width="500px" src="https://i.imgur.com/H5Pd8Ah.png">
  <br>  </br>
   <br>  </br>
</div>
<br>

## 🔑API Ecommerce SERRATEC [GRUPO3]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="https://apiserratec.herokuapp.com/swagger-ui.html#/">**Documentação [SWAGGER]**  </a>

<details>
  <summary>✔️ Funcionalidades:</summary>
      <p align="justify">
      1:  CRUD Cliente<br>
      2:  CRUD Produto <br>
      3:  CRUD PEDIDO<br>
      4:  CRUD ENDERECO<br>
      5:  Pesquisas personalizadas<br>
      6:  Pesquisas por paginação<br>
      7:  Armazenamento de fotos utilizando o AMAZON S3<br>
      8:  Pagamento com cartao <br>
      9:  Escolher opção de pagamento<br>
     10: Desconto por pedido<br>
     11: Validação de cpf<br>
     12: Validação de E-mail<br>
     13: Exceptions Personalizadas<br>
     14: Codigos de retorno no padrão do http<br>
     15: TOKENS DE AUTENTICAÇÃO <br>
     16: Armazenamento de imagens <br>
     17: Documentação com swagger <br>
      
  </details>
  
  <details>
  <summary>👨‍💼 Regras de negocio:</summary>
      <p align="justify">
      1:  Categoria possui varios produtos <br>
      2:  Produto pertence somente a uma categoria <br>
      3:  Cliente deve possuir OBRIGATORIAMENTE UM CELULAR<br>
      4:  Cliente deve possuir OBRIGATORIAMENTE UM ENDEREÇO<br>
      5:  Endereço nao pode existir sem um cliente  <br>
      6:  Categoria com produtos anexados nao podera ser deletada
  </details>
  
  
<details>
<summary>Diagrama UML</summary>
<img align="center" src="assets/Class Diagrama.jpg">
</details>

  
  
<BR>

  
  
⚠️🔃**Faça o login através do endpoint /login para poder acessar todos os endpoints  <br><br> 

⚠️🔃**UTILIZAR O SEGUINTE MODELO PARA INSERIR UM NOVO PEDIDO <br><br> 
{
 "cliente" : {"id" : 1},
 "enderecoDeEntrega" : {"id" : 1},
 "pagamento" : {
 "numeroDeParcelas" : 10,
 "@type": "pagamentoComCartao"
 },
 "itens" : [
 {
 "quantidade" : 2,
 "produto" : {"id" : 3}
 },
 {
 "quantidade" : 1,
 "produto" : {"id" : 1}
 }
 ]
}



<br>
     

## 🔒Autenticação [LOGIN-TOKEN]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**Realizar login através do endpoint <a href="https://apiserratec.herokuapp.com/login">/login </a>, será gerado um TOKEN de 15 minutos**  

  <div align="center">
  <img width="1000px" src="assets/Login.gif">
</div>

### 📖Se o Usuario estiver logado ele poderá:
- Adicionar foto (FOTO DE PERFIL)
- Acessar o endPoint /security/clientes.<br> 
- Acessar o endPoint /security/endereco.<br> 
- Visualizar todos os endereços cadastrados pelo id ou pela cidade.<br> 
- Visualizar todos os clientes (todas informações).<br> 
- Buscar cliente por CPF.<br> 
 - TOKEN DE AUTENTICAÇÃO DE 15 MINTUOS  <br>

  ** Realizar um post no endpoint https://apiserratec.herokuapp.com/login com o e-mail e senha**
<br></br>
<br>


 ## ☁ Upload de Imagens [AWS-S3 BUCKECT]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="https://apiserratec.herokuapp.com/swagger-ui.html#/">**Armazenamento de imagens utilizando o servidor da amazon**  </a>

   <div align="center">
  <img width="1000px" src="assets/aws.gif">
</div>
 
  
  
  <br></br>
<BR>
  
   ## ✔️ INSERINDO PEDIDO [END-POINT]
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="https://apiserratec.herokuapp.com/swagger-ui.html#/">**Inserindo pedidos através do end point /pedidos**  </a>
 
  
  <div align="center">
  <img width="1000px" src="assets/insert pedido.gif">
</div>
  <br></br>
  ⚠️🔃**UTILIZAR O SEGUINTE MODELO PARA INSERIR UM NOVO PEDIDO <br><br> 
{
 "cliente" : {"id" : 1},
 "enderecoDeEntrega" : {"id" : 1},
 "pagamento" : {
 "numeroDeParcelas" : 10,
 "@type": "pagamentoComCartao"
 },
 "itens" : [
 {
 "quantidade" : 2,
 "produto" : {"id" : 3}
 },
 {
 "quantidade" : 1,
 "produto" : {"id" : 1}
 }
 ]
}
<br>
  <br>  </br>
  
## <img  height="45px" align="center" src="https://github.com/luqui2/Sistema-para-Viagens-/blob/main/src/imagens/foguete.gif"> Tecnologia Utilizada
- [**DBeaver**](https://dbeaver.io/)    [(*Documentação*)](https://dbeaver.com/docs/wiki/)
- [**Mailtrap**](https://mailtrap.io/)    [(*Documentação*)](https://mailtrap.docs.apiary.io/#)    
- [**Java**](https://www.oracle.com/java/technologies/)    [(*Documentação*)](https://docs.oracle.com/en/java/)    [(*Documentação MDN*)](https://developer.mozilla.org/en-US/docs/Glossary/Java)
- [**PostgreSQL**](https://www.postgresql.org/)    [(*Documentação*)](http://pgdocptbr.sourceforge.net/pg80/index.html)
- [**Postman**](https://www.postman.com/downloads/)    [(*Documentação*)](https://learning.postman.com/docs/getting-started/introduction/)
- [**Spring Boot**](https://spring.io/)    [(*Documentação*)](https://spring.io/projects/spring-boot)
- [**Spring Tools 4**](https://spring.io/tools)    [(*Documentação*)](https://github.com/spring-projects/sts4/wiki)
- [**Swagger**](https://swagger.io/)    [(*Documentação*)](https://swagger.io/solutions/api-documentation/) 
- [**AWS**](https://swagger.io/)    [(*Documentação*)](https://docs.aws.amazon.com/pt_br/)      
     
<br>
  
 
## <img height="45px" align="center" src="https://github.com/luqui2/Sistema-para-Viagens-/blob/main/src/imagens/set.gif">   Desenvolvimento:
- GRUPO 03: [**INTEGRANTES**] 
  <br>
  - Lucas Esteves
  - Natalino Esteves
  - Felipe Antunes
  - Lais Jarlita
  - Rodrigo Ternis
  - Leticia de Souza

 <br>
<div align="center">      
 

  <br></br>
 
 </div>
<br> 
<br>
</p>



&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;⬆️[**Voltar ao Topo**](#back-to-top)⬆️
