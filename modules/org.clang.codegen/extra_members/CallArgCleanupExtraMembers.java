@Override public CallArgCleanup clone() {
  return new CallArgCleanup().$assign(this);
}

@Override public CallArgCleanup move() {
  return new CallArgCleanup().$assignMove(this);
}
