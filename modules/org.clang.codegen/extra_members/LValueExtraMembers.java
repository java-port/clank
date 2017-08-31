@Override public LValue clone() {
  return new LValue(this);
}

@Override public LValue move() {
  return new LValue(JD$Move.INSTANCE, this);
}
