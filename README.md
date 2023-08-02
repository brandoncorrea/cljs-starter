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

## Deployment

    # Build cljs
    clj -Mcljs once production

    # Build css
    clj -Mcss once

## Local HTTP Server

    cd resources/public
    http-server --proxy "http://localhost:8080?"
