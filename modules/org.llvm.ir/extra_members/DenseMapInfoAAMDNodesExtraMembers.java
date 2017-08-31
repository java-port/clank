private static DenseMapInfoAAMDNodes $INFO = new DenseMapInfoAAMDNodes();

public static DenseMapInfoAAMDNodes $Info() {
  return $INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}