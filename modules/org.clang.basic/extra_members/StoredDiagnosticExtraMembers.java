@Override public StoredDiagnostic clone() {
  return new StoredDiagnostic(this);
}

@Override public StoredDiagnostic move() {
  return new StoredDiagnostic(JD$Move.INSTANCE, this);
}
