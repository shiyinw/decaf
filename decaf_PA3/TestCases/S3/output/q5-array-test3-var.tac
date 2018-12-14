VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T4 = 5
    _T5 = 0
    _T6 = (_T4 < _T5)
    if (_T6 == 0) branch _L10
    _T7 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T7
    call _PrintString
    call _Halt
_L10:
    _T8 = 4
    _T9 = (_T8 * _T4)
    _T10 = (_T8 + _T9)
    parm _T10
    _T11 =  call _Alloc
    *(_T11 + 0) = _T4
    _T12 = 0
    _T11 = (_T11 + _T10)
_L11:
    _T10 = (_T10 - _T8)
    if (_T10 == 0) branch _L12
    _T11 = (_T11 - _T8)
    *(_T11 + 0) = _T12
    branch _L11
_L12:
    _T3 = _T11
    _T13 = 0
    _T14 = *(_T3 - 4)
    _T15 = (_T13 < _T14)
    if (_T15 == 0) branch _L13
    _T16 = 0
    _T17 = (_T13 < _T16)
    if (_T17 == 0) branch _L14
_L13:
    _T18 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T18
    call _PrintString
    call _Halt
_L14:
    _T19 = 4
    _T20 = (_T13 * _T19)
    _T21 = (_T3 + _T20)
    _T22 = *(_T21 + 0)
    _T23 = 123
    _T24 = 4
    _T25 = (_T13 * _T24)
    _T26 = (_T3 + _T25)
    *(_T26 + 0) = _T23
    _T27 = 1
    _T28 = *(_T3 - 4)
    _T29 = (_T27 < _T28)
    if (_T29 == 0) branch _L15
    _T30 = 0
    _T31 = (_T27 < _T30)
    if (_T31 == 0) branch _L16
_L15:
    _T32 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T32
    call _PrintString
    call _Halt
_L16:
    _T33 = 4
    _T34 = (_T27 * _T33)
    _T35 = (_T3 + _T34)
    _T36 = *(_T35 + 0)
    _T37 = 132
    _T38 = 4
    _T39 = (_T27 * _T38)
    _T40 = (_T3 + _T39)
    *(_T40 + 0) = _T37
    _T41 = 2
    _T42 = *(_T3 - 4)
    _T43 = (_T41 < _T42)
    if (_T43 == 0) branch _L17
    _T44 = 0
    _T45 = (_T41 < _T44)
    if (_T45 == 0) branch _L18
_L17:
    _T46 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T46
    call _PrintString
    call _Halt
_L18:
    _T47 = 4
    _T48 = (_T41 * _T47)
    _T49 = (_T3 + _T48)
    _T50 = *(_T49 + 0)
    _T51 = 213
    _T52 = 4
    _T53 = (_T41 * _T52)
    _T54 = (_T3 + _T53)
    *(_T54 + 0) = _T51
    _T55 = 3
    _T56 = *(_T3 - 4)
    _T57 = (_T55 < _T56)
    if (_T57 == 0) branch _L19
    _T58 = 0
    _T59 = (_T55 < _T58)
    if (_T59 == 0) branch _L20
_L19:
    _T60 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T60
    call _PrintString
    call _Halt
_L20:
    _T61 = 4
    _T62 = (_T55 * _T61)
    _T63 = (_T3 + _T62)
    _T64 = *(_T63 + 0)
    _T65 = 231
    _T66 = 4
    _T67 = (_T55 * _T66)
    _T68 = (_T3 + _T67)
    *(_T68 + 0) = _T65
    _T69 = 4
    _T70 = *(_T3 - 4)
    _T71 = (_T69 < _T70)
    if (_T71 == 0) branch _L21
    _T72 = 0
    _T73 = (_T69 < _T72)
    if (_T73 == 0) branch _L22
_L21:
    _T74 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T74
    call _PrintString
    call _Halt
_L22:
    _T75 = 4
    _T76 = (_T69 * _T75)
    _T77 = (_T3 + _T76)
    _T78 = *(_T77 + 0)
    _T79 = 312
    _T80 = 4
    _T81 = (_T69 * _T80)
    _T82 = (_T3 + _T81)
    *(_T82 + 0) = _T79
    _T84 = 4
    _T85 = *(_T3 - 4)
    _T86 = (_T85 * _T84)
    _T87 = (_T3 + _T86)
_L23:
    _T88 = (_T3 < _T87)
    if (_T88 == 0) branch _L24
    _T89 = *(_T3 + 0)
    _T83 = _T89
    _T90 = (_T3 + _T84)
    _T3 = _T90
    parm _T83
    call _PrintInt
    _T91 = "\n"
    parm _T91
    call _PrintString
    branch _L23
_L24:
    _T93 = 4
    _T94 = *(_T3 - 4)
    _T95 = (_T94 * _T93)
    _T96 = (_T3 + _T95)
_L25:
    _T97 = (_T3 < _T96)
    if (_T97 == 0) branch _L26
    _T98 = *(_T3 + 0)
    _T92 = _T98
    _T99 = (_T3 + _T93)
    _T3 = _T99
    _T100 = 200
    _T101 = (_T92 > _T100)
    if (_T101 == 0) branch _L27
    parm _T92
    call _PrintInt
    _T102 = "\n"
    parm _T102
    call _PrintString
_L27:
    branch _L25
_L26:
    _T104 = 0
    _T103 = _T104
    _T106 = 4
    _T107 = *(_T3 - 4)
    _T108 = (_T107 * _T106)
    _T109 = (_T3 + _T108)
_L28:
    _T110 = (_T3 < _T109)
    if (_T110 == 0) branch _L29
    _T111 = *(_T3 + 0)
    _T105 = _T111
    _T112 = (_T3 + _T106)
    _T3 = _T112
    _T113 = 140
    _T114 = (_T105 < _T113)
    if (_T114 == 0) branch _L28
    _T115 = 1
    _T116 = (_T103 + _T115)
    _T103 = _T116
    branch _L28
_L29:
    parm _T103
    call _PrintInt
    _T117 = "\n"
    parm _T117
    call _PrintString
    _T119 = 0
    _T118 = _T119
    _T121 = 4
    _T122 = *(_T3 - 4)
    _T123 = (_T122 * _T121)
    _T124 = (_T3 + _T123)
_L30:
    _T125 = (_T3 < _T124)
    if (_T125 == 0) branch _L31
    _T126 = *(_T3 + 0)
    _T120 = _T126
    _T127 = (_T3 + _T121)
    _T3 = _T127
    _T128 = 300
    _T129 = (_T120 < _T128)
    _T130 = 200
    _T131 = (_T120 > _T130)
    _T132 = (_T129 && _T131)
    if (_T132 == 0) branch _L30
    parm _T120
    call _PrintInt
    _T133 = "\n"
    parm _T133
    call _PrintString
    _T134 = 1
    _T135 = (_T118 + _T134)
    _T118 = _T135
    branch _L30
_L31:
    parm _T118
    call _PrintInt
    _T136 = "\n"
    parm _T136
    call _PrintString
}

