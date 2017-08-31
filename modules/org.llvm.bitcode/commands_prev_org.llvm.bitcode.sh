# Used directories
mkdir -p ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode
mkdir -p ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/bitc

# Global and static Enums
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp "-nm=_ZN4llvm12BitcodeErrorE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitcodeError.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp "-nm=_ZN4llvm4bitc14BlockInfoCodesE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/bitc/BlockInfoCodes.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp "-nm=_ZN4llvm4bitc14FixedAbbrevIDsE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/bitc/FixedAbbrevIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp "-nm=_ZN4llvm4bitc16StandardBlockIDsE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/bitc/StandardBlockIDs.java
${SPUTNIK}/contrib/JConvert/jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp "-nm=_ZN4llvm4bitc14StandardWidthsE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/bitc/StandardWidths.java

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN4llvm13BitCodeAbbrevE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitCodeAbbrev.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN4llvm15BitCodeAbbrevOpE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitCodeAbbrevOp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp "-nm=_ZN4llvm21BitcodeDiagnosticInfoE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitcodeDiagnosticInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp "-nm=_ZN4llvm17BitcodeWriterPassE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitcodeWriterPass.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN4llvm15BitstreamCursorE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamCursor.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN4llvm14BitstreamEntryE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamEntry.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp "-nm=_ZN4llvm15BitstreamReaderE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamReader.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp "-nm=_ZN4llvm15BitstreamWriterE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/BitstreamWriter.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/ARCMigrate/ARCMT.cpp "-nm=_ZN4llvm9isPodLikeINS_15BitCodeAbbrevOpEEE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/isPodLikeBitCodeAbbrevOp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp "-nm=_ZSt18is_error_code_enumIN4llvm12BitcodeErrorEE;" > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/is_error_code_enumBitcodeError.java

# Global and static namespaces

# Static functions/variables

# Global functions/variables

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenAction.cpp "-nm=_ZN4llvm16isBitcodeWrapperEPKhS1_;_ZN4llvm12isRawBitcodeEPKhS1_;_ZN4llvm9isBitcodeEPKhS1_;_ZN4llvm24SkipBitcodeWrapperHeaderERPKhS2_b;_ZN4llvm15make_error_codeENS_12BitcodeErrorE;" -static-type=LlvmGlobals -package=org.llvm.bitcode > ${SPUTNIK}/modules/org.llvm.bitcode/src/org/llvm/bitcode/LlvmGlobals.java

# Static functions/variables for namespaces as packages

