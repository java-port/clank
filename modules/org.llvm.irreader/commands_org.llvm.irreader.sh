# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.irreader/src/org/llvm/irreader
mkdir -p ${SPUTNIK}/modules/org.llvm.irreader/src/org/llvm/irreader/impl

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.irreader/llvmToClangType ${LLVM_SRC}/llvm/lib/IRReader/IRReader.cpp "-nm=_Z20LLVMParseIRInContext;_ZL15getLazyIRModuleSt10unique_ptrIN4llvm12MemoryBufferESt14default_deleteIS1_EERNS0_12SMDiagnosticERNS0_11LLVMContextEb;_ZL17TimeIRParsingName;_ZL22TimeIRParsingGroupName;" -static-type=IRReaderStatics -package=org.llvm.irreader.impl > ${SPUTNIK}/modules/org.llvm.irreader/src/org/llvm/irreader/impl/IRReaderStatics.java

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.irreader/llvmToClangType ${LLVM_SRC}/llvm/lib/IRReader/IRReader.cpp "-nm=_ZN4llvm11parseIRFileENS_9StringRefERNS_12SMDiagnosticERNS_11LLVMContextE;_ZN4llvm19getLazyIRFileModuleENS_9StringRefERNS_12SMDiagnosticERNS_11LLVMContextEb;_ZN4llvm7parseIRENS_15MemoryBufferRefERNS_12SMDiagnosticERNS_11LLVMContextE;" -static-type=IrreaderLlvmGlobals -package=org.llvm.irreader > ${SPUTNIK}/modules/org.llvm.irreader/src/org/llvm/irreader/IrreaderLlvmGlobals.java

