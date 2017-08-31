private final boolean External;

public po_iterator_storage() {
  this(false);
}
public po_iterator_storage(boolean External) {
  this.External = External;
}
public po_iterator_storage(boolean External, final SetType /*&*/ VSet) {
  // : Visited(VSet) 
  this.External = External;
  this.Visited = VSet;
}
