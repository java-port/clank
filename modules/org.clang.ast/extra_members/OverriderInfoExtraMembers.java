@Override public OverriderInfo clone() {
  return new OverriderInfo(this);
}

@Override public OverriderInfo move() {
  return new OverriderInfo(JD$Move.INSTANCE, this);
}
