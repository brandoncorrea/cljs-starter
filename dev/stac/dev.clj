(ns stac.dev
  (:require [c3kit.apron.log :as log]
            [c3kit.scaffold.cljs :as cljs]
            [c3kit.scaffold.css :as css]
            [clojure.java.shell :as sh]))

(defn start-cljs [] (cljs/-main "auto" "development"))
(defn start-css [] (css/-main "auto" "development"))
(defn run-server [] (sh/sh "./bin/server"))

(def threads
  {:cljs   (Thread. start-cljs)
   :css    (Thread. start-css)
   :server (Thread. run-server)})

(defn shutdown []
  (log/report "---- DEV Task - Shutdown ----"))

(defn -main
  "Where three separate tasks (and Java processes) were required before, this single task will host them all
   in a single Java process.  Easier to use and consuming less computer resources."
  [& args]
  (log/report "---- DEV Task - One process to rule them all.----")

  (.addShutdownHook (Runtime/getRuntime) (Thread. shutdown))

  (let [thread-keys (set (if (seq args) (map keyword args) (keys threads)))]
    (log/report "Starting: " thread-keys)
    (doseq [[key thread] threads]
      (when (contains? thread-keys key)
        (.start thread))))
  )
