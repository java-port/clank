protected final boolean needsCleanup = false;
protected final T defaultValue;
// Only Java! 
// Means that in native code AstVector contained pointers but in Java they were converted as Java references
public boolean isDataPointerLike() {
  return defaultValue == null;
}
void $set(int Init, T expr) { 
  Begin.$set(Init, expr); 
}