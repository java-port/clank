private final Predicate predicate;

public boolean isValue(APInt C) {
  return predicate.isValue(C);
}
