(ns lucuma.custom-elements-test
  (:require [cemerick.cljs.test :as t]
            [lucuma.custom-elements :as ce])
  (:require-macros [cemerick.cljs.test :refer [deftest is testing]]))

(deftest names
  (is (ce/valid-name? "ex-name"))
  (is (ce/valid-name? "ex-name-name"))
  (is (not (ce/valid-name? "name")))
  (is (not (ce/valid-name? "ex_name")))
  (is (not (ce/valid-name? "color-profile"))))

(deftest default-constructor-names
  (is (= "EXName" (ce/default-constructor-name "ex-name")))
  (is (= "EXComplexName" (ce/default-constructor-name "ex-complex-name"))))

(deftest register
  nil)
