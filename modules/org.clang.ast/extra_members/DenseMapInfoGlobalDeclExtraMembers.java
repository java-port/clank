  @Override
  public boolean isKeyPointerLike() {
    return false;
  }

  private static final DenseMapInfoGlobalDecl $INFO = new DenseMapInfoGlobalDecl();
  private static final GlobalDecl EmptyKey = new GlobalDecl();//new GlobalDecl();
  private static final GlobalDecl TombstoneKey = new GlobalDecl();//GlobalDecl.getFromOpaquePtr(reinterpret_cast(GlobalDecl/*void P*/ .class, -1));
  public static DenseMapInfoGlobalDecl $Info() {
    return $INFO;
  }
