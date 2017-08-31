public static class PMDataManager$Fields {  
  /*protected:*/
  // Top level manager.
  public/*protected*/ PMTopLevelManager /*P*/ TPM;

  // Collection of pass that are managed by this manager
  public/*protected*/ SmallVector<Pass /*P*/> PassVector;

  // Collection of Analysis provided by Parent pass manager and
  // used by current pass manager. At at time there can not be more
  // then PMT_Last active pass mangers.
  public/*protected*/ DenseMap</*const*/Object/*void P*/, Pass /*P*/> /*P*/ InheritedAnalysis[/*7*/] = new DenseMap /*P*/[7];

  // Set of available Analysis. This information is used while scheduling
  // pass. If a pass requires an analysis which is not available then
  // the required analysis pass is scheduled to run before the pass itself is
  // scheduled to run.
  public/*private*/ DenseMap</*const*/Object/*void P*/, Pass /*P*/ > AvailableAnalysis;

  // Collection of higher level analysis used by the pass managed by
  // this manager.
  public/*private*/ SmallVector<Pass /*P*/ > HigherLevelAnalysis;

  public/*private*/ /*uint*/int Depth;

  public PMDataManager$Fields() {
    TPM = null;
    PassVector = new SmallVector<Pass /*P*/ >(16, (Pass /*P*/ )null);
    AvailableAnalysis = new DenseMap</*const*/Object/*void P*/, Pass /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Pass /*P*/ )null);
    HigherLevelAnalysis = new SmallVector<Pass /*P*/ >(16, (Pass /*P*/ )null);
    Depth = 0;
  }
  
  @Override
  public String toString() {
    return "" + "TPM=" + "[PMTopLevelManager]" // NOI18N
            + ", PassVector=" + PassVector // NOI18N
            + ", InheritedAnalysis=" + InheritedAnalysis // NOI18N
            + ", AvailableAnalysis=" + AvailableAnalysis // NOI18N
            + ", HigherLevelAnalysis=" + HigherLevelAnalysis // NOI18N
            + ", Depth=" + Depth; // NOI18N
  }    
}

@Converted(kind = Converted.Kind.MANUAL_ADDED)
/*private*/ default PMDataManager$Fields $PMDataManager$Fields() {
  throw new UnsupportedOperationException("Why not implemented in derived?");
}
