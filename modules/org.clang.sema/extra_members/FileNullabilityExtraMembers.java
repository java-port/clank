@Override public FileNullability clone() {
  return new FileNullability(this);
}

@Override
public boolean $eq(FileNullability other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.PointerKind != other.PointerKind) {
    return false;
  }
  if (this.SawTypeNullability != other.SawTypeNullability) {
    return false;
  }
  if (this.PointerLoc.$noteq(other.PointerLoc)) {
    return false;
  }
  return true;
}
