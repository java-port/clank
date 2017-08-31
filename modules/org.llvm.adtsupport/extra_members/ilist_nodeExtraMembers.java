public final class ilist_node$Fields<NodeTy> {

  private ilist_node$Fields() {
    this.Next = null;
  }

  public/*private*/ NodeTy /*P*/ Next;
}
public default ilist_node$Fields<NodeTy> $ilist_node$Fields() {
  throw new UnsupportedOperationException("Override as final getter in derived " + this.getClass());
}

public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node(final /*const*/ ilist_node /*&*/ $Prm0) {
  $ilist_half_node($Prm0);
  return new ilist_node$Fields();
}

public/*protected*/ default/*interface*/ ilist_node$Fields $ilist_node(JD$Move _dparam, final ilist_node /*&&*/$Prm0) {
  $ilist_half_node(JD$Move.INSTANCE, $Prm0);
  return new ilist_node$Fields();
}

public default/*interface*/ void $destroy$ilist_node() {

}

public default/*interface*/ void $assign$ilist_node(NodeTy $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}

public default/*interface*/ void $assignMove$ilist_node(NodeTy $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}
