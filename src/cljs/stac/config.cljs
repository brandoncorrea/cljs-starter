(ns stac.config
  (:require [reagent.core :as reagent]))

(def environment (reagent/atom nil))
(def development? (reagent/track #(= "development" @environment)))
(def production? (reagent/track #(= "production" @environment)))
(defn install! [env] (reset! environment env))
