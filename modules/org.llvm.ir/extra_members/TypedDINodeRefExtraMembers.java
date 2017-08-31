private final Class<T> cls;

public TypedDINodeRef(TypedDINodeRef<T> other) {
  this.cls = other.cls;
  this.MD = new Metadata(other.MD);
}
