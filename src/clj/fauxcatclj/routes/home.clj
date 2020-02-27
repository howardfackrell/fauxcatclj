(ns fauxcatclj.routes.home
  (:require [fauxcatclj.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(def catalog-items [
                    {:foto "/img/captain.jpeg" :description "Captain America"}
                    {:foto "/img/hawkeye.jpg" :description "Iron Man"}
                    {:foto "/img/hulk.jpg" :description "Hulk"}
                    {:foto "/img/ironman.jpeg" :description "Iron Man"}
                    {:foto "/img/panther.jpeg" :description "Black Panther"}
                    {:foto "/img/widow.jpg" :description "Black Widow"}
                    {:foto "/img/vision.webp" :description "Vision"}
                    ])

(defn catalog-page []
  (layout/render
    "catalog.html" {:items catalog-items}))

(defn about-page []
  (layout/render "about.html"))

(defn octhc []
  (layout/render-text "{overall_status: good}"))

(defroutes home-routes
  (GET "/" [] (catalog-page))
  (GET "/luminus" [] (home-page))
  (GET "/octhc" [] (octhc))
  (GET "/about" [] (about-page)))

