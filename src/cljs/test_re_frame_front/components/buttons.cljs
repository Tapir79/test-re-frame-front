(ns test-re-frame-front.components.buttons)

(defn default-div-button [label on-click-function]
  [:div {:style    {:background   "#BDCCCC"
                    :width        130
                    :border       "dotted"
                    :border-color "black"
                    }
         :on-click on-click-function} label])

(defn default-button [label on-click-function]
  [:button {:type     "button"
            :on-click on-click-function} label]) 


