protected PreLoad(PreLoad $Prm0) {
  super($Prm0);
}

protected PreLoad(JavaDifferentiators.JD$Move _dparam, PreLoad $Prm0) {
  super(_dparam, $Prm0);
}

@Override public PreLoad clone() {
  assert this.getClass() == PreLoad.class : "must be overridden in " + this.getClass();
  return new PreLoad(this);
}

@Override public PreLoad move() {
  assert this.getClass() == PreLoad.class : "must be overridden in " + this.getClass();
  return new PreLoad(JavaDifferentiators.JD$Move.INSTANCE, this);
}
