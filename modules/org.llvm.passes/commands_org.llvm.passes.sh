# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes
mkdir -p ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN4llvm11PassBuilderE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/PassBuilder.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_117NoOpCGSCCAnalysisE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpCGSCCAnalysis.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_113NoOpCGSCCPassE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpCGSCCPass.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_120NoOpFunctionAnalysisE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpFunctionAnalysis.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_116NoOpFunctionPassE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpFunctionPass.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_116NoOpLoopAnalysisE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpLoopAnalysis.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_112NoOpLoopPassE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpLoopPass.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_118NoOpModuleAnalysisE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpModuleAnalysis.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZN12_GLOBAL__N_114NoOpModulePassE;" > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/NoOpModulePass.java

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.passes/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp "-nm=_ZL14isLoopPassNameN4llvm9StringRefE;_ZL15isCGSCCPassNameN4llvm9StringRefE;_ZL16isModulePassNameN4llvm9StringRefE;_ZL17DefaultAliasRegex;_ZL18isFunctionPassNameN4llvm9StringRefE;" -static-type=PassBuilderStatics -package=org.llvm.passes.impl > ${SPUTNIK}/modules/org.llvm.passes/src/org/llvm/passes/impl/PassBuilderStatics.java

