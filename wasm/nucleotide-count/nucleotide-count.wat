(module
  (memory (export "mem") 1)
  ;; finding "Easy" by hand a bit much to dive into as a first exercise.
  ;; is the approproiate approach to solve it in a higher-level language and translate to wasm/wat?
  ;; copied a working solution but feel there's a number of details that aren't obvious.
  ;; gonna look for something even more basic to try next
  
  ;; Counter of each nucleotide is stored in memory starting at offset 0
  ;; Offsets : 0 => A, 1 => C, 2 => G, 3 => T
  (func (export "countNucleotides") (param $offset i32) (param $length i32) (result i32 i32 i32 i32)
    (local $cur i32) (local $nucleotideCounterOffset i32)
  
    ;; empty string
    (i32.eq (i32.const 0) (local.get $length))
    (if
      (then
        (return (i32.const 0) (i32.const 0) (i32.const 0) (i32.const 0))))

    (loop $char_loop
      (block $break
    
        ;; iterate over each letter
        ;; increment count for valid ACGT
        ;; bail if any other letter encountered
       	(call $getNucleotidesOffset
          (i32.load8_u
            (i32.add
                (local.get $offset)
                (local.get $cur))))
        (local.tee $nucleotideCounterOffset)
        
        ;; invalid nucleotide value
        (i32.const -1)
        (i32.eq)
        (if
          (then
            (return (i32.const -1) (i32.const -1) (i32.const -1) (i32.const -1))))
        
        ;; inc nucleotide counter
        (local.get $nucleotideCounterOffset)
        (i32.add
        	(i32.const 1)
        	(i32.load8_u
          		(local.get $nucleotideCounterOffset)))
        (i32.store8)
        
        ;; inc nucleotide string cursor
        (i32.add
          (i32.const 1)
          (local.get $cur))
        (local.tee $cur)
        
        ;; all nucleotides counted ?
        (local.get $length)
	      (i32.eq)
        br_if $break
        br $char_loop
     ))

    (return
      (i32.load8_u (i32.const 0))
      (i32.load8_u (i32.const 1))
      (i32.load8_u (i32.const 2))
      (i32.load8_u (i32.const 3))
    )
  )

  ;; return the valid nucleotide character index ACGT => 0-3 or
  ;; return -1 when any other character encountered
  (func $getNucleotidesOffset (param $nucleotide i32) (result i32)
      ;; A
      (i32.const 0x41)
      (local.get $nucleotide)
      (i32.eq)
      (if(then(return (i32.const 0))))
  
      ;; C
      (i32.const 0x43)
      (local.get $nucleotide)
      (i32.eq)
      (if(then(return (i32.const 1))))
  
      ;; G
      (i32.const 0x47) 
      (local.get $nucleotide)
      (i32.eq)
      (if(then(return (i32.const 2))))
  
      ;; T
      (i32.const 0x54)
      (local.get $nucleotide)
      (i32.eq)
      (if(then(return (i32.const 3))))
      
      (i32.const -1)
    )
)

