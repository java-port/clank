@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/IR/LLVMContext.cpp", line = 234)
private static boolean isDiagnosticEnabled(DiagnosticInfo DI) {
  if (DI instanceof DiagnosticInfoOptimizationBase) {
    return ((DiagnosticInfoOptimizationBase) DI).isEnabled();
  }
  return true;
}
