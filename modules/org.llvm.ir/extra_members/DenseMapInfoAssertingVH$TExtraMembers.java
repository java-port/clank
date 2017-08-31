private static DenseMapInfoAssertingVH$T $INFO = new DenseMapInfoAssertingVH$T();

public static DenseMapInfoAssertingVH$T $Info() {
  return $INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}