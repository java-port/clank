private final GraphTraits<GraphT, /*class*/ NodeType, ChildNodeType> GT;

protected po_iterator(po_iterator<GraphT, NodeType, ChildNodeType> other) {
  super(other);
  GT = $tryClone(other.GT);
}

public void $destroy() {
  // should we destroy VisitStack? I don't think so
}

@Override public boolean $eq(Object $Prm0) {
  return $eq((po_iterator<GraphT, NodeType, ChildNodeType>)$Prm0);
}

@Override public po_iterator clone() {
  assert this.getClass() == po_iterator.class : "must be overridden in " + this.getClass();
  return new po_iterator(this);
}