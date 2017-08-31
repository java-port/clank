  public void $Node() {}

  @Override
  public FoldingSetImpl.NodeImpl $nodeImpl() {
    return $nodeImpl;
  }

  private final FoldingSetImpl.NodeImpl $nodeImpl = new FoldingSetImpl.NodeImpl();

@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 252)
class FoldingSetTraitAUFoldingSetNode implements FoldingSetTrait<AUFoldingSetNode> {
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 261)
  @Override
  public void Profile(AUFoldingSetNode X, FoldingSetNodeID ID) {
    X.Profile(ID);
  }


  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 387)
  @Override
  public boolean Equals(AUFoldingSetNode X, FoldingSetNodeID ID, int $Prm2, FoldingSetNodeID TempID) {
    X.Profile(ID);
    return $eq(TempID, ID);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 397)
  public int ComputeHash(AUFoldingSetNode X, FoldingSetNodeID TempID) {
    return TempID.ComputeHash();
  }
}

public static class PMTopLevelManager$Fields {

  // Active Pass Managers
  public PMStack activeStack;
  /*protected:*/
  /// Collection of pass managers
  public/*protected*/ SmallVector<PMDataManager /*P*/> PassManagers;
  /*private:*/
  /// Collection of pass managers that are not directly maintained
  /// by this pass manager
  private SmallVector<PMDataManager /*P*/> IndirectPassManagers;

  // Map to keep track of last user of the analysis pass.
  // LastUser->second is the last user of Lastuser->first.
  private DenseMap<Pass /*P*/, Pass /*P*/> LastUser;

  // Map to keep track of passes that are last used by a pass.
  // This inverse map is initialized at PM->run() based on
  // LastUser map.
  private DenseMap<Pass /*P*/, SmallPtrSet<Pass /*P*/>> InversedLastUser;

  /// Immutable passes are managed by top level manager.
  private SmallVector<ImmutablePass /*P*/> ImmutablePasses;

  /// Map from ID to immutable passes.
  private SmallDenseMap</*AnalysisID*/Object, ImmutablePass /*,8*/> ImmutablePassMap;

  // Contains all of the unique combinations of AnalysisUsage.  This is helpful
  // when we have multiple instances of the same pass since they'll usually
  // have the same analysis usage and can share storage.

  private FoldingSet<AUFoldingSetNode> UniqueAnalysisUsages;

  // Allocator used for allocating UAFoldingSetNodes.  This handles deletion of
  // all allocated nodes in one fell swoop.
  private SpecificBumpPtrAllocator<AUFoldingSetNode> AUFoldingSetNodeAllocator;

  // Maps from a pass to it's associated entry in UniqueAnalysisUsages.  Does
  // not own the storage associated with either key or value..
  private DenseMap<Pass /*P*/, AnalysisUsage /*P*/> AnUsageMap;

  /// Collection of PassInfo objects found via analysis IDs and in this top
  /// level manager. This is used to memoize queries to the pass registry.
  /// FIXME: This is an egregious hack because querying the pass registry is
  /// either slow or racy.
  private /*mutable */ DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/> AnalysisPassInfos;

  private PMTopLevelManager$Fields() {
    activeStack = new PMStack();
    PassManagers = new SmallVector<PMDataManager /*P*/>(8, (PMDataManager /*P*/) null);
    IndirectPassManagers = new SmallVector<PMDataManager /*P*/>(8, (PMDataManager /*P*/) null);
    LastUser = new DenseMap<Pass /*P*/, Pass /*P*/>(DenseMapInfo$LikePtr.$Info(), (Pass /*P*/) null);
    InversedLastUser = new DenseMap<Pass /*P*/, SmallPtrSet<Pass /*P*/>>(DenseMapInfo$LikePtr.$Info(), new SmallPtrSet<Pass /*P*/>(DenseMapInfo$LikePtr.$Info(), 8));
    ImmutablePasses = new SmallVector<ImmutablePass /*P*/>(16, (ImmutablePass /*P*/) null);
    ImmutablePassMap = new SmallDenseMap<>(DenseMapInfo$LikePtr.$Info(), (ImmutablePass) null);
    UniqueAnalysisUsages = new FoldingSet<AUFoldingSetNode>(AUFoldingSetNode.$Trait());
    AUFoldingSetNodeAllocator = new SpecificBumpPtrAllocator<AUFoldingSetNode>(AUFoldingSetNode.class);
    AnUsageMap = new DenseMap<Pass /*P*/, AnalysisUsage /*P*/>(DenseMapInfo$LikePtr.$Info(), (AnalysisUsage /*P*/) null);
    AnalysisPassInfos = new DenseMap</*const*/Object/*void P*/, /*const*/ PassInfo /*P*/>(/*DenseMapInfo$LikePtr*/DenseMapInfoVoid$Ptr.$Info(), (/*const*/PassInfo /*P*/) null);
  }

  @Override
  public String toString() {
    return "" + "activeStack=" + activeStack // NOI18N
            + ", PassManagers=" + "[SmallVector$PMDataManager]" // NOI18N
            + ", IndirectPassManagers=" + "[SmallVector$PMDataManager]" // NOI18N
            + ", LastUser=" + LastUser // NOI18N
            + ", InversedLastUser=" + InversedLastUser // NOI18N
            + ", ImmutablePasses=" + ImmutablePasses // NOI18N
            + ", ImmutablePassMap=" + ImmutablePassMap // NOI18N
            + ", UniqueAnalysisUsages=" + UniqueAnalysisUsages // NOI18N
            + ", AUFoldingSetNodeAllocator=" + AUFoldingSetNodeAllocator // NOI18N
            + ", AnUsageMap=" + AnUsageMap // NOI18N
            + ", AnalysisPassInfos=" + AnalysisPassInfos; // NOI18N
  }
}

default PMTopLevelManager$Fields $PMTopLevelManager$Fields() {
  throw new UnsupportedOperationException("Why not implemented in derived?");
}