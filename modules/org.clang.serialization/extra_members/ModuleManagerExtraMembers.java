@Override
public Iterator<ModuleFile> iterator() {
  return new JavaIterator<ModuleFile>(begin(), end());
}
