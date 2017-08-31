@Override public TypeInfo clone() { 
  return new TypeInfo(this); 
}

@Override
public boolean $eq(TypeInfo other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.Width != other.Width) {
    return false;
  }
  if (this.Align != other.Align) {
    return false;
  }
  if (this.AlignIsRequired != other.AlignIsRequired) {
    return false;
  }
  return true;
}
