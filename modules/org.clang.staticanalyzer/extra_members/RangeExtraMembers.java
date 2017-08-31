@Override public Range clone() {
  return new Range(this);
}

@Override public Range move() {
  return new Range(JD$Move.INSTANCE, this);
}
