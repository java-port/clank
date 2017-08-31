protected abstract ilist_traits<NodeTy> $traits();

private final type$ref<NodeTy> Head$ref = new type$ref<NodeTy>() {
  public @Override NodeTy $deref() {
    return Head;
  }
  public @Override NodeTy $set(NodeTy value) {
    Head = value;
    return Head;
  }          
};  

@Override
public NodeTy createNode(NodeTy V) {
  return $traits().createNode(V);
}

@Override
public void deleteNode(NodeTy V) {
  $traits().deleteNode(V);
}

@Override
public void addNodeToList(NodeTy $Prm0) {
  $traits().addNodeToList($Prm0);
}

@Override
public void removeNodeFromList(NodeTy $Prm0) {
  $traits().removeNodeFromList($Prm0);
}

@Override
public void transferNodesFromList(ilist_node_traits<NodeTy> $Prm0, ilist_iterator<NodeTy> $Prm1, ilist_iterator<NodeTy> $Prm2) {
  $traits().transferNodesFromList($Prm0, $Prm1, $Prm2);
}

@Override
public NodeTy createSentinel() {
  return $traits().createSentinel();
}

@Override
public void destroySentinel(NodeTy N) {
  $traits().destroySentinel(N);
}

@Override
public NodeTy provideInitialHead() {
  return $traits().provideInitialHead();
}

@Override
public NodeTy ensureHead(type$ref<NodeTy> Head) {
  return $traits().ensureHead(Head$ref);
}

@Override
public void noteHead(NodeTy NewHead, NodeTy Sentinel) {
  $traits().noteHead(NewHead, Sentinel);
}

@Override
public NodeTy getPrev(NodeTy N) {
  return $traits().getPrev(N);
}

@Override
public NodeTy getNext(NodeTy N) {
  return $traits().getNext(N);
}

@Override
public void setPrev(NodeTy N, NodeTy Prev) {
  $traits().setPrev(N, Prev);
}

@Override
public void setNext(NodeTy N, NodeTy Next) {
  $traits().setNext(N, Next);
}
