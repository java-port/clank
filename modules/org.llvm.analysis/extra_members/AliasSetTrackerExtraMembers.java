@Override
public Iterator<AliasSet> iterator() {
  return new JavaIterator<>(begin(), end());
}
