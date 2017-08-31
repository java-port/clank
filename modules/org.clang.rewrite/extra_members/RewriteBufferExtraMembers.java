@Override
public RewriteBuffer $assign(RewriteBuffer value) {
  this.Buffer = value.Buffer;
  this.Deltas = value.Deltas;
  return this;
}

@Override public RewriteBuffer clone() {
  RewriteBuffer res = new RewriteBuffer();
  res.$assign(this);
  return res;
}

@Override public RewriteBuffer move() {
  return new RewriteBuffer(JD$Move.INSTANCE, this);    
}
