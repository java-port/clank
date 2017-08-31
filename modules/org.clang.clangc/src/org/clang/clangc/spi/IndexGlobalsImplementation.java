/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.clangc.spi;

import org.clang.clangc.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.cl.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.IndexGlobals.*;
import org.clang.clangc.api.*;
import org.clang.clangc.api.buildsystem.*;
import org.clang.clangc.java.ClangCFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="static type IndexGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexHigh.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexInclusionStack.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXIndexDataConsumer.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXLoadedDiagnostic.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_CXCodeCompleteResults;_CXCompletionResult;_CXCursor;_CXEvalResultKind;_CXFileUniqueID;_CXGlobalOptFlags;_CXIdxAttrInfo;_CXIdxAttrKind;_CXIdxBaseClassInfo;_CXIdxCXXClassDeclInfo;_CXIdxContainerInfo;_CXIdxDeclInfo;_CXIdxDeclInfoFlags;_CXIdxEntityCXXTemplateKind;_CXIdxEntityInfo;_CXIdxEntityKind;_CXIdxEntityLanguage;_CXIdxEntityRefInfo;_CXIdxEntityRefKind;_CXIdxIBOutletCollectionAttrInfo;_CXIdxImportedASTFileInfo;_CXIdxIncludedFileInfo;_CXIdxLoc;_CXIdxObjCCategoryDeclInfo;_CXIdxObjCContainerDeclInfo;_CXIdxObjCContainerKind;_CXIdxObjCInterfaceDeclInfo;_CXIdxObjCPropertyDeclInfo;_CXIdxObjCProtocolRefInfo;_CXIdxObjCProtocolRefListInfo;_CXIndexOptFlags;_CXObjCDeclQualifierKind;_CXObjCPropertyAttrKind;_CXResult;_CXSourceLocation;_CXSourceRange;_CXSourceRangeList;_CXToken;_CXType;_IndexerCallbacks;_Z13clang_getFile;_Z14clang_getRange;_Z14clang_tokenize;_Z15clang_getCursor;_Z15clang_isInvalid;_Z15clang_isPODType;_Z16clang_equalTypes;_Z16clang_getArgType;_Z16clang_hashCursor;_Z17clang_createIndex;_Z17clang_equalRanges;_Z17clang_getFileName;_Z17clang_getFileTime;_Z17clang_getLocation;_Z17clang_getRangeEnd;_Z17clang_isAttribute;_Z17clang_isReference;_Z17clang_isStatement;_Z17clang_isUnexposed;_Z18clang_File_isEqual;_Z18clang_Range_isNull;_Z18clang_disposeIndex;_Z18clang_equalCursors;_Z18clang_getArraySize;_Z18clang_getCursorUSR;_Z18clang_getNullRange;_Z18clang_getTokenKind;_Z18clang_isExpression;_Z19clang_Cursor_isNull;_Z19clang_disposeTokens;_Z19clang_getCursorKind;_Z19clang_getCursorType;_Z19clang_getDiagnostic;_Z19clang_getInclusions;_Z19clang_getNullCursor;_Z19clang_getRangeStart;_Z19clang_getRemappings;_Z19clang_getResultType;_Z19clang_isDeclaration;_Z19clang_isVirtualBase;_Z19clang_remap_dispose;_Z19clang_visitChildren;_Z20clang_Module_getName;_Z20clang_Type_getSizeOf;_Z20clang_annotateTokens;_Z20clang_codeCompleteAt;_Z20clang_equalLocations;_Z20clang_getElementType;_Z20clang_getNumArgTypes;_Z20clang_getNumElements;_Z20clang_getPointeeType;_Z20clang_getTokenExtent;_Z21clang_Cursor_Evaluate;_Z21clang_Cursor_hasAttrs;_Z21clang_Module_isSystem;_Z21clang_Type_getAlignOf;_Z21clang_executeOnThread;_Z21clang_getClangVersion;_Z21clang_getCursorExtent;_Z21clang_getFileLocation;_Z21clang_getFileUniqueID;_Z21clang_getIncludedFile;_Z21clang_getNullLocation;_Z21clang_getTypeSpelling;_Z21clang_indexSourceFile;_Z21clang_isPreprocessing;_Z21clang_loadDiagnostics;_Z22clang_Cursor_getModule;_Z22clang_Module_getParent;_Z22clang_Type_getOffsetOf;_Z22clang_Type_visitFields;_Z22clang_formatDiagnostic;_Z22clang_getCanonicalType;_Z22clang_getCursorLinkage;_Z22clang_getModuleForFile;_Z22clang_getSkippedRanges;_Z22clang_getTokenLocation;_Z22clang_getTokenSpelling;_Z23clang_CXXMethod_isConst;_Z23clang_Cursor_isBitField;_Z23clang_Cursor_isVariadic;_Z23clang_Module_getASTFile;_Z23clang_Type_getClassType;_Z23clang_Type_getNamedType;_Z23clang_createCXCursorSet;_Z23clang_disposeDiagnostic;_Z23clang_enableStackTraces;_Z23clang_getCursorLanguage;_Z23clang_getCursorLocation;_Z23clang_getCursorSpelling;_Z23clang_getNumDiagnostics;_Z23clang_getOverloadedDecl;_Z23clang_isTranslationUnit;_Z23clang_remap_getNumFiles;_Z24clang_CXCursorSet_insert;_Z24clang_CXXField_isMutable;_Z24clang_CXXMethod_isStatic;_Z24clang_Cursor_getArgument;_Z24clang_Cursor_getMangling;_Z24clang_Cursor_isAnonymous;_Z24clang_EvalResult_dispose;_Z24clang_EvalResult_getKind;_Z24clang_IndexAction_create;_Z24clang_Module_getFullName;_Z24clang_defaultSaveOptions;_Z24clang_disposeCXCursorSet;_Z24clang_findIncludesInFile;_Z24clang_getCanonicalCursor;_Z24clang_getDiagnosticFixIt;_Z24clang_getDiagnosticInSet;_Z24clang_getDiagnosticRange;_Z24clang_getTypeDeclaration;_Z24clang_isCursorDefinition;_Z24clang_remap_getFilenames;_Z25clang_CXXMethod_isVirtual;_Z25clang_EvalResult_getAsInt;_Z25clang_EvalResult_getAsStr;_Z25clang_IndexAction_dispose;_Z25clang_getArrayElementType;_Z25clang_getChildDiagnostics;_Z25clang_getCompletionParent;_Z25clang_getCursorDefinition;_Z25clang_getCursorReferenced;_Z25clang_getCursorResultType;_Z25clang_getCursorVisibility;_Z25clang_getDiagnosticOption;_Z25clang_getPresumedLocation;_Z25clang_getSpellingLocation;_Z25clang_getTypeKindSpelling;_Z25clang_saveTranslationUnit;_Z25clang_toggleCrashRecovery;_Z26clang_CXCursorSet_contains;_Z26clang_Cursor_isDynamicCall;_Z26clang_Type_getObjCEncoding;_Z26clang_disposeDiagnosticSet;_Z26clang_findReferencesInFile;_Z26clang_getCXTUResourceUsage;_Z26clang_getCursorDisplayName;_Z26clang_getExpansionLocation;_Z26clang_getFieldDeclBitWidth;_Z26clang_getLocationForOffset;_Z26clang_getOverriddenCursors;_Z26clang_indexTranslationUnit;_Z26clang_isConstQualifiedType;_Z26clang_parseTranslationUnit;_Z27clang_CXXMethod_isDefaulted;_Z27clang_Cursor_isMacroBuiltin;_Z27clang_Cursor_isObjCOptional;_Z27clang_constructUSR_ObjCIvar;_Z27clang_createTranslationUnit;_Z27clang_defaultReparseOptions;_Z27clang_getCXXAccessSpecifier;_Z27clang_getCompletionPriority;_Z27clang_getCursorAvailability;_Z27clang_getCursorKindSpelling;_Z27clang_getDiagnosticCategory;_Z27clang_getDiagnosticLocation;_Z27clang_getDiagnosticSeverity;_Z27clang_getDiagnosticSpelling;_Z27clang_getNumOverloadedDecls;_Z27clang_getTemplateCursorKind;_Z27clang_index_getClientEntity;_Z27clang_index_setClientEntity;_Z27clang_parseTranslationUnit2;_Z28clang_Cursor_getCXXManglings;_Z28clang_Cursor_getCommentRange;_Z28clang_Cursor_getNumArguments;_Z28clang_Cursor_getReceiverType;_Z28clang_Cursor_getStorageClass;_Z28clang_EvalResult_getAsDouble;_Z28clang_constructUSR_ObjCClass;_Z28clang_createTranslationUnit2;_Z28clang_disposeSourceRangeList;_Z28clang_disposeTranslationUnit;_Z28clang_getCompletionChunkKind;_Z28clang_getCompletionChunkText;_Z28clang_getCursorLexicalParent;_Z28clang_getDiagnosticNumFixIts;_Z28clang_getDiagnosticNumRanges;_Z28clang_getDiagnosticSetFromTU;_Z28clang_getEnumDeclIntegerType;_Z28clang_getNumCompletionChunks;_Z28clang_getNumDiagnosticsInSet;_Z28clang_getTUResourceUsageName;_Z28clang_isFunctionTypeVariadic;_Z28clang_reparseTranslationUnit;_Z29clang_CXXMethod_isPureVirtual;_Z29clang_Cursor_getOffsetOfField;_Z29clang_Location_isFromMainFile;_Z29clang_Type_getCXXRefQualifier;_Z29clang_codeCompleteGetContexts;_Z29clang_constructUSR_ObjCMethod;_Z29clang_getCompletionAnnotation;_Z29clang_getCursorSemanticParent;_Z29clang_getDeclObjCTypeEncoding;_Z29clang_indexSourceFileFullArgv;_Z29clang_isRestrictQualifiedType;_Z29clang_isVolatileQualifiedType;_Z30clang_CXIndex_getGlobalOptions;_Z30clang_CXIndex_setGlobalOptions;_Z30clang_Cursor_getRawCommentText;_Z30clang_Cursor_isFunctionInlined;_Z30clang_Module_getTopLevelHeader;_Z30clang_disposeCXTUResourceUsage;_Z30clang_disposeOverriddenCursors;_Z30clang_getEnumConstantDeclValue;_Z30clang_getInstantiationLocation;_Z30clang_getTranslationUnitCursor;_Z30clang_indexLoc_getFileLocation;_Z30clang_index_getClientContainer;_Z30clang_index_setClientContainer;_Z31clang_Cursor_getTranslationUnit;_Z31clang_Location_isInSystemHeader;_Z31clang_codeCompleteGetDiagnostic;_Z31clang_constructUSR_ObjCCategory;_Z31clang_constructUSR_ObjCProperty;_Z31clang_constructUSR_ObjCProtocol;_Z31clang_getCompletionAvailability;_Z31clang_getCompletionBriefComment;_Z31clang_getCursorCompletionString;_Z31clang_getDiagnosticCategoryName;_Z31clang_getDiagnosticCategoryText;_Z31clang_getIBOutletCollectionType;_Z31clang_getRemappingsFromFileList;_Z31clang_index_getCXXClassDeclInfo;_Z31clang_sortCodeCompletionResults;_Z32clang_Cursor_getBriefCommentText;_Z32clang_Cursor_isMacroFunctionLike;_Z32clang_defaultCodeCompleteOptions;_Z32clang_disposeCodeCompleteResults;_Z32clang_getFunctionTypeCallingConv;_Z32clang_getTranslationUnitSpelling;_Z33clang_Cursor_getObjCSelectorIndex;_Z33clang_Cursor_getSpellingNameRange;_Z33clang_codeCompleteGetContainerUSR;_Z33clang_codeCompleteGetObjCSelector;_Z33clang_getCompletionNumAnnotations;_Z33clang_getCursorReferenceNameRange;_Z34clang_Cursor_getObjCDeclQualifiers;_Z34clang_Module_getNumTopLevelHeaders;_Z34clang_Type_getNumTemplateArguments;_Z34clang_codeCompleteGetContainerKind;_Z34clang_getSpecializedCursorTemplate;_Z34clang_getTypedefDeclUnderlyingType;_Z34clang_indexLoc_getCXSourceLocation;_Z34clang_isFileMultipleIncludeGuarded;_Z35clang_codeCompleteGetNumDiagnostics;_Z35clang_disposeCXPlatformAvailability;_Z35clang_getCursorPlatformAvailability;_Z35clang_index_getObjCCategoryDeclInfo;_Z35clang_index_getObjCPropertyDeclInfo;_Z35clang_parseTranslationUnit2FullArgv;_Z36clang_Cursor_getNumTemplateArguments;_Z36clang_Cursor_getTemplateArgumentKind;_Z36clang_Cursor_getTemplateArgumentType;_Z36clang_Type_getTemplateArgumentAsType;_Z36clang_getDefinitionSpellingAndExtent;_Z36clang_index_getObjCContainerDeclInfo;_Z36clang_index_getObjCInterfaceDeclInfo;_Z37clang_Cursor_getTemplateArgumentValue;_Z37clang_defaultDiagnosticDisplayOptions;_Z37clang_index_isEntityObjCContainerKind;_Z38clang_CXXConstructor_isCopyConstructor;_Z38clang_CXXConstructor_isMoveConstructor;_Z38clang_Cursor_getObjCPropertyAttributes;_Z38clang_getEnumConstantDeclUnsignedValue;_Z38clang_index_getObjCProtocolRefListInfo;_Z40clang_getCompletionChunkCompletionString;_Z41clang_CXXConstructor_isDefaultConstructor;_Z41clang_createTranslationUnitFromSourceFile;_Z41clang_index_getIBOutletCollectionAttrInfo;_Z42clang_defaultEditingTranslationUnitOptions;_Z44clang_CXXConstructor_isConvertingConstructor;_Z45clang_Cursor_getTemplateArgumentUnsignedValue; -static-type=IndexGlobals -package=org.clang.clangc")
//</editor-fold>
public interface IndexGlobalsImplementation {


/**
* \brief Provides a shared context for creating translation units.
*
* It provides two options:
*
* - excludeDeclarationsFromPCH: When non-zero, allows enumeration of "local"
* declarations (when loading any new translation units). A "local" declaration
* is one that belongs in the translation unit itself and not in a precompiled
* header that was used by the translation unit. If zero, all declarations
* will be enumerated.
*
* Here is an example:
*
* \code
*   // excludeDeclsFromPCH = 1, displayDiagnostics=1
*   Idx = clang_createIndex(1, 1);
*
*   // IndexTest.pch was produced with the following command:
*   // "clang -x c IndexTest.h -emit-ast -o IndexTest.pch"
*   TU = clang_createTranslationUnit(Idx, "IndexTest.pch");
*
*   // This will load all the symbols from 'IndexTest.pch'
*   clang_visitChildren(clang_getTranslationUnitCursor(TU),
*                       TranslationUnitVisitor, 0);
*   clang_disposeTranslationUnit(TU);
*
*   // This will load all the symbols from 'IndexTest.c', excluding symbols
*   // from 'IndexTest.pch'.
*   char *args[] = { "-Xclang", "-include-pch=IndexTest.pch" };
*   TU = clang_createTranslationUnitFromSourceFile(Idx, "IndexTest.c", 2, args,
*                                                  0, 0);
*   clang_visitChildren(clang_getTranslationUnitCursor(TU),
*                       TranslationUnitVisitor, 0);
*   clang_disposeTranslationUnit(TU);
* \endcode
*
* This process of creating the 'pch', loading it separately, and using it (via
* -include-pch) allows 'excludeDeclsFromPCH' to remove redundant callbacks
* (which gives the indexer the same performance benefit as the compiler).
*/

/**
* \brief Provides a shared context for creating translation units.
*
* It provides two options:
*
* - excludeDeclarationsFromPCH: When non-zero, allows enumeration of "local"
* declarations (when loading any new translation units). A "local" declaration
* is one that belongs in the translation unit itself and not in a precompiled
* header that was used by the translation unit. If zero, all declarations
* will be enumerated.
*
* Here is an example:
*
* \code
*   // excludeDeclsFromPCH = 1, displayDiagnostics=1
*   Idx = clang_createIndex(1, 1);
*
*   // IndexTest.pch was produced with the following command:
*   // "clang -x c IndexTest.h -emit-ast -o IndexTest.pch"
*   TU = clang_createTranslationUnit(Idx, "IndexTest.pch");
*
*   // This will load all the symbols from 'IndexTest.pch'
*   clang_visitChildren(clang_getTranslationUnitCursor(TU),
*                       TranslationUnitVisitor, 0);
*   clang_disposeTranslationUnit(TU);
*
*   // This will load all the symbols from 'IndexTest.c', excluding symbols
*   // from 'IndexTest.pch'.
*   char *args[] = { "-Xclang", "-include-pch=IndexTest.pch" };
*   TU = clang_createTranslationUnitFromSourceFile(Idx, "IndexTest.c", 2, args,
*                                                  0, 0);
*   clang_visitChildren(clang_getTranslationUnitCursor(TU),
*                       TranslationUnitVisitor, 0);
*   clang_disposeTranslationUnit(TU);
* \endcode
*
* This process of creating the 'pch', loading it separately, and using it (via
* -include-pch) allows 'excludeDeclsFromPCH' to remove redundant callbacks
* (which gives the indexer the same performance benefit as the compiler).
*/
//<editor-fold defaultstate="collapsed" desc="clang_createIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3057,
 FQN="clang_createIndex", NM="_Z17clang_createIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_createIndex")
//</editor-fold>
public /*static*/ default CXIndex clang_createIndex(int excludeDeclarationsFromPCH, 
                 int displayDiagnostics) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Destroy the given index.
*
* The index must not be destroyed until all of the translation units created
* within that index have been destroyed.
*/

/**
* \brief Destroy the given index.
*
* The index must not be destroyed until all of the translation units created
* within that index have been destroyed.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3092,
 FQN="clang_disposeIndex", NM="_Z18clang_disposeIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z18clang_disposeIndex")
//</editor-fold>
public /*static*/ default void clang_disposeIndex(CXIndex CIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Sets general options associated with a CXIndex.
*
* For example:
* \code
* CXIndex idx = ...;
* clang_CXIndex_setGlobalOptions(idx,
*     clang_CXIndex_getGlobalOptions(idx) |
*     CXGlobalOpt_ThreadBackgroundPriorityForIndexing);
* \endcode
*
* \param options A bitmask of options, a bitwise OR of CXGlobalOpt_XXX flags.
*/

/**
* \brief Sets general options associated with a CXIndex.
*
* For example:
* \code
* CXIndex idx = ...;
* clang_CXIndex_setGlobalOptions(idx,
*     clang_CXIndex_getGlobalOptions(idx) |
*     CXGlobalOpt_ThreadBackgroundPriorityForIndexing);
* \endcode
*
* \param options A bitmask of options, a bitwise OR of CXGlobalOpt_XXX flags.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXIndex_setGlobalOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3097,
 FQN="clang_CXIndex_setGlobalOptions", NM="_Z30clang_CXIndex_setGlobalOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_CXIndex_setGlobalOptions")
//</editor-fold>
public /*static*/ default void clang_CXIndex_setGlobalOptions(CXIndex CIdx, /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Gets the general options associated with a CXIndex.
*
* \returns A bitmask of options, a bitwise OR of CXGlobalOpt_XXX flags that
* are associated with the given CXIndex object.
*/

/**
* \brief Gets the general options associated with a CXIndex.
*
* \returns A bitmask of options, a bitwise OR of CXGlobalOpt_XXX flags that
* are associated with the given CXIndex object.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXIndex_getGlobalOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3102,
 FQN="clang_CXIndex_getGlobalOptions", NM="_Z30clang_CXIndex_getGlobalOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_CXIndex_getGlobalOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXIndex_getGlobalOptions(CXIndex CIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the complete file and path name of the given file.
*/

/**
* \brief Retrieve the complete file and path name of the given file.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFileName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3888,
 FQN="clang_getFileName", NM="_Z17clang_getFileName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_getFileName")
//</editor-fold>
public /*static*/ default  CXString clang_getFileName(CXFile SFile) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the last modification time of the given file.
*/

/**
* \brief Retrieve the last modification time of the given file.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFileTime">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3896,
 FQN="clang_getFileTime", NM="_Z17clang_getFileTime",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_getFileTime")
//</editor-fold>
public /*static*/ default long/*time_t*/ clang_getFileTime(CXFile SFile) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Retrieve the unique ID for the given \c file.
*
* \param file the file to get the ID for.
* \param outID stores the returned CXFileUniqueID.
* \returns If there was a failure getting the unique ID, returns non-zero,
* otherwise returns 0.
*/

/**
* \brief Retrieve the unique ID for the given \c file.
*
* \param file the file to get the ID for.
* \param outID stores the returned CXFileUniqueID.
* \returns If there was a failure getting the unique ID, returns non-zero,
* otherwise returns 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFileUniqueID">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3932,
 FQN="clang_getFileUniqueID", NM="_Z21clang_getFileUniqueID",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_getFileUniqueID")
//</editor-fold>
public /*static*/ default int clang_getFileUniqueID(CXFile file,  CXFileUniqueID /*P*/ outID) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given header is guarded against
* multiple inclusions, either with the conventional
* \#ifndef/\#define/\#endif macro guards or with \#pragma once.
*/

/**
* \brief Determine whether the given header is guarded against
* multiple inclusions, either with the conventional
* \#ifndef/\#define/\#endif macro guards or with \#pragma once.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isFileMultipleIncludeGuarded">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3916,
 FQN="clang_isFileMultipleIncludeGuarded", NM="_Z34clang_isFileMultipleIncludeGuarded",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z34clang_isFileMultipleIncludeGuarded")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isFileMultipleIncludeGuarded(CXTranslationUnit TU, 
                                  CXFile file) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a file handle within the given translation unit.
*
* \param tu the translation unit
*
* \param file_name the name of the file.
*
* \returns the file handle for the named file in the translation unit \p tu,
* or a NULL file handle if the file was not a part of this translation unit.
*/

/**
* \brief Retrieve a file handle within the given translation unit.
*
* \param tu the translation unit
*
* \param file_name the name of the file.
*
* \returns the file handle for the named file in the translation unit \p tu,
* or a NULL file handle if the file was not a part of this translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3904,
 FQN="clang_getFile", NM="_Z13clang_getFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z13clang_getFile")
//</editor-fold>
public /*static*/ default CXFile clang_getFile(CXTranslationUnit TU, /*const*/char$ptr/*char P*/ file_name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if the \c file1 and \c file2 point to the same file,
* or they are both NULL.
*/

/**
* \brief Returns non-zero if the \c file1 and \c file2 point to the same file,
* or they are both NULL.
*/
//<editor-fold defaultstate="collapsed" desc="clang_File_isEqual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3944,
 FQN="clang_File_isEqual", NM="_Z18clang_File_isEqual",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z18clang_File_isEqual")
//</editor-fold>
public /*static*/ default int clang_File_isEqual(CXFile file1, CXFile file2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_LOCATIONS Physical source locations
*
* Clang represents physical source locations in its abstract syntax tree in
* great detail, with file, line, and column information for the majority of
* the tokens parsed in the source code. These data types and functions are
* used to represent source location information, either for a particular
* point in the program or for a range of points in the program, and extract
* specific location information from those data types.
*
* @{
*/

/**
* \brief Retrieve a NULL (invalid) source location.
*/

/**
* \brief Retrieve a NULL (invalid) source location.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNullLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 43,
 FQN="clang_getNullLocation", NM="_Z21clang_getNullLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z21clang_getNullLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getNullLocation() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether two source locations, which must refer into
* the same translation unit, refer to exactly the same point in the source
* code.
*
* \returns non-zero if the source locations refer to the same location, zero
* if they refer to different locations.
*/

/**
* \brief Determine whether two source locations, which must refer into
* the same translation unit, refer to exactly the same point in the source
* code.
*
* \returns non-zero if the source locations refer to the same location, zero
* if they refer to different locations.
*/
//<editor-fold defaultstate="collapsed" desc="clang_equalLocations">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 48,
 FQN="clang_equalLocations", NM="_Z20clang_equalLocations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z20clang_equalLocations")
//</editor-fold>
public /*static*/ default /*uint*/int clang_equalLocations( CXSourceLocation loc1,  CXSourceLocation loc2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieves the source location associated with a given file/line/column
* in a particular translation unit.
*/

/**
* \brief Retrieves the source location associated with a given file/line/column
* in a particular translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 121,
 FQN="clang_getLocation", NM="_Z17clang_getLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z17clang_getLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getLocation(CXTranslationUnit TU, 
                 CXFile file, 
                 /*uint*/int line, 
                 /*uint*/int column) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Retrieves the source location associated with a given character offset
* in a particular translation unit.
*/
/**
* \brief Retrieves the source location associated with a given character offset
* in a particular translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getLocationForOffset">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 155,
 FQN="clang_getLocationForOffset", NM="_Z26clang_getLocationForOffset",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z26clang_getLocationForOffset")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getLocationForOffset(CXTranslationUnit TU, 
                          CXFile file, 
                          /*uint*/int offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if the given source location is in a system header.
*/

/**
* \brief Returns non-zero if the given source location is in a system header.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Location_isInSystemHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 209,
 FQN="clang_Location_isInSystemHeader", NM="_Z31clang_Location_isInSystemHeader",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z31clang_Location_isInSystemHeader")
//</editor-fold>
public /*static*/ default int clang_Location_isInSystemHeader( CXSourceLocation location) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if the given source location is in the main file of
* the corresponding translation unit.
*/

/**
* \brief Returns non-zero if the given source location is in the main file of
* the corresponding translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Location_isFromMainFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 220,
 FQN="clang_Location_isFromMainFile", NM="_Z29clang_Location_isFromMainFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z29clang_Location_isFromMainFile")
//</editor-fold>
public /*static*/ default int clang_Location_isFromMainFile( CXSourceLocation location) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a NULL (invalid) source range.
*/

/**
* \brief Retrieve a NULL (invalid) source range.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNullRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 54,
 FQN="clang_getNullRange", NM="_Z18clang_getNullRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z18clang_getNullRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getNullRange() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a source range given the beginning and ending source
* locations.
*/

/**
* \brief Retrieve a source range given the beginning and ending source
* locations.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 59,
 FQN="clang_getRange", NM="_Z14clang_getRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z14clang_getRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getRange( CXSourceLocation begin,  CXSourceLocation end) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether two ranges are equivalent.
*
* \returns non-zero if the ranges are the same, zero if they differ.
*/

/**
* \brief Determine whether two ranges are equivalent.
*
* \returns non-zero if the ranges are the same, zero if they differ.
*/
//<editor-fold defaultstate="collapsed" desc="clang_equalRanges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 77,
 FQN="clang_equalRanges", NM="_Z17clang_equalRanges",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z17clang_equalRanges")
//</editor-fold>
public /*static*/ default /*uint*/int clang_equalRanges( CXSourceRange range1,  CXSourceRange range2) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if \p range is null.
*/

/**
* \brief Returns non-zero if \p range is null.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Range_isNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 84,
 FQN="clang_Range_isNull", NM="_Z18clang_Range_isNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z18clang_Range_isNull")
//</editor-fold>
public /*static*/ default int clang_Range_isNull( CXSourceRange range) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro expansion, retrieves the
* location of the macro expansion.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/

/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro expansion, retrieves the
* location of the macro expansion.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getExpansionLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 231,
 FQN="clang_getExpansionLocation", NM="_Z26clang_getExpansionLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z26clang_getExpansionLocation")
//</editor-fold>
public /*static*/ default void clang_getExpansionLocation( CXSourceLocation location, 
                          CXFile/*P*/ file, 
                          uint$ptr/*uint P*/ line, 
                          uint$ptr/*uint P*/ column, 
                          uint$ptr/*uint P*/ offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location, as specified in a # line directive.
*
* Example: given the following source code in a file somefile.c
*
* \code
* #123 "dummy.c" 1
*
* static int func(void)
* {
*     return 0;
* }
* \endcode
*
* the location information returned by this function would be
*
* File: dummy.c Line: 124 Column: 12
*
* whereas clang_getExpansionLocation would have returned
*
* File: somefile.c Line: 3 Column: 12
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param filename [out] if non-NULL, will be set to the filename of the
* source location. Note that filenames returned will be for "virtual" files,
* which don't necessarily exist on the machine running clang - e.g. when
* parsing preprocessed output obtained from a different environment. If
* a non-NULL value is passed in, remember to dispose of the returned value
* using \c clang_disposeString() once you've finished with it. For an invalid
* source location, an empty string is returned.
*
* \param line [out] if non-NULL, will be set to the line number of the
* source location. For an invalid source location, zero is returned.
*
* \param column [out] if non-NULL, will be set to the column number of the
* source location. For an invalid source location, zero is returned.
*/

/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location, as specified in a # line directive.
*
* Example: given the following source code in a file somefile.c
*
* \code
* #123 "dummy.c" 1
*
* static int func(void)
* {
*     return 0;
* }
* \endcode
*
* the location information returned by this function would be
*
* File: dummy.c Line: 124 Column: 12
*
* whereas clang_getExpansionLocation would have returned
*
* File: somefile.c Line: 3 Column: 12
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param filename [out] if non-NULL, will be set to the filename of the
* source location. Note that filenames returned will be for "virtual" files,
* which don't necessarily exist on the machine running clang - e.g. when
* parsing preprocessed output obtained from a different environment. If
* a non-NULL value is passed in, remember to dispose of the returned value
* using \c clang_disposeString() once you've finished with it. For an invalid
* source location, an empty string is returned.
*
* \param line [out] if non-NULL, will be set to the line number of the
* source location. For an invalid source location, zero is returned.
*
* \param column [out] if non-NULL, will be set to the column number of the
* source location. For an invalid source location, zero is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getPresumedLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 272,
 FQN="clang_getPresumedLocation", NM="_Z25clang_getPresumedLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z25clang_getPresumedLocation")
//</editor-fold>
public /*static*/ default void clang_getPresumedLocation( CXSourceLocation location, 
                          type$ptr<CXString> filename, 
                         uint$ptr/*uint P*/ line, 
                         uint$ptr/*uint P*/ column) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Legacy API to retrieve the file, line, column, and offset represented
* by the given source location.
*
* This interface has been replaced by the newer interface
* #clang_getExpansionLocation(). See that interface's documentation for
* details.
*/

/**
* \brief Legacy API to retrieve the file, line, column, and offset represented
* by the given source location.
*
* This interface has been replaced by the newer interface
* #clang_getExpansionLocation(). See that interface's documentation for
* details.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getInstantiationLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 303,
 FQN="clang_getInstantiationLocation", NM="_Z30clang_getInstantiationLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z30clang_getInstantiationLocation")
//</editor-fold>
public /*static*/ default void clang_getInstantiationLocation( CXSourceLocation location, 
                              CXFile/*P*/ file, 
                              uint$ptr/*uint P*/ line, 
                              uint$ptr/*uint P*/ column, 
                              uint$ptr/*uint P*/ offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro instantiation, return where the
* location was originally spelled in the source file.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/

/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro instantiation, return where the
* location was originally spelled in the source file.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getSpellingLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 312,
 FQN="clang_getSpellingLocation", NM="_Z25clang_getSpellingLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z25clang_getSpellingLocation")
//</editor-fold>
public /*static*/ default void clang_getSpellingLocation( CXSourceLocation location, 
                         CXFile/*P*/ file, 
                         uint$ptr/*uint P*/ line, 
                         uint$ptr/*uint P*/ column, 
                         uint$ptr/*uint P*/ offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro expansion, return where the macro was
* expanded or where the macro argument was written, if the location points at
* a macro argument.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/

/**
* \brief Retrieve the file, line, column, and offset represented by
* the given source location.
*
* If the location refers into a macro expansion, return where the macro was
* expanded or where the macro argument was written, if the location points at
* a macro argument.
*
* \param location the location within a source file that will be decomposed
* into its parts.
*
* \param file [out] if non-NULL, will be set to the file to which the given
* source location points.
*
* \param line [out] if non-NULL, will be set to the line to which the given
* source location points.
*
* \param column [out] if non-NULL, will be set to the column to which the given
* source location points.
*
* \param offset [out] if non-NULL, will be set to the offset into the
* buffer to which the given source location points.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFileLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 349,
 FQN="clang_getFileLocation", NM="_Z21clang_getFileLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z21clang_getFileLocation")
//</editor-fold>
public /*static*/ default void clang_getFileLocation( CXSourceLocation location, 
                     CXFile/*P*/ file, 
                     uint$ptr/*uint P*/ line, 
                     uint$ptr/*uint P*/ column, 
                     uint$ptr/*uint P*/ offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a source location representing the first character within a
* source range.
*/

/**
* \brief Retrieve a source location representing the first character within a
* source range.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getRangeStart">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 89,
 FQN="clang_getRangeStart", NM="_Z19clang_getRangeStart",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z19clang_getRangeStart")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getRangeStart( CXSourceRange range) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a source location representing the last character within a
* source range.
*/

/**
* \brief Retrieve a source location representing the last character within a
* source range.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getRangeEnd">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp", line = 101,
 FQN="clang_getRangeEnd", NM="_Z17clang_getRangeEnd",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXSourceLocation.cpp -nm=_Z17clang_getRangeEnd")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getRangeEnd( CXSourceRange range) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Retrieve all ranges that were skipped by the preprocessor.
*
* The preprocessor will skip lines when they are surrounded by an
* if/ifdef/ifndef directive whose condition does not evaluate to true.
*/

/**
* \brief Retrieve all ranges that were skipped by the preprocessor.
*
* The preprocessor will skip lines when they are surrounded by an
* if/ifdef/ifndef directive whose condition does not evaluate to true.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getSkippedRanges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7719,
 FQN="clang_getSkippedRanges", NM="_Z22clang_getSkippedRanges",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_getSkippedRanges")
//</editor-fold>
public /*static*/ default  CXSourceRangeList /*P*/ clang_getSkippedRanges(CXTranslationUnit TU, CXFile file) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Destroy the given \c CXSourceRangeList.
*/

/**
* \brief Destroy the given \c CXSourceRangeList.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeSourceRangeList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7758,
 FQN="clang_disposeSourceRangeList", NM="_Z28clang_disposeSourceRangeList",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_disposeSourceRangeList")
//</editor-fold>
public /*static*/ default void clang_disposeSourceRangeList( CXSourceRangeList /*P*/ ranges) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of diagnostics in a CXDiagnosticSet.
*/

/**
* \brief Determine the number of diagnostics in a CXDiagnosticSet.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumDiagnosticsInSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 477,
 FQN="clang_getNumDiagnosticsInSet", NM="_Z28clang_getNumDiagnosticsInSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z28clang_getNumDiagnosticsInSet")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getNumDiagnosticsInSet(CXDiagnosticSet Diags) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a diagnostic associated with the given CXDiagnosticSet.
*
* \param Diags the CXDiagnosticSet to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/

/**
* \brief Retrieve a diagnostic associated with the given CXDiagnosticSet.
*
* \param Diags the CXDiagnosticSet to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticInSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 461,
 FQN="clang_getDiagnosticInSet", NM="_Z24clang_getDiagnosticInSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z24clang_getDiagnosticInSet")
//</editor-fold>
public /*static*/ default CXDiagnostic clang_getDiagnosticInSet(CXDiagnosticSet Diags, 
                        /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Deserialize a set of diagnostics from a Clang diagnostics bitcode
* file.
*
* \param file The name of the file to deserialize.
* \param error A pointer to a enum value recording if there was a problem
*        deserializing the diagnostics.
* \param errorString A pointer to a CXString for recording the error string
*        if the file was not successfully loaded.
*
* \returns A loaded CXDiagnosticSet if successful, and NULL otherwise.  These
* diagnostics should be released using clang_disposeDiagnosticSet().
*/

/**
* \brief Deserialize a set of diagnostics from a Clang diagnostics bitcode
* file.
*
* \param file The name of the file to deserialize.
* \param error A pointer to a enum value recording if there was a problem
*        deserializing the diagnostics.
* \param errorString A pointer to a CXString for recording the error string
*        if the file was not successfully loaded.
*
* \returns A loaded CXDiagnosticSet if successful, and NULL otherwise.  These
* diagnostics should be released using clang_disposeDiagnosticSet().
*/
//<editor-fold defaultstate="collapsed" desc="clang_loadDiagnostics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXLoadedDiagnostic.cpp", line = 393,
 FQN="clang_loadDiagnostics", NM="_Z21clang_loadDiagnostics",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXLoadedDiagnostic.cpp -nm=_Z21clang_loadDiagnostics")
//</editor-fold>
public /*static*/ default CXDiagnosticSet clang_loadDiagnostics(/*const*/char$ptr/*char P*/ file, 
                      CXLoadDiag_Error /*P*/ error, 
                      type$ptr<CXString> errorString) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Release a CXDiagnosticSet and all of its contained diagnostics.
*/

/**
* \brief Release a CXDiagnosticSet and all of its contained diagnostics.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeDiagnosticSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 454,
 FQN="clang_disposeDiagnosticSet", NM="_Z26clang_disposeDiagnosticSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z26clang_disposeDiagnosticSet")
//</editor-fold>
public /*static*/ default void clang_disposeDiagnosticSet(CXDiagnosticSet Diags) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the child diagnostics of a CXDiagnostic. 
*
* This CXDiagnosticSet does not need to be released by
* clang_disposeDiagnosticSet.
*/

/**
* \brief Retrieve the child diagnostics of a CXDiagnostic. 
*
* This CXDiagnosticSet does not need to be released by
* clang_disposeDiagnosticSet.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getChildDiagnostics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 469,
 FQN="clang_getChildDiagnostics", NM="_Z25clang_getChildDiagnostics",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z25clang_getChildDiagnostics")
//</editor-fold>
public /*static*/ default CXDiagnosticSet clang_getChildDiagnostics(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of diagnostics produced for the given
* translation unit.
*/

/**
* \brief Determine the number of diagnostics produced for the given
* translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumDiagnostics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 212,
 FQN="clang_getNumDiagnostics", NM="_Z23clang_getNumDiagnostics",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z23clang_getNumDiagnostics")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getNumDiagnostics(CXTranslationUnit Unit) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a diagnostic associated with the given translation unit.
*
* \param Unit the translation unit to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/

/**
* \brief Retrieve a diagnostic associated with the given translation unit.
*
* \param Unit the translation unit to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnostic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 222,
 FQN="clang_getDiagnostic", NM="_Z19clang_getDiagnostic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z19clang_getDiagnostic")
//</editor-fold>
public /*static*/ default CXDiagnostic clang_getDiagnostic(CXTranslationUnit Unit, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the complete set of diagnostics associated with a
*        translation unit.
*
* \param Unit the translation unit to query.
*/

/**
* \brief Retrieve the complete set of diagnostics associated with a
*        translation unit.
*
* \param Unit the translation unit to query.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticSetFromTU">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 239,
 FQN="clang_getDiagnosticSetFromTU", NM="_Z28clang_getDiagnosticSetFromTU",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z28clang_getDiagnosticSetFromTU")
//</editor-fold>
public /*static*/ default CXDiagnosticSet clang_getDiagnosticSetFromTU(CXTranslationUnit Unit) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Destroy a diagnostic.
*/

/**
* \brief Destroy a diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeDiagnostic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 249,
 FQN="clang_disposeDiagnostic", NM="_Z23clang_disposeDiagnostic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z23clang_disposeDiagnostic")
//</editor-fold>
public /*static*/ default void clang_disposeDiagnostic(CXDiagnostic Diagnostic) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Format the given diagnostic in a manner that is suitable for display.
*
* This routine will format the given diagnostic to a string, rendering
* the diagnostic according to the various options given. The
* \c clang_defaultDiagnosticDisplayOptions() function returns the set of
* options that most closely mimics the behavior of the clang compiler.
*
* \param Diagnostic The diagnostic to print.
*
* \param Options A set of options that control the diagnostic display,
* created by combining \c CXDiagnosticDisplayOptions values.
*
* \returns A new string containing for formatted diagnostic.
*/

/**
* \brief Format the given diagnostic in a manner that is suitable for display.
*
* This routine will format the given diagnostic to a string, rendering
* the diagnostic according to the various options given. The
* \c clang_defaultDiagnosticDisplayOptions() function returns the set of
* options that most closely mimics the behavior of the clang compiler.
*
* \param Diagnostic The diagnostic to print.
*
* \param Options A set of options that control the diagnostic display,
* created by combining \c CXDiagnosticDisplayOptions values.
*
* \returns A new string containing for formatted diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_formatDiagnostic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 254,
 FQN="clang_formatDiagnostic", NM="_Z22clang_formatDiagnostic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z22clang_formatDiagnostic")
//</editor-fold>
public /*static*/ default  CXString clang_formatDiagnostic(CXDiagnostic Diagnostic, /*uint*/int Options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the set of display options most similar to the
* default behavior of the clang compiler.
*
* \returns A set of display options suitable for use with \c
* clang_formatDiagnostic().
*/

/**
* \brief Retrieve the set of display options most similar to the
* default behavior of the clang compiler.
*
* \returns A set of display options suitable for use with \c
* clang_formatDiagnostic().
*/
//<editor-fold defaultstate="collapsed" desc="clang_defaultDiagnosticDisplayOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 374,
 FQN="clang_defaultDiagnosticDisplayOptions", NM="_Z37clang_defaultDiagnosticDisplayOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z37clang_defaultDiagnosticDisplayOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_defaultDiagnosticDisplayOptions() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the severity of the given diagnostic.
*/

/**
* \brief Determine the severity of the given diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticSeverity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 379,
 FQN="clang_getDiagnosticSeverity", NM="_Z27clang_getDiagnosticSeverity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z27clang_getDiagnosticSeverity")
//</editor-fold>
public /*static*/ default  CXDiagnosticSeverity clang_getDiagnosticSeverity(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the source location of the given diagnostic.
*
* This location is where Clang would print the caret ('^') when
* displaying the diagnostic on the command line.
*/

/**
* \brief Retrieve the source location of the given diagnostic.
*
* This location is where Clang would print the caret ('^') when
* displaying the diagnostic on the command line.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 385,
 FQN="clang_getDiagnosticLocation", NM="_Z27clang_getDiagnosticLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z27clang_getDiagnosticLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getDiagnosticLocation(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the text of the given diagnostic.
*/

/**
* \brief Retrieve the text of the given diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 391,
 FQN="clang_getDiagnosticSpelling", NM="_Z27clang_getDiagnosticSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z27clang_getDiagnosticSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getDiagnosticSpelling(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the name of the command-line option that enabled this
* diagnostic.
*
* \param Diag The diagnostic to be queried.
*
* \param Disable If non-NULL, will be set to the option that disables this
* diagnostic (if any).
*
* \returns A string that contains the command-line option used to enable this
* warning, such as "-Wconversion" or "-pedantic". 
*/

/**
* \brief Retrieve the name of the command-line option that enabled this
* diagnostic.
*
* \param Diag The diagnostic to be queried.
*
* \param Disable If non-NULL, will be set to the option that disables this
* diagnostic (if any).
*
* \returns A string that contains the command-line option used to enable this
* warning, such as "-Wconversion" or "-pedantic". 
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticOption">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 397,
 FQN="clang_getDiagnosticOption", NM="_Z25clang_getDiagnosticOption",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z25clang_getDiagnosticOption")
//</editor-fold>
public /*static*/ default  CXString clang_getDiagnosticOption(CXDiagnostic Diag,  type$ptr<CXString> Disable) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the category number for this diagnostic.
*
* Diagnostics can be categorized into groups along with other, related
* diagnostics (e.g., diagnostics under the same warning flag). This routine 
* retrieves the category number for the given diagnostic.
*
* \returns The number of the category that contains this diagnostic, or zero
* if this diagnostic is uncategorized.
*/

/**
* \brief Retrieve the category number for this diagnostic.
*
* Diagnostics can be categorized into groups along with other, related
* diagnostics (e.g., diagnostics under the same warning flag). This routine 
* retrieves the category number for the given diagnostic.
*
* \returns The number of the category that contains this diagnostic, or zero
* if this diagnostic is uncategorized.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticCategory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 407,
 FQN="clang_getDiagnosticCategory", NM="_Z27clang_getDiagnosticCategory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z27clang_getDiagnosticCategory")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getDiagnosticCategory(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the name of a particular diagnostic category.  This
*  is now deprecated.  Use clang_getDiagnosticCategoryText()
*  instead.
*
* \param Category A diagnostic category number, as returned by 
* \c clang_getDiagnosticCategory().
*
* \returns The name of the given diagnostic category.
*/

/**
* \brief Retrieve the name of a particular diagnostic category.  This
*  is now deprecated.  Use clang_getDiagnosticCategoryText()
*  instead.
*
* \param Category A diagnostic category number, as returned by 
* \c clang_getDiagnosticCategory().
*
* \returns The name of the given diagnostic category.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticCategoryName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 413,
 FQN="clang_getDiagnosticCategoryName", NM="_Z31clang_getDiagnosticCategoryName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z31clang_getDiagnosticCategoryName")
//</editor-fold>
public /*static*/ default  CXString clang_getDiagnosticCategoryName(/*uint*/int Category)/* __attribute__((deprecated("")))*/ {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the diagnostic category text for a given diagnostic.
*
* \returns The text of the given diagnostic category.
*/

/**
* \brief Retrieve the diagnostic category text for a given diagnostic.
*
* \returns The text of the given diagnostic category.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticCategoryText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 418,
 FQN="clang_getDiagnosticCategoryText", NM="_Z31clang_getDiagnosticCategoryText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z31clang_getDiagnosticCategoryText")
//</editor-fold>
public /*static*/ default  CXString clang_getDiagnosticCategoryText(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of source ranges associated with the given
* diagnostic.
*/

/**
* \brief Determine the number of source ranges associated with the given
* diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticNumRanges">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 424,
 FQN="clang_getDiagnosticNumRanges", NM="_Z28clang_getDiagnosticNumRanges",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z28clang_getDiagnosticNumRanges")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getDiagnosticNumRanges(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a source range associated with the diagnostic.
*
* A diagnostic's source ranges highlight important elements in the source
* code. On the command line, Clang displays source ranges by
* underlining them with '~' characters.
*
* \param Diagnostic the diagnostic whose range is being extracted.
*
* \param Range the zero-based index specifying which range to
*
* \returns the requested source range.
*/

/**
* \brief Retrieve a source range associated with the diagnostic.
*
* A diagnostic's source ranges highlight important elements in the source
* code. On the command line, Clang displays source ranges by
* underlining them with '~' characters.
*
* \param Diagnostic the diagnostic whose range is being extracted.
*
* \param Range the zero-based index specifying which range to
*
* \returns the requested source range.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 430,
 FQN="clang_getDiagnosticRange", NM="_Z24clang_getDiagnosticRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z24clang_getDiagnosticRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getDiagnosticRange(CXDiagnostic Diag, /*uint*/int Range) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of fix-it hints associated with the
* given diagnostic.
*/

/**
* \brief Determine the number of fix-it hints associated with the
* given diagnostic.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticNumFixIts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 437,
 FQN="clang_getDiagnosticNumFixIts", NM="_Z28clang_getDiagnosticNumFixIts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z28clang_getDiagnosticNumFixIts")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getDiagnosticNumFixIts(CXDiagnostic Diag) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the replacement information for a given fix-it.
*
* Fix-its are described in terms of a source range whose contents
* should be replaced by a string. This approach generalizes over
* three kinds of operations: removal of source code (the range covers
* the code to be removed and the replacement string is empty),
* replacement of source code (the range covers the code to be
* replaced and the replacement string provides the new code), and
* insertion (both the start and end of the range point at the
* insertion location, and the replacement string provides the text to
* insert).
*
* \param Diagnostic The diagnostic whose fix-its are being queried.
*
* \param FixIt The zero-based index of the fix-it.
*
* \param ReplacementRange The source range whose contents will be
* replaced with the returned replacement string. Note that source
* ranges are half-open ranges [a, b), so the source code should be
* replaced from a and up to (but not including) b.
*
* \returns A string containing text that should be replace the source
* code indicated by the \c ReplacementRange.
*/

/**
* \brief Retrieve the replacement information for a given fix-it.
*
* Fix-its are described in terms of a source range whose contents
* should be replaced by a string. This approach generalizes over
* three kinds of operations: removal of source code (the range covers
* the code to be removed and the replacement string is empty),
* replacement of source code (the range covers the code to be
* replaced and the replacement string provides the new code), and
* insertion (both the start and end of the range point at the
* insertion location, and the replacement string provides the text to
* insert).
*
* \param Diagnostic The diagnostic whose fix-its are being queried.
*
* \param FixIt The zero-based index of the fix-it.
*
* \param ReplacementRange The source range whose contents will be
* replaced with the returned replacement string. Note that source
* ranges are half-open ranges [a, b), so the source code should be
* replaced from a and up to (but not including) b.
*
* \returns A string containing text that should be replace the source
* code indicated by the \c ReplacementRange.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDiagnosticFixIt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp", line = 443,
 FQN="clang_getDiagnosticFixIt", NM="_Z24clang_getDiagnosticFixIt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexDiagnostic.cpp -nm=_Z24clang_getDiagnosticFixIt")
//</editor-fold>
public /*static*/ default  CXString clang_getDiagnosticFixIt(CXDiagnostic Diag, /*uint*/int FixIt, 
                         CXSourceRange /*P*/ ReplacementRange) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_TRANSLATION_UNIT Translation unit manipulation
*
* The routines in this group provide the ability to create and destroy
* translation units from files, either by parsing the contents of the files or
* by reading in a serialized representation of a translation unit.
*
* @{
*/

/**
* \brief Get the original translation unit source file name.
*/

/**
* @}
*/

/**
* \defgroup CINDEX_TRANSLATION_UNIT Translation unit manipulation
*
* The routines in this group provide the ability to create and destroy
* translation units from files, either by parsing the contents of the files or
* by reading in a serialized representation of a translation unit.
*
* @{
*/

/**
* \brief Get the original translation unit source file name.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTranslationUnitSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3861,
 FQN="clang_getTranslationUnitSpelling", NM="_Z32clang_getTranslationUnitSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z32clang_getTranslationUnitSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getTranslationUnitSpelling(CXTranslationUnit CTUnit) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the CXTranslationUnit for a given source file and the provided
* command line arguments one would pass to the compiler.
*
* Note: The 'source_filename' argument is optional.  If the caller provides a
* NULL pointer, the name of the source file is expected to reside in the
* specified command line arguments.
*
* Note: When encountered in 'clang_command_line_args', the following options
* are ignored:
*
*   '-c'
*   '-emit-ast'
*   '-fsyntax-only'
*   '-o \<output file>'  (both '-o' and '\<output file>' are ignored)
*
* \param CIdx The index object with which the translation unit will be
* associated.
*
* \param source_filename The name of the source file to load, or NULL if the
* source file is included in \p clang_command_line_args.
*
* \param num_clang_command_line_args The number of command-line arguments in
* \p clang_command_line_args.
*
* \param clang_command_line_args The command-line arguments that would be
* passed to the \c clang executable if it were being invoked out-of-process.
* These command-line options will be parsed and will affect how the translation
* unit is parsed. Note that the following options are ignored: '-c',
* '-emit-ast', '-fsyntax-only' (which is the default), and '-o \<output file>'.
*
* \param num_unsaved_files the number of unsaved file entries in \p
* unsaved_files.
*
* \param unsaved_files the files that have not yet been saved to disk
* but may be required for code completion, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
*/

/**
* \brief Return the CXTranslationUnit for a given source file and the provided
* command line arguments one would pass to the compiler.
*
* Note: The 'source_filename' argument is optional.  If the caller provides a
* NULL pointer, the name of the source file is expected to reside in the
* specified command line arguments.
*
* Note: When encountered in 'clang_command_line_args', the following options
* are ignored:
*
*   '-c'
*   '-emit-ast'
*   '-fsyntax-only'
*   '-o \<output file>'  (both '-o' and '\<output file>' are ignored)
*
* \param CIdx The index object with which the translation unit will be
* associated.
*
* \param source_filename The name of the source file to load, or NULL if the
* source file is included in \p clang_command_line_args.
*
* \param num_clang_command_line_args The number of command-line arguments in
* \p clang_command_line_args.
*
* \param clang_command_line_args The command-line arguments that would be
* passed to the \c clang executable if it were being invoked out-of-process.
* These command-line options will be parsed and will affect how the translation
* unit is parsed. Note that the following options are ignored: '-c',
* '-emit-ast', '-fsyntax-only' (which is the default), and '-o \<output file>'.
*
* \param num_unsaved_files the number of unsaved file entries in \p
* unsaved_files.
*
* \param unsaved_files the files that have not yet been saved to disk
* but may be required for code completion, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
*/
//<editor-fold defaultstate="collapsed" desc="clang_createTranslationUnitFromSourceFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3160,
 FQN="clang_createTranslationUnitFromSourceFile", NM="_Z41clang_createTranslationUnitFromSourceFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z41clang_createTranslationUnitFromSourceFile")
//</editor-fold>
public /*static*/ default CXTranslationUnit clang_createTranslationUnitFromSourceFile(CXIndex CIdx, 
                                         /*const*/char$ptr/*char P*/ source_filename, 
                                         int num_command_line_args, 
                                         /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, 
                                         /*uint*/int num_unsaved_files, 
                                          CXUnsavedFile /*P*/ unsaved_files) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Same as \c clang_createTranslationUnit2, but returns
* the \c CXTranslationUnit instead of an error code.  In case of an error this
* routine returns a \c NULL \c CXTranslationUnit, without further detailed
* error codes.
*/

/**
* \brief Same as \c clang_createTranslationUnit2, but returns
* the \c CXTranslationUnit instead of an error code.  In case of an error this
* routine returns a \c NULL \c CXTranslationUnit, without further detailed
* error codes.
*/
//<editor-fold defaultstate="collapsed" desc="clang_createTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3115,
 FQN="clang_createTranslationUnit", NM="_Z27clang_createTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_createTranslationUnit")
//</editor-fold>
public /*static*/ default CXTranslationUnit clang_createTranslationUnit(CXIndex CIdx, 
                           /*const*/char$ptr/*char P*/ ast_filename) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Create a translation unit from an AST file (\c -emit-ast).
*
* \param[out] out_TU A non-NULL pointer to store the created
* \c CXTranslationUnit.
*
* \returns Zero on success, otherwise returns an error code.
*/

/**
* \brief Create a translation unit from an AST file (\c -emit-ast).
*
* \param[out] out_TU A non-NULL pointer to store the created
* \c CXTranslationUnit.
*
* \returns Zero on success, otherwise returns an error code.
*/
//<editor-fold defaultstate="collapsed" desc="clang_createTranslationUnit2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3126,
 FQN="clang_createTranslationUnit2", NM="_Z28clang_createTranslationUnit2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_createTranslationUnit2")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_createTranslationUnit2(CXIndex CIdx, 
                            /*const*/char$ptr/*char P*/ ast_filename, 
                            CXTranslationUnit/*P*/ out_TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the set of flags that is suitable for parsing a translation
* unit that is being edited.
*
* The set of flags returned provide options for \c clang_parseTranslationUnit()
* to indicate that the translation unit is likely to be reparsed many times,
* either explicitly (via \c clang_reparseTranslationUnit()) or implicitly
* (e.g., by code completion (\c clang_codeCompletionAt())). The returned flag
* set contains an unspecified set of optimizations (e.g., the precompiled 
* preamble) geared toward improving the performance of these routines. The
* set of optimizations enabled may change from one version to the next.
*/

/**
* \brief Returns the set of flags that is suitable for parsing a translation
* unit that is being edited.
*
* The set of flags returned provide options for \c clang_parseTranslationUnit()
* to indicate that the translation unit is likely to be reparsed many times,
* either explicitly (via \c clang_reparseTranslationUnit()) or implicitly
* (e.g., by code completion (\c clang_codeCompletionAt())). The returned flag
* set contains an unspecified set of optimizations (e.g., the precompiled 
* preamble) geared toward improving the performance of these routines. The
* set of optimizations enabled may change from one version to the next.
*/
//<editor-fold defaultstate="collapsed" desc="clang_defaultEditingTranslationUnitOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3155,
 FQN="clang_defaultEditingTranslationUnitOptions", NM="_Z42clang_defaultEditingTranslationUnitOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z42clang_defaultEditingTranslationUnitOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_defaultEditingTranslationUnitOptions() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Same as \c clang_parseTranslationUnit2, but returns
* the \c CXTranslationUnit instead of an error code.  In case of an error this
* routine returns a \c NULL \c CXTranslationUnit, without further detailed
* error codes.
*/

/**
* \brief Same as \c clang_parseTranslationUnit2, but returns
* the \c CXTranslationUnit instead of an error code.  In case of an error this
* routine returns a \c NULL \c CXTranslationUnit, without further detailed
* error codes.
*/
//<editor-fold defaultstate="collapsed" desc="clang_parseTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3307,
 FQN="clang_parseTranslationUnit", NM="_Z26clang_parseTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z26clang_parseTranslationUnit")
//</editor-fold>
public /*static*/ default CXTranslationUnit clang_parseTranslationUnit(CXIndex CIdx, 
                          /*const*/char$ptr/*char P*/ source_filename, 
                          /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, 
                          int num_command_line_args, 
                           CXUnsavedFile /*P*/ unsaved_files, 
                          /*uint*/int num_unsaved_files, 
                          /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Parse the given source file and the translation unit corresponding
* to that file.
*
* This routine is the main entry point for the Clang C API, providing the
* ability to parse a source file into a translation unit that can then be
* queried by other functions in the API. This routine accepts a set of
* command-line arguments so that the compilation can be configured in the same
* way that the compiler is configured on the command line.
*
* \param CIdx The index object with which the translation unit will be 
* associated.
*
* \param source_filename The name of the source file to load, or NULL if the
* source file is included in \c command_line_args.
*
* \param command_line_args The command-line arguments that would be
* passed to the \c clang executable if it were being invoked out-of-process.
* These command-line options will be parsed and will affect how the translation
* unit is parsed. Note that the following options are ignored: '-c', 
* '-emit-ast', '-fsyntax-only' (which is the default), and '-o \<output file>'.
*
* \param num_command_line_args The number of command-line arguments in
* \c command_line_args.
*
* \param unsaved_files the files that have not yet been saved to disk
* but may be required for parsing, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
*
* \param num_unsaved_files the number of unsaved file entries in \p
* unsaved_files.
*
* \param options A bitmask of options that affects how the translation unit
* is managed but not its compilation. This should be a bitwise OR of the
* CXTranslationUnit_XXX flags.
*
* \param[out] out_TU A non-NULL pointer to store the created
* \c CXTranslationUnit, describing the parsed code and containing any
* diagnostics produced by the compiler.
*
* \returns Zero on success, otherwise returns an error code.
*/

/**
* \brief Parse the given source file and the translation unit corresponding
* to that file.
*
* This routine is the main entry point for the Clang C API, providing the
* ability to parse a source file into a translation unit that can then be
* queried by other functions in the API. This routine accepts a set of
* command-line arguments so that the compilation can be configured in the same
* way that the compiler is configured on the command line.
*
* \param CIdx The index object with which the translation unit will be 
* associated.
*
* \param source_filename The name of the source file to load, or NULL if the
* source file is included in \c command_line_args.
*
* \param command_line_args The command-line arguments that would be
* passed to the \c clang executable if it were being invoked out-of-process.
* These command-line options will be parsed and will affect how the translation
* unit is parsed. Note that the following options are ignored: '-c', 
* '-emit-ast', '-fsyntax-only' (which is the default), and '-o \<output file>'.
*
* \param num_command_line_args The number of command-line arguments in
* \c command_line_args.
*
* \param unsaved_files the files that have not yet been saved to disk
* but may be required for parsing, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
*
* \param num_unsaved_files the number of unsaved file entries in \p
* unsaved_files.
*
* \param options A bitmask of options that affects how the translation unit
* is managed but not its compilation. This should be a bitwise OR of the
* CXTranslationUnit_XXX flags.
*
* \param[out] out_TU A non-NULL pointer to store the created
* \c CXTranslationUnit, describing the parsed code and containing any
* diagnostics produced by the compiler.
*
* \returns Zero on success, otherwise returns an error code.
*/
//<editor-fold defaultstate="collapsed" desc="clang_parseTranslationUnit2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3325,
 FQN="clang_parseTranslationUnit2", NM="_Z27clang_parseTranslationUnit2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_parseTranslationUnit2")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_parseTranslationUnit2(CXIndex CIdx, /*const*/char$ptr/*char P*/ source_filename, 
                           /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, int num_command_line_args, 
                            CXUnsavedFile /*P*/ unsaved_files, /*uint*/int num_unsaved_files, 
                           /*uint*/int options, CXTranslationUnit/*P*/ out_TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Same as clang_parseTranslationUnit2 but requires a full command line
* for \c command_line_args including argv[0]. This is useful if the standard
* library paths are relative to the binary.
*/

/**
* \brief Same as clang_parseTranslationUnit2 but requires a full command line
* for \c command_line_args including argv[0]. This is useful if the standard
* library paths are relative to the binary.
*/
//<editor-fold defaultstate="collapsed" desc="clang_parseTranslationUnit2FullArgv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3338,
 FQN="clang_parseTranslationUnit2FullArgv", NM="_Z35clang_parseTranslationUnit2FullArgv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z35clang_parseTranslationUnit2FullArgv")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_parseTranslationUnit2FullArgv(CXIndex CIdx, /*const*/char$ptr/*char P*/ source_filename, 
                                   /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, int num_command_line_args, 
                                    CXUnsavedFile /*P*/ unsaved_files, /*uint*/int num_unsaved_files, 
                                   /*uint*/int options, CXTranslationUnit/*P*/ out_TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the set of flags that is suitable for saving a translation
* unit.
*
* The set of flags returned provide options for
* \c clang_saveTranslationUnit() by default. The returned flag
* set contains an unspecified set of options that save translation units with
* the most commonly-requested data.
*/

/**
* \brief Returns the set of flags that is suitable for saving a translation
* unit.
*
* The set of flags returned provide options for
* \c clang_saveTranslationUnit() by default. The returned flag
* set contains an unspecified set of options that save translation units with
* the most commonly-requested data.
*/
//<editor-fold defaultstate="collapsed" desc="clang_defaultSaveOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3697,
 FQN="clang_defaultSaveOptions", NM="_Z24clang_defaultSaveOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_defaultSaveOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_defaultSaveOptions(CXTranslationUnit TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Saves a translation unit into a serialized representation of
* that translation unit on disk.
*
* Any translation unit that was parsed without error can be saved
* into a file. The translation unit can then be deserialized into a
* new \c CXTranslationUnit with \c clang_createTranslationUnit() or,
* if it is an incomplete translation unit that corresponds to a
* header, used as a precompiled header when parsing other translation
* units.
*
* \param TU The translation unit to save.
*
* \param FileName The file to which the translation unit will be saved.
*
* \param options A bitmask of options that affects how the translation unit
* is saved. This should be a bitwise OR of the
* CXSaveTranslationUnit_XXX flags.
*
* \returns A value that will match one of the enumerators of the CXSaveError
* enumeration. Zero (CXSaveError_None) indicates that the translation unit was 
* saved successfully, while a non-zero value indicates that a problem occurred.
*/

/**
* \brief Saves a translation unit into a serialized representation of
* that translation unit on disk.
*
* Any translation unit that was parsed without error can be saved
* into a file. The translation unit can then be deserialized into a
* new \c CXTranslationUnit with \c clang_createTranslationUnit() or,
* if it is an incomplete translation unit that corresponds to a
* header, used as a precompiled header when parsing other translation
* units.
*
* \param TU The translation unit to save.
*
* \param FileName The file to which the translation unit will be saved.
*
* \param options A bitmask of options that affects how the translation unit
* is saved. This should be a bitwise OR of the
* CXSaveTranslationUnit_XXX flags.
*
* \returns A value that will match one of the enumerators of the CXSaveError
* enumeration. Zero (CXSaveError_None) indicates that the translation unit was 
* saved successfully, while a non-zero value indicates that a problem occurred.
*/
//<editor-fold defaultstate="collapsed" desc="clang_saveTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3712,
 FQN="clang_saveTranslationUnit", NM="_Z25clang_saveTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_saveTranslationUnit")
//</editor-fold>
public /*static*/ default int clang_saveTranslationUnit(CXTranslationUnit TU, /*const*/char$ptr/*char P*/ FileName, 
                         /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Destroy the specified CXTranslationUnit object.
*/

/**
* \brief Destroy the specified CXTranslationUnit object.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3763,
 FQN="clang_disposeTranslationUnit", NM="_Z28clang_disposeTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_disposeTranslationUnit")
//</editor-fold>
public /*static*/ default void clang_disposeTranslationUnit(CXTranslationUnit CTUnit) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the set of flags that is suitable for reparsing a translation
* unit.
*
* The set of flags returned provide options for
* \c clang_reparseTranslationUnit() by default. The returned flag
* set contains an unspecified set of optimizations geared toward common uses
* of reparsing. The set of optimizations enabled may change from one version 
* to the next.
*/

/**
* \brief Returns the set of flags that is suitable for reparsing a translation
* unit.
*
* The set of flags returned provide options for
* \c clang_reparseTranslationUnit() by default. The returned flag
* set contains an unspecified set of optimizations geared toward common uses
* of reparsing. The set of optimizations enabled may change from one version 
* to the next.
*/
//<editor-fold defaultstate="collapsed" desc="clang_defaultReparseOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3780,
 FQN="clang_defaultReparseOptions", NM="_Z27clang_defaultReparseOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_defaultReparseOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_defaultReparseOptions(CXTranslationUnit TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Reparse the source files that produced this translation unit.
*
* This routine can be used to re-parse the source files that originally
* created the given translation unit, for example because those source files
* have changed (either on disk or as passed via \p unsaved_files). The
* source code will be reparsed with the same command-line options as it
* was originally parsed. 
*
* Reparsing a translation unit invalidates all cursors and source locations
* that refer into that translation unit. This makes reparsing a translation
* unit semantically equivalent to destroying the translation unit and then
* creating a new translation unit with the same command-line arguments.
* However, it may be more efficient to reparse a translation 
* unit using this routine.
*
* \param TU The translation unit whose contents will be re-parsed. The
* translation unit must originally have been built with 
* \c clang_createTranslationUnitFromSourceFile().
*
* \param num_unsaved_files The number of unsaved file entries in \p
* unsaved_files.
*
* \param unsaved_files The files that have not yet been saved to disk
* but may be required for parsing, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
* 
* \param options A bitset of options composed of the flags in CXReparse_Flags.
* The function \c clang_defaultReparseOptions() produces a default set of
* options recommended for most uses, based on the translation unit.
*
* \returns 0 if the sources could be reparsed.  A non-zero error code will be
* returned if reparsing was impossible, such that the translation unit is
* invalid. In such cases, the only valid call for \c TU is
* \c clang_disposeTranslationUnit(TU).  The error codes returned by this
* routine are described by the \c CXErrorCode enum.
*/

/**
* \brief Reparse the source files that produced this translation unit.
*
* This routine can be used to re-parse the source files that originally
* created the given translation unit, for example because those source files
* have changed (either on disk or as passed via \p unsaved_files). The
* source code will be reparsed with the same command-line options as it
* was originally parsed. 
*
* Reparsing a translation unit invalidates all cursors and source locations
* that refer into that translation unit. This makes reparsing a translation
* unit semantically equivalent to destroying the translation unit and then
* creating a new translation unit with the same command-line arguments.
* However, it may be more efficient to reparse a translation 
* unit using this routine.
*
* \param TU The translation unit whose contents will be re-parsed. The
* translation unit must originally have been built with 
* \c clang_createTranslationUnitFromSourceFile().
*
* \param num_unsaved_files The number of unsaved file entries in \p
* unsaved_files.
*
* \param unsaved_files The files that have not yet been saved to disk
* but may be required for parsing, including the contents of
* those files.  The contents and name of these files (as specified by
* CXUnsavedFile) are copied when necessary, so the client only needs to
* guarantee their validity until the call to this function returns.
* 
* \param options A bitset of options composed of the flags in CXReparse_Flags.
* The function \c clang_defaultReparseOptions() produces a default set of
* options recommended for most uses, based on the translation unit.
*
* \returns 0 if the sources could be reparsed.  A non-zero error code will be
* returned if reparsing was impossible, such that the translation unit is
* invalid. In such cases, the only valid call for \c TU is
* \c clang_disposeTranslationUnit(TU).  The error codes returned by this
* routine are described by the \c CXErrorCode enum.
*/
//<editor-fold defaultstate="collapsed" desc="clang_reparseTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3826,
 FQN="clang_reparseTranslationUnit", NM="_Z28clang_reparseTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_reparseTranslationUnit")
//</editor-fold>
public /*static*/ default int clang_reparseTranslationUnit(CXTranslationUnit TU, 
                            /*uint*/int num_unsaved_files, 
                             CXUnsavedFile /*P*/ unsaved_files, 
                            /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the human-readable null-terminated C string that represents
*  the name of the memory category.  This string should never be freed.
*/

/**
* \brief Returns the human-readable null-terminated C string that represents
*  the name of the memory category.  This string should never be freed.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTUResourceUsageName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7572,
 FQN="clang_getTUResourceUsageName", NM="_Z28clang_getTUResourceUsageName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_getTUResourceUsageName")
//</editor-fold>
public /*static*/ default /*const*/char$ptr/*char P*/ clang_getTUResourceUsageName(CXTUResourceUsageKind kind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the memory usage of a translation unit.  This object
*  should be released with clang_disposeCXTUResourceUsage().
*/

/**
* \brief Return the memory usage of a translation unit.  This object
*  should be released with clang_disposeCXTUResourceUsage().
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCXTUResourceUsage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7621,
 FQN="clang_getCXTUResourceUsage", NM="_Z26clang_getCXTUResourceUsage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z26clang_getCXTUResourceUsage")
//</editor-fold>
public /*static*/ default  CXTUResourceUsage clang_getCXTUResourceUsage(CXTranslationUnit TU) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_disposeCXTUResourceUsage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7714,
 FQN="clang_disposeCXTUResourceUsage", NM="_Z30clang_disposeCXTUResourceUsage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_disposeCXTUResourceUsage")
//</editor-fold>
public /*static*/ default void clang_disposeCXTUResourceUsage( CXTUResourceUsage usage) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \defgroup CINDEX_CURSOR_MANIP Cursor manipulations
*
* @{
*/

/**
* \brief Retrieve the NULL cursor, which represents no entity.
*/

/**
* \defgroup CINDEX_CURSOR_MANIP Cursor manipulations
*
* @{
*/

/**
* \brief Retrieve the NULL cursor, which represents no entity.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNullCursor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5070,
 FQN="clang_getNullCursor", NM="_Z19clang_getNullCursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19clang_getNullCursor")
//</editor-fold>
public /*static*/ default  CXCursor clang_getNullCursor() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the cursor that represents the given translation unit.
*
* The translation unit cursor can be used to start traversing the
* various declarations within the given translation unit.
*/

/**
* \brief Retrieve the cursor that represents the given translation unit.
*
* The translation unit cursor can be used to start traversing the
* various declarations within the given translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTranslationUnitCursor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3871,
 FQN="clang_getTranslationUnitCursor", NM="_Z30clang_getTranslationUnitCursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_getTranslationUnitCursor")
//</editor-fold>
public /*static*/ default  CXCursor clang_getTranslationUnitCursor(CXTranslationUnit TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether two cursors are equivalent.
*/

/**
* \brief Determine whether two cursors are equivalent.
*/
//<editor-fold defaultstate="collapsed" desc="clang_equalCursors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5074,
 FQN="clang_equalCursors", NM="_Z18clang_equalCursors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z18clang_equalCursors")
//</editor-fold>
public /*static*/ default /*uint*/int clang_equalCursors( CXCursor X,  CXCursor Y) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if \p cursor is null.
*/

/**
* \brief Returns non-zero if \p cursor is null.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isNull">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1092,
 FQN="clang_Cursor_isNull", NM="_Z19clang_Cursor_isNull",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z19clang_Cursor_isNull")
//</editor-fold>
public /*static*/ default int clang_Cursor_isNull( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Compute a hash value for the given cursor.
*/

/**
* \brief Compute a hash value for the given cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_hashCursor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5090,
 FQN="clang_hashCursor", NM="_Z16clang_hashCursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z16clang_hashCursor")
//</editor-fold>
public /*static*/ default /*uint*/int clang_hashCursor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the kind of the given cursor.
*/

/**
* \brief Retrieve the kind of the given cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5144,
 FQN="clang_getCursorKind", NM="_Z19clang_getCursorKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19clang_getCursorKind")
//</editor-fold>
public /*static*/ default CXCursorKind clang_getCursorKind( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents a declaration.
*/

/**
* \brief Determine whether the given cursor kind represents a declaration.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5103,
 FQN="clang_isDeclaration", NM="_Z19clang_isDeclaration",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19clang_isDeclaration")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isDeclaration( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents a simple
* reference.
*
* Note that other kinds of cursors (such as expressions) can also refer to
* other cursors. Use clang_getCursorReferenced() to determine whether a
* particular cursor refers to another entity.
*/

/**
* \brief Determine whether the given cursor kind represents a simple
* reference.
*
* Note that other kinds of cursors (such as expressions) can also refer to
* other cursors. Use clang_getCursorReferenced() to determine whether a
* particular cursor refers to another entity.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isReference">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5108,
 FQN="clang_isReference", NM="_Z17clang_isReference",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_isReference")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isReference( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents an expression.
*/

/**
* \brief Determine whether the given cursor kind represents an expression.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isExpression">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5112,
 FQN="clang_isExpression", NM="_Z18clang_isExpression",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z18clang_isExpression")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isExpression( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents a statement.
*/

/**
* \brief Determine whether the given cursor kind represents a statement.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isStatement">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5116,
 FQN="clang_isStatement", NM="_Z17clang_isStatement",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_isStatement")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isStatement( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents an attribute.
*/

/**
* \brief Determine whether the given cursor kind represents an attribute.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isAttribute">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5120,
 FQN="clang_isAttribute", NM="_Z17clang_isAttribute",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_isAttribute")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isAttribute( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor has any attributes.
*/

/**
* \brief Determine whether the given cursor has any attributes.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_hasAttrs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3685,
 FQN="clang_Cursor_hasAttrs", NM="_Z21clang_Cursor_hasAttrs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_Cursor_hasAttrs")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_hasAttrs( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents an invalid
* cursor.
*/

/**
* \brief Determine whether the given cursor kind represents an invalid
* cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isInvalid">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5099,
 FQN="clang_isInvalid", NM="_Z15clang_isInvalid",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z15clang_isInvalid")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isInvalid( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor kind represents a translation
* unit.
*/

/**
* \brief Determine whether the given cursor kind represents a translation
* unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5124,
 FQN="clang_isTranslationUnit", NM="_Z23clang_isTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_isTranslationUnit")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isTranslationUnit( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/***
* \brief Determine whether the given cursor represents a preprocessing
* element, such as a preprocessor directive or macro instantiation.
*/

/***
* \brief Determine whether the given cursor represents a preprocessing
* element, such as a preprocessor directive or macro instantiation.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isPreprocessing">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5128,
 FQN="clang_isPreprocessing", NM="_Z21clang_isPreprocessing",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_isPreprocessing")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isPreprocessing( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/***
* \brief Determine whether the given cursor represents a currently
*  unexposed piece of the AST (e.g., CXCursor_UnexposedStmt).
*/

/***
* \brief Determine whether the given cursor represents a currently
*  unexposed piece of the AST (e.g., CXCursor_UnexposedStmt).
*/
//<editor-fold defaultstate="collapsed" desc="clang_isUnexposed">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5132,
 FQN="clang_isUnexposed", NM="_Z17clang_isUnexposed",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z17clang_isUnexposed")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isUnexposed( CXCursorKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the linkage of the entity referred to by a given cursor.
*/

/**
* \brief Determine the linkage of the entity referred to by a given cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorLinkage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6867,
 FQN="clang_getCursorLinkage", NM="_Z22clang_getCursorLinkage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_getCursorLinkage")
//</editor-fold>
public /*static*/ default CXLinkageKind clang_getCursorLinkage( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Describe the visibility of the entity referred to by a cursor.
*
* This returns the default visibility if not explicitly specified by
* a visibility attribute. The default visibility may be changed by
* commandline arguments.
*
* \param cursor The cursor to query.
*
* \returns The visibility of the cursor.
*/

/**
* \brief Describe the visibility of the entity referred to by a cursor.
*
* This returns the default visibility if not explicitly specified by
* a visibility attribute. The default visibility may be changed by
* commandline arguments.
*
* \param cursor The cursor to query.
*
* \returns The visibility of the cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorVisibility">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6890,
 FQN="clang_getCursorVisibility", NM="_Z25clang_getCursorVisibility",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_getCursorVisibility")
//</editor-fold>
public /*static*/ default CXVisibilityKind clang_getCursorVisibility( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the availability of the entity that this cursor refers to,
* taking the current target platform into account.
*
* \param cursor The cursor to query.
*
* \returns The availability of the cursor.
*/

/**
* \brief Determine the availability of the entity that this cursor refers to,
* taking the current target platform into account.
*
* \param cursor The cursor to query.
*
* \returns The availability of the cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorAvailability">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6984,
 FQN="clang_getCursorAvailability", NM="_Z27clang_getCursorAvailability",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_getCursorAvailability")
//</editor-fold>
public /*static*/ default  CXAvailabilityKind clang_getCursorAvailability( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the availability of the entity that this cursor refers to
* on any platforms for which availability information is known.
*
* \param cursor The cursor to query.
*
* \param always_deprecated If non-NULL, will be set to indicate whether the 
* entity is deprecated on all platforms.
*
* \param deprecated_message If non-NULL, will be set to the message text 
* provided along with the unconditional deprecation of this entity. The client
* is responsible for deallocating this string.
*
* \param always_unavailable If non-NULL, will be set to indicate whether the
* entity is unavailable on all platforms.
*
* \param unavailable_message If non-NULL, will be set to the message text
* provided along with the unconditional unavailability of this entity. The 
* client is responsible for deallocating this string.
*
* \param availability If non-NULL, an array of CXPlatformAvailability instances
* that will be populated with platform availability information, up to either
* the number of platforms for which availability information is available (as
* returned by this function) or \c availability_size, whichever is smaller.
*
* \param availability_size The number of elements available in the 
* \c availability array.
*
* \returns The number of platforms (N) for which availability information is
* available (which is unrelated to \c availability_size).
*
* Note that the client is responsible for calling 
* \c clang_disposeCXPlatformAvailability to free each of the 
* platform-availability structures returned. There are 
* \c min(N, availability_size) such structures.
*/

/**
* \brief Determine the availability of the entity that this cursor refers to
* on any platforms for which availability information is known.
*
* \param cursor The cursor to query.
*
* \param always_deprecated If non-NULL, will be set to indicate whether the 
* entity is deprecated on all platforms.
*
* \param deprecated_message If non-NULL, will be set to the message text 
* provided along with the unconditional deprecation of this entity. The client
* is responsible for deallocating this string.
*
* \param always_unavailable If non-NULL, will be set to indicate whether the
* entity is unavailable on all platforms.
*
* \param unavailable_message If non-NULL, will be set to the message text
* provided along with the unconditional unavailability of this entity. The 
* client is responsible for deallocating this string.
*
* \param availability If non-NULL, an array of CXPlatformAvailability instances
* that will be populated with platform availability information, up to either
* the number of platforms for which availability information is available (as
* returned by this function) or \c availability_size, whichever is smaller.
*
* \param availability_size The number of elements available in the 
* \c availability array.
*
* \returns The number of platforms (N) for which availability information is
* available (which is unrelated to \c availability_size).
*
* Note that the client is responsible for calling 
* \c clang_disposeCXPlatformAvailability to free each of the 
* platform-availability structures returned. There are 
* \c min(N, availability_size) such structures.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorPlatformAvailability">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7073,
 FQN="clang_getCursorPlatformAvailability", NM="_Z35clang_getCursorPlatformAvailability",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z35clang_getCursorPlatformAvailability")
//</editor-fold>
public /*static*/ default int clang_getCursorPlatformAvailability( CXCursor cursor, 
                                   int$ptr/*int P*/ always_deprecated, 
                                    type$ptr<CXString> deprecated_message, 
                                   int$ptr/*int P*/ always_unavailable, 
                                    type$ptr<CXString> unavailable_message, 
                                    CXPlatformAvailability /*P*/ availability, 
                                   int availability_size) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the memory associated with a \c CXPlatformAvailability structure.
*/

/**
* \brief Free the memory associated with a \c CXPlatformAvailability structure.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeCXPlatformAvailability">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7104,
 FQN="clang_disposeCXPlatformAvailability", NM="_Z35clang_disposeCXPlatformAvailability",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z35clang_disposeCXPlatformAvailability")
//</editor-fold>
public /*static*/ default void clang_disposeCXPlatformAvailability( CXPlatformAvailability /*P*/ availability) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the "language" of the entity referred to by a given cursor.
*/

/**
* \brief Determine the "language" of the entity referred to by a given cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorLanguage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7109,
 FQN="clang_getCursorLanguage", NM="_Z23clang_getCursorLanguage",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_getCursorLanguage")
//</editor-fold>
public /*static*/ default CXLanguageKind clang_getCursorLanguage( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the translation unit that a cursor originated from.
*/

/**
* \brief Returns the translation unit that a cursor originated from.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1096,
 FQN="clang_Cursor_getTranslationUnit", NM="_Z31clang_Cursor_getTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z31clang_Cursor_getTranslationUnit")
//</editor-fold>
public /*static*/ default CXTranslationUnit clang_Cursor_getTranslationUnit( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Creates an empty CXCursorSet.
*/

/**
* \brief Creates an empty CXCursorSet.
*/
//<editor-fold defaultstate="collapsed" desc="clang_createCXCursorSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1317,
 FQN="clang_createCXCursorSet", NM="_Z23clang_createCXCursorSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z23clang_createCXCursorSet")
//</editor-fold>
public /*static*/ default CXCursorSet clang_createCXCursorSet() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Disposes a CXCursorSet and releases its associated memory.
*/

/**
* \brief Disposes a CXCursorSet and releases its associated memory.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeCXCursorSet">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1321,
 FQN="clang_disposeCXCursorSet", NM="_Z24clang_disposeCXCursorSet",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z24clang_disposeCXCursorSet")
//</editor-fold>
public /*static*/ default void clang_disposeCXCursorSet(CXCursorSet set) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Queries a CXCursorSet to see if it contains a specific CXCursor.
*
* \returns non-zero if the set contains the specified cursor.
*/

/**
* \brief Queries a CXCursorSet to see if it contains a specific CXCursor.
*
* \returns non-zero if the set contains the specified cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXCursorSet_contains">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1325,
 FQN="clang_CXCursorSet_contains", NM="_Z26clang_CXCursorSet_contains",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z26clang_CXCursorSet_contains")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXCursorSet_contains(CXCursorSet set,  CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Inserts a CXCursor into a CXCursorSet.
*
* \returns zero if the CXCursor was already in the set, and non-zero otherwise.
*/

/**
* \brief Inserts a CXCursor into a CXCursorSet.
*
* \returns zero if the CXCursor was already in the set, and non-zero otherwise.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXCursorSet_insert">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1332,
 FQN="clang_CXCursorSet_insert", NM="_Z24clang_CXCursorSet_insert",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z24clang_CXCursorSet_insert")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXCursorSet_insert(CXCursorSet set,  CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the semantic parent of the given cursor.
*
* The semantic parent of a cursor is the cursor that semantically contains
* the given \p cursor. For many declarations, the lexical and semantic parents
* are equivalent (the lexical parent is returned by 
* \c clang_getCursorLexicalParent()). They diverge when declarations or
* definitions are provided out-of-line. For example:
*
* \code
* class C {
*  void f();
* };
*
* void C::f() { }
* \endcode
*
* In the out-of-line definition of \c C::f, the semantic parent is
* the class \c C, of which this function is a member. The lexical parent is
* the place where the declaration actually occurs in the source code; in this
* case, the definition occurs in the translation unit. In general, the
* lexical parent for a given entity can change without affecting the semantics
* of the program, and the lexical parent of different declarations of the
* same entity may be different. Changing the semantic parent of a declaration,
* on the other hand, can have a major impact on semantics, and redeclarations
* of a particular entity should all have the same semantic context.
*
* In the example above, both declarations of \c C::f have \c C as their
* semantic context, while the lexical context of the first \c C::f is \c C
* and the lexical context of the second \c C::f is the translation unit.
*
* For global declarations, the semantic parent is the translation unit.
*/

/**
* \brief Determine the semantic parent of the given cursor.
*
* The semantic parent of a cursor is the cursor that semantically contains
* the given \p cursor. For many declarations, the lexical and semantic parents
* are equivalent (the lexical parent is returned by 
* \c clang_getCursorLexicalParent()). They diverge when declarations or
* definitions are provided out-of-line. For example:
*
* \code
* class C {
*  void f();
* };
*
* void C::f() { }
* \endcode
*
* In the out-of-line definition of \c C::f, the semantic parent is
* the class \c C, of which this function is a member. The lexical parent is
* the place where the declaration actually occurs in the source code; in this
* case, the definition occurs in the translation unit. In general, the
* lexical parent for a given entity can change without affecting the semantics
* of the program, and the lexical parent of different declarations of the
* same entity may be different. Changing the semantic parent of a declaration,
* on the other hand, can have a major impact on semantics, and redeclarations
* of a particular entity should all have the same semantic context.
*
* In the example above, both declarations of \c C::f have \c C as their
* semantic context, while the lexical context of the first \c C::f is \c C
* and the lexical context of the second \c C::f is the translation unit.
*
* For global declarations, the semantic parent is the translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorSemanticParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7166,
 FQN="clang_getCursorSemanticParent", NM="_Z29clang_getCursorSemanticParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z29clang_getCursorSemanticParent")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCursorSemanticParent( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the lexical parent of the given cursor.
*
* The lexical parent of a cursor is the cursor in which the given \p cursor
* was actually written. For many declarations, the lexical and semantic parents
* are equivalent (the semantic parent is returned by 
* \c clang_getCursorSemanticParent()). They diverge when declarations or
* definitions are provided out-of-line. For example:
*
* \code
* class C {
*  void f();
* };
*
* void C::f() { }
* \endcode
*
* In the out-of-line definition of \c C::f, the semantic parent is
* the class \c C, of which this function is a member. The lexical parent is
* the place where the declaration actually occurs in the source code; in this
* case, the definition occurs in the translation unit. In general, the
* lexical parent for a given entity can change without affecting the semantics
* of the program, and the lexical parent of different declarations of the
* same entity may be different. Changing the semantic parent of a declaration,
* on the other hand, can have a major impact on semantics, and redeclarations
* of a particular entity should all have the same semantic context.
*
* In the example above, both declarations of \c C::f have \c C as their
* semantic context, while the lexical context of the first \c C::f is \c C
* and the lexical context of the second \c C::f is the translation unit.
*
* For declarations written in the global scope, the lexical parent is
* the translation unit.
*/

/**
* \brief Determine the lexical parent of the given cursor.
*
* The lexical parent of a cursor is the cursor in which the given \p cursor
* was actually written. For many declarations, the lexical and semantic parents
* are equivalent (the semantic parent is returned by 
* \c clang_getCursorSemanticParent()). They diverge when declarations or
* definitions are provided out-of-line. For example:
*
* \code
* class C {
*  void f();
* };
*
* void C::f() { }
* \endcode
*
* In the out-of-line definition of \c C::f, the semantic parent is
* the class \c C, of which this function is a member. The lexical parent is
* the place where the declaration actually occurs in the source code; in this
* case, the definition occurs in the translation unit. In general, the
* lexical parent for a given entity can change without affecting the semantics
* of the program, and the lexical parent of different declarations of the
* same entity may be different. Changing the semantic parent of a declaration,
* on the other hand, can have a major impact on semantics, and redeclarations
* of a particular entity should all have the same semantic context.
*
* In the example above, both declarations of \c C::f have \c C as their
* semantic context, while the lexical context of the first \c C::f is \c C
* and the lexical context of the second \c C::f is the translation unit.
*
* For declarations written in the global scope, the lexical parent is
* the translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorLexicalParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7186,
 FQN="clang_getCursorLexicalParent", NM="_Z28clang_getCursorLexicalParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_getCursorLexicalParent")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCursorLexicalParent( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the set of methods that are overridden by the given
* method.
*
* In both Objective-C and C++, a method (aka virtual member function,
* in C++) can override a virtual method in a base class. For
* Objective-C, a method is said to override any method in the class's
* base class, its protocols, or its categories' protocols, that has the same
* selector and is of the same kind (class or instance).
* If no such method exists, the search continues to the class's superclass,
* its protocols, and its categories, and so on. A method from an Objective-C
* implementation is considered to override the same methods as its
* corresponding method in the interface.
*
* For C++, a virtual member function overrides any virtual member
* function with the same signature that occurs in its base
* classes. With multiple inheritance, a virtual member function can
* override several virtual member functions coming from different
* base classes.
*
* In all cases, this function determines the immediate overridden
* method, rather than all of the overridden methods. For example, if
* a method is originally declared in a class A, then overridden in B
* (which in inherits from A) and also in C (which inherited from B),
* then the only overridden method returned from this function when
* invoked on C's method will be B's method. The client may then
* invoke this function again, given the previously-found overridden
* methods, to map out the complete method-override set.
*
* \param cursor A cursor representing an Objective-C or C++
* method. This routine will compute the set of methods that this
* method overrides.
* 
* \param overridden A pointer whose pointee will be replaced with a
* pointer to an array of cursors, representing the set of overridden
* methods. If there are no overridden methods, the pointee will be
* set to NULL. The pointee must be freed via a call to 
* \c clang_disposeOverriddenCursors().
*
* \param num_overridden A pointer to the number of overridden
* functions, will be set to the number of overridden functions in the
* array pointed to by \p overridden.
*/

/**
* \brief Determine the set of methods that are overridden by the given
* method.
*
* In both Objective-C and C++, a method (aka virtual member function,
* in C++) can override a virtual method in a base class. For
* Objective-C, a method is said to override any method in the class's
* base class, its protocols, or its categories' protocols, that has the same
* selector and is of the same kind (class or instance).
* If no such method exists, the search continues to the class's superclass,
* its protocols, and its categories, and so on. A method from an Objective-C
* implementation is considered to override the same methods as its
* corresponding method in the interface.
*
* For C++, a virtual member function overrides any virtual member
* function with the same signature that occurs in its base
* classes. With multiple inheritance, a virtual member function can
* override several virtual member functions coming from different
* base classes.
*
* In all cases, this function determines the immediate overridden
* method, rather than all of the overridden methods. For example, if
* a method is originally declared in a class A, then overridden in B
* (which in inherits from A) and also in C (which inherited from B),
* then the only overridden method returned from this function when
* invoked on C's method will be B's method. The client may then
* invoke this function again, given the previously-found overridden
* methods, to map out the complete method-override set.
*
* \param cursor A cursor representing an Objective-C or C++
* method. This routine will compute the set of methods that this
* method overrides.
* 
* \param overridden A pointer whose pointee will be replaced with a
* pointer to an array of cursors, representing the set of overridden
* methods. If there are no overridden methods, the pointee will be
* set to NULL. The pointee must be freed via a call to 
* \c clang_disposeOverriddenCursors().
*
* \param num_overridden A pointer to the number of overridden
* functions, will be set to the number of overridden functions in the
* array pointed to by \p overridden.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getOverriddenCursors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1405,
 FQN="clang_getOverriddenCursors", NM="_Z26clang_getOverriddenCursors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z26clang_getOverriddenCursors")
//</editor-fold>
public /*static*/ default void clang_getOverriddenCursors( CXCursor cursor, 
                           CXCursor /*P*/ /*P*/ overridden, 
                          uint$ptr/*uint P*/ num_overridden) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the set of overridden cursors returned by \c
* clang_getOverriddenCursors().
*/

/**
* \brief Free the set of overridden cursors returned by \c
* clang_getOverriddenCursors().
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeOverriddenCursors">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1462,
 FQN="clang_disposeOverriddenCursors", NM="_Z30clang_disposeOverriddenCursors",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z30clang_disposeOverriddenCursors")
//</editor-fold>
public /*static*/ default void clang_disposeOverriddenCursors( CXCursor /*P*/ overridden) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the file that is included by the given inclusion directive
* cursor.
*/

/**
* \brief Retrieve the file that is included by the given inclusion directive
* cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getIncludedFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7203,
 FQN="clang_getIncludedFile", NM="_Z21clang_getIncludedFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_getIncludedFile")
//</editor-fold>
public /*static*/ default CXFile clang_getIncludedFile( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_CURSOR_SOURCE Mapping between cursors and source code
*
* Cursors represent a location within the Abstract Syntax Tree (AST). These
* routines help map between cursors and the physical locations where the
* described entities occur in the source code. The mapping is provided in
* both directions, so one can map from source code to the AST and back.
*
* @{
*/

/**
* \brief Map a source location to the cursor that describes the entity at that
* location in the source code.
*
* clang_getCursor() maps an arbitrary source location within a translation
* unit down to the most specific cursor that describes the entity at that
* location. For example, given an expression \c x + y, invoking
* clang_getCursor() with a source location pointing to "x" will return the
* cursor for "x"; similarly for "y". If the cursor points anywhere between
* "x" or "y" (e.g., on the + or the whitespace around it), clang_getCursor()
* will return a cursor referring to the "+" expression.
*
* \returns a cursor representing the entity at the given source location, or
* a NULL cursor if no such entity can be found.
*/

/**
* @}
*/

/**
* \defgroup CINDEX_CURSOR_SOURCE Mapping between cursors and source code
*
* Cursors represent a location within the Abstract Syntax Tree (AST). These
* routines help map between cursors and the physical locations where the
* described entities occur in the source code. The mapping is provided in
* both directions, so one can map from source code to the AST and back.
*
* @{
*/

/**
* \brief Map a source location to the cursor that describes the entity at that
* location in the source code.
*
* clang_getCursor() maps an arbitrary source location within a translation
* unit down to the most specific cursor that describes the entity at that
* location. For example, given an expression \c x + y, invoking
* clang_getCursor() with a source location pointing to "x" will return the
* cursor for "x"; similarly for "y". If the cursor points anywhere between
* "x" or "y" (e.g., on the + or the whitespace around it), clang_getCursor()
* will return a cursor referring to the "+" expression.
*
* \returns a cursor representing the entity at the given source location, or
* a NULL cursor if no such entity can be found.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5008,
 FQN="clang_getCursor", NM="_Z15clang_getCursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z15clang_getCursor")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCursor(CXTranslationUnit TU,  CXSourceLocation Loc) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the physical location of the source constructor referenced
* by the given cursor.
*
* The location of a declaration is typically the location of the name of that
* declaration, where the name of that declaration would occur if it is
* unnamed, or some keyword that introduces that particular declaration.
* The location of a reference is where that reference occurs within the
* source code.
*/

/**
* \brief Retrieve the physical location of the source constructor referenced
* by the given cursor.
*
* The location of a declaration is typically the location of the name of that
* declaration, where the name of that declaration would occur if it is
* unnamed, or some keyword that introduces that particular declaration.
* The location of a reference is where that reference occurs within the
* source code.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5148,
 FQN="clang_getCursorLocation", NM="_Z23clang_getCursorLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_getCursorLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getCursorLocation( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the physical extent of the source construct referenced by
* the given cursor.
*
* The extent of a cursor starts with the file/line/column pointing at the
* first character within the source construct that the cursor refers to and
* ends with the last character within that source construct. For a
* declaration, the extent covers the declaration itself. For a reference,
* the extent covers the location of the reference (e.g., where the referenced
* entity was actually used).
*/

/**
* \brief Retrieve the physical extent of the source construct referenced by
* the given cursor.
*
* The extent of a cursor starts with the file/line/column pointing at the
* first character within the source construct that the cursor refers to and
* ends with the last character within that source construct. For a
* declaration, the extent covers the declaration itself. For a reference,
* the extent covers the location of the reference (e.g., where the referenced
* entity was actually used).
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorExtent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5457,
 FQN="clang_getCursorExtent", NM="_Z21clang_getCursorExtent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_getCursorExtent")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getCursorExtent( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Retrieve the type of a CXCursor (if any).
*/

/**
* \brief Retrieve the type of a CXCursor (if any).
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 148,
 FQN="clang_getCursorType", NM="_Z19clang_getCursorType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z19clang_getCursorType")
//</editor-fold>
public /*static*/ default  CXType clang_getCursorType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Pretty-print the underlying type using the rules of the
* language of the translation unit from which it came.
*
* If the type is invalid, an empty string is returned.
*/

/**
* \brief Pretty-print the underlying type using the rules of the
* language of the translation unit from which it came.
*
* If the type is invalid, an empty string is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTypeSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 223,
 FQN="clang_getTypeSpelling", NM="_Z21clang_getTypeSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z21clang_getTypeSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getTypeSpelling( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the underlying type of a typedef declaration.
*
* If the cursor does not reference a typedef declaration, an invalid type is
* returned.
*/

/**
* \brief Retrieve the underlying type of a typedef declaration.
*
* If the cursor does not reference a typedef declaration, an invalid type is
* returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTypedefDeclUnderlyingType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 238,
 FQN="clang_getTypedefDeclUnderlyingType", NM="_Z34clang_getTypedefDeclUnderlyingType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z34clang_getTypedefDeclUnderlyingType")
//</editor-fold>
public /*static*/ default  CXType clang_getTypedefDeclUnderlyingType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the integer type of an enum declaration.
*
* If the cursor does not reference an enum declaration, an invalid type is
* returned.
*/

/**
* \brief Retrieve the integer type of an enum declaration.
*
* If the cursor does not reference an enum declaration, an invalid type is
* returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getEnumDeclIntegerType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 256,
 FQN="clang_getEnumDeclIntegerType", NM="_Z28clang_getEnumDeclIntegerType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z28clang_getEnumDeclIntegerType")
//</editor-fold>
public /*static*/ default  CXType clang_getEnumDeclIntegerType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the integer value of an enum constant declaration as a signed
*  long long.
*
* If the cursor does not reference an enum constant declaration, LLONG_MIN is returned.
* Since this is also potentially a valid constant value, the kind of the cursor
* must be verified before calling this function.
*/

/**
* \brief Retrieve the integer value of an enum constant declaration as a signed
*  long long.
*
* If the cursor does not reference an enum constant declaration, LLONG_MIN is returned.
* Since this is also potentially a valid constant value, the kind of the cursor
* must be verified before calling this function.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getEnumConstantDeclValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 274,
 FQN="clang_getEnumConstantDeclValue", NM="_Z30clang_getEnumConstantDeclValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z30clang_getEnumConstantDeclValue")
//</editor-fold>
public /*static*/ default /*llong*/long clang_getEnumConstantDeclValue( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the integer value of an enum constant declaration as an unsigned
*  long long.
*
* If the cursor does not reference an enum constant declaration, ULLONG_MAX is returned.
* Since this is also potentially a valid constant value, the kind of the cursor
* must be verified before calling this function.
*/

/**
* \brief Retrieve the integer value of an enum constant declaration as an unsigned
*  long long.
*
* If the cursor does not reference an enum constant declaration, ULLONG_MAX is returned.
* Since this is also potentially a valid constant value, the kind of the cursor
* must be verified before calling this function.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getEnumConstantDeclUnsignedValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 290,
 FQN="clang_getEnumConstantDeclUnsignedValue", NM="_Z38clang_getEnumConstantDeclUnsignedValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z38clang_getEnumConstantDeclUnsignedValue")
//</editor-fold>
public /*static*/ default /*ullong*/long clang_getEnumConstantDeclUnsignedValue( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the bit width of a bit field declaration as an integer.
*
* If a cursor that is not a bit field declaration is passed in, -1 is returned.
*/

/**
* \brief Retrieve the bit width of a bit field declaration as an integer.
*
* If a cursor that is not a bit field declaration is passed in, -1 is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFieldDeclBitWidth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 306,
 FQN="clang_getFieldDeclBitWidth", NM="_Z26clang_getFieldDeclBitWidth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z26clang_getFieldDeclBitWidth")
//</editor-fold>
public /*static*/ default int clang_getFieldDeclBitWidth( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the number of non-variadic arguments associated with a given
* cursor.
*
* The number of arguments can be determined for calls as well as for
* declarations of functions or methods. For other cursors -1 is returned.
*/

/**
* \brief Retrieve the number of non-variadic arguments associated with a given
* cursor.
*
* The number of arguments can be determined for calls as well as for
* declarations of functions or methods. For other cursors -1 is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getNumArguments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1100,
 FQN="clang_Cursor_getNumArguments", NM="_Z28clang_Cursor_getNumArguments",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z28clang_Cursor_getNumArguments")
//</editor-fold>
public /*static*/ default int clang_Cursor_getNumArguments( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the argument cursor of a function or method.
*
* The argument cursor can be determined for calls as well as for declarations
* of functions or methods. For other cursors and for invalid indices, an
* invalid cursor is returned.
*/

/**
* \brief Retrieve the argument cursor of a function or method.
*
* The argument cursor can be determined for calls as well as for declarations
* of functions or methods. For other cursors and for invalid indices, an
* invalid cursor is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1119,
 FQN="clang_Cursor_getArgument", NM="_Z24clang_Cursor_getArgument",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z24clang_Cursor_getArgument")
//</editor-fold>
public /*static*/ default  CXCursor clang_Cursor_getArgument( CXCursor C, /*uint*/int i) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
*\brief Returns the number of template args of a function decl representing a
* template specialization.
*
* If the argument cursor cannot be converted into a template function
* declaration, -1 is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* The value 3 would be returned from this call.
*/

/**
*\brief Returns the number of template args of a function decl representing a
* template specialization.
*
* If the argument cursor cannot be converted into a template function
* declaration, -1 is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* The value 3 would be returned from this call.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getNumTemplateArguments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1147,
 FQN="clang_Cursor_getNumTemplateArguments", NM="_Z36clang_Cursor_getNumTemplateArguments",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z36clang_Cursor_getNumTemplateArguments")
//</editor-fold>
public /*static*/ default int clang_Cursor_getNumTemplateArguments( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the kind of the I'th template argument of the CXCursor C.
*
* If the argument CXCursor does not represent a FunctionDecl, an invalid
* template argument kind is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* For I = 0, 1, and 2, Type, Integral, and Integral will be returned,
* respectively.
*/

/**
* \brief Retrieve the kind of the I'th template argument of the CXCursor C.
*
* If the argument CXCursor does not represent a FunctionDecl, an invalid
* template argument kind is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* For I = 0, 1, and 2, Type, Integral, and Integral will be returned,
* respectively.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getTemplateArgumentKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1210,
 FQN="clang_Cursor_getTemplateArgumentKind", NM="_Z36clang_Cursor_getTemplateArgumentKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z36clang_Cursor_getTemplateArgumentKind")
//</editor-fold>
public /*static*/ default  CXTemplateArgumentKind clang_Cursor_getTemplateArgumentKind( CXCursor C, 
                                    /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a CXType representing the type of a TemplateArgument of a
*  function decl representing a template specialization.
*
* If the argument CXCursor does not represent a FunctionDecl whose I'th
* template argument has a kind of CXTemplateArgKind_Integral, an invalid type
* is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* If called with I = 0, "float", will be returned.
* Invalid types will be returned for I == 1 or 2.
*/

/**
* \brief Retrieve a CXType representing the type of a TemplateArgument of a
*  function decl representing a template specialization.
*
* If the argument CXCursor does not represent a FunctionDecl whose I'th
* template argument has a kind of CXTemplateArgKind_Integral, an invalid type
* is returned.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* If called with I = 0, "float", will be returned.
* Invalid types will be returned for I == 1 or 2.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getTemplateArgumentType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1234,
 FQN="clang_Cursor_getTemplateArgumentType", NM="_Z36clang_Cursor_getTemplateArgumentType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z36clang_Cursor_getTemplateArgumentType")
//</editor-fold>
public /*static*/ default  CXType clang_Cursor_getTemplateArgumentType( CXCursor C, /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the value of an Integral TemplateArgument (of a function
*  decl representing a template specialization) as a signed long long.
*
* It is undefined to call this function on a CXCursor that does not represent a
* FunctionDecl or whose I'th template argument is not an integral value.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* If called with I = 1 or 2, -7 or true will be returned, respectively.
* For I == 0, this function's behavior is undefined.
*/

/**
* \brief Retrieve the value of an Integral TemplateArgument (of a function
*  decl representing a template specialization) as a signed long long.
*
* It is undefined to call this function on a CXCursor that does not represent a
* FunctionDecl or whose I'th template argument is not an integral value.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, -7, true>();
*
* If called with I = 1 or 2, -7 or true will be returned, respectively.
* For I == 0, this function's behavior is undefined.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getTemplateArgumentValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1248,
 FQN="clang_Cursor_getTemplateArgumentValue", NM="_Z37clang_Cursor_getTemplateArgumentValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z37clang_Cursor_getTemplateArgumentValue")
//</editor-fold>
public /*static*/ default /*llong*/long clang_Cursor_getTemplateArgumentValue( CXCursor C, /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the value of an Integral TemplateArgument (of a function
*  decl representing a template specialization) as an unsigned long long.
*
* It is undefined to call this function on a CXCursor that does not represent a
* FunctionDecl or whose I'th template argument is not an integral value.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, 2147483649, true>();
*
* If called with I = 1 or 2, 2147483649 or true will be returned, respectively.
* For I == 0, this function's behavior is undefined.
*/

/**
* \brief Retrieve the value of an Integral TemplateArgument (of a function
*  decl representing a template specialization) as an unsigned long long.
*
* It is undefined to call this function on a CXCursor that does not represent a
* FunctionDecl or whose I'th template argument is not an integral value.
*
* For example, for the following declaration and specialization:
*   template <typename T, int kInt, bool kBool>
*   void foo() { ... }
*
*   template <>
*   void foo<float, 2147483649, true>();
*
* If called with I = 1 or 2, 2147483649 or true will be returned, respectively.
* For I == 0, this function's behavior is undefined.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getTemplateArgumentUnsignedValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1264,
 FQN="clang_Cursor_getTemplateArgumentUnsignedValue", NM="_Z45clang_Cursor_getTemplateArgumentUnsignedValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z45clang_Cursor_getTemplateArgumentUnsignedValue")
//</editor-fold>
public /*static*/ default /*ullong*/long clang_Cursor_getTemplateArgumentUnsignedValue( CXCursor C, 
                                             /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether two CXTypes represent the same type.
*
* \returns non-zero if the CXTypes represent the same type and
*          zero otherwise.
*/

/**
* \brief Determine whether two CXTypes represent the same type.
*
* \returns non-zero if the CXTypes represent the same type and
*          zero otherwise.
*/
//<editor-fold defaultstate="collapsed" desc="clang_equalTypes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 503,
 FQN="clang_equalTypes", NM="_Z16clang_equalTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z16clang_equalTypes")
//</editor-fold>
public /*static*/ default /*uint*/int clang_equalTypes( CXType A,  CXType B) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the canonical type for a CXType.
*
* Clang's type system explicitly models typedefs and all the ways
* a specific type can be represented.  The canonical type is the underlying
* type with all the "sugar" removed.  For example, if 'T' is a typedef
* for 'int', the canonical type for 'T' would be 'int'.
*/

/**
* \brief Return the canonical type for a CXType.
*
* Clang's type system explicitly models typedefs and all the ways
* a specific type can be represented.  The canonical type is the underlying
* type with all the "sugar" removed.  For example, if 'T' is a typedef
* for 'int', the canonical type for 'T' would be 'int'.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCanonicalType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 321,
 FQN="clang_getCanonicalType", NM="_Z22clang_getCanonicalType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z22clang_getCanonicalType")
//</editor-fold>
public /*static*/ default  CXType clang_getCanonicalType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a CXType has the "const" qualifier set,
* without looking through typedefs that may have added "const" at a
* different level.
*/

/**
* \brief Determine whether a CXType has the "const" qualifier set,
* without looking through typedefs that may have added "const" at a
* different level.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isConstQualifiedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 336,
 FQN="clang_isConstQualifiedType", NM="_Z26clang_isConstQualifiedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z26clang_isConstQualifiedType")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isConstQualifiedType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a  CXCursor that is a macro, is
* function like.
*/

/**
* \brief Determine whether a  CXCursor that is a macro, is
* function like.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isMacroFunctionLike">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3411,
 FQN="clang_Cursor_isMacroFunctionLike", NM="_Z32clang_Cursor_isMacroFunctionLike",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z32clang_Cursor_isMacroFunctionLike")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isMacroFunctionLike( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a  CXCursor that is a macro, is a
* builtin one.
*/

/**
* \brief Determine whether a  CXCursor that is a macro, is a
* builtin one.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isMacroBuiltin">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3423,
 FQN="clang_Cursor_isMacroBuiltin", NM="_Z27clang_Cursor_isMacroBuiltin",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_Cursor_isMacroBuiltin")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isMacroBuiltin( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a  CXCursor that is a function declaration, is an
* inline declaration.
*/

/**
* \brief Determine whether a  CXCursor that is a function declaration, is an
* inline declaration.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isFunctionInlined">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3435,
 FQN="clang_Cursor_isFunctionInlined", NM="_Z30clang_Cursor_isFunctionInlined",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_Cursor_isFunctionInlined")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isFunctionInlined( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a CXType has the "volatile" qualifier set,
* without looking through typedefs that may have added "volatile" at
* a different level.
*/

/**
* \brief Determine whether a CXType has the "volatile" qualifier set,
* without looking through typedefs that may have added "volatile" at
* a different level.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isVolatileQualifiedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 341,
 FQN="clang_isVolatileQualifiedType", NM="_Z29clang_isVolatileQualifiedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z29clang_isVolatileQualifiedType")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isVolatileQualifiedType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether a CXType has the "restrict" qualifier set,
* without looking through typedefs that may have added "restrict" at a
* different level.
*/

/**
* \brief Determine whether a CXType has the "restrict" qualifier set,
* without looking through typedefs that may have added "restrict" at a
* different level.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isRestrictQualifiedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 346,
 FQN="clang_isRestrictQualifiedType", NM="_Z29clang_isRestrictQualifiedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z29clang_isRestrictQualifiedType")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isRestrictQualifiedType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief For pointer types, returns the type of the pointee.
*/

/**
* \brief For pointer types, returns the type of the pointee.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getPointeeType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 351,
 FQN="clang_getPointeeType", NM="_Z20clang_getPointeeType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z20clang_getPointeeType")
//</editor-fold>
public /*static*/ default  CXType clang_getPointeeType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the cursor for the declaration of the given type.
*/

/**
* \brief Return the cursor for the declaration of the given type.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTypeDeclaration">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 382,
 FQN="clang_getTypeDeclaration", NM="_Z24clang_getTypeDeclaration",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z24clang_getTypeDeclaration")
//</editor-fold>
public /*static*/ default  CXCursor clang_getTypeDeclaration( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Returns the Objective-C type encoding for the specified declaration.
*/

/**
* Returns the Objective-C type encoding for the specified declaration.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getDeclObjCTypeEncoding">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 895,
 FQN="clang_getDeclObjCTypeEncoding", NM="_Z29clang_getDeclObjCTypeEncoding",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z29clang_getDeclObjCTypeEncoding")
//</editor-fold>
public /*static*/ default  CXString clang_getDeclObjCTypeEncoding( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Returns the Objective-C type encoding for the specified CXType.
*/

/**
* Returns the Objective-C type encoding for the specified CXType.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getObjCEncoding">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3390,
 FQN="clang_Type_getObjCEncoding", NM="_Z26clang_Type_getObjCEncoding",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z26clang_Type_getObjCEncoding")
//</editor-fold>
public /*static*/ default  CXString clang_Type_getObjCEncoding( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the spelling of a given CXTypeKind.
*/

/**
* \brief Retrieve the spelling of a given CXTypeKind.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTypeKindSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 443,
 FQN="clang_getTypeKindSpelling", NM="_Z25clang_getTypeKindSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z25clang_getTypeKindSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getTypeKindSpelling( CXTypeKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the calling convention associated with a function type.
*
* If a non-function type is passed in, CXCallingConv_Invalid is returned.
*/

/**
* \brief Retrieve the calling convention associated with a function type.
*
* If a non-function type is passed in, CXCallingConv_Invalid is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getFunctionTypeCallingConv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 521,
 FQN="clang_getFunctionTypeCallingConv", NM="_Z32clang_getFunctionTypeCallingConv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z32clang_getFunctionTypeCallingConv")
//</editor-fold>
public /*static*/ default CXCallingConv clang_getFunctionTypeCallingConv( CXType X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the return type associated with a function type.
*
* If a non-function type is passed in, an invalid type is returned.
*/

/**
* \brief Retrieve the return type associated with a function type.
*
* If a non-function type is passed in, an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getResultType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 585,
 FQN="clang_getResultType", NM="_Z19clang_getResultType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z19clang_getResultType")
//</editor-fold>
public /*static*/ default  CXType clang_getResultType( CXType X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the number of non-variadic parameters associated with a
* function type.
*
* If a non-function type is passed in, -1 is returned.
*/

/**
* \brief Retrieve the number of non-variadic parameters associated with a
* function type.
*
* If a non-function type is passed in, -1 is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumArgTypes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 553,
 FQN="clang_getNumArgTypes", NM="_Z20clang_getNumArgTypes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z20clang_getNumArgTypes")
//</editor-fold>
public /*static*/ default int clang_getNumArgTypes( CXType X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the type of a parameter of a function type.
*
* If a non-function type is passed in or the function does not have enough
* parameters, an invalid type is returned.
*/

/**
* \brief Retrieve the type of a parameter of a function type.
*
* If a non-function type is passed in or the function does not have enough
* parameters, an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getArgType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 569,
 FQN="clang_getArgType", NM="_Z16clang_getArgType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z16clang_getArgType")
//</editor-fold>
public /*static*/ default  CXType clang_getArgType( CXType X, /*uint*/int i) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return 1 if the CXType is a variadic function type, and 0 otherwise.
*/

/**
* \brief Return 1 if the CXType is a variadic function type, and 0 otherwise.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isFunctionTypeVariadic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 507,
 FQN="clang_isFunctionTypeVariadic", NM="_Z28clang_isFunctionTypeVariadic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z28clang_isFunctionTypeVariadic")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isFunctionTypeVariadic( CXType X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the return type associated with a given cursor.
*
* This only returns a valid type if the cursor refers to a function or method.
*/

/**
* \brief Retrieve the return type associated with a given cursor.
*
* This only returns a valid type if the cursor refers to a function or method.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorResultType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 596,
 FQN="clang_getCursorResultType", NM="_Z25clang_getCursorResultType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z25clang_getCursorResultType")
//</editor-fold>
public /*static*/ default  CXType clang_getCursorResultType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return 1 if the CXType is a POD (plain old data) type, and 0
*  otherwise.
*/

/**
* \brief Return 1 if the CXType is a POD (plain old data) type, and 0
*  otherwise.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isPODType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 608,
 FQN="clang_isPODType", NM="_Z15clang_isPODType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z15clang_isPODType")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isPODType( CXType X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the element type of an array, complex, or vector type.
*
* If a type is passed in that is not an array, complex, or vector type,
* an invalid type is returned.
*/

/**
* \brief Return the element type of an array, complex, or vector type.
*
* If a type is passed in that is not an array, complex, or vector type,
* an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getElementType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 618,
 FQN="clang_getElementType", NM="_Z20clang_getElementType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z20clang_getElementType")
//</editor-fold>
public /*static*/ default  CXType clang_getElementType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the number of elements of an array or vector type.
*
* If a type is passed in that is not an array or vector type,
* -1 is returned.
*/

/**
* \brief Return the number of elements of an array or vector type.
*
* If a type is passed in that is not an array or vector type,
* -1 is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumElements">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 650,
 FQN="clang_getNumElements", NM="_Z20clang_getNumElements",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z20clang_getNumElements")
//</editor-fold>
public /*static*/ default /*llong*/long clang_getNumElements( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the element type of an array type.
*
* If a non-array type is passed in, an invalid type is returned.
*/

/**
* \brief Return the element type of an array type.
*
* If a non-array type is passed in, an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getArrayElementType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 670,
 FQN="clang_getArrayElementType", NM="_Z25clang_getArrayElementType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z25clang_getArrayElementType")
//</editor-fold>
public /*static*/ default  CXType clang_getArrayElementType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the array size of a constant array.
*
* If a non-array type is passed in, -1 is returned.
*/

/**
* \brief Return the array size of a constant array.
*
* If a non-array type is passed in, -1 is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getArraySize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 696,
 FQN="clang_getArraySize", NM="_Z18clang_getArraySize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z18clang_getArraySize")
//</editor-fold>
public /*static*/ default /*llong*/long clang_getArraySize( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the type named by the qualified-id.
*
* If a non-elaborated type is passed in, an invalid type is returned.
*/

/**
* \brief Retrieve the type named by the qualified-id.
*
* If a non-elaborated type is passed in, an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getNamedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 994,
 FQN="clang_Type_getNamedType", NM="_Z23clang_Type_getNamedType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z23clang_Type_getNamedType")
//</editor-fold>
public /*static*/ default  CXType clang_Type_getNamedType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the alignment of a type in bytes as per C++[expr.alignof]
*   standard.
*
* If the type declaration is invalid, CXTypeLayoutError_Invalid is returned.
* If the type declaration is an incomplete type, CXTypeLayoutError_Incomplete
*   is returned.
* If the type declaration is a dependent type, CXTypeLayoutError_Dependent is
*   returned.
* If the type declaration is not a constant size type,
*   CXTypeLayoutError_NotConstantSize is returned.
*/

/**
* \brief Return the alignment of a type in bytes as per C++[expr.alignof]
*   standard.
*
* If the type declaration is invalid, CXTypeLayoutError_Invalid is returned.
* If the type declaration is an incomplete type, CXTypeLayoutError_Incomplete
*   is returned.
* If the type declaration is a dependent type, CXTypeLayoutError_Dependent is
*   returned.
* If the type declaration is not a constant size type,
*   CXTypeLayoutError_NotConstantSize is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getAlignOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 713,
 FQN="clang_Type_getAlignOf", NM="_Z21clang_Type_getAlignOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z21clang_Type_getAlignOf")
//</editor-fold>
public /*static*/ default /*llong*/long clang_Type_getAlignOf( CXType T) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the class type of an member pointer type.
*
* If a non-member-pointer type is passed in, an invalid type is returned.
*/

/**
* \brief Return the class type of an member pointer type.
*
* If a non-member-pointer type is passed in, an invalid type is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getClassType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 733,
 FQN="clang_Type_getClassType", NM="_Z23clang_Type_getClassType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z23clang_Type_getClassType")
//</editor-fold>
public /*static*/ default  CXType clang_Type_getClassType( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the size of a type in bytes as per C++[expr.sizeof] standard.
*
* If the type declaration is invalid, CXTypeLayoutError_Invalid is returned.
* If the type declaration is an incomplete type, CXTypeLayoutError_Incomplete
*   is returned.
* If the type declaration is a dependent type, CXTypeLayoutError_Dependent is
*   returned.
*/

/**
* \brief Return the size of a type in bytes as per C++[expr.sizeof] standard.
*
* If the type declaration is invalid, CXTypeLayoutError_Invalid is returned.
* If the type declaration is an incomplete type, CXTypeLayoutError_Incomplete
*   is returned.
* If the type declaration is a dependent type, CXTypeLayoutError_Dependent is
*   returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getSizeOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 744,
 FQN="clang_Type_getSizeOf", NM="_Z20clang_Type_getSizeOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z20clang_Type_getSizeOf")
//</editor-fold>
public /*static*/ default /*llong*/long clang_Type_getSizeOf( CXType T) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the offset of a field named S in a record of type T in bits
*   as it would be returned by __offsetof__ as per C++11[18.2p4]
*
* If the cursor is not a record field declaration, CXTypeLayoutError_Invalid
*   is returned.
* If the field's type declaration is an incomplete type,
*   CXTypeLayoutError_Incomplete is returned.
* If the field's type declaration is a dependent type,
*   CXTypeLayoutError_Dependent is returned.
* If the field's name S is not found,
*   CXTypeLayoutError_InvalidFieldName is returned.
*/

/**
* \brief Return the offset of a field named S in a record of type T in bits
*   as it would be returned by __offsetof__ as per C++11[18.2p4]
*
* If the cursor is not a record field declaration, CXTypeLayoutError_Invalid
*   is returned.
* If the field's type declaration is an incomplete type,
*   CXTypeLayoutError_Incomplete is returned.
* If the field's type declaration is a dependent type,
*   CXTypeLayoutError_Dependent is returned.
* If the field's name S is not found,
*   CXTypeLayoutError_InvalidFieldName is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getOffsetOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 818,
 FQN="clang_Type_getOffsetOf", NM="_Z22clang_Type_getOffsetOf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z22clang_Type_getOffsetOf")
//</editor-fold>
public /*static*/ default /*llong*/long clang_Type_getOffsetOf( CXType PT, /*const*/char$ptr/*char P*/ S) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Return the offset of the field represented by the Cursor.
*
* If the cursor is not a field declaration, -1 is returned.
* If the cursor semantic parent is not a record field declaration,
*   CXTypeLayoutError_Invalid is returned.
* If the field's type declaration is an incomplete type,
*   CXTypeLayoutError_Incomplete is returned.
* If the field's type declaration is a dependent type,
*   CXTypeLayoutError_Dependent is returned.
* If the field's name S is not found,
*   CXTypeLayoutError_InvalidFieldName is returned.
*/

/**
* \brief Return the offset of the field represented by the Cursor.
*
* If the cursor is not a field declaration, -1 is returned.
* If the cursor semantic parent is not a record field declaration,
*   CXTypeLayoutError_Invalid is returned.
* If the field's type declaration is an incomplete type,
*   CXTypeLayoutError_Incomplete is returned.
* If the field's type declaration is a dependent type,
*   CXTypeLayoutError_Dependent is returned.
* If the field's name S is not found,
*   CXTypeLayoutError_InvalidFieldName is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getOffsetOfField">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 849,
 FQN="clang_Cursor_getOffsetOfField", NM="_Z29clang_Cursor_getOffsetOfField",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z29clang_Cursor_getOffsetOfField")
//</editor-fold>
public /*static*/ default /*llong*/long clang_Cursor_getOffsetOfField( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the given cursor represents an anonymous record
* declaration.
*/

/**
* \brief Determine whether the given cursor represents an anonymous record
* declaration.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isAnonymous">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 985,
 FQN="clang_Cursor_isAnonymous", NM="_Z24clang_Cursor_isAnonymous",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z24clang_Cursor_isAnonymous")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isAnonymous( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the number of template arguments for given class template
* specialization, or -1 if type \c T is not a class template specialization.
*
* Variadic argument packs count as only one argument, and can not be inspected
* further.
*/

/**
* \brief Returns the number of template arguments for given class template
* specialization, or -1 if type \c T is not a class template specialization.
*
* Variadic argument packs count as only one argument, and can not be inspected
* further.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getNumTemplateArguments">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 923,
 FQN="clang_Type_getNumTemplateArguments", NM="_Z34clang_Type_getNumTemplateArguments",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z34clang_Type_getNumTemplateArguments")
//</editor-fold>
public /*static*/ default int clang_Type_getNumTemplateArguments( CXType CT) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the type template argument of a template class specialization
* at given index.
*
* This function only returns template type arguments and does not handle
* template template arguments or variadic packs.
*/

/**
* \brief Returns the type template argument of a template class specialization
* at given index.
*
* This function only returns template type arguments and does not handle
* template template arguments or variadic packs.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getTemplateArgumentAsType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 937,
 FQN="clang_Type_getTemplateArgumentAsType", NM="_Z36clang_Type_getTemplateArgumentAsType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z36clang_Type_getTemplateArgumentAsType")
//</editor-fold>
public /*static*/ default  CXType clang_Type_getTemplateArgumentAsType( CXType CT, /*uint*/int i) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the ref-qualifier kind of a function or method.
*
* The ref-qualifier is returned for C++ functions or methods. For other types
* or non-C++ declarations, CXRefQualifier_None is returned.
*/

/**
* \brief Retrieve the ref-qualifier kind of a function or method.
*
* The ref-qualifier is returned for C++ functions or methods. For other types
* or non-C++ declarations, CXRefQualifier_None is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_getCXXRefQualifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 868,
 FQN="clang_Type_getCXXRefQualifier", NM="_Z29clang_Type_getCXXRefQualifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z29clang_Type_getCXXRefQualifier")
//</editor-fold>
public /*static*/ default  CXRefQualifierKind clang_Type_getCXXRefQualifier( CXType T) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if the cursor specifies a Record member that is a
*   bitfield.
*/

/**
* \brief Returns non-zero if the cursor specifies a Record member that is a
*   bitfield.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isBitField">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 886,
 FQN="clang_Cursor_isBitField", NM="_Z23clang_Cursor_isBitField",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z23clang_Cursor_isBitField")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isBitField( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns 1 if the base class specified by the cursor with kind
*   CX_CXXBaseSpecifier is virtual.
*/

/**
* \brief Returns 1 if the base class specified by the cursor with kind
*   CX_CXXBaseSpecifier is virtual.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isVirtualBase">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp", line = 25,
 FQN="clang_isVirtualBase", NM="_Z19clang_isVirtualBase",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp -nm=_Z19clang_isVirtualBase")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isVirtualBase( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the access control level for the referenced object.
*
* If the cursor refers to a C++ declaration, its access control level within its
* parent scope is returned. Otherwise, if the cursor refers to a base specifier or
* access specifier, the specifier itself is returned.
*/

/**
* \brief Returns the access control level for the referenced object.
*
* If the cursor refers to a C++ declaration, its access control level within its
* parent scope is returned. Otherwise, if the cursor refers to a base specifier or
* access specifier, the specifier itself is returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCXXAccessSpecifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp", line = 33,
 FQN="clang_getCXXAccessSpecifier", NM="_Z27clang_getCXXAccessSpecifier",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp -nm=_Z27clang_getCXXAccessSpecifier")
//</editor-fold>
public /*static*/ default  CX_CXXAccessSpecifier clang_getCXXAccessSpecifier( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the storage class for a function or variable declaration.
*
* If the passed in Cursor is not a function or variable declaration,
* CX_SC_Invalid is returned else the storage class.
*/

/**
* \brief Returns the storage class for a function or variable declaration.
*
* If the passed in Cursor is not a function or variable declaration,
* CX_SC_Invalid is returned else the storage class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getStorageClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7135,
 FQN="clang_Cursor_getStorageClass", NM="_Z28clang_Cursor_getStorageClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_Cursor_getStorageClass")
//</editor-fold>
public /*static*/ default  CX_StorageClass clang_Cursor_getStorageClass( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of overloaded declarations referenced by a 
* \c CXCursor_OverloadedDeclRef cursor.
*
* \param cursor The cursor whose overloaded declarations are being queried.
*
* \returns The number of overloaded declarations referenced by \c cursor. If it
* is not a \c CXCursor_OverloadedDeclRef cursor, returns 0.
*/

/**
* \brief Determine the number of overloaded declarations referenced by a 
* \c CXCursor_OverloadedDeclRef cursor.
*
* \param cursor The cursor whose overloaded declarations are being queried.
*
* \returns The number of overloaded declarations referenced by \c cursor. If it
* is not a \c CXCursor_OverloadedDeclRef cursor, returns 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumOverloadedDecls">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5820,
 FQN="clang_getNumOverloadedDecls", NM="_Z27clang_getNumOverloadedDecls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_getNumOverloadedDecls")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getNumOverloadedDecls( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a cursor for one of the overloaded declarations referenced
* by a \c CXCursor_OverloadedDeclRef cursor.
*
* \param cursor The cursor whose overloaded declarations are being queried.
*
* \param index The zero-based index into the set of overloaded declarations in
* the cursor.
*
* \returns A cursor representing the declaration referenced by the given 
* \c cursor at the specified \c index. If the cursor does not have an 
* associated set of overloaded declarations, or if the index is out of bounds,
* returns \c clang_getNullCursor();
*/

/**
* \brief Retrieve a cursor for one of the overloaded declarations referenced
* by a \c CXCursor_OverloadedDeclRef cursor.
*
* \param cursor The cursor whose overloaded declarations are being queried.
*
* \param index The zero-based index into the set of overloaded declarations in
* the cursor.
*
* \returns A cursor representing the declaration referenced by the given 
* \c cursor at the specified \c index. If the cursor does not have an 
* associated set of overloaded declarations, or if the index is out of bounds,
* returns \c clang_getNullCursor();
*/
//<editor-fold defaultstate="collapsed" desc="clang_getOverloadedDecl">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5839,
 FQN="clang_getOverloadedDecl", NM="_Z23clang_getOverloadedDecl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_getOverloadedDecl")
//</editor-fold>
public /*static*/ default  CXCursor clang_getOverloadedDecl( CXCursor cursor, /*uint*/int index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_ATTRIBUTES Information for attributes
*
* @{
*/

/**
* \brief For cursors representing an iboutletcollection attribute,
*  this function returns the collection element type.
*
*/

/**
* @}
*/

/**
* \defgroup CINDEX_ATTRIBUTES Information for attributes
*
* @{
*/

/**
* \brief For cursors representing an iboutletcollection attribute,
*  this function returns the collection element type.
*
*/
//<editor-fold defaultstate="collapsed" desc="clang_getIBOutletCollectionType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7546,
 FQN="clang_getIBOutletCollectionType", NM="_Z31clang_getIBOutletCollectionType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z31clang_getIBOutletCollectionType")
//</editor-fold>
public /*static*/ default  CXType clang_getIBOutletCollectionType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Visit the children of a particular cursor.
*
* This function visits all the direct children of the given cursor,
* invoking the given \p visitor function with the cursors of each
* visited child. The traversal may be recursive, if the visitor returns
* \c CXChildVisit_Recurse. The traversal may also be ended prematurely, if
* the visitor returns \c CXChildVisit_Break.
*
* \param parent the cursor whose child may be visited. All kinds of
* cursors can be visited, including invalid cursors (which, by
* definition, have no children).
*
* \param visitor the visitor function that will be invoked for each
* child of \p parent.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the visitor each time it is invoked.
*
* \returns a non-zero value if the traversal was terminated
* prematurely by the visitor returning \c CXChildVisit_Break.
*/

/**
* \brief Visit the children of a particular cursor.
*
* This function visits all the direct children of the given cursor,
* invoking the given \p visitor function with the cursors of each
* visited child. The traversal may be recursive, if the visitor returns
* \c CXChildVisit_Recurse. The traversal may also be ended prematurely, if
* the visitor returns \c CXChildVisit_Break.
*
* \param parent the cursor whose child may be visited. All kinds of
* cursors can be visited, including invalid cursors (which, by
* definition, have no children).
*
* \param visitor the visitor function that will be invoked for each
* child of \p parent.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the visitor each time it is invoked.
*
* \returns a non-zero value if the traversal was terminated
* prematurely by the visitor returning \c CXChildVisit_Break.
*/
//<editor-fold defaultstate="collapsed" desc="clang_visitChildren">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4035,
 FQN="clang_visitChildren", NM="_Z19clang_visitChildren",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19clang_visitChildren")
//</editor-fold>
public /*static*/ default /*uint*/int clang_visitChildren( CXCursor parent, 
                   CXCursorVisitor visitor, 
                   CXClientData client_data) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_CURSOR_XREF Cross-referencing in the AST
*
* These routines provide the ability to determine references within and
* across translation units, by providing the names of the entities referenced
* by cursors, follow reference cursors to the declarations they reference,
* and associate declarations with their definitions.
*
* @{
*/

/**
* \brief Retrieve a Unified Symbol Resolution (USR) for the entity referenced
* by the given cursor.
*
* A Unified Symbol Resolution (USR) is a string that identifies a particular
* entity (function, class, variable, etc.) within a program. USRs can be
* compared across translation units to determine, e.g., when references in
* one translation refer to an entity defined in another translation unit.
*/

/**
* @}
*/

/**
* \defgroup CINDEX_CURSOR_XREF Cross-referencing in the AST
*
* These routines provide the ability to determine references within and
* across translation units, by providing the names of the entities referenced
* by cursors, follow reference cursors to the declarations they reference,
* and associate declarations with their definitions.
*
* @{
*/

/**
* \brief Retrieve a Unified Symbol Resolution (USR) for the entity referenced
* by the given cursor.
*
* A Unified Symbol Resolution (USR) is a string that identifies a particular
* entity (function, class, variable, etc.) within a program. USRs can be
* compared across translation units to determine, e.g., when references in
* one translation refer to an entity defined in another translation unit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorUSR">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 41,
 FQN="clang_getCursorUSR", NM="_Z18clang_getCursorUSR",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z18clang_getCursorUSR")
//</editor-fold>
public /*static*/ default  CXString clang_getCursorUSR( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C class.
*/

/**
* \brief Construct a USR for a specified Objective-C class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCClass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 113,
 FQN="clang_constructUSR_ObjCClass", NM="_Z28clang_constructUSR_ObjCClass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z28clang_constructUSR_ObjCClass")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCClass(/*const*/char$ptr/*char P*/ name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C category.
*/

/**
* \brief Construct a USR for a specified Objective-C category.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCCategory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 127,
 FQN="clang_constructUSR_ObjCCategory", NM="_Z31clang_constructUSR_ObjCCategory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z31clang_constructUSR_ObjCCategory")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCCategory(/*const*/char$ptr/*char P*/ class_name, 
                               /*const*/char$ptr/*char P*/ category_name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C protocol.
*/

/**
* \brief Construct a USR for a specified Objective-C protocol.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCProtocol">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 120,
 FQN="clang_constructUSR_ObjCProtocol", NM="_Z31clang_constructUSR_ObjCProtocol",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z31clang_constructUSR_ObjCProtocol")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCProtocol(/*const*/char$ptr/*char P*/ name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C instance variable and
*   the USR for its containing class.
*/

/**
* \brief Construct a USR for a specified Objective-C instance variable and
*   the USR for its containing class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCIvar">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 95,
 FQN="clang_constructUSR_ObjCIvar", NM="_Z27clang_constructUSR_ObjCIvar",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z27clang_constructUSR_ObjCIvar")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCIvar(/*const*/char$ptr/*char P*/ name,  CXString classUSR) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C method and
*   the USR for its containing class.
*/

/**
* \brief Construct a USR for a specified Objective-C method and
*   the USR for its containing class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCMethod">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 103,
 FQN="clang_constructUSR_ObjCMethod", NM="_Z29clang_constructUSR_ObjCMethod",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z29clang_constructUSR_ObjCMethod")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCMethod(/*const*/char$ptr/*char P*/ name, 
                             /*uint*/int isInstanceMethod, 
                              CXString classUSR) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Construct a USR for a specified Objective-C property and the USR
*  for its containing class.
*/

/**
* \brief Construct a USR for a specified Objective-C property and the USR
*  for its containing class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_constructUSR_ObjCProperty">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp", line = 135,
 FQN="clang_constructUSR_ObjCProperty", NM="_Z31clang_constructUSR_ObjCProperty",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexUSRs.cpp -nm=_Z31clang_constructUSR_ObjCProperty")
//</editor-fold>
public /*static*/ default  CXString clang_constructUSR_ObjCProperty(/*const*/char$ptr/*char P*/ property, 
                                CXString classUSR) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a name for the entity referenced by this cursor.
*/

/**
* \brief Retrieve a name for the entity referenced by this cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4117,
 FQN="clang_getCursorSpelling", NM="_Z23clang_getCursorSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_getCursorSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getCursorSpelling( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a range for a piece that forms the cursors spelling name.
* Most of the times there is only one range for the complete spelling but for
* Objective-C methods and Objective-C message expressions, there are multiple
* pieces for each selector identifier.
* 
* \param pieceIndex the index of the spelling name piece. If this is greater
* than the actual number of pieces, it will return a NULL (invalid) range.
*  
* \param options Reserved.
*/

/**
* \brief Retrieve a range for a piece that forms the cursors spelling name.
* Most of the times there is only one range for the complete spelling but for
* Objective-C methods and Objective-C message expressions, there are multiple
* pieces for each selector identifier.
* 
* \param pieceIndex the index of the spelling name piece. If this is greater
* than the actual number of pieces, it will return a NULL (invalid) range.
*  
* \param options Reserved.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getSpellingNameRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4278,
 FQN="clang_Cursor_getSpellingNameRange", NM="_Z33clang_Cursor_getSpellingNameRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z33clang_Cursor_getSpellingNameRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_Cursor_getSpellingNameRange( CXCursor C, 
                                 /*uint*/int pieceIndex, 
                                 /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the display name for the entity referenced by this cursor.
*
* The display name contains extra information that helps identify the cursor,
* such as the parameters of a function or template or the arguments of a 
* class template specialization.
*/

/**
* \brief Retrieve the display name for the entity referenced by this cursor.
*
* The display name contains extra information that helps identify the cursor,
* such as the parameters of a function or template or the arguments of a 
* class template specialization.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorDisplayName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4400,
 FQN="clang_getCursorDisplayName", NM="_Z26clang_getCursorDisplayName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z26clang_getCursorDisplayName")
//</editor-fold>
public /*static*/ default  CXString clang_getCursorDisplayName( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** \brief For a cursor that is a reference, retrieve a cursor representing the
* entity that it references.
*
* Reference cursors refer to other entities in the AST. For example, an
* Objective-C superclass reference cursor refers to an Objective-C class.
* This function produces the cursor for the Objective-C class from the
* cursor for the superclass reference. If the input cursor is a declaration or
* definition, it returns that declaration or definition unchanged.
* Otherwise, returns the NULL cursor.
*/

/** \brief For a cursor that is a reference, retrieve a cursor representing the
* entity that it references.
*
* Reference cursors refer to other entities in the AST. For example, an
* Objective-C superclass reference cursor refers to an Objective-C class.
* This function produces the cursor for the Objective-C class from the
* cursor for the superclass reference. If the input cursor is a declaration or
* definition, it returns that declaration or definition unchanged.
* Otherwise, returns the NULL cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorReferenced">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5465,
 FQN="clang_getCursorReferenced", NM="_Z25clang_getCursorReferenced",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_getCursorReferenced")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCursorReferenced( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
*  \brief For a cursor that is either a reference to or a declaration
*  of some entity, retrieve a cursor that describes the definition of
*  that entity.
*
*  Some entities can be declared multiple times within a translation
*  unit, but only one of those declarations can also be a
*  definition. For example, given:
*
*  \code
*  int f(int, int);
*  int g(int x, int y) { return f(x, y); }
*  int f(int a, int b) { return a + b; }
*  int f(int, int);
*  \endcode
*
*  there are three declarations of the function "f", but only the
*  second one is a definition. The clang_getCursorDefinition()
*  function will take any cursor pointing to a declaration of "f"
*  (the first or fourth lines of the example) or a cursor referenced
*  that uses "f" (the call to "f' inside "g") and will return a
*  declaration cursor pointing to the definition (the second "f"
*  declaration).
*
*  If given a cursor for which there is no corresponding definition,
*  e.g., because there is no definition of that entity within this
*  translation unit, returns a NULL cursor.
*/

/**
*  \brief For a cursor that is either a reference to or a declaration
*  of some entity, retrieve a cursor that describes the definition of
*  that entity.
*
*  Some entities can be declared multiple times within a translation
*  unit, but only one of those declarations can also be a
*  definition. For example, given:
*
*  \code
*  int f(int, int);
*  int g(int x, int y) { return f(x, y); }
*  int f(int a, int b) { return a + b; }
*  int f(int, int);
*  \endcode
*
*  there are three declarations of the function "f", but only the
*  second one is a definition. The clang_getCursorDefinition()
*  function will take any cursor pointing to a declaration of "f"
*  (the first or fourth lines of the example) or a cursor referenced
*  that uses "f" (the call to "f' inside "g") and will return a
*  declaration cursor pointing to the definition (the second "f"
*  declaration).
*
*  If given a cursor for which there is no corresponding definition,
*  e.g., because there is no definition of that entity within this
*  translation unit, returns a NULL cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorDefinition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5577,
 FQN="clang_getCursorDefinition", NM="_Z25clang_getCursorDefinition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_getCursorDefinition")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCursorDefinition( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine whether the declaration pointed to by this cursor
* is also a definition of that entity.
*/

/**
* \brief Determine whether the declaration pointed to by this cursor
* is also a definition of that entity.
*/
//<editor-fold defaultstate="collapsed" desc="clang_isCursorDefinition">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5790,
 FQN="clang_isCursorDefinition", NM="_Z24clang_isCursorDefinition",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_isCursorDefinition")
//</editor-fold>
public /*static*/ default /*uint*/int clang_isCursorDefinition( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the canonical cursor corresponding to the given cursor.
*
* In the C family of languages, many kinds of entities can be declared several
* times within a single translation unit. For example, a structure type can
* be forward-declared (possibly multiple times) and later defined:
*
* \code
* struct X;
* struct X;
* struct X {
*   int member;
* };
* \endcode
*
* The declarations and the definition of \c X are represented by three 
* different cursors, all of which are declarations of the same underlying 
* entity. One of these cursor is considered the "canonical" cursor, which
* is effectively the representative for the underlying entity. One can 
* determine if two cursors are declarations of the same underlying entity by
* comparing their canonical cursors.
*
* \returns The canonical cursor for the entity referred to by the given cursor.
*/

/**
* \brief Retrieve the canonical cursor corresponding to the given cursor.
*
* In the C family of languages, many kinds of entities can be declared several
* times within a single translation unit. For example, a structure type can
* be forward-declared (possibly multiple times) and later defined:
*
* \code
* struct X;
* struct X;
* struct X {
*   int member;
* };
* \endcode
*
* The declarations and the definition of \c X are represented by three 
* different cursors, all of which are declarations of the same underlying 
* entity. One of these cursor is considered the "canonical" cursor, which
* is effectively the representative for the underlying entity. One can 
* determine if two cursors are declarations of the same underlying entity by
* comparing their canonical cursors.
*
* \returns The canonical cursor for the entity referred to by the given cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCanonicalCursor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5797,
 FQN="clang_getCanonicalCursor", NM="_Z24clang_getCanonicalCursor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_getCanonicalCursor")
//</editor-fold>
public /*static*/ default  CXCursor clang_getCanonicalCursor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief If the cursor points to a selector identifier in an Objective-C
* method or message expression, this returns the selector index.
*
* After getting a cursor with #clang_getCursor, this can be called to
* determine if the location points to a selector identifier.
*
* \returns The selector index if the cursor is an Objective-C method or message
* expression and the cursor is pointing to a selector identifier, or -1
* otherwise.
*/

/**
* \brief If the cursor points to a selector identifier in an Objective-C
* method or message expression, this returns the selector index.
*
* After getting a cursor with #clang_getCursor, this can be called to
* determine if the location points to a selector identifier.
*
* \returns The selector index if the cursor is an Objective-C method or message
* expression and the cursor is pointing to a selector identifier, or -1
* otherwise.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getObjCSelectorIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5816,
 FQN="clang_Cursor_getObjCSelectorIndex", NM="_Z33clang_Cursor_getObjCSelectorIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z33clang_Cursor_getObjCSelectorIndex")
//</editor-fold>
public /*static*/ default int clang_Cursor_getObjCSelectorIndex( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor pointing to a C++ method call or an Objective-C
* message, returns non-zero if the method/message is "dynamic", meaning:
* 
* For a C++ method: the call is virtual.
* For an Objective-C message: the receiver is an object instance, not 'super'
* or a specific class.
* 
* If the method/message is "static" or the cursor does not point to a
* method/message, it will return zero.
*/

/**
* \brief Given a cursor pointing to a C++ method call or an Objective-C
* message, returns non-zero if the method/message is "dynamic", meaning:
* 
* For a C++ method: the call is virtual.
* For an Objective-C message: the receiver is an object instance, not 'super'
* or a specific class.
* 
* If the method/message is "static" or the cursor does not point to a
* method/message, it will return zero.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isDynamicCall">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1482,
 FQN="clang_Cursor_isDynamicCall", NM="_Z26clang_Cursor_isDynamicCall",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z26clang_Cursor_isDynamicCall")
//</editor-fold>
public /*static*/ default int clang_Cursor_isDynamicCall( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor pointing to an Objective-C message, returns the CXType
* of the receiver.
*/

/**
* \brief Given a cursor pointing to an Objective-C message, returns the CXType
* of the receiver.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getReceiverType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1515,
 FQN="clang_Cursor_getReceiverType", NM="_Z28clang_Cursor_getReceiverType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z28clang_Cursor_getReceiverType")
//</editor-fold>
public /*static*/ default  CXType clang_Cursor_getReceiverType( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents a property declaration, return the
* associated property attributes. The bits are formed from
* \c CXObjCPropertyAttrKind.
*
* \param reserved Reserved for future use, pass 0.
*/

/**
* \brief Given a cursor that represents a property declaration, return the
* associated property attributes. The bits are formed from
* \c CXObjCPropertyAttrKind.
*
* \param reserved Reserved for future use, pass 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getObjCPropertyAttributes">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7211,
 FQN="clang_Cursor_getObjCPropertyAttributes", NM="_Z38clang_Cursor_getObjCPropertyAttributes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z38clang_Cursor_getObjCPropertyAttributes")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_getObjCPropertyAttributes( CXCursor C, /*uint*/int reserved) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents an Objective-C method or parameter
* declaration, return the associated Objective-C qualifiers for the return
* type or the parameter respectively. The bits are formed from
* CXObjCDeclQualifierKind.
*/

/**
* \brief Given a cursor that represents an Objective-C method or parameter
* declaration, return the associated Objective-C qualifiers for the return
* type or the parameter respectively. The bits are formed from
* CXObjCDeclQualifierKind.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getObjCDeclQualifiers">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7241,
 FQN="clang_Cursor_getObjCDeclQualifiers", NM="_Z34clang_Cursor_getObjCDeclQualifiers",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z34clang_Cursor_getObjCDeclQualifiers")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_getObjCDeclQualifiers( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents an Objective-C method or property
* declaration, return non-zero if the declaration was affected by "@optional".
* Returns zero if the cursor is not such a declaration or it is "@required".
*/

/**
* \brief Given a cursor that represents an Objective-C method or property
* declaration, return non-zero if the declaration was affected by "@optional".
* Returns zero if the cursor is not such a declaration or it is "@required".
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isObjCOptional">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7265,
 FQN="clang_Cursor_isObjCOptional", NM="_Z27clang_Cursor_isObjCOptional",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_Cursor_isObjCOptional")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isObjCOptional( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns non-zero if the given cursor is a variadic function or method.
*/

/**
* \brief Returns non-zero if the given cursor is a variadic function or method.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_isVariadic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7278,
 FQN="clang_Cursor_isVariadic", NM="_Z23clang_Cursor_isVariadic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_Cursor_isVariadic")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Cursor_isVariadic( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents a declaration, return the associated
* comment's source range.  The range may include multiple consecutive comments
* with whitespace in between.
*/

/**
* \brief Given a cursor that represents a declaration, return the associated
* comment's source range.  The range may include multiple consecutive comments
* with whitespace in between.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getCommentRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7291,
 FQN="clang_Cursor_getCommentRange", NM="_Z28clang_Cursor_getCommentRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_Cursor_getCommentRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_Cursor_getCommentRange( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents a declaration, return the associated
* comment text, including comment markers.
*/

/**
* \brief Given a cursor that represents a declaration, return the associated
* comment text, including comment markers.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getRawCommentText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7304,
 FQN="clang_Cursor_getRawCommentText", NM="_Z30clang_Cursor_getRawCommentText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_Cursor_getRawCommentText")
//</editor-fold>
public /*static*/ default  CXString clang_Cursor_getRawCommentText( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents a documentable entity (e.g.,
* declaration), return the associated \\brief paragraph; otherwise return the
* first paragraph.
*/

/**
* \brief Given a cursor that represents a documentable entity (e.g.,
* declaration), return the associated \\brief paragraph; otherwise return the
* first paragraph.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getBriefCommentText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7319,
 FQN="clang_Cursor_getBriefCommentText", NM="_Z32clang_Cursor_getBriefCommentText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z32clang_Cursor_getBriefCommentText")
//</editor-fold>
public /*static*/ default  CXString clang_Cursor_getBriefCommentText( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/** \defgroup CINDEX_MANGLE Name Mangling API Functions
*
* @{
*/

/**
* \brief Retrieve the CXString representing the mangled name of the cursor.
*/

/**
* @}
*/

/** \defgroup CINDEX_MANGLE Name Mangling API Functions
*
* @{
*/

/**
* \brief Retrieve the CXString representing the mangled name of the cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getMangling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4372,
 FQN="clang_Cursor_getMangling", NM="_Z24clang_Cursor_getMangling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_Cursor_getMangling")
//</editor-fold>
public /*static*/ default  CXString clang_Cursor_getMangling( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the CXStrings representing the mangled symbols of the C++
* constructor or destructor at the cursor.
*/

/**
* \brief Retrieve the CXStrings representing the mangled symbols of the C++
* constructor or destructor at the cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getCXXManglings">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4386,
 FQN="clang_Cursor_getCXXManglings", NM="_Z28clang_Cursor_getCXXManglings",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_Cursor_getCXXManglings")
//</editor-fold>
public /*static*/ default  CXStringSet /*P*/ clang_Cursor_getCXXManglings( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a CXCursor_ModuleImportDecl cursor, return the associated module.
*/

/**
* \brief Given a CXCursor_ModuleImportDecl cursor, return the associated module.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7338,
 FQN="clang_Cursor_getModule", NM="_Z22clang_Cursor_getModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_Cursor_getModule")
//</editor-fold>
public /*static*/ default CXModule clang_Cursor_getModule( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a CXFile header file, return the module that contains it, if one
* exists.
*/

/**
* \brief Given a CXFile header file, return the module that contains it, if one
* exists.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getModuleForFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7348,
 FQN="clang_getModuleForFile", NM="_Z22clang_getModuleForFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_getModuleForFile")
//</editor-fold>
public /*static*/ default CXModule clang_getModuleForFile(CXTranslationUnit TU, CXFile File) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns the module file where the provided module object came from.
*/

/**
* \param Module a module object.
*
* \returns the module file where the provided module object came from.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getASTFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7364,
 FQN="clang_Module_getASTFile", NM="_Z23clang_Module_getASTFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_Module_getASTFile")
//</editor-fold>
public /*static*/ default CXFile clang_Module_getASTFile(CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns the parent of a sub-module or NULL if the given module is top-level,
* e.g. for 'std.vector' it will return the 'std' module.
*/

/**
* \param Module a module object.
*
* \returns the parent of a sub-module or NULL if the given module is top-level,
* e.g. for 'std.vector' it will return the 'std' module.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7371,
 FQN="clang_Module_getParent", NM="_Z22clang_Module_getParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_Module_getParent")
//</editor-fold>
public /*static*/ default CXModule clang_Module_getParent(CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns the name of the module, e.g. for the 'std.vector' sub-module it
* will return "vector".
*/

/**
* \param Module a module object.
*
* \returns the name of the module, e.g. for the 'std.vector' sub-module it
* will return "vector".
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7378,
 FQN="clang_Module_getName", NM="_Z20clang_Module_getName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z20clang_Module_getName")
//</editor-fold>
public /*static*/ default  CXString clang_Module_getName(CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns the full name of the module, e.g. "std.vector".
*/

/**
* \param Module a module object.
*
* \returns the full name of the module, e.g. "std.vector".
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getFullName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7385,
 FQN="clang_Module_getFullName", NM="_Z24clang_Module_getFullName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_Module_getFullName")
//</editor-fold>
public /*static*/ default  CXString clang_Module_getFullName(CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns non-zero if the module is a system one.
*/

/**
* \param Module a module object.
*
* \returns non-zero if the module is a system one.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_isSystem">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7392,
 FQN="clang_Module_isSystem", NM="_Z21clang_Module_isSystem",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_Module_isSystem")
//</editor-fold>
public /*static*/ default int clang_Module_isSystem(CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \returns the number of top level headers associated with this module.
*/

/**
* \param Module a module object.
*
* \returns the number of top level headers associated with this module.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getNumTopLevelHeaders">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7399,
 FQN="clang_Module_getNumTopLevelHeaders", NM="_Z34clang_Module_getNumTopLevelHeaders",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z34clang_Module_getNumTopLevelHeaders")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Module_getNumTopLevelHeaders(CXTranslationUnit TU, 
                                  CXModule CXMod) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Module a module object.
*
* \param Index top level header index (zero-based).
*
* \returns the specified top level header associated with the module.
*/

/**
* \param Module a module object.
*
* \param Index top level header index (zero-based).
*
* \returns the specified top level header associated with the module.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Module_getTopLevelHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7413,
 FQN="clang_Module_getTopLevelHeader", NM="_Z30clang_Module_getTopLevelHeader",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z30clang_Module_getTopLevelHeader")
//</editor-fold>
public /*static*/ default CXFile clang_Module_getTopLevelHeader(CXTranslationUnit TU, 
                              CXModule CXMod, /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_CPP C++ AST introspection
*
* The routines in this group provide access information in the ASTs specific
* to C++ language features.
*
* @{
*/

/**
* \brief Determine if a C++ constructor is a converting constructor.
*/

/**
* @}
*/

/**
* \defgroup CINDEX_CPP C++ AST introspection
*
* The routines in this group provide access information in the ASTs specific
* to C++ language features.
*
* @{
*/

/**
* \brief Determine if a C++ constructor is a converting constructor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXConstructor_isConvertingConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7469,
 FQN="clang_CXXConstructor_isConvertingConstructor", NM="_Z44clang_CXXConstructor_isConvertingConstructor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z44clang_CXXConstructor_isConvertingConstructor")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXConstructor_isConvertingConstructor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ constructor is a copy constructor.
*/

/**
* \brief Determine if a C++ constructor is a copy constructor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXConstructor_isCopyConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7449,
 FQN="clang_CXXConstructor_isCopyConstructor", NM="_Z38clang_CXXConstructor_isCopyConstructor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z38clang_CXXConstructor_isCopyConstructor")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXConstructor_isCopyConstructor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ constructor is the default constructor.
*/

/**
* \brief Determine if a C++ constructor is the default constructor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXConstructor_isDefaultConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7439,
 FQN="clang_CXXConstructor_isDefaultConstructor", NM="_Z41clang_CXXConstructor_isDefaultConstructor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z41clang_CXXConstructor_isDefaultConstructor")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXConstructor_isDefaultConstructor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ constructor is a move constructor.
*/

/**
* \brief Determine if a C++ constructor is a move constructor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXConstructor_isMoveConstructor">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7459,
 FQN="clang_CXXConstructor_isMoveConstructor", NM="_Z38clang_CXXConstructor_isMoveConstructor",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z38clang_CXXConstructor_isMoveConstructor")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXConstructor_isMoveConstructor( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ field is declared 'mutable'.
*/

/**
* \brief Determine if a C++ field is declared 'mutable'.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXField_isMutable">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7480,
 FQN="clang_CXXField_isMutable", NM="_Z24clang_CXXField_isMutable",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_CXXField_isMutable")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXField_isMutable( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ method is declared '= default'.
*/

/**
* \brief Determine if a C++ method is declared '= default'.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXMethod_isDefaulted">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7510,
 FQN="clang_CXXMethod_isDefaulted", NM="_Z27clang_CXXMethod_isDefaulted",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_CXXMethod_isDefaulted")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXMethod_isDefaulted( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ member function or member function template is
* pure virtual.
*/

/**
* \brief Determine if a C++ member function or member function template is
* pure virtual.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXMethod_isPureVirtual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7490,
 FQN="clang_CXXMethod_isPureVirtual", NM="_Z29clang_CXXMethod_isPureVirtual",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z29clang_CXXMethod_isPureVirtual")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXMethod_isPureVirtual( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ member function or member function template is 
* declared 'static'.
*/

/**
* \brief Determine if a C++ member function or member function template is 
* declared 'static'.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXMethod_isStatic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7520,
 FQN="clang_CXXMethod_isStatic", NM="_Z24clang_CXXMethod_isStatic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_CXXMethod_isStatic")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXMethod_isStatic( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ member function or member function template is
* explicitly declared 'virtual' or if it overrides a virtual method from
* one of the base classes.
*/

/**
* \brief Determine if a C++ member function or member function template is
* explicitly declared 'virtual' or if it overrides a virtual method from
* one of the base classes.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXMethod_isVirtual">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7530,
 FQN="clang_CXXMethod_isVirtual", NM="_Z25clang_CXXMethod_isVirtual",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_CXXMethod_isVirtual")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXMethod_isVirtual( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine if a C++ member function or member function template is
* declared 'const'.
*/

/**
* \brief Determine if a C++ member function or member function template is
* declared 'const'.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CXXMethod_isConst">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7500,
 FQN="clang_CXXMethod_isConst", NM="_Z23clang_CXXMethod_isConst",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_CXXMethod_isConst")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CXXMethod_isConst( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that represents a template, determine
* the cursor kind of the specializations would be generated by instantiating
* the template.
*
* This routine can be used to determine what flavor of function template,
* class template, or class template partial specialization is stored in the
* cursor. For example, it can describe whether a class template cursor is
* declared with "struct", "class" or "union".
*
* \param C The cursor to query. This cursor should represent a template
* declaration.
*
* \returns The cursor kind of the specializations that would be generated
* by instantiating the template \p C. If \p C is not a template, returns
* \c CXCursor_NoDeclFound.
*/

/**
* \brief Given a cursor that represents a template, determine
* the cursor kind of the specializations would be generated by instantiating
* the template.
*
* This routine can be used to determine what flavor of function template,
* class template, or class template partial specialization is stored in the
* cursor. For example, it can describe whether a class template cursor is
* declared with "struct", "class" or "union".
*
* \param C The cursor to query. This cursor should represent a template
* declaration.
*
* \returns The cursor kind of the specializations that would be generated
* by instantiating the template \p C. If \p C is not a template, returns
* \c CXCursor_NoDeclFound.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTemplateCursorKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp", line = 53,
 FQN="clang_getTemplateCursorKind", NM="_Z27clang_getTemplateCursorKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp -nm=_Z27clang_getTemplateCursorKind")
//</editor-fold>
public /*static*/ default  CXCursorKind clang_getTemplateCursorKind( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that may represent a specialization or instantiation
* of a template, retrieve the cursor that represents the template that it
* specializes or from which it was instantiated.
*
* This routine determines the template involved both for explicit 
* specializations of templates and for implicit instantiations of the template,
* both of which are referred to as "specializations". For a class template
* specialization (e.g., \c std::vector<bool>), this routine will return 
* either the primary template (\c std::vector) or, if the specialization was
* instantiated from a class template partial specialization, the class template
* partial specialization. For a class template partial specialization and a
* function template specialization (including instantiations), this
* this routine will return the specialized template.
*
* For members of a class template (e.g., member functions, member classes, or
* static data members), returns the specialized or instantiated member. 
* Although not strictly "templates" in the C++ language, members of class
* templates have the same notions of specializations and instantiations that
* templates do, so this routine treats them similarly.
*
* \param C A cursor that may be a specialization of a template or a member
* of a template.
*
* \returns If the given cursor is a specialization or instantiation of a 
* template or a member thereof, the template or member that it specializes or
* from which it was instantiated. Otherwise, returns a NULL cursor.
*/

/**
* \brief Given a cursor that may represent a specialization or instantiation
* of a template, retrieve the cursor that represents the template that it
* specializes or from which it was instantiated.
*
* This routine determines the template involved both for explicit 
* specializations of templates and for implicit instantiations of the template,
* both of which are referred to as "specializations". For a class template
* specialization (e.g., \c std::vector<bool>), this routine will return 
* either the primary template (\c std::vector) or, if the specialization was
* instantiated from a class template partial specialization, the class template
* partial specialization. For a class template partial specialization and a
* function template specialization (including instantiations), this
* this routine will return the specialized template.
*
* For members of a class template (e.g., member functions, member classes, or
* static data members), returns the specialized or instantiated member. 
* Although not strictly "templates" in the C++ language, members of class
* templates have the same notions of specializations and instantiations that
* templates do, so this routine treats them similarly.
*
* \param C A cursor that may be a specialization of a template or a member
* of a template.
*
* \returns If the given cursor is a specialization or instantiation of a 
* template or a member thereof, the template or member that it specializes or
* from which it was instantiated. Otherwise, returns a NULL cursor.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getSpecializedCursorTemplate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp", line = 85,
 FQN="clang_getSpecializedCursorTemplate", NM="_Z34clang_getSpecializedCursorTemplate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCXX.cpp -nm=_Z34clang_getSpecializedCursorTemplate")
//</editor-fold>
public /*static*/ default  CXCursor clang_getSpecializedCursorTemplate( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Given a cursor that references something else, return the source range
* covering that reference.
*
* \param C A cursor pointing to a member reference, a declaration reference, or
* an operator call.
* \param NameFlags A bitset with three independent flags: 
* CXNameRange_WantQualifier, CXNameRange_WantTemplateArgs, and
* CXNameRange_WantSinglePiece.
* \param PieceIndex For contiguous names or when passing the flag 
* CXNameRange_WantSinglePiece, only one piece with index 0 is 
* available. When the CXNameRange_WantSinglePiece flag is not passed for a
* non-contiguous names, this index can be used to retrieve the individual
* pieces of the name. See also CXNameRange_WantSinglePiece.
*
* \returns The piece of the name pointed to by the given cursor. If there is no
* name, or if the PieceIndex is out-of-range, a null-cursor will be returned.
*/

/**
* \brief Given a cursor that references something else, return the source range
* covering that reference.
*
* \param C A cursor pointing to a member reference, a declaration reference, or
* an operator call.
* \param NameFlags A bitset with three independent flags: 
* CXNameRange_WantQualifier, CXNameRange_WantTemplateArgs, and
* CXNameRange_WantSinglePiece.
* \param PieceIndex For contiguous names or when passing the flag 
* CXNameRange_WantSinglePiece, only one piece with index 0 is 
* available. When the CXNameRange_WantSinglePiece flag is not passed for a
* non-contiguous names, this index can be used to retrieve the individual
* pieces of the name. See also CXNameRange_WantSinglePiece.
*
* \returns The piece of the name pointed to by the given cursor. If there is no
* name, or if the PieceIndex is out-of-range, a null-cursor will be returned.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorReferenceNameRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5887,
 FQN="clang_getCursorReferenceNameRange", NM="_Z33clang_getCursorReferenceNameRange",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z33clang_getCursorReferenceNameRange")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getCursorReferenceNameRange( CXCursor C, /*uint*/int NameFlags, 
                                 /*uint*/int PieceIndex) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the kind of the given token.
*/

/**
* \brief Determine the kind of the given token.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTokenKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5962,
 FQN="clang_getTokenKind", NM="_Z18clang_getTokenKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z18clang_getTokenKind")
//</editor-fold>
public /*static*/ default  CXTokenKind clang_getTokenKind( CXToken CXTok) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the spelling of the given token.
*
* The spelling of a token is the textual representation of that token, e.g.,
* the text of an identifier or keyword.
*/

/**
* \brief Determine the spelling of the given token.
*
* The spelling of a token is the textual representation of that token, e.g.,
* the text of an identifier or keyword.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTokenSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5966,
 FQN="clang_getTokenSpelling", NM="_Z22clang_getTokenSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_getTokenSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getTokenSpelling(CXTranslationUnit TU,  CXToken CXTok) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the source location of the given token.
*/

/**
* \brief Retrieve the source location of the given token.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTokenLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6008,
 FQN="clang_getTokenLocation", NM="_Z22clang_getTokenLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z22clang_getTokenLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_getTokenLocation(CXTranslationUnit TU,  CXToken CXTok) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a source range that covers the given token.
*/

/**
* \brief Retrieve a source range that covers the given token.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getTokenExtent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6022,
 FQN="clang_getTokenExtent", NM="_Z20clang_getTokenExtent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z20clang_getTokenExtent")
//</editor-fold>
public /*static*/ default  CXSourceRange clang_getTokenExtent(CXTranslationUnit TU,  CXToken CXTok) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Tokenize the source code described by the given range into raw
* lexical tokens.
*
* \param TU the translation unit whose text is being tokenized.
*
* \param Range the source range in which text should be tokenized. All of the
* tokens produced by tokenization will fall within this source range,
*
* \param Tokens this pointer will be set to point to the array of tokens
* that occur within the given source range. The returned pointer must be
* freed with clang_disposeTokens() before the translation unit is destroyed.
*
* \param NumTokens will be set to the number of tokens in the \c *Tokens
* array.
*
*/

/**
* \brief Tokenize the source code described by the given range into raw
* lexical tokens.
*
* \param TU the translation unit whose text is being tokenized.
*
* \param Range the source range in which text should be tokenized. All of the
* tokens produced by tokenization will fall within this source range,
*
* \param Tokens this pointer will be set to point to the array of tokens
* that occur within the given source range. The returned pointer must be
* freed with clang_disposeTokens() before the translation unit is destroyed.
*
* \param NumTokens will be set to the number of tokens in the \c *Tokens
* array.
*
*/
//<editor-fold defaultstate="collapsed" desc="clang_tokenize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6108,
 FQN="clang_tokenize", NM="_Z14clang_tokenize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z14clang_tokenize")
//</editor-fold>
public /*static*/ default void clang_tokenize(CXTranslationUnit TU,  CXSourceRange Range, 
               CXToken /*P*/ /*P*/ Tokens, uint$ptr/*uint P*/ NumTokens) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Annotate the given set of tokens by providing cursors for each token
* that can be mapped to a specific entity within the abstract syntax tree.
*
* This token-annotation routine is equivalent to invoking
* clang_getCursor() for the source locations of each of the
* tokens. The cursors provided are filtered, so that only those
* cursors that have a direct correspondence to the token are
* accepted. For example, given a function call \c f(x),
* clang_getCursor() would provide the following cursors:
*
*   * when the cursor is over the 'f', a DeclRefExpr cursor referring to 'f'.
*   * when the cursor is over the '(' or the ')', a CallExpr referring to 'f'.
*   * when the cursor is over the 'x', a DeclRefExpr cursor referring to 'x'.
*
* Only the first and last of these cursors will occur within the
* annotate, since the tokens "f" and "x' directly refer to a function
* and a variable, respectively, but the parentheses are just a small
* part of the full syntax of the function call expression, which is
* not provided as an annotation.
*
* \param TU the translation unit that owns the given tokens.
*
* \param Tokens the set of tokens to annotate.
*
* \param NumTokens the number of tokens in \p Tokens.
*
* \param Cursors an array of \p NumTokens cursors, whose contents will be
* replaced with the cursors corresponding to each token.
*/

/**
* \brief Annotate the given set of tokens by providing cursors for each token
* that can be mapped to a specific entity within the abstract syntax tree.
*
* This token-annotation routine is equivalent to invoking
* clang_getCursor() for the source locations of each of the
* tokens. The cursors provided are filtered, so that only those
* cursors that have a direct correspondence to the token are
* accepted. For example, given a function call \c f(x),
* clang_getCursor() would provide the following cursors:
*
*   * when the cursor is over the 'f', a DeclRefExpr cursor referring to 'f'.
*   * when the cursor is over the '(' or the ')', a CallExpr referring to 'f'.
*   * when the cursor is over the 'x', a DeclRefExpr cursor referring to 'x'.
*
* Only the first and last of these cursors will occur within the
* annotate, since the tokens "f" and "x' directly refer to a function
* and a variable, respectively, but the parentheses are just a small
* part of the full syntax of the function call expression, which is
* not provided as an annotation.
*
* \param TU the translation unit that owns the given tokens.
*
* \param Tokens the set of tokens to annotate.
*
* \param NumTokens the number of tokens in \p Tokens.
*
* \param Cursors an array of \p NumTokens cursors, whose contents will be
* replaced with the cursors corresponding to each token.
*/
//<editor-fold defaultstate="collapsed" desc="clang_annotateTokens">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6821,
 FQN="clang_annotateTokens", NM="_Z20clang_annotateTokens",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z20clang_annotateTokens")
//</editor-fold>
public /*static*/ default void clang_annotateTokens(CXTranslationUnit TU, 
                     CXToken /*P*/ Tokens, /*uint*/int NumTokens, 
                     CXCursor /*P*/ Cursors) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the given set of tokens.
*/

/**
* \brief Free the given set of tokens.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeTokens">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 6145,
 FQN="clang_disposeTokens", NM="_Z19clang_disposeTokens",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z19clang_disposeTokens")
//</editor-fold>
public /*static*/ default void clang_disposeTokens(CXTranslationUnit TU, 
                    CXToken /*P*/ Tokens, /*uint*/int NumTokens) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_DEBUG Debugging facilities
*
* These routines are used for testing and debugging, only, and should not
* be relied upon.
*
* @{
*/

/* for debug/testing */

/**
* @}
*/

/**
* \defgroup CINDEX_DEBUG Debugging facilities
*
* These routines are used for testing and debugging, only, and should not
* be relied upon.
*
* @{
*/

/* for debug/testing */
//<editor-fold defaultstate="collapsed" desc="clang_getCursorKindSpelling">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 4482,
 FQN="clang_getCursorKindSpelling", NM="_Z27clang_getCursorKindSpelling",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z27clang_getCursorKindSpelling")
//</editor-fold>
public /*static*/ default  CXString clang_getCursorKindSpelling( CXCursorKind Kind) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_getDefinitionSpellingAndExtent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5866,
 FQN="clang_getDefinitionSpellingAndExtent", NM="_Z36clang_getDefinitionSpellingAndExtent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z36clang_getDefinitionSpellingAndExtent")
//</editor-fold>
public /*static*/ default void clang_getDefinitionSpellingAndExtent( CXCursor C, 
                                    /*const*/type$ptr<char$ptr>/*char PP*/ startBuf, 
                                    /*const*/type$ptr<char$ptr>/*char PP*/ endBuf, 
                                    uint$ptr/*uint P*/ startLine, 
                                    uint$ptr/*uint P*/ startColumn, 
                                    uint$ptr/*uint P*/ endLine, 
                                    uint$ptr/*uint P*/ endColumn) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_enableStackTraces">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5936,
 FQN="clang_enableStackTraces", NM="_Z23clang_enableStackTraces",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z23clang_enableStackTraces")
//</editor-fold>
public /*static*/ default void clang_enableStackTraces() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_executeOnThread">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 5941,
 FQN="clang_executeOnThread", NM="_Z21clang_executeOnThread",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_executeOnThread")
//</editor-fold>
public /*static*/ default void clang_executeOnThread(VoidPtr2Void fn, Object/*void P*/ user_data, 
                     /*uint*/int stack_size) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the kind of a particular chunk within a completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the kind of the chunk at the index \c chunk_number.
*/

/**
* \brief Determine the kind of a particular chunk within a completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the kind of the chunk at the index \c chunk_number.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionChunkKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 58,
 FQN="clang_getCompletionChunkKind", NM="_Z28clang_getCompletionChunkKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z28clang_getCompletionChunkKind")
//</editor-fold>
public /*static*/ default  CXCompletionChunkKind clang_getCompletionChunkKind(CXCompletionString completion_string, 
                            /*uint*/int chunk_number) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the text associated with a particular chunk within a
* completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the text associated with the chunk at index \c chunk_number.
*/

/**
* \brief Retrieve the text associated with a particular chunk within a
* completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the text associated with the chunk at index \c chunk_number.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionChunkText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 113,
 FQN="clang_getCompletionChunkText", NM="_Z28clang_getCompletionChunkText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z28clang_getCompletionChunkText")
//</editor-fold>
public /*static*/ default  CXString clang_getCompletionChunkText(CXCompletionString completion_string, 
                            /*uint*/int chunk_number) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the completion string associated with a particular chunk
* within a completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the completion string associated with the chunk at index
* \c chunk_number.
*/

/**
* \brief Retrieve the completion string associated with a particular chunk
* within a completion string.
*
* \param completion_string the completion string to query.
*
* \param chunk_number the 0-based index of the chunk in the completion string.
*
* \returns the completion string associated with the chunk at index
* \c chunk_number.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionChunkCompletionString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 151,
 FQN="clang_getCompletionChunkCompletionString", NM="_Z40clang_getCompletionChunkCompletionString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z40clang_getCompletionChunkCompletionString")
//</editor-fold>
public /*static*/ default CXCompletionString clang_getCompletionChunkCompletionString(CXCompletionString completion_string, 
                                        /*uint*/int chunk_number) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the number of chunks in the given code-completion string.
*/

/**
* \brief Retrieve the number of chunks in the given code-completion string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getNumCompletionChunks">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 189,
 FQN="clang_getNumCompletionChunks", NM="_Z28clang_getNumCompletionChunks",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z28clang_getNumCompletionChunks")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getNumCompletionChunks(CXCompletionString completion_string) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the priority of this code completion.
*
* The priority of a code completion indicates how likely it is that this 
* particular completion is the completion that the user will select. The
* priority is selected by various internal heuristics.
*
* \param completion_string The completion string to query.
*
* \returns The priority of this completion string. Smaller values indicate
* higher-priority (more likely) completions.
*/

/**
* \brief Determine the priority of this code completion.
*
* The priority of a code completion indicates how likely it is that this 
* particular completion is the completion that the user will select. The
* priority is selected by various internal heuristics.
*
* \param completion_string The completion string to query.
*
* \returns The priority of this completion string. Smaller values indicate
* higher-priority (more likely) completions.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionPriority">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 194,
 FQN="clang_getCompletionPriority", NM="_Z27clang_getCompletionPriority",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z27clang_getCompletionPriority")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getCompletionPriority(CXCompletionString completion_string) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the availability of the entity that this code-completion
* string refers to.
*
* \param completion_string The completion string to query.
*
* \returns The availability of the completion string.
*/

/**
* \brief Determine the availability of the entity that this code-completion
* string refers to.
*
* \param completion_string The completion string to query.
*
* \returns The availability of the completion string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionAvailability">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 199,
 FQN="clang_getCompletionAvailability", NM="_Z31clang_getCompletionAvailability",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z31clang_getCompletionAvailability")
//</editor-fold>
public /*static*/ default  CXAvailabilityKind clang_getCompletionAvailability(CXCompletionString completion_string) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the number of annotations associated with the given
* completion string.
*
* \param completion_string the completion string to query.
*
* \returns the number of annotations associated with the given completion
* string.
*/

/**
* \brief Retrieve the number of annotations associated with the given
* completion string.
*
* \param completion_string the completion string to query.
*
* \returns the number of annotations associated with the given completion
* string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionNumAnnotations">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 206,
 FQN="clang_getCompletionNumAnnotations", NM="_Z33clang_getCompletionNumAnnotations",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z33clang_getCompletionNumAnnotations")
//</editor-fold>
public /*static*/ default /*uint*/int clang_getCompletionNumAnnotations(CXCompletionString completion_string) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the annotation associated with the given completion string.
*
* \param completion_string the completion string to query.
*
* \param annotation_number the 0-based index of the annotation of the
* completion string.
*
* \returns annotation string associated with the completion at index
* \c annotation_number, or a NULL string if that annotation is not available.
*/

/**
* \brief Retrieve the annotation associated with the given completion string.
*
* \param completion_string the completion string to query.
*
* \param annotation_number the 0-based index of the annotation of the
* completion string.
*
* \returns annotation string associated with the completion at index
* \c annotation_number, or a NULL string if that annotation is not available.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionAnnotation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 212,
 FQN="clang_getCompletionAnnotation", NM="_Z29clang_getCompletionAnnotation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z29clang_getCompletionAnnotation")
//</editor-fold>
public /*static*/ default  CXString clang_getCompletionAnnotation(CXCompletionString completion_string, 
                             /*uint*/int annotation_number) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the parent context of the given completion string.
*
* The parent context of a completion string is the semantic parent of 
* the declaration (if any) that the code completion represents. For example,
* a code completion for an Objective-C method would have the method's class
* or protocol as its context.
*
* \param completion_string The code completion string whose parent is
* being queried.
*
* \param kind DEPRECATED: always set to CXCursor_NotImplemented if non-NULL.
*
* \returns The name of the completion parent, e.g., "NSObject" if
* the completion string represents a method in the NSObject class.
*/

/**
* \brief Retrieve the parent context of the given completion string.
*
* The parent context of a completion string is the semantic parent of 
* the declaration (if any) that the code completion represents. For example,
* a code completion for an Objective-C method would have the method's class
* or protocol as its context.
*
* \param completion_string The code completion string whose parent is
* being queried.
*
* \param kind DEPRECATED: always set to CXCursor_NotImplemented if non-NULL.
*
* \returns The name of the completion parent, e.g., "NSObject" if
* the completion string represents a method in the NSObject class.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionParent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 219,
 FQN="clang_getCompletionParent", NM="_Z25clang_getCompletionParent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z25clang_getCompletionParent")
//</editor-fold>
public /*static*/ default  CXString clang_getCompletionParent(CXCompletionString completion_string, 
                         CXCursorKind /*P*/ kind) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the brief documentation comment attached to the declaration
* that corresponds to the given completion string.
*/

/**
* \brief Retrieve the brief documentation comment attached to the declaration
* that corresponds to the given completion string.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCompletionBriefComment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 232,
 FQN="clang_getCompletionBriefComment", NM="_Z31clang_getCompletionBriefComment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z31clang_getCompletionBriefComment")
//</editor-fold>
public /*static*/ default  CXString clang_getCompletionBriefComment(CXCompletionString completion_string) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a completion string for an arbitrary declaration or macro
* definition cursor.
*
* \param cursor The cursor to query.
*
* \returns A non-context-sensitive completion string for declaration and macro
* definition cursors, or NULL for other kinds of cursors.
*/

/**
* \brief Retrieve a completion string for an arbitrary declaration or macro
* definition cursor.
*
* \param cursor The cursor to query.
*
* \returns A non-context-sensitive completion string for declaration and macro
* definition cursors, or NULL for other kinds of cursors.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getCursorCompletionString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp", line = 1347,
 FQN="clang_getCursorCompletionString", NM="_Z31clang_getCursorCompletionString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCursor.cpp -nm=_Z31clang_getCursorCompletionString")
//</editor-fold>
public /*static*/ default CXCompletionString clang_getCursorCompletionString( CXCursor cursor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns a default set of code-completion options that can be
* passed to\c clang_codeCompleteAt(). 
*/

/**
* \brief Returns a default set of code-completion options that can be
* passed to\c clang_codeCompleteAt(). 
*/
//<editor-fold defaultstate="collapsed" desc="clang_defaultCodeCompleteOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 837,
 FQN="clang_defaultCodeCompleteOptions", NM="_Z32clang_defaultCodeCompleteOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z32clang_defaultCodeCompleteOptions")
//</editor-fold>
public /*static*/ default /*uint*/int clang_defaultCodeCompleteOptions() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Perform code completion at a given location in a translation unit.
*
* This function performs code completion at a particular file, line, and
* column within source code, providing results that suggest potential
* code snippets based on the context of the completion. The basic model
* for code completion is that Clang will parse a complete source file,
* performing syntax checking up to the location where code-completion has
* been requested. At that point, a special code-completion token is passed
* to the parser, which recognizes this token and determines, based on the
* current location in the C/Objective-C/C++ grammar and the state of
* semantic analysis, what completions to provide. These completions are
* returned via a new \c CXCodeCompleteResults structure.
*
* Code completion itself is meant to be triggered by the client when the
* user types punctuation characters or whitespace, at which point the
* code-completion location will coincide with the cursor. For example, if \c p
* is a pointer, code-completion might be triggered after the "-" and then
* after the ">" in \c p->. When the code-completion location is afer the ">",
* the completion results will provide, e.g., the members of the struct that
* "p" points to. The client is responsible for placing the cursor at the
* beginning of the token currently being typed, then filtering the results
* based on the contents of the token. For example, when code-completing for
* the expression \c p->get, the client should provide the location just after
* the ">" (e.g., pointing at the "g") to this code-completion hook. Then, the
* client can filter the results based on the current token text ("get"), only
* showing those results that start with "get". The intent of this interface
* is to separate the relatively high-latency acquisition of code-completion
* results from the filtering of results on a per-character basis, which must
* have a lower latency.
*
* \param TU The translation unit in which code-completion should
* occur. The source files for this translation unit need not be
* completely up-to-date (and the contents of those source files may
* be overridden via \p unsaved_files). Cursors referring into the
* translation unit may be invalidated by this invocation.
*
* \param complete_filename The name of the source file where code
* completion should be performed. This filename may be any file
* included in the translation unit.
*
* \param complete_line The line at which code-completion should occur.
*
* \param complete_column The column at which code-completion should occur.
* Note that the column should point just after the syntactic construct that
* initiated code completion, and not in the middle of a lexical token.
*
* \param unsaved_files the Files that have not yet been saved to disk
* but may be required for parsing or code completion, including the
* contents of those files.  The contents and name of these files (as
* specified by CXUnsavedFile) are copied when necessary, so the
* client only needs to guarantee their validity until the call to
* this function returns.
*
* \param num_unsaved_files The number of unsaved file entries in \p
* unsaved_files.
*
* \param options Extra options that control the behavior of code
* completion, expressed as a bitwise OR of the enumerators of the
* CXCodeComplete_Flags enumeration. The 
* \c clang_defaultCodeCompleteOptions() function returns a default set
* of code-completion options.
*
* \returns If successful, a new \c CXCodeCompleteResults structure
* containing code-completion results, which should eventually be
* freed with \c clang_disposeCodeCompleteResults(). If code
* completion fails, returns NULL.
*/

/**
* \brief Perform code completion at a given location in a translation unit.
*
* This function performs code completion at a particular file, line, and
* column within source code, providing results that suggest potential
* code snippets based on the context of the completion. The basic model
* for code completion is that Clang will parse a complete source file,
* performing syntax checking up to the location where code-completion has
* been requested. At that point, a special code-completion token is passed
* to the parser, which recognizes this token and determines, based on the
* current location in the C/Objective-C/C++ grammar and the state of
* semantic analysis, what completions to provide. These completions are
* returned via a new \c CXCodeCompleteResults structure.
*
* Code completion itself is meant to be triggered by the client when the
* user types punctuation characters or whitespace, at which point the
* code-completion location will coincide with the cursor. For example, if \c p
* is a pointer, code-completion might be triggered after the "-" and then
* after the ">" in \c p->. When the code-completion location is afer the ">",
* the completion results will provide, e.g., the members of the struct that
* "p" points to. The client is responsible for placing the cursor at the
* beginning of the token currently being typed, then filtering the results
* based on the contents of the token. For example, when code-completing for
* the expression \c p->get, the client should provide the location just after
* the ">" (e.g., pointing at the "g") to this code-completion hook. Then, the
* client can filter the results based on the current token text ("get"), only
* showing those results that start with "get". The intent of this interface
* is to separate the relatively high-latency acquisition of code-completion
* results from the filtering of results on a per-character basis, which must
* have a lower latency.
*
* \param TU The translation unit in which code-completion should
* occur. The source files for this translation unit need not be
* completely up-to-date (and the contents of those source files may
* be overridden via \p unsaved_files). Cursors referring into the
* translation unit may be invalidated by this invocation.
*
* \param complete_filename The name of the source file where code
* completion should be performed. This filename may be any file
* included in the translation unit.
*
* \param complete_line The line at which code-completion should occur.
*
* \param complete_column The column at which code-completion should occur.
* Note that the column should point just after the syntactic construct that
* initiated code completion, and not in the middle of a lexical token.
*
* \param unsaved_files the Files that have not yet been saved to disk
* but may be required for parsing or code completion, including the
* contents of those files.  The contents and name of these files (as
* specified by CXUnsavedFile) are copied when necessary, so the
* client only needs to guarantee their validity until the call to
* this function returns.
*
* \param num_unsaved_files The number of unsaved file entries in \p
* unsaved_files.
*
* \param options Extra options that control the behavior of code
* completion, expressed as a bitwise OR of the enumerators of the
* CXCodeComplete_Flags enumeration. The 
* \c clang_defaultCodeCompleteOptions() function returns a default set
* of code-completion options.
*
* \returns If successful, a new \c CXCodeCompleteResults structure
* containing code-completion results, which should eventually be
* freed with \c clang_disposeCodeCompleteResults(). If code
* completion fails, returns NULL.
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteAt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 798,
 FQN="clang_codeCompleteAt", NM="_Z20clang_codeCompleteAt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z20clang_codeCompleteAt")
//</editor-fold>
public /*static*/ default  CXCodeCompleteResults /*P*/ clang_codeCompleteAt(CXTranslationUnit TU, 
                    /*const*/char$ptr/*char P*/ complete_filename, 
                    /*uint*/int complete_line, 
                    /*uint*/int complete_column, 
                     CXUnsavedFile /*P*/ unsaved_files, 
                    /*uint*/int num_unsaved_files, 
                    /*uint*/int options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Sort the code-completion results in case-insensitive alphabetical 
* order.
*
* \param Results The set of results to sort.
* \param NumResults The number of results in \p Results.
*/

/**
* \brief Sort the code-completion results in case-insensitive alphabetical 
* order.
*
* \param Results The set of results to sort.
* \param NumResults The number of results in \p Results.
*/
//<editor-fold defaultstate="collapsed" desc="clang_sortCodeCompletionResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 994,
 FQN="clang_sortCodeCompletionResults", NM="_Z31clang_sortCodeCompletionResults",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z31clang_sortCodeCompletionResults")
//</editor-fold>
public /*static*/ default void clang_sortCodeCompletionResults( CXCompletionResult /*P*/ Results, 
                               /*uint*/int NumResults) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the given set of code-completion results.
*/

/**
* \brief Free the given set of code-completion results.
*/
//<editor-fold defaultstate="collapsed" desc="clang_disposeCodeCompleteResults">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 841,
 FQN="clang_disposeCodeCompleteResults", NM="_Z32clang_disposeCodeCompleteResults",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z32clang_disposeCodeCompleteResults")
//</editor-fold>
public /*static*/ default void clang_disposeCodeCompleteResults( CXCodeCompleteResults /*P*/ ResultsIn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of diagnostics produced prior to the
* location where code completion was performed.
*/

/**
* \brief Determine the number of diagnostics produced prior to the
* location where code completion was performed.
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetNumDiagnostics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 850,
 FQN="clang_codeCompleteGetNumDiagnostics", NM="_Z35clang_codeCompleteGetNumDiagnostics",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z35clang_codeCompleteGetNumDiagnostics")
//</editor-fold>
public /*static*/ default /*uint*/int clang_codeCompleteGetNumDiagnostics( CXCodeCompleteResults /*P*/ ResultsIn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a diagnostic associated with the given code completion.
*
* \param Results the code completion results to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/

/**
* \brief Retrieve a diagnostic associated with the given code completion.
*
* \param Results the code completion results to query.
* \param Index the zero-based diagnostic number to retrieve.
*
* \returns the requested diagnostic. This diagnostic must be freed
* via a call to \c clang_disposeDiagnostic().
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetDiagnostic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 860,
 FQN="clang_codeCompleteGetDiagnostic", NM="_Z31clang_codeCompleteGetDiagnostic",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z31clang_codeCompleteGetDiagnostic")
//</editor-fold>
public /*static*/ default CXDiagnostic clang_codeCompleteGetDiagnostic( CXCodeCompleteResults /*P*/ ResultsIn, 
                               /*uint*/int Index) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determines what completions are appropriate for the context
* the given code completion.
* 
* \param Results the code completion results to query
*
* \returns the kinds of completions that are appropriate for use
* along with the given code completion results.
*/

/**
* \brief Determines what completions are appropriate for the context
* the given code completion.
* 
* \param Results the code completion results to query
*
* \returns the kinds of completions that are appropriate for use
* along with the given code completion results.
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetContexts">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 875,
 FQN="clang_codeCompleteGetContexts", NM="_Z29clang_codeCompleteGetContexts",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z29clang_codeCompleteGetContexts")
//</editor-fold>
public /*static*/ default /*ullong*/long clang_codeCompleteGetContexts( CXCodeCompleteResults /*P*/ ResultsIn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the cursor kind for the container for the current code
* completion context. The container is only guaranteed to be set for
* contexts where a container exists (i.e. member accesses or Objective-C
* message sends); if there is not a container, this function will return
* CXCursor_InvalidCode.
*
* \param Results the code completion results to query
*
* \param IsIncomplete on return, this value will be false if Clang has complete
* information about the container. If Clang does not have complete
* information, this value will be true.
*
* \returns the container kind, or CXCursor_InvalidCode if there is not a
* container
*/

/**
* \brief Returns the cursor kind for the container for the current code
* completion context. The container is only guaranteed to be set for
* contexts where a container exists (i.e. member accesses or Objective-C
* message sends); if there is not a container, this function will return
* CXCursor_InvalidCode.
*
* \param Results the code completion results to query
*
* \param IsIncomplete on return, this value will be false if Clang has complete
* information about the container. If Clang does not have complete
* information, this value will be true.
*
* \returns the container kind, or CXCursor_InvalidCode if there is not a
* container
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetContainerKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 885,
 FQN="clang_codeCompleteGetContainerKind", NM="_Z34clang_codeCompleteGetContainerKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z34clang_codeCompleteGetContainerKind")
//</editor-fold>
public /*static*/ default  CXCursorKind clang_codeCompleteGetContainerKind( CXCodeCompleteResults /*P*/ ResultsIn, 
                                  uint$ptr/*uint P*/ IsIncomplete) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the USR for the container for the current code completion
* context. If there is not a container for the current context, this
* function will return the empty string.
*
* \param Results the code completion results to query
*
* \returns the USR for the container
*/

/**
* \brief Returns the USR for the container for the current code completion
* context. If there is not a container for the current context, this
* function will return the empty string.
*
* \param Results the code completion results to query
*
* \returns the USR for the container
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetContainerUSR">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 900,
 FQN="clang_codeCompleteGetContainerUSR", NM="_Z33clang_codeCompleteGetContainerUSR",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z33clang_codeCompleteGetContainerUSR")
//</editor-fold>
public /*static*/ default  CXString clang_codeCompleteGetContainerUSR( CXCodeCompleteResults /*P*/ ResultsIn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the currently-entered selector for an Objective-C message
* send, formatted like "initWithFoo:bar:". Only guaranteed to return a
* non-empty string for CXCompletionContext_ObjCInstanceMessage and
* CXCompletionContext_ObjCClassMessage.
*
* \param Results the code completion results to query
*
* \returns the selector (or partial selector) that has been entered thus far
* for an Objective-C message send.
*/

/**
* \brief Returns the currently-entered selector for an Objective-C message
* send, formatted like "initWithFoo:bar:". Only guaranteed to return a
* non-empty string for CXCompletionContext_ObjCInstanceMessage and
* CXCompletionContext_ObjCClassMessage.
*
* \param Results the code completion results to query
*
* \returns the selector (or partial selector) that has been entered thus far
* for an Objective-C message send.
*/
//<editor-fold defaultstate="collapsed" desc="clang_codeCompleteGetObjCSelector">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp", line = 910,
 FQN="clang_codeCompleteGetObjCSelector", NM="_Z33clang_codeCompleteGetObjCSelector",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexCodeCompletion.cpp -nm=_Z33clang_codeCompleteGetObjCSelector")
//</editor-fold>
public /*static*/ default  CXString clang_codeCompleteGetObjCSelector( CXCodeCompleteResults /*P*/ ResultsIn) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* @}
*/

/**
* \defgroup CINDEX_MISC Miscellaneous utility functions
*
* @{
*/

/**
* \brief Return a version string, suitable for showing to a user, but not
*        intended to be parsed (the format is not guaranteed to be stable).
*/

/**
* @}
*/

/**
* \defgroup CINDEX_MISC Miscellaneous utility functions
*
* @{
*/

/**
* \brief Return a version string, suitable for showing to a user, but not
*        intended to be parsed (the format is not guaranteed to be stable).
*/
//<editor-fold defaultstate="collapsed" desc="clang_getClangVersion">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 7931,
 FQN="clang_getClangVersion", NM="_Z21clang_getClangVersion",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_getClangVersion")
//</editor-fold>
public /*static*/ default  CXString clang_getClangVersion() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Enable/disable crash recovery.
*
* \param isEnabled Flag to indicate if crash recovery is enabled.  A non-zero
*        value enables crash recovery, while 0 disables it.
*/

/**
* \brief Enable/disable crash recovery.
*
* \param isEnabled Flag to indicate if crash recovery is enabled.  A non-zero
*        value enables crash recovery, while 0 disables it.
*/
//<editor-fold defaultstate="collapsed" desc="clang_toggleCrashRecovery">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3108,
 FQN="clang_toggleCrashRecovery", NM="_Z25clang_toggleCrashRecovery",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_toggleCrashRecovery")
//</editor-fold>
public /*static*/ default void clang_toggleCrashRecovery(/*uint*/int isEnabled) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Visit the set of preprocessor inclusions in a translation unit.
*   The visitor function is called with the provided data for every included
*   file.  This does not include headers included by the PCH file (unless one
*   is inspecting the inclusions in the PCH file itself).
*/

/**
* \brief Visit the set of preprocessor inclusions in a translation unit.
*   The visitor function is called with the provided data for every included
*   file.  This does not include headers included by the PCH file (unless one
*   is inspecting the inclusions in the PCH file itself).
*/
//<editor-fold defaultstate="collapsed" desc="clang_getInclusions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexInclusionStack.cpp", line = 74,
 FQN="clang_getInclusions", NM="_Z19clang_getInclusions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexInclusionStack.cpp -nm=_Z19clang_getInclusions")
//</editor-fold>
public /*static*/ default void clang_getInclusions(CXTranslationUnit TU, CXInclusionVisitor CB, 
                   CXClientData clientData) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief If cursor is a statement declaration tries to evaluate the 
* statement and if its variable, tries to evaluate its initializer,
* into its corresponding type.
*/

/**
* \brief If cursor is a statement declaration tries to evaluate the 
* statement and if its variable, tries to evaluate its initializer,
* into its corresponding type.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_Evaluate">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3655,
 FQN="clang_Cursor_Evaluate", NM="_Z21clang_Cursor_Evaluate",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z21clang_Cursor_Evaluate")
//</editor-fold>
public /*static*/ default CXEvalResult clang_Cursor_Evaluate( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the kind of the evaluated result.
*/

/**
* \brief Returns the kind of the evaluated result.
*/
//<editor-fold defaultstate="collapsed" desc="clang_EvalResult_getKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3487,
 FQN="clang_EvalResult_getKind", NM="_Z24clang_EvalResult_getKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_EvalResult_getKind")
//</editor-fold>
public /*static*/ default CXEvalResultKind clang_EvalResult_getKind(CXEvalResult E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the evaluation result as integer if the
* kind is Int.
*/

/**
* \brief Returns the evaluation result as integer if the
* kind is Int.
*/
//<editor-fold defaultstate="collapsed" desc="clang_EvalResult_getAsInt">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3494,
 FQN="clang_EvalResult_getAsInt", NM="_Z25clang_EvalResult_getAsInt",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_EvalResult_getAsInt")
//</editor-fold>
public /*static*/ default int clang_EvalResult_getAsInt(CXEvalResult E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the evaluation result as double if the
* kind is double.
*/

/**
* \brief Returns the evaluation result as double if the
* kind is double.
*/
//<editor-fold defaultstate="collapsed" desc="clang_EvalResult_getAsDouble">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3501,
 FQN="clang_EvalResult_getAsDouble", NM="_Z28clang_EvalResult_getAsDouble",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z28clang_EvalResult_getAsDouble")
//</editor-fold>
public /*static*/ default double clang_EvalResult_getAsDouble(CXEvalResult E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Returns the evaluation result as a constant string if the
* kind is other than Int or float. User must not free this pointer,
* instead call clang_EvalResult_dispose on the CXEvalResult returned
* by clang_Cursor_Evaluate.
*/

/**
* \brief Returns the evaluation result as a constant string if the
* kind is other than Int or float. User must not free this pointer,
* instead call clang_EvalResult_dispose on the CXEvalResult returned
* by clang_Cursor_Evaluate.
*/
//<editor-fold defaultstate="collapsed" desc="clang_EvalResult_getAsStr">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3508,
 FQN="clang_EvalResult_getAsStr", NM="_Z25clang_EvalResult_getAsStr",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z25clang_EvalResult_getAsStr")
//</editor-fold>
public /*static*/ default /*const*/char$ptr/*char P*/ clang_EvalResult_getAsStr(CXEvalResult E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Disposes the created Eval memory.
*/

/**
* \brief Disposes the created Eval memory.
*/
//<editor-fold defaultstate="collapsed" desc="clang_EvalResult_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp", line = 3483,
 FQN="clang_EvalResult_dispose", NM="_Z24clang_EvalResult_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z24clang_EvalResult_dispose")
//</editor-fold>
public /*static*/ default void clang_EvalResult_dispose(CXEvalResult E) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a remapping.
*
* \param path the path that contains metadata about remappings.
*
* \returns the requested remapping. This remapping must be freed
* via a call to \c clang_remap_dispose(). Can return NULL if an error occurred.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getRemappings">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp", line = 37,
 FQN="clang_getRemappings", NM="_Z19clang_getRemappings",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp -nm=_Z19clang_getRemappings")
//</editor-fold>
public /*static*/ default CXRemapping clang_getRemappings(/*const*/char$ptr/*char P*/ migrate_dir_path) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve a remapping.
*
* \param filePaths pointer to an array of file paths containing remapping info.
*
* \param numFiles number of file paths.
*
* \returns the requested remapping. This remapping must be freed
* via a call to \c clang_remap_dispose(). Can return NULL if an error occurred.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getRemappingsFromFileList">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp", line = 79,
 FQN="clang_getRemappingsFromFileList", NM="_Z31clang_getRemappingsFromFileList",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp -nm=_Z31clang_getRemappingsFromFileList")
//</editor-fold>
public /*static*/ default CXRemapping clang_getRemappingsFromFileList(/*const*/type$ptr<char$ptr>/*char PP*/ filePaths, 
                               /*uint*/int numFiles) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Determine the number of remappings.
*/
//<editor-fold defaultstate="collapsed" desc="clang_remap_getNumFiles">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp", line = 123,
 FQN="clang_remap_getNumFiles", NM="_Z23clang_remap_getNumFiles",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp -nm=_Z23clang_remap_getNumFiles")
//</editor-fold>
public /*static*/ default /*uint*/int clang_remap_getNumFiles(CXRemapping map) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the original and the associated filename from the remapping.
* 
* \param original If non-NULL, will be set to the original filename.
*
* \param transformed If non-NULL, will be set to the filename that the original
* is associated with.
*/
//<editor-fold defaultstate="collapsed" desc="clang_remap_getFilenames">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp", line = 128,
 FQN="clang_remap_getFilenames", NM="_Z24clang_remap_getFilenames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp -nm=_Z24clang_remap_getFilenames")
//</editor-fold>
public /*static*/ default void clang_remap_getFilenames(CXRemapping map, /*uint*/int index, 
                         type$ptr<CXString> original,  type$ptr<CXString> transformed) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Dispose the remapping.
*/
//<editor-fold defaultstate="collapsed" desc="clang_remap_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp", line = 138,
 FQN="clang_remap_dispose", NM="_Z19clang_remap_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/ARCMigrate.cpp -nm=_Z19clang_remap_dispose")
//</editor-fold>
public /*static*/ default void clang_remap_dispose(CXRemapping map) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Find references of a declaration in a specific file.
* 
* \param cursor pointing to a declaration or a reference of one.
*
* \param file to search for references.
*
* \param visitor callback that will receive pairs of CXCursor/CXSourceRange for
* each reference found.
* The CXSourceRange will point inside the file; if the reference is inside
* a macro (and not a macro argument) the CXSourceRange will be invalid.
*
* \returns one of the CXResult enumerators.
*/

/**
* \brief Find references of a declaration in a specific file.
* 
* \param cursor pointing to a declaration or a reference of one.
*
* \param file to search for references.
*
* \param visitor callback that will receive pairs of CXCursor/CXSourceRange for
* each reference found.
* The CXSourceRange will point inside the file; if the reference is inside
* a macro (and not a macro argument) the CXSourceRange will be invalid.
*
* \returns one of the CXResult enumerators.
*/
//<editor-fold defaultstate="collapsed" desc="clang_findReferencesInFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexHigh.cpp", line = 412,
 FQN="clang_findReferencesInFile", NM="_Z26clang_findReferencesInFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexHigh.cpp -nm=_Z26clang_findReferencesInFile")
//</editor-fold>
public /*static*/ default CXResult clang_findReferencesInFile( CXCursor cursor, CXFile file, 
                           CXCursorAndRangeVisitor visitor) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Find #import/#include directives in a specific file.
*
* \param TU translation unit containing the file to query.
*
* \param file to search for #import/#include directives.
*
* \param visitor callback that will receive pairs of CXCursor/CXSourceRange for
* each directive found.
*
* \returns one of the CXResult enumerators.
*/

/**
* \brief Find #import/#include directives in a specific file.
*
* \param TU translation unit containing the file to query.
*
* \param file to search for #import/#include directives.
*
* \param visitor callback that will receive pairs of CXCursor/CXSourceRange for
* each directive found.
*
* \returns one of the CXResult enumerators.
*/
//<editor-fold defaultstate="collapsed" desc="clang_findIncludesInFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexHigh.cpp", line = 481,
 FQN="clang_findIncludesInFile", NM="_Z24clang_findIncludesInFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndexHigh.cpp -nm=_Z24clang_findIncludesInFile")
//</editor-fold>
public /*static*/ default CXResult clang_findIncludesInFile(CXTranslationUnit TU, CXFile file, 
                         CXCursorAndRangeVisitor visitor) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_isEntityObjCContainerKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 692,
 FQN="clang_index_isEntityObjCContainerKind", NM="_Z37clang_index_isEntityObjCContainerKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z37clang_index_isEntityObjCContainerKind")
//</editor-fold>
public /*static*/ default int clang_index_isEntityObjCContainerKind(CXIdxEntityKind K) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getObjCContainerDeclInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 696,
 FQN="clang_index_getObjCContainerDeclInfo", NM="_Z36clang_index_getObjCContainerDeclInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z36clang_index_getObjCContainerDeclInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxObjCContainerDeclInfo /*P*/ clang_index_getObjCContainerDeclInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getObjCInterfaceDeclInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 709,
 FQN="clang_index_getObjCInterfaceDeclInfo", NM="_Z36clang_index_getObjCInterfaceDeclInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z36clang_index_getObjCInterfaceDeclInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxObjCInterfaceDeclInfo /*P*/ clang_index_getObjCInterfaceDeclInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getObjCCategoryDeclInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 722,
 FQN="clang_index_getObjCCategoryDeclInfo", NM="_Z35clang_index_getObjCCategoryDeclInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z35clang_index_getObjCCategoryDeclInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxObjCCategoryDeclInfo /*P*/ clang_index_getObjCCategoryDeclInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getObjCProtocolRefListInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 735,
 FQN="clang_index_getObjCProtocolRefListInfo", NM="_Z38clang_index_getObjCProtocolRefListInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z38clang_index_getObjCProtocolRefListInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxObjCProtocolRefListInfo /*P*/ clang_index_getObjCProtocolRefListInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getObjCPropertyDeclInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 756,
 FQN="clang_index_getObjCPropertyDeclInfo", NM="_Z35clang_index_getObjCPropertyDeclInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z35clang_index_getObjCPropertyDeclInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxObjCPropertyDeclInfo /*P*/ clang_index_getObjCPropertyDeclInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getIBOutletCollectionAttrInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 768,
 FQN="clang_index_getIBOutletCollectionAttrInfo", NM="_Z41clang_index_getIBOutletCollectionAttrInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z41clang_index_getIBOutletCollectionAttrInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxIBOutletCollectionAttrInfo /*P*/ clang_index_getIBOutletCollectionAttrInfo(/*const*/  CXIdxAttrInfo /*P*/ AInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang_index_getCXXClassDeclInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 781,
 FQN="clang_index_getCXXClassDeclInfo", NM="_Z31clang_index_getCXXClassDeclInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z31clang_index_getCXXClassDeclInfo")
//</editor-fold>
public /*static*/ default /*const*/  CXIdxCXXClassDeclInfo /*P*/ clang_index_getCXXClassDeclInfo(/*const*/  CXIdxDeclInfo /*P*/ DInfo) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief For retrieving a custom CXIdxClientContainer attached to a
* container.
*/

/**
* \brief For retrieving a custom CXIdxClientContainer attached to a
* container.
*/
//<editor-fold defaultstate="collapsed" desc="clang_index_getClientContainer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 793,
 FQN="clang_index_getClientContainer", NM="_Z30clang_index_getClientContainer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z30clang_index_getClientContainer")
//</editor-fold>
public /*static*/ default CXIdxClientContainer clang_index_getClientContainer(/*const*/  CXIdxContainerInfo /*P*/ info) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief For setting a custom CXIdxClientContainer attached to a
* container.
*/

/**
* \brief For setting a custom CXIdxClientContainer attached to a
* container.
*/
//<editor-fold defaultstate="collapsed" desc="clang_index_setClientContainer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 801,
 FQN="clang_index_setClientContainer", NM="_Z30clang_index_setClientContainer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z30clang_index_setClientContainer")
//</editor-fold>
public /*static*/ default void clang_index_setClientContainer(/*const*/  CXIdxContainerInfo /*P*/ info, 
                              CXIdxClientContainer client) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief For retrieving a custom CXIdxClientEntity attached to an entity.
*/

/**
* \brief For retrieving a custom CXIdxClientEntity attached to an entity.
*/
//<editor-fold defaultstate="collapsed" desc="clang_index_getClientEntity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 809,
 FQN="clang_index_getClientEntity", NM="_Z27clang_index_getClientEntity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z27clang_index_getClientEntity")
//</editor-fold>
public /*static*/ default CXIdxClientEntity clang_index_getClientEntity(/*const*/  CXIdxEntityInfo /*P*/ info) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief For setting a custom CXIdxClientEntity attached to an entity.
*/

/**
* \brief For setting a custom CXIdxClientEntity attached to an entity.
*/
//<editor-fold defaultstate="collapsed" desc="clang_index_setClientEntity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 816,
 FQN="clang_index_setClientEntity", NM="_Z27clang_index_setClientEntity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z27clang_index_setClientEntity")
//</editor-fold>
public /*static*/ default void clang_index_setClientEntity(/*const*/  CXIdxEntityInfo /*P*/ info, 
                           CXIdxClientEntity client) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief An indexing action/session, to be applied to one or multiple
* translation units.
*
* \param CIdx The index object with which the index action will be associated.
*/

/**
* \brief An indexing action/session, to be applied to one or multiple
* translation units.
*
* \param CIdx The index object with which the index action will be associated.
*/
//<editor-fold defaultstate="collapsed" desc="clang_IndexAction_create">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 824,
 FQN="clang_IndexAction_create", NM="_Z24clang_IndexAction_create",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z24clang_IndexAction_create")
//</editor-fold>
public /*static*/ default CXIndexAction clang_IndexAction_create(CXIndex CIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Destroy the given index action.
*
* The index action must not be destroyed until all of the translation units
* created within that index action have been destroyed.
*/

/**
* \brief Destroy the given index action.
*
* The index action must not be destroyed until all of the translation units
* created within that index action have been destroyed.
*/
//<editor-fold defaultstate="collapsed" desc="clang_IndexAction_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 828,
 FQN="clang_IndexAction_dispose", NM="_Z25clang_IndexAction_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z25clang_IndexAction_dispose")
//</editor-fold>
public /*static*/ default void clang_IndexAction_dispose(CXIndexAction idxAction) {
  throw new UnsupportedOperationException("EmptyBody");
}

/**
* \brief Index the given source file and the translation unit corresponding
* to that file via callbacks implemented through #IndexerCallbacks.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the invoked callbacks.
*
* \param index_callbacks Pointer to indexing callbacks that the client
* implements.
*
* \param index_callbacks_size Size of #IndexerCallbacks structure that gets
* passed in index_callbacks.
*
* \param index_options A bitmask of options that affects how indexing is
* performed. This should be a bitwise OR of the CXIndexOpt_XXX flags.
*
* \param[out] out_TU pointer to store a \c CXTranslationUnit that can be
* reused after indexing is finished. Set to \c NULL if you do not require it.
*
* \returns 0 on success or if there were errors from which the compiler could
* recover.  If there is a failure from which there is no recovery, returns
* a non-zero \c CXErrorCode.
*
* The rest of the parameters are the same as #clang_parseTranslationUnit.
*/

/**
* \brief Index the given source file and the translation unit corresponding
* to that file via callbacks implemented through #IndexerCallbacks.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the invoked callbacks.
*
* \param index_callbacks Pointer to indexing callbacks that the client
* implements.
*
* \param index_callbacks_size Size of #IndexerCallbacks structure that gets
* passed in index_callbacks.
*
* \param index_options A bitmask of options that affects how indexing is
* performed. This should be a bitwise OR of the CXIndexOpt_XXX flags.
*
* \param[out] out_TU pointer to store a \c CXTranslationUnit that can be
* reused after indexing is finished. Set to \c NULL if you do not require it.
*
* \returns 0 on success or if there were errors from which the compiler could
* recover.  If there is a failure from which there is no recovery, returns
* a non-zero \c CXErrorCode.
*
* The rest of the parameters are the same as #clang_parseTranslationUnit.
*/
//<editor-fold defaultstate="collapsed" desc="clang_indexSourceFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 833,
 FQN="clang_indexSourceFile", NM="_Z21clang_indexSourceFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z21clang_indexSourceFile")
//</editor-fold>
public /*static*/ default int clang_indexSourceFile(CXIndexAction idxAction, 
                     CXClientData client_data, 
                      IndexerCallbacks /*P*/ index_callbacks, 
                     /*uint*/int index_callbacks_size, 
                     /*uint*/int index_options, 
                     /*const*/char$ptr/*char P*/ source_filename, 
                     /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, 
                     int num_command_line_args, 
                      CXUnsavedFile /*P*/ unsaved_files, 
                     /*uint*/int num_unsaved_files, 
                     CXTranslationUnit/*P*/ out_TU, 
                     /*uint*/int TU_options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Same as clang_indexSourceFile but requires a full command line
* for \c command_line_args including argv[0]. This is useful if the standard
* library paths are relative to the binary.
*/

/**
* \brief Same as clang_indexSourceFile but requires a full command line
* for \c command_line_args including argv[0]. This is useful if the standard
* library paths are relative to the binary.
*/
//<editor-fold defaultstate="collapsed" desc="clang_indexSourceFileFullArgv">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 854,
 FQN="clang_indexSourceFileFullArgv", NM="_Z29clang_indexSourceFileFullArgv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z29clang_indexSourceFileFullArgv")
//</editor-fold>
public /*static*/ default int clang_indexSourceFileFullArgv(CXIndexAction idxAction, CXClientData client_data, 
                              IndexerCallbacks /*P*/ index_callbacks, /*uint*/int index_callbacks_size, 
                             /*uint*/int index_options, /*const*/char$ptr/*char P*/ source_filename, 
                             /*const*/type$ptr<char$ptr>/*char P const P*/ command_line_args, int num_command_line_args, 
                              CXUnsavedFile /*P*/ unsaved_files, /*uint*/int num_unsaved_files, 
                             CXTranslationUnit/*P*/ out_TU, /*uint*/int TU_options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Index the given translation unit via callbacks implemented through
* #IndexerCallbacks.
* 
* The order of callback invocations is not guaranteed to be the same as
* when indexing a source file. The high level order will be:
* 
*   -Preprocessor callbacks invocations
*   -Declaration/reference callbacks invocations
*   -Diagnostic callback invocations
*
* The parameters are the same as #clang_indexSourceFile.
* 
* \returns If there is a failure from which there is no recovery, returns
* non-zero, otherwise returns 0.
*/

/**
* \brief Index the given translation unit via callbacks implemented through
* #IndexerCallbacks.
* 
* The order of callback invocations is not guaranteed to be the same as
* when indexing a source file. The high level order will be:
* 
*   -Preprocessor callbacks invocations
*   -Declaration/reference callbacks invocations
*   -Diagnostic callback invocations
*
* The parameters are the same as #clang_indexSourceFile.
* 
* \returns If there is a failure from which there is no recovery, returns
* non-zero, otherwise returns 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_indexTranslationUnit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 917,
 FQN="clang_indexTranslationUnit", NM="_Z26clang_indexTranslationUnit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z26clang_indexTranslationUnit")
//</editor-fold>
public /*static*/ default int clang_indexTranslationUnit(CXIndexAction idxAction, 
                          CXClientData client_data, 
                           IndexerCallbacks /*P*/ index_callbacks, 
                          /*uint*/int index_callbacks_size, 
                          /*uint*/int index_options, 
                          CXTranslationUnit TU) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the CXIdxFile, file, line, column, and offset represented by
* the given CXIdxLoc.
*
* If the location refers into a macro expansion, retrieves the
* location of the macro expansion and if it refers into a macro argument
* retrieves the location of the argument.
*/

/**
* \brief Retrieve the CXIdxFile, file, line, column, and offset represented by
* the given CXIdxLoc.
*
* If the location refers into a macro expansion, retrieves the
* location of the macro expansion and if it refers into a macro argument
* retrieves the location of the argument.
*/
//<editor-fold defaultstate="collapsed" desc="clang_indexLoc_getFileLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 950,
 FQN="clang_indexLoc_getFileLocation", NM="_Z30clang_indexLoc_getFileLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z30clang_indexLoc_getFileLocation")
//</editor-fold>
public /*static*/ default void clang_indexLoc_getFileLocation( CXIdxLoc location, 
                              CXIdxClientFile/*P*/ indexFile, 
                              CXFile/*P*/ file, 
                              uint$ptr/*uint P*/ line, 
                              uint$ptr/*uint P*/ column, 
                              uint$ptr/*uint P*/ offset) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Retrieve the CXSourceLocation represented by the given CXIdxLoc.
*/

/**
* \brief Retrieve the CXSourceLocation represented by the given CXIdxLoc.
*/
//<editor-fold defaultstate="collapsed" desc="clang_indexLoc_getCXSourceLocation">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp", line = 971,
 FQN="clang_indexLoc_getCXSourceLocation", NM="_Z34clang_indexLoc_getCXSourceLocation",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/Indexing.cpp -nm=_Z34clang_indexLoc_getCXSourceLocation")
//</editor-fold>
public /*static*/ default  CXSourceLocation clang_indexLoc_getCXSourceLocation( CXIdxLoc location) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Visit the fields of a particular type.
*
* This function visits all the direct fields of the given cursor,
* invoking the given \p visitor function with the cursors of each
* visited field. The traversal may be ended prematurely, if
* the visitor returns \c CXFieldVisit_Break.
*
* \param T the record type whose field may be visited.
*
* \param visitor the visitor function that will be invoked for each
* field of \p T.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the visitor each time it is invoked.
*
* \returns a non-zero value if the traversal was terminated
* prematurely by the visitor returning \c CXFieldVisit_Break.
*/

/**
* \brief Visit the fields of a particular type.
*
* This function visits all the direct fields of the given cursor,
* invoking the given \p visitor function with the cursors of each
* visited field. The traversal may be ended prematurely, if
* the visitor returns \c CXFieldVisit_Break.
*
* \param T the record type whose field may be visited.
*
* \param visitor the visitor function that will be invoked for each
* field of \p T.
*
* \param client_data pointer data supplied by the client, which will
* be passed to the visitor each time it is invoked.
*
* \returns a non-zero value if the traversal was terminated
* prematurely by the visitor returning \c CXFieldVisit_Break.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Type_visitFields">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp", line = 957,
 FQN="clang_Type_visitFields", NM="_Z22clang_Type_visitFields",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXType.cpp -nm=_Z22clang_Type_visitFields")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Type_visitFields( CXType PT, 
                      CXFieldVisitor visitor, 
                      CXClientData client_data) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class IndexGlobals
