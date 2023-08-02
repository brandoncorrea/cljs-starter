(ns stac.spec-helperc
  #?(:cljs (:require-macros [speclj.core :refer [-fail -to-s around should= it]]))
  (:require #?(:clj  [speclj.core :refer :all]
               :cljs [speclj.core])
            #?(:cljs [stac.page :as page])))

#?(:clj (defmacro it-routes
          "Tests a client side route"
          [path page-key & body]
          `(it ~path
             (secretary.core/dispatch! ~path)
             (should= ~page-key @page/current)
             ~@body)))
