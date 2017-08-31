private final GraphTraits<GraphT, NodeRef, ChildNodeType> GT;

@Override
public scc_iterator<GraphT, NodeRef, ChildNodeType> clone() {
  return new scc_iterator<GraphT, NodeRef, ChildNodeType>(GT);
}

@Override
public boolean $eq(Object other) {
  if (other instanceof scc_iterator) {
    return $eq((scc_iterator<GraphT, NodeRef, ChildNodeType>) other);
  }
  return false;
}

public GraphTraits<GraphT, NodeRef, ChildNodeType> $GT() {
  return GT;
}

public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> scc_begin(
        GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return scc_iterator.begin(GT, G);
}

public static </*class*/ GraphT, /*class* GT = GraphTraits<GraphT>*/NodeRef, ChildNodeType> scc_iterator<GraphT, NodeRef, ChildNodeType> scc_end(
        GraphTraits<GraphT, NodeRef, ChildNodeType> GT, final /*const*/ GraphT /*&*/ G) {
  return scc_iterator.end(GT, G);
}

@Override
public void $destroy() {
  this.SCCNodeStack.$destroy();
}
