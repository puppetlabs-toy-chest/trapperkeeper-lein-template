(def tk-version "0.3.4-SNAPSHOT")
(def ks-version "0.5.3-SNAPSHOT")

(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [org.clojure/tools.logging "0.2.6"]
                 [puppetlabs/trapperkeeper ~tk-version]]

  :test-paths ["test" "test-resources"]

  :profiles {:dev {:dependencies [[puppetlabs/trapperkeeper-webserver-jetty9 "0.3.3"]
                                  [puppetlabs/trapperkeeper ~tk-version :classifier "test" :scope "test"]
                                  [puppetlabs/kitchensink ~ks-version :classifier "test" :scope "test"]
                                  [clj-http "0.7.9"]
                                  [ring-mock "0.1.5"]]}}

  :aliases {"tk" ["trampoline" "run" "--config" "test-resources/config.ini"]}

  :main puppetlabs.trapperkeeper.main

  )
