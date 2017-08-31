public static final DeclarationNameKey EmptyKey = new DeclarationNameKey(-1, $int2ulong(1));
public static final DeclarationNameKey TombstoneKey = new DeclarationNameKey(-1, $int2ulong(2));

@Override
public boolean isKeyPointerLike() {
  return false; // DeclarationNameKey is cloneable Value-type
}

private static DenseMapInfoDeclarationNameKey INFO = new DenseMapInfoDeclarationNameKey();
public static DenseMapInfoDeclarationNameKey $Info() {
  return INFO;
}
