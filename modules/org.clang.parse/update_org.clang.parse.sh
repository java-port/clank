# Used directories
mkdir -p ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse
mkdir -p ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl

# Global and static Enums

# Global and static CXXRecords, ClassTemplates, ClassTemplateSpecializations
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseCXXInlineMethods.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseInit.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmtAsm.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN5clang6ParserE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/Parser.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN5clang24BalancedDelimiterTrackerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/BalancedDelimiterTracker.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp "-nm=_ZN12_GLOBAL__N_125CastExpressionIdValidatorE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/CastExpressionIdValidator.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN12_GLOBAL__N_135DestroyTemplateIdAnnotationsRAIIObjE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/DestroyTemplateIdAnnotationsRAIIObj.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN5clang19ExtensionRAIIObjectE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ExtensionRAIIObject.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN5clang21ParsingDeclRAIIObjectE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParsingDeclRAIIObject.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_120PragmaCommentHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaCommentHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_123PragmaFPContractHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaFPContractHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_126PragmaGCCVisibilityHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaGCCVisibilityHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_121PragmaLoopHintHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaLoopHintHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_118PragmaLoopHintInfoE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaLoopHintInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_125PragmaMSPointersToMembersE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaMSPointersToMembers.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_114PragmaMSPragmaE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaMSPragma.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_128PragmaMSRuntimeChecksHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaMSRuntimeChecksHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_121PragmaMSStructHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaMSStructHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_116PragmaMSVtorDispE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaMSVtorDisp.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_128PragmaOpenCLExtensionHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaOpenCLExtensionHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_119PragmaOpenMPHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaOpenMPHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_117PragmaPackHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaPackHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_114PragmaPackInfoE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaPackInfo.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_128PragmaRedefineExtnameHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaRedefineExtnameHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_123PragmaUnrollHintHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaUnrollHintHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZN12_GLOBAL__N_117PragmaWeakHandlerE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/PragmaWeakHandler.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp "-nm=_ZN12_GLOBAL__N_117ResetStackCleanupE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ResetStackCleanup.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseStmt.cpp "-nm=_ZN12_GLOBAL__N_118StatementFilterCCCE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/StatementFilterCCC.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/Parser.cpp "-nm=_ZN5clang20SuppressAccessChecksE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/SuppressAccessChecks.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTentative.cpp "-nm=_ZN12_GLOBAL__N_117TentativeParseCCCE;" > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/TentativeParseCCC.java

# Global and static namespaces

# Static functions/variables
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp "-nm=_ZL37diagnoseDynamicExceptionSpecificationRN5clang6ParserENS_11SourceRangeEb;_ZL33IsBuiltInOrStandardCXX11AttributePN5clang14IdentifierInfoES1_;" -static-type=ParseDeclCXXStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseDeclCXXStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDecl.cpp "-nm=_ZL21isAttributeLateParsedRKN5clang14IdentifierInfoE;_ZL17normalizeAttrNameN4llvm9StringRefE;_ZL25attributeHasIdentifierArgRKN5clang14IdentifierInfoE;_ZL22attributeIsTypeArgAttrRKN5clang14IdentifierInfoE;_ZL30attributeParsedArgsUnevaluatedRKN5clang14IdentifierInfoE;_ZL22VersionNumberSeparatorc;_ZL34isValidAfterIdentifierInDeclaratorRKN5clang5TokenE;_ZL18isPtrOperatorTokenN5clang3tok9TokenKindERKNS_11LangOptionsEj;_ZL16isPipeDecleratorRKN5clang10DeclaratorE;_ZL25getMissingDeclaratorIdLocRN5clang10DeclaratorENS_14SourceLocationE;" -static-type=ParseDeclStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseDeclStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExprCXX.cpp "-nm=_ZL25SelectDigraphErrorMessageN5clang3tok9TokenKindE;_ZL10FixDigraphRN5clang6ParserERNS_12PreprocessorERNS_5TokenES5_NS_3tok9TokenKindEb;_ZL20TypeTraitFromTokKindN5clang3tok9TokenKindE;_ZL25ArrayTypeTraitFromTokKindN5clang3tok9TokenKindE;_ZL26ExpressionTraitFromTokKindN5clang3tok9TokenKindE;_ZL14TypeTraitArityN5clang3tok9TokenKindE;" -static-type=ParseExprCXXStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseExprCXXStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp "-nm=_ZL34addContextSensitiveTypeNullabilityRN5clang6ParserERNS_10DeclaratorENS_15NullabilityKindENS_14SourceLocationERb;_ZL36diagnoseRedundantPropertyNullabilityRN5clang6ParserERNS_12ObjCDeclSpecENS_15NullabilityKindENS_14SourceLocationE;_ZL18takeDeclAttributesRN5clang16ParsedAttributesEPNS_13AttributeListE;_ZL18takeDeclAttributesRN5clang16ParsedAttributesERNS_10DeclaratorE;" -static-type=ParseObjcStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseObjcStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp "-nm=_ZL24ParseOpenMPDirectiveKindRN5clang6ParserE;_ZL16ParseReductionIdRN5clang6ParserERNS_12CXXScopeSpecERNS_13UnqualifiedIdE;" -static-type=ParseOpenMPStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseOpenMPStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp "-nm=_ZL20PragmaLoopHintStringN5clang5TokenES0_;_ZL16ParseAlignPragmaRN5clang12PreprocessorERNS_5TokenEb;_ZL18ParseLoopHintValueRN5clang12PreprocessorERNS_5TokenES2_S2_bRN12_GLOBAL__N_118PragmaLoopHintInfoE;" -static-type=ParsePragmaStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParsePragmaStatics.java
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp "-nm=_ZL23isEndOfTemplateArgumentN5clang5TokenE;" -static-type=ParseTemplateStatics > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/impl/ParseTemplateStatics.java

# Global functions/variables

# Global functions/variables for namespace as packages
${SPUTNIK}/contrib/JConvert/jclank.sh -empty-body -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseAST.cpp "-nm=_ZN5clang8ParseASTERNS_12PreprocessorEPNS_11ASTConsumerERNS_10ASTContextEbNS_19TranslationUnitKindEPNS_20CodeCompleteConsumerEb;_ZN5clang8ParseASTERNS_4SemaEbb;" -static-type=ClangGlobals > ${SPUTNIK}/modules/org.clang.parse/src/org/clang/parse/ClangGlobals.java

# Static functions/variables for namespaces as packages

# Unhandled removed symbols
#[CXXRecord,PragmaPackInfo,${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp:323,_Z14PragmaPackInfo]
#[CXXRecord,PragmaLoopHintInfo,${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp:739,_Z18PragmaLoopHintInfo]
#[Function,diagnoseDynamicExceptionSpecification,${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp:3218,_ZL37diagnoseDynamicExceptionSpecificationRN5clang6ParserERKNS_11SourceRangeEb]
#[Function,ParseLoopHintValue,${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParsePragma.cpp:1861,_ZL18ParseLoopHintValueRN5clang12PreprocessorERNS_5TokenES2_S2_bR18PragmaLoopHintInfo]


