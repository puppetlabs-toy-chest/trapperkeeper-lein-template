(ns {{namespace}}-core-test
  (:require [clojure.test :refer :all]
            [{{namespace}}-core :refer :all]))

(deftest hello-test
  (testing "says hello to caller"
    (is (= "Hello, foo!" (hello "foo")))))