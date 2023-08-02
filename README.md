# Stac Website

A static website built with ClojureScript.

## Setup

    # clojure
    brew install clojure

    # node
    brew install npm

    # http-server
    npm i http-server -g

    # NPM Install
    npm i

## Commands

    # Watch for css changes
    clj -Mcss

    # watch for both css/cljs changes and run specs
    clj -Mtest:dev-

    # build cljs on-change (for development)
    clj -Mcljs auto production

    # build cljs once (for production)
    clj -Mcljs once production

## Sandbox

### Configuration

The sandbox pages will only appear in the `development` environment.
To show them, update `main.cljs` with the `"development"` configuration.

For production, you will want these hidden. Update `main.cljs` to start up with `"production"`.

### Playing in the Sandbox

A sandbox page is just an implementation of `page/render`.

1. Create a cljs file under `src/cljs/stac/sandbox` - call it whatever you'd like!

```clojure
(ns stac.sandbox.example
  (:require [stac.page :as page]))

(defmethod page/render :sandbox/example [_]
  ; Your hiccup code here...
  )
```

2. Add your new namespace to `stac.sandbox.core`

```clojure
(ns stac.sandbox.core
  (:require ;...namespaces... 
            [stac.sandbox.example]
            ;...namespaces...
    ))
```

3. Create a test for your new sandbox in `stac.router-spec`

```clojure
(context "sandbox" 
  ; ...specs... 
  (it-routes "/sandbox/example" :sandbox/example)
  ; ...more specs...
  )
```

4. Pass your test in `stac.router`

```clojure
(defn def-sandbox []
  ; ...routes...
  (defroute "/sandbox/example" [] (page/install! :sandbox/example))
  ; ...more routes...
  )
```

Note: Your `:sandbox/keyword` will need to exactly match your route: `"/sandbox/keyword"`.

## Deployment

    # Build cljs
    clj -Mcljs once production

    # Build css
    clj -Mcss once

## Local HTTP Server

    cd resources/public
    http-server --proxy "http://localhost:8080?"
