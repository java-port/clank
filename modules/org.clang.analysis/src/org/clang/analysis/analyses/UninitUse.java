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

package org.clang.analysis.analyses;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.analyses.*;


/// A use of a variable, which might be uninitialized.
//<editor-fold defaultstate="collapsed" desc="clang::UninitUse">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 30,
 FQN="clang::UninitUse", NM="_ZN5clang9UninitUseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseE")
//</editor-fold>
public class UninitUse implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::Branch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 32,
   FQN="clang::UninitUse::Branch", NM="_ZN5clang9UninitUse6BranchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUse6BranchE")
  //</editor-fold>
  public static class/*struct*/ Branch {
    public /*const*/ Stmt /*P*/ Terminator;
    public /*uint*/int Output;

    //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::Branch::Branch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 32,
     FQN="clang::UninitUse::Branch::Branch", NM="_ZN5clang9UninitUse6BranchC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang9UninitUse6BranchC1Ev")
    //</editor-fold>
    public /*inline*/ Branch() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::Branch::Branch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 32,
     FQN="clang::UninitUse::Branch::Branch", NM="_ZN5clang9UninitUse6BranchC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang9UninitUse6BranchC1ERKS1_")
    //</editor-fold>
    public /*inline*/ Branch(final /*const*/ Branch /*&*/ $Prm0) {
      // : Terminator(.Terminator), Output(.Output) 
      //START JInit
      this.Terminator = $Prm0.Terminator;
      this.Output = $Prm0.Output;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::Branch::~Branch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 32,
     FQN="clang::UninitUse::Branch::~Branch", NM="_ZN5clang9UninitUse6BranchD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang9UninitUse6BranchD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }

    
    @Override public String toString() {
      return "" + "Terminator=" + Terminator // NOI18N
                + ", Output=" + Output; // NOI18N
    }
  };
/*private:*/
  /// The expression which uses this variable.
  private /*const*/ Expr /*P*/ User;
  
  /// Is this use uninitialized whenever the function is called?
  private boolean UninitAfterCall;
  
  /// Is this use uninitialized whenever the variable declaration is reached?
  private boolean UninitAfterDecl;
  
  /// Does this use always see an uninitialized value?
  private boolean AlwaysUninit;
  
  /// This use is always uninitialized if it occurs after any of these branches
  /// is taken.
  private SmallVector<Branch> UninitBranches;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::UninitUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 55,
   FQN="clang::UninitUse::UninitUse", NM="_ZN5clang9UninitUseC1EPKNS_4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseC1EPKNS_4ExprEb")
  //</editor-fold>
  public UninitUse(/*const*/ Expr /*P*/ User, boolean AlwaysUninit) {
    // : User(User), UninitAfterCall(false), UninitAfterDecl(false), AlwaysUninit(AlwaysUninit), UninitBranches() 
    //START JInit
    this.User = User;
    this.UninitAfterCall = false;
    this.UninitAfterDecl = false;
    this.AlwaysUninit = AlwaysUninit;
    this.UninitBranches = new SmallVector<Branch>(2, new Branch());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::addUninitBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 59,
   FQN="clang::UninitUse::addUninitBranch", NM="_ZN5clang9UninitUse15addUninitBranchENS0_6BranchE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUse15addUninitBranchENS0_6BranchE")
  //</editor-fold>
  public void addUninitBranch(Branch B) {
    UninitBranches.push_back(B);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::setUninitAfterCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 63,
   FQN="clang::UninitUse::setUninitAfterCall", NM="_ZN5clang9UninitUse18setUninitAfterCallEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUse18setUninitAfterCallEv")
  //</editor-fold>
  public void setUninitAfterCall() {
    UninitAfterCall = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::setUninitAfterDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 64,
   FQN="clang::UninitUse::setUninitAfterDecl", NM="_ZN5clang9UninitUse18setUninitAfterDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUse18setUninitAfterDeclEv")
  //</editor-fold>
  public void setUninitAfterDecl() {
    UninitAfterDecl = true;
  }

  
  /// Get the expression containing the uninitialized use.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::getUser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 67,
   FQN="clang::UninitUse::getUser", NM="_ZNK5clang9UninitUse7getUserEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang9UninitUse7getUserEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getUser() /*const*/ {
    return User;
  }

  
  /// The kind of uninitialized use.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 70,
   FQN="clang::UninitUse::Kind", NM="_ZN5clang9UninitUse4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUse4KindE")
  //</editor-fold>
  public enum Kind implements Native.ComparableLower {
    /// The use might be uninitialized.
    Maybe(0),
    /// The use is uninitialized whenever a certain branch is taken.
    Sometimes(Maybe.getValue() + 1),
    /// The use is uninitialized the first time it is reached after we reach
    /// the variable's declaration.
    AfterDecl(Sometimes.getValue() + 1),
    /// The use is uninitialized the first time it is reached after the function
    /// is called.
    AfterCall(AfterDecl.getValue() + 1),
    /// The use is always uninitialized.
    Always(AfterCall.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  /// Get the kind of uninitialized use.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 86,
   FQN="clang::UninitUse::getKind", NM="_ZNK5clang9UninitUse7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang9UninitUse7getKindEv")
  //</editor-fold>
  public Kind getKind() /*const*/ {
    return AlwaysUninit ? Kind.Always : UninitAfterCall ? Kind.AfterCall : UninitAfterDecl ? Kind.AfterDecl : !branch_empty() ? Kind.Sometimes : Kind.Maybe;
  }

  
  /*typedef SmallVectorImpl<Branch>::const_iterator branch_iterator*/
//  public final class branch_iterator extends type$ptr<Branch>{ };
  /// Branches which inevitably result in the variable being used uninitialized.
  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::branch_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 95,
   FQN="clang::UninitUse::branch_begin", NM="_ZNK5clang9UninitUse12branch_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang9UninitUse12branch_beginEv")
  //</editor-fold>
  public type$ptr<Branch> branch_begin() /*const*/ {
    return UninitBranches.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::branch_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 96,
   FQN="clang::UninitUse::branch_end", NM="_ZNK5clang9UninitUse10branch_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang9UninitUse10branch_endEv")
  //</editor-fold>
  public type$ptr<Branch> branch_end() /*const*/ {
    return UninitBranches.end$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::branch_empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 97,
   FQN="clang::UninitUse::branch_empty", NM="_ZNK5clang9UninitUse12branch_emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang9UninitUse12branch_emptyEv")
  //</editor-fold>
  public boolean branch_empty() /*const*/ {
    return UninitBranches.empty();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::UninitUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 30,
   FQN="clang::UninitUse::UninitUse", NM="_ZN5clang9UninitUseC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseC1EOS0_")
  //</editor-fold>
  public /*inline*/ UninitUse(JD$Move _dparam, final UninitUse /*&&*/$Prm0) {
    // : User(static_cast<UninitUse &&>().User), UninitAfterCall(static_cast<UninitUse &&>().UninitAfterCall), UninitAfterDecl(static_cast<UninitUse &&>().UninitAfterDecl), AlwaysUninit(static_cast<UninitUse &&>().AlwaysUninit), UninitBranches(static_cast<UninitUse &&>().UninitBranches) 
    //START JInit
    this.User = $Prm0.User;
    this.UninitAfterCall = $Prm0.UninitAfterCall;
    this.UninitAfterDecl = $Prm0.UninitAfterDecl;
    this.AlwaysUninit = $Prm0.AlwaysUninit;
    this.UninitBranches = new SmallVector<Branch>(JD$Move.INSTANCE, $Prm0.UninitBranches);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 30,
   FQN="clang::UninitUse::operator=", NM="_ZN5clang9UninitUseaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseaSEOS0_")
  //</editor-fold>
  public /*inline*/ UninitUse /*&*/ $assignMove(final UninitUse /*&&*/$Prm0) {
    this.User = $Prm0.User;
    this.UninitAfterCall = $Prm0.UninitAfterCall;
    this.UninitAfterDecl = $Prm0.UninitAfterDecl;
    this.AlwaysUninit = $Prm0.AlwaysUninit;
    this.UninitBranches.$assignMove($Prm0.UninitBranches);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::UninitUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 30,
   FQN="clang::UninitUse::UninitUse", NM="_ZN5clang9UninitUseC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseC1ERKS0_")
  //</editor-fold>
  public /*inline*/ UninitUse(final /*const*/ UninitUse /*&*/ $Prm0) {
    // : User(.User), UninitAfterCall(.UninitAfterCall), UninitAfterDecl(.UninitAfterDecl), AlwaysUninit(.AlwaysUninit), UninitBranches(.UninitBranches) 
    //START JInit
    this.User = $Prm0.User;
    this.UninitAfterCall = $Prm0.UninitAfterCall;
    this.UninitAfterDecl = $Prm0.UninitAfterDecl;
    this.AlwaysUninit = $Prm0.AlwaysUninit;
    this.UninitBranches = new SmallVector<Branch>($Prm0.UninitBranches);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::UninitUse::~UninitUse">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/UninitializedValues.h", line = 30,
   FQN="clang::UninitUse::~UninitUse", NM="_ZN5clang9UninitUseD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang9UninitUseD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    UninitBranches.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public UninitUse(){}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "User=" + User // NOI18N
              + ", UninitAfterCall=" + UninitAfterCall // NOI18N
              + ", UninitAfterDecl=" + UninitAfterDecl // NOI18N
              + ", AlwaysUninit=" + AlwaysUninit // NOI18N
              + ", UninitBranches=" + UninitBranches; // NOI18N
  }
}
