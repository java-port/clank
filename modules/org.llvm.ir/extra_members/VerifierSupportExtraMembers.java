@Converted(kind = Converted.Kind.MANUAL_ADDED)
private <T> void Write(T t) {
  if (t instanceof Module) {
    Write((Module)t);
  } else if (t instanceof Value) {
    Write((Value)t);
  } else if (t instanceof ImmutableCallSite) {
    Write((ImmutableCallSite)t);
  } else if (t instanceof Metadata) {
    Write((Metadata)t);
  } else if (t instanceof NamedMDNode) {
    Write((NamedMDNode)t);
  } else if (t instanceof Type) {
    Write((Type)t);
  } else if (t instanceof Comdat) {
    Write((Comdat)t);
  }
  throw new UnsupportedOperationException("EmptyBody: Write(" + t.getClass().getName() + ")");
}
