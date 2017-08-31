private DenseMapInfoCharUnits() {
}

@Override
public boolean isKeyPointerLike() {
  return false;
}

private static final DenseMapInfoCharUnits $INFO = new DenseMapInfoCharUnits();
private static final CharUnits EmptyKey = CharUnits.fromQuantity(DenseMapInfoLong.$Info().getEmptyKey());
private static final CharUnits TombstoneKey = CharUnits.fromQuantity(DenseMapInfoLong.$Info().getTombstoneKey());
public static DenseMapInfoCharUnits $Info() {
  return $INFO;
}
