(defproject test-re-frame-front "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]
                 [day8.re-frame/http-fx "0.1.6"]
                 [cljs-ajax "0.7.5"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   ;[day8.re-frame/re-frame-10x "0.3.3"]
                   ]

    :plugins      [[lein-figwheel "0.5.16"]]}
   :prod { }
   }

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "test-re-frame-front.core/mount-root"}
     :compiler     {:main                 test-re-frame-front.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :closure-defines {goog.DEBUG true
                                      "re_frame.trace.trace_enabled_QMARK_" true}
                    :preloads [devtools.preload
                               day8.re-frame-10x.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    :source-map true
                    :optimizations :none
                    :cache-analysis true
                    :pretty-print true
                    :closure-extra-annotations ["api" "observable"]
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            test-re-frame-front.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    ]}
  )
