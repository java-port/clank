@Override
public boolean $less(Object obj) {
  return $less((Attribute)obj);
}

@Override
public Attribute clone() {
  return new Attribute(this);
}

@Override
public Attribute move() {
  return new Attribute(JD$Move.INSTANCE, this);
}
