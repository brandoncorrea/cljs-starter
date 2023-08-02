(ns stac.home
  (:require [stac.page :as page]))

(defmethod page/render :home []
  [:div
   [:h1 "Hello, Static World!"]])
