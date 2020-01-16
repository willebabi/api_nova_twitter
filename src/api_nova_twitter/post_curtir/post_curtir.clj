(ns api_nova_twitter.post_curtir.post_curtir
    (:require [korma.db :refer :all]
              [korma.core :refer :all]
              [api_nova_twitter.db :refer :all]))
  
  (defentity post_curtir)
  
  (defn find-all []
    (select post_curtir))
  
  (defn find-by-id [id]
    (select post_curtir
            (where {:id id})
            (limit 1)))
  
  (defn create [id_post id_user]
    (insert post_curtir
            (values {:id_post id_post :id_user id_user})))
  
  (defn update-by-id [id id_post id_user]
    (update post_curtir
            (set-fields {:id_post id_post :id_user id_user})
            (where {:id id})))
  
  (defn delete-by-id [id]
    (delete post_curtir
            (where {:id id})))