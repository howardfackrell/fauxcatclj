(ns user
  (:require [fauxcatclj.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [fauxcatclj.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'fauxcatclj.core/repl-server))

(defn stop []
  (mount/stop-except #'fauxcatclj.core/repl-server))

(defn restart []
  (stop)
  (start))


