@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_14ObjCMethodCallEPKNS_15ObjCMessageExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_14ObjCMethodCallEPKNS_15ObjCMessageExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private ObjCMethodCall /*P*/ createObjCMethodCall(/*const*/ ObjCMessageExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_ObjCMethodCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(ObjCMethodCall.class), (type$ptr<?> New$Mem)->{
        return new ObjCMethodCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_16CXXAllocatorCallEPKNS_10CXXNewExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_16CXXAllocatorCallEPKNS_10CXXNewExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private CXXAllocatorCall /*P*/ createCXXAllocatorCall(/*const*/ CXXNewExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_CXXAllocatorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXAllocatorCall.class), (type$ptr<?> New$Mem)->{
        return new CXXAllocatorCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_13CXXMemberCallEPKNS_17CXXMemberCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_13CXXMemberCallEPKNS_17CXXMemberCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private CXXMemberCall /*P*/ createCXXMemberCall(/*const*/ CXXMemberCallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_CXXMemberCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXMemberCall.class), (type$ptr<?> New$Mem)->{
        return new CXXMemberCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_21CXXMemberOperatorCallEPKNS_19CXXOperatorCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_21CXXMemberOperatorCallEPKNS_19CXXOperatorCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private CXXMemberOperatorCall /*P*/ createCXXMemberOperatorCall(/*const*/ CXXOperatorCallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_CXXMemberOperatorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXMemberOperatorCall.class), (type$ptr<?> New$Mem)->{
        return new CXXMemberOperatorCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_9BlockCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_9BlockCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private BlockCall /*P*/ createBlockCall(/*const*/ CallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_BlockCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(BlockCall.class), (type$ptr<?> New$Mem)->{
        return new BlockCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_18SimpleFunctionCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_18SimpleFunctionCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private SimpleFunctionCall /*P*/ createSimpleFunctionCall(/*const*/ CallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_SimpleFunctionCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(SimpleFunctionCall.class), (type$ptr<?> New$Mem)->{
        return new SimpleFunctionCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}

//////
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1020,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_18CXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEEEPT_T0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_18CXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEEEPT_T0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private CXXConstructorCall /*P*/ createCXXConstructorCall(/*const*/ CXXConstructExpr /*P*/ A1, /*const*/ MemRegion /*P*/ A2, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_CXXConstructorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System]allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXConstructorCall.class), (type$ptr<?> New$Mem)->{
        return new CXXConstructorCall(A1, A2, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}

////////
@Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1036,
 FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_17CXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbEEPT_T0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_17CXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbEEPT_T0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
//</editor-fold>
private CXXDestructorCall /*P*/ createCXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ A1, /*const*/ Stmt /*P*/ A2, /*const*/ MemRegion /*P*/ A3, boolean A4, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    //static_assert($sizeof_CXXDestructorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
    return $c$.clean(/*NEW_EXPR [System]allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXDestructorCall.class), (type$ptr<?> New$Mem)->{
        return new CXXDestructorCall(A1, A2, A3, A4, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
     }));
  } finally {
    $c$.$destroy();
  }
}  
