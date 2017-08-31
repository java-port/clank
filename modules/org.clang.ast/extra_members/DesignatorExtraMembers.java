@Override
public Designator clone() {
  return new Designator(this);
}

@Override
public Designator move() {
  return new Designator(JD$Move.INSTANCE, this);
}
