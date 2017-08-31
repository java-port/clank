private DenseMapInfoDeclarationName() {
  super(DeclarationName.getEmptyMarker(), DeclarationName.getTombstoneMarker());
}

@Override
public boolean isKeyPointerLike() {
  return false;
}

private static final DenseMapInfoDeclarationName $INFO = new DenseMapInfoDeclarationName();

public static DenseMapInfoDeclarationName $Info() {
  return $INFO;
}
