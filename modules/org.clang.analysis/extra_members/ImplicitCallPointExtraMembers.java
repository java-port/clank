@Override public ImplicitCallPoint clone() {
  assert this.getClass() == ImplicitCallPoint.class : "must be overridden in " + this.getClass();
  return new ImplicitCallPoint(this);
}

@Override public ImplicitCallPoint move() {
  assert this.getClass() == ImplicitCallPoint.class : "must be overridden in " + this.getClass();
  return new ImplicitCallPoint(JD$Move.INSTANCE, this);
}
