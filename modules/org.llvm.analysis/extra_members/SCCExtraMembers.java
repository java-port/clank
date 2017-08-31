@Override
public Iterator<Node> iterator() {
  return new JavaIterator<>(begin(), end());
}
