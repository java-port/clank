@Override
public SrcBuffer $assign(SrcBuffer value) {
  this.Buffer = new unique_ptr<>(value.Buffer);
  this.IncludeLoc = new SMLoc(value.IncludeLoc);
  return this;
}

@Override
public SrcBuffer clone() {
  SrcBuffer res = new SrcBuffer();
  res.$assign(this);
  return res;
}
