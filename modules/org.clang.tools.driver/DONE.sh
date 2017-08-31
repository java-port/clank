# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp "-nm=_ZN12_GLOBAL__N_119AssemblerInvocationE;" > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/AssemblerInvocation.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp "-nm=_Z8cc1_mainN4llvm8ArrayRefIPKcEES2_Pv;_ZL16LLVMErrorHandlerPvRKSsb;" -static-type=cc1_mainGlobals -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/cc1_mainGlobals.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1as_main.cpp "-nm=_Z10cc1as_mainN4llvm8ArrayRefIPKcEES2_Pv;_ZL15getOutputStreamRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineEb;_ZL16ExecuteAssemblerRN12_GLOBAL__N_119AssemblerInvocationERN5clang17DiagnosticsEngineE;_ZL16LLVMErrorHandlerPvRKSsb;" -static-type=cc1as_mainGlobals -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/cc1as_mainGlobals.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tools.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_Z17GetExecutablePathPKcb;_Z4main;_ZL13GetStableCStrRSt3setISsSt4lessISsESaISsEEN4llvm9StringRefE;_ZL13SetInstallDirRN4llvm15SmallVectorImplIPKcEERN5clang6driver6DriverEb;_ZL14ExecuteCC1ToolN4llvm8ArrayRefIPKcEENS_9StringRefE;_ZL15ApplyQAOverrideRN4llvm15SmallVectorImplIPKcEES2_RSt3setISsSt4lessISsESaISsEE;_ZL18ApplyOneQAOverrideRN4llvm11raw_ostreamERNS_15SmallVectorImplIPKcEENS_9StringRefERSt3setISsSt4lessISsESaISsEE;_ZL18getCLEnvVarOptionsRSsRN4llvm11StringSaverERNS0_15SmallVectorImplIPKcEE;_ZL22FixupDiagPrefixExeNamePN5clang21TextDiagnosticPrinterERKSs;_ZL23insertTargetAndModeArgsN4llvm9StringRefES0_RNS_15SmallVectorImplIPKcEERSt3setISsSt4lessISsESaISsEE;_ZL25CreateAndPopulateDiagOptsN4llvm8ArrayRefIPKcEE;_ZL35SetBackdoorDriverOutputsFromEnvVarsRN5clang6driver6DriverE;" -static-type=driverGlobals -package=org.clang.tools.driver > ${SPUTNIK}/modules/org.clang.tools.driver/src/org/clang/tools/driver/driverGlobals.java

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

