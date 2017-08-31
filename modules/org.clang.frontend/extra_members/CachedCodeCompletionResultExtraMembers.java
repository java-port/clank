@Override public CachedCodeCompletionResult clone() {
  return new CachedCodeCompletionResult(this);
}

@Override public CachedCodeCompletionResult move() {
  return new CachedCodeCompletionResult(JD$Move.INSTANCE, this);
}
