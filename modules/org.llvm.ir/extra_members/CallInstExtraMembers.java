protected CallInst() { throw new UnsupportedOperationException("EmptyBody"); }

@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 1845)
private boolean hasFnAttrImpl(StringRef A) /*const*/ {
  if (AttributeList.hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A)) {
    return true;
  }

  // Operand bundles override attributes on the called function, but don't
  // override attributes directly present on the call instruction.
  if (isFnAttrDisallowedByOpBundle(A)) {
    return false;
  }
  {

    /*const*/ Function /*P*/ F = getCalledFunction();
    if ((F != null)) {
      return F.getAttributes().hasAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), A);
    }
  }
  return false;
}
