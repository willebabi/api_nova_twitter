(ns api-nova-twitter.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [api_nova_twitter.users.users :as users]
            [api_nova_twitter.seguir_users.seguir_users :as seguir_users]
            [api_nova_twitter.post.post :as post]
            [api_nova_twitter.post_curtir.post_curtir :as post_curtir]
            [ring.middleware.json :refer [wrap-json-response wrap-json-body]]))

(defroutes all-routes
  (GET "/posts/user/:id_user" [id_user]
    (post/find-all id_user))
(POST "/posts" req
  (let [texto (get-in req [:body "texto"])
        id_post_ori (get-in req [:body "id_post_ori"])
        id_user (get-in req [:body "id_user"])]
    (post/create texto id_post_ori id_user)))
(GET "/posts/:id" [id]
  (post/find-by-id id))
(PUT "/posts/:id" req
  (let [id (read-string (get-in req [:params :id]))
        texto (get-in req [:body "texto"])
        id_post_ori (get-in req [:body "id_post_ori"])
        id_user (get-in req [:body "id_user"])]
    (post/update-by-id id texto id_post_ori id_user)
    (post/find-by-id id)))
(DELETE "/posts/:id" [id]
  (post/delete-by-id id)
  (str "Deleted post " id))

  (GET "/users" []
    (users/find-all))
(POST "/users" req
  (let [nome (get-in req [:body "nome"])
        email (get-in req [:body "email"])
        senha (get-in req [:body "senha"])
        fone (get-in req [:body "fone"])]
    (users/create nome email senha fone)))
(GET "/users/:id" [id]
  (users/find-by-id id))
(PUT "/users/:id" req
  (let [id (read-string (get-in req [:params :id]))
                  nome (get-in req [:body "nome"])
                  email (get-in req [:body "email"])
                  senha (get-in req [:body "senha"])
                  fone (get-in req [:body "fone"])]
    (users/update-by-id id nome email senha fone)
    (users/find-by-id id)))
(DELETE "/users/:id" [id]
  (users/delete-by-id id)
  (str "Deleted users " id))

  (GET "/curtir" []
    (post_curtir/find-all))
(POST "/curtir" req
  (let [id_post (get-in req [:body "id_post"])
        id_user (get-in req [:body "id_user"])]
    (post_curtir/create id_post id_user)))
(GET "/curtir/:id" [id]
  (post_curtir/find-by-id id))
(PUT "/curtir/:id" req
  (let [id (read-string (get-in req [:params :id]))
        id_post (get-in req [:body "id_post"])
        id_user (get-in req [:body "id_user"])]
    (post_curtir/update-by-id id id_post id_user)
    (post_curtir/find-by-id id)))
(DELETE "/curtir/:id" [id]
  (post_curtir/delete-by-id id)
  (str "Deleted curtir " id))

  (GET "/seguir" []
    (seguir_users/find-all))
(POST "/seguir" req
  (let [id_user (get-in req [:body "id_user"])
        id_user_seguir (get-in req [:body "id_user_seguir"])]
    (seguir_users/create id_user id_user_seguir)))
(GET "/seguir/:id" [id]
  (seguir_users/find-by-id id))
(PUT "/seguir/:id" req
  (let [id (read-string (get-in req [:params :id]))
        id_user (get-in req [:body "id_user"])
        id_user_seguir (get-in req [:body "id_user_seguir"])]
    (seguir_users/update-by-id id id_user id_user_seguir)
    (seguir_users/find-by-id id)))
(DELETE "/seguir/:id" [id]
  (seguir_users/delete-by-id id)
  (str "Deleted seguir " id))

(route/not-found "Not Found"))

(def app
  (-> all-routes
      wrap-json-response
      wrap-json-body))
