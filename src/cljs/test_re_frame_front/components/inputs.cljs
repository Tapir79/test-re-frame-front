(ns test-re-frame-front.components.inputs)

(defn input-field [name on-change-function]
  [:input {:name name :on-change on-change-function}])