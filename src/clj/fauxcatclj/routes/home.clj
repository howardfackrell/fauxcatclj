(ns fauxcatclj.routes.home
  (:require [fauxcatclj.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn catalog-page []
  (layout/render
    "catalog.html" {}))

(defn about-page []
  (layout/render "about.html"))

(defn octhc []
  (layout/render-text "{overall_status: good}"))

(defroutes home-routes
  (GET "/" [] (catalog-page))
  (GET "/luminus" [] (home-page))
  (GET "/octhc" [] (octhc))
  (GET "/about" [] (about-page)))

