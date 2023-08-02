(ns stac.routes-spec
  (:require-macros [stac.spec-helperc :refer [it-routes]]
                   [speclj.core :refer [before context describe it redefs-around should-be-nil should-have-invoked should-not-have-invoked should= stub with-stubs]])
  (:require [stac.page :as page]
            [stac.router :as sut]
            [secretary.core :as secretary]
            [speclj.core]))

(describe "Router"
  (with-stubs)
  (before (page/clear!)
          (secretary/reset-routes!)
          (sut/defroutes))

  (it-routes "/" :home)
  )
