private static final DenseMapInfoDupKey INFO = new DenseMapInfoDupKey();

private DenseMapInfoDupKey() {
  super(new DupKey(0, true), new DupKey(1, true));
}

public static DenseMapInfoDupKey $Info() {
  return INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}
