public Key $tryCloneKey(Key K) {
  throw new UnsupportedOperationException("Why not implemented in derived " + this.getClass());
}

@Override public final ImmutableSet<Key> $tryCloneData(JavaCleaner $c$, ImmutableSet<Key> D) {
  return $c$.track(Native.$Clone(D));
}

private final ImutContainerInfo<Key> $ValInfo;

protected ProgramStatePartialTraitImmutableSet$T(FoldingSetTrait<Key> $KeyTrait) {
  this.$ValInfo = new ImutContainerInfo<Key>($KeyTrait);
}
