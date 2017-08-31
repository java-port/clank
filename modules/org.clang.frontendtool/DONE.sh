# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.frontendtool/src/org/clang/frontendtool
mkdir -p ${SPUTNIK}/modules/org.clang.frontendtool/src/org/clang/frontendtool/impl

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations

# Global and static namespaces

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp "-nm=_ZL20CreateFrontendActionRN5clang16CompilerInstanceE;_ZL24CreateFrontendBaseActionRN5clang16CompilerInstanceE;" -static-type=ExecuteCompilerInvocationStatics -package=org.clang.frontendtool.impl > ${SPUTNIK}/modules/org.clang.frontendtool/src/org/clang/frontendtool/impl/ExecuteCompilerInvocationStatics.java

# Global functions/variables

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontendtool/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/FrontendTool/ExecuteCompilerInvocation.cpp "-nm=_ZN5clang25ExecuteCompilerInvocationEPNS_16CompilerInstanceE;" -static-type=FrontendtoolClangGlobals -package=org.clang.frontendtool > ${SPUTNIK}/modules/org.clang.frontendtool/src/org/clang/frontendtool/FrontendtoolClangGlobals.java

# Static functions/variables for namespaces as packages

