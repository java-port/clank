public/*protected*/ default/*interface*/ ilist_half_node$Fields<NodeTy> $ilist_half_node(final /*const*/ ilist_half_node<NodeTy> /*&*/ $Prm0) {
  return new ilist_half_node$Fields<NodeTy>($Prm0.$ilist_half_node$Fields());
}

public/*protected*/ default/*interface*/ ilist_half_node$Fields<NodeTy> $ilist_half_node(JD$Move _dparam, final ilist_half_node<NodeTy> /*&&*/$Prm0) {
  return new ilist_half_node$Fields<NodeTy>(_dparam, $Prm0.$ilist_half_node$Fields());
}

public /*final*/ static class ilist_half_node$Fields<NodeTy> {
  public/*private*/ NodeTy /*P*/ Prev;
  protected ilist_half_node$Fields() {
    this.Prev = null;
  }
  protected ilist_half_node$Fields(ilist_half_node$Fields<NodeTy> $Prm0) {
    this.Prev = $Prm0.Prev;
  }
  protected ilist_half_node$Fields(JD$Move _dparam, ilist_half_node$Fields<NodeTy> $Prm0) {
    this.Prev = $Prm0.Prev;
  }
}

public default ilist_half_node$Fields<NodeTy> $ilist_half_node$Fields() {
  throw new UnsupportedOperationException("Override as final getter in derived " + this.getClass());
}
