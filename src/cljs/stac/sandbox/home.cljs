(ns stac.sandbox.home
  (:require [stac.page :as page]))

(defmethod page/render :sandbox/home [_]
  [:h1 "This is a sandbox page."])
