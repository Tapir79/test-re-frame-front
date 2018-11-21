(ns test-re-frame-front.views.test-form
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent :refer [atom]]
            [test-re-frame-front.events :as events]
            [test-re-frame-front.subs :as subs]
            [test-re-frame-front.components.inputs :as inputs]
            [test-re-frame-front.components.buttons :as buttons]
            [test-re-frame-front.components.lists :as lists]))

(enable-console-print!)

(defn test-list []
  (let [tests @(re-frame/subscribe [::subs/tests])]
    [lists/bullet-list :message tests]))

(defn test-form []

  [:form
   [:h3 "Textfield example"]
   [:br]
   [inputs/input-field "from" #(re-frame/dispatch [::events/add-to-new-test [[:message] (.-value (.-target %))]])]
   [:br]
   [buttons/default "Send a message" #(re-frame/dispatch [::events/save-test])]])