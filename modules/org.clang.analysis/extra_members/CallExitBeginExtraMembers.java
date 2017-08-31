protected CallExitBegin(CallExitBegin $Prm0) {
  super($Prm0);
}

protected CallExitBegin(JavaDifferentiators.JD$Move _dparam, CallExitBegin $Prm0) {
  super(_dparam, $Prm0);
}

@Override public CallExitBegin clone() {
  assert this.getClass() == CallExitBegin.class : "must be overridden in " + this.getClass();
  return new CallExitBegin(this);
}

@Override public CallExitBegin move() {
  assert this.getClass() == CallExitBegin.class : "must be overridden in " + this.getClass();
  return new CallExitBegin(JavaDifferentiators.JD$Move.INSTANCE, this);
}
