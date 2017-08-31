@Override
public NonLoc clone() {
  assert this.getClass() == NonLoc.class : "Why not overridden in " + this.getClass();
  return new NonLoc(this);
}

@Override
public NonLoc move() {
  assert this.getClass() == NonLoc.class : "Why not overridden in " + this.getClass();
  return new NonLoc(JD$Move.INSTANCE, this);
}
