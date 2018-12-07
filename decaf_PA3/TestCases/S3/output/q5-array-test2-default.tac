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
    _T4 = "pa1"
    _T5 = 2
    _T6 = 0
    _T7 = (_T5 < _T6)
    if (_T7 == 0) branch _L10
    _T8 = "Decaf runtime error: The length of the created array should not be less than 0.\n"
    parm _T8
    call _PrintString
    call _Halt
_L10:
    _T9 = 4
    _T10 = (_T9 * _T5)
    _T11 = (_T9 + _T10)
    parm _T11
    _T12 =  call _Alloc
    *(_T12 + 0) = _T5
    _T12 = (_T12 + _T11)
_L11:
    _T11 = (_T11 - _T9)
    if (_T11 == 0) branch _L12
    _T12 = (_T12 - _T9)
    *(_T12 + 0) = _T4
    branch _L11
_L12:
    _T3 = _T12
    _T14 = 0
    _T15 = "pa2"
    _T16 = *(_T3 - 4)
    _T17 = (_T14 < _T16)
    if (_T17 == 0) branch _L13
_L13:
    _T18 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T18
    call _PrintString
    _T13 = _T15
    _T20 = 2
    _T21 = "pa3"
    _T22 = *(_T3 - 4)
    _T23 = (_T20 < _T22)
    if (_T23 == 0) branch _L14
_L14:
    _T24 = "Decaf runtime error: Array subscript out of bounds\n"
    parm _T24
    call _PrintString
    _T19 = _T21
    parm _T13
    call _PrintString
    parm _T19
    call _PrintString
}

