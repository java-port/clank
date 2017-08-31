@Override public BlockEdge clone() {
  assert this.getClass() == BlockEdge.class : "clone must be overridden in " + this.getClass();
  return new BlockEdge(this);
}
