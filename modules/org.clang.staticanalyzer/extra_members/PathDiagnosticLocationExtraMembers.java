@Override public PathDiagnosticLocation clone() {
  assert this.getClass() == PathDiagnosticLocation.class : "must be overridden in " + this.getClass();
  return new PathDiagnosticLocation(this);
}
