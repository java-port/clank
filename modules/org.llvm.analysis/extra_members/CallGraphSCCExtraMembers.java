@Override
public Iterator<CallGraphNodeBase> iterator() {
  final JavaIterator<CallGraphNode> delegate = new JavaIterator<CallGraphNode>(begin(), end());
  return new Iterator<CallGraphNodeBase>() {
    @Override
    public boolean hasNext() {
      return delegate.hasNext();
    }

    @Override
    public CallGraphNodeBase next() {
      return delegate.next();
    }
  };
}