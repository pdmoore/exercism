(module
  (global $pointsForOutsideTarget i32 (i32.const 0))
  (global $pointsForOuterCircle i32 (i32.const 1))
  (global $pointaForMiddleCircle i32 (i32.const 5))
  (global $pointaForInnerCircle i32 (i32.const 10))
  
  (func (export "score") (param $x f32) (param $y f32) (result i32)
    (local $distance_from_center f32)

    (local.set $distance_from_center 
      (f32.sqrt
        (f32.add
          (f32.mul (local.get $x) (local.get $x))
          (f32.mul (local.get $y) (local.get $y))
        )
      )
    )
    
    (if (f32.le (local.get $distance_from_center) (f32.const 1)) (then
      (return (global.get $pointaForInnerCircle))))
    
    (if (f32.le (local.get $distance_from_center) (f32.const 5)) (then
      (return (global.get $pointaForMiddleCircle))))
    
    (if (f32.le (local.get $distance_from_center) (f32.const 10)) (then
      (return (global.get $pointsForOuterCircle))))
    
    (return (global.get $pointsForOutsideTarget))
  )
)
