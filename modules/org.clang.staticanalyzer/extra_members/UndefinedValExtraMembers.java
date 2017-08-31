@Override
public UndefinedVal clone() {
  return new UndefinedVal(this);
}

@Override
public UndefinedVal move() {
  return new UndefinedVal(JD$Move.INSTANCE, this);
}
