(ns api_nova_twitter.seguir_users.seguir_users
    (:require [korma.db :refer :all]
              [korma.core :refer :all]
              [api_nova_twitter.db :refer :all]))
  
  (defentity seguir_users)
  
  (defn find-all []
    (select seguir_users))
  
  (defn find-by-id [id]
    (select seguir_users
            (where {:id id})
            (limit 1)))
  
  (defn create [id_user id_user_seguir]
    (insert seguir_users
            (values {:id_user id_user :id_user_seguir id_user_seguir})))
  
  (defn update-by-id [id id_user id_user_seguir]
    (update seguir_users
            (set-fields {:id_user id_user :id_user_seguir id_user_seguir})
            (where {:id id})))
  
  (defn delete-by-id [id]
    (delete seguir_users
            (where {:id id})))