public specific_fpval(specific_fpval other) {
  this.Val = other.Val;
}

@Override
public specific_fpval clone() {
  return new specific_fpval(this);
}
