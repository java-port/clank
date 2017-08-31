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

package org.clang.parse.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.parse.impl.*;

/// RAII that recreates function context for correct parsing of clauses of
/// 'declare simd' construct.
/// OpenMP, 2.8.2 declare simd Construct
/// The expressions appearing in the clauses of this directive are evaluated in
/// the scope of the arguments of the function declaration or definition.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 363,
 FQN="(anonymous namespace)::FNContextRAII", NM="_ZN12_GLOBAL__N_113FNContextRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIIE")
//</editor-fold>
public final class FNContextRAII implements Destructors.ClassWithDestructor {
  private Parser /*&*/ P;
  private Sema.CXXThisScopeRAII /*P*/ ThisScope;
  private Parser.ParseScope /*P*/ TempScope;
  private Parser.ParseScope /*P*/ FnScope;
  private boolean HasTemplateScope/* = false*/;
  private boolean HasFunScope/* = false*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII::FNContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 370,
   FQN="(anonymous namespace)::FNContextRAII::FNContextRAII", NM="_ZN12_GLOBAL__N_113FNContextRAIIC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIIC1Ev")
  //</editor-fold>
  private FNContextRAII() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII::FNContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 371,
   FQN="(anonymous namespace)::FNContextRAII::FNContextRAII", NM="_ZN12_GLOBAL__N_113FNContextRAIIC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIIC1ERKS0_")
  //</editor-fold>
  private FNContextRAII(/*const*/ FNContextRAII /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 372,
   FQN="(anonymous namespace)::FNContextRAII::operator=", NM="_ZN12_GLOBAL__N_113FNContextRAIIaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIIaSERKS0_")
  //</editor-fold>
  private FNContextRAII /*&*/ $assign(/*const*/ FNContextRAII /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII::FNContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 375,
   FQN="(anonymous namespace)::FNContextRAII::FNContextRAII", NM="_ZN12_GLOBAL__N_113FNContextRAIIC1ERN5clang6ParserENS1_9OpaquePtrINS1_12DeclGroupRefEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIIC1ERN5clang6ParserENS1_9OpaquePtrINS1_12DeclGroupRefEEE")
  //</editor-fold>
  public FNContextRAII(Parser /*&*/ P, OpaquePtr<DeclGroupRef> Ptr) {
    // : P(P), HasTemplateScope(false), HasFunScope(false) 
    //START JInit
    this./*&*/P=/*&*/P;
    /*InClass*/this.HasTemplateScope = false;
    /*InClass*/this.HasFunScope = false;
    //END JInit
    Decl /*P*/ D = Ptr.getDeclGroupRef().begin().$star();
    NamedDecl /*P*/ ND = dyn_cast(NamedDecl.class, D);
    RecordDecl /*P*/ RD = dyn_cast_or_null(RecordDecl.class, D.getDeclContext());
    Sema /*&*/ Actions = P.getActions();
    
    // Allow 'this' within late-parsed attributes.
    ThisScope = new Sema.CXXThisScopeRAII(Actions, RD, /*TypeQuals=*/ 0, 
        (ND != null) && ND.isCXXInstanceMember());
    
    // If the Decl is templatized, add template parameters to scope.
    HasTemplateScope = D.isTemplateDecl();
    TempScope
       = new Parser.ParseScope($AddrOf(P), Scope.ScopeFlags.TemplateParamScope, HasTemplateScope);
    if (HasTemplateScope) {
      Actions.ActOnReenterTemplateScope(Actions.getCurScope(), D);
    }
    
    // If the Decl is on a function, add function parameters to the scope.
    HasFunScope = D.isFunctionOrFunctionTemplate();
    FnScope = new Parser.ParseScope($AddrOf(P), Scope.ScopeFlags.FnScope | Scope.ScopeFlags.DeclScope, 
        HasFunScope);
    if (HasFunScope) {
      Actions.ActOnReenterFunctionContext(Actions.getCurScope(), D);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FNContextRAII::~FNContextRAII">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 399,
   FQN="(anonymous namespace)::FNContextRAII::~FNContextRAII", NM="_ZN12_GLOBAL__N_113FNContextRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_113FNContextRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    if (HasFunScope) {
      P.getActions().ActOnExitFunctionContext();
      FnScope.Exit(); // Pop scope, and remove Decls from IdResolver
    }
    if (HasTemplateScope) {
      TempScope.Exit();
    }
    if (FnScope != null) { FnScope.$destroy();};
    if (TempScope != null) { TempScope.$destroy();};
    if (ThisScope != null) { ThisScope.$destroy();};
  }

  
  @Override public String toString() {
    return "" /* STACKOVERFLOW: NEVER PRINT PARSER "P=" + P */// NOI18N
              + ", ThisScope=" + ThisScope // NOI18N
              + ", TempScope=" + TempScope // NOI18N
              + ", FnScope=" + FnScope // NOI18N
              + ", HasTemplateScope=" + HasTemplateScope // NOI18N
              + ", HasFunScope=" + HasFunScope; // NOI18N
  }
}
