(ns test-re-frame-front.components.buttons)

(defn default [label on-click-function]
  [:button {:on-click on-click-function} label])
