@Override public ConstantAddress clone() {
  return new ConstantAddress(this);
}

@Override public ConstantAddress move() {
  return new ConstantAddress(JD$Move.INSTANCE, this);
}
