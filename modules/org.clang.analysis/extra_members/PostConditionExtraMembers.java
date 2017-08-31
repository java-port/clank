protected PostCondition(PostCondition $Prm0) {
  super($Prm0);
}

protected PostCondition(JavaDifferentiators.JD$Move _dparam, PostCondition $Prm0) {
  super(_dparam, $Prm0);
}

@Override public PostCondition clone() {
  assert this.getClass() == PostCondition.class : "must be overridden in " + this.getClass();
  return new PostCondition(this);
}

@Override public PostCondition move() {
  assert this.getClass() == PostCondition.class : "must be overridden in " + this.getClass();
  return new PostCondition(JavaDifferentiators.JD$Move.INSTANCE, this);
}
