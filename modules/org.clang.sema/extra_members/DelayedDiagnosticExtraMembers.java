public /*inline*/ DelayedDiagnostic(final DelayedDiagnostic /*&*/$Prm0) {
  // : Kind(static_cast<DelayedDiagnostic &&>().Kind), Triggered(static_cast<DelayedDiagnostic &&>().Triggered), Loc(static_cast<DelayedDiagnostic &&>().Loc), Unnamed_field3(static_cast<DelayedDiagnostic &&>().) 
  //START JInit
  this.Kind = $Prm0.Kind;
  this.Triggered = $Prm0.Triggered;
  this.Loc = new SourceLocation($Prm0.Loc);
  this.Unnamed_field3 = new Unnamed_union3($Prm0.Unnamed_field3);
  //END JInit
}

public /*inline*/ DelayedDiagnostic /*&*/ $assign(final DelayedDiagnostic /*&*/$Prm0) {
  this.Kind = $Prm0.Kind;
  this.Triggered = $Prm0.Triggered;
  this.Loc.$assign($Prm0.Loc);
  this.Unnamed_field3.$assign($Prm0.Unnamed_field3);
  return /*Deref*/this;
}

@Override
public DelayedDiagnostic clone() {
  return new DelayedDiagnostic(this);
}

@Override
public DelayedDiagnostic move() {
  return new DelayedDiagnostic(JD$Move.INSTANCE, this);
}

@Override
public boolean $eq(DelayedDiagnostic other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.Kind != other.Kind) {
    return false;
  }
  if (this.Triggered != other.Triggered) {
    return false;
  }
  if (this.Loc.$noteq(other.Loc)) {
    return false;
  }
  if (!this.Unnamed_field3.$eq(other.Unnamed_field3)) {
    return false;
  }
  return true;
}
