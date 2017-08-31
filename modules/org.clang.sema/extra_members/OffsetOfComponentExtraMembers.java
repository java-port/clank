private /*inline*/ OffsetOfComponent(OffsetOfComponent $Prm0) {
  // : LocStart(), LocEnd(), U() 
  //START JInit
  this.LocStart = new SourceLocation($Prm0.LocStart);
  this.LocEnd = new SourceLocation($Prm0.LocEnd);
  this.U = new Unnamed_union1($Prm0.U);
  this.isBrackets = $Prm0.isBrackets;
  //END JInit
}

@Override public OffsetOfComponent clone() { 
  return new OffsetOfComponent(this); 
}
