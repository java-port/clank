@Override
public ilist_iterator<NodeTy> $inc(int amount) {
  if (amount > 0) {
    while(amount-- > 0) {
      NodePtr = this.$traits.getNext(NodePtr);
    }
  } else if (amount < 0) {
    while (amount++ < 0) {
      NodePtr = this.$traits.getPrev(NodePtr);
    }      
  }
  return this;
}

@Override
public int $sub(ilist_iterator<NodeTy> iter) {
  if( $eq(iter) ) {
    return 0;
  } else {    
    int distance = 0;
    NodeTy p;
    for(p = iter.NodePtr; p != null && p != NodePtr /*&& p != iter.NodePtr*/; p = p.getNext()) {
      distance++;
    }
    if (p == NodePtr) {
      return distance;
    } else {
      return Integer.MAX_VALUE;
    }
  }
}

@Override
public boolean $eq(Object other) {
  return $eq((ilist_iterator)other);
}

@Override
public ilist_iterator<NodeTy> clone() {
  return new ilist_iterator<>(this);
}

public ilist_iterator(JavaDifferentiators.JD$Move INSTANCE, ilist_iterator<NodeTy> Tok) {
  this.$traits = $changeTraitsToDefaultIfNeed(Tok.$traits);
  this.NodePtr = Tok.NodePtr;
  Tok.NodePtr = null;
}

public void $assignMove(ilist_iterator<NodeTy> Tok) {
  this.NodePtr = Tok.NodePtr;
  //this.$traits = Tok.$traits;
  Tok.NodePtr = null;
}

private final ilist_traits<NodeTy> $changeTraitsToDefaultIfNeed(ilist_traits<NodeTy> traits) {
  if (traits == null) {
    traits = new ilist_traits<NodeTy>() {
      @Override
      public <NodeTy> NodeTy createSentinel() {
        throw new UnsupportedOperationException("Not supported yet.");
      }

      @Override
      public NodeTy ensureHead(type$ref<NodeTy> Head) {
        throw new UnsupportedOperationException("Not supported yet.");
      }      
    };
  }
  return traits;
}

private final ilist_traits<NodeTy> $traits;
