//<editor-fold defaultstate="collapsed" desc="llvm::MDOperand::getSimplifiedValue">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 706)
//</editor-fold>
@Override public Object getSimplifiedValue(Object $This) {
  // copied from simplify_type<const MDOperand> 
  assert $This == this : "must be called on itself " + $This + " vs. " + this;
  return this.get();
}

private final type$ptr<Metadata/*P*/> /*P*/ MD$Ptr = new type$ptr$inout<Metadata/*P*/>() {
  @Override
  protected Metadata/*P*/ $star$impl() {
    return MD;
  }

  @Override
  protected Metadata/*P*/ $set$impl(Metadata/*P*/ value) {
    return MD = value;
  }

  @Override
  public type$ptr$inout<Metadata> clone() {
    assert false : "why was cloned?";
    return this;
  }
};
