// typedef void (*CodeGenTy)(intptr_t, CodeGenFunction &, PrePostActionTy &);
@FunctionalInterface public static interface CodeGenTy {
  void $call(Object/*intptr_t*/ p, CodeGenFunction /*&*/ f, PrePostActionTy /*&*/ a); 
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.h", line = 79,
 FQN="clang::CodeGen::RegionCodeGenTy::RegionCodeGenTy", NM="Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGOpenMPRuntime.cpp -nm=Tpl__ZN5clang7CodeGen15RegionCodeGenTyC1EOT_PNSt9enable_ifIXntsr3std7is_sameINSt16remove_referenceIS2_E4typeES1_EE5valueEvE4typeE")
//</editor-fold>
public </*typename*/ Callable extends CodeGenTy> RegionCodeGenTy(final Callable /*&&*/CodeGenCallback) {
  this(JD$NotSameRegionCodeGenTy.INSTANCE, CodeGenCallback);
}

public RegionCodeGenTy(JD$NotSameRegionCodeGenTy INSTANCE, CodeGenFunctionPrePostActionTy2Void CodeGen) {
  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}
