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

package org.clang.analysis.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.clang.analysis.support.*;
import org.clang.analysis.impl.*;


/// LocalScope - Node in tree of local scopes created for C++ implicit
/// destructor calls generation. It contains list of automatic variables
/// declared in the scope and link to position in previous scope this scope
/// began in.
///
/// The process of creating local scopes is as follows:
/// - Init CFGBuilder::ScopePos with invalid position (equivalent for null),
/// - Before processing statements in scope (e.g. CompoundStmt) create
///   LocalScope object using CFGBuilder::ScopePos as link to previous scope
///   and set CFGBuilder::ScopePos to the end of new scope,
/// - On every occurrence of VarDecl increase CFGBuilder::ScopePos if it points
///   at this VarDecl,
/// - For every normal (without jump) end of scope add to CFGBlock destructors
///   for objects in the current scope,
/// - For every jump add to CFGBlock destructors for objects
///   between CFGBuilder::ScopePos and local scope position saved for jump
///   target. Thanks to C++ restrictions on goto jumps we can be sure that
///   jump target position will be on the path to root from CFGBuilder::ScopePos
///   (adding any variable that doesn't need constructor to be called to
///   LocalScope can break this assumption),
///
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 169,
 FQN="(anonymous namespace)::LocalScope", NM="_ZN12_GLOBAL__N_110LocalScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScopeE")
//</editor-fold>
public class LocalScope implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef BumpVector<VarDecl *> AutomaticVarsTy*/
//  public final class AutomaticVarsTy extends BumpVector<VarDecl /*P*/ >{ };
  
  /// const_iterator - Iterates local scope backwards and jumps to previous
  /// scope on reaching the beginning of currently iterated scope.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 175,
   FQN="(anonymous namespace)::LocalScope::const_iterator", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorE")
  //</editor-fold>
  public static class const_iterator implements Native.NativePOD<const_iterator>, Native.Native$Bool {
    private /*const*/ LocalScope /*P*/ Scope;
    
    /// VarIter is guaranteed to be greater then 0 for every valid iterator.
    /// Invalid iterator (with null Scope) has VarIter equal to 0.
    private /*uint*/int VarIter;
  /*public:*/
    /// Create invalid iterator. Dereferencing invalid iterator is not allowed.
    /// Incrementing invalid iterator is allowed and will result in invalid
    /// iterator.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::const_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 186,
     FQN="(anonymous namespace)::LocalScope::const_iterator::const_iterator", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1Ev")
    //</editor-fold>
    public const_iterator() {
      // : Scope(null), VarIter(0) 
      //START JInit
      this.Scope = null;
      this.VarIter = 0;
      //END JInit
    }

    
    /// Create valid iterator. In case when S.Prev is an invalid iterator and
    /// I is equal to 0, this will create invalid iterator.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::const_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 191,
     FQN="(anonymous namespace)::LocalScope::const_iterator::const_iterator", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1ERKS0_j",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1ERKS0_j")
    //</editor-fold>
    public const_iterator(final /*const*/ LocalScope /*&*/ S, /*uint*/int I) {
      // : Scope(&S), VarIter(I) 
      //START JInit
      this.Scope = $AddrOf(S);
      this.VarIter = I;
      //END JInit
      // Iterator to "end" of scope is not allowed. Handle it by going up
      // in scopes tree possibly up to invalid iterator in the root.
      if (VarIter == 0 && (Scope != null)) {
        /*Deref*/this.$assign(Scope.Prev);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator->">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 199,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator->", NM="_ZNK12_GLOBAL__N_110LocalScope14const_iteratorptEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope14const_iteratorptEv")
    //</editor-fold>
    public type$ptr<VarDecl /*P*/ /*const*/ /*P*/> $arrow() /*const*/ {
      assert ((Scope != null)) : "Dereferencing invalid iterator is not allowed";
      assert (VarIter != 0) : "Iterator has invalid value of VarIter member";
      return $AddrOf(Scope.Vars.ptr$at(VarIter - 1));
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 204,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator*", NM="_ZNK12_GLOBAL__N_110LocalScope14const_iteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope14const_iteratordeEv")
    //</editor-fold>
    public VarDecl /*P*/ $star() /*const*/ {
      return this.$arrow().$star();
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 208,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator++", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorppEv")
    //</editor-fold>
    public const_iterator /*&*/ $preInc() {
      if (!(Scope != null)) {
        return /*Deref*/this;
      }
      assert (VarIter != 0) : "Iterator has invalid value of VarIter member";
      --VarIter;
      if (VarIter == 0) {
        /*Deref*/this.$assign(Scope.Prev);
      }
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 218,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator++", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorppEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorppEi")
    //</editor-fold>
    public const_iterator $postInc(int $Prm0) {
      const_iterator P = new const_iterator(/*Deref*/this);
      $Deref(this.$preInc());
      return P;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 224,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator==", NM="_ZNK12_GLOBAL__N_110LocalScope14const_iteratoreqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope14const_iteratoreqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ const_iterator /*&*/ rhs) /*const*/ {
      return Scope == rhs.Scope && VarIter == rhs.VarIter;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 227,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator!=", NM="_ZNK12_GLOBAL__N_110LocalScope14const_iteratorneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope14const_iteratorneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ const_iterator /*&*/ rhs) /*const*/ {
      return !(/*Deref*/this.$eq(rhs));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator bool">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 231,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator bool", NM="_ZNK12_GLOBAL__N_110LocalScope14const_iteratorcvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope14const_iteratorcvbEv")
    //</editor-fold>
    public boolean $bool() /*const*/ {
      return /*Deref*/this.$noteq(new const_iterator());
    }

    
    
    /// distance - Calculates distance from this to L. L must be reachable from this
    /// (with use of ++ operator). Cost of calculating the distance is linear w.r.t.
    /// number of scopes between this and L.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::distance">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 265,
     FQN="(anonymous namespace)::LocalScope::const_iterator::distance", NM="_ZN12_GLOBAL__N_110LocalScope14const_iterator8distanceES1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iterator8distanceES1_")
    //</editor-fold>
    public int distance(LocalScope.const_iterator L) {
      int D = 0;
      const_iterator F = new const_iterator(/*Deref*/this);
      while (F.Scope != L.Scope) {
        assert (F.$noteq(new const_iterator())) : "L iterator is not reachable from F iterator.";
        D += F.VarIter;
        F.$assign(F.Scope.Prev);
      }
      D += F.VarIter - L.VarIter;
      return D;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::const_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 175,
     FQN="(anonymous namespace)::LocalScope::const_iterator::const_iterator", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ const_iterator(final /*const*/ const_iterator /*&*/ $Prm0) {
      // : Scope(.Scope), VarIter(.VarIter) 
      //START JInit
      this.Scope = $Prm0.Scope;
      this.VarIter = $Prm0.VarIter;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::const_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 175,
     FQN="(anonymous namespace)::LocalScope::const_iterator::const_iterator", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ const_iterator(JD$Move _dparam, final const_iterator /*&&*/$Prm0) {
      // : Scope(static_cast<const_iterator &&>().Scope), VarIter(static_cast<const_iterator &&>().VarIter) 
      //START JInit
      this.Scope = $Prm0.Scope;
      this.VarIter = $Prm0.VarIter;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 175,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator=", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratoraSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratoraSERKS1_")
    //</editor-fold>
    public /*inline*/ const_iterator /*&*/ $assign(final /*const*/ const_iterator /*&*/ $Prm0) {
      this.Scope = $Prm0.Scope;
      this.VarIter = $Prm0.VarIter;
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::const_iterator::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 175,
     FQN="(anonymous namespace)::LocalScope::const_iterator::operator=", NM="_ZN12_GLOBAL__N_110LocalScope14const_iteratoraSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope14const_iteratoraSEOS1_")
    //</editor-fold>
    public /*inline*/ const_iterator /*&*/ $assignMove(final const_iterator /*&&*/$Prm0) {
      this.Scope = $Prm0.Scope;
      this.VarIter = $Prm0.VarIter;
      return /*Deref*/this;
    }

    @Override public const_iterator clone() { return new const_iterator(this); }

    @Override public String toString() {
      return "" + "Scope=" + Scope // NOI18N
                + ", VarIter=" + VarIter; // NOI18N
    }
  };
  
  /*friend  class const_iterator*/
/*private:*/
  private BumpVectorContext ctx;
  
  /// Automatic variables in order of declaration.
  private BumpVector<VarDecl /*P*/ > Vars;
  /// Iterator to variable in previous scope that was declared just before
  /// begin of this scope.
  private const_iterator Prev;
/*public:*/
  /// Constructs empty scope linked to previous scope in specified place.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::LocalScope">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 251,
   FQN="(anonymous namespace)::LocalScope::LocalScope", NM="_ZN12_GLOBAL__N_110LocalScopeC1EN5clang17BumpVectorContextENS0_14const_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScopeC1EN5clang17BumpVectorContextENS0_14const_iteratorE")
  //</editor-fold>
  public LocalScope(BumpVectorContext ctx, const_iterator P) {
    // : ctx(std::move(ctx)), Vars(this->ctx, 4), Prev(P) 
    //START JInit
    this.ctx = new BumpVectorContext(JD$Move.INSTANCE, std.move(ctx));
    // JAVA: MEMORY
    NativeTrace.traceNotImplemented("Fix use of allocator. Do we need specialized BumpVectorTypeAllocator?");
    this.Vars = new BumpVector<VarDecl /*P*/ >(new BumpVector.TypeAllocator<VarDecl>(
                (int size)->{return new VarDecl[size];}), this.ctx, 4);
    this.Prev = $tryClone(new const_iterator(P));
    //END JInit
  }

  
  /// Begin of scope in direction of CFG building (backwards).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 255,
   FQN="(anonymous namespace)::LocalScope::begin", NM="_ZNK12_GLOBAL__N_110LocalScope5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZNK12_GLOBAL__N_110LocalScope5beginEv")
  //</editor-fold>
  public const_iterator begin() /*const*/ {
    return new const_iterator(/*Deref*/this, Vars.size());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::addVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 257,
   FQN="(anonymous namespace)::LocalScope::addVar", NM="_ZN12_GLOBAL__N_110LocalScope6addVarEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScope6addVarEPN5clang7VarDeclE")
  //</editor-fold>
  public void addVar(VarDecl /*P*/ VD) {
    Vars.push_back(VD, ctx);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalScope::~LocalScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 169,
   FQN="(anonymous namespace)::LocalScope::~LocalScope", NM="_ZN12_GLOBAL__N_110LocalScopeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN12_GLOBAL__N_110LocalScopeD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    /*<<<default destructor: may be there is another TU where objects are created/destroyed?>>>*/
  }


  
  @Override public String toString() {
    return "" + "ctx=" + "[BumpVectorContext]" // NOI18N
              + ", Vars=" + Vars // NOI18N
              + ", Prev=" + Prev; // NOI18N
  }
}
