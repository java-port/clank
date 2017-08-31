# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp "-nm=_ZN12_GLOBAL__N_119AssemblerInvocationE;" > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/AssemblerInvocation.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_Z12DriverSuffix;" > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/DriverSuffix.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_ZN12_GLOBAL__N_114StringSetSaverE;" > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/StringSetSaver.java

# Global and static namespaces

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp "-nm=_Z8cc1_mainN4llvm8ArrayRefIPKcEES2_Pv;_ZL16LLVMErrorHandlerPvRKSsb;" -static-type=cc1_mainStatics -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/cc1_mainStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp "-nm=_ZL15GetOutputStreamRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineEb;_ZL16ExecuteAssemblerRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineE;_ZL16LLVMErrorHandlerPvRKSsb;_Z10cc1as_mainN4llvm8ArrayRefIPKcEES2_Pv;" -static-type=cc1as_mainStatics -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/cc1as_mainStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_Z17GetExecutablePathPKcb;_ZL13GetStableCStrRSt3setISsSt4lessISsESaISsEEN4llvm9StringRefE;_ZL18ApplyOneQAOverrideRN4llvm11raw_ostreamERNS_15SmallVectorImplIPKcEENS_9StringRefERSt3setISsSt4lessISsESaISsEE;_ZL15ApplyQAOverrideRN4llvm15SmallVectorImplIPKcEES2_RSt3setISsSt4lessISsESaISsEE;_ZL16FindDriverSuffixN4llvm9StringRefE;_ZL13ParseProgNameRN4llvm15SmallVectorImplIPKcEERSt3setISsSt4lessISsESaISsEE;_ZL35SetBackdoorDriverOutputsFromEnvVarsRN5clang6driver6DriverE;_ZL22FixupDiagPrefixExeNamePN5clang21TextDiagnosticPrinterERKSs;_ZL25CreateAndPopulateDiagOptsRN4llvm15SmallVectorImplIPKcEE;_ZL13SetInstallDirRN4llvm15SmallVectorImplIPKcEERN5clang6driver6DriverE;_ZL14ExecuteCC1ToolN4llvm8ArrayRefIPKcEENS_9StringRefE;_Z4main;" -static-type=driverStatics -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/driverStatics.java

# Global functions/variables

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

