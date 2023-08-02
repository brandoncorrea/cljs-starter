(ns stac.page
  (:require [reagent.core :as reagent]))

(def state (reagent/atom nil))
(defn clear! [] (reset! state nil))
(defn install! [page] (swap! state assoc :current page))
(def current (reagent/track #(:current @state)))

(defn cursor
  ([path] (cursor path nil))
  ([path value]
   (let [c (reagent/cursor state path)]
     (reset! c value)
     c)))

(defmulti render identity)
(defmethod render :default [_]
  [:h1 "Four-Oh-Four – Not Found"])

(defn default [] (render @current))
