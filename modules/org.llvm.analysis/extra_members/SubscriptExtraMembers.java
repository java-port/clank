public type$ref<SCEV> Src_ref = new type$ptr$inout<SCEV>(this) {
  @Override
  protected SCEV $star$impl() {
    return Src;
  }

  @Override
  protected SCEV $set$impl(SCEV value) {
    Src = value;
    return Src;
  }      
};
public type$ref<SCEV> Dst_ref = new type$ptr$inout<SCEV>(this) {
  @Override
  protected SCEV $star$impl() {
    return Dst;
  }

  @Override
  protected SCEV $set$impl(SCEV value) {
    Dst = value;
    return Dst;
  }      
};
