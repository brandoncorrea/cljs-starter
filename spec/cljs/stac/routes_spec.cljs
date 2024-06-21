(ns stac.routes-spec
  (:require-macros [speclj.core :refer [after before context describe]]
                   [stac.spec-helperc :refer [it-routes]])
  (:require [secretary.core :as secretary]
            [speclj.core]
            [stac.config :as config]
            [stac.page :as page]
            [stac.router :as sut]))

(describe "Router"
  (before (page/clear!)
          (secretary/reset-routes!)
          (sut/defroutes))

  (it-routes "/" :home)

  (context "sandbox"
    (before (reset! config/environment "development")
            (sut/defroutes))
    (after (reset! config/environment nil))
    (it-routes "/sandbox" :sandbox)
    (it-routes "/sandbox/home" :sandbox/home)
    )
  )
