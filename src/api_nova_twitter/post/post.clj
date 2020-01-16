(ns api_nova_twitter.post.post
  (:require [korma.db :refer :all]
            [korma.core :refer :all]
            [api_nova_twitter.db :refer :all]))

(defentity post)

(defn find-all [id_user]
  (select post
    (where {:id_user id_user})
  )
)

(defn find-by-id [id]
  (select post
          (where {:id id})
          (limit 1)))

(defn create [texto id_post_ori id_user]
  (insert post
          (values {:texto texto :id_post_ori id_post_ori :id_user id_user})))

(defn update-by-id [id texto id_post_ori id_user]
  (update post
          (set-fields {:texto texto :id_post_ori id_post_ori :id_user id_user})
          (where {:id id})))

(defn delete-by-id [id]
  (delete post
          (where {:id id})))