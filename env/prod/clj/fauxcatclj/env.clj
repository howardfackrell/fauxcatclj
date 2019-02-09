(ns fauxcatclj.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[fauxcatclj started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[fauxcatclj has shut down successfully]=-"))
   :middleware identity})
