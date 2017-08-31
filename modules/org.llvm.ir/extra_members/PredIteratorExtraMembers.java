public @Override PredIterator clone() {
  return new PredIterator(this);
}

public PredIterator(PredIterator other) {
  this.It = It;
}
