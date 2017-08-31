# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker
mkdir -p ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp "-nm=_ZN4llvm7IRMoverE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/IRMover.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp "-nm=_ZN4llvm6LinkerE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/Linker.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZN12_GLOBAL__N_123GlobalValueMaterializerE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/GlobalValueMaterializer.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZN12_GLOBAL__N_18IRLinkerE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/IRLinker.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZN4llvm18LinkDiagnosticInfoE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/LinkDiagnosticInfo.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZN12_GLOBAL__N_122LocalValueMaterializerE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/LocalValueMaterializer.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp "-nm=_ZN12_GLOBAL__N_112ModuleLinkerE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/ModuleLinker.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZN12_GLOBAL__N_19TypeMapTyE;" > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/TypeMapTy.java

# Global and static namespaces

# Static functions/variables
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp "-nm=_ZL12mergeTriplesRKN4llvm6TripleES2_;_ZL12triplesMatchRKN4llvm6TripleES2_;_ZL13forceRenamingPN4llvm11GlobalValueENS_9StringRefE;_ZL16getArrayElementsPKN4llvm8ConstantERNS_15SmallVectorImplIPS0_EE;" -static-type=IRMoverStatics -package=org.llvm.linker.impl > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/IRMoverStatics.java
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp "-nm=_ZL16getMinVisibilityN4llvm11GlobalValue15VisibilityTypesES1_;" -static-type=LinkModulesStatics -package=org.llvm.linker.impl > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/LinkModulesStatics.java

# Global functions/variables
#${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.linker/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp "-nm=_Z16LLVMLinkModules2;" -static-type=LinkModulesGlobals -package=org.llvm.linker.impl > ${SPUTNIK}/modules/org.llvm.linker/src/org/llvm/linker/impl/LinkModulesGlobals.java

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

# Global typedefs


