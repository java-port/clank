public PossiblyUnreachableDiag() {
  this.PD = new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic());
  this.Loc = new SourceLocation();
  this.stmt = null;
}

@Override public PossiblyUnreachableDiag clone() {
  return new PossiblyUnreachableDiag(this);
}

@Override public /*inline*/ PossiblyUnreachableDiag /*&*/ $assignMove(final /*const*/ PossiblyUnreachableDiag /*&*/ $Prm0) {
  this.PD.$assignMove($Prm0.PD);
  this.Loc.$assignMove($Prm0.Loc);
  this.stmt = $Prm0.stmt;
  return /*Deref*/this;
}

@Override public PossiblyUnreachableDiag move() {
  return new PossiblyUnreachableDiag(JD$Move.INSTANCE, this);
}
