(ns api_nova_twitter.users.users
    (:require [korma.db :refer :all]
              [korma.core :refer :all]
              [api_nova_twitter.db :refer :all]))
  
  (defentity users)
  
  (defn find-all []
    (select users))
  
  (defn find-by-id [id]
    (select users
            (where {:id id})
            (limit 1)))
  
  (defn create [nome email senha fone]
    (insert users
            (values {:nome nome :email email :senha senha :fone fone})))
  
  (defn update-by-id [id nome email senha fone]
    (update users
            (set-fields {:nome nome :email email :senha senha :fone fone})
            (where {:id id})))
  
  (defn delete-by-id [id]
    (delete users
            (where {:id id})))