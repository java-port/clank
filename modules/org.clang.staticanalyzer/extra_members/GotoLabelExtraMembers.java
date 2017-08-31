@Override
public GotoLabel clone() {
  assert this.getClass() == GotoLabel.class : "Why not overridden in " + this.getClass();
  return new GotoLabel(this);
}

@Override
public GotoLabel move() {
  assert this.getClass() == GotoLabel.class : "Why not overridden in " + this.getClass();
  return new GotoLabel(JD$Move.INSTANCE, this);
}
