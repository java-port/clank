public OffsetOfNode() {
  this.Range = new SourceRange();
}

private byte DataKind;

@Override public OffsetOfNode clone() {
  return new OffsetOfNode(this);
}
