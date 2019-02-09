(ns fauxcatclj.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [fauxcatclj.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[fauxcatclj started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[fauxcatclj has shut down successfully]=-"))
   :middleware wrap-dev})
