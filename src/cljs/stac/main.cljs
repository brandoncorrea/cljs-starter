(ns stac.main
  (:require [accountant.core :as accountant]
            [c3kit.wire.js :as wjs]
            [reagent.dom :as dom]
            [stac.config :as config]
            [stac.home]
            [stac.sandbox.core]
            [stac.page :as page]
            [stac.router :as router]))

(goog/exportSymbol "goog.require" goog/require)

(defn ^:export main []
  (config/install! "production")
  ;(config/install! "development")
  (router/defroutes)
  (accountant/dispatch-current!)
  (dom/render [page/default] (wjs/element-by-id "app-root")))

(enable-console-print!)
