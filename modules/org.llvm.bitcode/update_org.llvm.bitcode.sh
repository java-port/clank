# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_ZN4llvm13BitCodeAbbrevE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitCodeAbbrev.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_ZN4llvm15BitCodeAbbrevOpE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitCodeAbbrevOp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/TestModuleFileExtension.cpp "-nm=_ZN4llvm15BitstreamCursorE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamCursor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/InitPreprocessor.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/SerializedDiagnosticReader.cpp "-nm=_ZN4llvm15BitstreamReaderE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/driver.cpp "-nm=_ZN4llvm15BitstreamWriterE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamWriter.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables

# Global functions/variables for namespace as packages

# Static functions/variables for namespaces as packages

