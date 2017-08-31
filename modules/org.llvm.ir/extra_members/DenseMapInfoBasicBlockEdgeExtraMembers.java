private static DenseMapInfoBasicBlockEdge $INFO = new DenseMapInfoBasicBlockEdge();

public static DenseMapInfoBasicBlockEdge $Info() {
  return $INFO;
}

@Override
public boolean isKeyPointerLike() {
  return false;
}

public /*uint*/int getHashValue(final /*const*/ BasicBlockEdge /*&*/ Edge) {
  //return hash_combine(DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getStart()),
  //    DenseMapInfo$LikePtr.$Info().getHashValue(Edge.getEnd())).$uint();
  return getHashValue_BasicBlockEdge$C(Edge);
}

private final BasicBlockEdge emptyKey = new BasicBlockEdge((BasicBlock) null, (BasicBlock) null);

private final BasicBlockEdge tombstoneKey = new BasicBlockEdge((BasicBlock) null, (BasicBlock) null);