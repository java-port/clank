protected PreStore(PreStore $Prm0) {
  super($Prm0);
}

protected PreStore(JavaDifferentiators.JD$Move _dparam, PreStore $Prm0) {
  super(_dparam, $Prm0);
}

@Override public PreStore clone() {
  assert this.getClass() == PreStore.class : "must be overridden in " + this.getClass();
  return new PreStore(this);
}

@Override public PreStore move() {
  assert this.getClass() == PreStore.class : "must be overridden in " + this.getClass();
  return new PreStore(JavaDifferentiators.JD$Move.INSTANCE, this);
}
