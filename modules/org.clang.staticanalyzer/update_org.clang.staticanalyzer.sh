# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.staticanalyzer/src/org/clang/staticanalyzer/core

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/FrontendActions.cpp "-nm=_ZN5clang15AnalyzerOptionsE;" > ${SPUTNIK}/modules/org.clang.staticanalyzer/src/org/clang/staticanalyzer/core/AnalyzerOptions.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

