(ns stac.styles.core
  (:refer-clojure :exclude [rem])
  (:require [garden.def :as def]
            [garden.units :as units]))

(defmacro defstyles
  "Convenience: `(garden.def/defstyles name styles*)"
  [name & styles] `(def/defstyles ~name ~@styles))

(defn px [n] (units/px n))
(defn em [n] (units/em n))
(defn rem [n] (units/rem n))
(defn percent [n] (units/percent n))

(defn font-family [face weight]
  (str "'" face "-" weight "', Helvetica, sans-serif"))

(defn font-load [face weight]
  (list
    ["@font-face" {
                   :font-family (str "'" face "-" weight "'")}
     {:src         (str "url('/fonts/" face "-" weight ".woff2') format('woff2'), "
                        "url('/fonts/" face "-" weight ".woff') format('woff')")
      :font-weight "normal"
      :font-style  "normal"
      }]

    ["@font-face" {
                   :font-family (str "'" face "-" weight "-italic'")}
     {:src         (str "url('/fonts/" face "-" weight "-italic.woff2') format('woff2'), "
                        "url('/fonts/" face "-" weight "-italic.woff') format('woff')")
      :font-weight "normal"
      :font-style  "normal"
      }]
    )
  )

(defn load-fonts [face weights]
  (map #(font-load face %) weights))
