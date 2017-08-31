private static DenseMapInfoCatchHandlerType Info = new DenseMapInfoCatchHandlerType();

public static DenseMapInfoCatchHandlerType Info() {
  return Info;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}

private final CatchHandlerType EMPTY_KEY = new CatchHandlerType(DenseMapInfoQualType.$Info().getEmptyKey(), 
        CatchHandlerType.Unique.ForDenseMap);

private final CatchHandlerType TOMBSTONE_KEY = new CatchHandlerType(DenseMapInfoQualType.$Info().getTombstoneKey(), 
    CatchHandlerType.Unique.ForDenseMap);
