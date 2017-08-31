public SuppressAccessChecks() {
  this.S = null;
  this.DiagnosticPool = null;
  this.State = null;
}

@Override public SuppressAccessChecks clone() {
  // can be used only by check-cloneable
  assert this.S == null;
  assert this.DiagnosticPool == null;
  assert this.State == null;
  return new SuppressAccessChecks();
}

@Override
public SuppressAccessChecks move() {
  assert this.S != null;
  assert this.DiagnosticPool != null;
  assert this.State != null;
  return new SuppressAccessChecks(JD$Move.INSTANCE, this);
}
