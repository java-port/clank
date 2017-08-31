public AsmStringPiece() {
  this.MyKind = Kind.valueOf(0);
  this.Str = std.string.EMPTY;
  this.OperandNo = 0;
  this.Range = new CharSourceRange();
}

private AsmStringPiece(AsmStringPiece $Prm0) {
  // : MyKind(static_cast<AsmStringPiece &&>().MyKind), Str(static_cast<AsmStringPiece &&>().Str), OperandNo(static_cast<AsmStringPiece &&>().OperandNo), Range(static_cast<AsmStringPiece &&>().Range) 
  //START JInit
  this.MyKind = $Prm0.MyKind;
  this.Str = new std.string($Prm0.Str);
  this.OperandNo = $Prm0.OperandNo;
  this.Range = new CharSourceRange($Prm0.Range);
  //END JInit      
}

@Override public AsmStringPiece clone() {
  return new AsmStringPiece(this);
}
