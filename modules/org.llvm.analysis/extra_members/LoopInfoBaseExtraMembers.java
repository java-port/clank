@Override
public Iterator<LoopT> iterator() {
  return new JavaIterator<>(begin(), end());
}
