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
import static org.clank.support.Casts.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;


// A LocalVariableMap maintains a map from local variables to their currently
// valid definitions.  It provides SSA-like functionality when traversing the
// CFG.  Like SSA, each definition or assignment to a variable is assigned a
// unique name (an integer), which acts as the SSA name for that definition.
// The total set of names is shared among all CFG basic blocks.
// Unlike SSA, we do not rewrite expressions to replace local variables declrefs
// with their SSA-names.  Instead, we compute a Context for each point in the
// code, which maps local variables to the appropriate SSA-name.  This map
// changes with each assignment.
//
// The map is computed in a single pass over the CFG.  Subsequent analyses can
// then query the map to find the appropriate Context for a statement, and use
// that Context to look up the definitions of variables.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 344,
 FQN="(anonymous namespace)::LocalVariableMap", NM="_ZN12_GLOBAL__N_116LocalVariableMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMapE")
//</editor-fold>
public class LocalVariableMap implements Destructors.ClassWithDestructor {
/*public:*/
  /*typedef LocalVarContext Context*/
//  public final class Context extends ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >{ };
  
  /// A VarDefinition consists of an expression, representing the value of the
  /// variable, along with the context in which that expression should be
  /// interpreted.  A reference VarDefinition does not itself contain this
  /// information, but instead contains a pointer to a previous VarDefinition.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 352,
   FQN="(anonymous namespace)::LocalVariableMap::VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionE")
  //</editor-fold>
  public static class/*struct*/ VarDefinition implements Native.NativePOD<VarDefinition>, Destructors.ClassWithDestructor {
  /*public:*/
    /*friend  class LocalVariableMap*/
    
    public /*const*/ NamedDecl /*P*/ Dec; // The original declaration for this variable.
    public /*const*/ Expr /*P*/ Exp; // The expression for this variable, OR
    public /*uint*/int Ref; // Reference to another VarDefinition
    public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx; // The map with which Exp should be interpreted.
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::isReference">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 361,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::isReference", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinition11isReferenceEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinition11isReferenceEv")
    //</editor-fold>
    public boolean isReference() {
      return !(Exp != null);
    }

  /*private:*/
    // Create ordinary variable definition
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 365,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EPKN5clang9NamedDeclEPKNS2_4ExprEN4llvm12ImmutableMapIS5_jNS9_16ImutKeyValueInfoIS5_jEEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EPKN5clang9NamedDeclEPKNS2_4ExprEN4llvm12ImmutableMapIS5_jNS9_16ImutKeyValueInfoIS5_jEEEE")
    //</editor-fold>
    private VarDefinition(/*const*/ NamedDecl /*P*/ D, /*const*/ Expr /*P*/ E, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
      // : Dec(D), Exp(E), Ref(0), Ctx(C) 
      //START JInit
      this.Dec = D;
      this.Exp = E;
      this.Ref = 0;
      this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C);
      //END JInit
    }

    
    // Create reference to previous definition
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 370,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EPKN5clang9NamedDeclEjN4llvm12ImmutableMapIS5_jNS6_16ImutKeyValueInfoIS5_jEEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EPKN5clang9NamedDeclEjN4llvm12ImmutableMapIS5_jNS6_16ImutKeyValueInfoIS5_jEEEE")
    //</editor-fold>
    private VarDefinition(/*const*/ NamedDecl /*P*/ D, /*uint*/int R, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
      // : Dec(D), Exp(null), Ref(R), Ctx(C) 
      //START JInit
      this.Dec = D;
      this.Exp = null;
      this.Ref = R;
      this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 352,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1EOS1_")
    //</editor-fold>
    public /*inline*/ VarDefinition(JD$Move _dparam, final VarDefinition /*&&*/$Prm0) {
      // : Dec(static_cast<VarDefinition &&>().Dec), Exp(static_cast<VarDefinition &&>().Exp), Ref(static_cast<VarDefinition &&>().Ref), Ctx(static_cast<VarDefinition &&>().Ctx) 
      //START JInit
      this.Dec = $Prm0.Dec;
      this.Exp = $Prm0.Exp;
      this.Ref = $Prm0.Ref;
      this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.Ctx);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::~VarDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 352,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::~VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Ctx.$destroy();
      //END JDestroy
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 352,
     FQN="(anonymous namespace)::LocalVariableMap::VarDefinition::VarDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13VarDefinitionC1ERKS1_")
    //</editor-fold>
    public /*inline*/ VarDefinition(final /*const*/ VarDefinition /*&*/ $Prm0) {
      // : Dec(.Dec), Exp(.Exp), Ref(.Ref), Ctx(.Ctx) 
      //START JInit
      this.Dec = $Prm0.Dec;
      this.Exp = $Prm0.Exp;
      this.Ref = $Prm0.Ref;
      this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.Ctx);
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public VarDefinition() {
      throw new UnsupportedOperationException("Why it is called?");
    }

    @Override
    public VarDefinition $assign(final /*const*/ VarDefinition /*&*/ $Prm0) {
      this.Dec = $Prm0.Dec;
      this.Exp = $Prm0.Exp;
      this.Ref = $Prm0.Ref;
      this.Ctx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.Ctx);
      return this;
    }

    @Override
    public VarDefinition clone() {
      return new VarDefinition(this);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Dec=" + Dec // NOI18N
                + ", Exp=" + Exp // NOI18N
                + ", Ref=" + Ref // NOI18N
                + ", Ctx=" + Ctx; // NOI18N
    }
  };
/*private:*/
  private ImmutableMapPtrUInt.Factory</*const*/ NamedDecl /*P*/ > ContextFactory;
  private std.vector<VarDefinition> VarDefinitions;
  private std.vectorUInt/*uint*/ CtxIndices;
  private std.vector<std.pair<Stmt /*P*/ , ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > >> SavedContexts;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::LocalVariableMap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 382,
   FQN="(anonymous namespace)::LocalVariableMap::LocalVariableMap", NM="_ZN12_GLOBAL__N_116LocalVariableMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMapC1Ev")
  //</editor-fold>
  public LocalVariableMap() {
    // : ContextFactory(), VarDefinitions(), CtxIndices(), SavedContexts() 
    //START JInit
    this.ContextFactory = new ImmutableMapPtrUInt.Factory</*const*/ NamedDecl /*P*/ >(ImutKeyValueInfo$PtrUInt.</*const*/ NamedDecl /*P*/>$Info());
    this.VarDefinitions = new std.vector<VarDefinition>(()->new VarDefinition());
    this.CtxIndices = new std.vectorUInt/*uint*/();
    this.SavedContexts = new std.vector<std.pair<Stmt /*P*/ , ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > >>(new std.pairPtrType<Stmt /*P*/ , ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > >());
    //END JInit
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // index 0 is a placeholder for undefined variables (aka phi-nodes).
      VarDefinitions.push_back_T$RR($c$.track(new VarDefinition((/*const*/ NamedDecl /*P*/ )null, 0/*U*/, $c$.track(getEmptyContext())))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Look up a definition, within the given context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::lookup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 388,
   FQN="(anonymous namespace)::LocalVariableMap::lookup", NM="_ZN12_GLOBAL__N_116LocalVariableMap6lookupEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap6lookupEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  public /*const*/ VarDefinition /*P*/ lookup(/*const*/ NamedDecl /*P*/ D, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    /*const*/uint$ptr/*uint P*/ i = $tryClone(Ctx.lookup(D));
    if (!Native.$bool(i)) {
      return null;
    }
    assert ($less_uint(i.$star(), VarDefinitions.size()));
    return $AddrOf(VarDefinitions.$at(i.$star()));
  }

  
  /// Look up the definition for D within the given context.  Returns
  /// NULL if the expression is not statically known.  If successful, also
  /// modifies Ctx to hold the context of the return Expr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::lookupExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 399,
   FQN="(anonymous namespace)::LocalVariableMap::lookupExpr", NM="_ZN12_GLOBAL__N_116LocalVariableMap10lookupExprEPKN5clang9NamedDeclERN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap10lookupExprEPKN5clang9NamedDeclERN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  public /*const*/ Expr /*P*/ lookupExpr(/*const*/ NamedDecl /*P*/ D, final ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > /*&*/ Ctx) {
    /*const*/uint$ptr/*uint P*/ P = $tryClone(Ctx.lookup(D));
    if (!Native.$bool(P)) {
      return null;
    }
    
    /*uint*/int i = P.$star();
    while ($greater_uint(i, 0)) {
      if ((VarDefinitions.$at(i).Exp != null)) {
        Ctx.$assign(VarDefinitions.$at(i).Ctx);
        return VarDefinitions.$at(i).Exp;
      }
      i = VarDefinitions.$at(i).Ref;
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::getEmptyContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 415,
   FQN="(anonymous namespace)::LocalVariableMap::getEmptyContext", NM="_ZN12_GLOBAL__N_116LocalVariableMap15getEmptyContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap15getEmptyContextEv")
  //</editor-fold>
  public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > getEmptyContext() {
    return ContextFactory.getEmptyMap();
  }

  
  /// Return the next context after processing S.  This function is used by
  /// clients of the class to get the appropriate context when traversing the
  /// CFG.  It must be called for every assignment or DeclStmt.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::getNextContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 420,
   FQN="(anonymous namespace)::LocalVariableMap::getNextContext", NM="_ZN12_GLOBAL__N_116LocalVariableMap14getNextContextERjPN5clang4StmtEN4llvm12ImmutableMapIPKNS2_9NamedDeclEjNS5_16ImutKeyValueInfoIS9_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap14getNextContextERjPN5clang4StmtEN4llvm12ImmutableMapIPKNS2_9NamedDeclEjNS5_16ImutKeyValueInfoIS9_jEEEE")
  //</editor-fold>
  public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > getNextContext(final uint$ref/*uint &*/ CtxIndex, Stmt /*P*/ S, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
    if (SavedContexts.$at(CtxIndex.$deref() + 1).first == S) {
      CtxIndex.$set$postInc();
      ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Result = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(SavedContexts.$at(CtxIndex.$deref()).second);
      return Result;
    }
    return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::dumpVarDefinitionName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 429,
   FQN="(anonymous namespace)::LocalVariableMap::dumpVarDefinitionName", NM="_ZN12_GLOBAL__N_116LocalVariableMap21dumpVarDefinitionNameEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap21dumpVarDefinitionNameEj")
  //</editor-fold>
  public void dumpVarDefinitionName(/*uint*/int i) {
    if (i == 0) {
      llvm.errs().$out(/*KEEP_STR*/"Undefined");
      return;
    }
    /*const*/ NamedDecl /*P*/ Dec = VarDefinitions.$at(i).Dec;
    if (!(Dec != null)) {
      llvm.errs().$out(/*KEEP_STR*/"<<NULL>>");
      return;
    }
    Dec.printName(llvm.errs());
    llvm.errs().$out(/*KEEP_STR*/$DOT).$out_uint(i).$out(/*KEEP_STR*/$SPACE).$out((reinterpret_cast(/*const*/Object/*void P*/ .class, Dec)));
  }

  
  /// Dumps an ASCII representation of the variable map to llvm::errs()
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 444,
   FQN="(anonymous namespace)::LocalVariableMap::dump", NM="_ZN12_GLOBAL__N_116LocalVariableMap4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap4dumpEv")
  //</editor-fold>
  public void dump() {
    for (/*uint*/int i = 1, e = VarDefinitions.size(); $less_uint(i, e); ++i) {
      /*const*/ Expr /*P*/ Exp = VarDefinitions.$at(i).Exp;
      /*uint*/int Ref = VarDefinitions.$at(i).Ref;
      
      dumpVarDefinitionName(i);
      llvm.errs().$out(/*KEEP_STR*/" = ");
      if ((Exp != null)) {
        Exp.dump();
      } else {
        dumpVarDefinitionName(Ref);
        llvm.errs().$out(/*KEEP_STR*/$LF);
      }
    }
  }

  
  /// Dumps an ASCII representation of a Context to llvm::errs()
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::dumpContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 460,
   FQN="(anonymous namespace)::LocalVariableMap::dumpContext", NM="_ZN12_GLOBAL__N_116LocalVariableMap11dumpContextEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap11dumpContextEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE")
  //</editor-fold>
  public void dumpContext(ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
    ImmutableMapPtrUInt.iterator</*const*/ NamedDecl /*P*/ > I = null;
    ImmutableMapPtrUInt.iterator</*const*/ NamedDecl /*P*/ > E = null;
    try {
      for (I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
        /*const*/ NamedDecl /*P*/ D = I.getKey();
        D.printName(llvm.errs());
        /*const*/uint$ptr/*uint P*/ i = $tryClone(C.lookup(D));
        llvm.errs().$out(/*KEEP_STR*/" -> ");
        dumpVarDefinitionName(i.$star());
        llvm.errs().$out(/*KEEP_STR*/$LF);
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
  }

  
  /// Builds the variable map.
  
  // Traverse the CFG in topological order, so all predecessors of a block
  // (excluding back-edges) are visited before the block itself.  At
  // each point in the code, we calculate a Context, which holds the set of
  // variable definitions which are visible at that point in execution.
  // Visible variables are mapped to their definitions using an array that
  // contains all definitions.
  //
  // At join points in the CFG, the set is computed as the intersection of
  // the incoming sets along each edge, E.g.
  //
  //                       { Context                 | VarDefinitions }
  //   int x = 0;          { x -> x1                 | x1 = 0 }
  //   int y = 0;          { x -> x1, y -> y1        | y1 = 0, x1 = 0 }
  //   if (b) x = 1;       { x -> x2, y -> y1        | x2 = 1, y1 = 0, ... }
  //   else   x = 2;       { x -> x3, y -> y1        | x3 = 2, x2 = 1, ... }
  //   ...                 { y -> y1  (x is unknown) | x3 = 2, x2 = 1, ... }
  //
  // This is essentially a simpler and more naive version of the standard SSA
  // algorithm.  Those definitions that remain in the intersection are from blocks
  // that strictly dominate the current block.  We do not bother to insert proper
  // phi nodes, because they are not used in our analysis; instead, wherever
  // a phi node would be required, we simply remove that definition from the
  // context (E.g. x above).
  //
  // The initial traversal does not capture back-edges, so those need to be
  // handled on a separate pass.  Whenever the first pass encounters an
  // incoming back edge, it duplicates the context, creating new definitions
  // that refer back to the originals.  (These correspond to places where SSA
  // might have to insert a phi node.)  On the second pass, these definitions are
  // set to NULL if the variable has changed on the back-edge (i.e. a phi
  // node was actually required.)  E.g.
  //
  //                       { Context           | VarDefinitions }
  //   int x = 0, y = 0;   { x -> x1, y -> y1  | y1 = 0, x1 = 0 }
  //   while (b)           { x -> x2, y -> y1  | [1st:] x2=x1; [2nd:] x2=NULL; }
  //     x = x+1;          { x -> x3, y -> y1  | x3 = x2 + 1, ... }
  //   ...                 { y -> y1           | x3 = 2, x2 = 1, ... }
  //
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::traverseCFG">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 686,
   FQN="(anonymous namespace)::LocalVariableMap::traverseCFG", NM="_ZN12_GLOBAL__N_116LocalVariableMap11traverseCFGEPN5clang3CFGEPKNS1_16PostOrderCFGViewERSt6vectorINS_12CFGBlockInfoESaIS8_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap11traverseCFGEPN5clang3CFGEPKNS1_16PostOrderCFGViewERSt6vectorINS_12CFGBlockInfoESaIS8_EE")
  //</editor-fold>
  public void traverseCFG(CFG /*P*/ CFGraph, 
             /*const*/ PostOrderCFGView /*P*/ SortedGraph, 
             final std.vector<CFGBlockInfo> /*&*/ BlockInfo) {
    PostOrderCFGView.CFGBlockSet VisitedBlocks = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      VisitedBlocks/*J*/= new PostOrderCFGView.CFGBlockSet(CFGraph);
      
      CtxIndices.resize(CFGraph.getNumBlockIDs());
      
      for (/*const*/ CFGBlock /*P*/ CurrBlock : $Deref(SortedGraph)) {
        VarMapBuilder VMapBuilder = null;
        try {
          int CurrBlockID = CurrBlock.getBlockID();
          CFGBlockInfo /*P*/ CurrBlockInfo = $AddrOf(BlockInfo.$at(CurrBlockID));
          
          VisitedBlocks.insert(CurrBlock);
          
          // Calculate the entry context for the current block
          boolean HasBackEdges = false;
          boolean CtxInit = true;
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > PI = $tryClone(CurrBlock.pred_begin$Const()), 
              /*P*/ PE = $tryClone(CurrBlock.pred_end$Const()); $noteq_ptr(PI, PE); PI.$preInc()) {
            // if *PI -> CurrBlock is a back edge, so skip it
            if (PI.$star().$CFGBlock$P() == null || !VisitedBlocks.alreadySet(PI.$star().$CFGBlock$P())) {
              HasBackEdges = true;
              continue;
            }
            
            int PrevBlockID = (PI.$star()).$arrow().getBlockID();
            CFGBlockInfo /*P*/ PrevBlockInfo = $AddrOf(BlockInfo.$at(PrevBlockID));
            if (CtxInit) {
              CurrBlockInfo.EntryContext.$assign(PrevBlockInfo.ExitContext);
              CtxInit = false;
            } else {
              $c$.clean(CurrBlockInfo.EntryContext.$assign(
                  $c$.track(intersectContexts($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(CurrBlockInfo.EntryContext)), 
                      $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(PrevBlockInfo.ExitContext))))
              ));
            }
          }
          
          // Duplicate the context if we have back-edges, so we can call
          // intersectBackEdges later.
          if (HasBackEdges) {
            $c$.clean(CurrBlockInfo.EntryContext.$assign(
                $c$.track(createReferenceContext($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(CurrBlockInfo.EntryContext))))
            ));
          }
          
          // Create a starting context index for the current block
          saveContext((Stmt /*P*/ )null, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(CurrBlockInfo.EntryContext))); $c$.clean();
          CurrBlockInfo.EntryIndex = getContextIndex();
          
          // Visit all the statements in the basic block.
          VMapBuilder/*J*/= $c$.clean(new VarMapBuilder(this, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(CurrBlockInfo.EntryContext))));
          for (std.reverse_iterator</*const*/ CFGElement> BI = CurrBlock.begin$Const(), 
              BE = CurrBlock.end$Const(); $noteq_reverse_iterator$C(BI, BE); BI.$preInc()) {
            switch (BI.$arrow().getKind()) {
             case Statement:
              {
                CFGStmt CS = BI.$arrow().castAs(CFGStmt.class);
                VMapBuilder.Visit(((/*const_cast*/Stmt /*P*/ )(CS.getStmt())));
                break;
              }
             default:
              break;
            }
          }
          CurrBlockInfo.ExitContext.$assign(VMapBuilder.Ctx);
          
          // Mark variables on back edges as "unknown" if they've been changed.
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.succ_begin$Const()), 
              /*P*/ SE = $tryClone(CurrBlock.succ_end$Const()); $noteq_ptr(SI, SE); SI.$preInc()) {
            // if CurrBlock -> *SI is *not* a back edge
            if (SI.$star().$CFGBlock$P() == null || !VisitedBlocks.alreadySet(SI.$star().$CFGBlock$P())) {
              continue;
            }
            
            CFGBlock /*P*/ FirstLoopBlock = SI.$star().$CFGBlock$P();
            ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > LoopBegin = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(BlockInfo.$at(FirstLoopBlock.getBlockID()).EntryContext);
            ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > LoopEnd = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(CurrBlockInfo.ExitContext);
            intersectBackEdge($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(LoopBegin)), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(LoopEnd))); $c$.clean();
          }
        } finally {
          if (VMapBuilder != null) { VMapBuilder.$destroy(); }
        }
      }
      
      // Put an extra entry at the end of the indexed context array
      /*uint*/int exitID = CFGraph.getExit().getBlockID();
      saveContext((Stmt /*P*/ )null, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(BlockInfo.$at(exitID).ExitContext))); $c$.clean();
    } finally {
      if (VisitedBlocks != null) { VisitedBlocks.$destroy(); }
      $c$.$destroy();
    }
  }

/*protected:*/
  // Get the current context index
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::getContextIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 477,
   FQN="(anonymous namespace)::LocalVariableMap::getContextIndex", NM="_ZN12_GLOBAL__N_116LocalVariableMap15getContextIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap15getContextIndexEv")
  //</editor-fold>
  protected /*uint*/int getContextIndex() {
    return SavedContexts.size() - 1;
  }

  
  // Save the current context for later replay
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::saveContext">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 480,
   FQN="(anonymous namespace)::LocalVariableMap::saveContext", NM="_ZN12_GLOBAL__N_116LocalVariableMap11saveContextEPN5clang4StmtEN4llvm12ImmutableMapIPKNS1_9NamedDeclEjNS4_16ImutKeyValueInfoIS8_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap11saveContextEPN5clang4StmtEN4llvm12ImmutableMapIPKNS1_9NamedDeclEjNS4_16ImutKeyValueInfoIS8_jEEEE")
  //</editor-fold>
  protected void saveContext(Stmt /*P*/ S, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SavedContexts.push_back_T$RR($c$.track(std.make_pair_Ptr_T(S, $Clone(C)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  // Adds a new definition to the given context, and returns a new context.
  // This method should be called when declaring a new variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::addDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 486,
   FQN="(anonymous namespace)::LocalVariableMap::addDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap13addDefinitionEPKN5clang9NamedDeclEPKNS1_4ExprEN4llvm12ImmutableMapIS4_jNS8_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap13addDefinitionEPKN5clang9NamedDeclEPKNS1_4ExprEN4llvm12ImmutableMapIS4_jNS8_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > addDefinition(/*const*/ NamedDecl /*P*/ D, /*const*/ Expr /*P*/ Exp, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > NewCtx = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (!Ctx.contains(D));
      /*uint*/int newID = VarDefinitions.size();
      NewCtx = $c$.clean(ContextFactory.add($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(Ctx)), D, newID));
      VarDefinitions.push_back_T$RR($c$.track(new VarDefinition(D, Exp, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))); $c$.clean();
      return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(NewCtx);
    } finally {
      if (NewCtx != null) { NewCtx.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Add a new reference to an existing definition.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::addReference">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 495,
   FQN="(anonymous namespace)::LocalVariableMap::addReference", NM="_ZN12_GLOBAL__N_116LocalVariableMap12addReferenceEPKN5clang9NamedDeclEjN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap12addReferenceEPKN5clang9NamedDeclEjN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > addReference(/*const*/ NamedDecl /*P*/ D, /*uint*/int i, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > NewCtx = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int newID = VarDefinitions.size();
      NewCtx = $c$.clean(ContextFactory.add($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(Ctx)), D, newID));
      VarDefinitions.push_back_T$RR($c$.track(new VarDefinition(D, i, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))); $c$.clean();
      return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(NewCtx);
    } finally {
      if (NewCtx != null) { NewCtx.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Updates a definition only if that definition is already in the map.
  // This method should be called when assigning to an existing variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::updateDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 504,
   FQN="(anonymous namespace)::LocalVariableMap::updateDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap16updateDefinitionEPKN5clang9NamedDeclEPNS1_4ExprEN4llvm12ImmutableMapIS4_jNS7_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap16updateDefinitionEPKN5clang9NamedDeclEPNS1_4ExprEN4llvm12ImmutableMapIS4_jNS7_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > updateDefinition(/*const*/ NamedDecl /*P*/ D, Expr /*P*/ Exp, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    if (Ctx.contains(D)) {
      ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > NewCtx = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int newID = VarDefinitions.size();
        NewCtx = $c$.clean(ContextFactory.remove($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(Ctx)), D));
        $c$.clean(NewCtx.$assign($c$.track(ContextFactory.add($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(NewCtx)), D, newID))));
        VarDefinitions.push_back_T$RR($c$.track(new VarDefinition(D, Exp, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx))))); $c$.clean();
        return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(NewCtx);
      } finally {
        if (NewCtx != null) { NewCtx.$destroy(); }
        $c$.$destroy();
      }
    }
    return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx);
  }

  
  // Removes a definition from the context, but keeps the variable name
  // as a valid variable.  The index 0 is a placeholder for cleared definitions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::clearDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 517,
   FQN="(anonymous namespace)::LocalVariableMap::clearDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap15clearDefinitionEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap15clearDefinitionEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > clearDefinition(/*const*/ NamedDecl /*P*/ D, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > NewCtx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx);
    if (NewCtx.contains(D)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(NewCtx.$assign($c$.track(ContextFactory.remove($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(NewCtx)), D))));
        $c$.clean(NewCtx.$assign($c$.track(ContextFactory.add($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(NewCtx)), D, 0))));
      } finally {
        $c$.$destroy();
      }
    }
    return NewCtx;
  }

  
  // Remove a definition entirely frmo the context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::removeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 527,
   FQN="(anonymous namespace)::LocalVariableMap::removeDefinition", NM="_ZN12_GLOBAL__N_116LocalVariableMap16removeDefinitionEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap16removeDefinitionEPKN5clang9NamedDeclEN4llvm12ImmutableMapIS4_jNS5_16ImutKeyValueInfoIS4_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > removeDefinition(/*const*/ NamedDecl /*P*/ D, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Ctx) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > NewCtx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Ctx);
    if (NewCtx.contains(D)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(NewCtx.$assign($c$.track(ContextFactory.remove($c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/>(NewCtx)), D))));
      } finally {
        $c$.$destroy();
      }
    }
    return NewCtx;
  }

  
  
  // Computes the intersection of two contexts.  The intersection is the
  // set of variables which have the same definition in both contexts;
  // variables with different definitions are discarded.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::intersectContexts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 608,
   FQN="(anonymous namespace)::LocalVariableMap::intersectContexts", NM="_ZN12_GLOBAL__N_116LocalVariableMap17intersectContextsEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap17intersectContextsEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEES9_")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > intersectContexts(ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C1, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C2) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Result = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C1);
    for (final /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*&*/ P : C1) {
      /*const*/ NamedDecl /*P*/ Dec = P.first;
      /*const*/uint$ptr/*uint P*/ i2 = $tryClone(C2.lookup(Dec));
      if (!Native.$bool(i2)) { // variable doesn't exist on second path
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Result.$assign($c$.track(removeDefinition(Dec, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Result))))));
        } finally {
          $c$.$destroy();
        }
      } else if (i2.$star() != P.second) { // variable exists, but has different definition
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Result.$assign($c$.track(clearDefinition(Dec, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Result))))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    return Result;
  }

  
  // For every variable in C, create a new variable that refers to the
  // definition in C.  Return a new context that contains these new variables.
  // (We use this for a naive implementation of SSA on loop back-edges.)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::createReferenceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 625,
   FQN="(anonymous namespace)::LocalVariableMap::createReferenceContext", NM="_ZN12_GLOBAL__N_116LocalVariableMap22createReferenceContextEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap22createReferenceContextEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE")
  //</editor-fold>
  protected ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > createReferenceContext(ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C) {
    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > Result = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Result = getEmptyContext();
      for (final /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*&*/ P : C)  {
        $c$.clean(Result.$assign($c$.track(addReference(P.first, P.second, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Result))))));
      }
      return new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Result);
    } finally {
      if (Result != null) { Result.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // This routine also takes the intersection of C1 and C2, but it does so by
  // altering the VarDefinitions.  C1 must be the result of an earlier call to
  // createReferenceContext.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::intersectBackEdge">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 635,
   FQN="(anonymous namespace)::LocalVariableMap::intersectBackEdge", NM="_ZN12_GLOBAL__N_116LocalVariableMap17intersectBackEdgeEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMap17intersectBackEdgeEN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEES9_")
  //</editor-fold>
  protected void intersectBackEdge(ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C1, ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C2) {
    for (final /*const*/std.pairTypeUInt</*const*/ NamedDecl /*P*/ > /*&*/ P : C1) {
      /*uint*/int i1 = P.second;
      VarDefinition /*P*/ VDef = $AddrOf(VarDefinitions.$at(i1));
      assert (VDef.isReference());
      
      /*const*/uint$ptr/*uint P*/ i2 = $tryClone(C2.lookup(P.first));
      if (!Native.$bool(i2) || (i2.$star() != i1)) {
        VDef.Ref = 0; // Mark this variable as undefined
      }
    }
  }

  
  /*friend  class VarMapBuilder*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LocalVariableMap::~LocalVariableMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 344,
   FQN="(anonymous namespace)::LocalVariableMap::~LocalVariableMap", NM="_ZN12_GLOBAL__N_116LocalVariableMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_116LocalVariableMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SavedContexts.$destroy();
    CtxIndices.$destroy();
    VarDefinitions.$destroy();
    ContextFactory.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ContextFactory=" + ContextFactory // NOI18N
              + ", VarDefinitions=" + VarDefinitions // NOI18N
              + ", CtxIndices=" + CtxIndices // NOI18N
              + ", SavedContexts=" + SavedContexts; // NOI18N
  }
}
