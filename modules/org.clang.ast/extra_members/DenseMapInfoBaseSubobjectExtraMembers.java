private DenseMapInfoBaseSubobject() {
}

@Override
public boolean isKeyPointerLike() {
  return false;
}

private static final DenseMapInfoBaseSubobject $INFO = new DenseMapInfoBaseSubobject();
private static final BaseSubobject EmptyKey = new BaseSubobject(null, DenseMapInfoCharUnits.$Info().getEmptyKey());
private static final BaseSubobject TombstoneKey = new BaseSubobject(null, DenseMapInfoCharUnits.$Info().getTombstoneKey());
private static final DenseMapInfoPair<CXXRecordDecl, CharUnits> delegate = 
        new DenseMapInfoPair<>(new DenseMapInfo$LikePtr(null, null), DenseMapInfoCharUnits.$Info());
public static DenseMapInfoBaseSubobject $Info() {
  return $INFO;
}
