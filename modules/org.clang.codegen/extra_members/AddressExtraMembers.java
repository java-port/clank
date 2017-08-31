public Address() {
  this.Pointer = null;
  this.Alignment = new CharUnits();
}

@Override public Address clone() {
  return new Address(this);
}

@Override public Address move() {
  return new Address(JD$Move.INSTANCE, this);
}
