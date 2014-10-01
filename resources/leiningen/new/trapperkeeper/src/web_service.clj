(ns {{namespace}}-web-service
  (:require [clojure.tools.logging :as log]
            [compojure.core :as compojure]
            [{{namespace}}-web-core :as core]
            [puppetlabs.trapperkeeper.core :as trapperkeeper]
            [puppetlabs.trapperkeeper.services :as tk-services]))

(trapperkeeper/defservice hello-web-service
  [[:ConfigService get-in-config]
   [:WebserverService add-ring-handler]
   HelloService]
  (init [this context]
    (log/info "Initializing hello webservice")
    (let [url-prefix (get-in-config [:hello-web :url-prefix])]
      (add-ring-handler
        (compojure/context url-prefix []
          (core/app (tk-services/get-service this :HelloService)))
        url-prefix)
      (assoc context :url-prefix url-prefix))))