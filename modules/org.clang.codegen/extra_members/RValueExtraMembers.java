@Override public RValue clone() {
  return new RValue(this);
}

@Override public RValue move() {
  return new RValue(JD$Move.INSTANCE, this);
}
