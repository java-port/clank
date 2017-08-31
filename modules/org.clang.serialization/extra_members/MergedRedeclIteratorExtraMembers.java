public MergedRedeclIterator(MergedRedeclIterator<DeclT> other) {
  this.Start = other.Start;
  this.Canonical = other.Canonical;
  this.Current = other.Current;
}

@Override
public MergedRedeclIterator clone() {
  return new MergedRedeclIterator(this);
}

@Override
public boolean $noteq(Object RHS) {
  return $noteq_MergedRedeclIterator$DeclT$C(this, (MergedRedeclIterator<DeclT>)RHS);
}

@Override
public boolean $eq(Object RHS) {
  return this.Current == ((MergedRedeclIterator<DeclT>)RHS).Current;
}
