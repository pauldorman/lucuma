(defproject lucuma "0.2.0-SNAPSHOT"
  :description "A Web Components library for ClojureScript"
  :url "http://github.com/jeluard/lucuma"
  :license  {:name "Eclipse Public License"
             :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths  ["src" "test"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2030"]]
  :plugins [[lein-cljsbuild "1.0.0"]
            [com.cemerick/clojurescript.test "0.2.1"]]
  :cljsbuild {:builds [{:source-paths ["src" "test"]
                        :compiler {:output-to "target/cljs/lucuma.js"
                                   :optimizations :advanced}}]
              :test-commands {;; Disabled for now: based on too old webkit version. "phantomjs" ["phantomjs" "resources/test/runner.js" "resources/test/assets/platform.js" "target/cljs/lucuma.js"]
                              ;; SlimerJS doesn't support exit code so CI won't fail when tests fail. See https://github.com/laurentj/slimerjs/issues/50.
                              "slimerjs" ["slimerjs" :runner "test-resources/assets/platform-v0.0.20131107.min.js" "target/cljs/lucuma.js"]}}

  :aliases {"clean-test" ["do" "clean," "cljsbuild" "clean," "cljsbuild" "test"]
            "clean-install" ["do" "clean," "cljsbuild" "clean," "install"]}
  :min-lein-version "2.3.0")
