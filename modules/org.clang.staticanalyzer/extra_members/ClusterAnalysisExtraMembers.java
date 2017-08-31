// JAVA: destroy temporary passed by child class as
// /*ExprWithCleanups*/super(rm, stateMgr, $c$.track(new RegionBindingsRef(b))
public ClusterAnalysis(final RegionStoreManager /*&*/ rm, final ProgramStateManager /*&*/ StateMgr, 
    RegionBindingsRef b, JD$Clean _dparm) {
  this(rm, StateMgr, b);
  // do requested clean up
  if (_dparm != null) b.$destroy();
}

@Override public void $destroy() {
}
