@Override
public Object $tryCloneData(JavaCleaner $c$, Object D) {
  if (D == null) {
    return null;
  } else if (D instanceof NativePointerLike) {
    return Native.$Clone((NativeCloneable)D);
  } else if (D instanceof void$ptr) {
    return Native.$Clone((NativeCloneable)D);
  }
  // else we suppose it was pointer like Java-reference
  return D;
}
