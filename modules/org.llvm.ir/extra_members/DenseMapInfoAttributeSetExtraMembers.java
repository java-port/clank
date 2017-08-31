private static DenseMapInfoAttributeSet $INFO = new DenseMapInfoAttributeSet();

public static DenseMapInfoAttributeSet $Info() {
  return $INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}