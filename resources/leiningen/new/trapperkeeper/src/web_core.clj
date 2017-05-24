(ns {{namespace}}-web-core
  (:require [{{namespace}}-service :as hello-svc]
            [clojure.tools.logging :as log]
            [puppetlabs.comidi :as comidi]))

(defn app
  [hello-service]
  (comidi/routes
    (comidi/GET ["/" :caller] [caller]
      (fn [req]
        (log/info "Handling request for caller:" caller)
        {:status  200
         :headers {"Content-Type" "text/plain"}
         :body    (hello-svc/hello hello-service caller)}))
    (comidi/not-found "Not Found")))
