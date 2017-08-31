protected LocationCheck(LocationCheck $Prm0) {
  super($Prm0);
}

protected LocationCheck(JavaDifferentiators.JD$Move _dparam, LocationCheck $Prm0) {
  super(_dparam, $Prm0);
}

@Override public LocationCheck clone() {
  assert this.getClass() == LocationCheck.class : "must be overridden in " + this.getClass();
  return new LocationCheck(this);
}

@Override public LocationCheck move() {
  assert this.getClass() == LocationCheck.class : "must be overridden in " + this.getClass();
  return new LocationCheck(JavaDifferentiators.JD$Move.INSTANCE, this);
}
