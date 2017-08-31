private static final Comparator<pairPtrType<Action/*P*/, string>> CACHED_RESULT_COMPARATOR = new Comparator<pairPtrType<Action, string>>() {
  @Override
  public int compare(pairPtrType<Action, string> o1, pairPtrType<Action, string> o2) {
    if (o1.first == o2.first) {
      return o1.second.compare(o2.second);
    } else {
      return o1.hashCode() - o2.hashCode();
    }
  }
};
