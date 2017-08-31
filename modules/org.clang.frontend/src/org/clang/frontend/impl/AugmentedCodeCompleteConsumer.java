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
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.clangc.*;
import org.clang.sema.*;
import static org.clang.frontend.impl.ASTUnitStatics.*;
import org.clang.frontend.*;
import org.clang.frontend.ASTUnit.*;
import static org.clang.sema.SemaClangGlobals.*;

/// \brief Code completion consumer that combines the cached code-completion
/// results from an ASTUnit with the code-completion results provided to it,
/// then passes the result on to 
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2090,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2080,
 FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerE")
//</editor-fold>
public class AugmentedCodeCompleteConsumer extends /*public*/ CodeCompleteConsumer implements Destructors.ClassWithDestructor {
  private long/*uint64_t*/ NormalContexts;
  private ASTUnit /*&*/ AST;
  private CodeCompleteConsumer /*&*/ Next;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::AugmentedCodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2096,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2086,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::AugmentedCodeCompleteConsumer", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerC1ERN5clang7ASTUnitERNS1_20CodeCompleteConsumerERKNS1_19CodeCompleteOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerC1ERN5clang7ASTUnitERNS1_20CodeCompleteConsumerERKNS1_19CodeCompleteOptionsE")
  //</editor-fold>
  public AugmentedCodeCompleteConsumer(ASTUnit /*&*/ AST, CodeCompleteConsumer /*&*/ Next, 
      /*const*/ CodeCompleteOptions /*&*/ CodeCompleteOpts) {
    // : CodeCompleteConsumer(CodeCompleteOpts, Next.isOutputBinary()), AST(AST), Next(Next) 
    //START JInit
    super(CodeCompleteOpts, Next.isOutputBinary());
    this./*&*/AST=/*&*/AST;
    this./*&*/Next=/*&*/Next;
    //END JInit
    // Compute the set of contexts in which we will look when we don't have
    // any information about the specific context.
    NormalContexts
       = (1L/*LL*/ << CodeCompletionContext.Kind.CCC_TopLevel.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCInterface.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCImplementation.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCIvarList.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Statement.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Expression.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCMessageReceiver.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_DotMemberAccess.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ArrowMemberAccess.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCPropertyAccess.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ObjCProtocolName.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ParenthesizedExpression.getValue())
       | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_Recovery.getValue());
    if (AST.getASTContext().getLangOpts().CPlusPlus) {
      NormalContexts |= (1L/*LL*/ << CodeCompletionContext.Kind.CCC_EnumTag.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_UnionTag.getValue())
         | (1L/*LL*/ << CodeCompletionContext.Kind.CCC_ClassOrStructTag.getValue());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::ProcessCodeCompleteResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2218,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::ProcessCodeCompleteResults", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer26ProcessCodeCompleteResultsERN5clang4SemaENS1_21CodeCompletionContextEPNS1_20CodeCompletionResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer26ProcessCodeCompleteResultsERN5clang4SemaENS1_21CodeCompletionContextEPNS1_20CodeCompletionResultEj")
  //</editor-fold>
  @Override public void ProcessCodeCompleteResults(Sema /*&*/ S, 
                            CodeCompletionContext Context, 
                            type$ptr<CodeCompletionResult/*P*/> Results, 
                            /*uint*/int NumResults)/* override*/ {
    StringSet/*BumpPtrAllocatorImpl*/ HiddenNames = null;
    try {
      // Merge the results we were given with the results we cached.
      boolean AddedResult = false;
      long/*uint64_t*/ InContexts = Context.getKind() == CodeCompletionContext.Kind.CCC_Recovery ? NormalContexts : (1L/*LL*/ << Context.getKind().getValue());
      // Contains the set of names that are hidden by "local" completion results.
      HiddenNames/*J*/= new StringSet/*BumpPtrAllocatorImpl*/();
      /*typedef CodeCompletionResult Result*/
//      final class Result extends CodeCompletionResult{ };
      SmallVector<CodeCompletionResult> AllResults/*J*/= new SmallVector<CodeCompletionResult>(8, new CodeCompletionResult());
      for (std.vector.iterator<CachedCodeCompletionResult /*P*/> C = AST.cached_completion_begin(), 
          CEnd = AST.cached_completion_end();
           $noteq___normal_iterator$C(C, CEnd); C.$preInc()) {
        // If the context we are in matches any of the contexts we are 
        // interested in, we'll add this result.
        if ((C.$arrow().ShowInContexts & InContexts) == 0) {
          continue;
        }
        
        // If we haven't added any results previously, do so now.
        if (!AddedResult) {
          CalculateHiddenNames(Context, Results, NumResults, S.Context, 
              HiddenNames);
          AllResults.insert$T(AllResults.end(), Results, Results.$add(NumResults));
          AddedResult = true;
        }
        
        // Determine whether this global completion result is hidden by a local
        // completion result. If so, skip it.
        if (C.$arrow().Kind != CXCursorKind.CXCursor_MacroDefinition
           && (HiddenNames.count(new StringRef(C.$arrow().Completion.getTypedText())) != 0)) {
          continue;
        }
        
        // Adjust priority based on similar type classes.
        /*uint*/int Priority = C.$arrow().Priority;
        CodeCompletionString /*P*/ Completion = C.$arrow().Completion;
        if (!Context.getPreferredType().isNull()) {
          if (C.$arrow().Kind == CXCursorKind.CXCursor_MacroDefinition) {
            Priority = getMacroUsagePriority(new StringRef(C.$arrow().Completion.getTypedText()), 
                S.getLangOpts(), 
                Context.getPreferredType().$arrow().isAnyPointerType());
          } else if ((C.$arrow().Type != 0)) {
            CanQual<Type> Expected = S.Context.getCanonicalType(Context.getPreferredType().getUnqualifiedType());
            SimplifiedTypeClass ExpectedSTC = getSimplifiedTypeClass(new CanQual<Type>(Expected));
            if (ExpectedSTC == C.$arrow().TypeClass) {
              // We know this type is similar; check for an exact match.
              StringMapUInt/*&*/ CachedCompletionTypes = AST.getCachedCompletionTypes();
              StringMapIteratorUInt Pos = CachedCompletionTypes.find(new StringRef(Expected.$QualType().getAsString()));
              if (Pos.$noteq(CachedCompletionTypes.end()) && Pos.$arrow().second == C.$arrow().Type) {
                Priority = $div_uint(Priority, CCF_ExactTypeMatch);
              } else {
                Priority = $div_uint(Priority, CCF_SimilarTypeMatch);
              }
            }
          }
        }
        
        // Adjust the completion string, if required.
        if (C.$arrow().Kind == CXCursorKind.CXCursor_MacroDefinition
           && Context.getKind() == CodeCompletionContext.Kind.CCC_MacroNameUse) {
          CodeCompletionBuilder Builder = null;
          try {
            // Create a new code-completion string that just contains the
            // macro name, without its arguments.
            Builder/*J*/= new CodeCompletionBuilder(getAllocator(), getCodeCompletionTUInfo(), 
                CCP_CodePattern, C.$arrow().Availability);
            Builder.AddTypedTextChunk(C.$arrow().Completion.getTypedText());
            Priority = CCP_CodePattern;
            Completion = Builder.TakeString();
          } finally {
            if (Builder != null) { Builder.$destroy(); }
          }
        }
        
        AllResults.push_back(new CodeCompletionResult(Completion, Priority, C.$arrow().Kind, 
                C.$arrow().Availability));
      }
      
      // If we did not add any cached completion results, just forward the
      // results we were given to the next consumer.
      if (!AddedResult) {
        Next.ProcessCodeCompleteResults(S, new CodeCompletionContext(Context), Results, NumResults);
        return;
      }
      
      Next.ProcessCodeCompleteResults(S, new CodeCompletionContext(Context), AllResults.data(), 
          AllResults.size());
    } finally {
      if (HiddenNames != null) { HiddenNames.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::ProcessOverloadCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2118,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::ProcessOverloadCandidates", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer25ProcessOverloadCandidatesERN5clang4SemaEjPNS1_20CodeCompleteConsumer17OverloadCandidateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer25ProcessOverloadCandidatesERN5clang4SemaEjPNS1_20CodeCompleteConsumer17OverloadCandidateEj")
  //</editor-fold>
  @Override public void ProcessOverloadCandidates(Sema /*&*/ S, /*uint*/int CurrentArg, 
                           type$ptr<OverloadCandidate> /*P*/ Candidates,
                           /*uint*/int NumCandidates)/* override*/ {
    Next.ProcessOverloadCandidates(S, CurrentArg, Candidates, NumCandidates);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2134,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2124,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::getAllocator", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer12getAllocatorEv")
  //</editor-fold>
  @Override public CodeCompletionAllocator /*&*/ getAllocator()/* override*/ {
    return Next.getAllocator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2138,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2128,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::getCodeCompletionTUInfo", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumer23getCodeCompletionTUInfoEv")
  //</editor-fold>
  @Override public CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo()/* override*/ {
    return Next.getCodeCompletionTUInfo();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AugmentedCodeCompleteConsumer::~AugmentedCodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", line = 2090,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp", old_line = 2080,
   FQN="(anonymous namespace)::AugmentedCodeCompleteConsumer::~AugmentedCodeCompleteConsumer", NM="_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN12_GLOBAL__N_129AugmentedCodeCompleteConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NormalContexts=" + NormalContexts // NOI18N
              + ", AST=" + AST // NOI18N
              + ", Next=" + Next // NOI18N
              + super.toString(); // NOI18N
  }
}
