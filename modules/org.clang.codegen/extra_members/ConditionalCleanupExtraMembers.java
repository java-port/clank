private final SupplierEx<T> $factory;
private final int[] index_sequence;
public ConditionalCleanup(SupplierEx<T> $factory, int[] index_sequence) {
  this.$factory = $factory;
  this.index_sequence = index_sequence;
}