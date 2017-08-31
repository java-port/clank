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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.CodeCompleteConsumerStatics.getOverloadAsString;


/// \brief A simple code-completion consumer that prints the results it
/// receives in a simple format.
//<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 946,
 FQN="clang::PrintingCodeCompleteConsumer", NM="_ZN5clang28PrintingCodeCompleteConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumerE")
//</editor-fold>
public class PrintingCodeCompleteConsumer extends /*public*/ CodeCompleteConsumer implements Destructors.ClassWithDestructor {
  /// \brief The raw output stream.
  private final raw_ostream /*&*/ OS;
  
  private CodeCompletionTUInfo CCTUInfo;
/*public:*/
  /// \brief Create a new printing code-completion consumer that prints its
  /// results to the given raw output stream.
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::PrintingCodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 955,
   FQN="clang::PrintingCodeCompleteConsumer::PrintingCodeCompleteConsumer", NM="_ZN5clang28PrintingCodeCompleteConsumerC1ERKNS_19CodeCompleteOptionsERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumerC1ERKNS_19CodeCompleteOptionsERN4llvm11raw_ostreamE")
  //</editor-fold>
  public PrintingCodeCompleteConsumer(final /*const*/ CodeCompleteOptions /*&*/ CodeCompleteOpts, 
      final raw_ostream /*&*/ OS) {
    // : CodeCompleteConsumer(CodeCompleteOpts, false), OS(OS), CCTUInfo(new GlobalCodeCompletionAllocator) 
    //START JInit
    super(CodeCompleteOpts, false);
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      this./*&*/OS=/*&*/OS;
      this.CCTUInfo = $c$.clean(new CodeCompletionTUInfo($c$.track(new IntrusiveRefCntPtr<GlobalCodeCompletionAllocator>(new GlobalCodeCompletionAllocator()))));
    } finally {
        $c$.$destroy();
    }
    //END JInit
  }

  
  /// \brief Prints the finalized code-completion results.
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::ProcessCodeCompleteResults">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 431,
   FQN="clang::PrintingCodeCompleteConsumer::ProcessCodeCompleteResults", NM="_ZN5clang28PrintingCodeCompleteConsumer26ProcessCodeCompleteResultsERNS_4SemaENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumer26ProcessCodeCompleteResultsERNS_4SemaENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj")
  //</editor-fold>
  @Override public void ProcessCodeCompleteResults(final Sema /*&*/ SemaRef, 
                            CodeCompletionContext Context, 
                            type$ptr<CodeCompletionResult/*P*/> Results, 
                            /*uint*/int NumResults)/* override*/ {
    std.stable_sort(Results, Results.$add(NumResults));
    
    // Print the results.
    for (/*uint*/int I = 0; I != NumResults; ++I) {
      OS.$out(/*KEEP_STR*/"COMPLETION: ");
      switch (Results.$at(I).Kind) {
       case RK_Declaration:
        $out_raw_ostream_NamedDecl$C(OS, $Deref(Results.$at(I).Declaration));
        if (Results.$at(I).Hidden) {
          OS.$out(/*KEEP_STR*/" (Hidden)");
        }
        {
          CodeCompletionString /*P*/ CCS = Results.$at(I).CreateCodeCompletionString(SemaRef, Context, 
              getAllocator(), 
              CCTUInfo, 
              includeBriefComments());
          if ((CCS != null)) {
            OS.$out(/*KEEP_STR*/" : ").$out(CCS.getAsString());
            {
              /*const*/char$ptr/*char P*/ BriefComment = $tryClone(CCS.getBriefComment());
              if ((BriefComment != null)) {
                OS.$out(/*KEEP_STR*/" : ").$out(BriefComment);
              }
            }
          }
        }
        
        OS.$out_char($$LF);
        break;
       case RK_Keyword:
        OS.$out(Results.$at(I).Unnamed_field1.Keyword).$out_char($$LF);
        break;
       case RK_Macro:
        {
          OS.$out(Results.$at(I).Unnamed_field1.Macro.getName());
          {
            CodeCompletionString /*P*/ CCS = Results.$at(I).CreateCodeCompletionString(SemaRef, Context, 
                getAllocator(), 
                CCTUInfo, 
                includeBriefComments());
            if ((CCS != null)) {
              OS.$out(/*KEEP_STR*/" : ").$out(CCS.getAsString());
            }
          }
          OS.$out_char($$LF);
          break;
        }
       case RK_Pattern:
        {
          OS.$out(/*KEEP_STR*/"Pattern : ").$out(
              Results.$at(I).Unnamed_field1.Pattern.getAsString()
          ).$out_char($$LF);
          break;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::ProcessOverloadCandidates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp", line = 510,
   FQN="clang::PrintingCodeCompleteConsumer::ProcessOverloadCandidates", NM="_ZN5clang28PrintingCodeCompleteConsumer25ProcessOverloadCandidatesERNS_4SemaEjPNS_20CodeCompleteConsumer17OverloadCandidateEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumer25ProcessOverloadCandidatesERNS_4SemaEjPNS_20CodeCompleteConsumer17OverloadCandidateEj")
  //</editor-fold>
  @Override public void ProcessOverloadCandidates(final Sema /*&*/ SemaRef, 
                           /*uint*/int CurrentArg, 
                           type$ptr<OverloadCandidate> /*P*/ Candidates, 
                           /*uint*/int NumCandidates)/* override*/ {
    for (/*uint*/int I = 0; I != NumCandidates; ++I) {
      {
        CodeCompletionString /*P*/ CCS = Candidates.$at(I).CreateSignatureString(CurrentArg, SemaRef, 
            getAllocator(), CCTUInfo, 
            includeBriefComments());
        if ((CCS != null)) {
          OS.$out(/*KEEP_STR*/"OVERLOAD: ").$out(getOverloadAsString($Deref(CCS))).$out(/*KEEP_STR*/$LF);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 969,
   FQN="clang::PrintingCodeCompleteConsumer::getAllocator", NM="_ZN5clang28PrintingCodeCompleteConsumer12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumer12getAllocatorEv")
  //</editor-fold>
  @Override public CodeCompletionAllocator /*&*/ getAllocator()/* override*/ {
    return CCTUInfo.getAllocator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::getCodeCompletionTUInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 973,
   FQN="clang::PrintingCodeCompleteConsumer::getCodeCompletionTUInfo", NM="_ZN5clang28PrintingCodeCompleteConsumer23getCodeCompletionTUInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumer23getCodeCompletionTUInfoEv")
  //</editor-fold>
  @Override public CodeCompletionTUInfo /*&*/ getCodeCompletionTUInfo()/* override*/ {
    return CCTUInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PrintingCodeCompleteConsumer::~PrintingCodeCompleteConsumer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/CodeCompleteConsumer.h", line = 946,
   FQN="clang::PrintingCodeCompleteConsumer::~PrintingCodeCompleteConsumer", NM="_ZN5clang28PrintingCodeCompleteConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/CodeCompleteConsumer.cpp -nm=_ZN5clang28PrintingCodeCompleteConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CCTUInfo.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", CCTUInfo=" + CCTUInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
