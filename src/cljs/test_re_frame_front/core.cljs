(ns test-re-frame-front.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [test-re-frame-front.events :as events]
   [test-re-frame-front.views :as views]
   [test-re-frame-front.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  #_(re-frame/dispatch-sync [::events/init-tests])
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (re-frame/dispatch-sync [::events/init-tests])
  (dev-setup)
  (mount-root))
