          .text                         
          .globl main                   

          .data                         
          .align 2                      
_Main:                                  # virtual table
          .word 0                       # parent
          .word _STRING0                # class name



          .text                         
_Main_New:                              # function entry
          sw $fp, 0($sp)                
          sw $ra, -4($sp)               
          move $fp, $sp                 
          addiu $sp, $sp, -16           
_L15:                                   
          li    $t0, 4                  
          sw    $t0, 4($sp)             
          jal   _Alloc                  
          move  $t1, $v0                
          la    $t0, _Main              
          sw    $t0, 0($t1)             
          move  $v0, $t1                
          move  $sp, $fp                
          lw    $ra, -4($fp)            
          lw    $fp, 0($fp)             
          jr    $ra                     

main:                                   # function entry
          sw $fp, 0($sp)                
          sw $ra, -4($sp)               
          move $fp, $sp                 
          addiu $sp, $sp, -44           
_L16:                                   
          li    $t1, 2                  
          li    $t0, 0                  
          slt   $t0, $t1, $t0           
          sw    $t1, -8($fp)            
          beqz  $t0, _L18               
_L17:                                   
          la    $t0, _STRING1           
          sw    $t0, 4($sp)             
          jal   _PrintString            
          jal   _Halt                   
_L18:                                   
          lw    $t0, -8($fp)            
          li    $t3, 4                  
          mul   $t1, $t3, $t0           
          add   $t2, $t3, $t1           
          sw    $t2, 4($sp)             
          sw    $t0, -8($fp)            
          sw    $t3, -12($fp)           
          sw    $t2, -16($fp)           
          jal   _Alloc                  
          move  $t1, $v0                
          lw    $t0, -8($fp)            
          lw    $t3, -12($fp)           
          lw    $t2, -16($fp)           
          sw    $t0, 0($t1)             
          li    $t0, 0                  
          add   $t1, $t1, $t2           
          sw    $t3, -12($fp)           
          sw    $t2, -16($fp)           
          sw    $t1, -20($fp)           
          sw    $t0, -24($fp)           
_L19:                                   
          lw    $t2, -16($fp)           
          lw    $t0, -12($fp)           
          sub   $t2, $t2, $t0           
          sw    $t0, -12($fp)           
          sw    $t2, -16($fp)           
          beqz  $t2, _L21               
_L20:                                   
          lw    $t2, -24($fp)           
          lw    $t3, -20($fp)           
          lw    $t0, -12($fp)           
          sub   $t3, $t3, $t0           
          sw    $t2, 0($t3)             
          sw    $t0, -12($fp)           
          sw    $t3, -20($fp)           
          sw    $t2, -24($fp)           
          b     _L19                    
_L21:                                   
          lw    $t0, -20($fp)           
          move  $t2, $t0                
          li    $t1, 2                  
          lw    $t0, -4($t2)            
          slt   $t0, $t1, $t0           
          sw    $t2, -28($fp)           
          sw    $t1, -32($fp)           
          beqz  $t0, _L23               
_L22:                                   
          lw    $t0, -32($fp)           
          li    $t1, 0                  
          slt   $t1, $t0, $t1           
          sw    $t0, -32($fp)           
          beqz  $t1, _L24               
_L23:                                   
          la    $t1, _STRING2           
          sw    $t1, 4($sp)             
          jal   _PrintString            
          jal   _Halt                   
_L24:                                   
          lw    $t1, -32($fp)           
          lw    $t0, -28($fp)           
          li    $t2, 4                  
          mul   $t2, $t1, $t2           
          add   $t2, $t0, $t2           
          lw    $t2, 0($t2)             
          li    $t3, 0                  
          li    $t2, 4                  
          mul   $t1, $t1, $t2           
          add   $t0, $t0, $t1           
          sw    $t3, 0($t0)             
          move  $sp, $fp                
          lw    $ra, -4($fp)            
          lw    $fp, 0($fp)             
          jr    $ra                     




          .data                         
_STRING1:
          .asciiz "Decaf runtime error: Cannot create negative-sized array\n"
_STRING0:
          .asciiz "Main"                
_STRING2:
          .asciiz "Decaf runtime error: Array subscript out of bounds\n"
