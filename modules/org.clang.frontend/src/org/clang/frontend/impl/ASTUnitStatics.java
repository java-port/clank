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
package org.clang.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import org.clang.serialization.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTUnitStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL13getOnDiskDataPKN5clang7ASTUnitE;_ZL13serializeUnitRN5clang9ASTWriterERN4llvm15SmallVectorImplIcEERNS_4SemaEbRNS2_11raw_ostreamE;_ZL14getOnDiskMutexv;_ZL15getPreambleFilePKN5clang7ASTUnitE;_ZL15isNonDriverDiagRKN5clang16StoredDiagnosticE;_ZL15setPreambleFilePKN5clang7ASTUnitEN4llvm9StringRefE;_ZL16getOnDiskDataMapv;_ZL17erasePreambleFilePKN5clang7ASTUnitE;_ZL17removeOnDiskEntryPKN5clang7ASTUnitE;_ZL18GetPreamblePCHPathv;_ZL19getDeclShowContextsPKN5clang9NamedDeclERKNS_11LangOptionsERb;_ZL19makeStandaloneFixItRKN5clang13SourceManagerERKNS_11LangOptionsERKNS_9FixItHintE;_ZL19makeStandaloneRangeN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE;_ZL20ActiveASTUnitObjects;_ZL20CalculateHiddenNamesRKN5clang21CodeCompletionContextEPNS_20CodeCompletionResultEjRNS_10ASTContextERN4llvm9StringSetINS7_20BumpPtrAllocatorImplINS7_15MallocAllocatorELj4096ELj4096EEEEE;_ZL21checkAndSanitizeDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEERNS1_13SourceManagerE;_ZL22cleanupOnDiskMapAtExitv;_ZL24makeStandaloneDiagnosticRKN5clang11LangOptionsERKNS_16StoredDiagnosticE;_ZL28checkAndRemoveNonDriverDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEE;_ZL30DefaultPreambleRebuildInterval;_ZN12_GLOBAL__N_128AddTopLevelDeclarationToHashEPN5clang4DeclERj; -static-type=ASTUnitStatics -package=org.clang.frontend.impl")
//</editor-fold>
public final class ASTUnitStatics {

//<editor-fold defaultstate="collapsed" desc="getOnDiskMutex">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 102,
 FQN="getOnDiskMutex", NM="_ZL14getOnDiskMutexv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL14getOnDiskMutexv")
//</editor-fold>
public static SmartMutex/*<false>*//*&*/ getOnDiskMutex() {
  final/*static*/ SmartMutex/*<false>*/ M = getOnDiskMutex$$.M;
  return M;
}
private static final class getOnDiskMutex$$ {
  static final/*static*/ SmartMutex/*<false>*/ M/*J*/= new SmartMutex/*<false>*/(/* recursive = */ true, false);
}

//<editor-fold defaultstate="collapsed" desc="cleanupOnDiskMapAtExit">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 121,
 FQN="cleanupOnDiskMapAtExit", NM="_ZL22cleanupOnDiskMapAtExitv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL22cleanupOnDiskMapAtExitv")
//</editor-fold>
public static void cleanupOnDiskMapAtExit() {
  MutexGuard Guard = null;
  try {
    // Use the mutex because there can be an alive thread destroying an ASTUnit.
    Guard/*J*/= new MutexGuard(getOnDiskMutex());
    final DenseMap<ASTUnit, std_ptr.unique_ptr<OnDiskData>> onDiskDataMap = getOnDiskDataMap();
    for (/*const*/std.pair</*const*/ ASTUnit /*P*/ , unique_ptr<OnDiskData>> /*&*/ I : onDiskDataMap) {
      // We don't worry about freeing the memory associated with OnDiskDataMap.
      // All we care about is erasing stale files.
      I.second.$arrow().Cleanup();
    }
    // JAVA: in java this could be run inside the same VM, so clean up map as well
    onDiskDataMap.clear();
  } finally {
    if (Guard != null) { Guard.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getOnDiskDataMap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 111,
 FQN="getOnDiskDataMap", NM="_ZL16getOnDiskDataMapv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL16getOnDiskDataMapv")
//</editor-fold>
public static DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> > /*&*/ getOnDiskDataMap() {
  final/*static*/ DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> > M = getOnDiskDataMap$$.M;
  synchronized (getOnDiskDataMap$$.class) {
    if (!getOnDiskDataMap$$.hasRegisteredAtExit) {
      getOnDiskDataMap$$.hasRegisteredAtExit = true;
      std.atexit(ASTUnitStatics::cleanupOnDiskMapAtExit);
    }
  }
  return M;
}
private static final class getOnDiskDataMap$$ {
  static final/*static*/ DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> > M/*J*/= new DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> >(DenseMapInfo$LikePtr.$Info(), new std.unique_ptr<>(JD$NullPtr.INSTANCE, null));
  static /*static*/ boolean hasRegisteredAtExit = false;
}

//<editor-fold defaultstate="collapsed" desc="getOnDiskData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 131,
 FQN="getOnDiskData", NM="_ZL13getOnDiskDataPKN5clang7ASTUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL13getOnDiskDataPKN5clang7ASTUnitE")
//</editor-fold>
public static OnDiskData /*&*/ getOnDiskData(/*const*/ ASTUnit /*P*/ AU) {
  MutexGuard Guard = null;
  try {
    // We require the mutex since we are modifying the structure of the
    // DenseMap.
    Guard/*J*/= new MutexGuard(getOnDiskMutex());
    DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> > /*&*/ M = getOnDiskDataMap();
    unique_ptr<OnDiskData> /*&*/ D = M.$at(AU);
    if (!D.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(D.$assignMove($c$.track(llvm.make_unique(new OnDiskData()))));
      } finally {
        $c$.$destroy();
      }
    }
    return D.$star();
  } finally {
    if (Guard != null) { Guard.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="erasePreambleFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 142,
 FQN="erasePreambleFile", NM="_ZL17erasePreambleFilePKN5clang7ASTUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL17erasePreambleFilePKN5clang7ASTUnitE")
//</editor-fold>
public static void erasePreambleFile(/*const*/ ASTUnit /*P*/ AU) {
  getOnDiskData(AU).CleanPreambleFile();
}

//<editor-fold defaultstate="collapsed" desc="removeOnDiskEntry">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 146,
 FQN="removeOnDiskEntry", NM="_ZL17removeOnDiskEntryPKN5clang7ASTUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL17removeOnDiskEntryPKN5clang7ASTUnitE")
//</editor-fold>
public static void removeOnDiskEntry(/*const*/ ASTUnit /*P*/ AU) {
  MutexGuard Guard = null;
  try {
    // We require the mutex since we are modifying the structure of the
    // DenseMap.
    Guard/*J*/= new MutexGuard(getOnDiskMutex());
    DenseMap</*const*/ ASTUnit /*P*/ , std.unique_ptr<OnDiskData> > /*&*/ M = getOnDiskDataMap();
    DenseMapIterator<ASTUnit, std_ptr.unique_ptr<OnDiskData>> I = M.find(AU);
    if (I.$noteq(/*NO_ITER_COPY*/M.end())) {
      I.$arrow().second.$arrow().Cleanup();
      M.erase(I);
    }
  } finally {
    if (Guard != null) { Guard.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="setPreambleFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 158,
 FQN="setPreambleFile", NM="_ZL15setPreambleFilePKN5clang7ASTUnitEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL15setPreambleFilePKN5clang7ASTUnitEN4llvm9StringRefE")
//</editor-fold>
public static void setPreambleFile(/*const*/ ASTUnit /*P*/ AU, StringRef preambleFile) {
  getOnDiskData(AU).PreambleFile.$assignMove(preambleFile.$string());
}

//<editor-fold defaultstate="collapsed" desc="getPreambleFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 162,
 FQN="getPreambleFile", NM="_ZL15getPreambleFilePKN5clang7ASTUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL15getPreambleFilePKN5clang7ASTUnitE")
//</editor-fold>
public static /*const*/std.string/*&*/ getPreambleFile(/*const*/ ASTUnit /*P*/ AU) {
  return getOnDiskData(AU).PreambleFile;
}


/// \brief After failing to build a precompiled preamble (due to
/// errors in the source that occurs in the preamble), the number of
/// reparses during which we'll skip even trying to precompile the
/// preamble.
//<editor-fold defaultstate="collapsed" desc="DefaultPreambleRebuildInterval">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 208,
 FQN="DefaultPreambleRebuildInterval", NM="_ZL30DefaultPreambleRebuildInterval",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL30DefaultPreambleRebuildInterval")
//</editor-fold>
public static /*const*//*uint*/int DefaultPreambleRebuildInterval = 5;

/// \brief Tracks the number of ASTUnit objects that are currently active.
///
/// Used for debugging purposes only.
//<editor-fold defaultstate="collapsed" desc="ActiveASTUnitObjects">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 213,
 FQN="ActiveASTUnitObjects", NM="_ZL20ActiveASTUnitObjects",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL20ActiveASTUnitObjects")
//</editor-fold>
public static std.atomicUInt ActiveASTUnitObjects/*J*/= new std.atomicUInt();

/// \brief Determine the set of code-completion contexts in which this 
/// declaration should be shown.
//<editor-fold defaultstate="collapsed" desc="getDeclShowContexts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 265,
 FQN="getDeclShowContexts", NM="_ZL19getDeclShowContextsPKN5clang9NamedDeclERKNS_11LangOptionsERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL19getDeclShowContextsPKN5clang9NamedDeclERKNS_11LangOptionsERb")
//</editor-fold>
public static /*uint*/int getDeclShowContexts(/*const*/ NamedDecl /*P*/ ND, 
                   /*const*/ LangOptions /*&*/ LangOpts, 
                   bool$ref/*bool &*/ IsNestedNameSpecifier) {
  IsNestedNameSpecifier.$set(false);
  if (isa(UsingShadowDecl.class, ND)) {
    ND = dyn_cast(NamedDecl.class, ND.getUnderlyingDecl$Const());
  }
  if (!(ND != null)) {
    return 0;
  }
  
  long/*uint64_t*/ Contexts = 0;
  if (isa(TypeDecl.class, ND) || isa(ObjCInterfaceDecl.class, ND)
     || isa(ClassTemplateDecl.class, ND) || isa(TemplateTemplateParmDecl.class, ND)) {
    // Types can appear in these contexts.
    if (LangOpts.CPlusPlus || !isa(TagDecl.class, ND)) {
      Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_TopLevel.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCIvarList.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassStructUnion.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Statement.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Type.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ParenthesizedExpression.getValue());
    }
    
    // In C++, types can appear in expressions contexts (for functional casts).
    if (LangOpts.CPlusPlus) {
      Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Expression.getValue());
    }
    
    // In Objective-C, message sends can send interfaces. In Objective-C++,
    // all types are available due to functional casts.
    if (LangOpts.CPlusPlus || isa(ObjCInterfaceDecl.class, ND)) {
      Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCMessageReceiver.getValue());
    }
    
    // In Objective-C, you can only be a subclass of another Objective-C class
    if (isa(ObjCInterfaceDecl.class, ND)) {
      Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCInterfaceName.getValue());
    }
    
    // Deal with tag names.
    if (isa(EnumDecl.class, ND)) {
      Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_EnumTag.getValue());
      
      // Part of the nested-name-specifier in C++0x.
      if (LangOpts.CPlusPlus11) {
        IsNestedNameSpecifier.$set(true);
      }
    } else {
      /*const*/ RecordDecl /*P*/ Record = dyn_cast(RecordDecl.class, ND);
      if ((Record != null)) {
        if (Record.isUnion()) {
          Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_UnionTag.getValue());
        } else {
          Contexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassOrStructTag.getValue());
        }
        if (LangOpts.CPlusPlus) {
          IsNestedNameSpecifier.$set(true);
        }
      } else if (isa(ClassTemplateDecl.class, ND)) {
        IsNestedNameSpecifier.$set(true);
      }
    }
  } else if (isa(ValueDecl.class, ND) || isa(FunctionTemplateDecl.class, ND)) {
    // Values can appear in these contexts.
    Contexts = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Statement.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Expression.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ParenthesizedExpression.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCMessageReceiver.getValue());
  } else if (isa(ObjCProtocolDecl.class, ND)) {
    Contexts = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCProtocolName.getValue());
  } else if (isa(ObjCCategoryDecl.class, ND)) {
    Contexts = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCCategoryName.getValue());
  } else if (isa(NamespaceDecl.class, ND) || isa(NamespaceAliasDecl.class, ND)) {
    Contexts = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Namespace.getValue());
    
    // Part of the nested-name-specifier.
    IsNestedNameSpecifier.$set(true);
  }
  
  return $ulong2uint(Contexts);
}


/// \brief Add the given declaration to the hash of all top-level entities.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddTopLevelDeclarationToHash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 778,
 FQN="(anonymous namespace)::AddTopLevelDeclarationToHash", NM="_ZN12_GLOBAL__N_128AddTopLevelDeclarationToHashEPN5clang4DeclERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_128AddTopLevelDeclarationToHashEPN5clang4DeclERj")
//</editor-fold>
public static void AddTopLevelDeclarationToHash(Decl /*P*/ D, uint$ref/*uint &*/ Hash) {
  if (!(D != null)) {
    return;
  }
  
  DeclContext /*P*/ DC = D.getDeclContext();
  if (!(DC != null)) {
    return;
  }
  if (!(DC.isTranslationUnit() || DC.getLookupParent().isTranslationUnit())) {
    return;
  }
  {
    
    NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
    if ((ND != null)) {
      {
        EnumDecl /*P*/ EnumD = dyn_cast(EnumDecl.class, D);
        if ((EnumD != null)) {
          // For an unscoped enum include the enumerators in the hash since they
          // enter the top-level namespace.
          if (!EnumD.isScoped()) {
            for (/*const*/ EnumConstantDecl /*P*/ EI : EnumD.enumerators()) {
              if ((EI.getIdentifier() != null)) {
                Hash.$set(llvm.HashString(EI.getIdentifier().getName(), Hash.$deref()));
              }
            }
          }
        }
      }
      if ((ND.getIdentifier() != null)) {
        Hash.$set(llvm.HashString(ND.getIdentifier().getName(), Hash.$deref()));
      } else {
        DeclarationName Name = ND.getDeclName();
        if (Name.$bool()) {
          std.string NameStr = Name.getAsString();
          Hash.$set(llvm.HashString(new StringRef(NameStr), Hash.$deref()));
        }
      }
      return;
    }
  }
  {
    
    ImportDecl /*P*/ ImportD = dyn_cast(ImportDecl.class, D);
    if ((ImportD != null)) {
      {
        Module /*P*/ Mod = ImportD.getImportedModule();
        if ((Mod != null)) {
          std.string ModName = Mod.getFullModuleName();
          Hash.$set(llvm.HashString(new StringRef(ModName), Hash.$deref()));
        }
      }
      return;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="isNonDriverDiag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1001,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1000,
 FQN="isNonDriverDiag", NM="_ZL15isNonDriverDiagRKN5clang16StoredDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL15isNonDriverDiagRKN5clang16StoredDiagnosticE")
//</editor-fold>
public static boolean isNonDriverDiag(/*const*/ StoredDiagnostic /*&*/ StoredDiag) {
  return StoredDiag.getLocation().isValid();
}

//<editor-fold defaultstate="collapsed" desc="checkAndRemoveNonDriverDiags">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1005,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1004,
 FQN="checkAndRemoveNonDriverDiags", NM="_ZL28checkAndRemoveNonDriverDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL28checkAndRemoveNonDriverDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEE")
//</editor-fold>
public static void checkAndRemoveNonDriverDiags(SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiags) {
  // Get rid of stored diagnostics except the ones from the driver which do not
  // have a source location.
  StoredDiags.erase(std.remove_if(StoredDiags.begin(), StoredDiags.end(), ASTUnitStatics::isNonDriverDiag), 
      StoredDiags.end());
}

//<editor-fold defaultstate="collapsed" desc="checkAndSanitizeDiags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1014,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1013,
 FQN="checkAndSanitizeDiags", NM="_ZL21checkAndSanitizeDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEERNS1_13SourceManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL21checkAndSanitizeDiagsRN4llvm15SmallVectorImplIN5clang16StoredDiagnosticEEERNS1_13SourceManagerE")
//</editor-fold>
public static void checkAndSanitizeDiags(SmallVectorImpl<StoredDiagnostic> /*&*/ StoredDiagnostics, 
                     SourceManager /*&*/ SM) {
  // The stored diagnostic has the old source manager in it; update
  // the locations to refer into the new source manager. Since we've
  // been careful to make sure that the source manager's state
  // before and after are identical, so that we can reuse the source
  // location itself.
  for (StoredDiagnostic /*&*/ SD : StoredDiagnostics) {
    if (SD.getLocation().isValid()) {
      FullSourceLoc Loc/*J*/= new FullSourceLoc(/*NO_COPY*/SD.getLocation(), SM);
      SD.setLocation(new FullSourceLoc(Loc));
    }
  }
}


/// \brief Simple function to retrieve a path for a preamble precompiled header.
//<editor-fold defaultstate="collapsed" desc="GetPreamblePCHPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1171,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1172,
 FQN="GetPreamblePCHPath", NM="_ZL18GetPreamblePCHPathv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL18GetPreamblePCHPathv")
//</editor-fold>
public static std.string GetPreamblePCHPath() {
  // FIXME: This is a hack so that we can override the preamble file during
  // crash-recovery testing, which is the only case where the preamble files
  // are not necessarily cleaned up.
  /*const*/char$ptr/*char P*/ TmpFile = $tryClone(/*::*/getenv($("CINDEXTEST_PREAMBLE_FILE")));
  if ((TmpFile != null)) {
    return new std.string(TmpFile);
  }
  
  SmallString/*128*/ Path/*J*/= new SmallString/*128*/(128);
  fs.createTemporaryFile(new Twine(/*KEEP_STR*/"preamble"), new StringRef(/*KEEP_STR*/"pch"), Path);
  
  return Path.str().$string();
}

// namespace clang
//<editor-fold defaultstate="collapsed" desc="makeStandaloneRange">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1275,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1276,
 FQN="makeStandaloneRange", NM="_ZL19makeStandaloneRangeN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL19makeStandaloneRangeN5clang15CharSourceRangeERKNS_13SourceManagerERKNS_11LangOptionsE")
//</editor-fold>
public static std.pairUIntUInt makeStandaloneRange(CharSourceRange Range, /*const*/ SourceManager /*&*/ SM, 
                   /*const*/ LangOptions /*&*/ LangOpts) {
  CharSourceRange FileRange = Lexer.makeFileCharRange(new CharSourceRange(Range), SM, LangOpts);
  /*uint*/int Offset = SM.getFileOffset(FileRange.getBegin());
  /*uint*/int EndOffset = SM.getFileOffset(FileRange.getEnd());
  return std.make_pair_uint_uint(Offset, EndOffset);
}

//<editor-fold defaultstate="collapsed" desc="makeStandaloneFixIt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1284,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1285,
 FQN="makeStandaloneFixIt", NM="_ZL19makeStandaloneFixItRKN5clang13SourceManagerERKNS_11LangOptionsERKNS_9FixItHintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL19makeStandaloneFixItRKN5clang13SourceManagerERKNS_11LangOptionsERKNS_9FixItHintE")
//</editor-fold>
public static ASTUnit.StandaloneFixIt makeStandaloneFixIt(/*const*/ SourceManager /*&*/ SM, 
                   /*const*/ LangOptions /*&*/ LangOpts, 
                   /*const*/ FixItHint /*&*/ InFix) {
  ASTUnit.StandaloneFixIt OutFix = null;
  try {
    OutFix/*J*/= new ASTUnit.StandaloneFixIt();
    OutFix.RemoveRange.$assignMove(makeStandaloneRange(new CharSourceRange(InFix.RemoveRange), SM, LangOpts));
    OutFix.InsertFromRange.$assignMove(makeStandaloneRange(new CharSourceRange(InFix.InsertFromRange), SM, 
            LangOpts));
    OutFix.CodeToInsert.$assign(InFix.CodeToInsert);
    OutFix.BeforePreviousInsertions = InFix.BeforePreviousInsertions;
    return new ASTUnit.StandaloneFixIt(JD$Move.INSTANCE, OutFix);
  } finally {
    if (OutFix != null) { OutFix.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="makeStandaloneDiagnostic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 1296,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 1297,
 FQN="makeStandaloneDiagnostic", NM="_ZL24makeStandaloneDiagnosticRKN5clang11LangOptionsERKNS_16StoredDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL24makeStandaloneDiagnosticRKN5clang11LangOptionsERKNS_16StoredDiagnosticE")
//</editor-fold>
public static ASTUnit.StandaloneDiagnostic makeStandaloneDiagnostic(/*const*/ LangOptions /*&*/ LangOpts, 
                        /*const*/ StoredDiagnostic /*&*/ InDiag) {
  ASTUnit.StandaloneDiagnostic OutDiag = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    OutDiag/*J*/= new ASTUnit.StandaloneDiagnostic();
    OutDiag.ID = InDiag.getID();
    OutDiag.Level = InDiag.getLevel();
    OutDiag.Message.$assignMove(InDiag.getMessage().$string());
    OutDiag.LocOffset = 0;
    if (InDiag.getLocation().isInvalid()) {
      return new ASTUnit.StandaloneDiagnostic(JD$Move.INSTANCE, OutDiag);
    }
    /*const*/ SourceManager /*&*/ SM = InDiag.getLocation().getManager();
    SourceLocation FileLoc = SM.getFileLoc(/*NO_COPY*/InDiag.getLocation());
    OutDiag.Filename.$assignMove(SM.getFilename(/*NO_COPY*/FileLoc).$string());
    if (OutDiag.Filename.empty()) {
      return new ASTUnit.StandaloneDiagnostic(JD$Move.INSTANCE, OutDiag);
    }
    OutDiag.LocOffset = SM.getFileOffset(/*NO_COPY*/FileLoc);
    for (/*const*/ CharSourceRange /*&*/ Range : InDiag.getRanges())  {
      OutDiag.Ranges.push_back_T$RR(makeStandaloneRange(new CharSourceRange(Range), SM, LangOpts));
    }
    for (/*const*/ FixItHint /*&*/ FixIt : InDiag.getFixIts())  {
      OutDiag.FixIts.push_back_T$RR($c$.track(makeStandaloneFixIt(SM, LangOpts, FixIt))); $c$.clean();
    }
    
    return new ASTUnit.StandaloneDiagnostic(JD$Move.INSTANCE, OutDiag);
  } finally {
    if (OutDiag != null) { OutDiag.$destroy(); }
    $c$.$destroy();
  }
}

// anonymous namespace

/// \brief Helper function that computes which global names are hidden by the
/// local code-completion results.
//<editor-fold defaultstate="collapsed" desc="CalculateHiddenNames">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2146,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2136,
 FQN="CalculateHiddenNames", NM="_ZL20CalculateHiddenNamesRKN5clang21CodeCompletionContextEPNS_20CodeCompletionResultEjRNS_10ASTContextERN4llvm9StringSetINS7_20BumpPtrAllocatorImplINS7_15MallocAllocatorELj4096ELj4096EEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL20CalculateHiddenNamesRKN5clang21CodeCompletionContextEPNS_20CodeCompletionResultEjRNS_10ASTContextERN4llvm9StringSetINS7_20BumpPtrAllocatorImplINS7_15MallocAllocatorELj4096ELj4096EEEEE")
//</editor-fold>
public static void CalculateHiddenNames(/*const*/ CodeCompletionContext /*&*/ Context, 
                    type$ptr<CodeCompletionResult/*P*/> Results, 
                    /*uint*/int NumResults, 
                    ASTContext /*&*/ Ctx, 
                    StringSet/*BumpPtrAllocatorImpl*/ /*&*/ HiddenNames) {
  boolean OnlyTagNames = false;
  switch (Context.getKind()) {
   case CCC_Recovery:
   case CCC_TopLevel:
   case CCC_ObjCInterface:
   case CCC_ObjCImplementation:
   case CCC_ObjCIvarList:
   case CCC_ClassStructUnion:
   case CCC_Statement:
   case CCC_Expression:
   case CCC_ObjCMessageReceiver:
   case CCC_DotMemberAccess:
   case CCC_ArrowMemberAccess:
   case CCC_ObjCPropertyAccess:
   case CCC_Namespace:
   case CCC_Type:
   case CCC_Name:
   case CCC_PotentiallyQualifiedName:
   case CCC_ParenthesizedExpression:
   case CCC_ObjCInterfaceName:
    break;
   case CCC_EnumTag:
   case CCC_UnionTag:
   case CCC_ClassOrStructTag:
    OnlyTagNames = true;
    break;
   case CCC_ObjCProtocolName:
   case CCC_MacroName:
   case CCC_MacroNameUse:
   case CCC_PreprocessorExpression:
   case CCC_PreprocessorDirective:
   case CCC_NaturalLanguage:
   case CCC_SelectorName:
   case CCC_TypeQualifiers:
   case CCC_Other:
   case CCC_OtherWithMacros:
   case CCC_ObjCInstanceMessage:
   case CCC_ObjCClassMessage:
   case CCC_ObjCCategoryName:
    // We're looking for nothing, or we're looking for names that cannot
    // be hidden.
    return;
  }
  
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  for (/*uint*/int I = 0; I != NumResults; ++I) {
    if (Results.$at(I).Kind != CodeCompletionResult.ResultKind.RK_Declaration) {
      continue;
    }
    
    /*uint*/int IDNS = Results.$at(I).Declaration.getUnderlyingDecl$Const().getIdentifierNamespace();
    
    boolean Hiding = false;
    if (OnlyTagNames) {
      Hiding = ((IDNS & Decl.IdentifierNamespace.IDNS_Tag) != 0);
    } else {
      /*uint*/int HiddenIDNS = (Decl.IdentifierNamespace.IDNS_Type | Decl.IdentifierNamespace.IDNS_Member
         | Decl.IdentifierNamespace.IDNS_Namespace | Decl.IdentifierNamespace.IDNS_Ordinary
         | Decl.IdentifierNamespace.IDNS_NonMemberOperator);
      if (Ctx.getLangOpts().CPlusPlus) {
        HiddenIDNS |= Decl.IdentifierNamespace.IDNS_Tag;
      }
      Hiding = ((IDNS & HiddenIDNS) != 0);
    }
    if (!Hiding) {
      continue;
    }
    
    DeclarationName Name = Results.$at(I).Declaration.getDeclName();
    {
      IdentifierInfo /*P*/ Identifier = Name.getAsIdentifierInfo();
      if ((Identifier != null)) {
        HiddenNames.insert(Identifier.getName());
      } else {
        HiddenNames.insert(new StringRef(Name.getAsString()));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="serializeUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2498,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2488,
 FQN="serializeUnit", NM="_ZL13serializeUnitRN5clang9ASTWriterERN4llvm15SmallVectorImplIcEERNS_4SemaEbRNS2_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZL13serializeUnitRN5clang9ASTWriterERN4llvm15SmallVectorImplIcEERNS_4SemaEbRNS2_11raw_ostreamE")
//</editor-fold>
public static boolean serializeUnit(ASTWriter /*&*/ Writer, 
             SmallString/*&*/ Buffer, 
             Sema /*&*/ S, 
             boolean hasErrors, 
             raw_ostream /*&*/ OS) {
  Writer.WriteAST(S, new std.string(), (Module /*P*/ )null, new StringRef(/*KEEP_STR*/$EMPTY), hasErrors);
  
  // Write the generated bitstream to "Out".
  if (!Buffer.empty()) {
    OS.write(Buffer.data(), Buffer.size());
  }
  
  return false;
}

} // END OF class ASTUnitStatics
