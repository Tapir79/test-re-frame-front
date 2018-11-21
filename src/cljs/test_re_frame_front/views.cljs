(ns test-re-frame-front.views
  (:require
    [re-frame.core :as re-frame]
    [test-re-frame-front.subs :as subs]
    [test-re-frame-front.views.test-form :as test-form]))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [:div
      [test-form/test-form]
      [:br]
      [test-form/test-list]]]))