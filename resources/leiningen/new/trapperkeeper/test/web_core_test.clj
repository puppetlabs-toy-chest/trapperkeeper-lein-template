(ns {{namespace}}-web-core-test
  (:require [clojure.test :refer :all]
            [{{namespace}}-service :as hello-svc]
            [{{namespace}}-web-core :refer :all]
            [ring.mock.request :as mock]))

(deftest hello-web-test
  (testing "says hello to caller"
    (let [hello-service (reify hello-svc/HelloService
                          (hello [this caller] (format "Testing, %s." caller)))
          ring-app (app hello-service)
          response (ring-app (mock/request :get "/foo"))]
      (is (= 200 (:status response)))
      (is (= "Testing, foo." (:body response))))))