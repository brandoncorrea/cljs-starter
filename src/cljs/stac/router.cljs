(ns stac.router
  (:require-macros [secretary.core :refer [defroute]])
  (:require [accountant.core :as accountant]
            [secretary.core :as secretary]
            [stac.config :as config]
            [stac.page :as page]))

(defn- hook-browser-navigation! []
  (accountant/configure-navigation!
    {:nav-handler  secretary/dispatch!
     :path-exists? secretary/locate-route}))

(defn def-sandbox []
  (defroute "/sandbox" [] (page/install! :sandbox))
  (defroute "/sandbox/home" [] (page/install! :sandbox/home))
  )

(defn defroutes []
  (defroute "/" [] (page/install! :home))
  (when @config/development? (def-sandbox))
  (hook-browser-navigation!)
  )
