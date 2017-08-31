private class finlDecl2Void implements Decl2Void {
  private finlDecl2Void() {}

  @Override
  public void $call(Decl D) {
    {
      Decl /*P*/ Prev = D.getPreviousDecl$Decl();
      if ((Prev != null)) {
        this.$call(Prev);
      }
    }
    dumpDecl(D);
  }
}
