public final Key $tryCloneKey(Key K) {
  // pointer key return as is
  return K;
}

public final boolean $tryCloneValue(boolean E) {
  return E;
}

@Override public final ImmutableMapPtrBool<Key> $tryCloneData(JavaCleaner $c$, ImmutableMapPtrBool<Key> D) {
  return $c$.track(Native.$Clone(D));
}
