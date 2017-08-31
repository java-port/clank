@Converted(kind = Converted.Kind.MANUAL_ADDED)
public OriginalCallArg() {
  this.OriginalParamType = new QualType();
  this.ArgIdx = 0;
  this.OriginalArgType = new QualType();
}

@Override
public OriginalCallArg clone() {
  return new OriginalCallArg(this);
}
