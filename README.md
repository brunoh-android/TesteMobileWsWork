# TesteMobileWsWork

App para captura de leads, da escolha de um carro do usuario

BIBLIOTECAS UTILIZADAS:

Coroutines 
Databinding
Retrofit
Room/DB
RecyclerView
okhttp3

Foi usado Retrofit para importar do dados da API "https://wswork.com.br/cars.json"
Os dados dessa api são transferidos para uma recyclerView informando todos os dados contidos na api.
Implementado um Button(EUQUERO) para que o usuario selecione um carro e siga para a proxima activity,
Nessa nova activity o usuario digital um tipo de NickName ou nome+idade e salva a preferencia da escolha do carro e o Nome.
Se tudo estiver correto um AlertDialog é aberta informando que tudo esta correto, ou outra Dialog é aberta informando algo deu errado.

Usei okhttp3 para interceptar os dados salvo na Room, e fazer um POST na https://www.wswork.com.br/cars/leads/

Toda vez que o app é aberto ele mostra a lista dos usuarios ja cadastrados no Banco de Dados
Alterei algumas cores e icone do app para ficar um pouco parecido com as cores da logo da empresa WsWork

![gif](https://user-images.githubusercontent.com/67665152/169662016-3d802b1c-b9db-45dc-bc4d-53163e8edf46.gif)

