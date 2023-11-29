(module
  (memory (export "mem") 1)

  (global $letterCount i32 (i32.const 26))
  (global $asciiLowerA i32 (i32.const 97))
  ;;
  ;; Encrypt plaintext using the rotational cipher.
  ;;
  ;; @param {i32} textOffset - The offset of the plaintext input in linear memory.
  ;; @param {i32} textLength - The length of the plaintext input in linear memory.
  ;; @param {i32} shiftKey - The shift key to use for the rotational cipher.
  ;;
  ;; @returns {(i32,i32)} - The offset and length of the ciphertext output in linear memory.
  ;;
  (func (export "rotate") (param $textOffset i32) (param $textLength i32) (param $shiftKey i32) (result i32 i32)
    (local $asciiCode i32)
    (local $i i32)
    (local $indexIntoText i32)

    (loop $loop
      (local.set $indexIntoText (i32.add (local.get $textOffset) (local.get $i)))
      (local.set $asciiCode (i32.load8_u (local.get $indexIntoText)))

      (if 
        (i32.and (i32.ge_u (local.get $asciiCode) (global.get $asciiLowerA)) (i32.le_u (local.get $asciiCode) (i32.const 122)))  
          (then 
            (i32.store8 (local.get $indexIntoText) (call $rotate_lower (local.get $asciiCode) (local.get $shiftKey)))
      ))

      (local.set $i (i32.add (local.get $i) (i32.const 1)))
      (br_if $loop (i32.lt_u (local.get $i) (local.get $textLength)))
    )

    (return (local.get $textOffset) (local.get $textLength))
  )

  (func $rotate_lower (param $asciiCode i32) (param $shiftKey i32) (result i32)
    (local.set $asciiCode (call $rotate_letter (i32.sub (local.get $asciiCode) (global.get $asciiLowerA)) (local.get $shiftKey)))
    (return (i32.add (local.get $asciiCode) (global.get $asciiLowerA))))

  (func $rotate_letter (param $asciiCode i32) (param $shiftKey i32) (result i32)
    (local.set $asciiCode (i32.add (local.get $asciiCode) (local.get $shiftKey)))
    (if 
      (i32.ge_u (local.get $asciiCode) (global.get $letterCount))
        (then
          (local.set $asciiCode (i32.sub (local.get $asciiCode) (global.get $letterCount))))
    )
    (return (local.get $asciiCode))
  )


)

