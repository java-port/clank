@Override public void reset() {
  this.Positions.clear();
  list_storage$reset();
  super.reset();
}

@Override
public Iterator<std.string> iterator() {
  return new JavaIterator<>(begin(), end());
}
