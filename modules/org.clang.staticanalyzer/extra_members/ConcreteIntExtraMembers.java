@Override
public ConcreteInt clone() {
  assert this.getClass() == ConcreteInt.class : "Why not overridden in " + this.getClass();
  return new ConcreteInt(this);
}

@Override
public ConcreteInt move() {
  assert this.getClass() == ConcreteInt.class : "Why not overridden in " + this.getClass();
  return new ConcreteInt(JD$Move.INSTANCE, this);
}
