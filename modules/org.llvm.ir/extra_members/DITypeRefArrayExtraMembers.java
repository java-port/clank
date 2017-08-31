@Override
public Iterator<TypedDINodeRef<DIType>> iterator() {
  return new JavaIterator<>(begin(), end());
}