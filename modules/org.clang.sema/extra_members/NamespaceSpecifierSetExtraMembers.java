@Override
    public Iterator<SpecifierInfo> iterator() {
  return new JavaIterator<>(begin(), end());
}
