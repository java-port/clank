private static final DenseMapInfoQualType INFO = new DenseMapInfoQualType();

public static DenseMapInfoQualType $Info() {
  return INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}
