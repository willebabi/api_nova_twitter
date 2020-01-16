# api_nova_twitter

Willian de Oliveira Wagner

## Intalações

Siga a instalação da linguagem no seguinte endereço:
https://clojure.org/guides/getting_started


Intale o gerenciador de pacotes para o clojure no seguinte endereço:
You will need [Leiningen][] 2.0.0 or above installed.
[leiningen]: https://github.com/technomancy/leiningen

## Para rodar o projeto

Para iniciar um servidor web para o aplicativo, execute:

    lein ring server

## Ações disponíveis

Para executar cada uma das ações, seguem abaixo os comandos:

# Users
Criando um usuário:
curl -X POST localhost:3000/users -H "Content-Type: application/json" -d '{"nome":"Willian Wagner", "email":"will.wag@gmail.com", "senha": "123", "fone": "(48)996379600"}'

Listando todos os user’s:
curl -X GET localhost:3000/users

Editando um user:
curl -X PUT localhost:3000/users/1 -H "Content-Type: application/json" -d '{"nome":"Willian O Wagner", "email":"will.wag@gmail.com", "senha": "123", "fone": "(48)996379600"}'

Encontrando um user:
curl -X GET localhost:3000/users/1

Removendo um user:
curl -X DELETE localhost:3000/users/1

# Seguir
Criando um seguir:
curl -X POST localhost:3000/seguir -H "Content-Type: application/json" -d '{"id_user":1, "id_user_seguir":2}'

Listando todos os seguir:
curl -X GET localhost:3000/seguir

Encontrando um seguir:
curl -X GET localhost:3000/seguir/1

Removendo o seguir:
curl -X DELETE localhost:3000/seguir/1

# Post (twitter)
Criando um post:
curl -X POST localhost:3000/posts -H "Content-Type: application/json" -d '{"texto":"Gostaria de trabalhar na Upnid!!", "id_post_ori":null, "id_user": 1}'

Listando todos os post’s do usuário:
curl -X GET localhost:3000/posts/user/1

Editando um post:
curl -X PUT localhost:3000/posts/1 -H "Content-Type: application/json" -d '"texto":"Gostaria muito de trabalhar na Upnid!!", "id_post_ori":null, "id_user": 1'

Encontrando um post:
curl -X GET localhost:3000/posts/1

Removendo um post:
curl -X DELETE localhost:3000/posts/1

# Curtir
Criando um curtir:
curl -X POST localhost:3000/curtir -H "Content-Type: application/json" -d '{"id_post":1, "id_user": 1}'

Removendo a curtida:
curl -X DELETE localhost:3000/curtir/1
