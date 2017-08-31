@Override
public boolean $less(Object other) {
  if (FilePath.$less(((Replacement)other).FilePath)) {
    return true;
  }
  if (FilePath.$eq(((Replacement)other).FilePath)) {
    return ReplacementRange.getOffset() < ((Replacement)other).getOffset();
  }
  return false;
}

@Override public String toString() {
  return "Replacement{" + __toString().toJavaString() + "}"; // NOI18N
}
