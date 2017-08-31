public Key $tryCloneKey(Key K) {
  throw new UnsupportedOperationException("Why not implemented in derived " + this.getClass());
}

@Override
public ImmutableList<Key> $tryCloneData(JavaCleaner $c$, ImmutableList<Key> D) {
  return $c$.track(Native.$Clone(D));
}
