@Override public RawCommentAndCacheFlags clone() { 
  return new RawCommentAndCacheFlags(this); 
}

@Override
public boolean $eq(RawCommentAndCacheFlags other) {
  if (this == other) {
    return true;
  }
  if (other == null) {
    return false;
  }
  if (this.OriginalDecl != other.OriginalDecl) {
    return false;
  }
  if (this.Data.$noteq(other.Data)) {
    return false;
  }
  return true;
}
