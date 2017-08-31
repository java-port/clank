@Override public JumpDest clone() {
  return new JumpDest(this);
}

@Override public JumpDest move() {
  return new JumpDest(JD$Move.INSTANCE, this);
}
