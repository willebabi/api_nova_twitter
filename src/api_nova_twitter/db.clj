(ns api_nova_twitter.db
  (:use korma.db))

(defdb db {:classname "org.sqlite.JDBC"
             :subprotocol "sqlite"
             :subname "src/api_nova_twitter/db/dev.sqlite3"})