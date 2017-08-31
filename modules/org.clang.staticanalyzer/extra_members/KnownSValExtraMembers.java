@Override
public KnownSVal clone() {
  return new KnownSVal(this);
}

@Override
public KnownSVal move() {
  return new KnownSVal(JD$Move.INSTANCE, this);
}
