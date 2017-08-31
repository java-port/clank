@Override
public Iterator<MCSection> iterator() {
  return new JavaIterator<>(Sections.begin(), Sections.end());
}
