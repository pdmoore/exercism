(module
  (memory (export "mem") 1)

  (data (i32.const 100) "black,brown,red,orange,yellow,green,blue,violet,grey,white")

  ;;
  ;; Return buffer of comma separated colors
  ;; "black,brown,red,orange,yellow,green,blue,violet,grey,white"
  ;;
  ;; @returns {(i32, i32)} - The offset and length of the buffer of comma separated colors
  ;;
  (func (export "colors") (result i32 i32)
    (return (i32.const 100) (i32.const 58))
  )

  ;;
  ;; Initialization function called each time a module is initialized
  ;; Can be used to populate globals similar to a constructor
  ;; Can be deleted if not needed
  ;;
  (func $initialize)
  (start $initialize)

  ;;
  ;; Given a valid resistor color, returns the associated value
  ;;
  ;; @param {i32} offset - offset into the color buffer
  ;; @param {i32} len - length of the color string
  ;;
  ;; @returns {i32} - the associated value
  ;;
  (func (export "colorCode") (param $offset i32) (param $len i32) (result i32)
    (if (i32.eq (i32.load (local.get $offset)) (i32.load (i32.const 100)))
      (then
      (i32.const 0)
      (return)
    ))

    (if (i32.eq (i32.load (local.get $offset)) (i32.load (i32.const 116)))
      (then
      (i32.const 3)
      (return)
    ))

    (if (i32.eq (i32.load (local.get $offset)) (i32.load (i32.const 153)))
      (then
      (i32.const 9)
      (return)
    ))

    (return (i32.const -1))
  )
)
