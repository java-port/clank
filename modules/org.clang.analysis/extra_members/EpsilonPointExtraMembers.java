@Override public EpsilonPoint clone() {
  assert this.getClass() == EpsilonPoint.class : "must be overridden in " + this.getClass();
  return new EpsilonPoint(this);
}

@Override public EpsilonPoint move() {
  assert this.getClass() == EpsilonPoint.class : "must be overridden in " + this.getClass();
  return new EpsilonPoint(JD$Move.INSTANCE, this);
}
