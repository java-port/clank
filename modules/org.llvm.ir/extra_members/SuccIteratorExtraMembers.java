public SuccIterator(SuccIterator<Term, BB> other) {
  this.TermInst = other.TermInst;
  this.idx = other.idx;
}

@Override
public SuccIterator clone() {
  return new SuccIterator(this);
}
