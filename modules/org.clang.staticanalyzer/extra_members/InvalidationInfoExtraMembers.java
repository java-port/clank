@Override
public InvalidationInfo clone() {
  return new InvalidationInfo(this);
}

@Override
public InvalidationInfo move() {
  return new InvalidationInfo(JD$Move.INSTANCE, this);
}
