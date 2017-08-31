public final Key $tryCloneKey(Key K) {
  // pointer key return as is
  return K;
}

public Data $tryCloneValue(Data E) {
  assert E == null || !(E instanceof void$ptr): "must use another trait class?";
  // pointer value return as is
  return E;
}

@Override public final ImmutableMapPtrPtr<Key, Data> $tryCloneData(JavaCleaner $c$, ImmutableMapPtrPtr<Key, Data> D) {
  return $c$.track(Native.$Clone(D));
}
