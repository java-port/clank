  @Override
  public boolean compare(Object a, Object b) {
    if (a instanceof UnqualUsingEntry) {
      if (b instanceof UnqualUsingEntry) {
        return $call((UnqualUsingEntry)a, (UnqualUsingEntry)b);
      }
      return $call((UnqualUsingEntry)a, (DeclContext/*P*/)b);
    } else {
      assert b instanceof UnqualUsingEntry : b.getClass();
      return $call((DeclContext/*P*/)a, (UnqualUsingEntry)b);
    }
  }
