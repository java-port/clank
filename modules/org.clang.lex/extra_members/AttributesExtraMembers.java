@Override
public Attributes clone() {
  return new Attributes(this);
}

@Override
public boolean $eq(Attributes other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.IsSystem != other.IsSystem) {
    return false;
  }
  if (this.IsExternC != other.IsExternC) {
    return false;
  }
  if (this.IsExhaustive != other.IsExhaustive) {
    return false;
  }
  return true;
}
