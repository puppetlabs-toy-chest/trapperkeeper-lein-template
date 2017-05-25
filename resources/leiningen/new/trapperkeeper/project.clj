(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :parent-project {:coords [puppetlabs/clj-parent "1.1.0"]
                   :inherit [:managed-dependencies]}

  :pedantic? :abort

  :dependencies [[org.clojure/clojure]
                 [puppetlabs/comidi]
                 [puppetlabs/trapperkeeper]
                 [puppetlabs/trapperkeeper-webserver-jetty9]]

  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[puppetlabs/trapperkeeper :classifier "test" :scope "test"]
                                  [puppetlabs/kitchensink :classifier "test" :scope "test"]
                                  [clj-http "3.6.0"]
                                  [org.clojure/tools.namespace]
                                  [ring-mock]]}}

  :repl-options {:init-ns user}

  :aliases {"tk" ["trampoline" "run" "--config" "dev-resources/config.conf"]}

  :plugins [[lein-parent "0.3.1"]]

  :main puppetlabs.trapperkeeper.main

  )
