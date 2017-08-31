@Override public CallArgList clone() {
  return new CallArgList().$assign(this);
}

@Override public CallArgList move() {
  return new CallArgList(JD$Move.INSTANCE, this);
}
