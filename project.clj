(defproject look-and-say "0.1.0-SNAPSHOT"
  :description "look and say sequence kata"
  :url "https://github.com/rojoangel/look-and-say-sequence-kata-clojure"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot look-and-say.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-auto "0.1.2"]])
