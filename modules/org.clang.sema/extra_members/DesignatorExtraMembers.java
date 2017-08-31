public /*inline*/ Designator(final Designator /*&&*/$Prm0) {
  // : Kind(static_cast<Designator &&>().Kind), Unnamed_field1(static_cast<Designator &&>().) 
  //START JInit
  this.Kind = $Prm0.Kind;
  this.Unnamed_field1 = new Unnamed_union4($Prm0.Unnamed_field1);
  //END JInit
}

@Override public Designator clone() {
  return new Designator(this);
}

@Override public Designator move() {
  return new Designator(JD$Move.INSTANCE, this);
} 
