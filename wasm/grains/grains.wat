(module
  (global $numSquares i32 (i32.const 64))
  
  ;;
  ;; Calculate the number of grains of wheat on the nth square of the chessboard
  ;;
  ;; @param {i32} squareNum - The square of the chessboard to calculate the number of grains for
  ;;
  ;; @returns {i64} - The number of grains of wheat on the nth square of the 
  ;;                  chessboard or 0 if the squareNum is invalid. The result
  ;;                  is unsigned.
  ;;
  (func $square (export "square") (param $squareNum i32) (result i64)
    (if (i32.or 
      (i32.le_s (local.get $squareNum) (i32.const 0))
      (i32.gt_s (local.get $squareNum) (global.get $numSquares)))  
      (then (return (i64.const 0))))

    (i64.shl (i64.const 1) (i64.extend_i32_u (i32.sub (local.get $squareNum) (i32.const 1))))
  )

  ;;
  ;; Calculate the sum of grains of wheat acrosss all squares of the chessboard
  ;;
  ;; @returns {i64} - The number of grains of wheat on the entire chessboard.
  ;;                  The result is unsigned.
  ;;
  (func (export "total") (result i64)
    (local $i i32)
    (local $sum i64)
    
    (local.set $i (i32.const 1))
    (local.set $sum (i64.const 0))
    
    (loop
      (local.set $sum (i64.add (local.get $sum) (call $square (local.get $i))))
      (br_if 0 (i32.le_u (local.tee $i (i32.add (local.get $i) (i32.const 1))) (global.get $numSquares)))
    )
    
    (local.get $sum)
  )
)

