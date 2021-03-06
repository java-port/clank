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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.sema.*;
import org.clang.frontend.*;
import org.clang.frontend.impl.*;


/// Use MultiplexExternalSemaSource to dispatch all ExternalSemaSource
/// calls to the final reader.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIncludesSource">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*merged with ChainedIncludesSourceMembers*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 67,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", old_line = 28,
 FQN="(anonymous namespace)::ChainedIncludesSource", NM="_ZN12_GLOBAL__N_121ChainedIncludesSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN12_GLOBAL__N_121ChainedIncludesSourceE")
//</editor-fold>
public class ChainedIncludesSource extends /*private ChainedIncludesSourceMembers, *//*public*/ MultiplexExternalSemaSource implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIncludesSource::ChainedIncludesSource">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 71,
   FQN="(anonymous namespace)::ChainedIncludesSource::ChainedIncludesSource", NM="_ZN12_GLOBAL__N_121ChainedIncludesSourceC1ESt6vectorISt10unique_ptrIN5clang16CompilerInstanceESt14default_deleteIS4_EESaIS7_EEN4llvm18IntrusiveRefCntPtrINS3_18ExternalSemaSourceEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN12_GLOBAL__N_121ChainedIncludesSourceC1ESt6vectorISt10unique_ptrIN5clang16CompilerInstanceESt14default_deleteIS4_EESaIS7_EEN4llvm18IntrusiveRefCntPtrINS3_18ExternalSemaSourceEEE")
  //</editor-fold>
  public ChainedIncludesSource(std.vector<std.unique_ptr<CompilerInstance>> CIs, 
      IntrusiveRefCntPtr<ExternalSemaSource> FinalReader) {
    // : ChainedIncludesSourceMembers(std::move(CIs), std::move(FinalReader)), MultiplexExternalSemaSource(Impl, * this->FinalReader) 
    //START JInit
    /*ExprWithCleanups*/$ChainedIncludesSourceMembers(std.move(CIs), std.move(FinalReader));
    $MultiplexExternalSemaSource(this.Impl, this.FinalReader.$star());
    //END JInit
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIncludesSourceMembers::ChainedIncludesSourceMembers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 57,
   FQN="(anonymous namespace)::ChainedIncludesSourceMembers::ChainedIncludesSourceMembers", NM="_ZN12_GLOBAL__N_128ChainedIncludesSourceMembersC1ESt6vectorISt10unique_ptrIN5clang16CompilerInstanceESt14default_deleteIS4_EESaIS7_EEN4llvm18IntrusiveRefCntPtrINS3_18ExternalSemaSourceEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN12_GLOBAL__N_128ChainedIncludesSourceMembersC1ESt6vectorISt10unique_ptrIN5clang16CompilerInstanceESt14default_deleteIS4_EESaIS7_EEN4llvm18IntrusiveRefCntPtrINS3_18ExternalSemaSourceEEE")
  //</editor-fold>
  private void $ChainedIncludesSourceMembers(std.vector<std.unique_ptr<CompilerInstance>> CIs, 
      IntrusiveRefCntPtr<ExternalSemaSource> FinalReader) {
    // : Impl(std::move(CIs)), FinalReader(std::move(FinalReader)) 
    //START JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      this.Impl = $c$.clean(new ChainedIncludesSourceImpl($c$.track(new std.vector<std.unique_ptr<CompilerInstance>>(JD$Move.INSTANCE, std.move(CIs)))));
      this.FinalReader = new IntrusiveRefCntPtr<ExternalSemaSource>(JD$Move.INSTANCE, std.move(FinalReader));
    } finally {
        $c$.$destroy();
    }
    //END JInit
  }

  public ChainedIncludesSourceImpl Impl;
  public IntrusiveRefCntPtr<ExternalSemaSource> FinalReader;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChainedIncludesSourceMembers::~ChainedIncludesSourceMembers">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp", line = 56,
   FQN="(anonymous namespace)::ChainedIncludesSourceMembers::~ChainedIncludesSourceMembers", NM="_ZN12_GLOBAL__N_128ChainedIncludesSourceMembersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.frontend/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ChainedIncludesSource.cpp -nm=_ZN12_GLOBAL__N_128ChainedIncludesSourceMembersD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    FinalReader.$destroy();
    Impl.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Impl=" + Impl // NOI18N
              + ", FinalReader=" + FinalReader + // NOI18N
            super.toString(); 
  }  
}
