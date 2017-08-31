public ImmutableList(ImmutableList<T> $Prm0) {
  this.X = $Prm0.X;
}

public ImmutableList<T> $assign(ImmutableList<T> consVals) {
  assert this != consVals;
  this.X = consVals.X;
  return this;
}

public ImmutableList<T> $assignMove(ImmutableList<T> consVals) {
  assert this != consVals;
  this.X = consVals.X;
  consVals.X = null;
  return this;
}

@Override public ImmutableList<T> clone() {
  return new ImmutableList<T>(this);
}

@Override
public Iterator<T> iterator() {
  return new JavaIterator<T>(begin(), end());
}
