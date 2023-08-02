(ns stac.routes-spec
  (:require-macros [stac.spec-helperc :refer [it-routes]]
                   [speclj.core :refer [after before context describe it redefs-around should-be-nil should-have-invoked should-not-have-invoked should= stub with-stubs]])
  (:require [stac.config :as config]
            [stac.page :as page]
            [stac.router :as sut]
            [secretary.core :as secretary]
            [speclj.core]))

(describe "Router"
  (with-stubs)
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
