@Override public AttributeSet clone() {
  return new AttributeSet(this);
}  

@Override public AttributeSet move() {
  return new AttributeSet(JD$Move.INSTANCE, this);
}
