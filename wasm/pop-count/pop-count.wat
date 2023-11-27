(module
  ;;
  ;; count the number of 1 bits in the binary representation of a number
  ;;
  ;; @param {i32} number - the number to count the bits of
  ;;
  ;; @returns {i32} the number of 1 bits in the binary representation of the number
  ;;
  (func (export "eggCount") (param $number i32) (result i32)
    (local $one_bits_count i32)

    (loop $all_the_bits
      (local.set $one_bits_count (i32.add (local.get $one_bits_count) (i32.and (local.get $number) (i32.const 1))))  
      (br_if $all_the_bits (i32.ne (local.tee $number (i32.shr_u (local.get $number) (i32.const 1))) (i32.const 0)))
    )

    (return (local.get $one_bits_count))
  )
)

